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
 * Unit test of the {@link MedicalSettlementItem} class.
 *
 * @author Haixing Hu
 */
public class MedicalSettlementItemTest extends ModelTestBase<MedicalSettlementItem> {

  public MedicalSettlementItemTest() {
    super(MedicalSettlementItem.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getId));
    assertEquals("id", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setId));
    assertEquals("settlementId", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getSettlementId));
    assertEquals("settlementId", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setSettlementId));
    assertEquals("index", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getIndex));
    assertEquals("index", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setIndex));
    assertEquals("type", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getType));
    assertEquals("type", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setType));
    assertEquals("chargeType", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getChargeType));
    assertEquals("chargeType", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setChargeType));
    assertEquals("code", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getCode));
    assertEquals("code", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setCode));
    assertEquals("name", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getName));
    assertEquals("name", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setName));
    assertEquals("specification", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getSpecification));
    assertEquals("specification", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setSpecification));
    assertEquals("unit", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getUnit));
    assertEquals("unit", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setUnit));
    assertEquals("price", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getPrice));
    assertEquals("price", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setPrice));
    assertEquals("amount", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getAmount));
    assertEquals("amount", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setAmount));
    assertEquals("totalPrice", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getTotalPrice));
    assertEquals("totalPrice", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setTotalPrice));
    assertEquals("selfPaid", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getSelfPaid));
    assertEquals("selfPaid", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setSelfPaid));
    assertEquals("selfPaidRate", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getSelfPaidRate));
    assertEquals("selfPaidRate", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setSelfPaidRate));
    assertEquals("reimburseLimit", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getReimburseLimit));
    assertEquals("reimburseLimit", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setReimburseLimit));
    assertEquals("payable", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getPayable));
    assertEquals("payable", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setPayable));
    assertEquals("remark", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::getRemark));
    assertEquals("remark", getFieldName(MedicalSettlementItem.class, MedicalSettlementItem::setRemark));
  }

  @Test
  public void test() throws Exception {
    xmlTester.test(type);
  }
}
