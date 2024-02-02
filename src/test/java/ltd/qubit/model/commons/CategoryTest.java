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
 * Unit test of the {@link Category} class.
 *
 * @author Haixing Hu
 */
public class CategoryTest extends ModelTestBase<Category> {

  public CategoryTest() {
    super(Category.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Category.class, Category::getId));
    assertEquals("id", getFieldName(Category.class, Category::setId));
    assertEquals("entity", getFieldName(Category.class, Category::getEntity));
    assertEquals("entity", getFieldName(Category.class, Category::setEntity));
    assertEquals("code", getFieldName(Category.class, Category::getCode));
    assertEquals("code", getFieldName(Category.class, Category::setCode));
    assertEquals("name", getFieldName(Category.class, Category::getName));
    assertEquals("name", getFieldName(Category.class, Category::setName));
    assertEquals("icon", getFieldName(Category.class, Category::getIcon));
    assertEquals("icon", getFieldName(Category.class, Category::setIcon));
    assertEquals("description", getFieldName(Category.class, Category::getDescription));
    assertEquals("description", getFieldName(Category.class, Category::setDescription));
    assertEquals("title", getFieldName(Category.class, Category::getTitle));
    assertEquals("title", getFieldName(Category.class, Category::setTitle));
    assertEquals("parent", getFieldName(Category.class, Category::getParent));
    assertEquals("parent", getFieldName(Category.class, Category::setParent));
    assertEquals("predefined", getFieldName(Category.class, Category::isPredefined));
    assertEquals("predefined", getFieldName(Category.class, Category::setPredefined));
    assertEquals("createTime", getFieldName(Category.class, Category::getCreateTime));
    assertEquals("createTime", getFieldName(Category.class, Category::setCreateTime));
    assertEquals("modifyTime", getFieldName(Category.class, Category::getModifyTime));
    assertEquals("modifyTime", getFieldName(Category.class, Category::setModifyTime));
    assertEquals("deleteTime", getFieldName(Category.class, Category::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Category.class, Category::setDeleteTime));
  }
}
