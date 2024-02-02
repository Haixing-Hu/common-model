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
 * Unit test of the {@link DictEntry} class.
 *
 * @author Haixing Hu
 */
public class DictEntryTest extends ModelTestBase<DictEntry> {

  public DictEntryTest() {
    super(DictEntry.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(DictEntry.class, DictEntry::getId));
    assertEquals("id", getFieldName(DictEntry.class, DictEntry::setId));
    assertEquals("dict", getFieldName(DictEntry.class, DictEntry::getDict));
    assertEquals("dict", getFieldName(DictEntry.class, DictEntry::setDict));
    assertEquals("code", getFieldName(DictEntry.class, DictEntry::getCode));
    assertEquals("code", getFieldName(DictEntry.class, DictEntry::setCode));
    assertEquals("name", getFieldName(DictEntry.class, DictEntry::getName));
    assertEquals("name", getFieldName(DictEntry.class, DictEntry::setName));
    assertEquals("description", getFieldName(DictEntry.class, DictEntry::getDescription));
    assertEquals("description", getFieldName(DictEntry.class, DictEntry::setDescription));
    assertEquals("comment", getFieldName(DictEntry.class, DictEntry::getComment));
    assertEquals("comment", getFieldName(DictEntry.class, DictEntry::setComment));
    assertEquals("parent", getFieldName(DictEntry.class, DictEntry::getParent));
    assertEquals("parent", getFieldName(DictEntry.class, DictEntry::setParent));
    assertEquals("createTime", getFieldName(DictEntry.class, DictEntry::getCreateTime));
    assertEquals("createTime", getFieldName(DictEntry.class, DictEntry::setCreateTime));
    assertEquals("modifyTime", getFieldName(DictEntry.class, DictEntry::getModifyTime));
    assertEquals("modifyTime", getFieldName(DictEntry.class, DictEntry::setModifyTime));
    assertEquals("deleteTime", getFieldName(DictEntry.class, DictEntry::getDeleteTime));
    assertEquals("deleteTime", getFieldName(DictEntry.class, DictEntry::setDeleteTime));
  }
}
