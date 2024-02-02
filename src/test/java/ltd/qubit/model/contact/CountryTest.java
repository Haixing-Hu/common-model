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
 * Unit test of the {@link Country} class.
 *
 * @author Haixing Hu
 */
public class CountryTest extends ModelTestBase<Country> {

  public CountryTest() {
    super(Country.class);
  }

  @Test
  public void testCopyConstructor() {
    for (int i = 0; i < DEFAULT_TEST_LOOPS; ++i) {
      final Country c1 = random.nextObject(Country.class);
      final Country c2 = new Country(c1);
      assertEquals(c1, c2);
    }
  }

  @Test
  public void testClone() {
    for (int i = 0; i < DEFAULT_TEST_LOOPS; ++i) {
      final Country c1 = random.nextObject(Country.class);
      final Country c2 = c1.clone();
      assertEquals(c1, c2);
    }
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Country.class, Country::getId));
    assertEquals("id", getFieldName(Country.class, Country::setId));
    assertEquals("code", getFieldName(Country.class, Country::getCode));
    assertEquals("code", getFieldName(Country.class, Country::setCode));
    assertEquals("name", getFieldName(Country.class, Country::getName));
    assertEquals("name", getFieldName(Country.class, Country::setName));
    assertEquals("phoneArea", getFieldName(Country.class, Country::getPhoneArea));
    assertEquals("phoneArea", getFieldName(Country.class, Country::setPhoneArea));
    assertEquals("postalcode", getFieldName(Country.class, Country::getPostalcode));
    assertEquals("postalcode", getFieldName(Country.class, Country::setPostalcode));
    assertEquals("icon", getFieldName(Country.class, Country::getIcon));
    assertEquals("icon", getFieldName(Country.class, Country::setIcon));
    assertEquals("url", getFieldName(Country.class, Country::getUrl));
    assertEquals("url", getFieldName(Country.class, Country::setUrl));
    assertEquals("description", getFieldName(Country.class, Country::getDescription));
    assertEquals("description", getFieldName(Country.class, Country::setDescription));
    assertEquals("predefined", getFieldName(Country.class, Country::isPredefined));
    assertEquals("predefined", getFieldName(Country.class, Country::setPredefined));
    assertEquals("createTime", getFieldName(Country.class, Country::getCreateTime));
    assertEquals("createTime", getFieldName(Country.class, Country::setCreateTime));
    assertEquals("modifyTime", getFieldName(Country.class, Country::getModifyTime));
    assertEquals("modifyTime", getFieldName(Country.class, Country::setModifyTime));
    assertEquals("deleteTime", getFieldName(Country.class, Country::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Country.class, Country::setDeleteTime));
  }
}
