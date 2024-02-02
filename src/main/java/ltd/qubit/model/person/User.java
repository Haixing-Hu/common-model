////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.person;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Computed;
import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Indexed;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.AuthorizeRecord;
import ltd.qubit.model.commons.State;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.controller.RegisterUserParams;
import ltd.qubit.model.organization.Organization;
import ltd.qubit.model.system.VerifyState;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Desensitizable;
import ltd.qubit.model.util.Emptyful;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Normalizable;
import ltd.qubit.model.util.Predefinable;
import ltd.qubit.model.util.Stateful;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithComment;
import ltd.qubit.model.util.WithEmail;
import ltd.qubit.model.util.WithMobile;
import ltd.qubit.model.util.WithName;
import ltd.qubit.model.util.WithOrganization;
import ltd.qubit.model.util.WithPassword;
import ltd.qubit.model.util.WithUsername;

/**
 * 此模型表示系统用户。
 *
 * @author 胡海星
 */
public class User implements Identifiable, WithUsername, WithPassword, WithName,
    WithMobile, WithEmail, WithOrganization, Stateful, WithComment, Auditable,
    Predefinable, Desensitizable<User>, Emptyful, Normalizable, Assignable<User> {

  private static final long serialVersionUID = -4419177823491290198L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 用户名，全局唯一不可重复。
   */
  @Size(min = 1, max = 64)
  @Unique
  private String username;

  /**
   * 密码，通常从数据库内取出的是加盐后的哈希值。
   */
  @Size(min = 1, max = 64)
  private String password;

  /**
   * 真实姓名。
   */
  @Size(min = 1, max = 128)
  @Nullable
  @Indexed
  private String name;

  /**
   * 昵称。
   */
  @Size(min = 1, max = 128)
  @Nullable
  @Indexed
  private String nickname;

  /**
   * 性别。
   */
  @Nullable
  @Indexed
  private Gender gender;

  /**
   * 手机号码。
   */
  @Unique
  @Nullable
  private Phone mobile;

  /**
   * 手机号码验证状态。
   */
  @Nullable
  private VerifyState mobileVerified;

  /**
   * 电子邮件地址。
   */
  @Size(min = 1, max = 512)
  @Unique
  @Nullable
  private String email;

  /**
   * 电子邮件地址验证状态。
   */
  @Nullable
  private VerifyState emailVerified;

  /**
   * 头像。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String avatar;

  /**
   * 网址。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String url;

  /**
   * 描述/自我介绍。
   */
  @Nullable
  private String description;

  /**
   * 所属机构基本信息。
   */
  @Reference(entity = Organization.class, property = "info")
  @Nullable
  private StatefulInfo organization;

  /**
   * 用户状态。
   */
  @Indexed
  private State state = State.NORMAL;

  /**
   * 上次登录的信息记录。
   */
  private AuthorizeRecord lastLogin;

  /**
   * 登录后是否应该立即更改密码。
   */
  private Boolean changePassword = false;

  /**
   * 此账号生效时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant validTime;

  /**
   * 此账号过期时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant expiredTime;

  /**
   * 备注。
   */
  @Nullable
  private String comment;

  /**
   * 是否是预定义的数据。
   */
  @Indexed
  private Boolean predefined;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant modifyTime;

  /**
   * 标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant deleteTime;

  public User() {
    // empty
  }

  public User(final RegisterUserParams params) {
    username = params.getUsername();
    password = params.getPassword();
    name = params.getName();
    nickname = params.getNickname();
    gender = params.getGender();
    mobile = Assignment.clone(params.getMobile());
    email = params.getEmail();
    avatar = params.getAvatar();
    organization = Assignment.clone(params.getOrganization());
  }

  public User(final User other) {
    assign(other);
  }

  @Override
  public void assign(final User other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    username = other.username;
    password = other.password;
    name = other.name;
    nickname = other.nickname;
    gender = other.gender;
    mobile = Assignment.clone(other.mobile);
    mobileVerified = other.mobileVerified;
    email = other.email;
    emailVerified = other.emailVerified;
    avatar = other.avatar;
    url = other.url;
    description = other.description;
    organization = Assignment.clone(other.organization);
    state = other.state;
    lastLogin = Assignment.clone(other.lastLogin);
    changePassword = other.changePassword;
    validTime = other.validTime;
    expiredTime = other.expiredTime;
    comment = other.comment;
    predefined = other.predefined;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public User clone() {
    return new User(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
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

  @Override
  @Nullable
  public String getName() {
    return name;
  }

  @Override
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
  public Phone getMobile() {
    return mobile;
  }

  public void setMobile(@Nullable final Phone mobile) {
    this.mobile = mobile;
  }

  @Nullable
  public VerifyState getMobileVerified() {
    return mobileVerified;
  }

  public void setMobileVerified(@Nullable final VerifyState mobileVerified) {
    this.mobileVerified = mobileVerified;
  }

  @Nullable
  public String getEmail() {
    return email;
  }

  public void setEmail(@Nullable final String email) {
    this.email = email;
  }

  @Nullable
  public VerifyState getEmailVerified() {
    return emailVerified;
  }

  public void setEmailVerified(@Nullable final VerifyState emailVerified) {
    this.emailVerified = emailVerified;
  }

  @Nullable
  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(@Nullable final String avatar) {
    this.avatar = avatar;
  }

  @Nullable
  public String getUrl() {
    return url;
  }

  public void setUrl(@Nullable final String url) {
    this.url = url;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  @Nullable
  public StatefulInfo getOrganization() {
    return organization;
  }

  public void setOrganization(@Nullable final StatefulInfo organization) {
    this.organization = organization;
  }

  public State getState() {
    return state;
  }

  public void setState(final State state) {
    this.state = state;
  }

  public AuthorizeRecord getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(final AuthorizeRecord lastLogin) {
    this.lastLogin = lastLogin;
  }

  public Boolean isChangePassword() {
    return changePassword;
  }

  public void setChangePassword(final Boolean changePassword) {
    this.changePassword = changePassword;
  }

  @Nullable
  public Instant getValidTime() {
    return validTime;
  }

  public void setValidTime(@Nullable final Instant validTime) {
    this.validTime = validTime;
  }

  @Nullable
  public Instant getExpiredTime() {
    return expiredTime;
  }

  public void setExpiredTime(@Nullable final Instant expiredTime) {
    this.expiredTime = expiredTime;
  }

  @Nullable
  public String getComment() {
    return comment;
  }

  public void setComment(@Nullable final String comment) {
    this.comment = comment;
  }

  public Boolean isPredefined() {
    return predefined;
  }

  public void setPredefined(final Boolean predefined) {
    this.predefined = predefined;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  @Nullable
  public Instant getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(@Nullable final Instant modifyTime) {
    this.modifyTime = modifyTime;
  }

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  @Computed({"id", "username", "name", "nickname", "avatar", "state", "deleteTime"})
  public UserInfo getInfo() {
    final UserInfo result = new UserInfo();
    result.setId(id);
    result.setUsername(username);
    result.setName(name);
    result.setNickname(nickname);
    result.setGender(gender);
    result.setAvatar(avatar);
    result.setMobile(mobile);
    result.setEmail(email);
    result.setState(state);
    result.setDeleteTime(deleteTime);
    return result;
  }

  /**
   * 对此对象脱敏。
   */
  @Override
  public final void desensitize() {
    password = null;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final User other = (User) o;
    return Equality.equals(id, other.id)
        && Equality.equals(username, other.username)
        && Equality.equals(password, other.password)
        && Equality.equals(name, other.name)
        && Equality.equals(nickname, other.nickname)
        && Equality.equals(gender, other.gender)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(mobileVerified, other.mobileVerified)
        && Equality.equals(email, other.email)
        && Equality.equals(emailVerified, other.emailVerified)
        && Equality.equals(avatar, other.avatar)
        && Equality.equals(url, other.url)
        && Equality.equals(description, other.description)
        && Equality.equals(organization, other.organization)
        && Equality.equals(state, other.state)
        && Equality.equals(lastLogin, other.lastLogin)
        && Equality.equals(changePassword, other.changePassword)
        && Equality.equals(validTime, other.validTime)
        && Equality.equals(expiredTime, other.expiredTime)
        && Equality.equals(comment, other.comment)
        && Equality.equals(predefined, other.predefined)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, username);
    result = Hash.combine(result, multiplier, password);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, nickname);
    result = Hash.combine(result, multiplier, gender);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, mobileVerified);
    result = Hash.combine(result, multiplier, email);
    result = Hash.combine(result, multiplier, emailVerified);
    result = Hash.combine(result, multiplier, avatar);
    result = Hash.combine(result, multiplier, url);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, lastLogin);
    result = Hash.combine(result, multiplier, changePassword);
    result = Hash.combine(result, multiplier, validTime);
    result = Hash.combine(result, multiplier, expiredTime);
    result = Hash.combine(result, multiplier, comment);
    result = Hash.combine(result, multiplier, predefined);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("username", username)
        .append("password", password)
        .append("name", name)
        .append("nickname", nickname)
        .append("gender", gender)
        .append("mobile", mobile)
        .append("mobileVerified", mobileVerified)
        .append("email", email)
        .append("emailVerified", emailVerified)
        .append("avatar", avatar)
        .append("url", url)
        .append("description", description)
        .append("organization", organization)
        .append("state", state)
        .append("lastLogin", lastLogin)
        .append("changePassword", changePassword)
        .append("validTime", validTime)
        .append("expiredTime", expiredTime)
        .append("comment", comment)
        .append("predefined", predefined)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
