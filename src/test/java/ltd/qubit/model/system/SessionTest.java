////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.system;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Session} class.
 *
 * @author Haixing Hu
 */
public class SessionTest extends ModelTestBase<Session> {

  public SessionTest() {
    super(Session.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Session.class, Session::getId));
    assertEquals("id", getFieldName(Session.class, Session::setId));
    assertEquals("app", getFieldName(Session.class, Session::getApp));
    assertEquals("app", getFieldName(Session.class, Session::setApp));
    assertEquals("user", getFieldName(Session.class, Session::getUser));
    assertEquals("user", getFieldName(Session.class, Session::setUser));
    assertEquals("token", getFieldName(Session.class, Session::getToken));
    assertEquals("token", getFieldName(Session.class, Session::setToken));
    assertEquals("roles", getFieldName(Session.class, Session::getRoles));
    assertEquals("roles", getFieldName(Session.class, Session::setRoles));
    assertEquals("privileges", getFieldName(Session.class, Session::getPrivileges));
    assertEquals("privileges", getFieldName(Session.class, Session::setPrivileges));
    assertEquals("environment", getFieldName(Session.class, Session::getEnvironment));
    assertEquals("environment", getFieldName(Session.class, Session::setEnvironment));
    assertEquals("lastActiveTime", getFieldName(Session.class, Session::getLastActiveTime));
    assertEquals("lastActiveTime", getFieldName(Session.class, Session::setLastActiveTime));
    assertEquals("expired", getFieldName(Session.class, Session::getExpired));
    assertEquals("expired", getFieldName(Session.class, Session::setExpired));
    assertEquals("createTime", getFieldName(Session.class, Session::getCreateTime));
    assertEquals("createTime", getFieldName(Session.class, Session::setCreateTime));
  }
}
