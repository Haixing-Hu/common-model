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
 * Unit test of the {@link Authorize} class.
 *
 * @author Haixing Hu
 */
public class AuthorizeTest extends ModelTestBase<Authorize> {

  public AuthorizeTest() {
    super(Authorize.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("app", getFieldName(Authorize.class, Authorize::getApp));
    assertEquals("app", getFieldName(Authorize.class, Authorize::setApp));
    assertEquals("token", getFieldName(Authorize.class, Authorize::getToken));
    assertEquals("token", getFieldName(Authorize.class, Authorize::setToken));
    assertEquals("createTime", getFieldName(Authorize.class, Authorize::getCreateTime));
    assertEquals("createTime", getFieldName(Authorize.class, Authorize::setCreateTime));
    assertEquals("expiredTime", getFieldName(Authorize.class, Authorize::getExpiredTime));
    assertEquals("expiredTime", getFieldName(Authorize.class, Authorize::setExpiredTime));
  }
}
