////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.privilege;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link UserRole} class.
 *
 * @author Haixing Hu
 */
public class UserRoleTest extends ModelTestBase<UserRole> {

  public UserRoleTest() {
    super(UserRole.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(UserRole.class, UserRole::getId));
    assertEquals("id", getFieldName(UserRole.class, UserRole::setId));
    assertEquals("user", getFieldName(UserRole.class, UserRole::getUser));
    assertEquals("user", getFieldName(UserRole.class, UserRole::setUser));
    assertEquals("app", getFieldName(UserRole.class, UserRole::getApp));
    assertEquals("app", getFieldName(UserRole.class, UserRole::setApp));
    assertEquals("role", getFieldName(UserRole.class, UserRole::getRole));
    assertEquals("role", getFieldName(UserRole.class, UserRole::setRole));
    assertEquals("createTime", getFieldName(UserRole.class, UserRole::getCreateTime));
    assertEquals("createTime", getFieldName(UserRole.class, UserRole::setCreateTime));
    assertEquals("deleteTime", getFieldName(UserRole.class, UserRole::getDeleteTime));
    assertEquals("deleteTime", getFieldName(UserRole.class, UserRole::setDeleteTime));
  }
}
