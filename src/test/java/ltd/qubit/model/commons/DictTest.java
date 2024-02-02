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

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Dict} class.
 *
 * @author Haixing Hu
 */
public class DictTest extends ModelTestBase<Dict> {

  public DictTest() {
    super(Dict.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Dict.class, Dict::getId));
    assertEquals("id", getFieldName(Dict.class, Dict::setId));
    assertEquals("code", getFieldName(Dict.class, Dict::getCode));
    assertEquals("code", getFieldName(Dict.class, Dict::setCode));
    assertEquals("name", getFieldName(Dict.class, Dict::getName));
    assertEquals("name", getFieldName(Dict.class, Dict::setName));
    assertEquals("standardDoc", getFieldName(Dict.class, Dict::getStandardDoc));
    assertEquals("standardDoc", getFieldName(Dict.class, Dict::setStandardDoc));
    assertEquals("standardCode", getFieldName(Dict.class, Dict::getStandardCode));
    assertEquals("standardCode", getFieldName(Dict.class, Dict::setStandardCode));
    assertEquals("url", getFieldName(Dict.class, Dict::getUrl));
    assertEquals("url", getFieldName(Dict.class, Dict::setUrl));
    assertEquals("description", getFieldName(Dict.class, Dict::getDescription));
    assertEquals("description", getFieldName(Dict.class, Dict::setDescription));
    assertEquals("comment", getFieldName(Dict.class, Dict::getComment));
    assertEquals("comment", getFieldName(Dict.class, Dict::setComment));
    assertEquals("app", getFieldName(Dict.class, Dict::getApp));
    assertEquals("app", getFieldName(Dict.class, Dict::setApp));
    assertEquals("category", getFieldName(Dict.class, Dict::getCategory));
    assertEquals("category", getFieldName(Dict.class, Dict::setCategory));
    assertEquals("state", getFieldName(Dict.class, Dict::getState));
    assertEquals("state", getFieldName(Dict.class, Dict::setState));
    assertEquals("predefined", getFieldName(Dict.class, Dict::isPredefined));
    assertEquals("predefined", getFieldName(Dict.class, Dict::setPredefined));
    assertEquals("createTime", getFieldName(Dict.class, Dict::getCreateTime));
    assertEquals("createTime", getFieldName(Dict.class, Dict::setCreateTime));
    assertEquals("modifyTime", getFieldName(Dict.class, Dict::getModifyTime));
    assertEquals("modifyTime", getFieldName(Dict.class, Dict::setModifyTime));
    assertEquals("deleteTime", getFieldName(Dict.class, Dict::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Dict.class, Dict::setDeleteTime));
  }
}
