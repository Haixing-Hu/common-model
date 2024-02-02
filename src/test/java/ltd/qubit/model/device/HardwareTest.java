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
 * Unit test of the {@link Hardware} class.
 *
 * @author Haixing Hu
 */
public class HardwareTest extends ModelTestBase<Hardware> {

  public HardwareTest() {
    super(Hardware.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("device", getFieldName(Hardware.class, Hardware::getDevice));
    assertEquals("device", getFieldName(Hardware.class, Hardware::setDevice));
    assertEquals("model", getFieldName(Hardware.class, Hardware::getModel));
    assertEquals("model", getFieldName(Hardware.class, Hardware::setModel));
    assertEquals("brand", getFieldName(Hardware.class, Hardware::getBrand));
    assertEquals("brand", getFieldName(Hardware.class, Hardware::setBrand));
    assertEquals("manufacturer", getFieldName(Hardware.class, Hardware::getManufacturer));
    assertEquals("manufacturer", getFieldName(Hardware.class, Hardware::setManufacturer));
    assertEquals("product", getFieldName(Hardware.class, Hardware::getProduct));
    assertEquals("product", getFieldName(Hardware.class, Hardware::setProduct));
    assertEquals("display", getFieldName(Hardware.class, Hardware::getDisplay));
    assertEquals("display", getFieldName(Hardware.class, Hardware::setDisplay));
    assertEquals("board", getFieldName(Hardware.class, Hardware::getBoard));
    assertEquals("board", getFieldName(Hardware.class, Hardware::setBoard));
    assertEquals("hardware", getFieldName(Hardware.class, Hardware::getHardware));
    assertEquals("hardware", getFieldName(Hardware.class, Hardware::setHardware));
    assertEquals("supportedAbis", getFieldName(Hardware.class, Hardware::getSupportedAbis));
    assertEquals("supportedAbis", getFieldName(Hardware.class, Hardware::setSupportedAbis));
    assertEquals("macAddresses", getFieldName(Hardware.class, Hardware::getMacAddresses));
    assertEquals("macAddresses", getFieldName(Hardware.class, Hardware::setMacAddresses));
    assertEquals("imei", getFieldName(Hardware.class, Hardware::getImei));
    assertEquals("imei", getFieldName(Hardware.class, Hardware::setImei));
    assertEquals("meid", getFieldName(Hardware.class, Hardware::getMeid));
    assertEquals("meid", getFieldName(Hardware.class, Hardware::setMeid));
    assertEquals("serial", getFieldName(Hardware.class, Hardware::getSerial));
    assertEquals("serial", getFieldName(Hardware.class, Hardware::setSerial));
  }
}
