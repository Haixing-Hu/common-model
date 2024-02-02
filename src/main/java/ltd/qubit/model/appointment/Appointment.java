////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.appointment;

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
import ltd.qubit.model.audit.AuditStatus;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.person.PersonInfo;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.StatefulInfo;

/**
 * 此模型表示用户预约记录。
 *
 * @author 王佳，胡海星
 */
public class Appointment implements Identifiable, Assignable<Appointment> {

  private static final long serialVersionUID = 7345977259699721726L;

  /**
   * 唯一标识。
   */
  @Identifier
  private Long id;

  /**
   * 所属 App 的基本信息。
   */
  @Reference(entity = App.class, property = "info")
  private StatefulInfo app;

  /**
   * 预约目标类型。
   */
  @Size(min = 1, max = 64)
  private String objectiveType;

  /**
   * 预约目标ID。
   */
  private Long objectiveId;

  /**
   * 预约申请人信息。
   */
  private PersonInfo applicant;

  /**
   * 预约服务开始时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant startTime;

  /**
   * 预约服务结束时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant endTime;

  /**
   * 审核状态。
   */
  private AuditStatus auditStatus;

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

  public Appointment() {
    // empty
  }

  public Appointment(final Appointment other) {
    assign(other);
  }

  @Override
  public void assign(final Appointment other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    app = Assignment.clone(other.app);
    objectiveType = other.objectiveType;
    objectiveId = other.objectiveId;
    applicant = Assignment.clone(other.applicant);
    startTime = other.startTime;
    endTime = other.endTime;
    auditStatus = other.auditStatus;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Appointment clone() {
    return new Appointment(this);
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(final Long id) {
    this.id = id;
  }

  public StatefulInfo getApp() {
    return app;
  }

  public void setApp(final StatefulInfo app) {
    this.app = app;
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

  public PersonInfo getApplicant() {
    return applicant;
  }

  public void setApplicant(final PersonInfo applicant) {
    this.applicant = applicant;
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

  public AuditStatus getAuditStatus() {
    return auditStatus;
  }

  public void setAuditStatus(final AuditStatus auditStatus) {
    this.auditStatus = auditStatus;
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

  @Override
  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Appointment other = (Appointment) o;
    return Equality.equals(id, other.id)
        && Equality.equals(app, other.app)
        && Equality.equals(objectiveType, other.objectiveType)
        && Equality.equals(objectiveId, other.objectiveId)
        && Equality.equals(applicant, other.applicant)
        && Equality.equals(startTime, other.startTime)
        && Equality.equals(endTime, other.endTime)
        && Equality.equals(auditStatus, other.auditStatus)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, objectiveType);
    result = Hash.combine(result, multiplier, objectiveId);
    result = Hash.combine(result, multiplier, applicant);
    result = Hash.combine(result, multiplier, startTime);
    result = Hash.combine(result, multiplier, endTime);
    result = Hash.combine(result, multiplier, auditStatus);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("app", app)
        .append("objectiveType", objectiveType)
        .append("objectiveId", objectiveId)
        .append("applicant", applicant)
        .append("startTime", startTime)
        .append("endTime", endTime)
        .append("auditStatus", auditStatus)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
