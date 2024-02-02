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
 * Unit test of the {@link Host} class.
 *
 * @author Haixing Hu
 */
public class HostTest extends ModelTestBase<Host> {

  public HostTest() {
    super(Host.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Host.class, Host::getId));
    assertEquals("id", getFieldName(Host.class, Host::setId));
    assertEquals("provider", getFieldName(Host.class, Host::getProvider));
    assertEquals("provider", getFieldName(Host.class, Host::setProvider));
    assertEquals("udid", getFieldName(Host.class, Host::getUdid));
    assertEquals("udid", getFieldName(Host.class, Host::setUdid));
  }
}
