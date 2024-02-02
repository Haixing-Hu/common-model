////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示住院信息。
 *
 * @author 胡海星
 */
public class HospitalizationInfo extends HisInfo {

  private static final long serialVersionUID = -8072318273414637318L;

  /**
   * 入院科室信息。
   */
  private Info admissionDepartment;

  /**
   * 出院科室信息。
   */
  private Info dischargeDepartment;

  /**
   * 住院患者编号。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String patientNumber;

  /**
   * 住院病历编号。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String recordNumber;

  /**
   * 病区。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String ward;

  /**
   * 床位号。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String bed;

  /**
   * 入院时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant admissionTime;

  /**
   * 出院时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant dischargeTime;

  /**
   * 住院天数。
   */
  private Integer days;

  public HospitalizationInfo() {
    super(MedicalType.HOSPITALIZATION);
  }

  public Info getAdmissionDepartment() {
    return admissionDepartment;
  }

  public void setAdmissionDepartment(final Info admissionDepartment) {
    this.admissionDepartment = admissionDepartment;
  }

  public Info getDischargeDepartment() {
    return dischargeDepartment;
  }

  public void setDischargeDepartment(final Info dischargeDepartment) {
    this.dischargeDepartment = dischargeDepartment;
  }

  @Nullable
  public String getPatientNumber() {
    return patientNumber;
  }

  public void setPatientNumber(@Nullable final String patientNumber) {
    this.patientNumber = patientNumber;
  }

  @Nullable
  public String getRecordNumber() {
    return recordNumber;
  }

  public void setRecordNumber(@Nullable final String recordNumber) {
    this.recordNumber = recordNumber;
  }

  @Nullable
  public String getWard() {
    return ward;
  }

  public void setWard(@Nullable final String ward) {
    this.ward = ward;
  }

  @Nullable
  public String getBed() {
    return bed;
  }

  public void setBed(@Nullable final String bed) {
    this.bed = bed;
  }

  public Instant getAdmissionTime() {
    return admissionTime;
  }

  public void setAdmissionTime(final Instant admissionTime) {
    this.admissionTime = admissionTime;
  }

  public Instant getDischargeTime() {
    return dischargeTime;
  }

  public void setDischargeTime(final Instant dischargeTime) {
    this.dischargeTime = dischargeTime;
  }

  public Integer getDays() {
    return days;
  }

  public void setDays(final Integer days) {
    this.days = days;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final HospitalizationInfo other = (HospitalizationInfo) o;
    return super.equals(other)
            && Equality.equals(admissionDepartment, other.admissionDepartment)
            && Equality.equals(dischargeDepartment, other.dischargeDepartment)
            && Equality.equals(patientNumber, other.patientNumber)
            && Equality.equals(recordNumber, other.recordNumber)
            && Equality.equals(ward, other.ward)
            && Equality.equals(bed, other.bed)
            && Equality.equals(admissionTime, other.admissionTime)
            && Equality.equals(dischargeTime, other.dischargeTime)
            && Equality.equals(days, other.days);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, super.hashCode());
    result = Hash.combine(result, multiplier, admissionDepartment);
    result = Hash.combine(result, multiplier, dischargeDepartment);
    result = Hash.combine(result, multiplier, patientNumber);
    result = Hash.combine(result, multiplier, recordNumber);
    result = Hash.combine(result, multiplier, ward);
    result = Hash.combine(result, multiplier, bed);
    result = Hash.combine(result, multiplier, admissionTime);
    result = Hash.combine(result, multiplier, dischargeTime);
    result = Hash.combine(result, multiplier, days);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .appendSuper(super.toString())
            .append("admissionDepartment", admissionDepartment)
            .append("dischargeDepartment", dischargeDepartment)
            .append("patientNumber", patientNumber)
            .append("recordNumber", recordNumber)
            .append("ward", ward)
            .append("bed", bed)
            .append("admissionTime", admissionTime)
            .append("dischargeTime", dischargeTime)
            .append("days", days)
            .toString();
  }
}
