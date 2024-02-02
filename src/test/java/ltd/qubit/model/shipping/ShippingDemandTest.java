////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.shipping;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link ShippingDemand} class.
 *
 * @author Haixing Hu
 */
public class ShippingDemandTest extends ModelTestBase<ShippingDemand> {

  public ShippingDemandTest() {
    super(ShippingDemand.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("dayType", getFieldName(ShippingDemand.class, ShippingDemand::getDayType));
    assertEquals("dayType", getFieldName(ShippingDemand.class, ShippingDemand::setDayType));
    assertEquals("dateRange", getFieldName(ShippingDemand.class, ShippingDemand::getDateRange));
    assertEquals("dateRange", getFieldName(ShippingDemand.class, ShippingDemand::setDateRange));
    assertEquals("timeRange", getFieldName(ShippingDemand.class, ShippingDemand::getTimeRange));
    assertEquals("timeRange", getFieldName(ShippingDemand.class, ShippingDemand::setTimeRange));
    assertEquals("packing", getFieldName(ShippingDemand.class, ShippingDemand::getPacking));
    assertEquals("packing", getFieldName(ShippingDemand.class, ShippingDemand::setPacking));
    assertEquals("comment", getFieldName(ShippingDemand.class, ShippingDemand::getComment));
    assertEquals("comment", getFieldName(ShippingDemand.class, ShippingDemand::setComment));
  }
}
