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
 * Unit test of the {@link SpecificClinicInfo} class.
 *
 * @author Haixing Hu
 */
public class SpecificClinicInfoTest extends ModelTestBase<SpecificClinicInfo> {

  public SpecificClinicInfoTest() {
    super(SpecificClinicInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("department", getFieldName(SpecificClinicInfo.class, SpecificClinicInfo::getDepartment));
    assertEquals("department", getFieldName(SpecificClinicInfo.class, SpecificClinicInfo::setDepartment));
    assertEquals("recordNumber", getFieldName(SpecificClinicInfo.class, SpecificClinicInfo::getRecordNumber));
    assertEquals("recordNumber", getFieldName(SpecificClinicInfo.class, SpecificClinicInfo::setRecordNumber));
    assertEquals("visitTime", getFieldName(SpecificClinicInfo.class, SpecificClinicInfo::getVisitTime));
    assertEquals("visitTime", getFieldName(SpecificClinicInfo.class, SpecificClinicInfo::setVisitTime));
    assertEquals("specialDisease", getFieldName(SpecificClinicInfo.class, SpecificClinicInfo::getSpecialDisease));
    assertEquals("specialDisease", getFieldName(SpecificClinicInfo.class, SpecificClinicInfo::setSpecialDisease));
  }
}
