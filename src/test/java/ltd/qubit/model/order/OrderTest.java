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
 * Unit test of the {@link Order} class.
 *
 * @author Haixing Hu
 */
public class OrderTest extends ModelTestBase<Order> {

  public OrderTest() {
    super(Order.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Order.class, Order::getId));
    assertEquals("id", getFieldName(Order.class, Order::setId));
    assertEquals("userId", getFieldName(Order.class, Order::getUserId));
    assertEquals("userId", getFieldName(Order.class, Order::setUserId));
    assertEquals("app", getFieldName(Order.class, Order::getApp));
    assertEquals("app", getFieldName(Order.class, Order::setApp));
    assertEquals("buyer", getFieldName(Order.class, Order::getBuyer));
    assertEquals("buyer", getFieldName(Order.class, Order::setBuyer));
    assertEquals("seller", getFieldName(Order.class, Order::getSeller));
    assertEquals("seller", getFieldName(Order.class, Order::setSeller));
    assertEquals("source", getFieldName(Order.class, Order::getSource));
    assertEquals("source", getFieldName(Order.class, Order::setSource));
    assertEquals("category", getFieldName(Order.class, Order::getCategory));
    assertEquals("category", getFieldName(Order.class, Order::setCategory));
    assertEquals("items", getFieldName(Order.class, Order::getItems));
    assertEquals("items", getFieldName(Order.class, Order::setItems));
    assertEquals("payType", getFieldName(Order.class, Order::getPayType));
    assertEquals("payType", getFieldName(Order.class, Order::setPayType));
    assertEquals("currency", getFieldName(Order.class, Order::getCurrency));
    assertEquals("currency", getFieldName(Order.class, Order::setCurrency));
    assertEquals("totalPrice", getFieldName(Order.class, Order::getTotalPrice));
    assertEquals("totalPrice", getFieldName(Order.class, Order::setTotalPrice));
    assertEquals("totalShippingCost", getFieldName(Order.class, Order::getTotalShippingCost));
    assertEquals("totalShippingCost", getFieldName(Order.class, Order::setTotalShippingCost));
    assertEquals("totalDiscount", getFieldName(Order.class, Order::getTotalDiscount));
    assertEquals("totalDiscount", getFieldName(Order.class, Order::setTotalDiscount));
    assertEquals("discount", getFieldName(Order.class, Order::getDiscount));
    assertEquals("discount", getFieldName(Order.class, Order::setDiscount));
    assertEquals("discountReason", getFieldName(Order.class, Order::getDiscountReason));
    assertEquals("discountReason", getFieldName(Order.class, Order::setDiscountReason));
    assertEquals("shippingCost", getFieldName(Order.class, Order::getShippingCost));
    assertEquals("shippingCost", getFieldName(Order.class, Order::setShippingCost));
    assertEquals("payable", getFieldName(Order.class, Order::getPayable));
    assertEquals("payable", getFieldName(Order.class, Order::setPayable));
    assertEquals("shippingMode", getFieldName(Order.class, Order::getShippingMode));
    assertEquals("shippingMode", getFieldName(Order.class, Order::setShippingMode));
    assertEquals("consignee", getFieldName(Order.class, Order::getConsignee));
    assertEquals("consignee", getFieldName(Order.class, Order::setConsignee));
    assertEquals("shippingDemand", getFieldName(Order.class, Order::getShippingDemand));
    assertEquals("shippingDemand", getFieldName(Order.class, Order::setShippingDemand));
    assertEquals("shippingId", getFieldName(Order.class, Order::getShippingId));
    assertEquals("shippingId", getFieldName(Order.class, Order::setShippingId));
    assertEquals("shippingNumber", getFieldName(Order.class, Order::getShippingNumber));
    assertEquals("shippingNumber", getFieldName(Order.class, Order::setShippingNumber));
    assertEquals("comment", getFieldName(Order.class, Order::getComment));
    assertEquals("comment", getFieldName(Order.class, Order::setComment));
    assertEquals("status", getFieldName(Order.class, Order::getStatus));
    assertEquals("status", getFieldName(Order.class, Order::setStatus));
    assertEquals("expiredTime", getFieldName(Order.class, Order::getExpiredTime));
    assertEquals("expiredTime", getFieldName(Order.class, Order::setExpiredTime));
    assertEquals("payTime", getFieldName(Order.class, Order::getPayTime));
    assertEquals("payTime", getFieldName(Order.class, Order::setPayTime));
    assertEquals("shipTime", getFieldName(Order.class, Order::getShipTime));
    assertEquals("shipTime", getFieldName(Order.class, Order::setShipTime));
    assertEquals("refundTime", getFieldName(Order.class, Order::getRefundTime));
    assertEquals("refundTime", getFieldName(Order.class, Order::setRefundTime));
    assertEquals("completeTime", getFieldName(Order.class, Order::getCompleteTime));
    assertEquals("completeTime", getFieldName(Order.class, Order::setCompleteTime));
    assertEquals("cancelTime", getFieldName(Order.class, Order::getCancelTime));
    assertEquals("cancelTime", getFieldName(Order.class, Order::setCancelTime));
    assertEquals("invoiceStatus", getFieldName(Order.class, Order::getInvoiceStatus));
    assertEquals("invoiceStatus", getFieldName(Order.class, Order::setInvoiceStatus));
    assertEquals("environment", getFieldName(Order.class, Order::getEnvironment));
    assertEquals("environment", getFieldName(Order.class, Order::setEnvironment));
    assertEquals("payload", getFieldName(Order.class, Order::getPayload));
    assertEquals("payload", getFieldName(Order.class, Order::setPayload));
    assertEquals("createTime", getFieldName(Order.class, Order::getCreateTime));
    assertEquals("createTime", getFieldName(Order.class, Order::setCreateTime));
    assertEquals("modifyTime", getFieldName(Order.class, Order::getModifyTime));
    assertEquals("modifyTime", getFieldName(Order.class, Order::setModifyTime));
    assertEquals("deleteTime", getFieldName(Order.class, Order::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Order.class, Order::setDeleteTime));
  }
  //
  //  @Test
  //  public void testCalculateDiscount() throws Exception {
  //    final RandomBeanGenerator random = new RandomBeanGenerator();
  //
  //    Order order = random.nextObject(Order.class);
  //    OrderItem i1 = random.nextObject(OrderItem.class);
  //    OrderItem i2 = random.nextObject(OrderItem.class);
  //
  //    order.setTotalPrice(new BigDecimal("448.00"))
  //         .setTotalDiscount(ZERO)
  //         .setDiscount(new BigDecimal("50.00"));
  //
  //    i1.setPrice(new BigDecimal("349.00"))
  //      .setCount(1)
  //      .setDiscount(ZERO)
  //      .calculate();
  //    BigDecimal d1 = order.calculateDiscount(i1);
  //    d1 = normalizeMoney(d1);
  //    assertEquals(new BigDecimal("38.9509"), d1);
  //    i2.setPrice(new BigDecimal("99.00"))
  //      .setCount(1)
  //      .setDiscount(ZERO)
  //      .calculate();
  //    BigDecimal d2 = order.calculateDiscount(i2);
  //    d2 = normalizeMoney(d2);
  //    assertEquals(new BigDecimal("11.0491"), d2);
  //
  //
  //    order.setDiscount(new BigDecimal("0.00"));
  //
  //    d1 = order.calculateDiscount(i1);
  //    d1 = normalizeMoney(d1);
  //    assertEquals(new BigDecimal("0.0000"), d1);
  //    d2 = order.calculateDiscount(i2);
  //    d2 = normalizeMoney(d2);
  //    assertEquals(new BigDecimal("0.0000"), d2);
  //
  //
  //    order.setDiscount(null);
  //    d1 = order.calculateDiscount(i1);
  //    d1 = normalizeMoney(d1);
  //    assertEquals(new BigDecimal("0.0000"), d1);
  //    d2 = order.calculateDiscount(i2);
  //    d2 = normalizeMoney(d2);
  //    assertEquals(new BigDecimal("0.0000"), d2);
  //
  //
  //    order.setDiscount(new BigDecimal("33.33"));
  //    i1.setPrice(new BigDecimal("448.00"))
  //      .calculate();
  //    d1 = order.calculateDiscount(i1);
  //    d1 = normalizeMoney(d1);
  //    assertEquals(new BigDecimal("33.3300"), d1);
  //    i2.setPrice(new BigDecimal("0.00"))
  //      .calculate();
  //    d2 = order.calculateDiscount(i2);
  //    d2 = normalizeMoney(d2);
  //    assertEquals(new BigDecimal("0.0000"), d2);
  //
  //    order.setDiscount(new BigDecimal("33.33"));
  //    i1.setPrice(new BigDecimal("449.00"))
  //      .calculate();
  //    d1 = order.calculateDiscount(i1);
  //    d1 = normalizeMoney(d1);
  //    assertEquals(new BigDecimal("33.3300"), d1);
  //    i2.setPrice(new BigDecimal("0.00"))
  //      .calculate();
  //    d2 = order.calculateDiscount(i2);
  //    d2 = normalizeMoney(d2);
  //    assertEquals(new BigDecimal("0.0000"), d2);
  //
  //    order.setDiscount(new BigDecimal("33.33"));
  //    i1.setPrice(new BigDecimal("447.00"))
  //      .calculate();
  //    d1 = order.calculateDiscount(i1);
  //    d1 = normalizeMoney(d1);
  //    assertEquals(new BigDecimal("33.2556"), d1);
  //    i2.setPrice(new BigDecimal("1.00"))
  //      .calculate();
  //    d2 = order.calculateDiscount(i2);
  //    d2 = normalizeMoney(d2);
  //    assertEquals(new BigDecimal("0.0744"), d2);
  //
  //
  //    order.setTotalPrice(new BigDecimal("548.00"))
  //         .setTotalDiscount(new BigDecimal("100.00"))
  //         .setDiscount(new BigDecimal("50.00"));
  //
  //    i1.setPrice(new BigDecimal("449.00"))
  //      .setCount(1)
  //      .setDiscount(new BigDecimal("100.00"))
  //      .calculate();
  //
  //    d1 = order.calculateDiscount(i1);
  //    d1 = normalizeMoney(d1);
  //    assertEquals(new BigDecimal("38.9509"), d1);
  //    i2.setPrice(new BigDecimal("99.00"))
  //      .setCount(1)
  //      .setDiscount(ZERO)
  //      .calculate();
  //    d2 = order.calculateDiscount(i2);
  //    d2 = normalizeMoney(d2);
  //    assertEquals(new BigDecimal("11.0491"), d2);
  //
  //    order.setTotalPrice(new BigDecimal("568.00"))
  //         .setTotalDiscount(new BigDecimal("120.00"))
  //         .setDiscount(new BigDecimal("50.00"));
  //
  //    i1.setPrice(new BigDecimal("449.00"))
  //      .setCount(1)
  //      .setDiscount(new BigDecimal("100.00"))
  //      .calculate();
  //
  //    d1 = order.calculateDiscount(i1);
  //    d1 = normalizeMoney(d1);
  //    assertEquals(new BigDecimal("38.9509"), d1);
  //    i2.setPrice(new BigDecimal("119.00"))
  //      .setCount(1)
  //      .setDiscount(new BigDecimal("20.00"))
  //      .calculate();
  //    d2 = order.calculateDiscount(i2);
  //    d2 = normalizeMoney(d2);
  //    assertEquals(new BigDecimal("11.0491"), d2);
  //  }
  //
  //
  //  @Test
  //  public void testCalculateRefundable() throws Exception {
  //    final RandomBeanGenerator random = new RandomBeanGenerator();
  //
  //    Order order = random.nextObject(Order.class);
  //    OrderItem i1 = random.nextObject(OrderItem.class);
  //    OrderItem i2 = random.nextObject(OrderItem.class);
  //
  //    order.setTotalPrice(new BigDecimal("448.00"))
  //         .setTotalDiscount(ZERO)
  //         .setDiscount(new BigDecimal("50.00"));
  //    i1.setPrice(new BigDecimal("349.00"))
  //      .setCount(1)
  //      .setDiscount(ZERO)
  //      .calculate();
  //    BigDecimal r1 = order.calculateRefundable(i1, 1);
  //    r1 = normalizeMoney(r1);
  //    assertEquals(new BigDecimal("310.0491"), r1);
  //    i2.setPrice(new BigDecimal("99.00"))
  //      .setCount(1)
  //      .setDiscount(ZERO)
  //      .calculate();
  //    BigDecimal r2 = order.calculateRefundable(i2, 1);
  //    r2 = normalizeMoney(r2);
  //    assertEquals(new BigDecimal("87.9509"), r2);
  //
  //
  //    order.setTotalPrice(new BigDecimal("896.00"))
  //         .setTotalDiscount(ZERO)
  //         .setDiscount(new BigDecimal("100.00"));
  //    i1.setPrice(new BigDecimal("349.00"))
  //      .setCount(2)
  //      .setDiscount(ZERO)
  //      .calculate();
  //    r1 = order.calculateRefundable(i1, 1);
  //    r1 = normalizeMoney(r1);
  //    assertEquals(new BigDecimal("310.0491"), r1);
  //    i2.setPrice(new BigDecimal("99.00"))
  //      .setCount(2)
  //      .setDiscount(ZERO)
  //      .calculate();
  //    r2 = order.calculateRefundable(i2, 1);
  //    r2 = normalizeMoney(r2);
  //    assertEquals(new BigDecimal("87.9509"), r2);
  //
  //
  //    order.setTotalPrice(new BigDecimal("996.00"))
  //         .setTotalDiscount(new BigDecimal("100.00"))
  //         .setDiscount(new BigDecimal("100.00"));
  //    i1.setPrice(new BigDecimal("399.00"))
  //      .setCount(2)
  //      .setDiscount(new BigDecimal("100.00"))
  //      .calculate();
  //    r1 = order.calculateRefundable(i1, 1);
  //    r1 = normalizeMoney(r1);
  //    assertEquals(new BigDecimal("310.0491"), r1);
  //    r1 = order.calculateRefundable(i1, 2);
  //    r1 = normalizeMoney(r1);
  //    assertEquals(new BigDecimal("620.0982"), r1);
  //    i2.setPrice(new BigDecimal("99.00"))
  //      .setCount(2)
  //      .setDiscount(ZERO)
  //      .calculate();
  //    r2 = order.calculateRefundable(i2, 1);
  //    r2 = normalizeMoney(r2);
  //    assertEquals(new BigDecimal("87.9509"), r2);
  //    r2 = order.calculateRefundable(i2, 2);
  //    r2 = normalizeMoney(r2);
  //    assertEquals(new BigDecimal("175.9018"), r2);
  //
  //    order.setTotalPrice(new BigDecimal("245.00"))
  //         .setTotalDiscount(ZERO)
  //         .setTotalShippingCost(ZERO)
  //         .setShippingCost(ZERO)
  //         .setDiscount(ZERO);
  //    i1.setPrice(new BigDecimal("49.00"))
  //      .setCount(5)
  //      .setShippingCost(ZERO)
  //      .setDiscount(ZERO)
  //      .calculate();
  //    r1 = order.calculateRefundable(i1, 1);
  //    r1 = normalizeMoney(r1);
  //    assertEquals(new BigDecimal("49.0000"), r1);
  //    r1 = order.calculateRefundable(i1, 2);
  //    r1 = normalizeMoney(r1);
  //    assertEquals(new BigDecimal("98.0000"), r1);
  //    r1 = order.calculateRefundable(i1, 3);
  //    r1 = normalizeMoney(r1);
  //    assertEquals(new BigDecimal("147.0000"), r1);
  //    r1 = order.calculateRefundable(i1, 4);
  //    r1 = normalizeMoney(r1);
  //    assertEquals(new BigDecimal("196.0000"), r1);
  //    r1 = order.calculateRefundable(i1, 5);
  //    r1 = normalizeMoney(r1);
  //    assertEquals(new BigDecimal("245.0000"), r1);
  //  }
}
