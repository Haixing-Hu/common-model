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

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Indexed;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.util.Creatable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;

/**
 * 此模型表示手机验证码或邮箱验证码。
 *
 * @author 胡海星
 */
public class VerifyCode implements Identifiable, WithApp, Creatable,
    Assignable<VerifyCode> {

  private static final long serialVersionUID = 3900326335477262558L;

  /**
   * 唯一标识。
   */
  @Identifier
  private Long id;

  /**
   * 所属App。
   */
  @Reference(entity = App.class, property = "info")
  private StatefulInfo app;

  /**
   * 手机号码。
   */
  @Nullable
  @Indexed
  private Phone mobile;

  /**
   * 电子邮件地址。
   */
  @Size(min = 1, max = 512)
  @Indexed
  @Nullable
  private String email;

  /**
   * 验证场景。
   */
  @Indexed
  private VerifyScene scene;

  /**
   * 验证码。
   */
  @Size(min = 1, max = 64)
  private String code;

  /**
   * 发送的验证码消息。
   */
  private String message;

  /**
   * 是否已验证过。
   */
  @Indexed
  private Boolean verified = false;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  private Instant createTime;

  public VerifyCode() {
    // empty
  }

  public VerifyCode(final VerifyCode other) {
    assign(other);
  }

  @Override
  public void assign(final VerifyCode other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    app = Assignment.clone(other.app);
    mobile = Assignment.clone(other.mobile);
    email = other.email;
    scene = other.scene;
    code = other.code;
    message = other.message;
    verified = other.verified;
    createTime = other.createTime;
  }

  @Override
  public VerifyCode clone() {
    return new VerifyCode(this);
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

  public VerifyScene getScene() {
    return scene;
  }

  public void setScene(final VerifyScene scene) {
    this.scene = scene;
  }

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public Boolean isVerified() {
    return verified;
  }

  public void setVerified(final Boolean verified) {
    this.verified = verified;
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
    final VerifyCode other = (VerifyCode) o;
    return Equality.equals(id, other.id)
        && Equality.equals(app, other.app)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(email, other.email)
        && Equality.equals(scene, other.scene)
        && Equality.equals(code, other.code)
        && Equality.equals(message, other.message)
        && Equality.equals(verified, other.verified)
        && Equality.equals(createTime, other.createTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, email);
    result = Hash.combine(result, multiplier, scene);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, message);
    result = Hash.combine(result, multiplier, verified);
    result = Hash.combine(result, multiplier, createTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("app", app)
        .append("mobile", mobile)
        .append("email", email)
        .append("scene", scene)
        .append("code", code)
        .append("message", message)
        .append("verified", verified)
        .append("createTime", createTime)
        .toString();
  }
}
