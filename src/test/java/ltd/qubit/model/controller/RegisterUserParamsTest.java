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
 * Unit test of the {@link RegisterUserParams} class.
 *
 * @author Haixing Hu
 */
public class RegisterUserParamsTest extends ModelTestBase<RegisterUserParams> {

  public RegisterUserParamsTest() {
    super(RegisterUserParams.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("username", getFieldName(RegisterUserParams.class, RegisterUserParams::getUsername));
    assertEquals("username", getFieldName(RegisterUserParams.class, RegisterUserParams::setUsername));
    assertEquals("password", getFieldName(RegisterUserParams.class, RegisterUserParams::getPassword));
    assertEquals("password", getFieldName(RegisterUserParams.class, RegisterUserParams::setPassword));
    assertEquals("name", getFieldName(RegisterUserParams.class, RegisterUserParams::getName));
    assertEquals("name", getFieldName(RegisterUserParams.class, RegisterUserParams::setName));
    assertEquals("nickname", getFieldName(RegisterUserParams.class, RegisterUserParams::getNickname));
    assertEquals("nickname", getFieldName(RegisterUserParams.class, RegisterUserParams::setNickname));
    assertEquals("gender", getFieldName(RegisterUserParams.class, RegisterUserParams::getGender));
    assertEquals("gender", getFieldName(RegisterUserParams.class, RegisterUserParams::setGender));
    assertEquals("avatar", getFieldName(RegisterUserParams.class, RegisterUserParams::getAvatar));
    assertEquals("avatar", getFieldName(RegisterUserParams.class, RegisterUserParams::setAvatar));
    assertEquals("mobile", getFieldName(RegisterUserParams.class, RegisterUserParams::getMobile));
    assertEquals("mobile", getFieldName(RegisterUserParams.class, RegisterUserParams::setMobile));
    assertEquals("email", getFieldName(RegisterUserParams.class, RegisterUserParams::getEmail));
    assertEquals("email", getFieldName(RegisterUserParams.class, RegisterUserParams::setEmail));
    assertEquals("socialNetwork", getFieldName(RegisterUserParams.class, RegisterUserParams::getSocialNetwork));
    assertEquals("socialNetwork", getFieldName(RegisterUserParams.class, RegisterUserParams::setSocialNetwork));
    assertEquals("appId", getFieldName(RegisterUserParams.class, RegisterUserParams::getAppId));
    assertEquals("appId", getFieldName(RegisterUserParams.class, RegisterUserParams::setAppId));
    assertEquals("openId", getFieldName(RegisterUserParams.class, RegisterUserParams::getOpenId));
    assertEquals("openId", getFieldName(RegisterUserParams.class, RegisterUserParams::setOpenId));
    assertEquals("organization", getFieldName(RegisterUserParams.class, RegisterUserParams::getOrganization));
    assertEquals("organization", getFieldName(RegisterUserParams.class, RegisterUserParams::setOrganization));
    assertEquals("environment", getFieldName(RegisterUserParams.class, RegisterUserParams::getEnvironment));
    assertEquals("environment", getFieldName(RegisterUserParams.class, RegisterUserParams::setEnvironment));
  }
}
