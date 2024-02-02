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

public class InfoWithEntityTest extends ModelTestBase<InfoWithEntity> {

  public InfoWithEntityTest() {
    super(InfoWithEntity.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("entity", getFieldName(InfoWithEntity.class, InfoWithEntity::getEntity));
    assertEquals("entity", getFieldName(InfoWithEntity.class, InfoWithEntity::setEntity));
  }
}
