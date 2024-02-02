////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.shipping;

import java.io.Serializable;

import javax.annotation.Nullable;

import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.range.LocalDateRange;
import ltd.qubit.commons.util.range.LocalTimeRange;
import ltd.qubit.model.commons.DayType;

/**
 * 此模型表示配送需求。
 *
 * @author 胡海星
 */
public class ShippingDemand implements Serializable,
    Assignable<ShippingDemand> {

  private static final long serialVersionUID = -6199522434591092369L;

  /**
   * 允许的配送日期类型。
   */
  @Nullable
  private DayType dayType;

  /**
   * 允许的配送日期范围。
   */
  @Nullable
  private LocalDateRange dateRange;

  /**
   * 允许的配送时间范围。
   */
  @Nullable
  private LocalTimeRange timeRange;

  /**
   * 配送的包装要求。
   */
  private Packing packing;

  /**
   * 其他配送要求留言。
   */
  @Nullable
  private String comment;

  public ShippingDemand() {
    // empty
  }

  public ShippingDemand(final ShippingDemand other) {
    assign(other);
  }

  @Override
  public void assign(final ShippingDemand other) {
    Argument.requireNonNull("other", other);
    dayType = other.dayType;
    dateRange = Assignment.clone(other.dateRange);
    timeRange = Assignment.clone(other.timeRange);
    packing = other.packing;
    comment = other.comment;
  }

  @Override
  public ShippingDemand clone() {
    return new ShippingDemand(this);
  }

  @Nullable
  public DayType getDayType() {
    return dayType;
  }

  public void setDayType(@Nullable final DayType dayType) {
    this.dayType = dayType;
  }

  @Nullable
  public LocalDateRange getDateRange() {
    return dateRange;
  }

  public void setDateRange(@Nullable final LocalDateRange dateRange) {
    this.dateRange = dateRange;
  }

  @Nullable
  public LocalTimeRange getTimeRange() {
    return timeRange;
  }

  public void setTimeRange(@Nullable final LocalTimeRange timeRange) {
    this.timeRange = timeRange;
  }

  public Packing getPacking() {
    return packing;
  }

  public void setPacking(final Packing packing) {
    this.packing = packing;
  }

  @Nullable
  public String getComment() {
    return comment;
  }

  public void setComment(@Nullable final String comment) {
    this.comment = comment;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final ShippingDemand other = (ShippingDemand) o;
    return Equality.equals(dayType, other.dayType)
        && Equality.equals(dateRange, other.dateRange)
        && Equality.equals(timeRange, other.timeRange)
        && Equality.equals(packing, other.packing)
        && Equality.equals(comment, other.comment);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, dayType);
    result = Hash.combine(result, multiplier, dateRange);
    result = Hash.combine(result, multiplier, timeRange);
    result = Hash.combine(result, multiplier, packing);
    result = Hash.combine(result, multiplier, comment);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("dayType", dayType)
        .append("dateRange", dateRange)
        .append("timeRange", timeRange)
        .append("packing", packing)
        .append("comment", comment)
        .toString();
  }
}
