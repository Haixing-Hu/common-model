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
 * Unit test of the {@link HospitalizationInfo} class.
 *
 * @author Haixing Hu
 */
public class HospitalizationInfoTest extends ModelTestBase<HospitalizationInfo> {

  public HospitalizationInfoTest() {
    super(HospitalizationInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("admissionDepartment",
      getFieldName(HospitalizationInfo.class, HospitalizationInfo::getAdmissionDepartment));
    assertEquals("admissionDepartment",
      getFieldName(HospitalizationInfo.class, HospitalizationInfo::setAdmissionDepartment));
    assertEquals("dischargeDepartment",
      getFieldName(HospitalizationInfo.class, HospitalizationInfo::getDischargeDepartment));
    assertEquals("dischargeDepartment",
      getFieldName(HospitalizationInfo.class, HospitalizationInfo::setDischargeDepartment));
    assertEquals("patientNumber", getFieldName(HospitalizationInfo.class, HospitalizationInfo::getPatientNumber));
    assertEquals("patientNumber", getFieldName(HospitalizationInfo.class, HospitalizationInfo::setPatientNumber));
    assertEquals("recordNumber", getFieldName(HospitalizationInfo.class, HospitalizationInfo::getRecordNumber));
    assertEquals("recordNumber", getFieldName(HospitalizationInfo.class, HospitalizationInfo::setRecordNumber));
    assertEquals("ward", getFieldName(HospitalizationInfo.class, HospitalizationInfo::getWard));
    assertEquals("ward", getFieldName(HospitalizationInfo.class, HospitalizationInfo::setWard));
    assertEquals("bed", getFieldName(HospitalizationInfo.class, HospitalizationInfo::getBed));
    assertEquals("bed", getFieldName(HospitalizationInfo.class, HospitalizationInfo::setBed));
    assertEquals("admissionTime", getFieldName(HospitalizationInfo.class, HospitalizationInfo::getAdmissionTime));
    assertEquals("admissionTime", getFieldName(HospitalizationInfo.class, HospitalizationInfo::setAdmissionTime));
    assertEquals("dischargeTime", getFieldName(HospitalizationInfo.class, HospitalizationInfo::getDischargeTime));
    assertEquals("dischargeTime", getFieldName(HospitalizationInfo.class, HospitalizationInfo::setDischargeTime));
    assertEquals("days", getFieldName(HospitalizationInfo.class, HospitalizationInfo::getDays));
    assertEquals("days", getFieldName(HospitalizationInfo.class, HospitalizationInfo::setDays));
  }
}
