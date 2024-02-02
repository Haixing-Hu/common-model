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
 * Unit test of the {@link OrderItem} class.
 *
 * @author Haixing Hu
 */
public class OrderItemTest extends ModelTestBase<OrderItem> {

  public OrderItemTest() {
    super(OrderItem.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(OrderItem.class, OrderItem::getId));
    assertEquals("id", getFieldName(OrderItem.class, OrderItem::setId));
    assertEquals("orderId", getFieldName(OrderItem.class, OrderItem::getOrderId));
    assertEquals("orderId", getFieldName(OrderItem.class, OrderItem::setOrderId));
    assertEquals("index", getFieldName(OrderItem.class, OrderItem::getIndex));
    assertEquals("index", getFieldName(OrderItem.class, OrderItem::setIndex));
    assertEquals("product", getFieldName(OrderItem.class, OrderItem::getProduct));
    assertEquals("product", getFieldName(OrderItem.class, OrderItem::setProduct));
    assertEquals("count", getFieldName(OrderItem.class, OrderItem::getCount));
    assertEquals("count", getFieldName(OrderItem.class, OrderItem::setCount));
    assertEquals("totalPrice", getFieldName(OrderItem.class, OrderItem::getTotalPrice));
    assertEquals("totalPrice", getFieldName(OrderItem.class, OrderItem::setTotalPrice));
    assertEquals("discount", getFieldName(OrderItem.class, OrderItem::getDiscount));
    assertEquals("discount", getFieldName(OrderItem.class, OrderItem::setDiscount));
    assertEquals("discountReason", getFieldName(OrderItem.class, OrderItem::getDiscountReason));
    assertEquals("discountReason", getFieldName(OrderItem.class, OrderItem::setDiscountReason));
    assertEquals("shippingCost", getFieldName(OrderItem.class, OrderItem::getShippingCost));
    assertEquals("shippingCost", getFieldName(OrderItem.class, OrderItem::setShippingCost));
    assertEquals("payable", getFieldName(OrderItem.class, OrderItem::getPayable));
    assertEquals("payable", getFieldName(OrderItem.class, OrderItem::setPayable));
    assertEquals("serviceId", getFieldName(OrderItem.class, OrderItem::getServiceId));
    assertEquals("serviceId", getFieldName(OrderItem.class, OrderItem::setServiceId));
    assertEquals("clients", getFieldName(OrderItem.class, OrderItem::getClients));
    assertEquals("clients", getFieldName(OrderItem.class, OrderItem::setClients));
  }
  //
  //  @Test
  //  public void testCalculateDiscount() throws Exception {
  //    final RandomBeanGenerator random = new RandomBeanGenerator();
  //
  //    OrderItem item = random.nextObject(OrderItem.class);
  //    item.setPrice(new BigDecimal("49.00"));
  //
  //    item.setDiscount(new BigDecimal("100.00"));
  //    item.setCount(10);
  //
  //    BigDecimal d = item.calculateDiscount(10);
  //    d = normalizeMoney(d);
  //    assertEquals(new BigDecimal("100.0000"), d);
  //
  //    d = item.calculateDiscount(3); // FIXME
  //    d = normalizeMoney(d);
  //    assertEquals(new BigDecimal("30.0000"), d);
  //
  //    d = item.calculateDiscount(3); // FIXME
  //    d = normalizeMoney(d);
  //    assertEquals(new BigDecimal("35.0000"), d);
  //
  //    d = item.calculateDiscount(0);
  //    d = normalizeMoney(d);
  //    assertEquals(new BigDecimal("0.0000"), d);
  //
  //    d = item.calculateDiscount(11);
  //    d = normalizeMoney(d);
  //    assertEquals(new BigDecimal("100.0000"), d);
  //
  //    item.setCount(0);
  //    d = item.calculateDiscount(3); // FIXME
  //    d = normalizeMoney(d);
  //    assertEquals(new BigDecimal("100.0000"), d);
  //
  //    item.setCount(null);
  //    d = item.calculateDiscount(3); // FIXME
  //    d = normalizeMoney(d);
  //    assertEquals(new BigDecimal("100.0000"), d);
  //
  //    item.setDiscount(new BigDecimal("0.00"));
  //    item.setCount(10);
  //    d = item.calculateDiscount(3); // FIXME
  //    d = normalizeMoney(d);
  //    assertEquals(new BigDecimal("0.0000"), d);
  //
  //    item.setDiscount(null);
  //    item.setCount(10);
  //    d = item.calculateDiscount(3); // FIXME
  //    d = normalizeMoney(d);
  //    assertEquals(new BigDecimal("0.0000"), d);
  //  }
}
