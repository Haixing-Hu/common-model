////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.service;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link MedicalItemUseRecord} class.
 *
 * @author Haixing Hu
 */
public class MedicalItemUseRecordTest extends ModelTestBase<MedicalItemUseRecord> {

  public MedicalItemUseRecordTest() {
    super(MedicalItemUseRecord.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::getId));
    assertEquals("id", getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::setId));
    assertEquals("medicalPackage", getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::getMedicalPackage));
    assertEquals("medicalPackage", getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::setMedicalPackage));
    assertEquals("medicalItem", getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::getMedicalItem));
    assertEquals("medicalItem", getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::setMedicalItem));
    assertEquals("userMedicalItemId",
      getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::getUserMedicalItemId));
    assertEquals("userMedicalItemId",
      getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::setUserMedicalItemId));
    assertEquals("patient", getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::getPatient));
    assertEquals("patient", getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::setPatient));
    assertEquals("doctor", getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::getDoctor));
    assertEquals("doctor", getFieldName(MedicalItemUseRecord.class, MedicalItemUseRecord::setDoctor));
  }
}
