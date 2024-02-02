////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim.enterprise;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Creatable;
import ltd.qubit.model.util.Deletable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示企业保险乙类自理明细。
 *
 * @author 潘凯
 */
public class EnterpriseClaimSelfCareItem implements Identifiable, Creatable,
    Deletable, Assignable<EnterpriseClaimSelfCareItem> {

  private static final long serialVersionUID = -394464215742752275L;

  /**
   * 内部ID，全局唯一，亦作为理赔流水号。
   */
  @Identifier
  private Long id;

  /**
   * 理赔发票ID。
   */
  private Long claimInvoiceId;

  /**
   * 项目名称。
   */
  private String name;

  /**
   * 医保收费编码。
   */
  private String medicareChargeCode;

  /**
   * 金额。
   */
  @Money
  private BigDecimal amount = BigDecimal.ZERO;

  /**
   * 比例。
   */
  private Double ratio;

  /**
   * 创建时间，即提交时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public EnterpriseClaimSelfCareItem() {
    // empty
  }

  public EnterpriseClaimSelfCareItem(final EnterpriseClaimSelfCareItem other) {
    assign(other);
  }

  @Override
  public void assign(final EnterpriseClaimSelfCareItem other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    claimInvoiceId = other.claimInvoiceId;
    name = other.name;
    medicareChargeCode = other.medicareChargeCode;
    amount = other.amount;
    ratio = other.ratio;
    createTime = other.createTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public EnterpriseClaimSelfCareItem clone() {
    return new EnterpriseClaimSelfCareItem(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getClaimInvoiceId() {
    return claimInvoiceId;
  }

  public void setClaimInvoiceId(final Long claimInvoiceId) {
    this.claimInvoiceId = claimInvoiceId;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getMedicareChargeCode() {
    return medicareChargeCode;
  }

  public void setMedicareChargeCode(final String medicareChargeCode) {
    this.medicareChargeCode = medicareChargeCode;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
  }

  public Double getRatio() {
    return ratio;
  }

  public void setRatio(final Double ratio) {
    this.ratio = ratio;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final EnterpriseClaimSelfCareItem other = (EnterpriseClaimSelfCareItem) o;
    return Equality.equals(id, other.id)
        && Equality.equals(claimInvoiceId, other.claimInvoiceId)
        && Equality.equals(name, other.name)
        && Equality.equals(medicareChargeCode, other.medicareChargeCode)
        && Equality.equals(amount, other.amount)
        && Equality.equals(ratio, other.ratio)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, claimInvoiceId);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, medicareChargeCode);
    result = Hash.combine(result, multiplier, amount);
    result = Hash.combine(result, multiplier, ratio);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("claimInvoiceId", claimInvoiceId)
        .append("name", name)
        .append("medicareChargeCode", medicareChargeCode)
        .append("amount", amount)
        .append("ratio", ratio)
        .append("createTime", createTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
