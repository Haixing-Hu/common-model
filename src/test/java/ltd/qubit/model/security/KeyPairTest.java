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
 * Unit test of the {@link KeyPair} class.
 *
 * @author Haixing Hu
 */
public class KeyPairTest extends ModelTestBase<KeyPair> {

  public KeyPairTest() {
    super(KeyPair.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(KeyPair.class, KeyPair::getId));
    assertEquals("id", getFieldName(KeyPair.class, KeyPair::setId));
    assertEquals("ownerType", getFieldName(KeyPair.class, KeyPair::getOwnerType));
    assertEquals("ownerType", getFieldName(KeyPair.class, KeyPair::setOwnerType));
    assertEquals("ownerId", getFieldName(KeyPair.class, KeyPair::getOwnerId));
    assertEquals("ownerId", getFieldName(KeyPair.class, KeyPair::setOwnerId));
    assertEquals("ownerCode", getFieldName(KeyPair.class, KeyPair::getOwnerCode));
    assertEquals("ownerCode", getFieldName(KeyPair.class, KeyPair::setOwnerCode));
    assertEquals("algorithm", getFieldName(KeyPair.class, KeyPair::getAlgorithm));
    assertEquals("algorithm", getFieldName(KeyPair.class, KeyPair::setAlgorithm));
    assertEquals("format", getFieldName(KeyPair.class, KeyPair::getFormat));
    assertEquals("format", getFieldName(KeyPair.class, KeyPair::setFormat));
    assertEquals("version", getFieldName(KeyPair.class, KeyPair::getVersion));
    assertEquals("version", getFieldName(KeyPair.class, KeyPair::setVersion));
    assertEquals("publicKey", getFieldName(KeyPair.class, KeyPair::getPublicKey));
    assertEquals("publicKey", getFieldName(KeyPair.class, KeyPair::setPublicKey));
    assertEquals("privateKey", getFieldName(KeyPair.class, KeyPair::getPrivateKey));
    assertEquals("privateKey", getFieldName(KeyPair.class, KeyPair::setPrivateKey));
    assertEquals("state", getFieldName(KeyPair.class, KeyPair::getState));
    assertEquals("state", getFieldName(KeyPair.class, KeyPair::setState));
    assertEquals("createTime", getFieldName(KeyPair.class, KeyPair::getCreateTime));
    assertEquals("createTime", getFieldName(KeyPair.class, KeyPair::setCreateTime));
    assertEquals("modifyTime", getFieldName(KeyPair.class, KeyPair::getModifyTime));
    assertEquals("modifyTime", getFieldName(KeyPair.class, KeyPair::setModifyTime));
    assertEquals("deleteTime", getFieldName(KeyPair.class, KeyPair::getDeleteTime));
    assertEquals("deleteTime", getFieldName(KeyPair.class, KeyPair::setDeleteTime));
  }
}
