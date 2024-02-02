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
 * Unit test of the {@link VerifyCode} class.
 *
 * @author Haixing Hu
 */
public class VerifyCodeTest extends ModelTestBase<VerifyCode> {

  public VerifyCodeTest() {
    super(VerifyCode.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(VerifyCode.class, VerifyCode::getId));
    assertEquals("id", getFieldName(VerifyCode.class, VerifyCode::setId));
    assertEquals("app", getFieldName(VerifyCode.class, VerifyCode::getApp));
    assertEquals("app", getFieldName(VerifyCode.class, VerifyCode::setApp));
    assertEquals("mobile", getFieldName(VerifyCode.class, VerifyCode::getMobile));
    assertEquals("mobile", getFieldName(VerifyCode.class, VerifyCode::setMobile));
    assertEquals("email", getFieldName(VerifyCode.class, VerifyCode::getEmail));
    assertEquals("email", getFieldName(VerifyCode.class, VerifyCode::setEmail));
    assertEquals("scene", getFieldName(VerifyCode.class, VerifyCode::getScene));
    assertEquals("scene", getFieldName(VerifyCode.class, VerifyCode::setScene));
    assertEquals("code", getFieldName(VerifyCode.class, VerifyCode::getCode));
    assertEquals("code", getFieldName(VerifyCode.class, VerifyCode::setCode));
    assertEquals("message", getFieldName(VerifyCode.class, VerifyCode::getMessage));
    assertEquals("message", getFieldName(VerifyCode.class, VerifyCode::setMessage));
    assertEquals("verified", getFieldName(VerifyCode.class, VerifyCode::isVerified));
    assertEquals("verified", getFieldName(VerifyCode.class, VerifyCode::setVerified));
    assertEquals("createTime", getFieldName(VerifyCode.class, VerifyCode::getCreateTime));
    assertEquals("createTime", getFieldName(VerifyCode.class, VerifyCode::setCreateTime));
  }
}
