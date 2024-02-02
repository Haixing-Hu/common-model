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
 * Unit test of the {@link InvoicePlace} class.
 *
 * @author Haixing Hu
 */
public class InvoicePlaceTest extends ModelTestBase<InvoicePlace> {

  public InvoicePlaceTest() {
    super(InvoicePlace.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(InvoicePlace.class, InvoicePlace::getId));
    assertEquals("id", getFieldName(InvoicePlace.class, InvoicePlace::setId));
    assertEquals("app", getFieldName(InvoicePlace.class, InvoicePlace::getApp));
    assertEquals("app", getFieldName(InvoicePlace.class, InvoicePlace::setApp));
    assertEquals("organization", getFieldName(InvoicePlace.class, InvoicePlace::getOrganization));
    assertEquals("organization", getFieldName(InvoicePlace.class, InvoicePlace::setOrganization));
    assertEquals("code", getFieldName(InvoicePlace.class, InvoicePlace::getCode));
    assertEquals("code", getFieldName(InvoicePlace.class, InvoicePlace::setCode));
    assertEquals("name", getFieldName(InvoicePlace.class, InvoicePlace::getName));
    assertEquals("name", getFieldName(InvoicePlace.class, InvoicePlace::setName));
    assertEquals("state", getFieldName(InvoicePlace.class, InvoicePlace::getState));
    assertEquals("state", getFieldName(InvoicePlace.class, InvoicePlace::setState));
    assertEquals("createTime", getFieldName(InvoicePlace.class, InvoicePlace::getCreateTime));
    assertEquals("createTime", getFieldName(InvoicePlace.class, InvoicePlace::setCreateTime));
    assertEquals("modifyTime", getFieldName(InvoicePlace.class, InvoicePlace::getModifyTime));
    assertEquals("modifyTime", getFieldName(InvoicePlace.class, InvoicePlace::setModifyTime));
    assertEquals("deleteTime", getFieldName(InvoicePlace.class, InvoicePlace::getDeleteTime));
    assertEquals("deleteTime", getFieldName(InvoicePlace.class, InvoicePlace::setDeleteTime));
  }
}
