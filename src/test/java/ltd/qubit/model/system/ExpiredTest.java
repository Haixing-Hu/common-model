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
 * Unit test of the {@link Expired} class.
 *
 * @author Haixing Hu
 */
public class ExpiredTest extends ModelTestBase<Expired> {

  public ExpiredTest() {
    super(Expired.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("time", getFieldName(Expired.class, Expired::getTime));
    assertEquals("time", getFieldName(Expired.class, Expired::setTime));
    assertEquals("reason", getFieldName(Expired.class, Expired::getReason));
    assertEquals("reason", getFieldName(Expired.class, Expired::setReason));
  }
}
