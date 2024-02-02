////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.product;

import java.io.Serializable;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
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
import ltd.qubit.model.util.StatefulInfo;

/**
 * 此模型表示优惠计算规则。
 *
 * @author 胡海星
 */
public class CouponRule implements Assignable<CouponRule>, Serializable {

  private static final long serialVersionUID = -5342682177854925520L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 代码，同一App内不可重复。
   */
  @Unique(respectTo = "app")
  @Size(min = 1, max = 64)
  private String code;

  /**
   * 名称，可重复。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 所属 App 的基本信息。
   */
  @Reference(entity = App.class, property = "info")
  private StatefulInfo app;

  /**
   * 规则表达式。
   */
  private String rule;

  /**
   * 描述。
   */
  @Nullable
  private String description;

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
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public CouponRule() {
    // empty
  }

  public CouponRule(final CouponRule other) {
    assign(other);
  }

  @Override
  public void assign(final CouponRule other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    name = other.name;
    app = Assignment.clone(other.app);
    rule = other.rule;
    description = other.description;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public CouponRule clone() {
    return new CouponRule(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
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

  public StatefulInfo getApp() {
    return app;
  }

  public void setApp(final StatefulInfo app) {
    this.app = app;
  }

  public String getRule() {
    return rule;
  }

  public void setRule(final String rule) {
    this.rule = rule;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
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
    final CouponRule other = (CouponRule) o;
    return Equality.equals(id, other.id)
      && Equality.equals(code, other.code)
      && Equality.equals(name, other.name)
      && Equality.equals(app, other.app)
      && Equality.equals(rule, other.rule)
      && Equality.equals(description, other.description)
      && Equality.equals(createTime, other.createTime)
      && Equality.equals(modifyTime, other.modifyTime)
      && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, rule);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this).append("id", id)
      .append("code", code)
      .append("name", name)
      .append("app", app)
      .append("rule", rule)
      .append("description", description)
      .append("createTime", createTime)
      .append("modifyTime", modifyTime)
      .append("deleteTime", deleteTime)
      .toString();
  }
}
