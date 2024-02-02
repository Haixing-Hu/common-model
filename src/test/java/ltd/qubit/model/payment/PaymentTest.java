////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Payment} class.
 *
 * @author Haixing Hu
 */
public class PaymentTest extends ModelTestBase<Payment> {

  public PaymentTest() {
    super(Payment.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Payment.class, Payment::getId));
    assertEquals("id", getFieldName(Payment.class, Payment::setId));
    assertEquals("type", getFieldName(Payment.class, Payment::getType));
    assertEquals("type", getFieldName(Payment.class, Payment::setType));
    assertEquals("orderId", getFieldName(Payment.class, Payment::getOrderId));
    assertEquals("orderId", getFieldName(Payment.class, Payment::setOrderId));
    assertEquals("transactionId", getFieldName(Payment.class, Payment::getTransactionId));
    assertEquals("transactionId", getFieldName(Payment.class, Payment::setTransactionId));
    assertEquals("providerApp", getFieldName(Payment.class, Payment::getProviderApp));
    assertEquals("providerApp", getFieldName(Payment.class, Payment::setProviderApp));
    assertEquals("channel", getFieldName(Payment.class, Payment::getChannel));
    assertEquals("channel", getFieldName(Payment.class, Payment::setChannel));
    assertEquals("mode", getFieldName(Payment.class, Payment::getMode));
    assertEquals("mode", getFieldName(Payment.class, Payment::setMode));
    assertEquals("number", getFieldName(Payment.class, Payment::getNumber));
    assertEquals("number", getFieldName(Payment.class, Payment::setNumber));
    assertEquals("channelNumber", getFieldName(Payment.class, Payment::getChannelNumber));
    assertEquals("channelNumber", getFieldName(Payment.class, Payment::setChannelNumber));
    assertEquals("channelReply", getFieldName(Payment.class, Payment::getChannelReply));
    assertEquals("channelReply", getFieldName(Payment.class, Payment::setChannelReply));
    assertEquals("currency", getFieldName(Payment.class, Payment::getCurrency));
    assertEquals("currency", getFieldName(Payment.class, Payment::setCurrency));
    assertEquals("payable", getFieldName(Payment.class, Payment::getPayable));
    assertEquals("payable", getFieldName(Payment.class, Payment::setPayable));
    assertEquals("discount", getFieldName(Payment.class, Payment::getDiscount));
    assertEquals("discount", getFieldName(Payment.class, Payment::setDiscount));
    assertEquals("paid", getFieldName(Payment.class, Payment::getPaid));
    assertEquals("paid", getFieldName(Payment.class, Payment::setPaid));
    assertEquals("cost", getFieldName(Payment.class, Payment::getCost));
    assertEquals("cost", getFieldName(Payment.class, Payment::setCost));
    assertEquals("environment", getFieldName(Payment.class, Payment::getEnvironment));
    assertEquals("environment", getFieldName(Payment.class, Payment::setEnvironment));
    assertEquals("success", getFieldName(Payment.class, Payment::isSuccess));
    assertEquals("success", getFieldName(Payment.class, Payment::setSuccess));
    assertEquals("error", getFieldName(Payment.class, Payment::getError));
    assertEquals("error", getFieldName(Payment.class, Payment::setError));
    assertEquals("createTime", getFieldName(Payment.class, Payment::getCreateTime));
    assertEquals("createTime", getFieldName(Payment.class, Payment::setCreateTime));
    assertEquals("completeTime", getFieldName(Payment.class, Payment::getCompleteTime));
    assertEquals("completeTime", getFieldName(Payment.class, Payment::setCompleteTime));
    assertEquals("modifyTime", getFieldName(Payment.class, Payment::getModifyTime));
    assertEquals("modifyTime", getFieldName(Payment.class, Payment::setModifyTime));
    assertEquals("deleteTime", getFieldName(Payment.class, Payment::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Payment.class, Payment::setDeleteTime));
  }
}
