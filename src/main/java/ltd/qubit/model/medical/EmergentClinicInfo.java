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

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示急诊信息。
 *
 * @author 胡海星
 */
public class EmergentClinicInfo extends HisInfo {

  private static final long serialVersionUID = -1981610739427770980L;

  /**
   * 就诊科室基本信息。
   */
  private Info department;

  /**
   * 门诊病历编号。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String recordNumber;

  /**
   * 就诊时间。
   */
  private Instant visitTime;

  public EmergentClinicInfo() {
    super(MedicalType.EMERGENT_CLINIC);
  }

  public Info getDepartment() {
    return department;
  }

  public void setDepartment(final Info department) {
    this.department = department;
  }

  @Nullable
  public String getRecordNumber() {
    return recordNumber;
  }

  public void setRecordNumber(@Nullable final String recordNumber) {
    this.recordNumber = recordNumber;
  }

  public Instant getVisitTime() {
    return visitTime;
  }

  public void setVisitTime(final Instant visitTime) {
    this.visitTime = visitTime;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final EmergentClinicInfo other = (EmergentClinicInfo) o;
    return super.equals(other)
            && Equality.equals(department, other.department)
            && Equality.equals(recordNumber, other.recordNumber)
            && Equality.equals(visitTime, other.visitTime);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, super.hashCode());
    result = Hash.combine(result, multiplier, department);
    result = Hash.combine(result, multiplier, recordNumber);
    result = Hash.combine(result, multiplier, visitTime);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .appendSuper(super.toString())
            .append("department", department)
            .append("recordNumber", recordNumber)
            .append("visitTime", visitTime)
            .toString();
  }
}
