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
 * Unit test of the {@link Diagnosis} class.
 *
 * @author Haixing Hu
 */
public class DiagnosisTest extends ModelTestBase<Diagnosis> {

  public DiagnosisTest() {
    super(Diagnosis.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Diagnosis.class, Diagnosis::getId));
    assertEquals("id", getFieldName(Diagnosis.class, Diagnosis::setId));
    assertEquals("ownerType", getFieldName(Diagnosis.class, Diagnosis::getOwnerType));
    assertEquals("ownerType", getFieldName(Diagnosis.class, Diagnosis::setOwnerType));
    assertEquals("ownerId", getFieldName(Diagnosis.class, Diagnosis::getOwnerId));
    assertEquals("ownerId", getFieldName(Diagnosis.class, Diagnosis::setOwnerId));
    assertEquals("disease", getFieldName(Diagnosis.class, Diagnosis::getDisease));
    assertEquals("disease", getFieldName(Diagnosis.class, Diagnosis::setDisease));
    assertEquals("tcmDisease", getFieldName(Diagnosis.class, Diagnosis::getTcmDisease));
    assertEquals("tcmDisease", getFieldName(Diagnosis.class, Diagnosis::setTcmDisease));
    assertEquals("syndrome", getFieldName(Diagnosis.class, Diagnosis::getSyndrome));
    assertEquals("syndrome", getFieldName(Diagnosis.class, Diagnosis::setSyndrome));
    assertEquals("description", getFieldName(Diagnosis.class, Diagnosis::getDescription));
    assertEquals("description", getFieldName(Diagnosis.class, Diagnosis::setDescription));
    assertEquals("comment", getFieldName(Diagnosis.class, Diagnosis::getComment));
    assertEquals("comment", getFieldName(Diagnosis.class, Diagnosis::setComment));
    assertEquals("priority", getFieldName(Diagnosis.class, Diagnosis::getPriority));
    assertEquals("priority", getFieldName(Diagnosis.class, Diagnosis::setPriority));
  }
}
