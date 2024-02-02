////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim.enterprise;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Creatable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示企业保险理赔事件。
 *
 * @author 潘凯
 */
public final class EnterpriseClaimEvent implements Identifiable, Creatable,
    Assignable<EnterpriseClaimEvent> {

  private static final long serialVersionUID = 1399012320113145140L;

  /**
   * 内部ID，全局唯一，亦作为理赔流水号。
   */
  @Identifier
  private Long id;

  /**
   * 理赔ID。
   */
  private Long claimId;

  /**
   * 事件结果。
   */
  private EnterpriseClaimStatus status;

  /**
   * 事件结果分组。
   */
  private EnterpriseClaimStatusGroup statusGroup;

  /**
   * 案件处理人姓名。
   */
  private String operatorName;

  /**
   * 详情描述。
   */
  private String detail;

  /**
   * 创建时间，即提交时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  public EnterpriseClaimEvent() {
    // empty
  }

  public EnterpriseClaimEvent(final EnterpriseClaimEvent other) {
    assign(other);
  }

  @Override
  public void assign(final EnterpriseClaimEvent other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    claimId = other.claimId;
    status = other.status;
    statusGroup = other.statusGroup;
    operatorName = other.operatorName;
    detail = other.detail;
    createTime = other.createTime;
  }

  @Override
  public EnterpriseClaimEvent clone() {
    return new EnterpriseClaimEvent(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getClaimId() {
    return claimId;
  }

  public void setClaimId(final Long claimId) {
    this.claimId = claimId;
  }

  public EnterpriseClaimStatus getStatus() {
    return status;
  }

  public void setStatus(final EnterpriseClaimStatus status) {
    this.status = status;
  }

  public EnterpriseClaimStatusGroup getStatusGroup() {
    return statusGroup;
  }

  public void setStatusGroup(final EnterpriseClaimStatusGroup statusGroup) {
    this.statusGroup = statusGroup;
  }

  public String getOperatorName() {
    return operatorName;
  }

  public void setOperatorName(final String operatorName) {
    this.operatorName = operatorName;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(final String detail) {
    this.detail = detail;
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
    final EnterpriseClaimEvent other = (EnterpriseClaimEvent) o;
    return Equality.equals(id, other.id)
        && Equality.equals(claimId, other.claimId)
        && Equality.equals(status, other.status)
        && Equality.equals(statusGroup, other.statusGroup)
        && Equality.equals(operatorName, other.operatorName)
        && Equality.equals(detail, other.detail)
        && Equality.equals(createTime, other.createTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, claimId);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, statusGroup);
    result = Hash.combine(result, multiplier, operatorName);
    result = Hash.combine(result, multiplier, detail);
    result = Hash.combine(result, multiplier, createTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("claimId", claimId)
        .append("status", status)
        .append("statusGroup", statusGroup)
        .append("operatorName", operatorName)
        .append("detail", detail)
        .append("createTime", createTime)
        .toString();
  }
}
