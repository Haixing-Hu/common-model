////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.work;

import java.time.Instant;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.range.LocalTimeRangeList;
import ltd.qubit.model.organization.Employee;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示排班信息。
 *
 * @author 王佳，胡海星
 */
public class WorkSchedule implements Identifiable, Auditable,
    Assignable<WorkSchedule>  {

  private static final long serialVersionUID = 6672398456292870406L;

  /**
   * 唯一标识。
   */
  @Identifier
  private Long id;

  /**
   * 所属雇员ID，对应于 {@link Employee} 类的 id 属性。
   */
  private Long employeeId;

  /**
   * 排班日期。
   */
  private LocalDate date;

  /**
   * 工作时段。
   */
  private LocalTimeRangeList intervals;

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

  public WorkSchedule() {
    // empty
  }

  public WorkSchedule(final WorkSchedule other) {
    assign(other);
  }

  @Override
  public void assign(final WorkSchedule other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    employeeId = other.employeeId;
    date = other.date;
    intervals = Assignment.clone(other.intervals);
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public WorkSchedule clone() {
    return new WorkSchedule(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(final Long employeeId) {
    this.employeeId = employeeId;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(final LocalDate date) {
    this.date = date;
  }

  public LocalTimeRangeList getIntervals() {
    return intervals;
  }

  public void setIntervals(final LocalTimeRangeList intervals) {
    this.intervals = intervals;
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
    final WorkSchedule other = (WorkSchedule) o;
    return Equality.equals(id, other.id)
        && Equality.equals(employeeId, other.employeeId)
        && Equality.equals(date, other.date)
        && Equality.equals(intervals, other.intervals)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, employeeId);
    result = Hash.combine(result, multiplier, date);
    result = Hash.combine(result, multiplier, intervals);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("employeeId", employeeId)
        .append("date", date)
        .append("intervals", intervals)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
