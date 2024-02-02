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
 * Unit test of the {@link City} class.
 *
 * @author Haixing Hu
 */
public class CityTest extends ModelTestBase<City> {

  public CityTest() {
    super(City.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(City.class, City::getId));
    assertEquals("id", getFieldName(City.class, City::setId));
    assertEquals("code", getFieldName(City.class, City::getCode));
    assertEquals("code", getFieldName(City.class, City::setCode));
    assertEquals("name", getFieldName(City.class, City::getName));
    assertEquals("name", getFieldName(City.class, City::setName));
    assertEquals("province", getFieldName(City.class, City::getProvince));
    assertEquals("province", getFieldName(City.class, City::setProvince));
    assertEquals("phoneArea", getFieldName(City.class, City::getPhoneArea));
    assertEquals("phoneArea", getFieldName(City.class, City::setPhoneArea));
    assertEquals("postalcode", getFieldName(City.class, City::getPostalcode));
    assertEquals("postalcode", getFieldName(City.class, City::setPostalcode));
    assertEquals("level", getFieldName(City.class, City::getLevel));
    assertEquals("level", getFieldName(City.class, City::setLevel));
    assertEquals("icon", getFieldName(City.class, City::getIcon));
    assertEquals("icon", getFieldName(City.class, City::setIcon));
    assertEquals("url", getFieldName(City.class, City::getUrl));
    assertEquals("url", getFieldName(City.class, City::setUrl));
    assertEquals("description", getFieldName(City.class, City::getDescription));
    assertEquals("description", getFieldName(City.class, City::setDescription));
    assertEquals("location", getFieldName(City.class, City::getLocation));
    assertEquals("location", getFieldName(City.class, City::setLocation));
    assertEquals("predefined", getFieldName(City.class, City::isPredefined));
    assertEquals("predefined", getFieldName(City.class, City::setPredefined));
    assertEquals("createTime", getFieldName(City.class, City::getCreateTime));
    assertEquals("createTime", getFieldName(City.class, City::setCreateTime));
    assertEquals("modifyTime", getFieldName(City.class, City::getModifyTime));
    assertEquals("modifyTime", getFieldName(City.class, City::setModifyTime));
    assertEquals("deleteTime", getFieldName(City.class, City::getDeleteTime));
    assertEquals("deleteTime", getFieldName(City.class, City::setDeleteTime));
  }
}
