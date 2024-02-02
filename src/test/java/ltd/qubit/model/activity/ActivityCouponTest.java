////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.activity;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link ActivityCoupon} class.
 *
 * @author Haixing Hu
 */
public class ActivityCouponTest extends ModelTestBase<ActivityCoupon> {

  public ActivityCouponTest() {
    super(ActivityCoupon.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(ActivityCoupon.class, ActivityCoupon::getId));
    assertEquals("id", getFieldName(ActivityCoupon.class, ActivityCoupon::setId));
    assertEquals("activity", getFieldName(ActivityCoupon.class, ActivityCoupon::getActivity));
    assertEquals("activity", getFieldName(ActivityCoupon.class, ActivityCoupon::setActivity));
    assertEquals("couponCode", getFieldName(ActivityCoupon.class, ActivityCoupon::getCouponCode));
    assertEquals("couponCode", getFieldName(ActivityCoupon.class, ActivityCoupon::setCouponCode));
    assertEquals("person", getFieldName(ActivityCoupon.class, ActivityCoupon::getPerson));
    assertEquals("person", getFieldName(ActivityCoupon.class, ActivityCoupon::setPerson));
    assertEquals("order", getFieldName(ActivityCoupon.class, ActivityCoupon::getOrder));
    assertEquals("order", getFieldName(ActivityCoupon.class, ActivityCoupon::setOrder));
    assertEquals("createTime", getFieldName(ActivityCoupon.class, ActivityCoupon::getCreateTime));
    assertEquals("createTime", getFieldName(ActivityCoupon.class, ActivityCoupon::setCreateTime));
    assertEquals("receiveTime", getFieldName(ActivityCoupon.class, ActivityCoupon::getReceiveTime));
    assertEquals("receiveTime", getFieldName(ActivityCoupon.class, ActivityCoupon::setReceiveTime));
  }
}
