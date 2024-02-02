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
 * Unit test of the {@link Coupon} class.
 *
 * @author Haixing Hu
 */
public class CouponTest extends ModelTestBase<Coupon> {

  public CouponTest() {
    super(Coupon.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Coupon.class, Coupon::getId));
    assertEquals("id", getFieldName(Coupon.class, Coupon::setId));
    assertEquals("code", getFieldName(Coupon.class, Coupon::getCode));
    assertEquals("code", getFieldName(Coupon.class, Coupon::setCode));
    assertEquals("name", getFieldName(Coupon.class, Coupon::getName));
    assertEquals("name", getFieldName(Coupon.class, Coupon::setName));
    assertEquals("app", getFieldName(Coupon.class, Coupon::getApp));
    assertEquals("app", getFieldName(Coupon.class, Coupon::setApp));
    assertEquals("sellerId", getFieldName(Coupon.class, Coupon::getSellerId));
    assertEquals("sellerId", getFieldName(Coupon.class, Coupon::setSellerId));
    assertEquals("sellerName", getFieldName(Coupon.class, Coupon::getSellerName));
    assertEquals("sellerName", getFieldName(Coupon.class, Coupon::setSellerName));
    assertEquals("image", getFieldName(Coupon.class, Coupon::getImage));
    assertEquals("image", getFieldName(Coupon.class, Coupon::setImage));
    assertEquals("description", getFieldName(Coupon.class, Coupon::getDescription));
    assertEquals("description", getFieldName(Coupon.class, Coupon::setDescription));
    assertEquals("rule", getFieldName(Coupon.class, Coupon::getRule));
    assertEquals("rule", getFieldName(Coupon.class, Coupon::setRule));
    assertEquals("startTime", getFieldName(Coupon.class, Coupon::getStartTime));
    assertEquals("startTime", getFieldName(Coupon.class, Coupon::setStartTime));
    assertEquals("endTime", getFieldName(Coupon.class, Coupon::getEndTime));
    assertEquals("endTime", getFieldName(Coupon.class, Coupon::setEndTime));
    assertEquals("state", getFieldName(Coupon.class, Coupon::getState));
    assertEquals("state", getFieldName(Coupon.class, Coupon::setState));
    assertEquals("createTime", getFieldName(Coupon.class, Coupon::getCreateTime));
    assertEquals("createTime", getFieldName(Coupon.class, Coupon::setCreateTime));
    assertEquals("modifyTime", getFieldName(Coupon.class, Coupon::getModifyTime));
    assertEquals("modifyTime", getFieldName(Coupon.class, Coupon::setModifyTime));
    assertEquals("deleteTime", getFieldName(Coupon.class, Coupon::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Coupon.class, Coupon::setDeleteTime));
  }
}
