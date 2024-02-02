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
import ltd.qubit.model.medical.MedicalType;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示保险理赔就诊记录。
 *
 * @author 潘凯
 */
public final class InsuranceClaimMedical implements Identifiable, Auditable,
    Assignable<InsuranceClaimMedical> {

  private static final long serialVersionUID = 1399012628123145140L;

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
   * 商保平台返回的理赔申请id。
   */
  @Nullable
  private String claimApplyId;

  /**
   * 就诊日期。
   */
  private LocalDate treatmentDate;

  /**
   * 就诊流水号。
   */
  private String number;

  /**
   * 医疗类别。
   */
  private MedicalType medicalType;

  /**
   * 既往症标识。
   */
  private Boolean pastSymptom;

  /**
   * 就诊医院。
   */
  private Info hospital;

  /**
   * 就诊科室。
   */
  private String department;

  /**
   * 费用。
   */
  private BigDecimal amount;

  /**
   * 初步诊断 。
   */
  private String primaryDiagnosis;

  /**
   * 是否有发票。
   */
  private Boolean hasInvoice;

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

  /**
   * 理赔发票列表。
   */
  private List<InsuranceClaimInvoice> invoiceList;

  public InsuranceClaimMedical() {
    // empty
  }

  public InsuranceClaimMedical(final InsuranceClaimMedical other) {
    assign(other);
  }

  @Override
  public void assign(final InsuranceClaimMedical other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    claimId = other.claimId;
    claimApplyId = other.claimApplyId;
    treatmentDate = other.treatmentDate;
    number = other.number;
    medicalType = other.medicalType;
    pastSymptom = other.pastSymptom;
    hospital = Assignment.clone(other.hospital);
    department = other.department;
    amount = other.amount;
    primaryDiagnosis = other.primaryDiagnosis;
    hasInvoice = other.hasInvoice;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
    invoiceList = Assignment.deepClone(other.invoiceList);
  }

  @Override
  public InsuranceClaimMedical clone() {
    return new InsuranceClaimMedical(this);
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
  public String getClaimApplyId() {
    return claimApplyId;
  }

  public void setClaimApplyId(@Nullable final String claimApplyId) {
    this.claimApplyId = claimApplyId;
  }

  public LocalDate getTreatmentDate() {
    return treatmentDate;
  }

  public void setTreatmentDate(final LocalDate treatmentDate) {
    this.treatmentDate = treatmentDate;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public MedicalType getMedicalType() {
    return medicalType;
  }

  public void setMedicalType(final MedicalType medicalType) {
    this.medicalType = medicalType;
  }

  public Boolean isPastSymptom() {
    return pastSymptom;
  }

  public void setPastSymptom(final Boolean pastSymptom) {
    this.pastSymptom = pastSymptom;
  }

  public Info getHospital() {
    return hospital;
  }

  public void setHospital(final Info hospital) {
    this.hospital = hospital;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(final String department) {
    this.department = department;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
  }

  public String getPrimaryDiagnosis() {
    return primaryDiagnosis;
  }

  public void setPrimaryDiagnosis(final String primaryDiagnosis) {
    this.primaryDiagnosis = primaryDiagnosis;
  }

  public Boolean isHasInvoice() {
    return hasInvoice;
  }

  public void setHasInvoice(final Boolean hasInvoice) {
    this.hasInvoice = hasInvoice;
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

  public List<InsuranceClaimInvoice> getInvoiceList() {
    return invoiceList;
  }

  public void setInvoiceList(final List<InsuranceClaimInvoice> invoiceList) {
    this.invoiceList = invoiceList;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final InsuranceClaimMedical other = (InsuranceClaimMedical) o;
    return Equality.equals(id, other.id)
        && Equality.equals(claimId, other.claimId)
        && Equality.equals(claimApplyId, other.claimApplyId)
        && Equality.equals(treatmentDate, other.treatmentDate)
        && Equality.equals(number, other.number)
        && Equality.equals(medicalType, other.medicalType)
        && Equality.equals(pastSymptom, other.pastSymptom)
        && Equality.equals(hospital, other.hospital)
        && Equality.equals(department, other.department)
        && Equality.equals(amount, other.amount)
        && Equality.equals(primaryDiagnosis, other.primaryDiagnosis)
        && Equality.equals(hasInvoice, other.hasInvoice)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime)
        && Equality.equals(invoiceList, other.invoiceList);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, claimId);
    result = Hash.combine(result, multiplier, claimApplyId);
    result = Hash.combine(result, multiplier, treatmentDate);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, medicalType);
    result = Hash.combine(result, multiplier, pastSymptom);
    result = Hash.combine(result, multiplier, hospital);
    result = Hash.combine(result, multiplier, department);
    result = Hash.combine(result, multiplier, amount);
    result = Hash.combine(result, multiplier, primaryDiagnosis);
    result = Hash.combine(result, multiplier, hasInvoice);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    result = Hash.combine(result, multiplier, invoiceList);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("claimId", claimId)
        .append("claimApplyId", claimApplyId)
        .append("treatmentDate", treatmentDate)
        .append("number", number)
        .append("medicalType", medicalType)
        .append("pastSymptom", pastSymptom)
        .append("hospital", hospital)
        .append("department", department)
        .append("amount", amount)
        .append("primaryDiagnosis", primaryDiagnosis)
        .append("hasInvoice", hasInvoice)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .append("invoiceList", invoiceList)
        .toString();
  }

  // public void checkEmptyField() {
  //   if (claimId == null) {
  //     throw new NullFieldException("claimId");
  //   }
  //   if (treatmentDate == null) {
  //     throw new NullFieldException("treatmentDate");
  //   }
  //   if (StringUtils.isBlank(primaryDiagnosis)) {
  //     throw new NullFieldException("primaryDiagnosis");
  //   }
  // }
}
