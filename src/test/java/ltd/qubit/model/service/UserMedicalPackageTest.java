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
 * Unit test of the {@link UserMedicalPackage} class.
 *
 * @author Haixing Hu
 */
public class UserMedicalPackageTest extends ModelTestBase<UserMedicalPackage> {

  public UserMedicalPackageTest() {
    super(UserMedicalPackage.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(UserMedicalPackage.class, UserMedicalPackage::getId));
    assertEquals("id", getFieldName(UserMedicalPackage.class, UserMedicalPackage::setId));
    assertEquals("userId", getFieldName(UserMedicalPackage.class, UserMedicalPackage::getUserId));
    assertEquals("userId", getFieldName(UserMedicalPackage.class, UserMedicalPackage::setUserId));
    assertEquals("medicalPackageId", getFieldName(UserMedicalPackage.class, UserMedicalPackage::getMedicalPackageId));
    assertEquals("medicalPackageId", getFieldName(UserMedicalPackage.class, UserMedicalPackage::setMedicalPackageId));
    assertEquals("userMedicalItems", getFieldName(UserMedicalPackage.class, UserMedicalPackage::getUserMedicalItems));
    assertEquals("userMedicalItems", getFieldName(UserMedicalPackage.class, UserMedicalPackage::setUserMedicalItems));
    assertEquals("validFrom", getFieldName(UserMedicalPackage.class, UserMedicalPackage::getValidFrom));
    assertEquals("validFrom", getFieldName(UserMedicalPackage.class, UserMedicalPackage::setValidFrom));
    assertEquals("validUntil", getFieldName(UserMedicalPackage.class, UserMedicalPackage::getValidUntil));
    assertEquals("validUntil", getFieldName(UserMedicalPackage.class, UserMedicalPackage::setValidUntil));
  }
}
