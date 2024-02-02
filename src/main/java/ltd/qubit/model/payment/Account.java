////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;

/**
 * 此模型表示支付账户信息。
 *
 * @author 胡海星
 */
public class Account implements Identifiable, WithApp, Auditable,
    Assignable<Account> {

  private static final long serialVersionUID = 4496911705225403028L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所属 App 的基本信息。
   */
  private StatefulInfo app;

  /**
   * 所有者的实体类型。
   */
  @Size(min = 1, max = 64)
  private String ownerType;

  /**
   * 所有者的实体ID。
   */
  private Long ownerId;

  /**
   * 账户类别。
   */
  private AccountType type;

  /**
   * 账户名称，此名称是该账户在支付平台内部的显示名称。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 账户号码。
   *
   * <p>如该账户不是平台内部账户，则此号码对应于第三方支付的账号，或者银行卡卡号等。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String number;

  /**
   * 账户账号供应商的基本信息。
   *
   * <p>如该账户不是平台内部账户，则此对象对应于第三方支付的渠道供应商信息，
   * 或者银行卡开户行信息等。
   */
  @Nullable
  private Info provider;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public Account() {
    // empty
  }

  public Account(final Account other) {
    assign(other);
  }

  @Override
  public void assign(final Account other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    app = Assignment.clone(other.app);
    ownerType = other.ownerType;
    ownerId = other.ownerId;
    type = other.type;
    name = other.name;
    number = other.number;
    provider = Assignment.clone(other.provider);
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Account clone() {
    return new Account(this);
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

  public String getOwnerType() {
    return ownerType;
  }

  public void setOwnerType(final String ownerType) {
    this.ownerType = ownerType;
  }

  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(final Long ownerId) {
    this.ownerId = ownerId;
  }

  public AccountType getType() {
    return type;
  }

  public void setType(final AccountType type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Nullable
  public String getNumber() {
    return number;
  }

  public void setNumber(@Nullable final String number) {
    this.number = number;
  }

  @Nullable
  public Info getProvider() {
    return provider;
  }

  public void setProvider(@Nullable final Info provider) {
    this.provider = provider;
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
    final Account other = (Account) o;
    return Equality.equals(id, other.id)
        && Equality.equals(app, other.app)
        && Equality.equals(ownerType, other.ownerType)
        && Equality.equals(ownerId, other.ownerId)
        && Equality.equals(type, other.type)
        && Equality.equals(name, other.name)
        && Equality.equals(number, other.number)
        && Equality.equals(provider, other.provider)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, ownerType);
    result = Hash.combine(result, multiplier, ownerId);
    result = Hash.combine(result, multiplier, type);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, provider);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("app", app)
        .append("ownerType", ownerType)
        .append("ownerId", ownerId)
        .append("type", type)
        .append("name", name)
        .append("number", number)
        .append("provider", provider)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
