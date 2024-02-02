////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

public class InfoWithAppEntityTest extends ModelTestBase<InfoWithAppEntity> {

  public InfoWithAppEntityTest() {
    super(InfoWithAppEntity.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("app", getFieldName(InfoWithAppEntity.class, InfoWithAppEntity::getApp));
    assertEquals("app", getFieldName(InfoWithAppEntity.class, InfoWithAppEntity::setApp));
    assertEquals("entity", getFieldName(InfoWithAppEntity.class, InfoWithAppEntity::getEntity));
    assertEquals("entity", getFieldName(InfoWithAppEntity.class, InfoWithAppEntity::setEntity));
  }
}
