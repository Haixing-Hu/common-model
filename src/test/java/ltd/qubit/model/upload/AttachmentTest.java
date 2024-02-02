////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.upload;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Attachment} class.
 *
 * @author Haixing Hu
 */
public class AttachmentTest extends ModelTestBase<Attachment> {

  public AttachmentTest() {
    super(Attachment.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Attachment.class, Attachment::getId));
    assertEquals("id", getFieldName(Attachment.class, Attachment::setId));
    assertEquals("owner", getFieldName(Attachment.class, Attachment::getOwner));
    assertEquals("owner", getFieldName(Attachment.class, Attachment::setOwner));
    assertEquals("type", getFieldName(Attachment.class, Attachment::getType));
    assertEquals("type", getFieldName(Attachment.class, Attachment::setType));
    assertEquals("category", getFieldName(Attachment.class, Attachment::getCategory));
    assertEquals("category", getFieldName(Attachment.class, Attachment::setCategory));
    assertEquals("index", getFieldName(Attachment.class, Attachment::getIndex));
    assertEquals("index", getFieldName(Attachment.class, Attachment::setIndex));
    assertEquals("title", getFieldName(Attachment.class, Attachment::getTitle));
    assertEquals("title", getFieldName(Attachment.class, Attachment::setTitle));
    assertEquals("description", getFieldName(Attachment.class, Attachment::getDescription));
    assertEquals("description", getFieldName(Attachment.class, Attachment::setDescription));
    assertEquals("upload", getFieldName(Attachment.class, Attachment::getUpload));
    assertEquals("upload", getFieldName(Attachment.class, Attachment::setUpload));
    assertEquals("state", getFieldName(Attachment.class, Attachment::getState));
    assertEquals("state", getFieldName(Attachment.class, Attachment::setState));
    assertEquals("visible", getFieldName(Attachment.class, Attachment::isVisible));
    assertEquals("visible", getFieldName(Attachment.class, Attachment::isVisible));
    assertEquals("createTime", getFieldName(Attachment.class, Attachment::getCreateTime));
    assertEquals("createTime", getFieldName(Attachment.class, Attachment::setCreateTime));
    assertEquals("modifyTime", getFieldName(Attachment.class, Attachment::getModifyTime));
    assertEquals("modifyTime", getFieldName(Attachment.class, Attachment::setModifyTime));
    assertEquals("deleteTime", getFieldName(Attachment.class, Attachment::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Attachment.class, Attachment::setDeleteTime));
  }
}
