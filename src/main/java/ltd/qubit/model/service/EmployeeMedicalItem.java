////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.service;

import java.io.Serializable;

import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.organization.Employee;
import ltd.qubit.model.organization.Organization;

/**
 * 此模型表示雇员与医疗服务项目关系。
 *
 * @author pino
 */
public class EmployeeMedicalItem implements Serializable,
    Assignable<EmployeeMedicalItem> {

  private static final long serialVersionUID = 3475952726509096943L;

  /**
   * 所属组织{@link Organization}。
   */
  private Long organizationId;

  /**
   * 所属雇员{@link Employee}。
   */
  private Long employeeId;

  /**
   * 所属医疗服务项目{@link MedicalItem}。
   */
  private Long medicalItemId;

  public EmployeeMedicalItem() {}

  public EmployeeMedicalItem(final EmployeeMedicalItem other) {
    assign(other);
  }

  @Override
  public void assign(final EmployeeMedicalItem other) {
    organizationId = other.organizationId;
    employeeId = other.employeeId;
    medicalItemId = other.medicalItemId;
  }

  @Override
  public EmployeeMedicalItem clone() {
    return new EmployeeMedicalItem(this);
  }

  public Long getOrganizationId() {
    return organizationId;
  }

  public EmployeeMedicalItem setOrganizationId(final Long organizationId) {
    this.organizationId = organizationId;
    return this;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public EmployeeMedicalItem setEmployeeId(final Long employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  public Long getMedicalItemId() {
    return medicalItemId;
  }

  public EmployeeMedicalItem setMedicalItemId(final Long medicalItemId) {
    this.medicalItemId = medicalItemId;
    return this;
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, organizationId);
    result = Hash.combine(result, multiplier, employeeId);
    result = Hash.combine(result, multiplier, medicalItemId);
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (getClass() != obj.getClass())) {
      return false;
    }
    final EmployeeMedicalItem other = (EmployeeMedicalItem) obj;
    return Equality.equals(organizationId, other.organizationId)
        && Equality.equals(employeeId, other.employeeId)
        && Equality.equals(medicalItemId, other.medicalItemId);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("organizationId", organizationId)
        .append("employeeId", employeeId)
        .append("medicalItemId", medicalItemId)
        .toString();
  }
}
