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
 * Unit test of the {@link OrderInfo} class.
 *
 * @author Haixing Hu
 */
public class OrderInfoTest extends ModelTestBase<OrderInfo> {

  public OrderInfoTest() {
    super(OrderInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(OrderInfo.class, OrderInfo::getId));
    assertEquals("id", getFieldName(OrderInfo.class, OrderInfo::setId));
    assertEquals("userId", getFieldName(OrderInfo.class, OrderInfo::getUserId));
    assertEquals("userId", getFieldName(OrderInfo.class, OrderInfo::setUserId));
    assertEquals("app", getFieldName(OrderInfo.class, OrderInfo::getApp));
    assertEquals("app", getFieldName(OrderInfo.class, OrderInfo::setApp));
    assertEquals("buyer", getFieldName(OrderInfo.class, OrderInfo::getBuyer));
    assertEquals("buyer", getFieldName(OrderInfo.class, OrderInfo::setBuyer));
    assertEquals("seller", getFieldName(OrderInfo.class, OrderInfo::getSeller));
    assertEquals("seller", getFieldName(OrderInfo.class, OrderInfo::setSeller));
    assertEquals("source", getFieldName(OrderInfo.class, OrderInfo::getSource));
    assertEquals("source", getFieldName(OrderInfo.class, OrderInfo::setSource));
    assertEquals("category", getFieldName(OrderInfo.class, OrderInfo::getCategory));
    assertEquals("category", getFieldName(OrderInfo.class, OrderInfo::setCategory));
    assertEquals("payType", getFieldName(OrderInfo.class, OrderInfo::getPayType));
    assertEquals("payType", getFieldName(OrderInfo.class, OrderInfo::setPayType));
    assertEquals("currency", getFieldName(OrderInfo.class, OrderInfo::getCurrency));
    assertEquals("currency", getFieldName(OrderInfo.class, OrderInfo::setCurrency));
    assertEquals("totalPrice", getFieldName(OrderInfo.class, OrderInfo::getTotalPrice));
    assertEquals("totalPrice", getFieldName(OrderInfo.class, OrderInfo::setTotalPrice));
    assertEquals("totalShippingCost", getFieldName(OrderInfo.class, OrderInfo::getTotalShippingCost));
    assertEquals("totalShippingCost", getFieldName(OrderInfo.class, OrderInfo::setTotalShippingCost));
    assertEquals("totalDiscount", getFieldName(OrderInfo.class, OrderInfo::getTotalDiscount));
    assertEquals("totalDiscount", getFieldName(OrderInfo.class, OrderInfo::setTotalDiscount));
    assertEquals("discount", getFieldName(OrderInfo.class, OrderInfo::getDiscount));
    assertEquals("discount", getFieldName(OrderInfo.class, OrderInfo::setDiscount));
    assertEquals("shippingCost", getFieldName(OrderInfo.class, OrderInfo::getShippingCost));
    assertEquals("shippingCost", getFieldName(OrderInfo.class, OrderInfo::setShippingCost));
    assertEquals("payable", getFieldName(OrderInfo.class, OrderInfo::getPayable));
    assertEquals("payable", getFieldName(OrderInfo.class, OrderInfo::setPayable));
    assertEquals("status", getFieldName(OrderInfo.class, OrderInfo::getStatus));
    assertEquals("status", getFieldName(OrderInfo.class, OrderInfo::setStatus));
    assertEquals("createTime", getFieldName(OrderInfo.class, OrderInfo::getCreateTime));
    assertEquals("createTime", getFieldName(OrderInfo.class, OrderInfo::setCreateTime));
    assertEquals("modifyTime", getFieldName(OrderInfo.class, OrderInfo::getModifyTime));
    assertEquals("modifyTime", getFieldName(OrderInfo.class, OrderInfo::setModifyTime));
    assertEquals("deleteTime", getFieldName(OrderInfo.class, OrderInfo::getDeleteTime));
    assertEquals("deleteTime", getFieldName(OrderInfo.class, OrderInfo::setDeleteTime));
  }
  //
  //  @Test
  //  public void testCalculateDiscount() throws Exception {
  //    final RandomBeanGenerator random = new RandomBeanGenerator();
  //
  //    OrderInfo order = random.nextObject(OrderInfo.class);
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
  //    OrderInfo order = random.nextObject(OrderInfo.class);
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
