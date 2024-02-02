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
 * Unit test of the {@link Environment} class.
 *
 * @author Haixing Hu
 */
public class EnvironmentTest extends ModelTestBase<Environment> {

  public EnvironmentTest() {
    super(Environment.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("ip", getFieldName(Environment.class, Environment::getIp));
    assertEquals("ip", getFieldName(Environment.class, Environment::setIp));
    assertEquals("location", getFieldName(Environment.class, Environment::getLocation));
    assertEquals("location", getFieldName(Environment.class, Environment::setLocation));
    assertEquals("platform", getFieldName(Environment.class, Environment::getPlatform));
    assertEquals("platform", getFieldName(Environment.class, Environment::setPlatform));
    assertEquals("udid", getFieldName(Environment.class, Environment::getUdid));
    assertEquals("udid", getFieldName(Environment.class, Environment::setUdid));
    assertEquals("pushToken", getFieldName(Environment.class, Environment::getPushToken));
    assertEquals("pushToken", getFieldName(Environment.class, Environment::setPushToken));
  }
}
