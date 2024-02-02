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
 * Unit test of the {@link Token} class.
 *
 * @author Haixing Hu
 */
public class TokenTest extends ModelTestBase<Token>{

  public TokenTest() {
    super(Token.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("value", getFieldName(Token.class, Token::getValue));
    assertEquals("value", getFieldName(Token.class, Token::setValue));
    assertEquals("createTime", getFieldName(Token.class, Token::getCreateTime));
    assertEquals("createTime", getFieldName(Token.class, Token::setCreateTime));
    assertEquals("maxAge", getFieldName(Token.class, Token::getMaxAge));
    assertEquals("maxAge", getFieldName(Token.class, Token::setMaxAge));
    assertEquals("previousValue", getFieldName(Token.class, Token::getPreviousValue));
    assertEquals("previousValue", getFieldName(Token.class, Token::setPreviousValue));
  }
}
