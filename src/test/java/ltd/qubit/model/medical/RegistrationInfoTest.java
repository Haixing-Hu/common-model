////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link RegistrationInfo} class.
 *
 * @author Haixing Hu
 */
public class RegistrationInfoTest extends ModelTestBase<RegistrationInfo> {

  public RegistrationInfoTest() {
    super(RegistrationInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("department", getFieldName(RegistrationInfo.class, RegistrationInfo::getDepartment));
    assertEquals("department", getFieldName(RegistrationInfo.class, RegistrationInfo::setDepartment));
    assertEquals("registerTime", getFieldName(RegistrationInfo.class, RegistrationInfo::getRegisterTime));
    assertEquals("registerTime", getFieldName(RegistrationInfo.class, RegistrationInfo::setRegisterTime));
  }
}
