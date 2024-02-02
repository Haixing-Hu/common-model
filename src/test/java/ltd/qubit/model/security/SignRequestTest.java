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

import ltd.qubit.commons.security.SignRequest;
import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link SignRequest} class.
 *
 * @author Haixing Hu
 */
public class SignRequestTest extends ModelTestBase<SignRequest> {

  public SignRequestTest() {
    super(SignRequest.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("signerType", getFieldName(SignRequest.class, SignRequest::getSignerType));
    assertEquals("signerType", getFieldName(SignRequest.class, SignRequest::setSignerType));
    assertEquals("signerId", getFieldName(SignRequest.class, SignRequest::getSignerId));
    assertEquals("signerId", getFieldName(SignRequest.class, SignRequest::setSignerId));
    assertEquals("signerCode", getFieldName(SignRequest.class, SignRequest::getSignerCode));
    assertEquals("signerCode", getFieldName(SignRequest.class, SignRequest::setSignerCode));
    assertEquals("keyVersion", getFieldName(SignRequest.class, SignRequest::getKeyVersion));
    assertEquals("keyVersion", getFieldName(SignRequest.class, SignRequest::setKeyVersion));
    assertEquals("payload", getFieldName(SignRequest.class, SignRequest::getPayload));
    assertEquals("payload", getFieldName(SignRequest.class, SignRequest::setPayload));
    assertEquals("message", getFieldName(SignRequest.class, SignRequest::getMessage));
    assertEquals("message", getFieldName(SignRequest.class, SignRequest::setMessage));
  }
}
