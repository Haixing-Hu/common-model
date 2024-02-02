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
 * Unit test of the {@link Person} class.
 *
 * @author Haixing Hu
 */
public class PersonTest extends ModelTestBase<Person> {

  public PersonTest() {
    super(Person.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Person.class, Person::getId));
    assertEquals("id", getFieldName(Person.class, Person::setId));
    assertEquals("source", getFieldName(Person.class, Person::getSource));
    assertEquals("source", getFieldName(Person.class, Person::setSource));
    assertEquals("name", getFieldName(Person.class, Person::getName));
    assertEquals("name", getFieldName(Person.class, Person::setName));
    assertEquals("username", getFieldName(Person.class, Person::getUsername));
    assertEquals("username", getFieldName(Person.class, Person::setUsername));
    assertEquals("username", getFieldName(Person.class, Person::getUsername));
    assertEquals("username", getFieldName(Person.class, Person::getUsername));
    assertEquals("gender", getFieldName(Person.class, Person::getGender));
    assertEquals("gender", getFieldName(Person.class, Person::setGender));
    assertEquals("birthday", getFieldName(Person.class, Person::getBirthday));
    assertEquals("birthday", getFieldName(Person.class, Person::setBirthday));
    assertEquals("credential", getFieldName(Person.class, Person::getCredential));
    assertEquals("credential", getFieldName(Person.class, Person::setCredential));
    assertEquals("hasMedicare", getFieldName(Person.class, Person::isHasMedicare));
    assertEquals("hasMedicare", getFieldName(Person.class, Person::setHasMedicare));
    assertEquals("medicareType", getFieldName(Person.class, Person::getMedicareType));
    assertEquals("medicareType", getFieldName(Person.class, Person::setMedicareType));
    assertEquals("medicareCard", getFieldName(Person.class, Person::getMedicareCard));
    assertEquals("medicareCard", getFieldName(Person.class, Person::setMedicareCard));
    assertEquals("medicareCity", getFieldName(Person.class, Person::getMedicareCity));
    assertEquals("medicareCity", getFieldName(Person.class, Person::setMedicareCity));
    assertEquals("hasSocialSecurity", getFieldName(Person.class, Person::isHasSocialSecurity));
    assertEquals("hasSocialSecurity", getFieldName(Person.class, Person::setHasSocialSecurity));
    assertEquals("socialSecurityCard", getFieldName(Person.class, Person::getSocialSecurityCard));
    assertEquals("socialSecurityCard", getFieldName(Person.class, Person::setSocialSecurityCard));
    assertEquals("socialSecurityCity", getFieldName(Person.class, Person::getSocialSecurityCity));
    assertEquals("socialSecurityCity", getFieldName(Person.class, Person::setSocialSecurityCity));
    assertEquals("contact", getFieldName(Person.class, Person::getContact));
    assertEquals("contact", getFieldName(Person.class, Person::setContact));
    assertEquals("guardian", getFieldName(Person.class, Person::getGuardian));
    assertEquals("guardian", getFieldName(Person.class, Person::setGuardian));
    assertEquals("education", getFieldName(Person.class, Person::getEducation));
    assertEquals("education", getFieldName(Person.class, Person::setEducation));
    assertEquals("ethnic", getFieldName(Person.class, Person::getEthnic));
    assertEquals("ethnic", getFieldName(Person.class, Person::setEthnic));
    assertEquals("blood", getFieldName(Person.class, Person::getBlood));
    assertEquals("blood", getFieldName(Person.class, Person::setBlood));
    assertEquals("marriage", getFieldName(Person.class, Person::getMarriage));
    assertEquals("marriage", getFieldName(Person.class, Person::setMarriage));
    assertEquals("hasChild", getFieldName(Person.class, Person::isHasChild));
    assertEquals("hasChild", getFieldName(Person.class, Person::setHasChild));
    assertEquals("sexOrientation", getFieldName(Person.class, Person::getSexOrientation));
    assertEquals("sexOrientation", getFieldName(Person.class, Person::setSexOrientation));
    assertEquals("religion", getFieldName(Person.class, Person::getReligion));
    assertEquals("religion", getFieldName(Person.class, Person::setReligion));
    assertEquals("politics", getFieldName(Person.class, Person::getPolitics));
    assertEquals("politics", getFieldName(Person.class, Person::setPolitics));
    assertEquals("industry", getFieldName(Person.class, Person::getIndustry));
    assertEquals("industry", getFieldName(Person.class, Person::setIndustry));
    assertEquals("job", getFieldName(Person.class, Person::getJob));
    assertEquals("job", getFieldName(Person.class, Person::setJob));
    assertEquals("jobTitle", getFieldName(Person.class, Person::getJobTitle));
    assertEquals("jobTitle", getFieldName(Person.class, Person::setJobTitle));
    assertEquals("incoming", getFieldName(Person.class, Person::getIncoming));
    assertEquals("incoming", getFieldName(Person.class, Person::setIncoming));
    assertEquals("organization", getFieldName(Person.class, Person::getOrganization));
    assertEquals("organization", getFieldName(Person.class, Person::setOrganization));
    assertEquals("height", getFieldName(Person.class, Person::getHeight));
    assertEquals("height", getFieldName(Person.class, Person::setHeight));
    assertEquals("weight", getFieldName(Person.class, Person::getWeight));
    assertEquals("weight", getFieldName(Person.class, Person::setWeight));
    assertEquals("allergicHistory", getFieldName(Person.class, Person::getAllergicHistory));
    assertEquals("allergicHistory", getFieldName(Person.class, Person::setAllergicHistory));
    assertEquals("comment", getFieldName(Person.class, Person::getComment));
    assertEquals("comment", getFieldName(Person.class, Person::setComment));
    assertEquals("createTime", getFieldName(Person.class, Person::getCreateTime));
    assertEquals("createTime", getFieldName(Person.class, Person::setCreateTime));
    assertEquals("modifyTime", getFieldName(Person.class, Person::getModifyTime));
    assertEquals("modifyTime", getFieldName(Person.class, Person::setModifyTime));
    assertEquals("deleteTime", getFieldName(Person.class, Person::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Person.class, Person::setDeleteTime));
  }
}
