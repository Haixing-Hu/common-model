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
 * Unit test of the {@link Faq} class.
 *
 * @author Haixing Hu
 */
public class FaqTest extends ModelTestBase<Faq> {

  public FaqTest() {
    super(Faq.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Faq.class, Faq::getId));
    assertEquals("id", getFieldName(Faq.class, Faq::setId));
    assertEquals("app", getFieldName(Faq.class, Faq::getApp));
    assertEquals("app", getFieldName(Faq.class, Faq::setApp));
    assertEquals("category", getFieldName(Faq.class, Faq::getCategory));
    assertEquals("category", getFieldName(Faq.class, Faq::setCategory));
    assertEquals("product", getFieldName(Faq.class, Faq::getProduct));
    assertEquals("product", getFieldName(Faq.class, Faq::setProduct));
    assertEquals("question", getFieldName(Faq.class, Faq::getQuestion));
    assertEquals("question", getFieldName(Faq.class, Faq::setQuestion));
    assertEquals("answer", getFieldName(Faq.class, Faq::getAnswer));
    assertEquals("answer", getFieldName(Faq.class, Faq::setAnswer));
    assertEquals("frequency", getFieldName(Faq.class, Faq::getFrequency));
    assertEquals("frequency", getFieldName(Faq.class, Faq::setFrequency));
    assertEquals("state", getFieldName(Faq.class, Faq::getState));
    assertEquals("state", getFieldName(Faq.class, Faq::setState));
    assertEquals("createTime", getFieldName(Faq.class, Faq::getCreateTime));
    assertEquals("createTime", getFieldName(Faq.class, Faq::setCreateTime));
    assertEquals("modifyTime", getFieldName(Faq.class, Faq::getModifyTime));
    assertEquals("modifyTime", getFieldName(Faq.class, Faq::setModifyTime));
    assertEquals("deleteTime", getFieldName(Faq.class, Faq::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Faq.class, Faq::setDeleteTime));
  }
}
