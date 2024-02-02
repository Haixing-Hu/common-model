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
 * Unit test of the {@link MedicalSettlement} class.
 *
 * @author Haixing Hu
 */
public class MedicalSettlementTest extends ModelTestBase<MedicalSettlement> {

  public MedicalSettlementTest() {
    super(MedicalSettlement.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("medicare", getFieldName(MedicalSettlement.class, MedicalSettlement::getMedicare));
    assertEquals("medicare", getFieldName(MedicalSettlement.class, MedicalSettlement::setMedicare));
    assertEquals("patient", getFieldName(MedicalSettlement.class, MedicalSettlement::getPatient));
    assertEquals("patient", getFieldName(MedicalSettlement.class, MedicalSettlement::setPatient));
    assertEquals("card", getFieldName(MedicalSettlement.class, MedicalSettlement::getCard));
    assertEquals("card", getFieldName(MedicalSettlement.class, MedicalSettlement::setCard));
    assertEquals("hisInfo", getFieldName(MedicalSettlement.class, MedicalSettlement::getHisInfo));
    assertEquals("hisInfo", getFieldName(MedicalSettlement.class, MedicalSettlement::setHisInfo));
    assertEquals("payment", getFieldName(MedicalSettlement.class, MedicalSettlement::getPayment));
    assertEquals("payment", getFieldName(MedicalSettlement.class, MedicalSettlement::setPayment));
    assertEquals("items", getFieldName(MedicalSettlement.class, MedicalSettlement::getItems));
    assertEquals("items", getFieldName(MedicalSettlement.class, MedicalSettlement::setItems));
  }
}
