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
 * Unit test of the {@link MedicalItem} class.
 *
 * @author Haixing Hu
 */
public class MedicalItemTest extends ModelTestBase<MedicalItem> {

  public MedicalItemTest() {
    super(MedicalItem.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(MedicalItem.class, MedicalItem::getId));
    assertEquals("id", getFieldName(MedicalItem.class, MedicalItem::setId));
    assertEquals("code", getFieldName(MedicalItem.class, MedicalItem::getCode));
    assertEquals("code", getFieldName(MedicalItem.class, MedicalItem::setCode));
    assertEquals("name", getFieldName(MedicalItem.class, MedicalItem::getName));
    assertEquals("name", getFieldName(MedicalItem.class, MedicalItem::setName));
    assertEquals("description", getFieldName(MedicalItem.class, MedicalItem::getDescription));
    assertEquals("description", getFieldName(MedicalItem.class, MedicalItem::setDescription));
    assertEquals("createTime", getFieldName(MedicalItem.class, MedicalItem::getCreateTime));
    assertEquals("createTime", getFieldName(MedicalItem.class, MedicalItem::setCreateTime));
    assertEquals("modifyTime", getFieldName(MedicalItem.class, MedicalItem::getModifyTime));
    assertEquals("modifyTime", getFieldName(MedicalItem.class, MedicalItem::setModifyTime));
    assertEquals("deleteTime", getFieldName(MedicalItem.class, MedicalItem::getDeleteTime));
    assertEquals("deleteTime", getFieldName(MedicalItem.class, MedicalItem::setDeleteTime));
  }
}
