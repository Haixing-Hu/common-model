////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.service;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link EmployeeMedicalItem} class.
 *
 * @author Haixing Hu
 */
public class EmployeeMedicalItemTest extends ModelTestBase<EmployeeMedicalItem> {

  public EmployeeMedicalItemTest() {
    super(EmployeeMedicalItem.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("organizationId", getFieldName(EmployeeMedicalItem.class, EmployeeMedicalItem::getOrganizationId));
    assertEquals("organizationId", getFieldName(EmployeeMedicalItem.class, EmployeeMedicalItem::setOrganizationId));
    assertEquals("employeeId", getFieldName(EmployeeMedicalItem.class, EmployeeMedicalItem::getEmployeeId));
    assertEquals("employeeId", getFieldName(EmployeeMedicalItem.class, EmployeeMedicalItem::setEmployeeId));
    assertEquals("medicalItemId", getFieldName(EmployeeMedicalItem.class, EmployeeMedicalItem::getMedicalItemId));
    assertEquals("medicalItemId", getFieldName(EmployeeMedicalItem.class, EmployeeMedicalItem::setMedicalItemId));
  }
}
