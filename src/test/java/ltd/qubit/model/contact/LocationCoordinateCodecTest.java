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

import java.math.BigDecimal;

import static ltd.qubit.model.contact.LocationCoordinateCodec.normalize;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationCoordinateCodecTest {

  @Test
  public void testNormalize() {
    final BigDecimal v1 = new BigDecimal("28.1");
    assertEquals(new BigDecimal("28.100000"), normalize(v1));
    final BigDecimal v2 = new BigDecimal("-128.9293323");
    assertEquals(new BigDecimal("-128.929332"), normalize(v2));

    final BigDecimal v3 = new BigDecimal("180.0");
    assertEquals(new BigDecimal("180.000000"), normalize(v3));

    final BigDecimal v4 = new BigDecimal("-180.0");
    assertEquals(new BigDecimal("-180.000000"), normalize(v4));

    final BigDecimal v5 = new BigDecimal("180.1");
    assertEquals(new BigDecimal("-179.900000"), normalize(v5));

    final BigDecimal v6 = new BigDecimal("-180.1");
    assertEquals(new BigDecimal("179.900000"), normalize(v6));

    final BigDecimal v7 = new BigDecimal("360.1");
    assertEquals(new BigDecimal("0.100000"), normalize(v7));

    final BigDecimal v8 = new BigDecimal("-360.1");
    assertEquals(new BigDecimal("-0.100000"), normalize(v8));

    final BigDecimal v9 = new BigDecimal("540.1");
    assertEquals(new BigDecimal("-179.900000"), normalize(v9));

    final BigDecimal v10 = new BigDecimal("-540.1");
    assertEquals(new BigDecimal("179.900000"), normalize(v10));
  }
}
