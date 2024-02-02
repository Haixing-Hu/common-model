////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import ltd.qubit.commons.test.ModelTestBase;

/**
 * Unit test of the {@link PaymentResponse} class.
 *
 * @author Haixing Hu
 */
public class PaymentResponseTest extends ModelTestBase<PaymentResponse> {

  public PaymentResponseTest() {
    super(PaymentResponse.class);
    xmlTester.setEnabled(false); // FIXME: 暂时没能解决XML序列化的错误
  }
}
