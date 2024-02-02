////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.commons;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Schedule} class.
 *
 * @author Haixing Hu
 */
public class ScheduleTest extends ModelTestBase<Schedule> {

  public ScheduleTest() {
    super(Schedule.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("startTime", getFieldName(Schedule.class, Schedule::getStartTime));
    assertEquals("startTime", getFieldName(Schedule.class, Schedule::setStartTime));
    assertEquals("endTime", getFieldName(Schedule.class, Schedule::getEndTime));
    assertEquals("endTime", getFieldName(Schedule.class, Schedule::setEndTime));
    assertEquals("crontabs", getFieldName(Schedule.class, Schedule::getCrontabs));
    assertEquals("crontabs", getFieldName(Schedule.class, Schedule::setCrontabs));
  }
}
