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
 * Unit test of the {@link MedicalPackage} class.
 *
 * @author Haixing Hu
 */
public class MedicalPackageTest extends ModelTestBase<MedicalPackage> {

  public MedicalPackageTest() {
    super(MedicalPackage.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(MedicalPackage.class, MedicalPackage::getId));
    assertEquals("id", getFieldName(MedicalPackage.class, MedicalPackage::setId));
    assertEquals("code", getFieldName(MedicalPackage.class, MedicalPackage::getCode));
    assertEquals("code", getFieldName(MedicalPackage.class, MedicalPackage::setCode));
    assertEquals("name", getFieldName(MedicalPackage.class, MedicalPackage::getName));
    assertEquals("name", getFieldName(MedicalPackage.class, MedicalPackage::setName));
    assertEquals("description", getFieldName(MedicalPackage.class, MedicalPackage::getDescription));
    assertEquals("description", getFieldName(MedicalPackage.class, MedicalPackage::setDescription));
    assertEquals("items", getFieldName(MedicalPackage.class, MedicalPackage::getItems));
    assertEquals("items", getFieldName(MedicalPackage.class, MedicalPackage::setItems));
    assertEquals("organization", getFieldName(MedicalPackage.class, MedicalPackage::getOrganization));
    assertEquals("organization", getFieldName(MedicalPackage.class, MedicalPackage::setOrganization));
    assertEquals("createTime", getFieldName(MedicalPackage.class, MedicalPackage::getCreateTime));
    assertEquals("createTime", getFieldName(MedicalPackage.class, MedicalPackage::setCreateTime));
    assertEquals("modifyTime", getFieldName(MedicalPackage.class, MedicalPackage::getModifyTime));
    assertEquals("modifyTime", getFieldName(MedicalPackage.class, MedicalPackage::setModifyTime));
    assertEquals("deleteTime", getFieldName(MedicalPackage.class, MedicalPackage::getDeleteTime));
    assertEquals("deleteTime", getFieldName(MedicalPackage.class, MedicalPackage::setDeleteTime));
  }
}
