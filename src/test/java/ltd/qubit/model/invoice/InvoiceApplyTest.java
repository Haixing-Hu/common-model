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
 * Unit test of the {@link InvoiceApply} class.
 *
 * @author Haixing Hu
 */
public class InvoiceApplyTest extends ModelTestBase<InvoiceApply> {

  public InvoiceApplyTest() {
    super(InvoiceApply.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(InvoiceApply.class, InvoiceApply::getId));
    assertEquals("id", getFieldName(InvoiceApply.class, InvoiceApply::setId));
    assertEquals("app", getFieldName(InvoiceApply.class, InvoiceApply::getApp));
    assertEquals("app", getFieldName(InvoiceApply.class, InvoiceApply::setApp));
    assertEquals("organization", getFieldName(InvoiceApply.class, InvoiceApply::getOrganization));
    assertEquals("organization", getFieldName(InvoiceApply.class, InvoiceApply::setOrganization));
    assertEquals("applicant", getFieldName(InvoiceApply.class, InvoiceApply::getApplicant));
    assertEquals("applicant", getFieldName(InvoiceApply.class, InvoiceApply::setApplicant));
    assertEquals("type", getFieldName(InvoiceApply.class, InvoiceApply::getType));
    assertEquals("type", getFieldName(InvoiceApply.class, InvoiceApply::setType));
    assertEquals("number", getFieldName(InvoiceApply.class, InvoiceApply::getNumber));
    assertEquals("number", getFieldName(InvoiceApply.class, InvoiceApply::setNumber));
    assertEquals("count", getFieldName(InvoiceApply.class, InvoiceApply::getCount));
    assertEquals("count", getFieldName(InvoiceApply.class, InvoiceApply::setCount));
    assertEquals("status", getFieldName(InvoiceApply.class, InvoiceApply::getStatus));
    assertEquals("status", getFieldName(InvoiceApply.class, InvoiceApply::setStatus));
    assertEquals("applyRemark", getFieldName(InvoiceApply.class, InvoiceApply::getApplyRemark));
    assertEquals("applyRemark", getFieldName(InvoiceApply.class, InvoiceApply::setApplyRemark));
    assertEquals("cancelRemark", getFieldName(InvoiceApply.class, InvoiceApply::getCancelRemark));
    assertEquals("cancelRemark", getFieldName(InvoiceApply.class, InvoiceApply::setCancelRemark));
    assertEquals("approveRemark", getFieldName(InvoiceApply.class, InvoiceApply::getApproveRemark));
    assertEquals("approveRemark", getFieldName(InvoiceApply.class, InvoiceApply::setApproveRemark));
    assertEquals("applyTime", getFieldName(InvoiceApply.class, InvoiceApply::getApplyTime));
    assertEquals("applyTime", getFieldName(InvoiceApply.class, InvoiceApply::setApplyTime));
    assertEquals("cancelTime", getFieldName(InvoiceApply.class, InvoiceApply::getCancelTime));
    assertEquals("cancelTime", getFieldName(InvoiceApply.class, InvoiceApply::setCancelTime));
    assertEquals("approveTime", getFieldName(InvoiceApply.class, InvoiceApply::getApproveTime));
    assertEquals("approveTime", getFieldName(InvoiceApply.class, InvoiceApply::setApproveTime));
    assertEquals("createTime", getFieldName(InvoiceApply.class, InvoiceApply::getCreateTime));
    assertEquals("createTime", getFieldName(InvoiceApply.class, InvoiceApply::setCreateTime));
    assertEquals("modifyTime", getFieldName(InvoiceApply.class, InvoiceApply::getModifyTime));
    assertEquals("modifyTime", getFieldName(InvoiceApply.class, InvoiceApply::setModifyTime));
    assertEquals("deleteTime", getFieldName(InvoiceApply.class, InvoiceApply::getDeleteTime));
    assertEquals("deleteTime", getFieldName(InvoiceApply.class, InvoiceApply::setDeleteTime));
  }
}
