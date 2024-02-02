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
 * Unit test of the {@link OrderDetail} class.
 *
 * @author Haixing Hu
 */
public class OrderDetailTest extends ModelTestBase<OrderDetail> {

  public OrderDetailTest() {
    super(OrderDetail.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("order", getFieldName(OrderDetail.class, OrderDetail::getOrder));
    assertEquals("order", getFieldName(OrderDetail.class, OrderDetail::setOrder));
    assertEquals("transactions", getFieldName(OrderDetail.class, OrderDetail::getTransactions));
    assertEquals("transactions", getFieldName(OrderDetail.class, OrderDetail::setTransactions));
    assertEquals("returns", getFieldName(OrderDetail.class, OrderDetail::getReturns));
    assertEquals("returns", getFieldName(OrderDetail.class, OrderDetail::setReturns));
  }
}
