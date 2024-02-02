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
 * Unit test of the {@link InvoiceInfo} class.
 *
 * @author Haixing Hu
 */
public class InvoiceInfoTest extends ModelTestBase<InvoiceInfo> {

  public InvoiceInfoTest() {
    super(InvoiceInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(InvoiceInfo.class, InvoiceInfo::getId));
    assertEquals("id", getFieldName(InvoiceInfo.class, InvoiceInfo::setId));
    assertEquals("code", getFieldName(InvoiceInfo.class, InvoiceInfo::getCode));
    assertEquals("code", getFieldName(InvoiceInfo.class, InvoiceInfo::setCode));
    assertEquals("number", getFieldName(InvoiceInfo.class, InvoiceInfo::getNumber));
    assertEquals("number", getFieldName(InvoiceInfo.class, InvoiceInfo::setNumber));
    assertEquals("businessNumber", getFieldName(InvoiceInfo.class, InvoiceInfo::getBusinessNumber));
    assertEquals("businessNumber", getFieldName(InvoiceInfo.class, InvoiceInfo::setBusinessNumber));
    assertEquals("issueDate", getFieldName(InvoiceInfo.class, InvoiceInfo::getIssueDate));
    assertEquals("issueDate", getFieldName(InvoiceInfo.class, InvoiceInfo::setIssueDate));
    assertEquals("payeeName", getFieldName(InvoiceInfo.class, InvoiceInfo::getPayeeName));
    assertEquals("payeeName", getFieldName(InvoiceInfo.class, InvoiceInfo::setPayeeName));
    assertEquals("payerName", getFieldName(InvoiceInfo.class, InvoiceInfo::getPayerName));
    assertEquals("payerName", getFieldName(InvoiceInfo.class, InvoiceInfo::setPayerName));
    assertEquals("currency", getFieldName(InvoiceInfo.class, InvoiceInfo::getCurrency));
    assertEquals("currency", getFieldName(InvoiceInfo.class, InvoiceInfo::setCurrency));
    assertEquals("totalAmount", getFieldName(InvoiceInfo.class, InvoiceInfo::getTotalAmount));
    assertEquals("totalAmount", getFieldName(InvoiceInfo.class, InvoiceInfo::setTotalAmount));
    assertEquals("url", getFieldName(InvoiceInfo.class, InvoiceInfo::getUrl));
    assertEquals("url", getFieldName(InvoiceInfo.class, InvoiceInfo::setUrl));
    assertEquals("status", getFieldName(InvoiceInfo.class, InvoiceInfo::getStatus));
    assertEquals("status", getFieldName(InvoiceInfo.class, InvoiceInfo::setStatus));
  }
}
