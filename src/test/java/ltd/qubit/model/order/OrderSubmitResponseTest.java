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
 * Unit test of the {@link OrderSubmitResponse} class.
 *
 * @author Haixing Hu
 */
public class OrderSubmitResponseTest extends ModelTestBase<OrderSubmitResponse> {

  public OrderSubmitResponseTest() {
    super(OrderSubmitResponse.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("url", getFieldName(OrderSubmitResponse.class, OrderSubmitResponse::getUrl));
    assertEquals("url", getFieldName(OrderSubmitResponse.class, OrderSubmitResponse::setUrl));
    assertEquals("params", getFieldName(OrderSubmitResponse.class, OrderSubmitResponse::getParams));
    assertEquals("params", getFieldName(OrderSubmitResponse.class, OrderSubmitResponse::setParams));
  }
}
