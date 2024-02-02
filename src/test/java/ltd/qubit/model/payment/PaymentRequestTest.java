////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link PaymentRequest} class.
 *
 * @author Haixing Hu
 */
public class PaymentRequestTest extends ModelTestBase<PaymentRequest> {

  public PaymentRequestTest() {
    super(PaymentRequest.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("data", getFieldName(PaymentRequest.class, PaymentRequest::getData));
    assertEquals("data", getFieldName(PaymentRequest.class, PaymentRequest::setData));
    assertEquals("returnUrl", getFieldName(PaymentRequest.class, PaymentRequest::getReturnUrl));
    assertEquals("returnUrl", getFieldName(PaymentRequest.class, PaymentRequest::setReturnUrl));
    assertEquals("notifyUrl", getFieldName(PaymentRequest.class, PaymentRequest::getNotifyUrl));
    assertEquals("notifyUrl", getFieldName(PaymentRequest.class, PaymentRequest::setNotifyUrl));
    assertEquals("signature", getFieldName(PaymentRequest.class, PaymentRequest::getSignature));
    assertEquals("signature", getFieldName(PaymentRequest.class, PaymentRequest::setSignature));
  }
}
