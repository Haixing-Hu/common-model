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

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Location} class.
 *
 * @author Haixing Hu
 */
public class LocationTest extends ModelTestBase<Location> {

  public LocationTest() {
    super(Location.class);
  }

  @Test
  public void testNormalize() {
    final Location l1 = new Location();
    l1.normalize();
    assertEquals(new Location(), l1);
    final Location l2 = new Location(new BigDecimal("1.123456789"), new BigDecimal("2.123456789"));
    l2.normalize();
    assertEquals(new Location(new BigDecimal("1.123457"), new BigDecimal("2.123457")), l2);

    final Location l3 = new Location(new BigDecimal("540.123456789"), new BigDecimal("-540.123456789"));
    l3.normalize();
    assertEquals(new Location(new BigDecimal("-179.876543"), new BigDecimal("179.876543")), l3);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("latitude", getFieldName(Location.class, Location::getLatitude));
    assertEquals("latitude", getFieldName(Location.class, Location::setLatitude));
    assertEquals("longitude", getFieldName(Location.class, Location::getLongitude));
    assertEquals("longitude", getFieldName(Location.class, Location::setLongitude));
  }
}
