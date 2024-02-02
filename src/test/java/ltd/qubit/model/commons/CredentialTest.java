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
 * Unit test of the {@link Credential} class.
 *
 * @author Haixing Hu
 */
public class CredentialTest extends ModelTestBase<Credential> {

  public CredentialTest() {
    super(Credential.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Credential.class, Credential::getId));
    assertEquals("id", getFieldName(Credential.class, Credential::setId));
    assertEquals("type", getFieldName(Credential.class, Credential::getType));
    assertEquals("type", getFieldName(Credential.class, Credential::setType));
    assertEquals("number", getFieldName(Credential.class, Credential::getNumber));
    assertEquals("number", getFieldName(Credential.class, Credential::setNumber));
    assertEquals("verified", getFieldName(Credential.class, Credential::getVerified));
    assertEquals("verified", getFieldName(Credential.class, Credential::setVerified));
    assertEquals("owner", getFieldName(Credential.class, Credential::getOwner));
    assertEquals("owner", getFieldName(Credential.class, Credential::setOwner));
    assertEquals("index", getFieldName(Credential.class, Credential::getIndex));
    assertEquals("index", getFieldName(Credential.class, Credential::setIndex));
    assertEquals("title", getFieldName(Credential.class, Credential::getTitle));
    assertEquals("title", getFieldName(Credential.class, Credential::setTitle));
    assertEquals("description", getFieldName(Credential.class, Credential::getDescription));
    assertEquals("description", getFieldName(Credential.class, Credential::setDescription));
    assertEquals("attachments", getFieldName(Credential.class, Credential::getAttachments));
    assertEquals("attachments", getFieldName(Credential.class, Credential::setAttachments));
    assertEquals("createTime", getFieldName(Credential.class, Credential::getCreateTime));
    assertEquals("createTime", getFieldName(Credential.class, Credential::setCreateTime));
    assertEquals("modifyTime", getFieldName(Credential.class, Credential::getModifyTime));
    assertEquals("modifyTime", getFieldName(Credential.class, Credential::setModifyTime));
    assertEquals("deleteTime", getFieldName(Credential.class, Credential::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Credential.class, Credential::setDeleteTime));
  }
}
