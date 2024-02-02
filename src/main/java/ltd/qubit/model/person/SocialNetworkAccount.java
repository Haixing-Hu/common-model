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
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

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
import ltd.qubit.commons.util.pair.KeyValuePairList;
import ltd.qubit.model.commons.Payload;
import ltd.qubit.model.controller.RegisterUserParams;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Normalizable;

/**
 * 此模型表示用户在社交网络中的账号。
 *
 * @author 胡海星
 */
public class SocialNetworkAccount implements Identifiable, Normalizable,
    Auditable, Assignable<SocialNetworkAccount> {

  private static final long serialVersionUID = -1180320318502604463L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所属用户的用户名，对应于{@link User}类的{@code username}属性。
   */
  @Size(min = 1, max = 64)
  @Reference(entity = User.class, property = "username")
  private String username;

  /**
   * 所属社交网络的类型。
   */
  @Indexed
  private SocialNetwork socialNetwork;

  /**
   * 此账号在对应的社交网络中的App ID。
   */
  @Size(min = 1, max = 64)
  @Indexed
  private String appId;

  /**
   * 此账号在对应的社交网络中的 open ID。
   */
  @Size(min = 1, max = 64)
  @Unique(respectTo = {"socialNetwork", "appId"})
  private String openId;

  /**
   * 在社交网络上的昵称。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String nickname;

  /**
   * 在社交网络上的头像。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String avatar;

  /**
   * 在社交网络上的个人信息。
   */
  @Size(min = 1, max = 10)
  @Nullable
  private KeyValuePairList profiles;

  /**
   * 额外参数。
   */
  @Size(min = 1, max = 10)
  @Reference(entity = Payload.class, existing = false)
  @Nullable
  private List<Payload> payloads;

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

  public SocialNetworkAccount() {
    // empty
  }

  public SocialNetworkAccount(final RegisterUserParams params) {
    Argument.requireNonNull("params", params);
    username = params.getUsername();
    socialNetwork = params.getSocialNetwork();
    appId = params.getAppId();
    openId = params.getOpenId();
    nickname = params.getNickname();
    avatar = params.getAvatar();
  }

  public SocialNetworkAccount(final SocialNetworkAccount other) {
    assign(other);
  }

  @Override
  public void assign(final SocialNetworkAccount other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    username = other.username;
    socialNetwork = other.socialNetwork;
    appId = other.appId;
    openId = other.openId;
    nickname = other.nickname;
    avatar = other.avatar;
    profiles = Assignment.clone(other.profiles);
    payloads = Assignment.deepClone(other.payloads);
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public SocialNetworkAccount clone() {
    return new SocialNetworkAccount(this);
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

  public SocialNetwork getSocialNetwork() {
    return socialNetwork;
  }

  public void setSocialNetwork(final SocialNetwork socialNetwork) {
    this.socialNetwork = socialNetwork;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(final String appId) {
    this.appId = appId;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(final String openId) {
    this.openId = openId;
  }

  @Nullable
  public String getNickname() {
    return nickname;
  }

  public void setNickname(@Nullable final String nickname) {
    this.nickname = nickname;
  }

  @Nullable
  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(@Nullable final String avatar) {
    this.avatar = avatar;
  }

  @Nullable
  public KeyValuePairList getProfiles() {
    return profiles;
  }

  public void setProfiles(@Nullable final KeyValuePairList profiles) {
    this.profiles = profiles;
  }

  @Nullable
  public List<Payload> getPayloads() {
    return payloads;
  }

  public void setPayloads(@Nullable final List<Payload> payloads) {
    this.payloads = payloads;
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

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final SocialNetworkAccount other = (SocialNetworkAccount) o;
    return Equality.equals(id, other.id)
        && Equality.equals(username, other.username)
        && Equality.equals(socialNetwork, other.socialNetwork)
        && Equality.equals(appId, other.appId)
        && Equality.equals(openId, other.openId)
        && Equality.equals(nickname, other.nickname)
        && Equality.equals(avatar, other.avatar)
        && Equality.equals(profiles, other.profiles)
        && Equality.equals(payloads, other.payloads)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, username);
    result = Hash.combine(result, multiplier, socialNetwork);
    result = Hash.combine(result, multiplier, appId);
    result = Hash.combine(result, multiplier, openId);
    result = Hash.combine(result, multiplier, nickname);
    result = Hash.combine(result, multiplier, avatar);
    result = Hash.combine(result, multiplier, profiles);
    result = Hash.combine(result, multiplier, payloads);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this).append("id", id)
        .append("username", username)
        .append("socialNetwork", socialNetwork)
        .append("appId", appId)
        .append("openId", openId)
        .append("nickname", nickname)
        .append("avatar", avatar)
        .append("profiles", profiles)
        .append("payloads", payloads)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
