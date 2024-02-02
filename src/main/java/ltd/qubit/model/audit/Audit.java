////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.audit;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.organization.Employee;
import ltd.qubit.model.organization.EmployeeInfo;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示审核记录。
 *
 * @author 胡海星
 */
public class Audit implements Identifiable, Auditable, Assignable<Audit> {

  private static final long serialVersionUID = -8570293479717426895L;

  /**
   * 唯一标识。
   */
  @Identifier
  private Long id;

  /**
   * 审核对象类型。
   */
  @Size(min = 1, max = 64)
  private String objectiveType;

  /**
   * 审核对象ID。
   */
  private Long objectiveId;

  /**
   * 审核状态。
   */
  private AuditStatus status;

  /**
   * 审核人的基本信息。
   */
  @Reference(entity = Employee.class, property = "info")
  private EmployeeInfo auditor;

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

  public Audit() {
    // empty
  }

  public Audit(final Audit other) {
    assign(other);
  }

  @Override
  public void assign(final Audit other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    objectiveType = other.objectiveType;
    objectiveId = other.objectiveId;
    status = other.status;
    auditor = Assignment.clone(other.auditor);
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Audit clone() {
    return new Audit(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getObjectiveType() {
    return objectiveType;
  }

  public void setObjectiveType(final String objectiveType) {
    this.objectiveType = objectiveType;
  }

  public Long getObjectiveId() {
    return objectiveId;
  }

  public void setObjectiveId(final Long objectiveId) {
    this.objectiveId = objectiveId;
  }

  public AuditStatus getStatus() {
    return status;
  }

  public void setStatus(final AuditStatus status) {
    this.status = status;
  }

  public EmployeeInfo getAuditor() {
    return auditor;
  }

  public void setAuditor(final EmployeeInfo auditor) {
    this.auditor = auditor;
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
    final Audit other = (Audit) o;
    return Equality.equals(id, other.id)
        && Equality.equals(objectiveType, other.objectiveType)
        && Equality.equals(objectiveId, other.objectiveId)
        && Equality.equals(status, other.status)
        && Equality.equals(auditor, other.auditor)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, objectiveType);
    result = Hash.combine(result, multiplier, objectiveId);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, auditor);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("objectiveType", objectiveType)
        .append("objectiveId", objectiveId)
        .append("status", status)
        .append("auditor", auditor)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
