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
 * Unit test of the {@link UserInfo} class.
 *
 * @author Haixing Hu
 */
public class UserInfoTest extends ModelTestBase<UserInfo> {

  public UserInfoTest() {
    super(UserInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(UserInfo.class, UserInfo::getId));
    assertEquals("id", getFieldName(UserInfo.class, UserInfo::setId));
    assertEquals("username", getFieldName(UserInfo.class, UserInfo::getUsername));
    assertEquals("username", getFieldName(UserInfo.class, UserInfo::setUsername));
    assertEquals("name", getFieldName(UserInfo.class, UserInfo::getName));
    assertEquals("name", getFieldName(UserInfo.class, UserInfo::setName));
    assertEquals("nickname", getFieldName(UserInfo.class, UserInfo::getNickname));
    assertEquals("nickname", getFieldName(UserInfo.class, UserInfo::setNickname));
    assertEquals("gender", getFieldName(UserInfo.class, UserInfo::getGender));
    assertEquals("gender", getFieldName(UserInfo.class, UserInfo::setGender));
    assertEquals("avatar", getFieldName(UserInfo.class, UserInfo::getAvatar));
    assertEquals("avatar", getFieldName(UserInfo.class, UserInfo::setAvatar));
    assertEquals("mobile", getFieldName(UserInfo.class, UserInfo::getMobile));
    assertEquals("mobile", getFieldName(UserInfo.class, UserInfo::setMobile));
    assertEquals("email", getFieldName(UserInfo.class, UserInfo::getEmail));
    assertEquals("email", getFieldName(UserInfo.class, UserInfo::setEmail));
    assertEquals("state", getFieldName(UserInfo.class, UserInfo::getState));
    assertEquals("state", getFieldName(UserInfo.class, UserInfo::setState));
    assertEquals("deleteTime", getFieldName(UserInfo.class, UserInfo::getDeleteTime));
    assertEquals("deleteTime", getFieldName(UserInfo.class, UserInfo::setDeleteTime));
  }
}
