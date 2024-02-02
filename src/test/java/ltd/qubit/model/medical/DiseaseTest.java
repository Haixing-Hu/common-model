////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Disease} class.
 *
 * @author Haixing Hu
 */
public class DiseaseTest extends ModelTestBase<Disease> {

  public DiseaseTest() {
    super(Disease.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Disease.class, Disease::getId));
    assertEquals("id", getFieldName(Disease.class, Disease::setId));
    assertEquals("code", getFieldName(Disease.class, Disease::getCode));
    assertEquals("code", getFieldName(Disease.class, Disease::setCode));
    assertEquals("name", getFieldName(Disease.class, Disease::getName));
    assertEquals("name", getFieldName(Disease.class, Disease::setName));
    assertEquals("category", getFieldName(Disease.class, Disease::getCategory));
    assertEquals("category", getFieldName(Disease.class, Disease::setCategory));
    assertEquals("description", getFieldName(Disease.class, Disease::getDescription));
    assertEquals("description", getFieldName(Disease.class, Disease::setDescription));
    assertEquals("url", getFieldName(Disease.class, Disease::getUrl));
    assertEquals("url", getFieldName(Disease.class, Disease::setUrl));
    assertEquals("comment", getFieldName(Disease.class, Disease::getComment));
    assertEquals("comment", getFieldName(Disease.class, Disease::setComment));
    assertEquals("predefined", getFieldName(Disease.class, Disease::isPredefined));
    assertEquals("predefined", getFieldName(Disease.class, Disease::setPredefined));
    assertEquals("createTime", getFieldName(Disease.class, Disease::getCreateTime));
    assertEquals("createTime", getFieldName(Disease.class, Disease::setCreateTime));
    assertEquals("modifyTime", getFieldName(Disease.class, Disease::getModifyTime));
    assertEquals("modifyTime", getFieldName(Disease.class, Disease::setModifyTime));
    assertEquals("deleteTime", getFieldName(Disease.class, Disease::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Disease.class, Disease::setDeleteTime));
  }
}
