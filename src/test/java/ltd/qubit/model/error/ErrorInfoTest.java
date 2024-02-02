////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.error;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.error.ErrorInfo;
import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link ErrorInfo} class.
 *
 * @author Haixing Hu
 */
public class ErrorInfoTest extends ModelTestBase<ErrorInfo> {

  public ErrorInfoTest() {
    super(ErrorInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("type", getFieldName(ErrorInfo.class, ErrorInfo::getType));
    assertEquals("type", getFieldName(ErrorInfo.class, ErrorInfo::setType));
    assertEquals("code", getFieldName(ErrorInfo.class, ErrorInfo::getCode));
    assertEquals("code", getFieldName(ErrorInfo.class, ErrorInfo::setCode));
    assertEquals("message", getFieldName(ErrorInfo.class, ErrorInfo::getMessage));
    assertEquals("message", getFieldName(ErrorInfo.class, ErrorInfo::setMessage));
    assertEquals("params", getFieldName(ErrorInfo.class, ErrorInfo::getParams));
    assertEquals("params", getFieldName(ErrorInfo.class, ErrorInfo::setParams));
  }
}
