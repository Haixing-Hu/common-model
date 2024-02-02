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
 * Unit test of the {@link Province} class.
 *
 * @author Haixing Hu
 */
public class ProvinceTest extends ModelTestBase<Province> {

  public ProvinceTest() {
    super(Province.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Province.class, Province::getId));
    assertEquals("id", getFieldName(Province.class, Province::setId));
    assertEquals("code", getFieldName(Province.class, Province::getCode));
    assertEquals("code", getFieldName(Province.class, Province::setCode));
    assertEquals("name", getFieldName(Province.class, Province::getName));
    assertEquals("name", getFieldName(Province.class, Province::setName));
    assertEquals("country", getFieldName(Province.class, Province::getCountry));
    assertEquals("country", getFieldName(Province.class, Province::setCountry));
    assertEquals("postalcode", getFieldName(Province.class, Province::getPostalcode));
    assertEquals("postalcode", getFieldName(Province.class, Province::setPostalcode));
    assertEquals("level", getFieldName(Province.class, Province::getLevel));
    assertEquals("level", getFieldName(Province.class, Province::setLevel));
    assertEquals("icon", getFieldName(Province.class, Province::getIcon));
    assertEquals("icon", getFieldName(Province.class, Province::setIcon));
    assertEquals("url", getFieldName(Province.class, Province::getUrl));
    assertEquals("url", getFieldName(Province.class, Province::setUrl));
    assertEquals("description", getFieldName(Province.class, Province::getDescription));
    assertEquals("description", getFieldName(Province.class, Province::setDescription));
    assertEquals("predefined", getFieldName(Province.class, Province::isPredefined));
    assertEquals("predefined", getFieldName(Province.class, Province::setPredefined));
    assertEquals("createTime", getFieldName(Province.class, Province::getCreateTime));
    assertEquals("createTime", getFieldName(Province.class, Province::setCreateTime));
    assertEquals("modifyTime", getFieldName(Province.class, Province::getModifyTime));
    assertEquals("modifyTime", getFieldName(Province.class, Province::setModifyTime));
    assertEquals("deleteTime", getFieldName(Province.class, Province::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Province.class, Province::setDeleteTime));
  }
}
