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
 * Unit test of the {@link MedicalPackageItem} class.
 *
 * @author Haixing Hu
 */
public class MedicalPackageItemTest extends ModelTestBase<MedicalPackageItem> {

  public MedicalPackageItemTest() {
    super(MedicalPackageItem.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("packageId", getFieldName(MedicalPackageItem.class, MedicalPackageItem::getPackageId));
    assertEquals("packageId", getFieldName(MedicalPackageItem.class, MedicalPackageItem::setPackageId));
    assertEquals("item", getFieldName(MedicalPackageItem.class, MedicalPackageItem::getItem));
    assertEquals("item", getFieldName(MedicalPackageItem.class, MedicalPackageItem::setItem));
    assertEquals("count", getFieldName(MedicalPackageItem.class, MedicalPackageItem::getCount));
    assertEquals("count", getFieldName(MedicalPackageItem.class, MedicalPackageItem::setCount));
  }
}
