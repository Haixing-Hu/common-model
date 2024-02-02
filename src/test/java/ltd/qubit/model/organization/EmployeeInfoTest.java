////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.organization;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link EmployeeInfo} class.
 *
 * @author Haixing Hu
 */
public class EmployeeInfoTest extends ModelTestBase<EmployeeInfo> {

  public EmployeeInfoTest() {
    super(EmployeeInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(EmployeeInfo.class, EmployeeInfo::getId));
    assertEquals("id", getFieldName(EmployeeInfo.class, EmployeeInfo::setId));
    assertEquals("code", getFieldName(EmployeeInfo.class, EmployeeInfo::getCode));
    assertEquals("code", getFieldName(EmployeeInfo.class, EmployeeInfo::setCode));
    assertEquals("internalCode", getFieldName(EmployeeInfo.class, EmployeeInfo::getInternalCode));
    assertEquals("internalCode", getFieldName(EmployeeInfo.class, EmployeeInfo::setInternalCode));
    assertEquals("username", getFieldName(EmployeeInfo.class, EmployeeInfo::getUsername));
    assertEquals("username", getFieldName(EmployeeInfo.class, EmployeeInfo::getUsername));
    assertEquals("name", getFieldName(EmployeeInfo.class, EmployeeInfo::getName));
    assertEquals("name", getFieldName(EmployeeInfo.class, EmployeeInfo::setName));
    assertEquals("gender", getFieldName(EmployeeInfo.class, EmployeeInfo::getGender));
    assertEquals("gender", getFieldName(EmployeeInfo.class, EmployeeInfo::setGender));
    assertEquals("birthday", getFieldName(EmployeeInfo.class, EmployeeInfo::getBirthday));
    assertEquals("birthday", getFieldName(EmployeeInfo.class, EmployeeInfo::setBirthday));
    assertEquals("credential", getFieldName(EmployeeInfo.class, EmployeeInfo::getCredential));
    assertEquals("credential", getFieldName(EmployeeInfo.class, EmployeeInfo::setCredential));
    assertEquals("mobile", getFieldName(EmployeeInfo.class, EmployeeInfo::getMobile));
    assertEquals("mobile", getFieldName(EmployeeInfo.class, EmployeeInfo::setMobile));
    assertEquals("organization", getFieldName(EmployeeInfo.class, EmployeeInfo::getOrganization));
    assertEquals("organization", getFieldName(EmployeeInfo.class, EmployeeInfo::setOrganization));
    assertEquals("department", getFieldName(EmployeeInfo.class, EmployeeInfo::getDepartment));
    assertEquals("department", getFieldName(EmployeeInfo.class, EmployeeInfo::setDepartment));
  }
}
