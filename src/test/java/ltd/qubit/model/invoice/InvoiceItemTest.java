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
 * Unit test of the {@link InvoiceItem} class.
 *
 * @author Haixing Hu
 */
public class InvoiceItemTest extends ModelTestBase<InvoiceItem> {

  public InvoiceItemTest() {
    super(InvoiceItem.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(InvoiceItem.class, InvoiceItem::getId));
    assertEquals("id", getFieldName(InvoiceItem.class, InvoiceItem::setId));
    assertEquals("invoiceId", getFieldName(InvoiceItem.class, InvoiceItem::getInvoiceId));
    assertEquals("invoiceId", getFieldName(InvoiceItem.class, InvoiceItem::setInvoiceId));
    assertEquals("index", getFieldName(InvoiceItem.class, InvoiceItem::getIndex));
    assertEquals("index", getFieldName(InvoiceItem.class, InvoiceItem::setIndex));
    assertEquals("code", getFieldName(InvoiceItem.class, InvoiceItem::getCode));
    assertEquals("code", getFieldName(InvoiceItem.class, InvoiceItem::setCode));
    assertEquals("name", getFieldName(InvoiceItem.class, InvoiceItem::getName));
    assertEquals("name", getFieldName(InvoiceItem.class, InvoiceItem::setName));
    assertEquals("specification", getFieldName(InvoiceItem.class, InvoiceItem::getSpecification));
    assertEquals("specification", getFieldName(InvoiceItem.class, InvoiceItem::setSpecification));
    assertEquals("unit", getFieldName(InvoiceItem.class, InvoiceItem::getUnit));
    assertEquals("unit", getFieldName(InvoiceItem.class, InvoiceItem::setUnit));
    assertEquals("price", getFieldName(InvoiceItem.class, InvoiceItem::getPrice));
    assertEquals("price", getFieldName(InvoiceItem.class, InvoiceItem::setPrice));
    assertEquals("discount", getFieldName(InvoiceItem.class, InvoiceItem::getDiscount));
    assertEquals("discount", getFieldName(InvoiceItem.class, InvoiceItem::setDiscount));
    assertEquals("amount", getFieldName(InvoiceItem.class, InvoiceItem::getAmount));
    assertEquals("amount", getFieldName(InvoiceItem.class, InvoiceItem::setAmount));
    assertEquals("totalDiscount", getFieldName(InvoiceItem.class, InvoiceItem::getTotalDiscount));
    assertEquals("totalDiscount", getFieldName(InvoiceItem.class, InvoiceItem::setTotalDiscount));
    assertEquals("payable", getFieldName(InvoiceItem.class, InvoiceItem::getPayable));
    assertEquals("payable", getFieldName(InvoiceItem.class, InvoiceItem::setPayable));
    assertEquals("taxRate", getFieldName(InvoiceItem.class, InvoiceItem::getTaxRate));
    assertEquals("taxRate", getFieldName(InvoiceItem.class, InvoiceItem::setTaxRate));
    assertEquals("tax", getFieldName(InvoiceItem.class, InvoiceItem::getTax));
    assertEquals("tax", getFieldName(InvoiceItem.class, InvoiceItem::setTax));
    assertEquals("paid", getFieldName(InvoiceItem.class, InvoiceItem::getPaid));
    assertEquals("paid", getFieldName(InvoiceItem.class, InvoiceItem::setPaid));
    assertEquals("remark", getFieldName(InvoiceItem.class, InvoiceItem::getRemark));
    assertEquals("remark", getFieldName(InvoiceItem.class, InvoiceItem::setRemark));
  }
}
