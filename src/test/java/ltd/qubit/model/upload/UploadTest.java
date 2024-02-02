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
 * Unit test of the {@link Upload} class.
 *
 * @author Haixing Hu
 */
public class UploadTest extends ModelTestBase<Upload> {

  public UploadTest() {
    super(Upload.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Upload.class, Upload::getId));
    assertEquals("id", getFieldName(Upload.class, Upload::setId));
    assertEquals("type", getFieldName(Upload.class, Upload::getType));
    assertEquals("type", getFieldName(Upload.class, Upload::setType));
    assertEquals("file", getFieldName(Upload.class, Upload::getFile));
    assertEquals("file", getFieldName(Upload.class, Upload::setFile));
    assertEquals("screenshot", getFieldName(Upload.class, Upload::getScreenshot));
    assertEquals("screenshot", getFieldName(Upload.class, Upload::setScreenshot));
    assertEquals("smallThumbnail", getFieldName(Upload.class, Upload::getSmallThumbnail));
    assertEquals("smallThumbnail", getFieldName(Upload.class, Upload::setSmallThumbnail));
    assertEquals("largeThumbnail", getFieldName(Upload.class, Upload::getLargeThumbnail));
    assertEquals("largeThumbnail", getFieldName(Upload.class, Upload::setLargeThumbnail));
    assertEquals("createTime", getFieldName(Upload.class, Upload::getCreateTime));
    assertEquals("createTime", getFieldName(Upload.class, Upload::setCreateTime));
    assertEquals("deleteTime", getFieldName(Upload.class, Upload::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Upload.class, Upload::setDeleteTime));
  }
}
