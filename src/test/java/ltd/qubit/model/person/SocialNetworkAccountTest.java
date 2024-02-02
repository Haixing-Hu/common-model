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
 * Unit test of the {@link SocialNetworkAccount} class.
 *
 * @author Haixing Hu
 */
public class SocialNetworkAccountTest extends ModelTestBase<SocialNetworkAccount> {

  public SocialNetworkAccountTest() {
    super(SocialNetworkAccount.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getId));
    assertEquals("id", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setId));
    assertEquals("username", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getUsername));
    assertEquals("username", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setUsername));
    assertEquals("socialNetwork", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getSocialNetwork));
    assertEquals("socialNetwork", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setSocialNetwork));
    assertEquals("appId", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getAppId));
    assertEquals("appId", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setAppId));
    assertEquals("openId", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getOpenId));
    assertEquals("openId", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setOpenId));
    assertEquals("nickname", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getNickname));
    assertEquals("nickname", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setNickname));
    assertEquals("avatar", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getAvatar));
    assertEquals("avatar", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setAvatar));
    assertEquals("profiles", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getProfiles));
    assertEquals("profiles", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setProfiles));
    assertEquals("payloads", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getPayloads));
    assertEquals("payloads", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setPayloads));
    assertEquals("createTime", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getCreateTime));
    assertEquals("createTime", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setCreateTime));
    assertEquals("modifyTime", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getModifyTime));
    assertEquals("modifyTime", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setModifyTime));
    assertEquals("deleteTime", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::getDeleteTime));
    assertEquals("deleteTime", getFieldName(SocialNetworkAccount.class, SocialNetworkAccount::setDeleteTime));
  }
}
