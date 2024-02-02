////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.device;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link SimCard} class.
 *
 * @author Haixing Hu
 */
public class SimCardTest extends ModelTestBase<SimCard> {

  public SimCardTest() {
    super(SimCard.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("iccid", getFieldName(SimCard.class, SimCard::getIccid));
    assertEquals("iccid", getFieldName(SimCard.class, SimCard::setIccid));
    assertEquals("imei", getFieldName(SimCard.class, SimCard::getImei));
    assertEquals("imei", getFieldName(SimCard.class, SimCard::setImei));
    assertEquals("meid", getFieldName(SimCard.class, SimCard::getMeid));
    assertEquals("meid", getFieldName(SimCard.class, SimCard::setMeid));
    assertEquals("phone", getFieldName(SimCard.class, SimCard::getPhone));
    assertEquals("phone", getFieldName(SimCard.class, SimCard::setPhone));
    assertEquals("operator", getFieldName(SimCard.class, SimCard::getOperator));
    assertEquals("operator", getFieldName(SimCard.class, SimCard::setOperator));
    assertEquals("country", getFieldName(SimCard.class, SimCard::getCountry));
    assertEquals("country", getFieldName(SimCard.class, SimCard::setCountry));
    assertEquals("location", getFieldName(SimCard.class, SimCard::getLocation));
    assertEquals("location", getFieldName(SimCard.class, SimCard::setLocation));
    assertEquals("networkType", getFieldName(SimCard.class, SimCard::getNetworkType));
    assertEquals("networkType", getFieldName(SimCard.class, SimCard::setNetworkType));
    assertEquals("status", getFieldName(SimCard.class, SimCard::getStatus));
    assertEquals("status", getFieldName(SimCard.class, SimCard::setStatus));
  }
}
