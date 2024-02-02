////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.commons;

import java.io.Serializable;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Emptyful;
import ltd.qubit.model.util.Normalizable;

/**
 * 此模型表示定期执行的任务计划。
 *
 * <p>此对象使用 Spring 框架的 crontab 表达式来指定计划执行的时间点，其语法规则参见：
 * <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/support/CronExpression.html">CronExpression</a></p>
 *
 * @author 胡海星
 * @see <a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/support/CronExpression.html">CronExpression</a>
 * @see <a href="https://www.baeldung.com/cron-expressions">A Guide To Cron Expressions</a>
 */
public class Schedule implements Emptyful, Normalizable, Assignable<Schedule>,
    Serializable {

  private static final long serialVersionUID = -2368199450049878746L;

  /**
   * 计划开始时间点，UTC时区，精度为秒。
   */
  @Precision(value = TimeUnit.SECONDS)
  private Instant startTime;

  /**
   * 计划结束时间点，UTC时区，精度为秒。
   *
   * <p>为{@code null}则表示不作限制。</p>
   */
  @Precision(value = TimeUnit.SECONDS)
  @Nullable
  private Instant endTime;

  /**
   * 用于计算计划执行时间点的 crontab 表达式列表。
   *
   * <p>为{@code null}则表示不作限制。</p>
   */
  @Size(min = 1, max = 10)
  @Nullable
  private String[] crontabs;

  public Schedule() {
    // empty
  }

  public Schedule(final Schedule other) {
    assign(other);
  }

  @Override
  public void assign(final Schedule other) {
    Argument.requireNonNull("other", other);
    startTime = other.startTime;
    endTime = other.endTime;
    crontabs = Assignment.clone(other.crontabs);
  }

  @Override
  public Schedule clone() {
    return new Schedule(this);
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

  @Nullable
  public String[] getCrontabs() {
    return crontabs;
  }

  public void setCrontabs(@Nullable final String[] crontabs) {
    this.crontabs = crontabs;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Schedule other = (Schedule) o;
    return Equality.equals(startTime, other.startTime)
        && Equality.equals(endTime, other.endTime)
        && Equality.equals(crontabs, other.crontabs);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, startTime);
    result = Hash.combine(result, multiplier, endTime);
    result = Hash.combine(result, multiplier, crontabs);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("startTime", startTime)
        .append("endTime", endTime)
        .append("crontabs", crontabs)
        .toString();
  }
}
