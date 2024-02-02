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
 * Unit test of the {@link PrescriptionItem} class.
 *
 * @author Haixing Hu
 */
public class PrescriptionItemTest extends ModelTestBase<PrescriptionItem> {

  public PrescriptionItemTest() {
    super(PrescriptionItem.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(PrescriptionItem.class, PrescriptionItem::getId));
    assertEquals("id", getFieldName(PrescriptionItem.class, PrescriptionItem::setId));
    assertEquals("prescriptionId", getFieldName(PrescriptionItem.class, PrescriptionItem::getPrescriptionId));
    assertEquals("prescriptionId", getFieldName(PrescriptionItem.class, PrescriptionItem::setPrescriptionId));
    assertEquals("drug", getFieldName(PrescriptionItem.class, PrescriptionItem::getDrug));
    assertEquals("drug", getFieldName(PrescriptionItem.class, PrescriptionItem::setDrug));
    assertEquals("amount", getFieldName(PrescriptionItem.class, PrescriptionItem::getAmount));
    assertEquals("amount", getFieldName(PrescriptionItem.class, PrescriptionItem::setAmount));
    assertEquals("unit", getFieldName(PrescriptionItem.class, PrescriptionItem::getUnit));
    assertEquals("unit", getFieldName(PrescriptionItem.class, PrescriptionItem::setUnit));
    assertEquals("dosage", getFieldName(PrescriptionItem.class, PrescriptionItem::getDosage));
    assertEquals("dosage", getFieldName(PrescriptionItem.class, PrescriptionItem::setDosage));
    assertEquals("comment", getFieldName(PrescriptionItem.class, PrescriptionItem::getComment));
    assertEquals("comment", getFieldName(PrescriptionItem.class, PrescriptionItem::setComment));
  }
}
