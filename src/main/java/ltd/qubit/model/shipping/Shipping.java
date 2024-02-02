////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.shipping;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.organization.Organization;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示物流记录。
 *
 * @author 胡海星
 */
public class Shipping implements Identifiable, Auditable, Assignable<Shipping> {

  private static final long serialVersionUID = 7523739629298634510L;

  /**
   * 内部ID，全局唯一，亦作为退货单流水号。
   */
  @Identifier
  private Long id;

  /**
   * 物流公司。
   */
  @Reference(entity = Organization.class, property = "info")
  private Info organization;

  /**
   * 物流单号。
   */
  private String number;

  /**
   * 发货时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant shipTime;

  /**
   * 发货人信息。
   */
  private ConsignInfo consignor;

  /**
   * 收货人信息。
   */
  private ConsignInfo consignee;

  /**
   * 此记录创建时间。
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

  public Shipping() {
    // empty
  }

  public Shipping(final Shipping other) {
    assign(other);
  }

  @Override
  public void assign(final Shipping other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    organization = Assignment.clone(other.organization);
    number = other.number;
    shipTime = other.shipTime;
    consignor = Assignment.clone(other.consignor);
    consignee = Assignment.clone(other.consignee);
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Shipping clone() {
    return new Shipping(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Info getOrganization() {
    return organization;
  }

  public void setOrganization(final Info organization) {
    this.organization = organization;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public Instant getShipTime() {
    return shipTime;
  }

  public void setShipTime(final Instant shipTime) {
    this.shipTime = shipTime;
  }

  public ConsignInfo getConsignor() {
    return consignor;
  }

  public void setConsignor(final ConsignInfo consignor) {
    this.consignor = consignor;
  }

  public ConsignInfo getConsignee() {
    return consignee;
  }

  public void setConsignee(final ConsignInfo consignee) {
    this.consignee = consignee;
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
    final Shipping other = (Shipping) o;
    return Equality.equals(id, other.id)
        && Equality.equals(organization, other.organization)
        && Equality.equals(number, other.number)
        && Equality.equals(shipTime, other.shipTime)
        && Equality.equals(consignor, other.consignor)
        && Equality.equals(consignee, other.consignee)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, shipTime);
    result = Hash.combine(result, multiplier, consignor);
    result = Hash.combine(result, multiplier, consignee);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("organization", organization)
        .append("number", number)
        .append("shipTime", shipTime)
        .append("consignor", consignor)
        .append("consignee", consignee)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
