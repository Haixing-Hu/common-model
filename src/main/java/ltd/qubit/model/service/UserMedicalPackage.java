////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.service;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.person.User;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示用户医疗服务包。
 *
 * @author 王佳，胡海星
 */
public class UserMedicalPackage implements Identifiable,
    Assignable<UserMedicalPackage> {

  private static final long serialVersionUID = -5366849744265006632L;

  /**
   * 唯一标识。
   */
  @Identifier
  private Long id;

  /**
   * 所属用户ID，对应于 {@link User} 类的 id 属性。
   */
  @Reference(entity = User.class, property = "id")
  private Long userId;

  /**
   * 所属{@link MedicalPackage}对象的ID。
   */
  @Reference(entity = MedicalPackage.class, property = "id")
  private Long medicalPackageId;

  /**
   *  服务项目列表。
   */
  @Nullable
  private List<UserMedicalItem> userMedicalItems;

  /**
   * 服务有效期开始时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant validFrom;

  /**
   * 服务有效期结束时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant validUntil;

  public UserMedicalPackage() {
    // empty
  }

  public UserMedicalPackage(final UserMedicalPackage other) {
    assign(other);
  }

  @Override
  public void assign(final UserMedicalPackage other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    userId = other.userId;
    medicalPackageId = other.medicalPackageId;
    userMedicalItems = Assignment.deepClone(other.userMedicalItems);
    validFrom = other.validFrom;
    validUntil = other.validUntil;
  }

  @Override
  public UserMedicalPackage clone() {
    return new UserMedicalPackage(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public Long getMedicalPackageId() {
    return medicalPackageId;
  }

  public void setMedicalPackageId(final Long medicalPackageId) {
    this.medicalPackageId = medicalPackageId;
  }

  @Nullable
  public List<UserMedicalItem> getUserMedicalItems() {
    return userMedicalItems;
  }

  public void setUserMedicalItems(@Nullable final List<UserMedicalItem> userMedicalItems) {
    this.userMedicalItems = userMedicalItems;
  }

  public Instant getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(final Instant validFrom) {
    this.validFrom = validFrom;
  }

  public Instant getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(final Instant validUntil) {
    this.validUntil = validUntil;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final UserMedicalPackage other = (UserMedicalPackage) o;
    return Equality.equals(id, other.id)
        && Equality.equals(userId, other.userId)
        && Equality.equals(medicalPackageId, other.medicalPackageId)
        && Equality.equals(userMedicalItems, other.userMedicalItems)
        && Equality.equals(validFrom, other.validFrom)
        && Equality.equals(validUntil, other.validUntil);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, userId);
    result = Hash.combine(result, multiplier, medicalPackageId);
    result = Hash.combine(result, multiplier, userMedicalItems);
    result = Hash.combine(result, multiplier, validFrom);
    result = Hash.combine(result, multiplier, validUntil);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("userId", userId)
        .append("medicalPackageId", medicalPackageId)
        .append("userMedicalItems", userMedicalItems)
        .append("validFrom", validFrom)
        .append("validUntil", validUntil)
        .toString();
  }
}
