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
 * Unit test of the {@link PatientInfo} class.
 *
 * @author Haixing Hu
 */
public class PatientInfoTest extends ModelTestBase<PatientInfo> {

  public PatientInfoTest() {
    super(PatientInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(PatientInfo.class, PatientInfo::getId));
    assertEquals("id", getFieldName(PatientInfo.class, PatientInfo::setId));
    assertEquals("code", getFieldName(PatientInfo.class, PatientInfo::getCode));
    assertEquals("code", getFieldName(PatientInfo.class, PatientInfo::setCode));
    assertEquals("internalCode", getFieldName(PatientInfo.class, PatientInfo::getInternalCode));
    assertEquals("internalCode", getFieldName(PatientInfo.class, PatientInfo::setInternalCode));
    assertEquals("name", getFieldName(PatientInfo.class, PatientInfo::getName));
    assertEquals("name", getFieldName(PatientInfo.class, PatientInfo::setName));
    assertEquals("gender", getFieldName(PatientInfo.class, PatientInfo::getGender));
    assertEquals("gender", getFieldName(PatientInfo.class, PatientInfo::setGender));
    assertEquals("birthday", getFieldName(PatientInfo.class, PatientInfo::getBirthday));
    assertEquals("birthday", getFieldName(PatientInfo.class, PatientInfo::setBirthday));
    assertEquals("credential", getFieldName(PatientInfo.class, PatientInfo::getCredential));
    assertEquals("credential", getFieldName(PatientInfo.class, PatientInfo::setCredential));
    assertEquals("mobile", getFieldName(PatientInfo.class, PatientInfo::getMobile));
    assertEquals("mobile", getFieldName(PatientInfo.class, PatientInfo::setMobile));
  }
}
