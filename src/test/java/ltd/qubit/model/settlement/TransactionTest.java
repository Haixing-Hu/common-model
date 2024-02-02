////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.settlement;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Transaction} class.
 *
 * @author Haixing Hu
 */
public class TransactionTest extends ModelTestBase<Transaction> {

  public TransactionTest() {
    super(Transaction.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Transaction.class, Transaction::getId));
    assertEquals("id", getFieldName(Transaction.class, Transaction::setId));
    assertEquals("type", getFieldName(Transaction.class, Transaction::getType));
    assertEquals("type", getFieldName(Transaction.class, Transaction::setType));
    assertEquals("originId", getFieldName(Transaction.class, Transaction::getOriginId));
    assertEquals("originId", getFieldName(Transaction.class, Transaction::setOriginId));
    assertEquals("status", getFieldName(Transaction.class, Transaction::getStatus));
    assertEquals("status", getFieldName(Transaction.class, Transaction::setStatus));
    assertEquals("app", getFieldName(Transaction.class, Transaction::getApp));
    assertEquals("app", getFieldName(Transaction.class, Transaction::setApp));
    assertEquals("source", getFieldName(Transaction.class, Transaction::getSource));
    assertEquals("source", getFieldName(Transaction.class, Transaction::setSource));
    assertEquals("category", getFieldName(Transaction.class, Transaction::getCategory));
    assertEquals("category", getFieldName(Transaction.class, Transaction::setCategory));
    assertEquals("orderId", getFieldName(Transaction.class, Transaction::getOrderId));
    assertEquals("orderId", getFieldName(Transaction.class, Transaction::setOrderId));
    assertEquals("returnId", getFieldName(Transaction.class, Transaction::getReturnId));
    assertEquals("returnId", getFieldName(Transaction.class, Transaction::setReturnId));
    assertEquals("returnIssuer", getFieldName(Transaction.class, Transaction::getReturnIssuer));
    assertEquals("returnIssuer", getFieldName(Transaction.class, Transaction::setReturnIssuer));
    assertEquals("currency", getFieldName(Transaction.class, Transaction::getCurrency));
    assertEquals("currency", getFieldName(Transaction.class, Transaction::setCurrency));
    assertEquals("payable", getFieldName(Transaction.class, Transaction::getPayable));
    assertEquals("payable", getFieldName(Transaction.class, Transaction::setPayable));
    assertEquals("discount", getFieldName(Transaction.class, Transaction::getDiscount));
    assertEquals("discount", getFieldName(Transaction.class, Transaction::setDiscount));
    assertEquals("paid", getFieldName(Transaction.class, Transaction::getPaid));
    assertEquals("paid", getFieldName(Transaction.class, Transaction::setPaid));
    assertEquals("payee", getFieldName(Transaction.class, Transaction::getPayee));
    assertEquals("payee", getFieldName(Transaction.class, Transaction::setPayee));
    assertEquals("payer", getFieldName(Transaction.class, Transaction::getPayer));
    assertEquals("payer", getFieldName(Transaction.class, Transaction::setPayer));
    assertEquals("payment", getFieldName(Transaction.class, Transaction::getPayment));
    assertEquals("payment", getFieldName(Transaction.class, Transaction::setPayment));
    assertEquals("expiredTime", getFieldName(Transaction.class, Transaction::getExpiredTime));
    assertEquals("expiredTime", getFieldName(Transaction.class, Transaction::setExpiredTime));
    assertEquals("completeTime", getFieldName(Transaction.class, Transaction::getCompleteTime));
    assertEquals("completeTime", getFieldName(Transaction.class, Transaction::setCompleteTime));
    assertEquals("invoiceStatus", getFieldName(Transaction.class, Transaction::getInvoiceStatus));
    assertEquals("invoiceStatus", getFieldName(Transaction.class, Transaction::setInvoiceStatus));
    assertEquals("environment", getFieldName(Transaction.class, Transaction::getEnvironment));
    assertEquals("environment", getFieldName(Transaction.class, Transaction::setEnvironment));
    assertEquals("comment", getFieldName(Transaction.class, Transaction::getComment));
    assertEquals("comment", getFieldName(Transaction.class, Transaction::setComment));
    assertEquals("createTime", getFieldName(Transaction.class, Transaction::getCreateTime));
    assertEquals("createTime", getFieldName(Transaction.class, Transaction::setCreateTime));
    assertEquals("modifyTime", getFieldName(Transaction.class, Transaction::getModifyTime));
    assertEquals("modifyTime", getFieldName(Transaction.class, Transaction::setModifyTime));
    assertEquals("deleteTime", getFieldName(Transaction.class, Transaction::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Transaction.class, Transaction::setDeleteTime));
  }
}
