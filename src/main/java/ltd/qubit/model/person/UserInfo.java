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

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.State;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.util.Deletable;
import ltd.qubit.model.util.Emptyful;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Normalizable;
import ltd.qubit.model.util.Stateful;
import ltd.qubit.model.util.WithName;
import ltd.qubit.model.util.WithUsername;

/**
 * 此模型表示用户对象{@link User}的基本信息。
 *
 * @author 胡海星
 */
public class UserInfo implements Identifiable, WithUsername, WithName, Stateful,
    Deletable, Emptyful, Normalizable, Assignable<UserInfo> {

  private static final long serialVersionUID = -3739818849317896899L;

  /**
   * 用户ID。
   */
  @Identifier
  private Long id;

  /**
   * 用户名。
   */
  @Size(min = 1, max = 64)
  @Unique
  private String username;

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
  @Nullable
  private Phone mobile;

  /**
   * 电子邮件地址。
   */
  @Size(min = 1, max = 512)
  @Unique
  @Nullable
  private String email;

  /**
   * 用户状态。
   */
  private State state;

  /**
   * 标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public static UserInfo create(@Nullable final Long id,
          @Nullable final String username,
          @Nullable final String name,
          @Nullable final String nickname) {
    if (id == null && username == null && name == null && nickname == null) {
      return null;
    } else {
      final UserInfo result = new UserInfo();
      result.setId(id);
      result.setUsername(username);
      result.setName(name);
      result.setNickname(nickname);
      return result;
    }
  }

  public UserInfo() {
    // empty
  }

  public UserInfo(final UserInfo other) {
    assign(other);
  }

  @Override
  public void assign(final UserInfo other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    username = other.username;
    name = other.name;
    nickname = other.nickname;
    gender = other.gender;
    avatar = other.avatar;
    mobile = other.mobile;
    email = other.email;
    state = other.state;
    deleteTime = other.deleteTime;
  }

  @Override
  public UserInfo clone() {
    return new UserInfo(this);
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

  @Nullable
  public Phone getMobile() {
    return mobile;
  }

  public void setMobile(@Nullable final Phone mobile) {
    this.mobile = mobile;
  }

  @Nullable
  public String getEmail() {
    return email;
  }

  public void setEmail(@Nullable final String email) {
    this.email = email;
  }

  public State getState() {
    return state;
  }

  public void setState(final State state) {
    this.state = state;
  }

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final UserInfo other = (UserInfo) o;
    return Equality.equals(id, other.id)
        && Equality.equals(username, other.username)
        && Equality.equals(name, other.name)
        && Equality.equals(nickname, other.nickname)
        && Equality.equals(gender, other.gender)
        && Equality.equals(avatar, other.avatar)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(email, other.email)
        && Equality.equals(state, other.state)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, username);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, nickname);
    result = Hash.combine(result, multiplier, gender);
    result = Hash.combine(result, multiplier, avatar);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, email);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("username", username)
        .append("name", name)
        .append("nickname", nickname)
        .append("gender", gender)
        .append("avatar", avatar)
        .append("mobile", mobile)
        .append("email", email)
        .append("state", state)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
