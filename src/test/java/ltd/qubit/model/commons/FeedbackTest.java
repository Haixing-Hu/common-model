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
 * Unit test of the {@link Feedback} class.
 *
 * @author Haixing Hu
 */
public class FeedbackTest extends ModelTestBase<Feedback> {

  public FeedbackTest() {
    super(Feedback.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Feedback.class, Feedback::getId));
    assertEquals("id", getFieldName(Feedback.class, Feedback::setId));
    assertEquals("type", getFieldName(Feedback.class, Feedback::getType));
    assertEquals("type", getFieldName(Feedback.class, Feedback::setType));
    assertEquals("item", getFieldName(Feedback.class, Feedback::getItem));
    assertEquals("item", getFieldName(Feedback.class, Feedback::setItem));
    assertEquals("comment", getFieldName(Feedback.class, Feedback::getComment));
    assertEquals("comment", getFieldName(Feedback.class, Feedback::setComment));
    assertEquals("ownerType", getFieldName(Feedback.class, Feedback::getOwnerType));
    assertEquals("ownerType", getFieldName(Feedback.class, Feedback::setOwnerType));
    assertEquals("ownerId", getFieldName(Feedback.class, Feedback::getOwnerId));
    assertEquals("ownerId", getFieldName(Feedback.class, Feedback::setOwnerId));
    assertEquals("clientId", getFieldName(Feedback.class, Feedback::getClientId));
    assertEquals("clientId", getFieldName(Feedback.class, Feedback::setClientId));
    assertEquals("createTime", getFieldName(Feedback.class, Feedback::getCreateTime));
    assertEquals("createTime", getFieldName(Feedback.class, Feedback::setCreateTime));
    assertEquals("modifyTime", getFieldName(Feedback.class, Feedback::getModifyTime));
    assertEquals("modifyTime", getFieldName(Feedback.class, Feedback::setModifyTime));
    assertEquals("deleteTime", getFieldName(Feedback.class, Feedback::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Feedback.class, Feedback::setDeleteTime));
  }
}
