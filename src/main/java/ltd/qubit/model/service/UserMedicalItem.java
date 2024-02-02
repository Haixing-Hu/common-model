////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.service;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示用户医疗服务项目。
 *
 * @author pino
 */
public class UserMedicalItem implements Identifiable,
    Assignable<UserMedicalItem> {

  private static final long serialVersionUID = -6568556191053355870L;

  /**
   * 唯一标识。
   */
  @Identifier
  private Long id;

  /**
   * 所属{@link MedicalItem}对象的ID。
   */
  @Reference(entity = MedicalItem.class, property = "id")
  private Long medicalItemId;

  /**
   *  服务数量。
   */
  private Integer count;

  /**
   * 服务状态。
   */
  private UserServiceState state;

  public UserMedicalItem() {
    // empty
  }

  public UserMedicalItem(final UserMedicalItem other) {
    assign(other);
  }

  @Override
  public void assign(final UserMedicalItem other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    medicalItemId = other.medicalItemId;
    count = other.count;
    state = other.state;
  }

  @Override
  public UserMedicalItem clone() {
    return new UserMedicalItem(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getMedicalItemId() {
    return medicalItemId;
  }

  public void setMedicalItemId(final Long medicalItemId) {
    this.medicalItemId = medicalItemId;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(final Integer count) {
    this.count = count;
  }

  public UserServiceState getState() {
    return state;
  }

  public void setState(final UserServiceState state) {
    this.state = state;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final UserMedicalItem other = (UserMedicalItem) o;
    return Equality.equals(id, other.id)
        && Equality.equals(medicalItemId, other.medicalItemId)
        && Equality.equals(count, other.count)
        && Equality.equals(state, other.state);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, medicalItemId);
    result = Hash.combine(result, multiplier, count);
    result = Hash.combine(result, multiplier, state);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("medicalItemId", medicalItemId)
        .append("count", count)
        .append("state", state)
        .toString();
  }
}
