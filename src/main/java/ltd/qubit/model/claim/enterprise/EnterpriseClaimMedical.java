////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim.enterprise;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.DictEntryInfo;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;

public class EnterpriseClaimMedical implements Identifiable, Auditable,
    Assignable<EnterpriseClaimMedical> {

  private static final long serialVersionUID = -2711780508394380793L;

  /**
   * 内部ID，全局唯一。
   */
  @Identifier
  private Long id;

  /**
   * 理赔记录ID。
   */
  private Long claimId;

  /**
   * 就诊开始日期。
   */
  private LocalDate treatmentStartDate;

  /**
   * 就诊结束日期。
   */
  private LocalDate treatmentEndDate;

  /**
   * 就诊流水号。
   */
  @Nullable
  private String number;

  /**
   * 就诊记录申请ID。
   */
  @Nullable
  private String claimApplyId;

  /**
   * 医疗类别，字典条目。
   */
  @Nullable
  private DictEntryInfo medicalCategory;

  /**
   * 疾病名称，字典条目。
   */
  @Nullable
  private DictEntryInfo disease;

  /**
   * 就诊医院，字典条目。
   */
  @Nullable
  private DictEntryInfo hospital;

  /**
   * 就诊医院等级。
   */
  @Nullable
  private Integer hospitalLevel;

  /**
   * 操作人员。
   */
  @Nullable
  private String operatorName;

  /**
   * 人员类型。
   */
  private EnterpriseInsuredType insuredType;

  /**
   * 数据保存状态。
   */
  private SaveStatus status;

  /**
   * 关联的发票列表。
   */
  private List<EnterpriseClaimInvoice> invoices;

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

  public EnterpriseClaimMedical() {
    // empty
  }

  public EnterpriseClaimMedical(final EnterpriseClaimMedical other) {
    assign(other);
  }

  @Override
  public void assign(final EnterpriseClaimMedical other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    claimId = other.claimId;
    treatmentStartDate = other.treatmentStartDate;
    treatmentEndDate = other.treatmentEndDate;
    number = other.number;
    claimApplyId = other.claimApplyId;
    medicalCategory = Assignment.clone(other.medicalCategory);
    disease = Assignment.clone(other.disease);
    hospital = Assignment.clone(other.hospital);
    hospitalLevel = other.hospitalLevel;
    operatorName = other.operatorName;
    insuredType = other.insuredType;
    status = other.status;
    invoices = Assignment.deepClone(other.invoices);
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public EnterpriseClaimMedical clone() {
    return new EnterpriseClaimMedical(this);
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

  public LocalDate getTreatmentStartDate() {
    return treatmentStartDate;
  }

  public void setTreatmentStartDate(final LocalDate treatmentStartDate) {
    this.treatmentStartDate = treatmentStartDate;
  }

  public LocalDate getTreatmentEndDate() {
    return treatmentEndDate;
  }

  public void setTreatmentEndDate(final LocalDate treatmentEndDate) {
    this.treatmentEndDate = treatmentEndDate;
  }

  @Nullable
  public String getNumber() {
    return number;
  }

  public void setNumber(@Nullable final String number) {
    this.number = number;
  }

  @Nullable
  public String getClaimApplyId() {
    return claimApplyId;
  }

  public void setClaimApplyId(@Nullable final String claimApplyId) {
    this.claimApplyId = claimApplyId;
  }

  @Nullable
  public DictEntryInfo getMedicalCategory() {
    return medicalCategory;
  }

  public void setMedicalCategory(@Nullable final DictEntryInfo medicalCategory) {
    this.medicalCategory = medicalCategory;
  }

  @Nullable
  public DictEntryInfo getDisease() {
    return disease;
  }

  public void setDisease(@Nullable final DictEntryInfo disease) {
    this.disease = disease;
  }

  @Nullable
  public DictEntryInfo getHospital() {
    return hospital;
  }

  public void setHospital(@Nullable final DictEntryInfo hospital) {
    this.hospital = hospital;
  }

  @Nullable
  public Integer getHospitalLevel() {
    return hospitalLevel;
  }

  public void setHospitalLevel(@Nullable final Integer hospitalLevel) {
    this.hospitalLevel = hospitalLevel;
  }

  @Nullable
  public String getOperatorName() {
    return operatorName;
  }

  public void setOperatorName(@Nullable final String operatorName) {
    this.operatorName = operatorName;
  }

  public EnterpriseInsuredType getInsuredType() {
    return insuredType;
  }

  public void setInsuredType(final EnterpriseInsuredType insuredType) {
    this.insuredType = insuredType;
  }

  public SaveStatus getStatus() {
    return status;
  }

  public void setStatus(final SaveStatus status) {
    this.status = status;
  }

  public List<EnterpriseClaimInvoice> getInvoices() {
    return invoices;
  }

  public void setInvoices(final List<EnterpriseClaimInvoice> invoices) {
    this.invoices = invoices;
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
    final EnterpriseClaimMedical other = (EnterpriseClaimMedical) o;
    return Equality.equals(id, other.id)
        && Equality.equals(claimId, other.claimId)
        && Equality.equals(treatmentStartDate, other.treatmentStartDate)
        && Equality.equals(treatmentEndDate, other.treatmentEndDate)
        && Equality.equals(number, other.number)
        && Equality.equals(claimApplyId, other.claimApplyId)
        && Equality.equals(medicalCategory, other.medicalCategory)
        && Equality.equals(disease, other.disease)
        && Equality.equals(hospital, other.hospital)
        && Equality.equals(hospitalLevel, other.hospitalLevel)
        && Equality.equals(operatorName, other.operatorName)
        && Equality.equals(insuredType, other.insuredType)
        && Equality.equals(status, other.status)
        && Equality.equals(invoices, other.invoices)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, claimId);
    result = Hash.combine(result, multiplier, treatmentStartDate);
    result = Hash.combine(result, multiplier, treatmentEndDate);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, claimApplyId);
    result = Hash.combine(result, multiplier, medicalCategory);
    result = Hash.combine(result, multiplier, disease);
    result = Hash.combine(result, multiplier, hospital);
    result = Hash.combine(result, multiplier, hospitalLevel);
    result = Hash.combine(result, multiplier, operatorName);
    result = Hash.combine(result, multiplier, insuredType);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, invoices);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("claimId", claimId)
        .append("treatmentStartDate", treatmentStartDate)
        .append("treatmentEndDate", treatmentEndDate)
        .append("number", number)
        .append("claimApplyId", claimApplyId)
        .append("medicalCategory", medicalCategory)
        .append("disease", disease)
        .append("hospital", hospital)
        .append("hospitalLevel", hospitalLevel)
        .append("operatorName", operatorName)
        .append("insuredType", insuredType)
        .append("status", status)
        .append("invoices", invoices)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
