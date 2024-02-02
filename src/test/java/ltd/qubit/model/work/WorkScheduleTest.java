////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.work;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link WorkSchedule} class.
 *
 * @author Haixing Hu
 */
public class WorkScheduleTest extends ModelTestBase<WorkSchedule> {

  public WorkScheduleTest() {
    super(WorkSchedule.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(WorkSchedule.class, WorkSchedule::getId));
    assertEquals("id", getFieldName(WorkSchedule.class, WorkSchedule::setId));
    assertEquals("employeeId", getFieldName(WorkSchedule.class, WorkSchedule::getEmployeeId));
    assertEquals("employeeId", getFieldName(WorkSchedule.class, WorkSchedule::setEmployeeId));
    assertEquals("date", getFieldName(WorkSchedule.class, WorkSchedule::getDate));
    assertEquals("date", getFieldName(WorkSchedule.class, WorkSchedule::setDate));
    assertEquals("intervals", getFieldName(WorkSchedule.class, WorkSchedule::getIntervals));
    assertEquals("intervals", getFieldName(WorkSchedule.class, WorkSchedule::setIntervals));
    assertEquals("createTime", getFieldName(WorkSchedule.class, WorkSchedule::getCreateTime));
    assertEquals("createTime", getFieldName(WorkSchedule.class, WorkSchedule::setCreateTime));
    assertEquals("modifyTime", getFieldName(WorkSchedule.class, WorkSchedule::getModifyTime));
    assertEquals("modifyTime", getFieldName(WorkSchedule.class, WorkSchedule::setModifyTime));
    assertEquals("deleteTime", getFieldName(WorkSchedule.class, WorkSchedule::getDeleteTime));
    assertEquals("deleteTime", getFieldName(WorkSchedule.class, WorkSchedule::setDeleteTime));
  }
}
