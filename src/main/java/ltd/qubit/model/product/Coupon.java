////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.product;

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
import ltd.qubit.model.commons.State;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.HasInfo;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;

/**
 * 此模型表示优惠信息。
 *
 * @author 胡海星
 */
public class Coupon implements HasInfo, WithApp, Auditable, Assignable<Coupon> {

  private static final long serialVersionUID = -6289237627529086477L;

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
   * 所属销售商的 ID。
   */
  private Long sellerId;

  /**
   * 所属销售商的名称。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String sellerName;

  /**
   * 图片。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String image;

  /**
   * 描述。
   */
  @Nullable
  private String description;

  /**
   * 规则。
   */
  private CouponRule rule;

  /**
   * 优惠开始时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant startTime;

  /**
   * 优惠结束时间，如为{@code null}则表示永远不结束。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant endTime;

  /**
   * 状态。
   */
  private State state = State.NORMAL;

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

  public Coupon() {
    // empty
  }

  public Coupon(final Coupon other) {
    assign(other);
  }

  @Override
  public void assign(final Coupon other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    name = other.name;
    app = Assignment.clone(other.app);
    sellerId = other.sellerId;
    sellerName = other.sellerName;
    image = other.image;
    description = other.description;
    rule = Assignment.clone(other.rule);
    startTime = other.startTime;
    endTime = other.endTime;
    state = other.state;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Coupon clone() {
    return new Coupon(this);
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

  public Long getSellerId() {
    return sellerId;
  }

  public void setSellerId(final Long sellerId) {
    this.sellerId = sellerId;
  }

  @Nullable
  public String getSellerName() {
    return sellerName;
  }

  public void setSellerName(@Nullable final String sellerName) {
    this.sellerName = sellerName;
  }

  @Nullable
  public String getImage() {
    return image;
  }

  public void setImage(@Nullable final String image) {
    this.image = image;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  public CouponRule getRule() {
    return rule;
  }

  public void setRule(final CouponRule rule) {
    this.rule = rule;
  }

  public Instant getStartTime() {
    return startTime;
  }

  public void setStartTime(final Instant startTime) {
    this.startTime = startTime;
  }

  @Nullable
  public Instant getEndTime() {
    return endTime;
  }

  public void setEndTime(@Nullable final Instant endTime) {
    this.endTime = endTime;
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

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Coupon other = (Coupon) o;
    return Equality.equals(id, other.id)
      && Equality.equals(code, other.code)
      && Equality.equals(name, other.name)
      && Equality.equals(app, other.app)
      && Equality.equals(sellerId, other.sellerId)
      && Equality.equals(sellerName, other.sellerName)
      && Equality.equals(image, other.image)
      && Equality.equals(description, other.description)
      && Equality.equals(rule, other.rule)
      && Equality.equals(startTime, other.startTime)
      && Equality.equals(endTime, other.endTime)
      && Equality.equals(state, other.state)
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
    result = Hash.combine(result, multiplier, sellerId);
    result = Hash.combine(result, multiplier, sellerName);
    result = Hash.combine(result, multiplier, image);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, rule);
    result = Hash.combine(result, multiplier, startTime);
    result = Hash.combine(result, multiplier, endTime);
    result = Hash.combine(result, multiplier, state);
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
      .append("sellerId", sellerId)
      .append("sellerName", sellerName)
      .append("image", image)
      .append("description", description)
      .append("rule", rule)
      .append("startTime", startTime)
      .append("endTime", endTime)
      .append("state", state)
      .append("createTime", createTime)
      .append("modifyTime", modifyTime)
      .append("deleteTime", deleteTime)
      .toString();
  }
}
