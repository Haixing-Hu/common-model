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
 * 此模型表示挂号信息。
 *
 * @author 胡海星
 */
public class RegistrationInfo extends HisInfo {

  private static final long serialVersionUID = -4268967083714462560L;

  /**
   * 挂号科室。
   */
  private Info department;

  /**
   * 挂号时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant registerTime;

  public RegistrationInfo() {
    super(MedicalType.REGISTRATION);
  }

  public Info getDepartment() {
    return department;
  }

  public void setDepartment(final Info department) {
    this.department = department;
  }

  public Instant getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(final Instant registerTime) {
    this.registerTime = registerTime;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final RegistrationInfo other = (RegistrationInfo) o;
    return super.equals(other)
            && Equality.equals(department, other.department)
            && Equality.equals(registerTime, other.registerTime);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, super.hashCode());
    result = Hash.combine(result, multiplier, department);
    result = Hash.combine(result, multiplier, registerTime);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .appendSuper(super.toString())
            .append("department", department)
            .append("registerTime", registerTime)
            .toString();
  }
}
