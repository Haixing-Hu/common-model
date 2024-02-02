////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.activity;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.State;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.HasInfo;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.Stateful;

/**
 * 此模型表示营销活动。
 *
 * @author 潘凯，胡海星
 */
public class Activity implements HasInfo, Stateful, Auditable,
    Assignable<Activity> {

  private static final long serialVersionUID = 984809454885498013L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 代码，全局不可重复，一旦设置不能更改。
   */
  @Unique
  @Size(min = 1, max = 64)
  private String code;

  /**
   * 名称，同一产品下不可重复。
   */
  @Size(min = 1, max = 256)
  private String name;

  /**
   * 所属应用。
   */
  private Info app;

  /**
   * 产品分项列表。
   */
  private List<ActivityProductItem> items;

  /**
   * 描述。
   */
  @Nullable
  private String description;

  /**
   * 开始时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant startTime;

  /**
   * 结束时间。
   */
  @Precision(TimeUnit.SECONDS)
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

  public Activity() {
    // empty
  }

  public Activity(final Activity other) {
    assign(other);
  }

  @Override
  public void assign(final Activity other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    name = other.name;
    app = Assignment.clone(other.app);
    items = Assignment.deepClone(other.items);
    description = other.description;
    startTime = other.startTime;
    endTime = other.endTime;
    state = other.state;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Activity clone() {
    return new Activity(this);
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

  public Info getApp() {
    return app;
  }

  public void setApp(final Info app) {
    this.app = app;
  }

  public List<ActivityProductItem> getItems() {
    return items;
  }

  public void setItems(final List<ActivityProductItem> items) {
    this.items = items;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  public Instant getStartTime() {
    return startTime;
  }

  public void setStartTime(final Instant startTime) {
    this.startTime = startTime;
  }

  public Instant getEndTime() {
    return endTime;
  }

  public void setEndTime(final Instant endTime) {
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
    final Activity other = (Activity) o;
    return Equality.equals(id, other.id)
        && Equality.equals(code, other.code)
        && Equality.equals(name, other.name)
        && Equality.equals(app, other.app)
        && Equality.equals(items, other.items)
        && Equality.equals(description, other.description)
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
    result = Hash.combine(result, multiplier, items);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, startTime);
    result = Hash.combine(result, multiplier, endTime);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("code", code)
        .append("name", name)
        .append("app", app)
        .append("items", items)
        .append("description", description)
        .append("startTime", startTime)
        .append("endTime", endTime)
        .append("state", state)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
