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
 * Unit test of the {@link PrescriptionActionParams} class.
 *
 * @author Haixing Hu
 */
public class PrescriptionActionParamsTest extends ModelTestBase<PrescriptionActionParams> {

  public PrescriptionActionParamsTest() {
    super(PrescriptionActionParams.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("action", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::getAction));
    assertEquals("action", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::setAction));
    assertEquals("actorType", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::getActorType));
    assertEquals("actorType", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::setActorType));
    assertEquals("actorCode", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::getActorCode));
    assertEquals("actorCode", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::setActorCode));
    assertEquals("actorName", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::getActorName));
    assertEquals("actorName", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::setActorName));
    assertEquals("description", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::getDescription));
    assertEquals("description", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::setDescription));
    assertEquals("timestamp", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::getTimestamp));
    assertEquals("timestamp", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::setTimestamp));
    assertEquals("payload", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::getPayload));
    assertEquals("payload", getFieldName(PrescriptionActionParams.class, PrescriptionActionParams::setPayload));
  }
}
