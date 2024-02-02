////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Participant} class.
 *
 * @author Haixing Hu
 */
public class ParticipantTest extends ModelTestBase<Participant> {

  public ParticipantTest() {
    super(Participant.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Participant.class, Participant::getId));
    assertEquals("id", getFieldName(Participant.class, Participant::setId));
    assertEquals("type", getFieldName(Participant.class, Participant::getType));
    assertEquals("type", getFieldName(Participant.class, Participant::setType));
    assertEquals("name", getFieldName(Participant.class, Participant::getName));
    assertEquals("name", getFieldName(Participant.class, Participant::setName));
    assertEquals("credential", getFieldName(Participant.class, Participant::getCredential));
    assertEquals("credential", getFieldName(Participant.class, Participant::setCredential));
    assertEquals("phone", getFieldName(Participant.class, Participant::getPhone));
    assertEquals("phone", getFieldName(Participant.class, Participant::setPhone));
    assertEquals("email", getFieldName(Participant.class, Participant::getEmail));
    assertEquals("email", getFieldName(Participant.class, Participant::setEmail));
    assertEquals("account", getFieldName(Participant.class, Participant::getAccount));
    assertEquals("account", getFieldName(Participant.class, Participant::setAccount));
  }
}
