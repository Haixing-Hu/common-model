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

import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示体检信息。
 *
 * @author 胡海星
 */
public class ExaminationInfo extends HisInfo {

  private static final long serialVersionUID = 7565344015829377445L;

  /**
   * 体检科室。
   */
  private Info department;

  /**
   * 体检时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant examineTime;

  public ExaminationInfo() {
    super(MedicalType.EXAMINATION);
  }

  public Info getDepartment() {
    return department;
  }

  public void setDepartment(final Info department) {
    this.department = department;
  }

  public Instant getExamineTime() {
    return examineTime;
  }

  public void setExamineTime(final Instant examineTime) {
    this.examineTime = examineTime;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final ExaminationInfo other = (ExaminationInfo) o;
    return super.equals(other)
            && Equality.equals(department, other.department)
            && Equality.equals(examineTime, other.examineTime);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, super.hashCode());
    result = Hash.combine(result, multiplier, department);
    result = Hash.combine(result, multiplier, examineTime);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .appendSuper(super.toString())
            .append("department", department)
            .append("examineTime", examineTime)
            .toString();
  }
}
