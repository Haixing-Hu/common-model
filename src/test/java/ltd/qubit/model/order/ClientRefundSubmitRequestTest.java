////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link ClientRefundSubmitRequest} class.
 *
 * @author Haixing Hu
 */
public class ClientRefundSubmitRequestTest extends ModelTestBase<ClientRefundSubmitRequest> {

  public ClientRefundSubmitRequestTest() {
    super(ClientRefundSubmitRequest.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("verifyCode", getFieldName(ClientRefundSubmitRequest.class, ClientRefundSubmitRequest::getVerifyCode));
    assertEquals("verifyCode", getFieldName(ClientRefundSubmitRequest.class, ClientRefundSubmitRequest::setVerifyCode));
    assertEquals("client", getFieldName(ClientRefundSubmitRequest.class, ClientRefundSubmitRequest::getClient));
    assertEquals("client", getFieldName(ClientRefundSubmitRequest.class, ClientRefundSubmitRequest::setClient));
    assertEquals("returnUrl", getFieldName(ClientRefundSubmitRequest.class, ClientRefundSubmitRequest::getReturnUrl));
    assertEquals("returnUrl", getFieldName(ClientRefundSubmitRequest.class, ClientRefundSubmitRequest::setReturnUrl));
    assertEquals("notifyUrl", getFieldName(ClientRefundSubmitRequest.class, ClientRefundSubmitRequest::getNotifyUrl));
    assertEquals("notifyUrl", getFieldName(ClientRefundSubmitRequest.class, ClientRefundSubmitRequest::setNotifyUrl));
  }
}
