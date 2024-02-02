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
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
import ltd.qubit.model.commons.DictEntryInfo;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示企业保险理赔分单信息。
 *
 * @author 潘凯
 */
public class EnterpriseClaimItem implements Identifiable, Auditable,
    Assignable<EnterpriseClaimItem> {

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
   * 医疗类别，字典条目。
   */
  private DictEntryInfo medicalCategory;

  /**
   * 人员类别。
   */
  @Nullable
  private EnterpriseInsuredType insuredType;

  /**
   * 总金额。
   */
  @Money
  private BigDecimal amount = BigDecimal.ZERO;

  /**
   * 统筹基金支出(大病救助+统筹基金)。
   */
  @Money
  private BigDecimal overallFundAmount = BigDecimal.ZERO;

  /**
   * 无效费用。
   */
  @Money
  private BigDecimal invalidAmount = BigDecimal.ZERO;

  /**
   * 起付线。
   */
  @Money
  private BigDecimal deductible = BigDecimal.ZERO;

  /**
   * 自费金额。
   */
  @Money
  private BigDecimal selfAmount = BigDecimal.ZERO;

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
   * 实际赔付金额。
   */
  @Money
  private BigDecimal actualClaimAmount = BigDecimal.ZERO;

  /**
   * 超上限。
   */
  @Money
  private BigDecimal overUpperLimit = BigDecimal.ZERO;

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
   * 扬子补助。
   */
  @Money
  private BigDecimal yangziSupply = BigDecimal.ZERO;

  /**
   * 医院名称。
   */
  @Nullable
  private String hospitalName;

  /**
   * 医院等级。
   */
  @Nullable
  private Integer hospitalLevel;

  /**
   * 疾病编码。
   */
  @Nullable
  private String diseaseCode;

  /**
   * 实际划账金额。
   */
  @Money
  private BigDecimal actualPaidAmount = BigDecimal.ZERO;

  /**
   * 支付时间。
   */
  @Nullable
  private LocalDate paidDate;

  /**
   * 结案日期。
   */
  @Nullable
  private LocalDate endcaseDate;

  /**
   * 操作人员。
   */
  @Nullable
  private String operatorName;

  /**
   * 赔付说明。
   */
  @Nullable
  private String description;

  /**
   * 分单状态。
   */
  private EnterpriseClaimItemStatus status;

  /**
   * 分单关联的就诊记录列表。
   */
  private List<EnterpriseClaimMedical> medicals;

  /**
   * 历史赔付金额信息。
   */
  private EnterpriseHistoryClaimAmount historyClaimAmount;

  /**
   * 是否已经扣除起付线，默认为false，表示未扣除。
   */
  private Boolean deductDeductible = Boolean.FALSE;

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

  public EnterpriseClaimItem() {
    // empty
  }

  public EnterpriseClaimItem(final EnterpriseClaimItem other) {
    assign(other);
  }

  @Override
  public void assign(final EnterpriseClaimItem other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    claimId = other.claimId;
    medicalCategory = Assignment.clone(other.medicalCategory);
    insuredType = other.insuredType;
    amount = other.amount;
    overallFundAmount = other.overallFundAmount;
    invalidAmount = other.invalidAmount;
    deductible = other.deductible;
    selfAmount = other.selfAmount;
    claimBase = other.claimBase;
    claimAmount = other.claimAmount;
    actualClaimAmount = other.actualClaimAmount;
    overUpperLimit = other.overUpperLimit;
    seriousIllnessAmount = other.seriousIllnessAmount;
    seriousIllnessInsuranceAmount = other.seriousIllnessInsuranceAmount;
    yangziSupply = other.yangziSupply;
    hospitalName = other.hospitalName;
    hospitalLevel = other.hospitalLevel;
    diseaseCode = other.diseaseCode;
    actualPaidAmount = other.actualPaidAmount;
    paidDate = other.paidDate;
    endcaseDate = other.endcaseDate;
    operatorName = other.operatorName;
    description = other.description;
    status = other.status;
    medicals = Assignment.deepClone(other.medicals);
    historyClaimAmount = Assignment.clone(other.historyClaimAmount);
    deductDeductible = other.deductDeductible;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public EnterpriseClaimItem clone() {
    return new EnterpriseClaimItem(this);
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

  public DictEntryInfo getMedicalCategory() {
    return medicalCategory;
  }

  public void setMedicalCategory(final DictEntryInfo medicalCategory) {
    this.medicalCategory = medicalCategory;
  }

  @Nullable
  public EnterpriseInsuredType getInsuredType() {
    return insuredType;
  }

  public void setInsuredType(@Nullable final EnterpriseInsuredType insuredType) {
    this.insuredType = insuredType;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getOverallFundAmount() {
    return overallFundAmount;
  }

  public void setOverallFundAmount(final BigDecimal overallFundAmount) {
    this.overallFundAmount = overallFundAmount;
  }

  public BigDecimal getInvalidAmount() {
    return invalidAmount;
  }

  public void setInvalidAmount(final BigDecimal invalidAmount) {
    this.invalidAmount = invalidAmount;
  }

  public BigDecimal getDeductible() {
    return deductible;
  }

  public void setDeductible(final BigDecimal deductible) {
    this.deductible = deductible;
  }

  public BigDecimal getSelfAmount() {
    return selfAmount;
  }

  public void setSelfAmount(final BigDecimal selfAmount) {
    this.selfAmount = selfAmount;
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

  public BigDecimal getActualClaimAmount() {
    return actualClaimAmount;
  }

  public void setActualClaimAmount(final BigDecimal actualClaimAmount) {
    this.actualClaimAmount = actualClaimAmount;
  }

  public BigDecimal getOverUpperLimit() {
    return overUpperLimit;
  }

  public void setOverUpperLimit(final BigDecimal overUpperLimit) {
    this.overUpperLimit = overUpperLimit;
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

  public BigDecimal getYangziSupply() {
    return yangziSupply;
  }

  public void setYangziSupply(final BigDecimal yangziSupply) {
    this.yangziSupply = yangziSupply;
  }

  @Nullable
  public String getHospitalName() {
    return hospitalName;
  }

  public void setHospitalName(@Nullable final String hospitalName) {
    this.hospitalName = hospitalName;
  }

  @Nullable
  public Integer getHospitalLevel() {
    return hospitalLevel;
  }

  public void setHospitalLevel(@Nullable final Integer hospitalLevel) {
    this.hospitalLevel = hospitalLevel;
  }

  @Nullable
  public String getDiseaseCode() {
    return diseaseCode;
  }

  public void setDiseaseCode(@Nullable final String diseaseCode) {
    this.diseaseCode = diseaseCode;
  }

  public BigDecimal getActualPaidAmount() {
    return actualPaidAmount;
  }

  public void setActualPaidAmount(final BigDecimal actualPaidAmount) {
    this.actualPaidAmount = actualPaidAmount;
  }

  @Nullable
  public LocalDate getPaidDate() {
    return paidDate;
  }

  public void setPaidDate(@Nullable final LocalDate paidDate) {
    this.paidDate = paidDate;
  }

  @Nullable
  public LocalDate getEndcaseDate() {
    return endcaseDate;
  }

  public void setEndcaseDate(@Nullable final LocalDate endcaseDate) {
    this.endcaseDate = endcaseDate;
  }

  @Nullable
  public String getOperatorName() {
    return operatorName;
  }

  public void setOperatorName(@Nullable final String operatorName) {
    this.operatorName = operatorName;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  public EnterpriseClaimItemStatus getStatus() {
    return status;
  }

  public void setStatus(final EnterpriseClaimItemStatus status) {
    this.status = status;
  }

  public List<EnterpriseClaimMedical> getMedicals() {
    return medicals;
  }

  public void setMedicals(final List<EnterpriseClaimMedical> medicals) {
    this.medicals = medicals;
  }

  public EnterpriseHistoryClaimAmount getHistoryClaimAmount() {
    return historyClaimAmount;
  }

  public void setHistoryClaimAmount(final EnterpriseHistoryClaimAmount historyClaimAmount) {
    this.historyClaimAmount = historyClaimAmount;
  }

  public Boolean isDeductDeductible() {
    return deductDeductible;
  }

  public void setDeductDeductible(final Boolean deductDeductible) {
    this.deductDeductible = deductDeductible;
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
    final EnterpriseClaimItem other = (EnterpriseClaimItem) o;
    return Equality.equals(id, other.id)
        && Equality.equals(claimId, other.claimId)
        && Equality.equals(medicalCategory, other.medicalCategory)
        && Equality.equals(insuredType, other.insuredType)
        && Equality.equals(amount, other.amount)
        && Equality.equals(overallFundAmount, other.overallFundAmount)
        && Equality.equals(invalidAmount, other.invalidAmount)
        && Equality.equals(deductible, other.deductible)
        && Equality.equals(selfAmount, other.selfAmount)
        && Equality.equals(claimBase, other.claimBase)
        && Equality.equals(claimAmount, other.claimAmount)
        && Equality.equals(actualClaimAmount, other.actualClaimAmount)
        && Equality.equals(overUpperLimit, other.overUpperLimit)
        && Equality.equals(seriousIllnessAmount, other.seriousIllnessAmount)
        && Equality.equals(seriousIllnessInsuranceAmount,
        other.seriousIllnessInsuranceAmount)
        && Equality.equals(yangziSupply, other.yangziSupply)
        && Equality.equals(hospitalName, other.hospitalName)
        && Equality.equals(hospitalLevel, other.hospitalLevel)
        && Equality.equals(diseaseCode, other.diseaseCode)
        && Equality.equals(actualPaidAmount, other.actualPaidAmount)
        && Equality.equals(paidDate, other.paidDate)
        && Equality.equals(endcaseDate, other.endcaseDate)
        && Equality.equals(operatorName, other.operatorName)
        && Equality.equals(description, other.description)
        && Equality.equals(status, other.status)
        && Equality.equals(medicals, other.medicals)
        && Equality.equals(historyClaimAmount, other.historyClaimAmount)
        && Equality.equals(deductDeductible, other.deductDeductible)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, claimId);
    result = Hash.combine(result, multiplier, medicalCategory);
    result = Hash.combine(result, multiplier, insuredType);
    result = Hash.combine(result, multiplier, amount);
    result = Hash.combine(result, multiplier, overallFundAmount);
    result = Hash.combine(result, multiplier, invalidAmount);
    result = Hash.combine(result, multiplier, deductible);
    result = Hash.combine(result, multiplier, selfAmount);
    result = Hash.combine(result, multiplier, claimBase);
    result = Hash.combine(result, multiplier, claimAmount);
    result = Hash.combine(result, multiplier, actualClaimAmount);
    result = Hash.combine(result, multiplier, overUpperLimit);
    result = Hash.combine(result, multiplier, seriousIllnessAmount);
    result = Hash.combine(result, multiplier, seriousIllnessInsuranceAmount);
    result = Hash.combine(result, multiplier, yangziSupply);
    result = Hash.combine(result, multiplier, hospitalName);
    result = Hash.combine(result, multiplier, hospitalLevel);
    result = Hash.combine(result, multiplier, diseaseCode);
    result = Hash.combine(result, multiplier, actualPaidAmount);
    result = Hash.combine(result, multiplier, paidDate);
    result = Hash.combine(result, multiplier, endcaseDate);
    result = Hash.combine(result, multiplier, operatorName);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, medicals);
    result = Hash.combine(result, multiplier, historyClaimAmount);
    result = Hash.combine(result, multiplier, deductDeductible);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("claimId", claimId)
        .append("medicalCategory", medicalCategory)
        .append("insuredType", insuredType)
        .append("amount", amount)
        .append("overallFundAmount", overallFundAmount)
        .append("invalidAmount", invalidAmount)
        .append("deductible", deductible)
        .append("selfAmount", selfAmount)
        .append("claimBase", claimBase)
        .append("claimAmount", claimAmount)
        .append("actualClaimAmount", actualClaimAmount)
        .append("overUpperLimit", overUpperLimit)
        .append("seriousIllnessAmount", seriousIllnessAmount)
        .append("seriousIllnessInsuranceAmount", seriousIllnessInsuranceAmount)
        .append("yangziSupply", yangziSupply)
        .append("hospitalName", hospitalName)
        .append("hospitalLevel", hospitalLevel)
        .append("diseaseCode", diseaseCode)
        .append("actualPaidAmount", actualPaidAmount)
        .append("paidDate", paidDate)
        .append("endcaseDate", endcaseDate)
        .append("operatorName", operatorName)
        .append("description", description)
        .append("status", status)
        .append("medicals", medicals)
        .append("historyClaimAmount", historyClaimAmount)
        .append("deductDeductible", deductDeductible)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }

  public void initHospitalAndDisease() {
    if (!CollectionUtils.isEmpty(this.medicals)) {
      // 设置分单的医院信息
      final Set<String> hospitalSet = this.medicals
          .stream()
          .map(item -> item.getHospital().getName())
          .collect(Collectors.toSet());
      if (hospitalSet.size() == 1) {
        // 如果当前就诊记录列表都是同一个医院，则取第一条就诊记录的医院信息即可
        this.setHospitalName(this.medicals.get(0).getHospital().getName());
        this.setHospitalLevel(this.medicals.get(0).getHospitalLevel());
      } else {
        // 否则医院名称设置为其他
        this.setHospitalName("其他");
        // 医院等级取就诊记录中医院等级最高的值
        final Integer maxHospitalLevel = this.medicals
              .stream()
              .max(Comparator.comparing(
                  EnterpriseClaimMedical::getHospitalLevel))
              .get()
              .getHospitalLevel();
        this.setHospitalLevel(maxHospitalLevel);
      }
      // 设置分单的疾病信息，默认取第一个就诊记录中的疾病
      this.setDiseaseCode(this.medicals.get(0).getDisease().getCode());
    }
  }

}
