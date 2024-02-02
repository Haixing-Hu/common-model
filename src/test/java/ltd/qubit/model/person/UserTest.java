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
 * Unit test of the {@link User} class.
 *
 * @author Haixing Hu
 */
public class UserTest extends ModelTestBase<User> {

  public UserTest() {
    super(User.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(User.class, User::getId));
    assertEquals("id", getFieldName(User.class, User::setId));
    assertEquals("username", getFieldName(User.class, User::getUsername));
    assertEquals("username", getFieldName(User.class, User::setUsername));
    assertEquals("password", getFieldName(User.class, User::getPassword));
    assertEquals("password", getFieldName(User.class, User::setPassword));
    assertEquals("name", getFieldName(User.class, User::getName));
    assertEquals("name", getFieldName(User.class, User::setName));
    assertEquals("nickname", getFieldName(User.class, User::getNickname));
    assertEquals("nickname", getFieldName(User.class, User::setNickname));
    assertEquals("gender", getFieldName(User.class, User::getGender));
    assertEquals("gender", getFieldName(User.class, User::setGender));
    assertEquals("mobile", getFieldName(User.class, User::getMobile));
    assertEquals("mobile", getFieldName(User.class, User::setMobile));
    assertEquals("mobileVerified", getFieldName(User.class, User::getMobileVerified));
    assertEquals("mobileVerified", getFieldName(User.class, User::setMobileVerified));
    assertEquals("email", getFieldName(User.class, User::getEmail));
    assertEquals("email", getFieldName(User.class, User::setEmail));
    assertEquals("emailVerified", getFieldName(User.class, User::getEmailVerified));
    assertEquals("emailVerified", getFieldName(User.class, User::setEmailVerified));
    assertEquals("avatar", getFieldName(User.class, User::getAvatar));
    assertEquals("avatar", getFieldName(User.class, User::setAvatar));
    assertEquals("url", getFieldName(User.class, User::getUrl));
    assertEquals("url", getFieldName(User.class, User::setUrl));
    assertEquals("description", getFieldName(User.class, User::getDescription));
    assertEquals("description", getFieldName(User.class, User::setDescription));
    assertEquals("organization", getFieldName(User.class, User::getOrganization));
    assertEquals("organization", getFieldName(User.class, User::setOrganization));
    assertEquals("state", getFieldName(User.class, User::getState));
    assertEquals("state", getFieldName(User.class, User::setState));
    assertEquals("lastLogin", getFieldName(User.class, User::getLastLogin));
    assertEquals("lastLogin", getFieldName(User.class, User::setLastLogin));
    assertEquals("changePassword", getFieldName(User.class, User::setChangePassword));
    assertEquals("changePassword", getFieldName(User.class, User::setChangePassword));
    assertEquals("validTime", getFieldName(User.class, User::getValidTime));
    assertEquals("validTime", getFieldName(User.class, User::setValidTime));
    assertEquals("expiredTime", getFieldName(User.class, User::getExpiredTime));
    assertEquals("expiredTime", getFieldName(User.class, User::setExpiredTime));
    assertEquals("comment", getFieldName(User.class, User::getComment));
    assertEquals("comment", getFieldName(User.class, User::setComment));
    assertEquals("predefined", getFieldName(User.class, User::isPredefined));
    assertEquals("predefined", getFieldName(User.class, User::setPredefined));
    assertEquals("createTime", getFieldName(User.class, User::getCreateTime));
    assertEquals("createTime", getFieldName(User.class, User::setCreateTime));
    assertEquals("modifyTime", getFieldName(User.class, User::getModifyTime));
    assertEquals("modifyTime", getFieldName(User.class, User::setModifyTime));
    assertEquals("deleteTime", getFieldName(User.class, User::getDeleteTime));
    assertEquals("deleteTime", getFieldName(User.class, User::setDeleteTime));
  }
}
