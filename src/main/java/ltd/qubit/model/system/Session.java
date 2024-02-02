////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.system;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.NotNull;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Indexed;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.commons.Token;
import ltd.qubit.model.person.User;
import ltd.qubit.model.person.UserInfo;
import ltd.qubit.model.util.Creatable;
import ltd.qubit.model.util.Expirable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Normalizable;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;
import ltd.qubit.model.util.WithToken;

import static ltd.qubit.commons.lang.Argument.requireNonNull;

/**
 * 此模型表示登录会话信息。
 *
 * @author 胡海星
 */
public class Session implements Identifiable, WithApp, WithToken, Expirable,
    Creatable, Normalizable, Assignable<Session> {

  private static final long serialVersionUID = -3182545272338585538L;

  private static final ThreadLocal<Session> CURRENT_SESSION = new ThreadLocal<>();

  /**
   * 获取当前线程的会话信息。
   *
   * @return
   *     当前线程中保存的全局{@link Session}对象，若调用此函数前没有保存过{@link Session}
   *     对象，此函数会创建一个新的空白的{@link Session}对象，保存在当前线程中并返回。
   */
  public static Session getCurrentSession() {
    Session current = CURRENT_SESSION.get();
    if (current == null) {
      current = new Session();
      CURRENT_SESSION.set(current);
    }
    return current;
  }

  /**
   * 设置当前线程的会话信息。
   *
   * @param session
   *     当前线程中应保存的全局{@link Session}对象，不能为{@code null}。
   */
  public static void setCurrentSession(@NotNull final Session session) {
    CURRENT_SESSION.set(requireNonNull("session", session));
  }

  /**
   * 获取当前线程的应用信息。
   *
   * @return
   *     当前线程的应用信息，注意可能为{@code null}。
   */
  @Nullable
  public static StatefulInfo getCurrentApp() {
    return getCurrentSession().getApp();
  }

  /**
   * 获取当前线程的用户信息。
   *
   * @return
   *     当前线程的用户信息，注意可能为{@code null}。
   */
  @Nullable
  public static UserInfo getCurrentUser() {
    return getCurrentSession().getUser();
  }

  /**
   * 获取当前线程的用户存取令牌。
   *
   * @return
   *     当前线程的用户存取令牌，注意可能为{@code null}。
   */
  @Nullable
  public static Token getCurrentUserToken() {
    return getCurrentSession().getToken();
  }

  /**
   * 获取当前线程的应用信息。
   *
   * @param app
   *     当前线程的应用信息，若为{@code null}则表示清空当前线程的应用信息。
   */
  public static void setCurrentApp(@Nullable final StatefulInfo app) {
    getCurrentSession().setApp(app);
  }

  /**
   * 获取当前线程的用户信息。
   *
   * @param user
   *     当前线程的用户信息，若为{@code null}则表示清空当前线程的用户信息。
   */
  public static void setCurrentUser(@Nullable final UserInfo user) {
    getCurrentSession().setUser(user);
  }

  /**
   * 获取当前线程的用户存取令牌。
   *
   * @param token
   *     当前线程的用户存取令牌，若为{@code null}则表示清空当前线程的用户令牌。
   */
  public static void setCurrentUserToken(@Nullable final Token token) {
    getCurrentSession().setToken(token);
  }

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 会话发起App。
   */
  @Reference(entity = App.class, property = "info")
  private StatefulInfo app;

  /**
   * 会话发起用户，即当前登录用户。
   */
  @Reference(entity = User.class, property = "info")
  @Nullable
  private UserInfo user;

  /**
   * 会话发起用户的令牌。
   */
  private Token token;

  /**
   * 会话发起用户在当前app中所拥有的角色。
   */
  @Nullable
  private String[] roles;

  /**
   * 会话发起用户在当前app中所拥有的权限。
   */
  @Nullable
  private String[] privileges;

  /**
   * 会话发起客户端的环境。
   */
  @Nullable
  private Environment environment;

  /**
   * 该会话用户最后一次活动时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant lastActiveTime;

  /**
   * 会话过期信息。
   */
  @Indexed
  @Nullable
  private Expired expired;

  /**
   * 该会话创建时间，即用户登录时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  private Instant createTime;

  public Session() {
    // empty
  }

  public Session(final Session other) {
    assign(other);
  }

  @Override
  public void assign(final Session other) {
    requireNonNull("other", other);
    id = other.id;
    app = Assignment.clone(other.app);
    user = Assignment.clone(other.user);
    token = Assignment.clone(other.token);
    roles = Assignment.clone(other.roles);
    privileges = Assignment.clone(other.privileges);
    environment = Assignment.clone(other.environment);
    lastActiveTime = other.lastActiveTime;
    expired = Assignment.clone(other.expired);
    createTime = other.createTime;
  }

  @Override
  public Session clone() {
    return new Session(this);
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

  @Nullable
  public UserInfo getUser() {
    return user;
  }

  public void setUser(@Nullable final UserInfo user) {
    this.user = user;
  }

  public Token getToken() {
    return token;
  }

  public void setToken(final Token token) {
    this.token = token;
  }

  @Nullable
  public String[] getRoles() {
    return roles;
  }

  public void setRoles(@Nullable final String[] roles) {
    this.roles = roles;
  }

  @Nullable
  public String[] getPrivileges() {
    return privileges;
  }

  public void setPrivileges(@Nullable final String[] privileges) {
    this.privileges = privileges;
  }

  @Nullable
  public Environment getEnvironment() {
    return environment;
  }

  public void setEnvironment(@Nullable final Environment environment) {
    this.environment = environment;
  }

  public Instant getLastActiveTime() {
    return lastActiveTime;
  }

  public void setLastActiveTime(final Instant lastActiveTime) {
    this.lastActiveTime = lastActiveTime;
  }

  @Nullable
  public Expired getExpired() {
    return expired;
  }

  public void setExpired(@Nullable final Expired expired) {
    this.expired = expired;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Session other = (Session) o;
    return Equality.equals(id, other.id)
        && Equality.equals(app, other.app)
        && Equality.equals(user, other.user)
        && Equality.equals(token, other.token)
        && Equality.equals(roles, other.roles)
        && Equality.equals(privileges, other.privileges)
        && Equality.equals(environment, other.environment)
        && Equality.equals(lastActiveTime, other.lastActiveTime)
        && Equality.equals(expired, other.expired)
        && Equality.equals(createTime, other.createTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, user);
    result = Hash.combine(result, multiplier, token);
    result = Hash.combine(result, multiplier, roles);
    result = Hash.combine(result, multiplier, privileges);
    result = Hash.combine(result, multiplier, environment);
    result = Hash.combine(result, multiplier, lastActiveTime);
    result = Hash.combine(result, multiplier, expired);
    result = Hash.combine(result, multiplier, createTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("app", app)
        .append("user", user)
        .append("token", token)
        .append("roles", roles)
        .append("privileges", privileges)
        .append("environment", environment)
        .append("lastActiveTime", lastActiveTime)
        .append("expired", expired)
        .append("createTime", createTime)
        .toString();
  }
}
