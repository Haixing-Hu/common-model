////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.person;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link PersonInfo} class.
 *
 * @author Haixing Hu
 */
public class PersonInfoTest extends ModelTestBase<PersonInfo> {

  public PersonInfoTest() {
    super(PersonInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(PersonInfo.class, PersonInfo::getId));
    assertEquals("id", getFieldName(PersonInfo.class, PersonInfo::setId));
    assertEquals("name", getFieldName(PersonInfo.class, PersonInfo::getName));
    assertEquals("name", getFieldName(PersonInfo.class, PersonInfo::setName));
    assertEquals("gender", getFieldName(PersonInfo.class, PersonInfo::getGender));
    assertEquals("gender", getFieldName(PersonInfo.class, PersonInfo::setGender));
    assertEquals("birthday", getFieldName(PersonInfo.class, PersonInfo::getBirthday));
    assertEquals("birthday", getFieldName(PersonInfo.class, PersonInfo::setBirthday));
    assertEquals("credential", getFieldName(PersonInfo.class, PersonInfo::getCredential));
    assertEquals("credential", getFieldName(PersonInfo.class, PersonInfo::setCredential));
    assertEquals("mobile", getFieldName(PersonInfo.class, PersonInfo::getMobile));
    assertEquals("mobile", getFieldName(PersonInfo.class, PersonInfo::setMobile));
    assertEquals("email", getFieldName(PersonInfo.class, PersonInfo::getEmail));
    assertEquals("email", getFieldName(PersonInfo.class, PersonInfo::setEmail));
  }
}
