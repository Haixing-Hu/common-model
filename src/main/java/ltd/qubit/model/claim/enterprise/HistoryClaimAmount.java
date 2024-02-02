////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim.enterprise;

import java.math.BigDecimal;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 此模型表示历史赔付金额信息。
 *
 * @author 潘凯
 */
public final class HistoryClaimAmount implements
    Assignable<HistoryClaimAmount> {

  private static final long serialVersionUID = 2817436002830383780L;

  /**
   * 赔付基数。
   */
  @Money
  private BigDecimal claimBase = BigDecimal.ZERO;

  /**
   * 起付线。
   */
  @Money
  private BigDecimal deductible = BigDecimal.ZERO;

  /**
   * 统筹基金支出。
   */
  @Money
  private BigDecimal overallFundAmount = BigDecimal.ZERO;

  public HistoryClaimAmount() {
    // empty
  }

  public HistoryClaimAmount(final HistoryClaimAmount other) {
    assign(other);
  }

  @Override
  public void assign(final HistoryClaimAmount other) {
    Argument.requireNonNull("other", other);
    claimBase = other.claimBase;
    deductible = other.deductible;
    overallFundAmount = other.overallFundAmount;
  }

  @Override
  public HistoryClaimAmount clone() {
    return new HistoryClaimAmount(this);
  }

  public BigDecimal getClaimBase() {
    return claimBase;
  }

  public void setClaimBase(final BigDecimal claimBase) {
    this.claimBase = claimBase;
  }

  public BigDecimal getDeductible() {
    return deductible;
  }

  public void setDeductible(final BigDecimal deductible) {
    this.deductible = deductible;
  }

  public BigDecimal getOverallFundAmount() {
    return overallFundAmount;
  }

  public void setOverallFundAmount(final BigDecimal overallFundAmount) {
    this.overallFundAmount = overallFundAmount;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final HistoryClaimAmount other = (HistoryClaimAmount) o;
    return Equality.equals(claimBase, other.claimBase)
        && Equality.equals(deductible, other.deductible)
        && Equality.equals(overallFundAmount, other.overallFundAmount);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, claimBase);
    result = Hash.combine(result, multiplier, deductible);
    result = Hash.combine(result, multiplier, overallFundAmount);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("claimBase", claimBase)
        .append("deductible", deductible)
        .append("overallFundAmount", overallFundAmount)
        .toString();
  }
}
