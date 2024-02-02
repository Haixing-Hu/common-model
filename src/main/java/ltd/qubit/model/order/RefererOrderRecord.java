////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.product.Product;
import ltd.qubit.model.product.ProductItem;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示推广人员的订单推广记录。
 *
 * @author 潘凯
 */
public class RefererOrderRecord implements Identifiable, Auditable,
    Assignable<RefererOrderRecord> {

  private static final long serialVersionUID = 7672395963404984229L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 推广渠道类型。
   */
  private OpenidType openidType;

  /**
   * 推广渠道的唯一标识ID。
   */
  @Size(min = 1, max = 128)
  private String openid;

  /**
   * 根推广渠道类型。
   */
  private OpenidType rootOpenidType;

  /**
   * 根推广渠道的唯一标识ID。
   */
  @Size(min = 1, max = 128)
  private String rootOpenid;

  /**
   * 从根渠道算起的第几级渠道。
   */
  private Integer rootLevel;

  /**
   * 订单ID。
   */
  @Reference(entity = Order.class, property = "id")
  private Long orderId;

  /**
   * 订单项ID。
   */
  @Reference(entity = OrderItem.class, property = "id")
  private Long orderItemId;

  /**
   * 客户ID。
   */
  @Reference(entity = Client.class, property = "id")
  private Long clientId;

  /**
   * 产品编码。
   */
  @Reference(entity = Product.class, property = "code")
  private String productCode;

  /**
   * 产品项ID。
   */
  @Reference(entity = ProductItem.class, property = "id")
  private Long productItemId;

  /**
   * 推广状态。
   */
  private RefererOrderRecordStatus status;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public RefererOrderRecord() {
    // empty
  }

  public RefererOrderRecord(final RefererOrderRecord other) {
    assign(other);
  }

  @Override
  public void assign(final RefererOrderRecord other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    openidType = other.openidType;
    openid = other.openid;
    rootOpenidType = other.rootOpenidType;
    rootOpenid = other.rootOpenid;
    rootLevel = other.rootLevel;
    orderId = other.orderId;
    orderItemId = other.orderItemId;
    clientId = other.clientId;
    productCode = other.productCode;
    productItemId = other.productItemId;
    status = other.status;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public RefererOrderRecord clone() {
    return new RefererOrderRecord(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public OpenidType getOpenidType() {
    return openidType;
  }

  public void setOpenidType(final OpenidType openidType) {
    this.openidType = openidType;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(final String openid) {
    this.openid = openid;
  }

  public OpenidType getRootOpenidType() {
    return rootOpenidType;
  }

  public void setRootOpenidType(final OpenidType rootOpenidType) {
    this.rootOpenidType = rootOpenidType;
  }

  public String getRootOpenid() {
    return rootOpenid;
  }

  public void setRootOpenid(final String rootOpenid) {
    this.rootOpenid = rootOpenid;
  }

  public Integer getRootLevel() {
    return rootLevel;
  }

  public void setRootLevel(final Integer rootLevel) {
    this.rootLevel = rootLevel;
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

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(final Long clientId) {
    this.clientId = clientId;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(final String productCode) {
    this.productCode = productCode;
  }

  public Long getProductItemId() {
    return productItemId;
  }

  public void setProductItemId(final Long productItemId) {
    this.productItemId = productItemId;
  }

  public RefererOrderRecordStatus getStatus() {
    return status;
  }

  public void setStatus(final RefererOrderRecordStatus status) {
    this.status = status;
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
    final RefererOrderRecord other = (RefererOrderRecord) o;
    return Equality.equals(id, other.id)
        && Equality.equals(openidType, other.openidType)
        && Equality.equals(openid, other.openid)
        && Equality.equals(rootOpenidType, other.rootOpenidType)
        && Equality.equals(rootOpenid, other.rootOpenid)
        && Equality.equals(rootLevel, other.rootLevel)
        && Equality.equals(orderId, other.orderId)
        && Equality.equals(orderItemId, other.orderItemId)
        && Equality.equals(clientId, other.clientId)
        && Equality.equals(productCode, other.productCode)
        && Equality.equals(productItemId, other.productItemId)
        && Equality.equals(status, other.status)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, openidType);
    result = Hash.combine(result, multiplier, openid);
    result = Hash.combine(result, multiplier, rootOpenidType);
    result = Hash.combine(result, multiplier, rootOpenid);
    result = Hash.combine(result, multiplier, rootLevel);
    result = Hash.combine(result, multiplier, orderId);
    result = Hash.combine(result, multiplier, orderItemId);
    result = Hash.combine(result, multiplier, clientId);
    result = Hash.combine(result, multiplier, productCode);
    result = Hash.combine(result, multiplier, productItemId);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("openidType", openidType)
        .append("openid", openid)
        .append("rootOpenidType", rootOpenidType)
        .append("rootOpenid", rootOpenid)
        .append("rootLevel", rootLevel)
        .append("orderId", orderId)
        .append("orderItemId", orderItemId)
        .append("clientId", clientId)
        .append("productCode", productCode)
        .append("productItemId", productItemId)
        .append("status", status)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
