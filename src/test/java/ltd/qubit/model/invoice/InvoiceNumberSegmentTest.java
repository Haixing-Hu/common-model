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
 * Unit test of the {@link InvoiceNumberSegment} class.
 *
 * @author Haixing Hu
 */
public class InvoiceNumberSegmentTest extends ModelTestBase<InvoiceNumberSegment> {

  public InvoiceNumberSegmentTest() {
    super(InvoiceNumberSegment.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getId));
    assertEquals("id", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setId));
    assertEquals("app", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getApp));
    assertEquals("app", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setApp));
    assertEquals("organization", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getOrganization));
    assertEquals("organization", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setOrganization));
    assertEquals("applyId", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getApplyId));
    assertEquals("applyId", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setApplyId));
    assertEquals("applyNumber", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getApplyNumber));
    assertEquals("applyNumber", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setApplyNumber));
    assertEquals("type", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getType));
    assertEquals("type", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setType));
    assertEquals("code", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getCode));
    assertEquals("code", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setCode));
    assertEquals("name", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getName));
    assertEquals("name", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setName));
    assertEquals("count", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getCount));
    assertEquals("count", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setCount));
    assertEquals("start", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getStart));
    assertEquals("start", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setStart));
    assertEquals("end", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getEnd));
    assertEquals("end", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setEnd));
    assertEquals("status", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getStatus));
    assertEquals("status", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setStatus));
    assertEquals("remark", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getRemark));
    assertEquals("remark", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setRemark));
    assertEquals("dispatchTime", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getDispatchTime));
    assertEquals("dispatchTime", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setDispatchTime));
    assertEquals("cancelTime", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getCancelTime));
    assertEquals("cancelTime", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setCancelTime));
    assertEquals("createTime", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getCreateTime));
    assertEquals("createTime", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setCreateTime));
    assertEquals("modifyTime", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getModifyTime));
    assertEquals("modifyTime", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setModifyTime));
    assertEquals("deleteTime", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::getDeleteTime));
    assertEquals("deleteTime", getFieldName(InvoiceNumberSegment.class, InvoiceNumberSegment::setDeleteTime));
  }
}
