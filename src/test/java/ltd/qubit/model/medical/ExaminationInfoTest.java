////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link ExaminationInfo} class.
 *
 * @author Haixing Hu
 */
public class ExaminationInfoTest extends ModelTestBase<ExaminationInfo> {

  public ExaminationInfoTest() {
    super(ExaminationInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("department", getFieldName(ExaminationInfo.class, ExaminationInfo::getDepartment));
    assertEquals("department", getFieldName(ExaminationInfo.class, ExaminationInfo::setDepartment));
    assertEquals("examineTime", getFieldName(ExaminationInfo.class, ExaminationInfo::getExamineTime));
    assertEquals("examineTime", getFieldName(ExaminationInfo.class, ExaminationInfo::setExamineTime));
  }
}
