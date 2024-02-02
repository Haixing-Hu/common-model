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
 * Unit test of the {@link ActivityProductItem} class.
 *
 * @author Haixing Hu
 */
public class ActivityProductItemTest extends ModelTestBase<ActivityProductItem> {

  public ActivityProductItemTest() {
    super(ActivityProductItem.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("activityId", getFieldName(ActivityProductItem.class, ActivityProductItem::getActivityId));
    assertEquals("activityId", getFieldName(ActivityProductItem.class, ActivityProductItem::setActivityId));
    assertEquals("index", getFieldName(ActivityProductItem.class, ActivityProductItem::getIndex));
    assertEquals("index", getFieldName(ActivityProductItem.class, ActivityProductItem::setIndex));
    assertEquals("product", getFieldName(ActivityProductItem.class, ActivityProductItem::getProduct));
    assertEquals("product", getFieldName(ActivityProductItem.class, ActivityProductItem::setProduct));
    assertEquals("createTime", getFieldName(ActivityProductItem.class, ActivityProductItem::getCreateTime));
    assertEquals("createTime", getFieldName(ActivityProductItem.class, ActivityProductItem::setCreateTime));
    assertEquals("deleteTime", getFieldName(ActivityProductItem.class, ActivityProductItem::getDeleteTime));
    assertEquals("deleteTime", getFieldName(ActivityProductItem.class, ActivityProductItem::setDeleteTime));
  }
}
