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
 * Unit test of the {@link EmergentClinicInfo} class.
 *
 * @author Haixing Hu
 */
public class EmergentClinicInfoTest extends ModelTestBase<EmergentClinicInfo> {

  public EmergentClinicInfoTest() {
    super(EmergentClinicInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("department", getFieldName(EmergentClinicInfo.class, EmergentClinicInfo::getDepartment));
    assertEquals("department", getFieldName(EmergentClinicInfo.class, EmergentClinicInfo::setDepartment));
    assertEquals("recordNumber", getFieldName(EmergentClinicInfo.class, EmergentClinicInfo::getRecordNumber));
    assertEquals("recordNumber", getFieldName(EmergentClinicInfo.class, EmergentClinicInfo::setRecordNumber));
    assertEquals("visitTime", getFieldName(EmergentClinicInfo.class, EmergentClinicInfo::getVisitTime));
    assertEquals("visitTime", getFieldName(EmergentClinicInfo.class, EmergentClinicInfo::setVisitTime));
  }
}
