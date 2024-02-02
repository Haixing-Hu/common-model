////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.commons;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test of the {@link CredentialType} class.
 *
 * @author Haixing Hu
 */
public class CredentialTypeTest extends ModelTestBase<CredentialType> {

  public CredentialTypeTest() {
    super(CredentialType.class);
  }

  @Test
  public void testCode() {
    for (final CredentialType obj : CredentialType.values()) {
      final String code = obj.code();
      assertNotNull(code);
      System.out.println(obj.name() + ": " + code);
      final CredentialType other = CredentialType.forCode(code);
      assertEquals(obj, other);
    }
  }

  @Test
  public void testGetLocalizedName() {
    final Locale zh = Locale.SIMPLIFIED_CHINESE;
    System.out.println("============ " + zh + " ============ ");
    for (final DayType obj : DayType.values()) {
      final String name = obj.getLocalizedName(zh);
      assertNotNull(name);
      System.out.println(obj.name() + ": " + name);
    }
    final Locale en = Locale.ENGLISH;
    System.out.println("============ " + en + " ============ ");
    for (final DayType obj : DayType.values()) {
      final String name = obj.getLocalizedName(en);
      assertNotNull(name);
      System.out.println(obj.name() + ": " + name);
    }
    final Locale fr = Locale.FRANCE;
    System.out.println("============ " + fr + " ============ ");
    for (final DayType obj : DayType.values()) {
      final String name = obj.getLocalizedName(fr);
      assertEquals(obj.name(), name);
      System.out.println(obj.name() + ": " + name);
    }
  }
}
