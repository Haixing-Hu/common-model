////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link RefererOrderRecord} class.
 *
 * @author Haixing Hu
 */
public class RefererOrderRecordTest extends ModelTestBase<RefererOrderRecord> {

  public RefererOrderRecordTest() {
    super(RefererOrderRecord.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getId));
    assertEquals("id", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setId));
    assertEquals("openidType", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getOpenidType));
    assertEquals("openidType", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setOpenidType));
    assertEquals("openid", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getOpenid));
    assertEquals("openid", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setOpenid));
    assertEquals("rootOpenidType", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getRootOpenidType));
    assertEquals("rootOpenidType", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setRootOpenidType));
    assertEquals("rootOpenid", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getRootOpenid));
    assertEquals("rootOpenid", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setRootOpenid));
    assertEquals("rootLevel", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getRootLevel));
    assertEquals("rootLevel", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setRootLevel));
    assertEquals("orderId", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getOrderId));
    assertEquals("orderId", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setOrderId));
    assertEquals("orderItemId", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getOrderItemId));
    assertEquals("orderItemId", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setOrderItemId));
    assertEquals("clientId", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getClientId));
    assertEquals("clientId", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setClientId));
    assertEquals("productCode", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getProductCode));
    assertEquals("productCode", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setProductCode));
    assertEquals("productItemId", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getProductItemId));
    assertEquals("productItemId", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setProductItemId));
    assertEquals("status", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getStatus));
    assertEquals("status", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setStatus));
    assertEquals("createTime", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getCreateTime));
    assertEquals("createTime", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setCreateTime));
    assertEquals("modifyTime", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getModifyTime));
    assertEquals("modifyTime", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setModifyTime));
    assertEquals("deleteTime", getFieldName(RefererOrderRecord.class, RefererOrderRecord::getDeleteTime));
    assertEquals("deleteTime", getFieldName(RefererOrderRecord.class, RefererOrderRecord::setDeleteTime));
  }
}
