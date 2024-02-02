////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.settlement;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.commons.Category;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.commons.Source;
import ltd.qubit.model.invoice.InvoiceStatus;
import ltd.qubit.model.order.Order;
import ltd.qubit.model.order.OrderInfo;
import ltd.qubit.model.order.Return;
import ltd.qubit.model.order.ReturnIssuer;
import ltd.qubit.model.payment.Participant;
import ltd.qubit.model.payment.Payment;
import ltd.qubit.model.system.Environment;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.InfoWithEntity;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;
import ltd.qubit.model.util.WithCategory;
import ltd.qubit.model.util.WithSource;

/**
 * 此模型表示交易记录。
 *
 * @author 胡海星
 */
public class Transaction implements Identifiable, WithApp, WithSource,
    WithCategory, Auditable, Assignable<Transaction> {

  private static final long serialVersionUID = 3005124732186830131L;

  /**
   * 内部ID，全局唯一，亦作为内部流水号。
   */
  @Identifier
  private Long id;

  /**
   * 交易类型：购买、退款等。
   */
  private TransactionType type;

  /**
   * 退款易所对应的原始付款交易记录的ID。
   *
   * <p>若此交易不是退款交易则此字段为{@code null}。
   */
  @Reference(entity = Transaction.class, property = "id")
  @Nullable
  private Long originId;

  /**
   * 交易状态。
   */
  private TransactionStatus status;

  /**
   * 发起交易的App的基本信息。
   */
  @Reference(entity = App.class, property = "info")
  private StatefulInfo app;

  /**
   * 交易发起的来源的基本信息。
   */
  @Reference(entity = Source.class, property = "info")
  @Nullable
  private Info source;

  /**
   * 订单所属类别的基本信息。
   */
  @Reference(entity = Category.class, property = "info")
  @Nullable
  private InfoWithEntity category;

  /**
   * 订单ID。
   */
  @Reference(entity = Order.class, property = "id")
  private Long orderId;

  /**
   * 退货记录ID。
   */
  @Reference(entity = Return.class, property = "id")
  @Nullable
  private Long returnId;

  /**
   * 退货发起方。
   */
  @Nullable
  private ReturnIssuer returnIssuer;

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
  private BigDecimal discount;

  /**
   * 实付金额，必须大于等于0，保留4位小数。
   *
   * <p>实付金额 = 应付金额 - 支付折扣
   *
   * <p>如支付失败实付金额为0。
   */
  @Money
  private BigDecimal paid;

  /**
   * 收款方信息。
   */
  private Participant payee;

  /**
   * 付款方信息。
   */
  private Participant payer;

  /**
   * 支付信息。
   */
  @Nullable
  private Payment payment;

  /**
   * 此交易的失效时间，在此时间内未完成支付则此交易失效。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant expiredTime;

  /**
   * 此交易的完成时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant completeTime;

  /**
   * 此交易的发票开具状态。
   */
  private InvoiceStatus invoiceStatus;

  /**
   * 交易发生时客户端环境。
   */
  @Nullable
  private Environment environment;

  /**
   * 交易备注。
   */
  @Nullable
  private String comment;

  /**
   * 此记录的创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 此记录的最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 此记录的标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public Transaction() {
    // empty
  }

  public Transaction(final Transaction other) {
    assign(other);
  }

  /**
   * 根据订单记录创建一条购买交易记录。
   *
   * @param order
   *     订单记录
   */
  public Transaction(final Order order) {
    assign(order);
  }

  /**
   * 根据退货记录创建一条退款交易记录。
   *
   * @param ret
   *     退货记录
   * @param order
   *     该退货记录对应的订单
   */
  public Transaction(final Return ret, final OrderInfo order) {
    assign(ret, order);
  }

  @Override
  public void assign(final Transaction other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    type = other.type;
    originId = other.originId;
    status = other.status;
    app = Assignment.clone(other.app);
    source = Assignment.clone(other.source);
    category = Assignment.clone(other.category);
    orderId = other.orderId;
    returnId = other.returnId;
    returnIssuer = other.returnIssuer;
    currency = other.currency;
    payable = other.payable;
    discount = other.discount;
    paid = other.paid;
    payee = Assignment.clone(other.payee);
    payer = Assignment.clone(other.payer);
    payment = Assignment.clone(other.payment);
    expiredTime = other.expiredTime;
    completeTime = other.completeTime;
    invoiceStatus = other.invoiceStatus;
    environment = Assignment.clone(other.environment);
    comment = other.comment;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  public void assign(final Order order) {
    this.type = TransactionType.BUY;
    this.status = TransactionStatus.SUBMITTED;
    this.app = Assignment.clone(order.getApp());
    this.source = Assignment.clone(order.getSource());    // FIXME?
    this.category = Assignment.clone(order.getCategory()); // FIXME?
    this.orderId = order.getId();
    this.currency = order.getCurrency();
    this.payable = order.getPayable();
    this.paid = BigDecimal.ZERO;      // not paid yet
    if (order.getSeller() != null) {
      this.payee = new Participant(order.getSeller());
      // TODO: 设置收款者收款账号
    }
    if (order.getBuyer() != null) {
      this.payer = new Participant(order.getBuyer());
      // TODO: 设置付款者付款账号
    }
    this.expiredTime = order.getExpiredTime();     // FIXME
    this.invoiceStatus = order.getInvoiceStatus(); // FIXME
    this.environment = Assignment.clone(order.getEnvironment()); // FIXME
  }

  public void assign(final Return ret, final OrderInfo order) {
    this.type = TransactionType.REFUND;
    this.status = TransactionStatus.SUBMITTED;
    this.app = Assignment.clone(order.getApp());
    this.source = Assignment.clone(order.getSource());     // FIXME?
    this.category = Assignment.clone(order.getCategory()); // FIXME?
    this.orderId = ret.getOrderId();
    this.returnId = ret.getId();
    this.returnIssuer = ret.getIssuer();
    this.currency = ret.getCurrency();
    this.payable = ret.getRefundable();
    this.paid = BigDecimal.ZERO;
    // 注意对于退款交易，订单的购买者是收款方，销售商是支付方
    if (order.getBuyer() != null) {
      this.payee = new Participant(order.getBuyer());
      // TODO: 设置收款者收款账号
    }
    if (order.getSeller() != null) {
      this.payer = new Participant(order.getSeller());
      // TODO: 设置付款者付款账号
    }
    this.expiredTime = ret.getExpiredTime();     // FIXME
    this.invoiceStatus = ret.getInvoiceStatus(); // FIXME
    this.environment = Assignment.clone(ret.getEnvironment()); // FIXME
  }

  @Override
  public Transaction clone() {
    return new Transaction(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public TransactionType getType() {
    return type;
  }

  public void setType(final TransactionType type) {
    this.type = type;
  }

  @Nullable
  public Long getOriginId() {
    return originId;
  }

  public void setOriginId(@Nullable final Long originId) {
    this.originId = originId;
  }

  public TransactionStatus getStatus() {
    return status;
  }

  public void setStatus(final TransactionStatus status) {
    this.status = status;
  }

  public StatefulInfo getApp() {
    return app;
  }

  public void setApp(final StatefulInfo app) {
    this.app = app;
  }

  @Nullable
  public Info getSource() {
    return source;
  }

  public void setSource(@Nullable final Info source) {
    this.source = source;
  }

  @Nullable
  public InfoWithEntity getCategory() {
    return category;
  }

  public void setCategory(@Nullable final InfoWithEntity category) {
    this.category = category;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(final Long orderId) {
    this.orderId = orderId;
  }

  @Nullable
  public Long getReturnId() {
    return returnId;
  }

  public void setReturnId(@Nullable final Long returnId) {
    this.returnId = returnId;
  }

  @Nullable
  public ReturnIssuer getReturnIssuer() {
    return returnIssuer;
  }

  public void setReturnIssuer(@Nullable final ReturnIssuer returnIssuer) {
    this.returnIssuer = returnIssuer;
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

  public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(final BigDecimal discount) {
    this.discount = discount;
  }

  public BigDecimal getPaid() {
    return paid;
  }

  public void setPaid(final BigDecimal paid) {
    this.paid = paid;
  }

  public Participant getPayee() {
    return payee;
  }

  public void setPayee(final Participant payee) {
    this.payee = payee;
  }

  public Participant getPayer() {
    return payer;
  }

  public void setPayer(final Participant payer) {
    this.payer = payer;
  }

  @Nullable
  public Payment getPayment() {
    return payment;
  }

  public void setPayment(@Nullable final Payment payment) {
    this.payment = payment;
  }

  public Instant getExpiredTime() {
    return expiredTime;
  }

  public void setExpiredTime(final Instant expiredTime) {
    this.expiredTime = expiredTime;
  }

  @Nullable
  public Instant getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(@Nullable final Instant completeTime) {
    this.completeTime = completeTime;
  }

  public InvoiceStatus getInvoiceStatus() {
    return invoiceStatus;
  }

  public void setInvoiceStatus(final InvoiceStatus invoiceStatus) {
    this.invoiceStatus = invoiceStatus;
  }

  @Nullable
  public Environment getEnvironment() {
    return environment;
  }

  public void setEnvironment(@Nullable final Environment environment) {
    this.environment = environment;
  }

  @Nullable
  public String getComment() {
    return comment;
  }

  public void setComment(@Nullable final String comment) {
    this.comment = comment;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  @Nullable
  public Instant getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(@Nullable final Instant modifyTime) {
    this.modifyTime = modifyTime;
  }

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Transaction other = (Transaction) o;
    return Equality.equals(id, other.id)
        && Equality.equals(type, other.type)
        && Equality.equals(originId, other.originId)
        && Equality.equals(status, other.status)
        && Equality.equals(app, other.app)
        && Equality.equals(source, other.source)
        && Equality.equals(category, other.category)
        && Equality.equals(orderId, other.orderId)
        && Equality.equals(returnId, other.returnId)
        && Equality.equals(returnIssuer, other.returnIssuer)
        && Equality.equals(currency, other.currency)
        && Equality.equals(payable, other.payable)
        && Equality.equals(discount, other.discount)
        && Equality.equals(paid, other.paid)
        && Equality.equals(payee, other.payee)
        && Equality.equals(payer, other.payer)
        && Equality.equals(payment, other.payment)
        && Equality.equals(expiredTime, other.expiredTime)
        && Equality.equals(completeTime, other.completeTime)
        && Equality.equals(invoiceStatus, other.invoiceStatus)
        && Equality.equals(environment, other.environment)
        && Equality.equals(comment, other.comment)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, type);
    result = Hash.combine(result, multiplier, originId);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, source);
    result = Hash.combine(result, multiplier, category);
    result = Hash.combine(result, multiplier, orderId);
    result = Hash.combine(result, multiplier, returnId);
    result = Hash.combine(result, multiplier, returnIssuer);
    result = Hash.combine(result, multiplier, currency);
    result = Hash.combine(result, multiplier, payable);
    result = Hash.combine(result, multiplier, discount);
    result = Hash.combine(result, multiplier, paid);
    result = Hash.combine(result, multiplier, payee);
    result = Hash.combine(result, multiplier, payer);
    result = Hash.combine(result, multiplier, payment);
    result = Hash.combine(result, multiplier, expiredTime);
    result = Hash.combine(result, multiplier, completeTime);
    result = Hash.combine(result, multiplier, invoiceStatus);
    result = Hash.combine(result, multiplier, environment);
    result = Hash.combine(result, multiplier, comment);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("type", type)
        .append("originId", originId)
        .append("status", status)
        .append("app", app)
        .append("source", source)
        .append("category", category)
        .append("orderId", orderId)
        .append("returnId", returnId)
        .append("returnIssuer", returnIssuer)
        .append("currency", currency)
        .append("payable", payable)
        .append("discount", discount)
        .append("paid", paid)
        .append("payee", payee)
        .append("payer", payer)
        .append("payment", payment)
        .append("expiredTime", expiredTime)
        .append("completeTime", completeTime)
        .append("invoiceStatus", invoiceStatus)
        .append("environment", environment)
        .append("comment", comment)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
