////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.contact;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;
import ltd.qubit.model.util.Info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Address} class.
 *
 * @author Haixing Hu
 */
public class AddressTest extends ModelTestBase<Address> {

  public AddressTest() {
    super(Address.class);
  }

  @Test
  public void testIsEmpty() {
    final Address a1 = new Address();
    assertTrue(a1.isEmpty());
    a1.setCity(new Info());
    assertTrue(a1.isEmpty());
    a1.setCountry(new Info(12l));
    assertFalse(a1.isEmpty());
    a1.setCountry(new Info(null, "  "));
    a1.setDetail("  ");
    assertFalse(a1.isEmpty());
    a1.setCountry(new Info(null, ""));
    a1.setDetail("");
    assertTrue(a1.isEmpty());
  }

  @Test
  public void testNormalize() {
    final Address a1 = new Address();
    a1.normalize();
    assertEquals(new Address(), a1);

    a1.setDetail("  ");
    a1.normalize();
    assertEquals(new Address(), a1);

    a1.setCountry(new Info(null, "  "));
    a1.setDetail("  ");
    a1.normalize();
    assertEquals(new Address(), a1);

    a1.setCountry(new Info(null, "  "));
    a1.setDetail(" a ");
    a1.normalize();
    final Address a2 = new Address();
    a2.setDetail("a");
    assertEquals(a2, a1);

    a1.setLocation(new Location(new BigDecimal("1.123456789"), new BigDecimal("2.123456789")));
    a1.normalize();
    a2.setLocation(new Location(new BigDecimal("1.123457"), new BigDecimal("2.123457")));
    assertEquals(a2, a1);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("country", getFieldName(Address.class, Address::getCountry));
    assertEquals("country", getFieldName(Address.class, Address::setCountry));
    assertEquals("province", getFieldName(Address.class, Address::getProvince));
    assertEquals("province", getFieldName(Address.class, Address::setProvince));
    assertEquals("city", getFieldName(Address.class, Address::getCity));
    assertEquals("city", getFieldName(Address.class, Address::setCity));
    assertEquals("district", getFieldName(Address.class, Address::getDistrict));
    assertEquals("district", getFieldName(Address.class, Address::setDistrict));
    assertEquals("street", getFieldName(Address.class, Address::getStreet));
    assertEquals("street", getFieldName(Address.class, Address::setStreet));
    assertEquals("detail", getFieldName(Address.class, Address::getDetail));
    assertEquals("detail", getFieldName(Address.class, Address::setDetail));
    assertEquals("postalcode", getFieldName(Address.class, Address::getPostalcode));
    assertEquals("postalcode", getFieldName(Address.class, Address::setPostalcode));
    assertEquals("location", getFieldName(Address.class, Address::getLocation));
    assertEquals("location", getFieldName(Address.class, Address::setLocation));
  }
}
