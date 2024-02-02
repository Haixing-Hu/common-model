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
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.datastructure.CollectionUtils;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.WithSource;

/**
 * 此模型表示企业保险理赔发票信息。
 *
 * @author 潘凯
 */
public class EnterpriseClaimInvoice implements Identifiable, WithSource,
    Auditable, Assignable<EnterpriseClaimInvoice> {

  private static final long serialVersionUID = 5899630210422111785L;

  /**
   * 内部ID，主键全局唯一。
   */
  @Identifier
  private Long id;

  /**
   * 理赔申请ID，关联表enterprise_claim的id字段。
   */
  private Long claimId;

  /**
   * 理赔就诊记录ID，关联表enterprise_claim_medical的id字段。
   */
  private Long claimMedicalId;

  /**
   * 发票影像件ID，关联表attachment的id字段。
   */
  private Long attachmentId;

  /**
   * 发票号。
   */
  private String number;

  /**
   * 起付线。
   */
  @Money
  private BigDecimal deductible = BigDecimal.ZERO;

  /**
   * 总金额。
   */
  @Money
  private BigDecimal amount = BigDecimal.ZERO;

  /**
   * 个人自付。
   */
  @Money
  private BigDecimal selfPaidAmount = BigDecimal.ZERO;

  /**
   * 个人自理。
   */
  @Money
  private BigDecimal selfCareAmount = BigDecimal.ZERO;

  /**
   * 统筹基金支付。
   */
  @Money
  private BigDecimal fundPaidAmount = BigDecimal.ZERO;

  /**
   * 大病救助。
   */
  @Money
  private BigDecimal seriousIllnessAmount = BigDecimal.ZERO;

  /**
   * 大病保险。
   */
  @Money
  private BigDecimal seriousIllnessInsuranceAmount = BigDecimal.ZERO;

  /**
   * 不予报销费用。
   */
  @Money
  private BigDecimal noReimbursementAmount = BigDecimal.ZERO;

  /**
   * 无效费用。
   */
  @Money
  private BigDecimal invalidAmount = BigDecimal.ZERO;

  /**
   * 乙类自理。
   */
  @Money
  private BigDecimal classBSelfCareAmount = BigDecimal.ZERO;

  /**
   * 自费。
   */
  @Money
  private BigDecimal selfAmount = BigDecimal.ZERO;

  /**
   * 民政补助支付。
   */
  @Money
  private BigDecimal civilAffairSubsidyAmount = BigDecimal.ZERO;

  /**
   * 医保范围内费用。
   */
  @Money
  private BigDecimal medicareAmount = BigDecimal.ZERO;

  /**
   * 发票来源。
   */
  private Info source;

  /**
   * 操作人员。
   */
  @Nullable
  private String operatorName;

  /**
   * 发票状态。
   */
  private SaveStatus status;

  /**
   * 是否准确。
   */
  private Boolean accuracy;

  /**
   * 不准确的原因。
   */
  private String inaccurateReason;

  /**
   * 乙类自理明细列表。
   */
  private List<EnterpriseClaimSelfCareItem> selfCareItems;

  /**
   * 赔付基数。
   */
  @Money
  private BigDecimal claimBase = BigDecimal.ZERO;

  /**
   * 赔付金额。
   */
  @Money
  private BigDecimal claimAmount = BigDecimal.ZERO;

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

  public EnterpriseClaimInvoice() {
    // empty
  }

  public EnterpriseClaimInvoice(final EnterpriseClaimInvoice other) {
    assign(other);
  }

  @Override
  public void assign(final EnterpriseClaimInvoice other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    claimId = other.claimId;
    claimMedicalId = other.claimMedicalId;
    attachmentId = other.attachmentId;
    number = other.number;
    deductible = other.deductible;
    amount = other.amount;
    selfPaidAmount = other.selfPaidAmount;
    selfCareAmount = other.selfCareAmount;
    fundPaidAmount = other.fundPaidAmount;
    seriousIllnessAmount = other.seriousIllnessAmount;
    seriousIllnessInsuranceAmount = other.seriousIllnessInsuranceAmount;
    noReimbursementAmount = other.noReimbursementAmount;
    invalidAmount = other.invalidAmount;
    classBSelfCareAmount = other.classBSelfCareAmount;
    selfAmount = other.selfAmount;
    civilAffairSubsidyAmount = other.civilAffairSubsidyAmount;
    medicareAmount = other.medicareAmount;
    source = Assignment.clone(other.source);
    operatorName = other.operatorName;
    status = other.status;
    accuracy = other.accuracy;
    inaccurateReason = other.inaccurateReason;
    selfCareItems = Assignment.deepClone(other.selfCareItems);
    claimBase = other.claimBase;
    claimAmount = other.claimAmount;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public EnterpriseClaimInvoice clone() {
    return new EnterpriseClaimInvoice(this);
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

  public BigDecimal getDeductible() {
    return deductible;
  }

  public void setDeductible(final BigDecimal deductible) {
    this.deductible = deductible;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
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

  public BigDecimal getFundPaidAmount() {
    return fundPaidAmount;
  }

  public void setFundPaidAmount(final BigDecimal fundPaidAmount) {
    this.fundPaidAmount = fundPaidAmount;
  }

  public BigDecimal getSeriousIllnessAmount() {
    return seriousIllnessAmount;
  }

  public void setSeriousIllnessAmount(final BigDecimal seriousIllnessAmount) {
    this.seriousIllnessAmount = seriousIllnessAmount;
  }

  public BigDecimal getSeriousIllnessInsuranceAmount() {
    return seriousIllnessInsuranceAmount;
  }

  public void setSeriousIllnessInsuranceAmount(final BigDecimal seriousIllnessInsuranceAmount) {
    this.seriousIllnessInsuranceAmount = seriousIllnessInsuranceAmount;
  }

  public BigDecimal getNoReimbursementAmount() {
    return noReimbursementAmount;
  }

  public void setNoReimbursementAmount(final BigDecimal noReimbursementAmount) {
    this.noReimbursementAmount = noReimbursementAmount;
  }

  public BigDecimal getInvalidAmount() {
    return invalidAmount;
  }

  public void setInvalidAmount(final BigDecimal invalidAmount) {
    this.invalidAmount = invalidAmount;
  }

  public BigDecimal getClassBSelfCareAmount() {
    return classBSelfCareAmount;
  }

  public void setClassBSelfCareAmount(final BigDecimal classBSelfCareAmount) {
    this.classBSelfCareAmount = classBSelfCareAmount;
  }

  public BigDecimal getSelfAmount() {
    return selfAmount;
  }

  public void setSelfAmount(final BigDecimal selfAmount) {
    this.selfAmount = selfAmount;
  }

  public BigDecimal getCivilAffairSubsidyAmount() {
    return civilAffairSubsidyAmount;
  }

  public void setCivilAffairSubsidyAmount(final BigDecimal civilAffairSubsidyAmount) {
    this.civilAffairSubsidyAmount = civilAffairSubsidyAmount;
  }

  public BigDecimal getMedicareAmount() {
    return medicareAmount;
  }

  public void setMedicareAmount(final BigDecimal medicareAmount) {
    this.medicareAmount = medicareAmount;
  }

  public Info getSource() {
    return source;
  }

  public void setSource(final Info source) {
    this.source = source;
  }

  @Nullable
  public String getOperatorName() {
    return operatorName;
  }

  public void setOperatorName(@Nullable final String operatorName) {
    this.operatorName = operatorName;
  }

  public SaveStatus getStatus() {
    return status;
  }

  public void setStatus(final SaveStatus status) {
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

  public List<EnterpriseClaimSelfCareItem> getSelfCareItems() {
    return selfCareItems;
  }

  public void setSelfCareItems(final List<EnterpriseClaimSelfCareItem> selfCareItems) {
    this.selfCareItems = selfCareItems;
  }

  public BigDecimal getClaimBase() {
    return claimBase;
  }

  public void setClaimBase(final BigDecimal claimBase) {
    this.claimBase = claimBase;
  }

  public BigDecimal getClaimAmount() {
    return claimAmount;
  }

  public void setClaimAmount(final BigDecimal claimAmount) {
    this.claimAmount = claimAmount;
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

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final EnterpriseClaimInvoice other = (EnterpriseClaimInvoice) o;
    return Equality.equals(id, other.id)
        && Equality.equals(claimId, other.claimId)
        && Equality.equals(claimMedicalId, other.claimMedicalId)
        && Equality.equals(attachmentId, other.attachmentId)
        && Equality.equals(number, other.number)
        && Equality.equals(deductible, other.deductible)
        && Equality.equals(amount, other.amount)
        && Equality.equals(selfPaidAmount, other.selfPaidAmount)
        && Equality.equals(selfCareAmount, other.selfCareAmount)
        && Equality.equals(fundPaidAmount, other.fundPaidAmount)
        && Equality.equals(seriousIllnessAmount, other.seriousIllnessAmount)
        && Equality.equals(seriousIllnessInsuranceAmount,
        other.seriousIllnessInsuranceAmount)
        && Equality.equals(noReimbursementAmount, other.noReimbursementAmount)
        && Equality.equals(invalidAmount, other.invalidAmount)
        && Equality.equals(classBSelfCareAmount, other.classBSelfCareAmount)
        && Equality.equals(selfAmount, other.selfAmount)
        && Equality.equals(civilAffairSubsidyAmount,
        other.civilAffairSubsidyAmount)
        && Equality.equals(medicareAmount, other.medicareAmount)
        && Equality.equals(source, other.source)
        && Equality.equals(operatorName, other.operatorName)
        && Equality.equals(status, other.status)
        && Equality.equals(accuracy, other.accuracy)
        && Equality.equals(inaccurateReason, other.inaccurateReason)
        && Equality.equals(selfCareItems, other.selfCareItems)
        && Equality.equals(claimBase, other.claimBase)
        && Equality.equals(claimAmount, other.claimAmount)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, claimId);
    result = Hash.combine(result, multiplier, claimMedicalId);
    result = Hash.combine(result, multiplier, attachmentId);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, deductible);
    result = Hash.combine(result, multiplier, amount);
    result = Hash.combine(result, multiplier, selfPaidAmount);
    result = Hash.combine(result, multiplier, selfCareAmount);
    result = Hash.combine(result, multiplier, fundPaidAmount);
    result = Hash.combine(result, multiplier, seriousIllnessAmount);
    result = Hash.combine(result, multiplier, seriousIllnessInsuranceAmount);
    result = Hash.combine(result, multiplier, noReimbursementAmount);
    result = Hash.combine(result, multiplier, invalidAmount);
    result = Hash.combine(result, multiplier, classBSelfCareAmount);
    result = Hash.combine(result, multiplier, selfAmount);
    result = Hash.combine(result, multiplier, civilAffairSubsidyAmount);
    result = Hash.combine(result, multiplier, medicareAmount);
    result = Hash.combine(result, multiplier, source);
    result = Hash.combine(result, multiplier, operatorName);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, accuracy);
    result = Hash.combine(result, multiplier, inaccurateReason);
    result = Hash.combine(result, multiplier, selfCareItems);
    result = Hash.combine(result, multiplier, claimBase);
    result = Hash.combine(result, multiplier, claimAmount);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("claimId", claimId)
        .append("claimMedicalId", claimMedicalId)
        .append("attachmentId", attachmentId)
        .append("number", number)
        .append("deductible", deductible)
        .append("amount", amount)
        .append("selfPaidAmount", selfPaidAmount)
        .append("selfCareAmount", selfCareAmount)
        .append("fundPaidAmount", fundPaidAmount)
        .append("seriousIllnessAmount", seriousIllnessAmount)
        .append("seriousIllnessInsuranceAmount", seriousIllnessInsuranceAmount)
        .append("noReimbursementAmount", noReimbursementAmount)
        .append("invalidAmount", invalidAmount)
        .append("classBSelfCareAmount", classBSelfCareAmount)
        .append("selfAmount", selfAmount)
        .append("civilAffairSubsidyAmount", civilAffairSubsidyAmount)
        .append("medicareAmount", medicareAmount)
        .append("source", source)
        .append("operatorName", operatorName)
        .append("status", status)
        .append("accuracy", accuracy)
        .append("inaccurateReason", inaccurateReason)
        .append("selfCareItems", selfCareItems)
        .append("claimBase", claimBase)
        .append("claimAmount", claimAmount)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }

  /**
   * 校验金额。
   */
  public Boolean checkAmount() {
    // 总费用 ≥ 统筹支付 + 大病救助 + 民政补助 + 大病保险 + 个人自理+ 个人自付
    final BigDecimal totalAmount = this.fundPaidAmount.add(this.seriousIllnessAmount)
                                                      .add(this.seriousIllnessInsuranceAmount)
                                                      .add(this.civilAffairSubsidyAmount)
                                                      .add(this.selfCareAmount)
                                                      .add(this.selfPaidAmount);
    return this.amount.compareTo(totalAmount) >= 0;
  }

  /**
   * 校验乙类自理项目。
   * @return
   */
  public Boolean checkSelfCareItems() {
    if (CollectionUtils.isEmpty(this.selfCareItems)) {
      return true;
    }
    // 乙类自理项目自费比例在0到1之间
    final long invalidCount = this.selfCareItems.stream().filter(item -> {
      final Double ratio = item.getRatio();
      return ratio.compareTo(0d) < 0 || ratio.compareTo(1d) > 0;
    }).count();
    return invalidCount == 0;
  }
}
