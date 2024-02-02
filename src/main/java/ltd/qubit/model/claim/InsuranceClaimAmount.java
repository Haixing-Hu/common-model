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
import java.time.LocalDate;
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
 * 此模型表示保险理赔金额。
 *
 * @author 潘凯
 */
public class InsuranceClaimAmount implements Identifiable, Creatable,
    Modifiable, Assignable<InsuranceClaimAmount> {

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
   * 医疗费合计。
   */
  @Money
  @Nullable
  private BigDecimal totalAmount;

  /**
   * 医保范围内费用。
   */
  @Money
  @Nullable
  private BigDecimal medicareAmount;

  /**
   * 个人自付。
   */
  @Money
  @Nullable
  private BigDecimal selfPaidAmount;

  /**
   * 个人自理。
   */
  @Money
  @Nullable
  private BigDecimal selfCareAmount;

  /**
   * 统筹基金支付。
   */
  @Money
  @Nullable
  private BigDecimal fundPaidAmount;

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
   * 个人自付部分索赔金额。
   */
  @Money
  @Nullable
  private BigDecimal selfPaidClaimAmount;

  /**
   * 个人自理部分索赔金额。
   */
  @Money
  @Nullable
  private BigDecimal selfCareClaimAmount;

  /**
   * 总索赔金额。
   */
  @Money
  @Nullable
  private BigDecimal totalClaimAmount;

  /**
   * 个人自付部分实际赔付金额。
   */
  @Money
  @Nullable
  private BigDecimal actualSelfPaidAmount;

  /**
   * 个人自理部分实际赔付金额。
   */
  @Money
  @Nullable
  private BigDecimal actualSelfCareAmount;

  /**
   * 实际赔款金额。
   */
  @Money
  @Nullable
  private BigDecimal actualPaidAmount;

  /**
   * 实际赔付金额是否校准，默认为{@code false}。
   */
  private Boolean paidAmountCalibration;

  /**
   * 支付时间。
   */
  @Nullable
  private LocalDate payTime;

  /**
   * 结案日期。
   */
  @Nullable
  private LocalDate endcaseDate;

  /**
   * 理赔金额的额外参数。
   */
  @Nullable
  private String payload;

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

  public InsuranceClaimAmount() {
    // empty
  }

  public InsuranceClaimAmount(final InsuranceClaimAmount other) {
    assign(other);
  }

  @Override
  public void assign(final InsuranceClaimAmount other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    claimId = other.claimId;
    totalAmount = other.totalAmount;
    medicareAmount = other.medicareAmount;
    selfPaidAmount = other.selfPaidAmount;
    selfCareAmount = other.selfCareAmount;
    fundPaidAmount = other.fundPaidAmount;
    seriousIllnessPaid = other.seriousIllnessPaid;
    seriousIllnessInsurancePaid = other.seriousIllnessInsurancePaid;
    civilAffairSubsidyPaid = other.civilAffairSubsidyPaid;
    selfPaidClaimAmount = other.selfPaidClaimAmount;
    selfCareClaimAmount = other.selfCareClaimAmount;
    totalClaimAmount = other.totalClaimAmount;
    actualSelfPaidAmount = other.actualSelfPaidAmount;
    actualSelfCareAmount = other.actualSelfCareAmount;
    actualPaidAmount = other.actualPaidAmount;
    paidAmountCalibration = other.paidAmountCalibration;
    payTime = other.payTime;
    endcaseDate = other.endcaseDate;
    payload = other.payload;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
  }

  @Override
  public InsuranceClaimAmount clone() {
    return new InsuranceClaimAmount(this);
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

  @Nullable
  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(@Nullable final BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  @Nullable
  public BigDecimal getMedicareAmount() {
    return medicareAmount;
  }

  public void setMedicareAmount(@Nullable final BigDecimal medicareAmount) {
    this.medicareAmount = medicareAmount;
  }

  @Nullable
  public BigDecimal getSelfPaidAmount() {
    return selfPaidAmount;
  }

  public void setSelfPaidAmount(@Nullable final BigDecimal selfPaidAmount) {
    this.selfPaidAmount = selfPaidAmount;
  }

  @Nullable
  public BigDecimal getSelfCareAmount() {
    return selfCareAmount;
  }

  public void setSelfCareAmount(@Nullable final BigDecimal selfCareAmount) {
    this.selfCareAmount = selfCareAmount;
  }

  @Nullable
  public BigDecimal getFundPaidAmount() {
    return fundPaidAmount;
  }

  public void setFundPaidAmount(@Nullable final BigDecimal fundPaidAmount) {
    this.fundPaidAmount = fundPaidAmount;
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
  public BigDecimal getSelfPaidClaimAmount() {
    return selfPaidClaimAmount;
  }

  public void setSelfPaidClaimAmount(@Nullable final BigDecimal selfPaidClaimAmount) {
    this.selfPaidClaimAmount = selfPaidClaimAmount;
  }

  @Nullable
  public BigDecimal getSelfCareClaimAmount() {
    return selfCareClaimAmount;
  }

  public void setSelfCareClaimAmount(@Nullable final BigDecimal selfCareClaimAmount) {
    this.selfCareClaimAmount = selfCareClaimAmount;
  }

  @Nullable
  public BigDecimal getTotalClaimAmount() {
    return totalClaimAmount;
  }

  public void setTotalClaimAmount(@Nullable final BigDecimal totalClaimAmount) {
    this.totalClaimAmount = totalClaimAmount;
  }

  @Nullable
  public BigDecimal getActualSelfPaidAmount() {
    return actualSelfPaidAmount;
  }

  public void setActualSelfPaidAmount(@Nullable final BigDecimal actualSelfPaidAmount) {
    this.actualSelfPaidAmount = actualSelfPaidAmount;
  }

  @Nullable
  public BigDecimal getActualSelfCareAmount() {
    return actualSelfCareAmount;
  }

  public void setActualSelfCareAmount(@Nullable final BigDecimal actualSelfCareAmount) {
    this.actualSelfCareAmount = actualSelfCareAmount;
  }

  @Nullable
  public BigDecimal getActualPaidAmount() {
    return actualPaidAmount;
  }

  public void setActualPaidAmount(@Nullable final BigDecimal actualPaidAmount) {
    this.actualPaidAmount = actualPaidAmount;
  }

  public Boolean isPaidAmountCalibration() {
    return paidAmountCalibration;
  }

  public void setPaidAmountCalibration(final Boolean paidAmountCalibration) {
    this.paidAmountCalibration = paidAmountCalibration;
  }

  @Nullable
  public LocalDate getPayTime() {
    return payTime;
  }

  public void setPayTime(@Nullable final LocalDate payTime) {
    this.payTime = payTime;
  }

  @Nullable
  public LocalDate getEndcaseDate() {
    return endcaseDate;
  }

  public void setEndcaseDate(@Nullable final LocalDate endcaseDate) {
    this.endcaseDate = endcaseDate;
  }

  @Nullable
  public String getPayload() {
    return payload;
  }

  public void setPayload(@Nullable final String payload) {
    this.payload = payload;
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
    final InsuranceClaimAmount other = (InsuranceClaimAmount) o;
    return Equality.equals(id, other.id)
        && Equality.equals(claimId, other.claimId)
        && Equality.equals(totalAmount, other.totalAmount)
        && Equality.equals(medicareAmount, other.medicareAmount)
        && Equality.equals(selfPaidAmount, other.selfPaidAmount)
        && Equality.equals(selfCareAmount, other.selfCareAmount)
        && Equality.equals(fundPaidAmount, other.fundPaidAmount)
        && Equality.equals(seriousIllnessPaid, other.seriousIllnessPaid)
        && Equality.equals(seriousIllnessInsurancePaid, other.seriousIllnessInsurancePaid)
        && Equality.equals(civilAffairSubsidyPaid, other.civilAffairSubsidyPaid)
        && Equality.equals(selfPaidClaimAmount, other.selfPaidClaimAmount)
        && Equality.equals(selfCareClaimAmount, other.selfCareClaimAmount)
        && Equality.equals(totalClaimAmount, other.totalClaimAmount)
        && Equality.equals(actualSelfPaidAmount, other.actualSelfPaidAmount)
        && Equality.equals(actualSelfCareAmount, other.actualSelfCareAmount)
        && Equality.equals(actualPaidAmount, other.actualPaidAmount)
        && Equality.equals(paidAmountCalibration, other.paidAmountCalibration)
        && Equality.equals(payTime, other.payTime)
        && Equality.equals(endcaseDate, other.endcaseDate)
        && Equality.equals(payload, other.payload)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, claimId);
    result = Hash.combine(result, multiplier, totalAmount);
    result = Hash.combine(result, multiplier, medicareAmount);
    result = Hash.combine(result, multiplier, selfPaidAmount);
    result = Hash.combine(result, multiplier, selfCareAmount);
    result = Hash.combine(result, multiplier, fundPaidAmount);
    result = Hash.combine(result, multiplier, seriousIllnessPaid);
    result = Hash.combine(result, multiplier, seriousIllnessInsurancePaid);
    result = Hash.combine(result, multiplier, civilAffairSubsidyPaid);
    result = Hash.combine(result, multiplier, selfPaidClaimAmount);
    result = Hash.combine(result, multiplier, selfCareClaimAmount);
    result = Hash.combine(result, multiplier, totalClaimAmount);
    result = Hash.combine(result, multiplier, actualSelfPaidAmount);
    result = Hash.combine(result, multiplier, actualSelfCareAmount);
    result = Hash.combine(result, multiplier, actualPaidAmount);
    result = Hash.combine(result, multiplier, paidAmountCalibration);
    result = Hash.combine(result, multiplier, payTime);
    result = Hash.combine(result, multiplier, endcaseDate);
    result = Hash.combine(result, multiplier, payload);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("claimId", claimId)
        .append("totalAmount", totalAmount)
        .append("medicareAmount", medicareAmount)
        .append("selfPaidAmount", selfPaidAmount)
        .append("selfCareAmount", selfCareAmount)
        .append("fundPaidAmount", fundPaidAmount)
        .append("seriousIllnessPaid", seriousIllnessPaid)
        .append("seriousIllnessInsurancePaid", seriousIllnessInsurancePaid)
        .append("civilAffairSubsidyPaid", civilAffairSubsidyPaid)
        .append("selfPaidClaimAmount", selfPaidClaimAmount)
        .append("selfCareClaimAmount", selfCareClaimAmount)
        .append("totalClaimAmount", totalClaimAmount)
        .append("actualSelfPaidAmount", actualSelfPaidAmount)
        .append("actualSelfCareAmount", actualSelfCareAmount)
        .append("actualPaidAmount", actualPaidAmount)
        .append("paidAmountCalibration", paidAmountCalibration)
        .append("payTime", payTime)
        .append("endcaseDate", endcaseDate)
        .append("payload", payload)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .toString();
  }
}
