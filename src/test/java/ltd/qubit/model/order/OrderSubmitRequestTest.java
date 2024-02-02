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
 * Unit test of the {@link OrderSubmitRequest} class.
 *
 * @author Haixing Hu
 */
public class OrderSubmitRequestTest extends ModelTestBase<OrderSubmitRequest> {

  public OrderSubmitRequestTest() {
    super(OrderSubmitRequest.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("order", getFieldName(OrderSubmitRequest.class, OrderSubmitRequest::getOrder));
    assertEquals("order", getFieldName(OrderSubmitRequest.class, OrderSubmitRequest::setOrder));
    assertEquals("returnUrl", getFieldName(OrderSubmitRequest.class, OrderSubmitRequest::getReturnUrl));
    assertEquals("returnUrl", getFieldName(OrderSubmitRequest.class, OrderSubmitRequest::setReturnUrl));
    assertEquals("notifyUrl", getFieldName(OrderSubmitRequest.class, OrderSubmitRequest::getNotifyUrl));
    assertEquals("notifyUrl", getFieldName(OrderSubmitRequest.class, OrderSubmitRequest::setNotifyUrl));
  }
}
