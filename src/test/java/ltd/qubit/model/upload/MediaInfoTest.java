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
 * Unit test of the {@link MediaInfo} class.
 *
 * @author Haixing Hu
 */
public class MediaInfoTest extends ModelTestBase<MediaInfo> {

  public MediaInfoTest() {
    super(MediaInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("type", getFieldName(MediaInfo.class, MediaInfo::getType));
    assertEquals("type", getFieldName(MediaInfo.class, MediaInfo::setType));
    assertEquals("size", getFieldName(MediaInfo.class, MediaInfo::getSize));
    assertEquals("size", getFieldName(MediaInfo.class, MediaInfo::setSize));
    assertEquals("screen", getFieldName(MediaInfo.class, MediaInfo::getScreen));
    assertEquals("screen", getFieldName(MediaInfo.class, MediaInfo::setScreen));
    assertEquals("duration", getFieldName(MediaInfo.class, MediaInfo::getDuration));
    assertEquals("duration", getFieldName(MediaInfo.class, MediaInfo::setDuration));
  }
}
