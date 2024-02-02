////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Prescription} class.
 *
 * @author Haixing Hu
 */
public class PrescriptionTest  extends ModelTestBase<Prescription> {

  public PrescriptionTest() {
    super(Prescription.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Prescription.class, Prescription::getId));
    assertEquals("id", getFieldName(Prescription.class, Prescription::setId));
    assertEquals("content", getFieldName(Prescription.class, Prescription::getContent));
    assertEquals("content", getFieldName(Prescription.class, Prescription::setContent));
    assertEquals("auditor", getFieldName(Prescription.class, Prescription::getAuditor));
    assertEquals("auditor", getFieldName(Prescription.class, Prescription::setAuditor));
    assertEquals("inspector", getFieldName(Prescription.class, Prescription::getInspector));
    assertEquals("inspector", getFieldName(Prescription.class, Prescription::setInspector));
    assertEquals("pharmacist", getFieldName(Prescription.class, Prescription::getPharmacist));
    assertEquals("pharmacist", getFieldName(Prescription.class, Prescription::setPharmacist));
    assertEquals("reviewer", getFieldName(Prescription.class, Prescription::getReviewer));
    assertEquals("reviewer", getFieldName(Prescription.class, Prescription::setReviewer));
    assertEquals("consignor", getFieldName(Prescription.class, Prescription::getConsignor));
    assertEquals("consignor", getFieldName(Prescription.class, Prescription::setConsignor));
    assertEquals("signatures", getFieldName(Prescription.class, Prescription::getSignatures));
    assertEquals("signatures", getFieldName(Prescription.class, Prescription::setSignatures));
    assertEquals("status", getFieldName(Prescription.class, Prescription::getStatus));
    assertEquals("status", getFieldName(Prescription.class, Prescription::setStatus));
    assertEquals("orderId", getFieldName(Prescription.class, Prescription::getOrderId));
    assertEquals("orderId", getFieldName(Prescription.class, Prescription::setOrderId));
    assertEquals("createTime", getFieldName(Prescription.class, Prescription::getCreateTime));
    assertEquals("createTime", getFieldName(Prescription.class, Prescription::setCreateTime));
    assertEquals("modifyTime", getFieldName(Prescription.class, Prescription::getModifyTime));
    assertEquals("modifyTime", getFieldName(Prescription.class, Prescription::setModifyTime));
    assertEquals("deleteTime", getFieldName(Prescription.class, Prescription::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Prescription.class, Prescription::setDeleteTime));
  }
}
