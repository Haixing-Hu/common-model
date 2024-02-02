////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.commons;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;
import ltd.qubit.commons.text.CaseFormat;
import ltd.qubit.commons.text.jackson.CustomizedJsonMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;
import static ltd.qubit.commons.test.json.JacksonJsonTestUtils.testJsonDeserialization;
import static ltd.qubit.commons.test.json.JacksonJsonTestUtils.testJsonSerialization;

/**
 * Unit test of the {@link App} class.
 *
 * @author Haixing Hu
 */
public class AppTest extends ModelTestBase<App> {

  public AppTest() {
    super(App.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(App.class, App::getId));
    assertEquals("id", getFieldName(App.class, App::setId));
    assertEquals("code", getFieldName(App.class, App::getCode));
    assertEquals("code", getFieldName(App.class, App::setCode));
    assertEquals("name", getFieldName(App.class, App::getName));
    assertEquals("name", getFieldName(App.class, App::setName));
    assertEquals("organization", getFieldName(App.class, App::getOrganization));
    assertEquals("organization", getFieldName(App.class, App::setOrganization));
    assertEquals("category", getFieldName(App.class, App::getCategory));
    assertEquals("category", getFieldName(App.class, App::setCategory));
    assertEquals("state", getFieldName(App.class, App::getState));
    assertEquals("state", getFieldName(App.class, App::setState));
    assertEquals("icon", getFieldName(App.class, App::getIcon));
    assertEquals("icon", getFieldName(App.class, App::setIcon));
    assertEquals("url", getFieldName(App.class, App::getUrl));
    assertEquals("url", getFieldName(App.class, App::setUrl));
    assertEquals("description", getFieldName(App.class, App::getDescription));
    assertEquals("description", getFieldName(App.class, App::setDescription));
    assertEquals("comment", getFieldName(App.class, App::getComment));
    assertEquals("comment", getFieldName(App.class, App::setComment));
    assertEquals("securityKey", getFieldName(App.class, App::getSecurityKey));
    assertEquals("securityKey", getFieldName(App.class, App::setSecurityKey));
    assertEquals("token", getFieldName(App.class, App::getToken));
    assertEquals("token", getFieldName(App.class, App::setToken));
    assertEquals("lastAuthorize", getFieldName(App.class, App::getLastAuthorize));
    assertEquals("lastAuthorize", getFieldName(App.class, App::setLastAuthorize));
    assertEquals("predefined", getFieldName(App.class, App::isPredefined));
    assertEquals("predefined", getFieldName(App.class, App::setPredefined));
    assertEquals("createTime", getFieldName(App.class, App::getCreateTime));
    assertEquals("createTime", getFieldName(App.class, App::setCreateTime));
    assertEquals("modifyTime", getFieldName(App.class, App::getModifyTime));
    assertEquals("modifyTime", getFieldName(App.class, App::setModifyTime));
    assertEquals("deleteTime", getFieldName(App.class, App::getDeleteTime));
    assertEquals("deleteTime", getFieldName(App.class, App::setDeleteTime));
  }

  @Test
  public void testJsonMapperChangeNamingStrategy() throws Exception {
    final CustomizedJsonMapper mapper = new CustomizedJsonMapper();
    mapper.setNamingStrategy(CaseFormat.LOWER_CAMEL);
    for (int i = 0; i < loops; ++i) {
      final App obj = random.nextObject(type);
      testJsonSerialization(mapper, obj);
      testJsonDeserialization(mapper, obj);
    }
  }
}
