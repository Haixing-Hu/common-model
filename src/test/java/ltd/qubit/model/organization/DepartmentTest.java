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
 * Unit test of the {@link Department} class.
 *
 * @author Haixing Hu
 */
public class DepartmentTest extends ModelTestBase<Department> {

  public DepartmentTest() {
    super(Department.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Department.class, Department::getId));
    assertEquals("id", getFieldName(Department.class, Department::setId));
    assertEquals("code", getFieldName(Department.class, Department::getCode));
    assertEquals("code", getFieldName(Department.class, Department::setCode));
    assertEquals("internalCode", getFieldName(Department.class, Department::getInternalCode));
    assertEquals("internalCode", getFieldName(Department.class, Department::setInternalCode));
    assertEquals("name", getFieldName(Department.class, Department::getName));
    assertEquals("name", getFieldName(Department.class, Department::setName));
    assertEquals("category", getFieldName(Department.class, Department::getCategory));
    assertEquals("category", getFieldName(Department.class, Department::setCategory));
    assertEquals("parent", getFieldName(Department.class, Department::getParent));
    assertEquals("parent", getFieldName(Department.class, Department::setParent));
    assertEquals("organization", getFieldName(Department.class, Department::getOrganization));
    assertEquals("organization", getFieldName(Department.class, Department::setOrganization));
    assertEquals("state", getFieldName(Department.class, Department::getState));
    assertEquals("state", getFieldName(Department.class, Department::setState));
    assertEquals("icon", getFieldName(Department.class, Department::getIcon));
    assertEquals("icon", getFieldName(Department.class, Department::setIcon));
    assertEquals("description", getFieldName(Department.class, Department::getDescription));
    assertEquals("description", getFieldName(Department.class, Department::setDescription));
    assertEquals("contact", getFieldName(Department.class, Department::getContact));
    assertEquals("contact", getFieldName(Department.class, Department::setContact));
    assertEquals("payloads", getFieldName(Department.class, Department::getPayloads));
    assertEquals("payloads", getFieldName(Department.class, Department::setPayloads));
    assertEquals("predefined", getFieldName(Department.class, Department::isPredefined));
    assertEquals("predefined", getFieldName(Department.class, Department::setPredefined));
    assertEquals("createTime", getFieldName(Department.class, Department::getCreateTime));
    assertEquals("createTime", getFieldName(Department.class, Department::setCreateTime));
    assertEquals("modifyTime", getFieldName(Department.class, Department::getModifyTime));
    assertEquals("modifyTime", getFieldName(Department.class, Department::setModifyTime));
    assertEquals("deleteTime", getFieldName(Department.class, Department::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Department.class, Department::setDeleteTime));
  }
}
