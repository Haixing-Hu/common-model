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
 * 此模型表示企业保险理赔分单关联的就诊记录。
 *
 * @author 潘凯
 */
public class EnterpriseClaimItemMedical implements Identifiable, Creatable, Assignable<EnterpriseClaimItemMedical> {

  private static final long serialVersionUID = -2890401200030120054L;

  /**
   * 内部ID，主键全局唯一。
   */
  @Identifier
  private Long id;

  /**
   * 理赔申请分单ID，关联表enterprise_claim_item的id字段。
   */
  private Long claimItemId;

  /**
   * 理赔就诊记录ID，关联表enterprise_claim_medical的id字段。
   */
  private Long claimMedicalId;

  /**
   * 创建时间，即提交时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  public EnterpriseClaimItemMedical() {
    // empty
  }

  public EnterpriseClaimItemMedical(final EnterpriseClaimItemMedical other) {
    assign(other);
  }

  @Override
  public void assign(final EnterpriseClaimItemMedical other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    claimItemId = other.claimItemId;
    claimMedicalId = other.claimMedicalId;
    createTime = other.createTime;
  }

  @Override
  public EnterpriseClaimItemMedical clone() {
    return new EnterpriseClaimItemMedical(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getClaimItemId() {
    return claimItemId;
  }

  public void setClaimItemId(final Long claimItemId) {
    this.claimItemId = claimItemId;
  }

  public Long getClaimMedicalId() {
    return claimMedicalId;
  }

  public void setClaimMedicalId(final Long claimMedicalId) {
    this.claimMedicalId = claimMedicalId;
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
    final EnterpriseClaimItemMedical other = (EnterpriseClaimItemMedical) o;
    return Equality.equals(id, other.id)
        && Equality.equals(claimItemId, other.claimItemId)
        && Equality.equals(claimMedicalId, other.claimMedicalId)
        && Equality.equals(createTime, other.createTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, claimItemId);
    result = Hash.combine(result, multiplier, claimMedicalId);
    result = Hash.combine(result, multiplier, createTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("claimItemId", claimItemId)
        .append("claimMedicalId", claimMedicalId)
        .append("createTime", createTime)
        .toString();
  }
}
