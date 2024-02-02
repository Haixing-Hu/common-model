////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Computed;
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
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.invoice.InvoiceStatus;
import ltd.qubit.model.product.Product;
import ltd.qubit.model.product.ProductInfo;
import ltd.qubit.model.settlement.Transaction;
import ltd.qubit.model.system.Environment;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示退货单。
 *
 * @author 胡海星
 */
public class Return implements Identifiable, Auditable, Assignable<Return> {

  private static final long serialVersionUID = 4217296699189459052L;

  /**
   * 内部ID，全局唯一，亦作为退货单流水号。
   */
  @Identifier
  private Long id;

  /**
   * 所属订单的ID。
   */
  @Reference(entity = Order.class, property = "id")
  private Long orderId;

  /**
   * 所属订单项的ID。
   */
  @Reference(entity = OrderItem.class, property = "id")
  private Long orderItemId;

  /**
   * 所对应的退款交易记录的ID。
   */
  @Reference(entity = Transaction.class, property = "id")
  @Nullable
  private Long transactionId;

  /**
   * 退货发起方。
   */
  private ReturnIssuer issuer;

  /**
   * 所退换的货物。
   */
  @Reference(entity = Product.class, property = "info")
  private ProductInfo product;

  /**
   * 退货数量，必须大于等于0。
   */
  private Integer count;

  /**
   * 货币单位。
   */
  private Currency currency;

  /**
   * 应退款总金额，必须大于等于0，保留四位小数。
   *
   * <p>如无需退款则此字段为{@code null}.
   */
  @Money
  @Nullable
  private BigDecimal refundable;

  /**
   * 实际退款总金额，必须大于等于0，保留四位小数。
   *
   * <p>注意实际退款金额可能小于应退款金额，比如扣除信用卡手续费。
   *
   * <p>如尚未完成退款则此字段为{@code null}.
   */
  @Money
  @Nullable
  private BigDecimal refunded;

  /**
   * 退货单关联的顾客信息。
   *
   * <p>购买某些产品或服务时，例如保险、飞机票、船票等，需要提供产品或服务享用人
   * 的信息。
   */
  @Nullable
  private List<Client> clients;

  /**
   * 退货原因。
   */
  private ReturnReason reason;

  /**
   * 退货备注。
   */
  @Nullable
  private String comment;

  /**
   * 退货状态。
   */
  private ReturnStatus status;

  /**
   * 退货被商家拒绝的原因。
   */
  @Nullable
  private String rejectReason;

  /**
   * 退货物流记录ID。
   */
  @Nullable
  private Long shippingId;

  /**
   * 退货物流单单号。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String shippingNumber;

  /**
   * 发票开具状态。
   */
  private InvoiceStatus invoiceStatus;

  /**
   * 退货申请提交时客户端环境。
   */
  @Nullable
  private Environment environment;

  /**
   * 退货申请失效时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant expiredTime;

  /**
   * 退款时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant refundTime;

  /**
   * 退货发货时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant shipTime;

  /**
   * 退货流程完成时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant completeTime;

  /**
   * 退货申请放弃时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant cancelTime;

  /**
   * 此记录创建时间，即退货申请提交时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 此记录最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 此记录标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public Return() {
    // empty
  }

  public Return(final Long orderId, final Long orderItemId, final Client client) {
    this.orderId = orderId;
    this.orderItemId = orderItemId;
    this.issuer = ReturnIssuer.BUYER;
    this.count = 1;
    this.clients = (client != null ? Arrays.asList(client) : null);
  }

  public Return(final Return other) {
    assign(other);
  }

  @Override
  public void assign(final Return other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    orderId = other.orderId;
    orderItemId = other.orderItemId;
    transactionId = other.transactionId;
    issuer = other.issuer;
    product = Assignment.clone(other.product);
    count = other.count;
    currency = other.currency;
    refundable = other.refundable;
    refunded = other.refunded;
    clients = Assignment.deepClone(other.clients);
    reason = other.reason;
    comment = other.comment;
    status = other.status;
    rejectReason = other.rejectReason;
    shippingId = other.shippingId;
    shippingNumber = other.shippingNumber;
    invoiceStatus = other.invoiceStatus;
    environment = Assignment.clone(other.environment);
    expiredTime = other.expiredTime;
    refundTime = other.refundTime;
    shipTime = other.shipTime;
    completeTime = other.completeTime;
    cancelTime = other.cancelTime;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Return clone() {
    return new Return(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(final Long orderId) {
    this.orderId = orderId;
  }

  public Long getOrderItemId() {
    return orderItemId;
  }

  public void setOrderItemId(final Long orderItemId) {
    this.orderItemId = orderItemId;
  }

  @Nullable
  public Long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(@Nullable final Long transactionId) {
    this.transactionId = transactionId;
  }

  public ReturnIssuer getIssuer() {
    return issuer;
  }

  public void setIssuer(final ReturnIssuer issuer) {
    this.issuer = issuer;
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

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(final Currency currency) {
    this.currency = currency;
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

  @Nullable
  public List<Client> getClients() {
    return clients;
  }

  public void setClients(@Nullable final List<Client> clients) {
    this.clients = clients;
  }

  public ReturnReason getReason() {
    return reason;
  }

  public void setReason(final ReturnReason reason) {
    this.reason = reason;
  }

  @Nullable
  public String getComment() {
    return comment;
  }

  public void setComment(@Nullable final String comment) {
    this.comment = comment;
  }

  public ReturnStatus getStatus() {
    return status;
  }

  public void setStatus(final ReturnStatus status) {
    this.status = status;
    if (clients != null) {
      for (final Client client : clients) {
        client.setReturnStatus(status);
      }
    }
  }

  @Nullable
  public String getRejectReason() {
    return rejectReason;
  }

  public void setRejectReason(@Nullable final String rejectReason) {
    this.rejectReason = rejectReason;
  }

  @Nullable
  public Long getShippingId() {
    return shippingId;
  }

  public void setShippingId(@Nullable final Long shippingId) {
    this.shippingId = shippingId;
  }

  @Nullable
  public String getShippingNumber() {
    return shippingNumber;
  }

  public void setShippingNumber(@Nullable final String shippingNumber) {
    this.shippingNumber = shippingNumber;
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

  public Instant getExpiredTime() {
    return expiredTime;
  }

  public void setExpiredTime(final Instant expiredTime) {
    this.expiredTime = expiredTime;
  }

  @Nullable
  public Instant getRefundTime() {
    return refundTime;
  }

  public void setRefundTime(@Nullable final Instant refundTime) {
    this.refundTime = refundTime;
  }

  @Nullable
  public Instant getShipTime() {
    return shipTime;
  }

  public void setShipTime(@Nullable final Instant shipTime) {
    this.shipTime = shipTime;
  }

  @Nullable
  public Instant getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(@Nullable final Instant completeTime) {
    this.completeTime = completeTime;
  }

  @Nullable
  public Instant getCancelTime() {
    return cancelTime;
  }

  public void setCancelTime(@Nullable final Instant cancelTime) {
    this.cancelTime = cancelTime;
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

  /**
   * 检测此退款记录的产品数量是否正确。
   *
   * @return 若此退款记录的产品数量正确，则返回{@code true}；否则返回{@code false}。
   */
  @Computed({"count", "clients"})
  public final boolean isCountValid() {
    if (count == null || count <= 0) {
      return false;
    }
    if (clients != null && clients.size() > 0) {
      // 若有客户则客户数目应该等于产品数目
      return count == clients.size();
    }
    return true;
  }

  /**
   * 获取此退货记录的客户的ID列表。
   *
   * @return 此退货记录的客户的ID列表；若此退货记录没有客户，则返回一个空列表。
   */
  @Computed("clients")
  public Long[] getClientIds() {
    if (clients == null) {
      return new Long[0];
    } else {
      final Long[] result = new Long[clients.size()];
      int index = 0;
      for (final Client client : clients) {
        result[index++] = client.getId();
      }
      return result;
    }
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Return other = (Return) o;
    return Equality.equals(id, other.id)
        && Equality.equals(orderId, other.orderId)
        && Equality.equals(orderItemId, other.orderItemId)
        && Equality.equals(transactionId, other.transactionId)
        && Equality.equals(issuer, other.issuer)
        && Equality.equals(product, other.product)
        && Equality.equals(count, other.count)
        && Equality.equals(currency, other.currency)
        && Equality.equals(refundable, other.refundable)
        && Equality.equals(refunded, other.refunded)
        && Equality.equals(clients, other.clients)
        && Equality.equals(reason, other.reason)
        && Equality.equals(comment, other.comment)
        && Equality.equals(status, other.status)
        && Equality.equals(rejectReason, other.rejectReason)
        && Equality.equals(shippingId, other.shippingId)
        && Equality.equals(shippingNumber, other.shippingNumber)
        && Equality.equals(invoiceStatus, other.invoiceStatus)
        && Equality.equals(environment, other.environment)
        && Equality.equals(expiredTime, other.expiredTime)
        && Equality.equals(refundTime, other.refundTime)
        && Equality.equals(shipTime, other.shipTime)
        && Equality.equals(completeTime, other.completeTime)
        && Equality.equals(cancelTime, other.cancelTime)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, orderId);
    result = Hash.combine(result, multiplier, orderItemId);
    result = Hash.combine(result, multiplier, transactionId);
    result = Hash.combine(result, multiplier, issuer);
    result = Hash.combine(result, multiplier, product);
    result = Hash.combine(result, multiplier, count);
    result = Hash.combine(result, multiplier, currency);
    result = Hash.combine(result, multiplier, refundable);
    result = Hash.combine(result, multiplier, refunded);
    result = Hash.combine(result, multiplier, clients);
    result = Hash.combine(result, multiplier, reason);
    result = Hash.combine(result, multiplier, comment);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, rejectReason);
    result = Hash.combine(result, multiplier, shippingId);
    result = Hash.combine(result, multiplier, shippingNumber);
    result = Hash.combine(result, multiplier, invoiceStatus);
    result = Hash.combine(result, multiplier, environment);
    result = Hash.combine(result, multiplier, expiredTime);
    result = Hash.combine(result, multiplier, refundTime);
    result = Hash.combine(result, multiplier, shipTime);
    result = Hash.combine(result, multiplier, completeTime);
    result = Hash.combine(result, multiplier, cancelTime);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("orderId", orderId)
        .append("orderItemId", orderItemId)
        .append("transactionId", transactionId)
        .append("issuer", issuer)
        .append("product", product)
        .append("count", count)
        .append("currency", currency)
        .append("refundable", refundable)
        .append("refunded", refunded)
        .append("clients", clients)
        .append("reason", reason)
        .append("comment", comment)
        .append("status", status)
        .append("rejectReason", rejectReason)
        .append("shippingId", shippingId)
        .append("shippingNumber", shippingNumber)
        .append("invoiceStatus", invoiceStatus)
        .append("environment", environment)
        .append("expiredTime", expiredTime)
        .append("refundTime", refundTime)
        .append("shipTime", shipTime)
        .append("completeTime", completeTime)
        .append("cancelTime", cancelTime)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
