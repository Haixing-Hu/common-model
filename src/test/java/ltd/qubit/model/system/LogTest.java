////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.system;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Log} class.
 *
 * @author Haixing Hu
 */
public class LogTest extends ModelTestBase<Log> {

  public LogTest() {
    super(Log.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Log.class, Log::getId));
    assertEquals("id", getFieldName(Log.class, Log::setId));
    assertEquals("timestamp", getFieldName(Log.class, Log::getTimestamp));
    assertEquals("timestamp", getFieldName(Log.class, Log::setTimestamp));
    assertEquals("operator", getFieldName(Log.class, Log::getOperator));
    assertEquals("operator", getFieldName(Log.class, Log::setOperator));
    assertEquals("ip", getFieldName(Log.class, Log::getIp));
    assertEquals("ip", getFieldName(Log.class, Log::setIp));
    assertEquals("operation", getFieldName(Log.class, Log::getOperation));
    assertEquals("operation", getFieldName(Log.class, Log::setOperation));
    assertEquals("targetType", getFieldName(Log.class, Log::getTargetType));
    assertEquals("targetType", getFieldName(Log.class, Log::setTargetType));
    assertEquals("targetId", getFieldName(Log.class, Log::getTargetId));
    assertEquals("targetId", getFieldName(Log.class, Log::setTargetId));
    assertEquals("success", getFieldName(Log.class, Log::isSuccess));
    assertEquals("success", getFieldName(Log.class, Log::setSuccess));
    assertEquals("error", getFieldName(Log.class, Log::getError));
    assertEquals("error", getFieldName(Log.class, Log::setError));
  }
}
