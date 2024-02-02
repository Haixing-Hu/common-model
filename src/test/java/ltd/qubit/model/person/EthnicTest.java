////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.person;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test for the {@link Ethnic} class.
 *
 * @author Haixing Hu
 */
public class EthnicTest extends ModelTestBase<Ethnic> {

  public EthnicTest() {
    super(Ethnic.class);
  }

  @Test
  public void testGetLocalizedName_zh_CN() {
    final Locale zh = new Locale("zh", "CN");

    assertEquals("汉族", Ethnic.HAN.getLocalizedName(zh));
    assertEquals("回族", Ethnic.HUI.getLocalizedName(zh));
    assertEquals("门巴族", Ethnic.MONBA.getLocalizedName(zh));
    assertEquals("柯尔克孜族", Ethnic.KIRGIZ.getLocalizedName(zh));
    assertEquals("外国人", Ethnic.FOREIGNER.getLocalizedName(zh));
    assertEquals("其他", Ethnic.OTHER.getLocalizedName(zh));
    System.out.println("============ " + zh + " ============ ");
    for (final Ethnic obj : Ethnic.values()) {
      final String name = obj.getLocalizedName(zh);
      assertNotNull(name);
      System.out.println(obj.name() + ": " + name);
    }
  }

  @Test
  public void testGetLocalizedName_en_US() {
    final Locale en = new Locale("en", "US");
    assertEquals("Han", Ethnic.HAN.getLocalizedName(en));
    assertEquals("Hui", Ethnic.HUI.getLocalizedName(en));
    assertEquals("Monba", Ethnic.MONBA.getLocalizedName(en));
    assertEquals("Kirgiz", Ethnic.KIRGIZ.getLocalizedName(en));
    assertEquals("Foreigner", Ethnic.FOREIGNER.getLocalizedName(en));
    assertEquals("Other", Ethnic.OTHER.getLocalizedName(en));
    System.out.println("============ " + en + " ============ ");
    for (final Ethnic obj : Ethnic.values()) {
      final String name = obj.getLocalizedName(en);
      assertNotNull(name);
      System.out.println(obj.name() + ": " + name);
    }
  }

  @Test
  public void testGetLocalizedName_fallback() throws Exception {
    final Locale fr = Locale.FRANCE;
    System.out.println("============ " + fr + " ============ ");
    for (final Ethnic obj : Ethnic.values()) {
      final String name = obj.getLocalizedName(fr);
      assertNotNull(name);
      System.out.println(obj.name() + ": " + name);
    }
  }
}
