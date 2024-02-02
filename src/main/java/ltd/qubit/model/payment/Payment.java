////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.error.ErrorInfo;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.order.Order;
import ltd.qubit.model.settlement.Transaction;
import ltd.qubit.model.system.Environment;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.Normalizable;

import static java.math.BigDecimal.ZERO;

import static ltd.qubit.commons.lang.BigDecimalUtils.normalizeMoney;
import static ltd.qubit.commons.lang.BooleanUtils.isTrue;
import static ltd.qubit.commons.lang.InstantUtils.truncatedToSecond;
import static ltd.qubit.commons.lang.ObjectUtils.defaultIfNull;

/**
 * 此模型表示支付信息。
 *
 * @author 胡海星
 */
public class Payment implements Identifiable, Auditable, Normalizable,
    Assignable<Payment> {

  private static final long serialVersionUID = -7335649111866196183L;

  public static final String UNKNOWN_NUMBER = "UNKNOWN";

  public static final String UNKNOWN_CHANNEL_NUMBER = null;

  /**
   * 内部ID，全局唯一，亦作为内部流水号。
   */
  @Identifier
  private Long id;

  /**
   * 类型：付款或退款。
   */
  private PaymentType type;

  /**
   * 所属的订单的ID。
   */
  @Reference(entity = Order.class, property = "id")
  private Long orderId;

  /**
   * 所属的交易的ID。
   */
  @Reference(entity = Transaction.class, property = "id")
  private Long transactionId;

  /**
   * 支付系统供应商的App的基本信息。
   */
  private Info providerApp;

  /**
   * 支付渠道。
   */
  private PaymentChannel channel;

  /**
   * 支付模式。
   */
  private PaymentMode mode;

  /**
   * 支付交易流水号，由支付平台内部生成。
   */
  @Size(min = 1, max = 128)
  private String number;

  /**
   * 支付渠道交易流水号，由第三方支付系统（支付宝、微信、银联、银行等）提供。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String channelNumber;

  /**
   * 第三方支付的回复。
   */
  private String channelReply;

  /**
   * 货币单位。
   */
  private Currency currency;

  /**
   * 应支付总金额，必须大于等于0，保留4位小数。
   */
  @Money
  private BigDecimal payable;

  /**
   * 支付折扣，必须大于等于0，保留4位小数。
   */
  @Money
  @Nullable
  private BigDecimal discount;

  /**
   * 实付金额，必须大于等于0，保留4位小数。
   *
   * <p>实付金额 = 应支付总金额 - 支付折扣
   *
   * <p>如支付失败实付金额为0。
   */
  @Money
  private BigDecimal paid;

  /**
   * 支付手续费，必须大于等于0，保留四位小数。
   *
   * <p>此手续费是指付款者需要支付的手续费。
   */
  @Money
  @Nullable
  private BigDecimal cost;

  /**
   * 支付发生时客户端环境。
   */
  @Nullable
  private Environment environment;

  /**
   * 支付是否成功。
   */
  private Boolean success;

  /**
   * 支付失败时的错误信息。
   */
  @Nullable
  private ErrorInfo error;

  /**
   * 支付发起时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 支付完成时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant completeTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant modifyTime;

  /**
   * 标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public Payment() {
    // empty
  }

  public Payment(final Payment other) {
    assign(other);
  }

  public Payment(final Transaction transaction,
      @Nullable final Transaction origin, final Clock clock) {
    orderId = transaction.getOrderId();
    transactionId = transaction.getId();
    currency = transaction.getCurrency();
    payable = defaultIfNull(transaction.getPayable(), ZERO);
    discount = defaultIfNull(transaction.getDiscount(), ZERO);
    cost = ZERO;
    success = true;
    createTime = clock.instant();
    completeTime = clock.instant();
    number = UNKNOWN_NUMBER;
    channelNumber = UNKNOWN_CHANNEL_NUMBER;
    if (transaction.getType() == null) {
      type = null;
    } else {
      switch (transaction.getType()) {
        case BUY:
          type = PaymentType.PAY;
          channel = PaymentChannel.UNKNOWN;
          mode = PaymentMode.UNKNOWN;
          break;
        case REFUND: {
          type = PaymentType.REFUND;
          if (origin != null && origin.getPayment() != null) {
            // 应该按照付款时支付记录的原路退款
            final Payment originPayment = origin.getPayment();
            channel = originPayment.getChannel();
            mode = originPayment.getMode();
          } else {
            channel = PaymentChannel.UNKNOWN;
            mode = PaymentMode.UNKNOWN;
          }
          break;
        }
        default:
          throw new IllegalArgumentException("Unsupported transaction type: "
              + transaction.getType());
      }
    }
    // 计算实付金额
    calculatePaid();
  }

  @Override
  public void assign(final Payment other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    type = other.type;
    orderId = other.orderId;
    transactionId = other.transactionId;
    providerApp = Assignment.clone(other.providerApp);
    channel = other.channel;
    mode = other.mode;
    number = other.number;
    channelNumber = other.channelNumber;
    channelReply = other.channelReply;
    currency = other.currency;
    payable = other.payable;
    discount = other.discount;
    paid = other.paid;
    cost = other.cost;
    environment = Assignment.clone(other.environment);
    success = other.success;
    error = Assignment.clone(other.error);
    createTime = other.createTime;
    completeTime = other.completeTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Payment clone() {
    return new Payment(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public PaymentType getType() {
    return type;
  }

  public void setType(final PaymentType type) {
    this.type = type;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(final Long orderId) {
    this.orderId = orderId;
  }

  public Long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(final Long transactionId) {
    this.transactionId = transactionId;
  }

  public Info getProviderApp() {
    return providerApp;
  }

  public void setProviderApp(final Info providerApp) {
    this.providerApp = providerApp;
  }

  public PaymentChannel getChannel() {
    return channel;
  }

  public void setChannel(final PaymentChannel channel) {
    this.channel = channel;
  }

  public PaymentMode getMode() {
    return mode;
  }

  public void setMode(final PaymentMode mode) {
    this.mode = mode;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  @Nullable
  public String getChannelNumber() {
    return channelNumber;
  }

  public void setChannelNumber(@Nullable final String channelNumber) {
    this.channelNumber = channelNumber;
  }

  public String getChannelReply() {
    return channelReply;
  }

  public void setChannelReply(final String channelReply) {
    this.channelReply = channelReply;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(final Currency currency) {
    this.currency = currency;
  }

  public BigDecimal getPayable() {
    return payable;
  }

  public void setPayable(final BigDecimal payable) {
    this.payable = payable;
  }

  @Nullable
  public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(@Nullable final BigDecimal discount) {
    this.discount = discount;
  }

  public BigDecimal getPaid() {
    return paid;
  }

  public void setPaid(final BigDecimal paid) {
    this.paid = paid;
  }

  @Nullable
  public BigDecimal getCost() {
    return cost;
  }

  public void setCost(@Nullable final BigDecimal cost) {
    this.cost = cost;
  }

  @Nullable
  public Environment getEnvironment() {
    return environment;
  }

  public void setEnvironment(@Nullable final Environment environment) {
    this.environment = environment;
  }

  public Boolean isSuccess() {
    return success;
  }

  public void setSuccess(final Boolean success) {
    this.success = success;
  }

  @Nullable
  public ErrorInfo getError() {
    return error;
  }

  public void setError(@Nullable final ErrorInfo error) {
    this.error = error;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  public Instant getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(final Instant completeTime) {
    this.completeTime = completeTime;
  }

  public Instant getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(final Instant modifyTime) {
    this.modifyTime = modifyTime;
  }

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  @Override
  public void normalize() {
    payable = normalizeMoney(payable);
    discount = normalizeMoney(discount);
    paid = normalizeMoney(paid);
    cost = normalizeMoney(cost);
    if (environment != null) {
      environment.normalize();
    }
    createTime = truncatedToSecond(createTime);
    modifyTime = truncatedToSecond(modifyTime);
    deleteTime = truncatedToSecond(deleteTime);
    completeTime = truncatedToSecond(completeTime);
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Payment other = (Payment) o;
    return Equality.equals(id, other.id)
        && Equality.equals(type, other.type)
        && Equality.equals(orderId, other.orderId)
        && Equality.equals(transactionId, other.transactionId)
        && Equality.equals(providerApp, other.providerApp)
        && Equality.equals(channel, other.channel)
        && Equality.equals(mode, other.mode)
        && Equality.equals(number, other.number)
        && Equality.equals(channelNumber, other.channelNumber)
        && Equality.equals(channelReply, other.channelReply)
        && Equality.equals(currency, other.currency)
        && Equality.equals(payable, other.payable)
        && Equality.equals(discount, other.discount)
        && Equality.equals(paid, other.paid)
        && Equality.equals(cost, other.cost)
        && Equality.equals(environment, other.environment)
        && Equality.equals(success, other.success)
        && Equality.equals(error, other.error)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(completeTime, other.completeTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, type);
    result = Hash.combine(result, multiplier, orderId);
    result = Hash.combine(result, multiplier, transactionId);
    result = Hash.combine(result, multiplier, providerApp);
    result = Hash.combine(result, multiplier, channel);
    result = Hash.combine(result, multiplier, mode);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, channelNumber);
    result = Hash.combine(result, multiplier, channelReply);
    result = Hash.combine(result, multiplier, currency);
    result = Hash.combine(result, multiplier, payable);
    result = Hash.combine(result, multiplier, discount);
    result = Hash.combine(result, multiplier, paid);
    result = Hash.combine(result, multiplier, cost);
    result = Hash.combine(result, multiplier, environment);
    result = Hash.combine(result, multiplier, success);
    result = Hash.combine(result, multiplier, error);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, completeTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("type", type)
        .append("orderId", orderId)
        .append("transactionId", transactionId)
        .append("providerApp", providerApp)
        .append("channel", channel)
        .append("mode", mode)
        .append("number", number)
        .append("channelNumber", channelNumber)
        .append("channelReply", channelReply)
        .append("currency", currency)
        .append("payable", payable)
        .append("discount", discount)
        .append("paid", paid)
        .append("cost", cost)
        .append("environment", environment)
        .append("success", success)
        .append("error", error)
        .append("createTime", createTime)
        .append("completeTime", completeTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }

  public final boolean match(final Transaction tx) {
    return (orderId != null)
          && (orderId.equals(tx.getOrderId()))
          && (transactionId != null)
          && transactionId.equals(tx.getId())
          && (type != null)
          && type.match(tx.getType())
          && (currency == tx.getCurrency())
          && (payable != null)
          && (payable.compareTo(tx.getPayable()) == 0);
  }

  public final boolean isMoneyValid() {
    if (currency == null || payable == null
        || paid == null || success == null) {
      // 非空字段不能为空
      return false;
    }
    final BigDecimal theDiscount = defaultIfNull(discount, ZERO);
    final BigDecimal theCost = defaultIfNull(cost, ZERO);
    if (payable.signum() < 0
            || theDiscount.signum() < 0
            || theCost.signum() < 0
            || paid.signum() < 0) {
      // 所有金额不能为负数
      return false;
    }
    if (theDiscount.compareTo(payable) > 0) {
      // 折扣不能大于应付金额
      return false;
    }
    if (success) {
      return (paid.compareTo(payable.subtract(theDiscount).add(theCost)) == 0);
    } else {        // 若支付失败，已支付金额可以小于应支付金额
      return (paid.compareTo(payable.subtract(theDiscount).add(theCost)) <= 0);
    }
  }

  public Payment calculatePaid() {
    if (isTrue(success)) {
      paid = defaultIfNull(payable, ZERO)
              .subtract(defaultIfNull(discount, ZERO))
              .add(defaultIfNull(cost, ZERO));
    } else {
      paid = ZERO;
    }
    return this;
  }
}
