////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test of the {@link PaymentType} class.
 *
 * @author Haixing Hu
 */
public class PaymentTypeTest extends ModelTestBase<PaymentType> {

  public PaymentTypeTest() {
    super(PaymentType.class);
  }

  @Test
  public void testGetLocalizedName() {
    final Locale zh = Locale.SIMPLIFIED_CHINESE;
    System.out.println("============ " + zh + " ============ ");
    for (final PaymentType obj : PaymentType.values()) {
      final String name = obj.getLocalizedName(zh);
      assertNotNull(name);
      System.out.println(obj.name() + ": " + name);
    }
    final Locale en = Locale.ENGLISH;
    System.out.println("============ " + en + " ============ ");
    for (final PaymentType obj : PaymentType.values()) {
      final String name = obj.getLocalizedName(en);
      assertNotNull(name);
      System.out.println(obj.name() + ": " + name);
    }
    final Locale fr = Locale.FRANCE;
    System.out.println("============ " + fr + " ============ ");
    for (final PaymentType obj : PaymentType.values()) {
      final String name = obj.getLocalizedName(fr);
      assertEquals(obj.name(), name);
      System.out.println(obj.name() + ": " + name);
    }
  }
}
