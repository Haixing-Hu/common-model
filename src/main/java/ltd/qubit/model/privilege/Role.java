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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import ltd.qubit.model.commons.App;
import ltd.qubit.model.commons.State;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.HasStatefulInfo;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;

/**
 * 此模型表示不同App中的系统角色。
 *
 * @author 孙建，胡海星
 */
public class Role implements HasStatefulInfo, WithApp, Auditable, Assignable<Role> {

  private static final long serialVersionUID = 8407047795229301900L;

  /**
   * 从指定的角色列表中获取权限列表。
   *
   * @param roles
   *     角色列表。
   * @return
   *     获取的权限列表，其中权限确保不重复。
   */
  public static String[] collectPrivileges(final List<Role> roles) {
    final Set<String> result = new HashSet<>();
    for (final Role role : roles) {
      final String[] privileges = role.getPrivileges();
      if (privileges != null && privileges.length > 0) {
        Collections.addAll(result, privileges);
      }
    }
    return result.toArray(new String[0]);
  }

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所属App。
   */
  @Reference(entity = App.class, property = "info")
  private StatefulInfo app;

  /**
   * 编码，同一个App下不可重复。
   */
  @Size(min = 1, max = 64)
  @Unique(respectTo = "app")
  private String code;

  /**
   * 名称，同一个App下不可重复。
   */
  @Size(min = 1, max = 128)
  @Unique(respectTo = "app")
  private String name;

  /**
   * 描述。
   */
  @Nullable
  private String description;

  /**
   * 是否是访客角色。
   */
  @Indexed
  private Boolean guest;

  /**
   * 是否是默认的基本角色。
   */
  @Indexed
  private Boolean basic;

  /**
   * 操作权限。
   */
  @Size(min = 1, max = 256)
  private String[] privileges;

  /**
   * 状态。
   */
  @Indexed
  private State state = State.NORMAL;

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
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant deleteTime;

  public Role() {
    // empty
  }

  public Role(final Role other) {
    assign(other);
  }

  @Override
  public void assign(final Role other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    app = Assignment.clone(other.app);
    code = other.code;
    name = other.name;
    description = other.description;
    guest = other.guest;
    basic = other.basic;
    privileges = Assignment.clone(other.privileges);
    state = other.state;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Role clone() {
    return new Role(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public StatefulInfo getApp() {
    return app;
  }

  public void setApp(final StatefulInfo app) {
    this.app = app;
  }

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  public Boolean isGuest() {
    return guest;
  }

  public void setGuest(final Boolean guest) {
    this.guest = guest;
  }

  public Boolean isBasic() {
    return basic;
  }

  public void setBasic(final Boolean basic) {
    this.basic = basic;
  }

  public String[] getPrivileges() {
    return privileges;
  }

  public void setPrivileges(final String[] privileges) {
    this.privileges = privileges;
  }

  public State getState() {
    return state;
  }

  public void setState(final State state) {
    this.state = state;
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

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Role other = (Role) o;
    return Equality.equals(id, other.id)
        && Equality.equals(app, other.app)
        && Equality.equals(code, other.code)
        && Equality.equals(name, other.name)
        && Equality.equals(description, other.description)
        && Equality.equals(guest, other.guest)
        && Equality.equals(basic, other.basic)
        && Equality.equals(privileges, other.privileges)
        && Equality.equals(state, other.state)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, guest);
    result = Hash.combine(result, multiplier, basic);
    result = Hash.combine(result, multiplier, privileges);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("app", app)
        .append("code", code)
        .append("name", name)
        .append("description", description)
        .append("guest", guest)
        .append("basic", basic)
        .append("privileges", privileges)
        .append("state", state)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
