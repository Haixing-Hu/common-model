////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.pair.KeyValuePairList;
import ltd.qubit.model.invoice.InvoiceStatus;
import ltd.qubit.model.organization.Organization;
import ltd.qubit.model.payment.Account;
import ltd.qubit.model.payment.PaymentChannel;
import ltd.qubit.model.payment.PaymentMode;
import ltd.qubit.model.product.ProductInfo;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.WithSource;

/**
 * 此模型表示每个客户对应的订单信息。
 *
 * @author 胡海星
 */
public class ClientOrder implements WithSource, Serializable {

  private static final long serialVersionUID = -3569506740993752427L;

  /**
   * 使用者信息。
   */
  private Client client;

  /**
   * 所属App信息。
   */
  private Info app;

  /**
   * 订单编号。
   */
  private Long orderId;

  /**
   * 订单的额外参数。
   */
  @Nullable
  private KeyValuePairList payload;

  /**
   * 订单项编号。
   */
  private Long orderItemId;

  /**
   * 退货记录编号。
   *
   * <p>若无退货记录则为{@code null}。
   */
  @Nullable
  private Long returnId;

  /**
   * 付款交易编号。
   */
  private Long payTransactionId;

  /**
   * 退款交易编号。
   */
  private Long refundTransactionId;

  /**
   * 订单状态。
   */
  private OrderStatus orderStatus;

  /**
   * 退货状态。
   */
  private ReturnStatus returnStatus;

  /**
   * 发票开具状态。
   */
  private InvoiceStatus invoiceStatus;

  /**
   * 商品。
   */
  private ProductInfo product;

  /**
   * 商品数量，必须大于等于0，保留四位小数。
   */
  private Integer count;

  /**
   * 应支付金额，必须大于0，保留四位小数。
   */
  @Money
  private BigDecimal payable;

  /**
   * 实际支付金额，必须大于等于0，保留4位小数。
   *
   * <p>支付金额 = 应付金额 - 支付折扣
   *
   * <p>如支付失败实付金额为0。
   */
  @Money
  private BigDecimal paid;

  /**
   * 应退款总金额，必须大于等于0，保留四位小数。
   *
   * <p>如无需退款则此字段为{@code null}。
   */
  @Money
  @Nullable
  private BigDecimal refundable;

  /**
   * 实际退款总金额，必须大于等于0，保留四位小数。
   *
   * <p>注意实际退款金额可能小于应退款金额，比如扣除信用卡手续费。
   *
   * <p>如尚未完成退款则此字段为{@code null}。
   */
  @Money
  @Nullable
  private BigDecimal refunded;

  /**
   * 订单提交时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant orderTime;

  /**
   * 付款时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant payTime;

  /**
   * 退款时间，若未退款则为{@code null}。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant refundTime;

  /**
   * 支付渠道。
   */
  private PaymentChannel payChannel;

  /**
   * 支付模式。
   */
  private PaymentMode payMode;

  /**
   * 支付交易流水号，由支付平台内部生成。
   */
  @Size(min = 1, max = 128)
  private String payNumber;

  /**
   * 支付渠道交易流水号，由第三方支付系统（支付宝、微信、银联、银行等）提供。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String payChannelNumber;

  /**
   * 退款渠道。
   */
  @Nullable
  private PaymentChannel refundChannel;

  /**
   * 退款模式。
   */
  @Nullable
  private PaymentMode refundMode;

  /**
   * 退款交易流水号，由支付平台内部生成。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String refundNumber;

  /**
   * 退款渠道交易流水号，由第三方支付系统（支付宝、微信、银联、银行等）提供。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String refundChannelNumber;

  @Nullable
  private Info source;

  @Nullable
  private Organization organization;

  @Nullable
  private Account account;

  public ClientOrder() {
    // empty
  }

  public Client getClient() {
    return client;
  }

  public void setClient(final Client client) {
    this.client = client;
  }

  public Info getApp() {
    return app;
  }

  public void setApp(final Info app) {
    this.app = app;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(final Long orderId) {
    this.orderId = orderId;
  }

  @Nullable
  public KeyValuePairList getPayload() {
    return payload;
  }

  public void setPayload(@Nullable final KeyValuePairList payload) {
    this.payload = payload;
  }

  public Long getOrderItemId() {
    return orderItemId;
  }

  public void setOrderItemId(final Long orderItemId) {
    this.orderItemId = orderItemId;
  }

  @Nullable
  public Long getReturnId() {
    return returnId;
  }

  public void setReturnId(@Nullable final Long returnId) {
    this.returnId = returnId;
  }

  public Long getPayTransactionId() {
    return payTransactionId;
  }

  public void setPayTransactionId(final Long payTransactionId) {
    this.payTransactionId = payTransactionId;
  }

  public Long getRefundTransactionId() {
    return refundTransactionId;
  }

  public void setRefundTransactionId(final Long refundTransactionId) {
    this.refundTransactionId = refundTransactionId;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(final OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  public ReturnStatus getReturnStatus() {
    return returnStatus;
  }

  public void setReturnStatus(final ReturnStatus returnStatus) {
    this.returnStatus = returnStatus;
  }

  public InvoiceStatus getInvoiceStatus() {
    return invoiceStatus;
  }

  public void setInvoiceStatus(final InvoiceStatus invoiceStatus) {
    this.invoiceStatus = invoiceStatus;
  }

  public ProductInfo getProduct() {
    return product;
  }

  public void setProduct(final ProductInfo product) {
    this.product = product;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(final Integer count) {
    this.count = count;
  }

  public BigDecimal getPayable() {
    return payable;
  }

  public void setPayable(final BigDecimal payable) {
    this.payable = payable;
  }

  public BigDecimal getPaid() {
    return paid;
  }

  public void setPaid(final BigDecimal paid) {
    this.paid = paid;
  }

  @Nullable
  public BigDecimal getRefundable() {
    return refundable;
  }

  public void setRefundable(@Nullable final BigDecimal refundable) {
    this.refundable = refundable;
  }

  @Nullable
  public BigDecimal getRefunded() {
    return refunded;
  }

  public void setRefunded(@Nullable final BigDecimal refunded) {
    this.refunded = refunded;
  }

  public Instant getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(final Instant orderTime) {
    this.orderTime = orderTime;
  }

  @Nullable
  public Instant getPayTime() {
    return payTime;
  }

  public void setPayTime(@Nullable final Instant payTime) {
    this.payTime = payTime;
  }

  @Nullable
  public Instant getRefundTime() {
    return refundTime;
  }

  public void setRefundTime(@Nullable final Instant refundTime) {
    this.refundTime = refundTime;
  }

  public PaymentChannel getPayChannel() {
    return payChannel;
  }

  public void setPayChannel(final PaymentChannel payChannel) {
    this.payChannel = payChannel;
  }

  public PaymentMode getPayMode() {
    return payMode;
  }

  public void setPayMode(final PaymentMode payMode) {
    this.payMode = payMode;
  }

  public String getPayNumber() {
    return payNumber;
  }

  public void setPayNumber(final String payNumber) {
    this.payNumber = payNumber;
  }

  @Nullable
  public String getPayChannelNumber() {
    return payChannelNumber;
  }

  public void setPayChannelNumber(@Nullable final String payChannelNumber) {
    this.payChannelNumber = payChannelNumber;
  }

  @Nullable
  public PaymentChannel getRefundChannel() {
    return refundChannel;
  }

  public void setRefundChannel(@Nullable final PaymentChannel refundChannel) {
    this.refundChannel = refundChannel;
  }

  @Nullable
  public PaymentMode getRefundMode() {
    return refundMode;
  }

  public void setRefundMode(@Nullable final PaymentMode refundMode) {
    this.refundMode = refundMode;
  }

  @Nullable
  public String getRefundNumber() {
    return refundNumber;
  }

  public void setRefundNumber(@Nullable final String refundNumber) {
    this.refundNumber = refundNumber;
  }

  @Nullable
  public String getRefundChannelNumber() {
    return refundChannelNumber;
  }

  public void setRefundChannelNumber(@Nullable final String refundChannelNumber) {
    this.refundChannelNumber = refundChannelNumber;
  }

  @Nullable
  public Info getSource() {
    return source;
  }

  public void setSource(@Nullable final Info source) {
    this.source = source;
  }

  @Nullable
  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(@Nullable final Organization organization) {
    this.organization = organization;
  }

  @Nullable
  public Account getAccount() {
    return account;
  }

  public void setAccount(@Nullable final Account account) {
    this.account = account;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final ClientOrder other = (ClientOrder) o;
    return Equality.equals(client, other.client)
        && Equality.equals(app, other.app)
        && Equality.equals(orderId, other.orderId)
        && Equality.equals(payload, other.payload)
        && Equality.equals(orderItemId, other.orderItemId)
        && Equality.equals(returnId, other.returnId)
        && Equality.equals(payTransactionId, other.payTransactionId)
        && Equality.equals(refundTransactionId, other.refundTransactionId)
        && Equality.equals(orderStatus, other.orderStatus)
        && Equality.equals(returnStatus, other.returnStatus)
        && Equality.equals(invoiceStatus, other.invoiceStatus)
        && Equality.equals(product, other.product)
        && Equality.equals(count, other.count)
        && Equality.equals(payable, other.payable)
        && Equality.equals(paid, other.paid)
        && Equality.equals(refundable, other.refundable)
        && Equality.equals(refunded, other.refunded)
        && Equality.equals(orderTime, other.orderTime)
        && Equality.equals(payTime, other.payTime)
        && Equality.equals(refundTime, other.refundTime)
        && Equality.equals(payChannel, other.payChannel)
        && Equality.equals(payMode, other.payMode)
        && Equality.equals(payNumber, other.payNumber)
        && Equality.equals(payChannelNumber, other.payChannelNumber)
        && Equality.equals(refundChannel, other.refundChannel)
        && Equality.equals(refundMode, other.refundMode)
        && Equality.equals(refundNumber, other.refundNumber)
        && Equality.equals(refundChannelNumber, other.refundChannelNumber)
        && Equality.equals(source, other.source)
        && Equality.equals(organization, other.organization)
        && Equality.equals(account, other.account);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, client);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, orderId);
    result = Hash.combine(result, multiplier, payload);
    result = Hash.combine(result, multiplier, orderItemId);
    result = Hash.combine(result, multiplier, returnId);
    result = Hash.combine(result, multiplier, payTransactionId);
    result = Hash.combine(result, multiplier, refundTransactionId);
    result = Hash.combine(result, multiplier, orderStatus);
    result = Hash.combine(result, multiplier, returnStatus);
    result = Hash.combine(result, multiplier, invoiceStatus);
    result = Hash.combine(result, multiplier, product);
    result = Hash.combine(result, multiplier, count);
    result = Hash.combine(result, multiplier, payable);
    result = Hash.combine(result, multiplier, paid);
    result = Hash.combine(result, multiplier, refundable);
    result = Hash.combine(result, multiplier, refunded);
    result = Hash.combine(result, multiplier, orderTime);
    result = Hash.combine(result, multiplier, payTime);
    result = Hash.combine(result, multiplier, refundTime);
    result = Hash.combine(result, multiplier, payChannel);
    result = Hash.combine(result, multiplier, payMode);
    result = Hash.combine(result, multiplier, payNumber);
    result = Hash.combine(result, multiplier, payChannelNumber);
    result = Hash.combine(result, multiplier, refundChannel);
    result = Hash.combine(result, multiplier, refundMode);
    result = Hash.combine(result, multiplier, refundNumber);
    result = Hash.combine(result, multiplier, refundChannelNumber);
    result = Hash.combine(result, multiplier, source);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, account);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("client", client)
        .append("app", app)
        .append("orderId", orderId)
        .append("payload", payload)
        .append("orderItemId", orderItemId)
        .append("returnId", returnId)
        .append("payTransactionId", payTransactionId)
        .append("refundTransactionId", refundTransactionId)
        .append("orderStatus", orderStatus)
        .append("returnStatus", returnStatus)
        .append("invoiceStatus", invoiceStatus)
        .append("product", product)
        .append("count", count)
        .append("payable", payable)
        .append("paid", paid)
        .append("refundable", refundable)
        .append("refunded", refunded)
        .append("orderTime", orderTime)
        .append("payTime", payTime)
        .append("refundTime", refundTime)
        .append("payChannel", payChannel)
        .append("payMode", payMode)
        .append("payNumber", payNumber)
        .append("payChannelNumber", payChannelNumber)
        .append("refundChannel", refundChannel)
        .append("refundMode", refundMode)
        .append("refundNumber", refundNumber)
        .append("refundChannelNumber", refundChannelNumber)
        .append("source", source)
        .append("organization", organization)
        .append("account", account)
        .toString();
  }
}
