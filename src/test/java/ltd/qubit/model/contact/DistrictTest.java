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
 * Unit test of the {@link District} class.
 *
 * @author Haixing Hu
 */
public class DistrictTest extends ModelTestBase<District> {

  public DistrictTest() {
    super(District.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(District.class, District::getId));
    assertEquals("id", getFieldName(District.class, District::setId));
    assertEquals("code", getFieldName(District.class, District::getCode));
    assertEquals("code", getFieldName(District.class, District::setCode));
    assertEquals("name", getFieldName(District.class, District::getName));
    assertEquals("name", getFieldName(District.class, District::setName));
    assertEquals("city", getFieldName(District.class, District::getCity));
    assertEquals("city", getFieldName(District.class, District::setCity));
    assertEquals("level", getFieldName(District.class, District::getLevel));
    assertEquals("level", getFieldName(District.class, District::setLevel));
    assertEquals("postalcode", getFieldName(District.class, District::getPostalcode));
    assertEquals("postalcode", getFieldName(District.class, District::setPostalcode));
    assertEquals("icon", getFieldName(District.class, District::getIcon));
    assertEquals("icon", getFieldName(District.class, District::setIcon));
    assertEquals("url", getFieldName(District.class, District::getUrl));
    assertEquals("url", getFieldName(District.class, District::setUrl));
    assertEquals("description", getFieldName(District.class, District::getDescription));
    assertEquals("description", getFieldName(District.class, District::setDescription));
    assertEquals("location", getFieldName(District.class, District::getLocation));
    assertEquals("location", getFieldName(District.class, District::setLocation));
    assertEquals("predefined", getFieldName(District.class, District::isPredefined));
    assertEquals("predefined", getFieldName(District.class, District::setPredefined));
    assertEquals("createTime", getFieldName(District.class, District::getCreateTime));
    assertEquals("createTime", getFieldName(District.class, District::setCreateTime));
    assertEquals("modifyTime", getFieldName(District.class, District::getModifyTime));
    assertEquals("modifyTime", getFieldName(District.class, District::setModifyTime));
    assertEquals("deleteTime", getFieldName(District.class, District::getDeleteTime));
    assertEquals("deleteTime", getFieldName(District.class, District::setDeleteTime));
  }
}
