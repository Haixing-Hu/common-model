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
 * Unit test of the {@link FileInfo} class.
 *
 * @author Haixing Hu
 */
public class FileInfoTest extends ModelTestBase<FileInfo> {

  public FileInfoTest() {
    super(FileInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("path", getFieldName(FileInfo.class, FileInfo::getPath));
    assertEquals("path", getFieldName(FileInfo.class, FileInfo::setPath));
    assertEquals("format", getFieldName(FileInfo.class, FileInfo::getFormat));
    assertEquals("format", getFieldName(FileInfo.class, FileInfo::setFormat));
    assertEquals("contentType", getFieldName(FileInfo.class, FileInfo::getContentType));
    assertEquals("contentType", getFieldName(FileInfo.class, FileInfo::setContentType));
    assertEquals("size", getFieldName(FileInfo.class, FileInfo::getSize));
    assertEquals("size", getFieldName(FileInfo.class, FileInfo::setSize));
    assertEquals("width", getFieldName(FileInfo.class, FileInfo::getWidth));
    assertEquals("width", getFieldName(FileInfo.class, FileInfo::setWidth));
    assertEquals("height", getFieldName(FileInfo.class, FileInfo::getHeight));
    assertEquals("height", getFieldName(FileInfo.class, FileInfo::setHeight));
    assertEquals("duration", getFieldName(FileInfo.class, FileInfo::getDuration));
    assertEquals("duration", getFieldName(FileInfo.class, FileInfo::setDuration));
    assertEquals("quality", getFieldName(FileInfo.class, FileInfo::getQuality));
    assertEquals("quality", getFieldName(FileInfo.class, FileInfo::setQuality));
  }
}
