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
 * Unit test of the {@link Employee} class.
 *
 * @author Haixing Hu
 */
public class EmployeeTest extends ModelTestBase<Employee> {

  public EmployeeTest() {
    super(Employee.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Employee.class, Employee::getId));
    assertEquals("id", getFieldName(Employee.class, Employee::setId));
    assertEquals("username", getFieldName(Employee.class, Employee::getUsername));
    assertEquals("username", getFieldName(Employee.class, Employee::setUsername));
    assertEquals("personId", getFieldName(Employee.class, Employee::getPersonId));
    assertEquals("personId", getFieldName(Employee.class, Employee::setPersonId));
    assertEquals("code", getFieldName(Employee.class, Employee::getCode));
    assertEquals("code", getFieldName(Employee.class, Employee::setCode));
    assertEquals("internalCode", getFieldName(Employee.class, Employee::getInternalCode));
    assertEquals("internalCode", getFieldName(Employee.class, Employee::setInternalCode));
    assertEquals("name", getFieldName(Employee.class, Employee::getName));
    assertEquals("name", getFieldName(Employee.class, Employee::setName));
    assertEquals("gender", getFieldName(Employee.class, Employee::getGender));
    assertEquals("gender", getFieldName(Employee.class, Employee::setGender));
    assertEquals("birthday", getFieldName(Employee.class, Employee::getBirthday));
    assertEquals("birthday", getFieldName(Employee.class, Employee::setBirthday));
    assertEquals("credential", getFieldName(Employee.class, Employee::getCredential));
    assertEquals("credential", getFieldName(Employee.class, Employee::setCredential));
    assertEquals("category", getFieldName(Employee.class, Employee::getCategory));
    assertEquals("category", getFieldName(Employee.class, Employee::setCategory));
    assertEquals("organization", getFieldName(Employee.class, Employee::getOrganization));
    assertEquals("organization", getFieldName(Employee.class, Employee::setOrganization));
    assertEquals("department", getFieldName(Employee.class, Employee::getDepartment));
    assertEquals("department", getFieldName(Employee.class, Employee::setDepartment));
    assertEquals("phone", getFieldName(Employee.class, Employee::getPhone));
    assertEquals("phone", getFieldName(Employee.class, Employee::setPhone));
    assertEquals("mobile", getFieldName(Employee.class, Employee::getMobile));
    assertEquals("mobile", getFieldName(Employee.class, Employee::setMobile));
    assertEquals("email", getFieldName(Employee.class, Employee::getEmail));
    assertEquals("email", getFieldName(Employee.class, Employee::setEmail));
    assertEquals("url", getFieldName(Employee.class, Employee::getUrl));
    assertEquals("url", getFieldName(Employee.class, Employee::setUrl));
    assertEquals("photo", getFieldName(Employee.class, Employee::getPhoto));
    assertEquals("photo", getFieldName(Employee.class, Employee::setPhoto));
    assertEquals("description", getFieldName(Employee.class, Employee::getDescription));
    assertEquals("description", getFieldName(Employee.class, Employee::setDescription));
    assertEquals("practisingCertificate", getFieldName(Employee.class, Employee::getPractisingCertificate));
    assertEquals("practisingCertificate", getFieldName(Employee.class, Employee::setPractisingCertificate));
    assertEquals("titleCertificate", getFieldName(Employee.class, Employee::getTitleCertificate));
    assertEquals("titleCertificate", getFieldName(Employee.class, Employee::setTitleCertificate));
    assertEquals("practisingType", getFieldName(Employee.class, Employee::getPractisingType));
    assertEquals("practisingType", getFieldName(Employee.class, Employee::setPractisingType));
    assertEquals("practisingScope", getFieldName(Employee.class, Employee::getPractisingScope));
    assertEquals("practisingScope", getFieldName(Employee.class, Employee::setPractisingScope));
    assertEquals("jobTitle", getFieldName(Employee.class, Employee::getJobTitle));
    assertEquals("jobTitle", getFieldName(Employee.class, Employee::setJobTitle));
    assertEquals("comment", getFieldName(Employee.class, Employee::getComment));
    assertEquals("comment", getFieldName(Employee.class, Employee::setComment));
    assertEquals("state", getFieldName(Employee.class, Employee::getState));
    assertEquals("state", getFieldName(Employee.class, Employee::setState));
    assertEquals("createTime", getFieldName(Employee.class, Employee::getCreateTime));
    assertEquals("createTime", getFieldName(Employee.class, Employee::setCreateTime));
    assertEquals("modifyTime", getFieldName(Employee.class, Employee::getModifyTime));
    assertEquals("modifyTime", getFieldName(Employee.class, Employee::setModifyTime));
    assertEquals("deleteTime", getFieldName(Employee.class, Employee::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Employee.class, Employee::setDeleteTime));
  }
}
