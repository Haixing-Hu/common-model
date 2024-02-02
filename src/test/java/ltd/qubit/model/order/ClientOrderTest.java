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
 * Unit test of the {@link ClientOrder} class.
 *
 * @author Haixing Hu
 */
public class ClientOrderTest extends ModelTestBase<ClientOrder> {

  public ClientOrderTest() {
    super(ClientOrder.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("client", getFieldName(ClientOrder.class, ClientOrder::getClient));
    assertEquals("client", getFieldName(ClientOrder.class, ClientOrder::setClient));
    assertEquals("app", getFieldName(ClientOrder.class, ClientOrder::getApp));
    assertEquals("app", getFieldName(ClientOrder.class, ClientOrder::setApp));
    assertEquals("orderId", getFieldName(ClientOrder.class, ClientOrder::getOrderId));
    assertEquals("orderId", getFieldName(ClientOrder.class, ClientOrder::setOrderId));
    assertEquals("payload", getFieldName(ClientOrder.class, ClientOrder::getPayload));
    assertEquals("payload", getFieldName(ClientOrder.class, ClientOrder::setPayload));
    assertEquals("orderItemId", getFieldName(ClientOrder.class, ClientOrder::getOrderItemId));
    assertEquals("orderItemId", getFieldName(ClientOrder.class, ClientOrder::setOrderItemId));
    assertEquals("returnId", getFieldName(ClientOrder.class, ClientOrder::getReturnId));
    assertEquals("returnId", getFieldName(ClientOrder.class, ClientOrder::setReturnId));
    assertEquals("payTransactionId", getFieldName(ClientOrder.class, ClientOrder::getPayTransactionId));
    assertEquals("payTransactionId", getFieldName(ClientOrder.class, ClientOrder::setPayTransactionId));
    assertEquals("refundTransactionId", getFieldName(ClientOrder.class, ClientOrder::getRefundTransactionId));
    assertEquals("refundTransactionId", getFieldName(ClientOrder.class, ClientOrder::setRefundTransactionId));
    assertEquals("orderStatus", getFieldName(ClientOrder.class, ClientOrder::getOrderStatus));
    assertEquals("orderStatus", getFieldName(ClientOrder.class, ClientOrder::setOrderStatus));
    assertEquals("returnStatus", getFieldName(ClientOrder.class, ClientOrder::getReturnStatus));
    assertEquals("returnStatus", getFieldName(ClientOrder.class, ClientOrder::setReturnStatus));
    assertEquals("invoiceStatus", getFieldName(ClientOrder.class, ClientOrder::getInvoiceStatus));
    assertEquals("invoiceStatus", getFieldName(ClientOrder.class, ClientOrder::setInvoiceStatus));
    assertEquals("product", getFieldName(ClientOrder.class, ClientOrder::getProduct));
    assertEquals("product", getFieldName(ClientOrder.class, ClientOrder::setProduct));
    assertEquals("count", getFieldName(ClientOrder.class, ClientOrder::getCount));
    assertEquals("count", getFieldName(ClientOrder.class, ClientOrder::setCount));
    assertEquals("payable", getFieldName(ClientOrder.class, ClientOrder::getPayable));
    assertEquals("payable", getFieldName(ClientOrder.class, ClientOrder::setPayable));
    assertEquals("paid", getFieldName(ClientOrder.class, ClientOrder::getPaid));
    assertEquals("paid", getFieldName(ClientOrder.class, ClientOrder::setPaid));
    assertEquals("refundable", getFieldName(ClientOrder.class, ClientOrder::getRefundable));
    assertEquals("refundable", getFieldName(ClientOrder.class, ClientOrder::setRefundable));
    assertEquals("refunded", getFieldName(ClientOrder.class, ClientOrder::getRefunded));
    assertEquals("refunded", getFieldName(ClientOrder.class, ClientOrder::setRefunded));
    assertEquals("orderTime", getFieldName(ClientOrder.class, ClientOrder::getOrderTime));
    assertEquals("orderTime", getFieldName(ClientOrder.class, ClientOrder::setOrderTime));
    assertEquals("payTime", getFieldName(ClientOrder.class, ClientOrder::getPayTime));
    assertEquals("payTime", getFieldName(ClientOrder.class, ClientOrder::setPayTime));
    assertEquals("refundTime", getFieldName(ClientOrder.class, ClientOrder::getRefundTime));
    assertEquals("refundTime", getFieldName(ClientOrder.class, ClientOrder::setRefundTime));
    assertEquals("payChannel", getFieldName(ClientOrder.class, ClientOrder::getPayChannel));
    assertEquals("payChannel", getFieldName(ClientOrder.class, ClientOrder::setPayChannel));
    assertEquals("payMode", getFieldName(ClientOrder.class, ClientOrder::getPayMode));
    assertEquals("payMode", getFieldName(ClientOrder.class, ClientOrder::setPayMode));
    assertEquals("payNumber", getFieldName(ClientOrder.class, ClientOrder::getPayNumber));
    assertEquals("payNumber", getFieldName(ClientOrder.class, ClientOrder::setPayNumber));
    assertEquals("payChannelNumber", getFieldName(ClientOrder.class, ClientOrder::getPayChannelNumber));
    assertEquals("payChannelNumber", getFieldName(ClientOrder.class, ClientOrder::setPayChannelNumber));
    assertEquals("refundChannel", getFieldName(ClientOrder.class, ClientOrder::getRefundChannel));
    assertEquals("refundChannel", getFieldName(ClientOrder.class, ClientOrder::setRefundChannel));
    assertEquals("refundMode", getFieldName(ClientOrder.class, ClientOrder::getRefundMode));
    assertEquals("refundMode", getFieldName(ClientOrder.class, ClientOrder::setRefundMode));
    assertEquals("refundNumber", getFieldName(ClientOrder.class, ClientOrder::getRefundNumber));
    assertEquals("refundNumber", getFieldName(ClientOrder.class, ClientOrder::setRefundNumber));
    assertEquals("refundChannelNumber", getFieldName(ClientOrder.class, ClientOrder::getRefundChannelNumber));
    assertEquals("refundChannelNumber", getFieldName(ClientOrder.class, ClientOrder::setRefundChannelNumber));
    assertEquals("source", getFieldName(ClientOrder.class, ClientOrder::getSource));
    assertEquals("source", getFieldName(ClientOrder.class, ClientOrder::setSource));
    assertEquals("organization", getFieldName(ClientOrder.class, ClientOrder::getOrganization));
    assertEquals("organization", getFieldName(ClientOrder.class, ClientOrder::setOrganization));
    assertEquals("account", getFieldName(ClientOrder.class, ClientOrder::getAccount));
    assertEquals("account", getFieldName(ClientOrder.class, ClientOrder::setAccount));
  }
}
