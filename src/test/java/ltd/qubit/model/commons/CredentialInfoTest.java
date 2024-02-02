////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.commons;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link CredentialInfo} class.
 *
 * @author Haixing Hu
 */
public class CredentialInfoTest extends ModelTestBase<CredentialInfo> {

  public CredentialInfoTest() {
    super(CredentialInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(CredentialInfo.class, CredentialInfo::getId));
    assertEquals("id", getFieldName(CredentialInfo.class, CredentialInfo::setId));
    assertEquals("type", getFieldName(CredentialInfo.class, CredentialInfo::getType));
    assertEquals("type", getFieldName(CredentialInfo.class, CredentialInfo::setType));
    assertEquals("number", getFieldName(CredentialInfo.class, CredentialInfo::getNumber));
    assertEquals("number", getFieldName(CredentialInfo.class, CredentialInfo::setNumber));
    assertEquals("verified", getFieldName(CredentialInfo.class, CredentialInfo::getVerified));
    assertEquals("verified", getFieldName(CredentialInfo.class, CredentialInfo::setVerified));
  }
}
