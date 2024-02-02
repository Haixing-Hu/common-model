////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import ltd.qubit.commons.security.SignedMessage;

/**
 * 此模型支付系统在支付完成后的响应消息。
 *
 * @author 胡海星
 */
public class PaymentResponse extends SignedMessage<Payment> {

  private static final long serialVersionUID = -6461949970094112376L;

  public PaymentResponse() {}

  public PaymentResponse(final Payment data) {
    super(data);
  }
}
