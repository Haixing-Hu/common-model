////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PhoneCodecTest {

  @Test
  public void testEncode() throws Exception {
    final PhoneCodec codec = new PhoneCodec();
    final Phone phone = new Phone();

    phone.setCountryArea("86");
    phone.setCityArea("025");
    phone.setNumber("84507781");
    assertEquals("+86-025-84507781", codec.encode(phone));

    phone.setCountryArea("86");
    phone.setCityArea(null);
    phone.setNumber("84507781");
    assertEquals("+86-84507781", codec.encode(phone));

    phone.setCountryArea(null);
    phone.setCityArea("025");
    phone.setNumber("84507781");
    assertEquals("025-84507781", codec.encode(phone));

    phone.setCountryArea(null);
    phone.setCityArea(null);
    phone.setNumber("84507781");
    assertEquals("84507781", codec.encode(phone));

    assertNull(codec.encode(null));
  }

  @Test
  public void testDecode() throws Exception {
    final PhoneCodec codec = new PhoneCodec();

    final Phone p1 = new Phone();
    p1.setCountryArea("86");
    p1.setCityArea("025");
    p1.setNumber("84507781");
    assertEquals(p1, codec.decode("+86-025-84507781"));

    final Phone p2 = new Phone();
    p2.setCountryArea("86");
    p2.setCityArea(null);
    p2.setNumber("84507781");
    assertEquals(p2, codec.decode("+86-84507781"));

    final Phone p3 = new Phone();
    p3.setCountryArea(null);
    p3.setCityArea("025");
    p3.setNumber("84507781");
    assertEquals(p3, codec.decode("025-84507781"));

    final Phone p4 = new Phone();
    p4.setCountryArea(null);
    p4.setCityArea(null);
    p4.setNumber("84507781");
    assertEquals(p4, codec.decode("84507781"));

    assertNull(codec.decode(null));
    assertNull(codec.decode(""));
    assertNull(codec.decode("  "));
  }
}
