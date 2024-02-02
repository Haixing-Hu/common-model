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
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示保险理赔发票信息。
 *
 * @author 潘凯
 */
public class InsuranceClaimInvoice implements Identifiable, Auditable,
    Assignable<InsuranceClaimInvoice> {

  private static final long serialVersionUID = -4967109882502851278L;

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
   * 影像件ID，关联表attachment的id字段。
   */
  private Long attachmentId;

  /**
   * 发票号。
   */
  private String number;

  /**
   * 发票金额。
   */
  @Money
  private BigDecimal amount;

  /**
   * 统筹基金支付。
   */
  @Money
  private BigDecimal fundPaidAmount;

  /**
   * 个人自付。
   */
  @Money
  private BigDecimal selfPaidAmount;

  /**
   * 个人自理。
   */
  @Money
  private BigDecimal selfCareAmount;

  /**
   * 医保范围内费用。
   */
  @Money
  private BigDecimal medicareAmount;

  /**
   * 大病救助支付。
   */
  @Money
  @Nullable
  private BigDecimal seriousIllnessPaid;

  /**
   * 大病保险支付。
   */
  @Money
  @Nullable
  private BigDecimal seriousIllnessInsurancePaid;

  /**
   * 民政补助支付。
   */
  @Money
  @Nullable
  private BigDecimal civilAffairSubsidyPaid;

  /**
   * 自费。
   */
  @Money
  @Nullable
  private BigDecimal selfAmount;

  /**
   * 既往症标识。
   */
  private Boolean pastSymptom;

  /**
   * 理赔发票类型。
   */
  private InsuranceClaimInvoiceType type;

  /**
   * 理赔发票状态。
   */
  private InsuranceClaimInvoiceStatus status;

  /**
   * 是否准确。
   */
  private Boolean accuracy;

  /**
   * 不准确的原因。
   */
  private String inaccurateReason;

  /**
   * 自费补录金额。
   */
  @Money
  @Nullable
  private BigDecimal selfAmountSupply;

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

  /**
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  private List<InsuranceClaimInvoiceCost> costs;

  public InsuranceClaimInvoice() {
    // empty
  }

  public InsuranceClaimInvoice(final InsuranceClaimInvoice other) {
    assign(other);
  }

  @Override
  public void assign(final InsuranceClaimInvoice other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    claimId = other.claimId;
    claimMedicalId = other.claimMedicalId;
    attachmentId = other.attachmentId;
    number = other.number;
    amount = other.amount;
    fundPaidAmount = other.fundPaidAmount;
    selfPaidAmount = other.selfPaidAmount;
    selfCareAmount = other.selfCareAmount;
    medicareAmount = other.medicareAmount;
    seriousIllnessPaid = other.seriousIllnessPaid;
    seriousIllnessInsurancePaid = other.seriousIllnessInsurancePaid;
    civilAffairSubsidyPaid = other.civilAffairSubsidyPaid;
    selfAmount = other.selfAmount;
    pastSymptom = other.pastSymptom;
    type = other.type;
    status = other.status;
    accuracy = other.accuracy;
    inaccurateReason = other.inaccurateReason;
    selfAmountSupply = other.selfAmountSupply;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
    costs = Assignment.deepClone(other.costs);
  }

  @Override
  public InsuranceClaimInvoice clone() {
    return new InsuranceClaimInvoice(this);
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

  public Long getAttachmentId() {
    return attachmentId;
  }

  public void setAttachmentId(final Long attachmentId) {
    this.attachmentId = attachmentId;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getFundPaidAmount() {
    return fundPaidAmount;
  }

  public void setFundPaidAmount(final BigDecimal fundPaidAmount) {
    this.fundPaidAmount = fundPaidAmount;
  }

  public BigDecimal getSelfPaidAmount() {
    return selfPaidAmount;
  }

  public void setSelfPaidAmount(final BigDecimal selfPaidAmount) {
    this.selfPaidAmount = selfPaidAmount;
  }

  public BigDecimal getSelfCareAmount() {
    return selfCareAmount;
  }

  public void setSelfCareAmount(final BigDecimal selfCareAmount) {
    this.selfCareAmount = selfCareAmount;
  }

  public BigDecimal getMedicareAmount() {
    return medicareAmount;
  }

  public void setMedicareAmount(final BigDecimal medicareAmount) {
    this.medicareAmount = medicareAmount;
  }

  @Nullable
  public BigDecimal getSeriousIllnessPaid() {
    return seriousIllnessPaid;
  }

  public void setSeriousIllnessPaid(@Nullable final BigDecimal seriousIllnessPaid) {
    this.seriousIllnessPaid = seriousIllnessPaid;
  }

  @Nullable
  public BigDecimal getSeriousIllnessInsurancePaid() {
    return seriousIllnessInsurancePaid;
  }

  public void setSeriousIllnessInsurancePaid(
      @Nullable final BigDecimal seriousIllnessInsurancePaid) {
    this.seriousIllnessInsurancePaid = seriousIllnessInsurancePaid;
  }

  @Nullable
  public BigDecimal getCivilAffairSubsidyPaid() {
    return civilAffairSubsidyPaid;
  }

  public void setCivilAffairSubsidyPaid(@Nullable final BigDecimal civilAffairSubsidyPaid) {
    this.civilAffairSubsidyPaid = civilAffairSubsidyPaid;
  }

  @Nullable
  public BigDecimal getSelfAmount() {
    return selfAmount;
  }

  public void setSelfAmount(@Nullable final BigDecimal selfAmount) {
    this.selfAmount = selfAmount;
  }

  public Boolean isPastSymptom() {
    return pastSymptom;
  }

  public void setPastSymptom(final Boolean pastSymptom) {
    this.pastSymptom = pastSymptom;
  }

  public InsuranceClaimInvoiceType getType() {
    return type;
  }

  public void setType(final InsuranceClaimInvoiceType type) {
    this.type = type;
  }

  public InsuranceClaimInvoiceStatus getStatus() {
    return status;
  }

  public void setStatus(final InsuranceClaimInvoiceStatus status) {
    this.status = status;
  }

  public Boolean isAccuracy() {
    return accuracy;
  }

  public void setAccuracy(final Boolean accuracy) {
    this.accuracy = accuracy;
  }

  public String getInaccurateReason() {
    return inaccurateReason;
  }

  public void setInaccurateReason(final String inaccurateReason) {
    this.inaccurateReason = inaccurateReason;
  }

  @Nullable
  public BigDecimal getSelfAmountSupply() {
    return selfAmountSupply;
  }

  public void setSelfAmountSupply(@Nullable final BigDecimal selfAmountSupply) {
    this.selfAmountSupply = selfAmountSupply;
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

  public List<InsuranceClaimInvoiceCost> getCosts() {
    return costs;
  }

  public void setCosts(final List<InsuranceClaimInvoiceCost> costs) {
    this.costs = costs;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final InsuranceClaimInvoice other = (InsuranceClaimInvoice) o;
    return Equality.equals(id, other.id)
        && Equality.equals(claimId, other.claimId)
        && Equality.equals(claimMedicalId, other.claimMedicalId)
        && Equality.equals(attachmentId, other.attachmentId)
        && Equality.equals(number, other.number)
        && Equality.equals(amount, other.amount)
        && Equality.equals(fundPaidAmount, other.fundPaidAmount)
        && Equality.equals(selfPaidAmount, other.selfPaidAmount)
        && Equality.equals(selfCareAmount, other.selfCareAmount)
        && Equality.equals(medicareAmount, other.medicareAmount)
        && Equality.equals(seriousIllnessPaid, other.seriousIllnessPaid)
        && Equality.equals(seriousIllnessInsurancePaid, other.seriousIllnessInsurancePaid)
        && Equality.equals(civilAffairSubsidyPaid, other.civilAffairSubsidyPaid)
        && Equality.equals(selfAmount, other.selfAmount)
        && Equality.equals(pastSymptom, other.pastSymptom)
        && Equality.equals(type, other.type)
        && Equality.equals(status, other.status)
        && Equality.equals(accuracy, other.accuracy)
        && Equality.equals(inaccurateReason, other.inaccurateReason)
        && Equality.equals(selfAmountSupply, other.selfAmountSupply)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime)
        && Equality.equals(costs, other.costs);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, claimId);
    result = Hash.combine(result, multiplier, claimMedicalId);
    result = Hash.combine(result, multiplier, attachmentId);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, amount);
    result = Hash.combine(result, multiplier, fundPaidAmount);
    result = Hash.combine(result, multiplier, selfPaidAmount);
    result = Hash.combine(result, multiplier, selfCareAmount);
    result = Hash.combine(result, multiplier, medicareAmount);
    result = Hash.combine(result, multiplier, seriousIllnessPaid);
    result = Hash.combine(result, multiplier, seriousIllnessInsurancePaid);
    result = Hash.combine(result, multiplier, civilAffairSubsidyPaid);
    result = Hash.combine(result, multiplier, selfAmount);
    result = Hash.combine(result, multiplier, pastSymptom);
    result = Hash.combine(result, multiplier, type);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, accuracy);
    result = Hash.combine(result, multiplier, inaccurateReason);
    result = Hash.combine(result, multiplier, selfAmountSupply);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    result = Hash.combine(result, multiplier, costs);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("claimId", claimId)
        .append("claimMedicalId", claimMedicalId)
        .append("attachmentId", attachmentId)
        .append("number", number)
        .append("amount", amount)
        .append("fundPaidAmount", fundPaidAmount)
        .append("selfPaidAmount", selfPaidAmount)
        .append("selfCareAmount", selfCareAmount)
        .append("medicareAmount", medicareAmount)
        .append("seriousIllnessPaid", seriousIllnessPaid)
        .append("seriousIllnessInsurancePaid", seriousIllnessInsurancePaid)
        .append("civilAffairSubsidyPaid", civilAffairSubsidyPaid)
        .append("selfAmount", selfAmount)
        .append("pastSymptom", pastSymptom)
        .append("type", type)
        .append("status", status)
        .append("accuracy", accuracy)
        .append("inaccurateReason", inaccurateReason)
        .append("selfAmountSupply", selfAmountSupply)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .append("costs", costs)
        .toString();
  }

  // public void checkEmptyField() {
  //   if (claimId == null) {
  //     throw new NullFieldException("claimId");
  //   }
  //   if (claimMedicalId == null) {
  //     throw new NullFieldException("claimMedicalId");
  //   }
  //   if (StringUtils.isBlank(number)) {
  //     throw new NullFieldException("invoiceNumber");
  //   }
  //   if (amount == null) {
  //     throw new NullFieldException("amount");
  //   }
  //   if (amount.compareTo(BigDecimal.ZERO) < 0) {
  //     throw new InvalidFieldValueException("amount", amount);
  //   }
  //   if (fundPaidAmount == null) {
  //     throw new NullFieldException("fundPaidAmount");
  //   }
  //   if (fundPaidAmount.compareTo(BigDecimal.ZERO) < 0) {
  //     throw new InvalidFieldValueException("fundPaidAmount", fundPaidAmount);
  //   }
  //   if (selfPaidAmount == null) {
  //     throw new NullFieldException("selfPaidAmount");
  //   }
  //   if (selfPaidAmount.compareTo(BigDecimal.ZERO) < 0) {
  //     throw new InvalidFieldValueException("selfPaidAmount", selfPaidAmount);
  //   }
  //   if (selfCareAmount == null) {
  //     throw new NullFieldException("selfCareAmount");
  //   }
  //   if (selfCareAmount.compareTo(BigDecimal.ZERO) < 0) {
  //     throw new InvalidFieldValueException("selfCareAmount", selfCareAmount);
  //   }
  //   if (medicareAmount == null) {
  //     throw new NullFieldException("medicareAmount");
  //   }
  //   if (medicareAmount.compareTo(BigDecimal.ZERO) < 0) {
  //     throw new InvalidFieldValueException("medicareAmount", medicareAmount);
  //   }
  //   if (seriousIllnessPaid == null) {
  //     throw new NullFieldException("seriousIllnessPaid");
  //   }
  //   if (seriousIllnessPaid.compareTo(BigDecimal.ZERO) < 0) {
  //     throw new InvalidFieldValueException("seriousIllnessPaid", seriousIllnessPaid);
  //   }
  //   if (seriousIllnessInsurancePaid == null) {
  //     throw new NullFieldException("seriousIllnessInsurancePaid");
  //   }
  //   if (seriousIllnessInsurancePaid.compareTo(BigDecimal.ZERO) < 0) {
  //     throw new InvalidFieldValueException("seriousIllnessInsurancePaid",
  //         seriousIllnessInsurancePaid);
  //   }
  //   if (civilAffairSubsidyPaid == null) {
  //     throw new NullFieldException("civilAffairSubsidyPaid");
  //   }
  //   if (civilAffairSubsidyPaid.compareTo(BigDecimal.ZERO) < 0) {
  //     throw new InvalidFieldValueException("civilAffairSubsidyPaid", civilAffairSubsidyPaid);
  //   }
  // }

  /**
   * 校验金额。
   */
  public Boolean checkAmount() {
    // checkEmptyField();
    final BigDecimal totalAmount = this.fundPaidAmount
        .add(this.selfCareAmount)
        .add(this.selfPaidAmount)
        .add(this.seriousIllnessPaid)
        .add(this.seriousIllnessInsurancePaid)
        .add(civilAffairSubsidyPaid);
    return this.amount.compareTo(totalAmount) >= 0;
  }
}
