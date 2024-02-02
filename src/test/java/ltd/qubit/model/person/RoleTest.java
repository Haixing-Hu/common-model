////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.person;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;
import ltd.qubit.model.privilege.Role;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Role} class.
 *
 * @author Haixing Hu
 */
public class RoleTest extends ModelTestBase<Role> {

  public RoleTest() {
    super(Role.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Role.class, Role::getId));
    assertEquals("id", getFieldName(Role.class, Role::setId));
    assertEquals("app", getFieldName(Role.class, Role::getApp));
    assertEquals("app", getFieldName(Role.class, Role::setApp));
    assertEquals("code", getFieldName(Role.class, Role::getCode));
    assertEquals("code", getFieldName(Role.class, Role::setCode));
    assertEquals("name", getFieldName(Role.class, Role::getName));
    assertEquals("name", getFieldName(Role.class, Role::setName));
    assertEquals("description", getFieldName(Role.class, Role::getDescription));
    assertEquals("description", getFieldName(Role.class, Role::setDescription));
    assertEquals("guest", getFieldName(Role.class, Role::isGuest));
    assertEquals("guest", getFieldName(Role.class, Role::setGuest));
    assertEquals("basic", getFieldName(Role.class, Role::isBasic));
    assertEquals("basic", getFieldName(Role.class, Role::setBasic));
    assertEquals("privileges", getFieldName(Role.class, Role::getPrivileges));
    assertEquals("privileges", getFieldName(Role.class, Role::setPrivileges));
    assertEquals("state", getFieldName(Role.class, Role::getState));
    assertEquals("state", getFieldName(Role.class, Role::setState));
    assertEquals("createTime", getFieldName(Role.class, Role::getCreateTime));
    assertEquals("createTime", getFieldName(Role.class, Role::setCreateTime));
    assertEquals("modifyTime", getFieldName(Role.class, Role::getModifyTime));
    assertEquals("modifyTime", getFieldName(Role.class, Role::setModifyTime));
    assertEquals("deleteTime", getFieldName(Role.class, Role::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Role.class, Role::setDeleteTime));
  }
}
