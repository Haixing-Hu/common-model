////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示推广人员的信息.
 *
 * @author 潘凯
 */
public class RefererInfo implements Identifiable, Auditable,
    Assignable<RefererInfo> {

  private static final long serialVersionUID = 3943505292507947521L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 外部渠道类型。
   *
   * FIXME: 字段名应保持一致，参见 open-id
   */
  private OpenidType openidType;

  /**
   * 外部渠道的唯一标识ID。
   *
   * FIXME: 字段名应保持一致，参见 openid-type
   */
  @Size(min = 1, max = 128)
  private String openid;

  /**
   * 推广人员的类型。
   */
  private String refererType;

  /**
   * 推广人员的ID。
   */
  private Long refererId;

  /**
   * 创建时间，存储UTC时间戳。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 最后一次修改时间，存储UTC时间戳。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 标记删除时间，存储UTC时间戳。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public RefererInfo() {
    // empty
  }

  public RefererInfo(final RefererInfo other) {
    assign(other);
  }

  @Override
  public void assign(final RefererInfo other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    openidType = other.openidType;
    openid = other.openid;
    refererType = other.refererType;
    refererId = other.refererId;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public RefererInfo clone() {
    return new RefererInfo(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public OpenidType getOpenidType() {
    return openidType;
  }

  public void setOpenidType(final OpenidType openidType) {
    this.openidType = openidType;
  }

  public String getOpenid() {
    return openid;
  }

  public void setOpenid(final String openid) {
    this.openid = openid;
  }

  public String getRefererType() {
    return refererType;
  }

  public void setRefererType(final String refererType) {
    this.refererType = refererType;
  }

  public Long getRefererId() {
    return refererId;
  }

  public void setRefererId(final Long refererId) {
    this.refererId = refererId;
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
    final RefererInfo other = (RefererInfo) o;
    return Equality.equals(id, other.id)
        && Equality.equals(openidType, other.openidType)
        && Equality.equals(openid, other.openid)
        && Equality.equals(refererType, other.refererType)
        && Equality.equals(refererId, other.refererId)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, openidType);
    result = Hash.combine(result, multiplier, openid);
    result = Hash.combine(result, multiplier, refererType);
    result = Hash.combine(result, multiplier, refererId);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("openidType", openidType)
        .append("openid", openid)
        .append("refererType", refererType)
        .append("refererId", refererId)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
