////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Dosage} class.
 *
 * @author Haixing Hu
 */
public class DosageTest extends ModelTestBase<Dosage> {

  public DosageTest() {
    super(Dosage.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("usage", getFieldName(Dosage.class, Dosage::getUsage));
    assertEquals("usage", getFieldName(Dosage.class, Dosage::setUsage));
    assertEquals("decoction", getFieldName(Dosage.class, Dosage::getDecoction));
    assertEquals("decoction", getFieldName(Dosage.class, Dosage::setDecoction));
    assertEquals("therapy", getFieldName(Dosage.class, Dosage::getTherapy));
    assertEquals("therapy", getFieldName(Dosage.class, Dosage::setTherapy));
    assertEquals("amount", getFieldName(Dosage.class, Dosage::getAmount));
    assertEquals("amount", getFieldName(Dosage.class, Dosage::setAmount));
    assertEquals("unit", getFieldName(Dosage.class, Dosage::getUnit));
    assertEquals("unit", getFieldName(Dosage.class, Dosage::setUnit));
    assertEquals("frequency", getFieldName(Dosage.class, Dosage::getFrequency));
    assertEquals("frequency", getFieldName(Dosage.class, Dosage::setFrequency));
    assertEquals("duration", getFieldName(Dosage.class, Dosage::getDuration));
    assertEquals("duration", getFieldName(Dosage.class, Dosage::setDuration));
    assertEquals("totalAmount", getFieldName(Dosage.class, Dosage::getTotalAmount));
    assertEquals("totalAmount", getFieldName(Dosage.class, Dosage::setTotalAmount));
    assertEquals("pastes", getFieldName(Dosage.class, Dosage::getPastes));
    assertEquals("pastes", getFieldName(Dosage.class, Dosage::setPastes));
    assertEquals("precautions", getFieldName(Dosage.class, Dosage::getPrecautions));
    assertEquals("precautions", getFieldName(Dosage.class, Dosage::setPrecautions));
  }
}
