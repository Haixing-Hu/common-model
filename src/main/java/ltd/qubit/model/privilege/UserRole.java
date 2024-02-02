////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.privilege;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

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
import ltd.qubit.model.commons.App;
import ltd.qubit.model.person.User;
import ltd.qubit.model.person.UserInfo;
import ltd.qubit.model.util.Creatable;
import ltd.qubit.model.util.Deletable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.StatefulInfo;

/**
 * 此模型表示用户在特定应用下的角色信息。
 *
 * @author 孙建，胡海星
 */
public class UserRole implements Identifiable, Creatable, Deletable, Assignable<UserRole> {

  private static final long serialVersionUID = 3352425101388793004L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 用户信息。
   */
  @Reference(entity = User.class, property = "info")
  private UserInfo user;

  /**
   * 所属App。
   */
  @Reference(entity = App.class, property = "info")
  private StatefulInfo app;

  /**
   * 角色。
   */
  @Reference(entity = Role.class, property = "info")
  @Unique(respectTo = {"user", "app"})
  private StatefulInfo role;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  private Instant createTime;

  /**
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant deleteTime;

  public UserRole() {
    // empty
  }

  public UserRole(final UserInfo user, final StatefulInfo app,
      final StatefulInfo role) {
    this.user = user;
    this.app = app;
    this.role = role;
  }

  public UserRole(final UserInfo user, final Role role) {
    this.user = user;
    this.app = role.getApp();
    this.role = role.getInfo();
  }

  public UserRole(final UserRole other) {
    assign(other);
  }

  @Override
  public void assign(final UserRole other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    user = Assignment.clone(other.user);
    app = Assignment.clone(other.app);
    role = Assignment.clone(other.role);
    createTime = other.createTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public UserRole clone() {
    return new UserRole(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public UserInfo getUser() {
    return user;
  }

  public void setUser(final UserInfo user) {
    this.user = user;
  }

  public StatefulInfo getApp() {
    return app;
  }

  public void setApp(final StatefulInfo app) {
    this.app = app;
  }

  public StatefulInfo getRole() {
    return role;
  }

  public void setRole(final StatefulInfo role) {
    this.role = role;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final UserRole other = (UserRole) o;
    return Equality.equals(id, other.id)
        && Equality.equals(user, other.user)
        && Equality.equals(app, other.app)
        && Equality.equals(role, other.role)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, user);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, role);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("user", user)
        .append("app", app)
        .append("role", role)
        .append("createTime", createTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
