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
 * Unit test of the {@link ParticipantType} class.
 *
 * @author Haixing Hu
 */
public class ParticipantTypeTest extends ModelTestBase<ParticipantType> {

  public ParticipantTypeTest() {
    super(ParticipantType.class);
  }

  @Test
  public void testGetLocalizedName() {
    final Locale zh = Locale.SIMPLIFIED_CHINESE;
    System.out.println("============ " + zh + " ============ ");
    for (final ParticipantType obj : ParticipantType.values()) {
      final String name = obj.getLocalizedName(zh);
      assertNotNull(name);
      System.out.println(obj.name() + ": " + name);
    }
    final Locale en = Locale.ENGLISH;
    System.out.println("============ " + en + " ============ ");
    for (final ParticipantType obj : ParticipantType.values()) {
      final String name = obj.getLocalizedName(en);
      assertNotNull(name);
      System.out.println(obj.name() + ": " + name);
    }
    final Locale fr = Locale.FRANCE;
    System.out.println("============ " + fr + " ============ ");
    for (final ParticipantType obj : ParticipantType.values()) {
      final String name = obj.getLocalizedName(fr);
      assertEquals(obj.name(), name);
      System.out.println(obj.name() + ": " + name);
    }
  }
}