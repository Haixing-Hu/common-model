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
 * Unit test of the {@link Signature} class.
 *
 * @author Haixing Hu
 */
public class SignatureTest extends ModelTestBase<Signature> {

  public SignatureTest() {
    super(Signature.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Signature.class, Signature::getId));
    assertEquals("id", getFieldName(Signature.class, Signature::setId));
    assertEquals("ownerType", getFieldName(Signature.class, Signature::getOwnerType));
    assertEquals("ownerType", getFieldName(Signature.class, Signature::setOwnerType));
    assertEquals("ownerId", getFieldName(Signature.class, Signature::getOwnerId));
    assertEquals("ownerId", getFieldName(Signature.class, Signature::setOwnerId));
    assertEquals("signerType", getFieldName(Signature.class, Signature::getSignerType));
    assertEquals("signerType", getFieldName(Signature.class, Signature::setSignerType));
    assertEquals("signerId", getFieldName(Signature.class, Signature::getSignerId));
    assertEquals("signerId", getFieldName(Signature.class, Signature::setSignerId));
    assertEquals("signerCode", getFieldName(Signature.class, Signature::getSignerCode));
    assertEquals("signerCode", getFieldName(Signature.class, Signature::setSignerCode));
    assertEquals("signedInfo", getFieldName(Signature.class, Signature::getSignedInfo));
    assertEquals("signedInfo", getFieldName(Signature.class, Signature::setSignedInfo));
    assertEquals("signedValue", getFieldName(Signature.class, Signature::getSignedValue));
    assertEquals("signedValue", getFieldName(Signature.class, Signature::setSignedValue));
  }
}
