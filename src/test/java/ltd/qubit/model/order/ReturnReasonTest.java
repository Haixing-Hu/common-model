////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test of the {@link ReturnReason} class.
 *
 * @author Haixing Hu
 */
public class ReturnReasonTest extends ModelTestBase<ReturnReason> {

  public ReturnReasonTest() {
    super(ReturnReason.class);
  }

  @Test
  public void testGetLocalizedName() {
    final Locale zh = Locale.SIMPLIFIED_CHINESE;
    System.out.println("============ " + zh + " ============ ");
    for (final ReturnReason obj : ReturnReason.values()) {
      final String name = obj.getLocalizedName(zh);
      assertNotNull(name);
      System.out.println(obj.name() + ": " + name);
    }
    final Locale en = Locale.ENGLISH;
    System.out.println("============ " + en + " ============ ");
    for (final ReturnReason obj : ReturnReason.values()) {
      final String name = obj.getLocalizedName(en);
      assertNotNull(name);
      System.out.println(obj.name() + ": " + name);
    }
    final Locale fr = Locale.FRANCE;
    System.out.println("============ " + fr + " ============ ");
    for (final ReturnReason obj : ReturnReason.values()) {
      final String name = obj.getLocalizedName(fr);
      assertEquals(obj.name(), name);
      System.out.println(obj.name() + ": " + name);
    }
  }
}
