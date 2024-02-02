////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.china;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdentityCardUtilsTest {

  @Test
  public void testValidate() {
    assertEquals(true, IdentityCardUtils.validate("320114197001160058"));
    assertEquals(true, IdentityCardUtils.validate("32128319931103141X"));
    assertEquals(true, IdentityCardUtils.validate("32128319931103141x"));
    assertEquals(false, IdentityCardUtils.validate("320114197001160059"));
    assertEquals(false, IdentityCardUtils.validate("32128319931103141y"));
    assertEquals(false, IdentityCardUtils.validate("320114197013160058"));
    assertEquals(false, IdentityCardUtils.validate("320114197002290058"));
  }

  @Test
  public void bug_1() {
    // FIXME:
    assertEquals(true, IdentityCardUtils.validate("320121194905121510"));
  }

  @Test
  public void bug_2() {
    // FIXME:
    assertEquals(true, IdentityCardUtils.validate("320121196612114711"));
  }

  @Test
  public void bug_old_area() {
    assertEquals(true, IdentityCardUtils.validate("320121196612114711"));
  }
}
