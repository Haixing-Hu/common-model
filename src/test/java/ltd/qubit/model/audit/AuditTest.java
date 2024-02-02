////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.audit;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Audit} class.
 *
 * @author Haixing Hu
 */
public class AuditTest extends ModelTestBase<Audit> {

  public AuditTest() {
    super(Audit.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Audit.class, Audit::getId));
    assertEquals("id", getFieldName(Audit.class, Audit::setId));
    assertEquals("objectiveType", getFieldName(Audit.class, Audit::getObjectiveType));
    assertEquals("objectiveType", getFieldName(Audit.class, Audit::setObjectiveType));
    assertEquals("objectiveId", getFieldName(Audit.class, Audit::getObjectiveId));
    assertEquals("objectiveId", getFieldName(Audit.class, Audit::setObjectiveId));
    assertEquals("status", getFieldName(Audit.class, Audit::getStatus));
    assertEquals("status", getFieldName(Audit.class, Audit::setStatus));
    assertEquals("auditor", getFieldName(Audit.class, Audit::getAuditor));
    assertEquals("auditor", getFieldName(Audit.class, Audit::setAuditor));
    assertEquals("createTime", getFieldName(Audit.class, Audit::getCreateTime));
    assertEquals("createTime", getFieldName(Audit.class, Audit::setCreateTime));
    assertEquals("modifyTime", getFieldName(Audit.class, Audit::getModifyTime));
    assertEquals("modifyTime", getFieldName(Audit.class, Audit::setModifyTime));
    assertEquals("deleteTime", getFieldName(Audit.class, Audit::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Audit.class, Audit::setDeleteTime));
  }
}
