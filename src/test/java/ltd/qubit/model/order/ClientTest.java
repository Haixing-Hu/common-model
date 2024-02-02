////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Client} class.
 *
 * @author Haixing Hu
 */
public class ClientTest extends ModelTestBase<Client> {

  public ClientTest() {
    super(Client.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Client.class, Client::getId));
    assertEquals("id", getFieldName(Client.class, Client::setId));
    assertEquals("name", getFieldName(Client.class, Client::getName));
    assertEquals("name", getFieldName(Client.class, Client::setName));
    assertEquals("credential", getFieldName(Client.class, Client::getCredential));
    assertEquals("credential", getFieldName(Client.class, Client::setCredential));
    assertEquals("gender", getFieldName(Client.class, Client::getGender));
    assertEquals("gender", getFieldName(Client.class, Client::setGender));
    assertEquals("birthday", getFieldName(Client.class, Client::getBirthday));
    assertEquals("birthday", getFieldName(Client.class, Client::setBirthday));
    assertEquals("mobile", getFieldName(Client.class, Client::getMobile));
    assertEquals("mobile", getFieldName(Client.class, Client::setMobile));
    assertEquals("email", getFieldName(Client.class, Client::getEmail));
    assertEquals("email", getFieldName(Client.class, Client::setEmail));
    assertEquals("hasMedicare", getFieldName(Client.class, Client::isHasMedicare));
    assertEquals("hasMedicare", getFieldName(Client.class, Client::setHasMedicare));
    assertEquals("medicareType", getFieldName(Client.class, Client::getMedicareType));
    assertEquals("medicareType", getFieldName(Client.class, Client::setMedicareType));
    assertEquals("medicareCard", getFieldName(Client.class, Client::getMedicareCard));
    assertEquals("medicareCard", getFieldName(Client.class, Client::setMedicareCard));
    assertEquals("medicareCity", getFieldName(Client.class, Client::getMedicareCity));
    assertEquals("medicareCity", getFieldName(Client.class, Client::setMedicareCity));
    assertEquals("hasSocialSecurity", getFieldName(Client.class, Client::isHasSocialSecurity));
    assertEquals("hasSocialSecurity", getFieldName(Client.class, Client::setHasSocialSecurity));
    assertEquals("socialSecurityCard", getFieldName(Client.class, Client::getSocialSecurityCard));
    assertEquals("socialSecurityCard", getFieldName(Client.class, Client::setSocialSecurityCard));
    assertEquals("socialSecurityCity", getFieldName(Client.class, Client::getSocialSecurityCity));
    assertEquals("socialSecurityCity", getFieldName(Client.class, Client::setSocialSecurityCity));
    assertEquals("guardian", getFieldName(Client.class, Client::getGuardian));
    assertEquals("guardian", getFieldName(Client.class, Client::setGuardian));
    assertEquals("returnStatus", getFieldName(Client.class, Client::getReturnStatus));
    assertEquals("returnStatus", getFieldName(Client.class, Client::setReturnStatus));
    assertEquals("kinship", getFieldName(Client.class, Client::getKinship));
    assertEquals("kinship", getFieldName(Client.class, Client::setKinship));
    assertEquals("payload", getFieldName(Client.class, Client::getPayload));
    assertEquals("payload", getFieldName(Client.class, Client::setPayload));
  }
}
