////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.controller;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link LoginResponse} class.
 *
 * @author Haixing Hu
 */
public class LoginResponseTest extends ModelTestBase<LoginResponse> {

  public LoginResponseTest() {
    super(LoginResponse.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(LoginResponse.class, LoginResponse::getId));
    assertEquals("id", getFieldName(LoginResponse.class, LoginResponse::setId));
    assertEquals("username", getFieldName(LoginResponse.class, LoginResponse::getUsername));
    assertEquals("username", getFieldName(LoginResponse.class, LoginResponse::setUsername));
    assertEquals("name", getFieldName(LoginResponse.class, LoginResponse::getName));
    assertEquals("name", getFieldName(LoginResponse.class, LoginResponse::setName));
    assertEquals("nickname", getFieldName(LoginResponse.class, LoginResponse::getNickname));
    assertEquals("nickname", getFieldName(LoginResponse.class, LoginResponse::setNickname));
    assertEquals("gender", getFieldName(LoginResponse.class, LoginResponse::getGender));
    assertEquals("gender", getFieldName(LoginResponse.class, LoginResponse::setGender));
    assertEquals("avatar", getFieldName(LoginResponse.class, LoginResponse::getAvatar));
    assertEquals("avatar", getFieldName(LoginResponse.class, LoginResponse::setAvatar));
    assertEquals("token", getFieldName(LoginResponse.class, LoginResponse::getToken));
    assertEquals("token", getFieldName(LoginResponse.class, LoginResponse::setToken));
    assertEquals("privileges", getFieldName(LoginResponse.class, LoginResponse::getPrivileges));
    assertEquals("privileges", getFieldName(LoginResponse.class, LoginResponse::setPrivileges));
    assertEquals("roles", getFieldName(LoginResponse.class, LoginResponse::getRoles));
    assertEquals("roles", getFieldName(LoginResponse.class, LoginResponse::setRoles));
  }
}
