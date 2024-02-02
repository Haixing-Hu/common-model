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
 * Unit test of the {@link Patient} class.
 *
 * @author Haixing Hu
 */
public class PatientTest extends ModelTestBase<Patient> {

  public PatientTest() {
    super(Patient.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Patient.class, Patient::getId));
    assertEquals("id", getFieldName(Patient.class, Patient::setId));
    assertEquals("userId", getFieldName(Patient.class, Patient::getUserId));
    assertEquals("userId", getFieldName(Patient.class, Patient::setUserId));
    assertEquals("personId", getFieldName(Patient.class, Patient::getPersonId));
    assertEquals("personId", getFieldName(Patient.class, Patient::setPersonId));
    assertEquals("hospital", getFieldName(Patient.class, Patient::getHospital));
    assertEquals("hospital", getFieldName(Patient.class, Patient::setHospital));
    assertEquals("code", getFieldName(Patient.class, Patient::getCode));
    assertEquals("code", getFieldName(Patient.class, Patient::setCode));
    assertEquals("internalCode", getFieldName(Patient.class, Patient::getInternalCode));
    assertEquals("internalCode", getFieldName(Patient.class, Patient::setInternalCode));
    assertEquals("name", getFieldName(Patient.class, Patient::getName));
    assertEquals("name", getFieldName(Patient.class, Patient::setName));
    assertEquals("gender", getFieldName(Patient.class, Patient::getGender));
    assertEquals("gender", getFieldName(Patient.class, Patient::setGender));
    assertEquals("birthday", getFieldName(Patient.class, Patient::getBirthday));
    assertEquals("birthday", getFieldName(Patient.class, Patient::setBirthday));
    assertEquals("credential", getFieldName(Patient.class, Patient::getCredential));
    assertEquals("credential", getFieldName(Patient.class, Patient::setCredential));
    assertEquals("mobile", getFieldName(Patient.class, Patient::getMobile));
    assertEquals("mobile", getFieldName(Patient.class, Patient::setMobile));
    assertEquals("email", getFieldName(Patient.class, Patient::getEmail));
    assertEquals("email", getFieldName(Patient.class, Patient::setEmail));
    assertEquals("guardian", getFieldName(Patient.class, Patient::getGuardian));
    assertEquals("guardian", getFieldName(Patient.class, Patient::setGuardian));
    assertEquals("hasMedicare", getFieldName(Patient.class, Patient::isHasMedicare));
    assertEquals("hasMedicare", getFieldName(Patient.class, Patient::setHasMedicare));
    assertEquals("medicareCard", getFieldName(Patient.class, Patient::getMedicareCard));
    assertEquals("medicareCard", getFieldName(Patient.class, Patient::setMedicareCard));
    assertEquals("medicareCity", getFieldName(Patient.class, Patient::getMedicareCity));
    assertEquals("medicareCity", getFieldName(Patient.class, Patient::setMedicareCity));
    assertEquals("comment", getFieldName(Patient.class, Patient::getComment));
    assertEquals("comment", getFieldName(Patient.class, Patient::setComment));
    assertEquals("state", getFieldName(Patient.class, Patient::getState));
    assertEquals("state", getFieldName(Patient.class, Patient::setState));
    assertEquals("createTime", getFieldName(Patient.class, Patient::getCreateTime));
    assertEquals("createTime", getFieldName(Patient.class, Patient::setCreateTime));
    assertEquals("modifyTime", getFieldName(Patient.class, Patient::getModifyTime));
    assertEquals("modifyTime", getFieldName(Patient.class, Patient::setModifyTime));
    assertEquals("deleteTime", getFieldName(Patient.class, Patient::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Patient.class, Patient::setDeleteTime));
  }
}
