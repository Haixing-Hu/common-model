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
 * Unit test of the {@link Return} class.
 *
 * @author Haixing Hu
 */
public class ReturnTest extends ModelTestBase<Return> {

  public ReturnTest() {
    super(Return.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Return.class, Return::getId));
    assertEquals("id", getFieldName(Return.class, Return::setId));
    assertEquals("orderId", getFieldName(Return.class, Return::getOrderId));
    assertEquals("orderId", getFieldName(Return.class, Return::setOrderId));
    assertEquals("orderItemId", getFieldName(Return.class, Return::getOrderItemId));
    assertEquals("orderItemId", getFieldName(Return.class, Return::setOrderItemId));
    assertEquals("transactionId", getFieldName(Return.class, Return::getTransactionId));
    assertEquals("transactionId", getFieldName(Return.class, Return::setTransactionId));
    assertEquals("issuer", getFieldName(Return.class, Return::getIssuer));
    assertEquals("issuer", getFieldName(Return.class, Return::setIssuer));
    assertEquals("product", getFieldName(Return.class, Return::getProduct));
    assertEquals("product", getFieldName(Return.class, Return::setProduct));
    assertEquals("count", getFieldName(Return.class, Return::getCount));
    assertEquals("count", getFieldName(Return.class, Return::setCount));
    assertEquals("currency", getFieldName(Return.class, Return::getCurrency));
    assertEquals("currency", getFieldName(Return.class, Return::setCurrency));
    assertEquals("refundable", getFieldName(Return.class, Return::getRefundable));
    assertEquals("refundable", getFieldName(Return.class, Return::setRefundable));
    assertEquals("refunded", getFieldName(Return.class, Return::getRefunded));
    assertEquals("refunded", getFieldName(Return.class, Return::setRefunded));
    assertEquals("clients", getFieldName(Return.class, Return::getClients));
    assertEquals("clients", getFieldName(Return.class, Return::setClients));
    assertEquals("reason", getFieldName(Return.class, Return::getReason));
    assertEquals("reason", getFieldName(Return.class, Return::setReason));
    assertEquals("comment", getFieldName(Return.class, Return::getComment));
    assertEquals("comment", getFieldName(Return.class, Return::setComment));
    assertEquals("status", getFieldName(Return.class, Return::getStatus));
    assertEquals("status", getFieldName(Return.class, Return::setStatus));
    assertEquals("rejectReason", getFieldName(Return.class, Return::getRejectReason));
    assertEquals("rejectReason", getFieldName(Return.class, Return::setRejectReason));
    assertEquals("shippingId", getFieldName(Return.class, Return::getShippingId));
    assertEquals("shippingId", getFieldName(Return.class, Return::setShippingId));
    assertEquals("shippingNumber", getFieldName(Return.class, Return::getShippingNumber));
    assertEquals("shippingNumber", getFieldName(Return.class, Return::setShippingNumber));
    assertEquals("invoiceStatus", getFieldName(Return.class, Return::getInvoiceStatus));
    assertEquals("invoiceStatus", getFieldName(Return.class, Return::setInvoiceStatus));
    assertEquals("environment", getFieldName(Return.class, Return::getEnvironment));
    assertEquals("environment", getFieldName(Return.class, Return::setEnvironment));
    assertEquals("expiredTime", getFieldName(Return.class, Return::getExpiredTime));
    assertEquals("expiredTime", getFieldName(Return.class, Return::setExpiredTime));
    assertEquals("refundTime", getFieldName(Return.class, Return::getRefundTime));
    assertEquals("refundTime", getFieldName(Return.class, Return::setRefundTime));
    assertEquals("shipTime", getFieldName(Return.class, Return::getShipTime));
    assertEquals("shipTime", getFieldName(Return.class, Return::setShipTime));
    assertEquals("completeTime", getFieldName(Return.class, Return::getCompleteTime));
    assertEquals("completeTime", getFieldName(Return.class, Return::setCompleteTime));
    assertEquals("cancelTime", getFieldName(Return.class, Return::getCancelTime));
    assertEquals("cancelTime", getFieldName(Return.class, Return::setCancelTime));
    assertEquals("createTime", getFieldName(Return.class, Return::getCreateTime));
    assertEquals("createTime", getFieldName(Return.class, Return::setCreateTime));
    assertEquals("modifyTime", getFieldName(Return.class, Return::getModifyTime));
    assertEquals("modifyTime", getFieldName(Return.class, Return::setModifyTime));
    assertEquals("deleteTime", getFieldName(Return.class, Return::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Return.class, Return::setDeleteTime));
  }
}
