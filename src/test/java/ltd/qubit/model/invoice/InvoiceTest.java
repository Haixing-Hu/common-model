////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.invoice;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Invoice} class.
 *
 * @author Haixing Hu
 */
public class InvoiceTest extends ModelTestBase<Invoice> {

  public InvoiceTest() {
    super(Invoice.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Invoice.class, Invoice::getId));
    assertEquals("id", getFieldName(Invoice.class, Invoice::setId));
    assertEquals("app", getFieldName(Invoice.class, Invoice::getApp));
    assertEquals("app", getFieldName(Invoice.class, Invoice::setApp));
    assertEquals("organization", getFieldName(Invoice.class, Invoice::getOrganization));
    assertEquals("organization", getFieldName(Invoice.class, Invoice::setOrganization));
    assertEquals("place", getFieldName(Invoice.class, Invoice::getPlace));
    assertEquals("place", getFieldName(Invoice.class, Invoice::setPlace));
    assertEquals("code", getFieldName(Invoice.class, Invoice::getCode));
    assertEquals("code", getFieldName(Invoice.class, Invoice::setCode));
    assertEquals("number", getFieldName(Invoice.class, Invoice::getNumber));
    assertEquals("number", getFieldName(Invoice.class, Invoice::setNumber));
    assertEquals("verifyCode", getFieldName(Invoice.class, Invoice::getVerifyCode));
    assertEquals("verifyCode", getFieldName(Invoice.class, Invoice::setVerifyCode));
    assertEquals("businessNumber", getFieldName(Invoice.class, Invoice::getBusinessNumber));
    assertEquals("businessNumber", getFieldName(Invoice.class, Invoice::setBusinessNumber));
    assertEquals("businessTime", getFieldName(Invoice.class, Invoice::getBusinessTime));
    assertEquals("businessTime", getFieldName(Invoice.class, Invoice::setBusinessTime));
    assertEquals("payee", getFieldName(Invoice.class, Invoice::getPayee));
    assertEquals("payee", getFieldName(Invoice.class, Invoice::setPayee));
    assertEquals("payer", getFieldName(Invoice.class, Invoice::getPayer));
    assertEquals("payer", getFieldName(Invoice.class, Invoice::setPayer));
    assertEquals("paymentChannel", getFieldName(Invoice.class, Invoice::getPaymentChannel));
    assertEquals("paymentChannel", getFieldName(Invoice.class, Invoice::setPaymentChannel));
    assertEquals("paymentMode", getFieldName(Invoice.class, Invoice::getPaymentMode));
    assertEquals("paymentMode", getFieldName(Invoice.class, Invoice::setPaymentMode));
    assertEquals("currency", getFieldName(Invoice.class, Invoice::getCurrency));
    assertEquals("currency", getFieldName(Invoice.class, Invoice::setCurrency));
    assertEquals("exchangeRate", getFieldName(Invoice.class, Invoice::getExchangeRate));
    assertEquals("exchangeRate", getFieldName(Invoice.class, Invoice::setExchangeRate));
    assertEquals("totalPrice", getFieldName(Invoice.class, Invoice::getTotalPrice));
    assertEquals("totalPrice", getFieldName(Invoice.class, Invoice::setTotalPrice));
    assertEquals("remark", getFieldName(Invoice.class, Invoice::getRemark));
    assertEquals("remark", getFieldName(Invoice.class, Invoice::setRemark));
    assertEquals("drawer", getFieldName(Invoice.class, Invoice::getDrawer));
    assertEquals("drawer", getFieldName(Invoice.class, Invoice::setDrawer));
    assertEquals("auditor", getFieldName(Invoice.class, Invoice::getAuditor));
    assertEquals("auditor", getFieldName(Invoice.class, Invoice::setAuditor));
    assertEquals("supervisorRemark", getFieldName(Invoice.class, Invoice::getSupervisorRemark));
    assertEquals("supervisorRemark", getFieldName(Invoice.class, Invoice::setSupervisorRemark));
    assertEquals("relatedInvoice", getFieldName(Invoice.class, Invoice::getRelatedInvoice));
    assertEquals("relatedInvoice", getFieldName(Invoice.class, Invoice::setRelatedInvoice));
    assertEquals("sealNumber", getFieldName(Invoice.class, Invoice::getSealNumber));
    assertEquals("sealNumber", getFieldName(Invoice.class, Invoice::setSealNumber));
    assertEquals("items", getFieldName(Invoice.class, Invoice::getItems));
    assertEquals("items", getFieldName(Invoice.class, Invoice::setItems));
    assertEquals("settlement", getFieldName(Invoice.class, Invoice::getSettlement));
    assertEquals("settlement", getFieldName(Invoice.class, Invoice::setSettlement));
    assertEquals("url", getFieldName(Invoice.class, Invoice::getUrl));
    assertEquals("url", getFieldName(Invoice.class, Invoice::setUrl));
    assertEquals("status", getFieldName(Invoice.class, Invoice::getStatus));
    assertEquals("status", getFieldName(Invoice.class, Invoice::setStatus));
    assertEquals("issueDate", getFieldName(Invoice.class, Invoice::getIssueDate));
    assertEquals("issueDate", getFieldName(Invoice.class, Invoice::setIssueDate));
    assertEquals("createTime", getFieldName(Invoice.class, Invoice::getCreateTime));
    assertEquals("createTime", getFieldName(Invoice.class, Invoice::setCreateTime));
    assertEquals("modifyTime", getFieldName(Invoice.class, Invoice::getModifyTime));
    assertEquals("modifyTime", getFieldName(Invoice.class, Invoice::setModifyTime));
    assertEquals("deleteTime", getFieldName(Invoice.class, Invoice::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Invoice.class, Invoice::setDeleteTime));
  }
}
