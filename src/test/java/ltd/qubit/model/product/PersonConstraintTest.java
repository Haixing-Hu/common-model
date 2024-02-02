////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.product;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link PersonConstraint} class.
 *
 * @author Haixing Hu
 */
public class PersonConstraintTest extends ModelTestBase<PersonConstraint> {

  public PersonConstraintTest() {
    super(PersonConstraint.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("minAge", getFieldName(PersonConstraint.class, PersonConstraint::getMinAge));
    assertEquals("minAge", getFieldName(PersonConstraint.class, PersonConstraint::setMinAge));
    assertEquals("maxAge", getFieldName(PersonConstraint.class, PersonConstraint::getMaxAge));
    assertEquals("maxAge", getFieldName(PersonConstraint.class, PersonConstraint::setMaxAge));
    assertEquals("adultOnly", getFieldName(PersonConstraint.class, PersonConstraint::isAdultOnly));
    assertEquals("adultOnly", getFieldName(PersonConstraint.class, PersonConstraint::setAdultOnly));
    assertEquals("gender", getFieldName(PersonConstraint.class, PersonConstraint::getGender));
    assertEquals("gender", getFieldName(PersonConstraint.class, PersonConstraint::setGender));
    assertEquals("hasMedicare", getFieldName(PersonConstraint.class, PersonConstraint::isHasMedicare));
    assertEquals("hasMedicare", getFieldName(PersonConstraint.class, PersonConstraint::setHasMedicare));
    assertEquals("hasSocialSecurity", getFieldName(PersonConstraint.class, PersonConstraint::isHasSocialSecurity));
    assertEquals("hasSocialSecurity", getFieldName(PersonConstraint.class, PersonConstraint::setHasSocialSecurity));
    assertEquals("hasMedicareOrSocialSecurity",
      getFieldName(PersonConstraint.class, PersonConstraint::isHasMedicareOrSocialSecurity));
    assertEquals("hasMedicareOrSocialSecurity",
      getFieldName(PersonConstraint.class, PersonConstraint::setHasMedicareOrSocialSecurity));
    assertEquals("medicareCities", getFieldName(PersonConstraint.class, PersonConstraint::getMedicareCities));
    assertEquals("medicareCities", getFieldName(PersonConstraint.class, PersonConstraint::setMedicareCities));
    assertEquals("socialSecurityCities",
      getFieldName(PersonConstraint.class, PersonConstraint::getSocialSecurityCities));
    assertEquals("socialSecurityCities",
      getFieldName(PersonConstraint.class, PersonConstraint::setSocialSecurityCities));
    assertEquals("needGuardian", getFieldName(PersonConstraint.class, PersonConstraint::isNeedGuardian));
    assertEquals("needGuardian", getFieldName(PersonConstraint.class, PersonConstraint::setNeedGuardian));
  }
}
