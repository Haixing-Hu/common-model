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
 * Unit test of the {@link Source} class.
 *
 * @author Haixing Hu
 */
public class SourceTest extends ModelTestBase<Source> {

  public SourceTest() {
    super(Source.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Source.class, Source::getId));
    assertEquals("id", getFieldName(Source.class, Source::setId));
    assertEquals("app", getFieldName(Source.class, Source::getApp));
    assertEquals("app", getFieldName(Source.class, Source::setApp));
    assertEquals("entity", getFieldName(Source.class, Source::getEntity));
    assertEquals("entity", getFieldName(Source.class, Source::setEntity));
    assertEquals("code", getFieldName(Source.class, Source::getCode));
    assertEquals("code", getFieldName(Source.class, Source::setCode));
    assertEquals("name", getFieldName(Source.class, Source::getName));
    assertEquals("name", getFieldName(Source.class, Source::setName));
    assertEquals("description", getFieldName(Source.class, Source::getDescription));
    assertEquals("description", getFieldName(Source.class, Source::setDescription));
    assertEquals("category", getFieldName(Source.class, Source::getCategory));
    assertEquals("category", getFieldName(Source.class, Source::setCategory));
    assertEquals("providerApp", getFieldName(Source.class, Source::getProviderApp));
    assertEquals("providerApp", getFieldName(Source.class, Source::setProviderApp));
    assertEquals("providerOrg", getFieldName(Source.class, Source::getProviderOrg));
    assertEquals("providerOrg", getFieldName(Source.class, Source::setProviderOrg));
    assertEquals("predefined", getFieldName(Source.class, Source::isPredefined));
    assertEquals("predefined", getFieldName(Source.class, Source::setPredefined));
    assertEquals("createTime", getFieldName(Source.class, Source::getCreateTime));
    assertEquals("createTime", getFieldName(Source.class, Source::setCreateTime));
    assertEquals("modifyTime", getFieldName(Source.class, Source::getModifyTime));
    assertEquals("modifyTime", getFieldName(Source.class, Source::setModifyTime));
    assertEquals("deleteTime", getFieldName(Source.class, Source::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Source.class, Source::setDeleteTime));
  }
}
