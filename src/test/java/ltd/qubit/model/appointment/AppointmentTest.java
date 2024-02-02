////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.appointment;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Appointment} class.
 *
 * @author Haixing Hu
 */
public class AppointmentTest extends ModelTestBase<Appointment> {

  public AppointmentTest() {
    super(Appointment.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Appointment.class, Appointment::getId));
    assertEquals("id", getFieldName(Appointment.class, Appointment::setId));
    assertEquals("app", getFieldName(Appointment.class, Appointment::getApp));
    assertEquals("app", getFieldName(Appointment.class, Appointment::setApp));
    assertEquals("objectiveType", getFieldName(Appointment.class, Appointment::getObjectiveType));
    assertEquals("objectiveType", getFieldName(Appointment.class, Appointment::setObjectiveType));
    assertEquals("objectiveId", getFieldName(Appointment.class, Appointment::getObjectiveId));
    assertEquals("objectiveId", getFieldName(Appointment.class, Appointment::setObjectiveId));
    assertEquals("applicant", getFieldName(Appointment.class, Appointment::getApplicant));
    assertEquals("applicant", getFieldName(Appointment.class, Appointment::setApplicant));
    assertEquals("startTime", getFieldName(Appointment.class, Appointment::getStartTime));
    assertEquals("startTime", getFieldName(Appointment.class, Appointment::setStartTime));
    assertEquals("endTime", getFieldName(Appointment.class, Appointment::getEndTime));
    assertEquals("endTime", getFieldName(Appointment.class, Appointment::setEndTime));
    assertEquals("auditStatus", getFieldName(Appointment.class, Appointment::getAuditStatus));
    assertEquals("auditStatus", getFieldName(Appointment.class, Appointment::setAuditStatus));
    assertEquals("createTime", getFieldName(Appointment.class, Appointment::getCreateTime));
    assertEquals("createTime", getFieldName(Appointment.class, Appointment::setCreateTime));
    assertEquals("modifyTime", getFieldName(Appointment.class, Appointment::getModifyTime));
    assertEquals("modifyTime", getFieldName(Appointment.class, Appointment::setModifyTime));
    assertEquals("deleteTime", getFieldName(Appointment.class, Appointment::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Appointment.class, Appointment::setDeleteTime));
  }
}
