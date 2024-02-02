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
 * Unit test of the {@link Activity} class.
 *
 * @author Haixing Hu
 */
public class ActivityTest extends ModelTestBase<Activity> {

  public ActivityTest() {
    super(Activity.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Activity.class, Activity::getId));
    assertEquals("id", getFieldName(Activity.class, Activity::setId));
    assertEquals("code", getFieldName(Activity.class, Activity::getCode));
    assertEquals("code", getFieldName(Activity.class, Activity::setCode));
    assertEquals("name", getFieldName(Activity.class, Activity::getName));
    assertEquals("name", getFieldName(Activity.class, Activity::setName));
    assertEquals("app", getFieldName(Activity.class, Activity::getApp));
    assertEquals("app", getFieldName(Activity.class, Activity::setApp));
    assertEquals("items", getFieldName(Activity.class, Activity::getItems));
    assertEquals("items", getFieldName(Activity.class, Activity::setItems));
    assertEquals("description", getFieldName(Activity.class, Activity::getDescription));
    assertEquals("description", getFieldName(Activity.class, Activity::setDescription));
    assertEquals("startTime", getFieldName(Activity.class, Activity::getStartTime));
    assertEquals("startTime", getFieldName(Activity.class, Activity::setStartTime));
    assertEquals("endTime", getFieldName(Activity.class, Activity::getEndTime));
    assertEquals("endTime", getFieldName(Activity.class, Activity::setEndTime));
    assertEquals("state", getFieldName(Activity.class, Activity::getState));
    assertEquals("state", getFieldName(Activity.class, Activity::setState));
    assertEquals("createTime", getFieldName(Activity.class, Activity::getCreateTime));
    assertEquals("createTime", getFieldName(Activity.class, Activity::setCreateTime));
    assertEquals("modifyTime", getFieldName(Activity.class, Activity::getModifyTime));
    assertEquals("modifyTime", getFieldName(Activity.class, Activity::setModifyTime));
    assertEquals("deleteTime", getFieldName(Activity.class, Activity::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Activity.class, Activity::setDeleteTime));
  }
}
