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
 * Unit test of the {@link LoginParams} class.
 *
 * @author Haixing Hu
 */
public class LoginParamsTest extends ModelTestBase<LoginParams> {

  public LoginParamsTest() {
    super(LoginParams.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("username", getFieldName(LoginParams.class, LoginParams::getUsername));
    assertEquals("username", getFieldName(LoginParams.class, LoginParams::setUsername));
    assertEquals("email", getFieldName(LoginParams.class, LoginParams::getEmail));
    assertEquals("email", getFieldName(LoginParams.class, LoginParams::setEmail));
    assertEquals("mobile", getFieldName(LoginParams.class, LoginParams::getMobile));
    assertEquals("mobile", getFieldName(LoginParams.class, LoginParams::setMobile));
    assertEquals("password", getFieldName(LoginParams.class, LoginParams::getPassword));
    assertEquals("password", getFieldName(LoginParams.class, LoginParams::setPassword));
    assertEquals("verifyCode", getFieldName(LoginParams.class, LoginParams::getVerifyCode));
    assertEquals("verifyCode", getFieldName(LoginParams.class, LoginParams::setVerifyCode));
    assertEquals("socialNetwork", getFieldName(LoginParams.class, LoginParams::getSocialNetwork));
    assertEquals("socialNetwork", getFieldName(LoginParams.class, LoginParams::setSocialNetwork));
    assertEquals("appId", getFieldName(LoginParams.class, LoginParams::getAppId));
    assertEquals("appId", getFieldName(LoginParams.class, LoginParams::setAppId));
    assertEquals("openId", getFieldName(LoginParams.class, LoginParams::getOpenId));
    assertEquals("openId", getFieldName(LoginParams.class, LoginParams::setOpenId));
    assertEquals("environment", getFieldName(LoginParams.class, LoginParams::getEnvironment));
    assertEquals("environment", getFieldName(LoginParams.class, LoginParams::setEnvironment));
  }
}
