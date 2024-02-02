////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.controller;

import java.io.Serializable;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.organization.Organization;
import ltd.qubit.model.person.Gender;
import ltd.qubit.model.person.SocialNetwork;
import ltd.qubit.model.system.Environment;
import ltd.qubit.model.util.Desensitizable;
import ltd.qubit.model.util.StatefulInfo;

/**
 * 此数据结构封装了注册新用户所需提供的参数。
 *
 * @author 胡海星
 */
public class RegisterUserParams implements Serializable,
    Desensitizable<RegisterUserParams>, Assignable<RegisterUserParams> {

  private static final long serialVersionUID = -3255597390802649423L;

  /**
   * 用户名。
   */
  @Size(min = 1, max = 64)
  @Unique
  private String username;

  /**
   * 密码（明文）。
   */
  @Size(min = 1, max = 64)
  private String password;

  /**
   * 注册使用的验证码。若使用手机号码或电子邮件注册，则此项不能为{@code null}，否则
   * 可以为{@code null}。
   */
  @Size(min = 1, max = 64)
  private String verifyCode;

  /**
   * 真实姓名。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String name;

  /**
   * 昵称。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String nickname;

  /**
   * 性别。
   */
  @Nullable
  private Gender gender;

  /**
   * 头像。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String avatar;

  /**
   * 手机号码。
   */
  @Unique
  private Phone mobile;

  /**
   * 电子邮件地址。
   */
  @Size(min = 1, max = 512)
  @Unique
  @Nullable
  private String email;

  /**
   * 所属社交网络的类型。
   */
  @Nullable
  private SocialNetwork socialNetwork;

  /**
   * 此账号在对应的社交网络中的App ID。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String appId;

  /**
   * 此账号在对应的社交网络中的 open ID。
   */
  @Size(min = 1, max = 64)
  @Unique(respectTo = {"socialNetwork", "appId"})
  @Nullable
  private String openId;

  /**
   * 所属机构基本信息。
   */
  @Reference(entity = Organization.class, property = "info")
  @Nullable
  private StatefulInfo organization;

  /**
   * 注册时的客户端环境，可以为{@code null}。
   */
  @Nullable
  private Environment environment;

  public RegisterUserParams() {
    // empty
  }

  public RegisterUserParams(final RegisterUserParams other) {
    assign(other);
  }

  @Override
  public void assign(final RegisterUserParams other) {
    Argument.requireNonNull("other", other);
    username = other.username;
    password = other.password;
    verifyCode = other.verifyCode;
    name = other.name;
    nickname = other.nickname;
    gender = other.gender;
    avatar = other.avatar;
    mobile = Assignment.clone(other.mobile);
    email = other.email;
    socialNetwork = other.socialNetwork;
    appId = other.appId;
    openId = other.openId;
    organization = Assignment.clone(other.organization);
    environment = Assignment.clone(other.environment);
  }

  @Override
  public RegisterUserParams clone() {
    return new RegisterUserParams(this);
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getVerifyCode() {
    return verifyCode;
  }

  public void setVerifyCode(final String verifyCode) {
    this.verifyCode = verifyCode;
  }

  @Nullable
  public String getName() {
    return name;
  }

  public void setName(@Nullable final String name) {
    this.name = name;
  }

  @Nullable
  public String getNickname() {
    return nickname;
  }

  public void setNickname(@Nullable final String nickname) {
    this.nickname = nickname;
  }

  @Nullable
  public Gender getGender() {
    return gender;
  }

  public void setGender(@Nullable final Gender gender) {
    this.gender = gender;
  }

  @Nullable
  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(@Nullable final String avatar) {
    this.avatar = avatar;
  }

  public Phone getMobile() {
    return mobile;
  }

  public void setMobile(final Phone mobile) {
    this.mobile = mobile;
  }

  @Nullable
  public String getEmail() {
    return email;
  }

  public void setEmail(@Nullable final String email) {
    this.email = email;
  }

  @Nullable
  public SocialNetwork getSocialNetwork() {
    return socialNetwork;
  }

  public void setSocialNetwork(@Nullable final SocialNetwork socialNetwork) {
    this.socialNetwork = socialNetwork;
  }

  @Nullable
  public String getAppId() {
    return appId;
  }

  public void setAppId(@Nullable final String appId) {
    this.appId = appId;
  }

  @Nullable
  public String getOpenId() {
    return openId;
  }

  public void setOpenId(@Nullable final String openId) {
    this.openId = openId;
  }

  @Nullable
  public StatefulInfo getOrganization() {
    return organization;
  }

  public void setOrganization(@Nullable final StatefulInfo organization) {
    this.organization = organization;
  }

  @Nullable
  public Environment getEnvironment() {
    return environment;
  }

  public void setEnvironment(@Nullable final Environment environment) {
    this.environment = environment;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final RegisterUserParams other = (RegisterUserParams) o;
    return Equality.equals(username, other.username)
        && Equality.equals(password, other.password)
        && Equality.equals(verifyCode, other.verifyCode)
        && Equality.equals(name, other.name)
        && Equality.equals(nickname, other.nickname)
        && Equality.equals(gender, other.gender)
        && Equality.equals(avatar, other.avatar)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(email, other.email)
        && Equality.equals(socialNetwork, other.socialNetwork)
        && Equality.equals(appId, other.appId)
        && Equality.equals(openId, other.openId)
        && Equality.equals(organization, other.organization)
        && Equality.equals(environment, other.environment);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, username);
    result = Hash.combine(result, multiplier, password);
    result = Hash.combine(result, multiplier, verifyCode);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, nickname);
    result = Hash.combine(result, multiplier, gender);
    result = Hash.combine(result, multiplier, avatar);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, email);
    result = Hash.combine(result, multiplier, socialNetwork);
    result = Hash.combine(result, multiplier, appId);
    result = Hash.combine(result, multiplier, openId);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, environment);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("username", username)
        .append("password", password)
        .append("verifyCode", verifyCode)
        .append("name", name)
        .append("nickname", nickname)
        .append("gender", gender)
        .append("avatar", avatar)
        .append("mobile", mobile)
        .append("email", email)
        .append("socialNetwork", socialNetwork)
        .append("appId", appId)
        .append("openId", openId)
        .append("organization", organization)
        .append("environment", environment)
        .toString();
  }

  @Override
  public void desensitize() {
    // FIXME
    password = "--------";
    openId = "--------";
  }
}
