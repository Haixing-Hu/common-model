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
 * Unit test of the {@link Code} class.
 *
 * @author Haixing Hu
 */
public class CodeTest extends ModelTestBase<Code> {

  public CodeTest() {
    super(Code.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("app", getFieldName(Code.class, Code::getApp));
    assertEquals("app", getFieldName(Code.class, Code::setApp));
    assertEquals("standard", getFieldName(Code.class, Code::getStandard));
    assertEquals("standard", getFieldName(Code.class, Code::setStandard));
    assertEquals("code", getFieldName(Code.class, Code::getCode));
    assertEquals("code", getFieldName(Code.class, Code::setCode));
  }
}
