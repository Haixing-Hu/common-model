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
 * Unit test of the {@link PrescriptionOrderRequest} class.
 *
 * @author Haixing Hu
 */
public class PrescriptionOrderRequestTest extends ModelTestBase<PrescriptionOrderRequest> {

  public PrescriptionOrderRequestTest() {
    super(PrescriptionOrderRequest.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("prescription",
      getFieldName(PrescriptionOrderRequest.class, PrescriptionOrderRequest::getPrescription));
    assertEquals("prescription",
      getFieldName(PrescriptionOrderRequest.class, PrescriptionOrderRequest::setPrescription));
    assertEquals("order", getFieldName(PrescriptionOrderRequest.class, PrescriptionOrderRequest::getOrder));
    assertEquals("order", getFieldName(PrescriptionOrderRequest.class, PrescriptionOrderRequest::setOrder));
  }
}
