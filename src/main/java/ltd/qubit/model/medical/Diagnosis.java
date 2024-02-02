////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.Entity;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示基本诊断。
 *
 * @author 胡海星
 */
public class Diagnosis implements Identifiable, Assignable<Diagnosis> {

  private static final long serialVersionUID = -5038120497879007114L;

  /**
   * 唯一标识，系统自动生成.
   */
  @Identifier
  private Long id;

  /**
   * 所属对象类型。
   */
  private Entity ownerType;

  /**
   * 所属对象ID.
   */
  private Long ownerId;

  /**
   * 西医诊断出的疾病，依据 ICD-10 / ICD-11.
   */
  @Nullable
  private Info disease;

  /**
   * 中医诊断出的疾病，依据 GB/T 15657-1995.
   */
  @Nullable
  private Info tcmDisease;

  /**
   * 症状（西医）、证型（中医）。按照规定中医处方必须填写证型。
   */
  @Nullable
  private String syndrome;

  /**
   * 描述.
   */
  @Nullable
  private String description;

  /**
   * 备注.
   */
  @Nullable
  private String comment;

  /**
   * 诊断的优先级：主要诊断优先级为0，次要诊断为1，再次要诊断为2，依此类推.
   */
  private Integer priority;

  public Diagnosis() {
    // empty
  }

  public Diagnosis(final Diagnosis other) {
    assign(other);
  }

  @Override
  public void assign(final Diagnosis other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    ownerType = other.ownerType;
    ownerId = other.ownerId;
    disease = Assignment.clone(other.disease);
    tcmDisease = Assignment.clone(other.tcmDisease);
    syndrome = other.syndrome;
    description = other.description;
    comment = other.comment;
    priority = other.priority;
  }

  @Override
  public Diagnosis clone() {
    return new Diagnosis(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Entity getOwnerType() {
    return ownerType;
  }

  public void setOwnerType(final Entity ownerType) {
    this.ownerType = ownerType;
  }

  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(final Long ownerId) {
    this.ownerId = ownerId;
  }

  @Nullable
  public Info getDisease() {
    return disease;
  }

  public void setDisease(@Nullable final Info disease) {
    this.disease = disease;
  }

  @Nullable
  public Info getTcmDisease() {
    return tcmDisease;
  }

  public void setTcmDisease(@Nullable final Info tcmDisease) {
    this.tcmDisease = tcmDisease;
  }

  @Nullable
  public String getSyndrome() {
    return syndrome;
  }

  public void setSyndrome(@Nullable final String syndrome) {
    this.syndrome = syndrome;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  @Nullable
  public String getComment() {
    return comment;
  }

  public void setComment(@Nullable final String comment) {
    this.comment = comment;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(final Integer priority) {
    this.priority = priority;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Diagnosis other = (Diagnosis) o;
    return Equality.equals(id, other.id)
            && Equality.equals(ownerType, other.ownerType)
            && Equality.equals(ownerId, other.ownerId)
            && Equality.equals(disease, other.disease)
            && Equality.equals(tcmDisease, other.tcmDisease)
            && Equality.equals(syndrome, other.syndrome)
            && Equality.equals(description, other.description)
            && Equality.equals(comment, other.comment)
            && Equality.equals(priority, other.priority);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, ownerType);
    result = Hash.combine(result, multiplier, ownerId);
    result = Hash.combine(result, multiplier, disease);
    result = Hash.combine(result, multiplier, tcmDisease);
    result = Hash.combine(result, multiplier, syndrome);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, comment);
    result = Hash.combine(result, multiplier, priority);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("ownerType", ownerType)
            .append("ownerId", ownerId)
            .append("disease", disease)
            .append("tcmDisease", tcmDisease)
            .append("syndrome", syndrome)
            .append("description", description)
            .append("comment", comment)
            .append("priority", priority)
            .toString();
  }
}
