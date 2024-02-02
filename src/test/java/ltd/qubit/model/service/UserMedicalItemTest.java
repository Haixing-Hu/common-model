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
 * Unit test of the {@link UserMedicalItem} class.
 *
 * @author Haixing Hu
 */
public class UserMedicalItemTest extends ModelTestBase<UserMedicalItem> {

  public UserMedicalItemTest() {
    super(UserMedicalItem.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(UserMedicalItem.class, UserMedicalItem::getId));
    assertEquals("id", getFieldName(UserMedicalItem.class, UserMedicalItem::setId));
    assertEquals("medicalItemId", getFieldName(UserMedicalItem.class, UserMedicalItem::getMedicalItemId));
    assertEquals("medicalItemId", getFieldName(UserMedicalItem.class, UserMedicalItem::setMedicalItemId));
    assertEquals("count", getFieldName(UserMedicalItem.class, UserMedicalItem::getCount));
    assertEquals("count", getFieldName(UserMedicalItem.class, UserMedicalItem::setCount));
    assertEquals("state", getFieldName(UserMedicalItem.class, UserMedicalItem::getState));
    assertEquals("state", getFieldName(UserMedicalItem.class, UserMedicalItem::setState));
  }
}
