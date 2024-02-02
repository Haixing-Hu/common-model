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
 * Unit test of the {@link ClinicInfo} class.
 *
 * @author Haixing Hu
 */
public class ClinicInfoTest extends ModelTestBase<ClinicInfo> {

  public ClinicInfoTest() {
    super(ClinicInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("department", getFieldName(ClinicInfo.class, ClinicInfo::getDepartment));
    assertEquals("department", getFieldName(ClinicInfo.class, ClinicInfo::setDepartment));
    assertEquals("recordNumber", getFieldName(ClinicInfo.class, ClinicInfo::getRecordNumber));
    assertEquals("recordNumber", getFieldName(ClinicInfo.class, ClinicInfo::setRecordNumber));
    assertEquals("visitTime", getFieldName(ClinicInfo.class, ClinicInfo::getVisitTime));
    assertEquals("visitTime", getFieldName(ClinicInfo.class, ClinicInfo::setVisitTime));
  }
}
