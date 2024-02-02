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

public class AuthorizeRecordTest extends ModelTestBase<AuthorizeRecord> {

  public AuthorizeRecordTest() {
    super(AuthorizeRecord.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("failures", getFieldName(AuthorizeRecord.class, AuthorizeRecord::getFailures));
    assertEquals("failures", getFieldName(AuthorizeRecord.class, AuthorizeRecord::setFailures));
    assertEquals("time", getFieldName(AuthorizeRecord.class, AuthorizeRecord::getTime));
    assertEquals("time", getFieldName(AuthorizeRecord.class, AuthorizeRecord::setTime));
  }
}
