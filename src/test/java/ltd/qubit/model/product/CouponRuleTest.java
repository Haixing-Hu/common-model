////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.product;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link CouponRule} class.
 *
 * @author Haixing Hu
 */
public class CouponRuleTest extends ModelTestBase<CouponRule> {

  public CouponRuleTest() {
    super(CouponRule.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(CouponRule.class, CouponRule::getId));
    assertEquals("id", getFieldName(CouponRule.class, CouponRule::setId));
    assertEquals("code", getFieldName(CouponRule.class, CouponRule::getCode));
    assertEquals("code", getFieldName(CouponRule.class, CouponRule::setCode));
    assertEquals("name", getFieldName(CouponRule.class, CouponRule::getName));
    assertEquals("name", getFieldName(CouponRule.class, CouponRule::setName));
    assertEquals("app", getFieldName(CouponRule.class, CouponRule::getApp));
    assertEquals("app", getFieldName(CouponRule.class, CouponRule::setApp));
    assertEquals("rule", getFieldName(CouponRule.class, CouponRule::getRule));
    assertEquals("rule", getFieldName(CouponRule.class, CouponRule::setRule));
    assertEquals("description", getFieldName(CouponRule.class, CouponRule::getDescription));
    assertEquals("description", getFieldName(CouponRule.class, CouponRule::setDescription));
    assertEquals("createTime", getFieldName(CouponRule.class, CouponRule::getCreateTime));
    assertEquals("createTime", getFieldName(CouponRule.class, CouponRule::setCreateTime));
    assertEquals("modifyTime", getFieldName(CouponRule.class, CouponRule::getModifyTime));
    assertEquals("modifyTime", getFieldName(CouponRule.class, CouponRule::setModifyTime));
    assertEquals("deleteTime", getFieldName(CouponRule.class, CouponRule::getDeleteTime));
    assertEquals("deleteTime", getFieldName(CouponRule.class, CouponRule::setDeleteTime));
  }
}
