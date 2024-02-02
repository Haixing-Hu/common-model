////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim;

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
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Modifiable;

/**
 * 此模型表示保险理赔发票费用明细。
 *
 * @author 潘凯
 */
public class InsuranceClaimInvoiceCost implements Identifiable,
    Creatable, Modifiable, Assignable<InsuranceClaimInvoiceCost> {

  private static final long serialVersionUID = 924167043931820919L;
  /**
   * 内部ID，主键全局唯一。
   */
  @Identifier
  private Long id;

  /**
   * 理赔申请ID，关联表insurance_claim的id字段。
   */
  private Long claimId;

  /**
   * 理赔就诊记录ID，关联表insurance_claim_medical的id字段。
   */
  private Long claimMedicalId;

  /**
   * 理赔就诊记录ID，关联表insurance_claim_invoice的id字段。
   */
  private Long claimInvoiceId;

  /**
   * 医疗收费项目名称。
   */
  private String medicalChargeName;

  /**
   * 金额。
   */
  @Money
  private BigDecimal amount;

  /**
   * 创建时间，即提交时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  public InsuranceClaimInvoiceCost() {
    // empty
  }

  public InsuranceClaimInvoiceCost(final InsuranceClaimInvoiceCost other) {
    assign(other);
  }

  @Override
  public void assign(final InsuranceClaimInvoiceCost other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    claimId = other.claimId;
    claimMedicalId = other.claimMedicalId;
    claimInvoiceId = other.claimInvoiceId;
    medicalChargeName = other.medicalChargeName;
    amount = other.amount;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
  }

  @Override
  public InsuranceClaimInvoiceCost clone() {
    return new InsuranceClaimInvoiceCost(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getClaimId() {
    return claimId;
  }

  public void setClaimId(final Long claimId) {
    this.claimId = claimId;
  }

  public Long getClaimMedicalId() {
    return claimMedicalId;
  }

  public void setClaimMedicalId(final Long claimMedicalId) {
    this.claimMedicalId = claimMedicalId;
  }

  public Long getClaimInvoiceId() {
    return claimInvoiceId;
  }

  public void setClaimInvoiceId(final Long claimInvoiceId) {
    this.claimInvoiceId = claimInvoiceId;
  }

  public String getMedicalChargeName() {
    return medicalChargeName;
  }

  public void setMedicalChargeName(final String medicalChargeName) {
    this.medicalChargeName = medicalChargeName;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
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

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final InsuranceClaimInvoiceCost other = (InsuranceClaimInvoiceCost) o;
    return Equality.equals(id, other.id)
        && Equality.equals(claimId, other.claimId)
        && Equality.equals(claimMedicalId, other.claimMedicalId)
        && Equality.equals(claimInvoiceId, other.claimInvoiceId)
        && Equality.equals(medicalChargeName, other.medicalChargeName)
        && Equality.equals(amount, other.amount)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, claimId);
    result = Hash.combine(result, multiplier, claimMedicalId);
    result = Hash.combine(result, multiplier, claimInvoiceId);
    result = Hash.combine(result, multiplier, medicalChargeName);
    result = Hash.combine(result, multiplier, amount);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("claimId", claimId)
        .append("claimMedicalId", claimMedicalId)
        .append("claimInvoiceId", claimInvoiceId)
        .append("medicalChargeName", medicalChargeName)
        .append("amount", amount)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .toString();
  }

  // public void checkEmptyField() {
  //   if (claimId == null) {
  //     throw new NullFieldException("claimId");
  //   }
  //   if (claimMedicalId == null) {
  //     throw new NullFieldException("claimMedicalId");
  //   }
  //   if (claimInvoiceId == null) {
  //     throw new NullFieldException("claimInvoiceId");
  //   }
  //   if (StringUtils.isBlank(medicalChargeName)) {
  //     throw new NullFieldException("medicalChargeName");
  //   }
  //   if (amount == null) {
  //     throw new NullFieldException("amount");
  //   }
  //   if (amount.compareTo(BigDecimal.ZERO) < 0) {
  //     throw new InvalidFieldValueException("amount", amount);
  //   }
  // }
}
