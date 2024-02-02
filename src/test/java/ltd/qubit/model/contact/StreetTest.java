////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.contact;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Street} class.
 *
 * @author Haixing Hu
 */
public class StreetTest extends ModelTestBase<Street> {

  public StreetTest() {
    super(Street.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Street.class, Street::getId));
    assertEquals("id", getFieldName(Street.class, Street::setId));
    assertEquals("code", getFieldName(Street.class, Street::getCode));
    assertEquals("code", getFieldName(Street.class, Street::setCode));
    assertEquals("name", getFieldName(Street.class, Street::getName));
    assertEquals("name", getFieldName(Street.class, Street::setName));
    assertEquals("district", getFieldName(Street.class, Street::getDistrict));
    assertEquals("district", getFieldName(Street.class, Street::setDistrict));
    assertEquals("level", getFieldName(Street.class, Street::getLevel));
    assertEquals("level", getFieldName(Street.class, Street::setLevel));
    assertEquals("postalcode", getFieldName(Street.class, Street::getPostalcode));
    assertEquals("postalcode", getFieldName(Street.class, Street::setPostalcode));
    assertEquals("icon", getFieldName(Street.class, Street::getIcon));
    assertEquals("icon", getFieldName(Street.class, Street::setIcon));
    assertEquals("url", getFieldName(Street.class, Street::getUrl));
    assertEquals("url", getFieldName(Street.class, Street::setUrl));
    assertEquals("description", getFieldName(Street.class, Street::getDescription));
    assertEquals("description", getFieldName(Street.class, Street::setDescription));
    assertEquals("location", getFieldName(Street.class, Street::getLocation));
    assertEquals("location", getFieldName(Street.class, Street::setLocation));
    assertEquals("predefined", getFieldName(Street.class, Street::isPredefined));
    assertEquals("predefined", getFieldName(Street.class, Street::setPredefined));
    assertEquals("createTime", getFieldName(Street.class, Street::getCreateTime));
    assertEquals("createTime", getFieldName(Street.class, Street::setCreateTime));
    assertEquals("modifyTime", getFieldName(Street.class, Street::getModifyTime));
    assertEquals("modifyTime", getFieldName(Street.class, Street::setModifyTime));
    assertEquals("deleteTime", getFieldName(Street.class, Street::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Street.class, Street::setDeleteTime));
  }
}
