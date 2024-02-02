////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.security;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link SignedInfo} class.
 *
 * @author Haixing Hu
 */
public class SignedInfoTest extends ModelTestBase<SignedInfo> {

  public SignedInfoTest() {
    super(SignedInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("message", getFieldName(SignedInfo.class, SignedInfo::getMessage));
    assertEquals("message", getFieldName(SignedInfo.class, SignedInfo::setMessage));
    assertEquals("algorithm", getFieldName(SignedInfo.class, SignedInfo::getAlgorithm));
    assertEquals("algorithm", getFieldName(SignedInfo.class, SignedInfo::setAlgorithm));
    assertEquals("keyVersion", getFieldName(SignedInfo.class, SignedInfo::getKeyVersion));
    assertEquals("keyVersion", getFieldName(SignedInfo.class, SignedInfo::setKeyVersion));
    assertEquals("publicKey", getFieldName(SignedInfo.class, SignedInfo::getPublicKey));
    assertEquals("publicKey", getFieldName(SignedInfo.class, SignedInfo::setPublicKey));
    assertEquals("name", getFieldName(SignedInfo.class, SignedInfo::getName));
    assertEquals("name", getFieldName(SignedInfo.class, SignedInfo::setName));
    assertEquals("credentialType", getFieldName(SignedInfo.class, SignedInfo::getCredentialType));
    assertEquals("credentialType", getFieldName(SignedInfo.class, SignedInfo::setCredentialType));
    assertEquals("credentialNumber", getFieldName(SignedInfo.class, SignedInfo::getCredentialNumber));
    assertEquals("credentialNumber", getFieldName(SignedInfo.class, SignedInfo::setCredentialNumber));
    assertEquals("payload", getFieldName(SignedInfo.class, SignedInfo::getPayload));
    assertEquals("payload", getFieldName(SignedInfo.class, SignedInfo::setPayload));
    assertEquals("timestamp", getFieldName(SignedInfo.class, SignedInfo::getTimestamp));
    assertEquals("timestamp", getFieldName(SignedInfo.class, SignedInfo::setTimestamp));
  }
}
