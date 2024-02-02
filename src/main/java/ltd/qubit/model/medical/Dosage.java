////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Period;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Scale;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.DictEntryInfo;

/**
 * 此模型表示药品用法用量。
 *
 * @author 胡海星
 */
public class Dosage implements Serializable, Assignable<Dosage> {

  private static final long serialVersionUID = 6503164695268202734L;

  /**
   * 使用途径(西药)/用药方法(中药)，字典项。
   */
  @Nullable
  private DictEntryInfo usage;

  /**
   * 中药煎药方法，字典项。
   */
  @Nullable
  private DictEntryInfo decoction;

  /**
   * 中医治法治则。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String therapy;

  /**
   * 单次使用量。
   */
  @Scale(4)
  private BigDecimal amount;

  /**
   * 单次使用量单位。
   */
  @Size(min = 1, max = 64)
  private String unit;

  /**
   * 使用频次，字典条目；中西药分别使用不同的字典。
   */
  private DictEntryInfo frequency;

  /**
   * 持续用药时间。
   */
  private Period duration;

  /**
   * 合计使用量。
   */
  @Scale(4)
  @Nullable
  private BigDecimal totalAmount;

  /**
   * 中药帖数。
   *
   * <p>一般和整个处方的帖数一致，但每个处方项也可以有单独的帖数。
   */
  @Nullable
  private Integer pastes;

  /**
   * 用药注意事项。
   */
  @Nullable
  private String precautions;

  public Dosage() {
    // empty
  }

  public Dosage(final Dosage other) {
    assign(other);
  }

  @Override
  public void assign(final Dosage other) {
    Argument.requireNonNull("other", other);
    usage = Assignment.clone(other.usage);
    decoction = Assignment.clone(other.decoction);
    therapy = other.therapy;
    amount = other.amount;
    unit = other.unit;
    frequency = Assignment.clone(other.frequency);
    duration = other.duration;
    totalAmount = other.totalAmount;
    pastes = other.pastes;
    precautions = other.precautions;
  }

  @Override
  public Dosage clone() {
    return new Dosage(this);
  }

  @Nullable
  public DictEntryInfo getUsage() {
    return usage;
  }

  public void setUsage(@Nullable final DictEntryInfo usage) {
    this.usage = usage;
  }

  @Nullable
  public DictEntryInfo getDecoction() {
    return decoction;
  }

  public void setDecoction(@Nullable final DictEntryInfo decoction) {
    this.decoction = decoction;
  }

  @Nullable
  public String getTherapy() {
    return therapy;
  }

  public void setTherapy(@Nullable final String therapy) {
    this.therapy = therapy;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(final String unit) {
    this.unit = unit;
  }

  public DictEntryInfo getFrequency() {
    return frequency;
  }

  public void setFrequency(final DictEntryInfo frequency) {
    this.frequency = frequency;
  }

  public Period getDuration() {
    return duration;
  }

  public void setDuration(final Period duration) {
    this.duration = duration;
  }

  @Nullable
  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(@Nullable final BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  @Nullable
  public Integer getPastes() {
    return pastes;
  }

  public void setPastes(@Nullable final Integer pastes) {
    this.pastes = pastes;
  }

  @Nullable
  public String getPrecautions() {
    return precautions;
  }

  public void setPrecautions(@Nullable final String precautions) {
    this.precautions = precautions;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Dosage other = (Dosage) o;
    return Equality.equals(usage, other.usage)
        && Equality.equals(decoction, other.decoction)
        && Equality.equals(therapy, other.therapy)
        && Equality.equals(amount, other.amount)
        && Equality.equals(unit, other.unit)
        && Equality.equals(frequency, other.frequency)
        && Equality.equals(duration, other.duration)
        && Equality.equals(totalAmount, other.totalAmount)
        && Equality.equals(pastes, other.pastes)
        && Equality.equals(precautions, other.precautions);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, usage);
    result = Hash.combine(result, multiplier, decoction);
    result = Hash.combine(result, multiplier, therapy);
    result = Hash.combine(result, multiplier, amount);
    result = Hash.combine(result, multiplier, unit);
    result = Hash.combine(result, multiplier, frequency);
    result = Hash.combine(result, multiplier, duration);
    result = Hash.combine(result, multiplier, totalAmount);
    result = Hash.combine(result, multiplier, pastes);
    result = Hash.combine(result, multiplier, precautions);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("usage", usage)
        .append("decoction", decoction)
        .append("therapy", therapy)
        .append("amount", amount)
        .append("unit", unit)
        .append("frequency", frequency)
        .append("duration", duration)
        .append("totalAmount", totalAmount)
        .append("pastes", pastes)
        .append("precautions", precautions)
        .toString();
  }
}
