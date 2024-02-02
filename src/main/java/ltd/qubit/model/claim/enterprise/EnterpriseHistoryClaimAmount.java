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
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.DictEntryInfo;
import ltd.qubit.model.util.Creatable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Modifiable;

/**
 * 此模型表示企业出险人历史赔付金额信息。
 *
 * @author 潘凯
 */
public final class EnterpriseHistoryClaimAmount implements Identifiable,
    Creatable, Modifiable, Assignable<EnterpriseHistoryClaimAmount> {

  private static final long serialVersionUID = -2854397640767342370L;

  /**
   * 内部ID，主键全局唯一。
   */
  @Identifier
  private Long id;

  /**
   * 产品 ID，关联表product的id字段。
   */
  private Long productId;

  /**
   * 出险人姓名。
   */
  private String name;

  /**
   * 出险人身份证号。
   */
  private String credentialNumber;

  /**
   * 医疗类别，字典条目。
   */
  private DictEntryInfo medicalCategory;

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

  /**
   * 创建时间，即提交时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  public EnterpriseHistoryClaimAmount() {
    // empty
  }

  public EnterpriseHistoryClaimAmount(final EnterpriseHistoryClaimAmount other) {
    assign(other);
  }

  @Override
  public void assign(final EnterpriseHistoryClaimAmount other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    productId = other.productId;
    name = other.name;
    credentialNumber = other.credentialNumber;
    medicalCategory = Assignment.clone(other.medicalCategory);
    claimBase = other.claimBase;
    deductible = other.deductible;
    overallFundAmount = other.overallFundAmount;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
  }

  @Override
  public EnterpriseHistoryClaimAmount clone() {
    return new EnterpriseHistoryClaimAmount(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(final Long productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getCredentialNumber() {
    return credentialNumber;
  }

  public void setCredentialNumber(final String credentialNumber) {
    this.credentialNumber = credentialNumber;
  }

  public DictEntryInfo getMedicalCategory() {
    return medicalCategory;
  }

  public void setMedicalCategory(final DictEntryInfo medicalCategory) {
    this.medicalCategory = medicalCategory;
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

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final EnterpriseHistoryClaimAmount other = (EnterpriseHistoryClaimAmount) o;
    return Equality.equals(id, other.id)
        && Equality.equals(productId, other.productId)
        && Equality.equals(name, other.name)
        && Equality.equals(credentialNumber, other.credentialNumber)
        && Equality.equals(medicalCategory, other.medicalCategory)
        && Equality.equals(claimBase, other.claimBase)
        && Equality.equals(deductible, other.deductible)
        && Equality.equals(overallFundAmount, other.overallFundAmount)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, productId);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, credentialNumber);
    result = Hash.combine(result, multiplier, medicalCategory);
    result = Hash.combine(result, multiplier, claimBase);
    result = Hash.combine(result, multiplier, deductible);
    result = Hash.combine(result, multiplier, overallFundAmount);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("productId", productId)
        .append("name", name)
        .append("credentialNumber", credentialNumber)
        .append("medicalCategory", medicalCategory)
        .append("claimBase", claimBase)
        .append("deductible", deductible)
        .append("overallFundAmount", overallFundAmount)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .toString();
  }
}
