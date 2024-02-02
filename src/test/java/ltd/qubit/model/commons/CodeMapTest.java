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
 * Unit test of the {@link CodeMap} class.
 *
 * @author Haixing Hu
 */
public class CodeMapTest extends ModelTestBase<CodeMap> {

  public CodeMapTest() {
    super(CodeMap.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(CodeMap.class, CodeMap::getId));
    assertEquals("id", getFieldName(CodeMap.class, CodeMap::setId));
    assertEquals("entity", getFieldName(CodeMap.class, CodeMap::getEntity));
    assertEquals("entity", getFieldName(CodeMap.class, CodeMap::setEntity));
    assertEquals("source", getFieldName(CodeMap.class, CodeMap::getSource));
    assertEquals("source", getFieldName(CodeMap.class, CodeMap::setSource));
    assertEquals("platformCode", getFieldName(CodeMap.class, CodeMap::getPlatformCode));
    assertEquals("platformCode", getFieldName(CodeMap.class, CodeMap::setPlatformCode));
    assertEquals("createTime", getFieldName(CodeMap.class, CodeMap::getCreateTime));
    assertEquals("createTime", getFieldName(CodeMap.class, CodeMap::setCreateTime));
    assertEquals("modifyTime", getFieldName(CodeMap.class, CodeMap::getModifyTime));
    assertEquals("modifyTime", getFieldName(CodeMap.class, CodeMap::setModifyTime));
    assertEquals("deleteTime", getFieldName(CodeMap.class, CodeMap::getDeleteTime));
    assertEquals("deleteTime", getFieldName(CodeMap.class, CodeMap::setDeleteTime));
  }
}
