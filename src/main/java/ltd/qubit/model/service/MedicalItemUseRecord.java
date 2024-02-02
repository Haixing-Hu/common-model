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
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.organization.EmployeeInfo;
import ltd.qubit.model.person.PersonInfo;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模式表示医疗服务项目使用记录。
 *
 * @author 王佳，胡海星
 */
public class MedicalItemUseRecord implements Identifiable,
    Assignable<MedicalItemUseRecord> {

  private static final long serialVersionUID = -5192377125268912169L;

  /**
   * 唯一标识。
   */
  @Identifier
  private Long id;

  /**
   * 所属{@link MedicalPackage}对象。
   */
  private MedicalPackage medicalPackage;

  /**
   * 所属{@link MedicalItem}对象。
   */
  private MedicalItem medicalItem;

  /**
   * 所属{@link UserMedicalItem}对象ID。
   */
  private Long userMedicalItemId;

  /**
   * 患者信息。
   */
  private PersonInfo patient;

  /**
   * 医生信息。
   */
  private EmployeeInfo doctor;

  public MedicalItemUseRecord() {
    // empty
  }

  public MedicalItemUseRecord(final MedicalItemUseRecord other) {
    assign(other);
  }

  @Override
  public void assign(final MedicalItemUseRecord other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    medicalPackage = Assignment.clone(other.medicalPackage);
    medicalItem = Assignment.clone(other.medicalItem);
    userMedicalItemId = other.userMedicalItemId;
    patient = Assignment.clone(other.patient);
    doctor = Assignment.clone(other.doctor);
  }

  @Override
  public MedicalItemUseRecord clone() {
    return new MedicalItemUseRecord(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public MedicalPackage getMedicalPackage() {
    return medicalPackage;
  }

  public void setMedicalPackage(final MedicalPackage medicalPackage) {
    this.medicalPackage = medicalPackage;
  }

  public MedicalItem getMedicalItem() {
    return medicalItem;
  }

  public void setMedicalItem(final MedicalItem medicalItem) {
    this.medicalItem = medicalItem;
  }

  public Long getUserMedicalItemId() {
    return userMedicalItemId;
  }

  public void setUserMedicalItemId(final Long userMedicalItemId) {
    this.userMedicalItemId = userMedicalItemId;
  }

  public PersonInfo getPatient() {
    return patient;
  }

  public void setPatient(final PersonInfo patient) {
    this.patient = patient;
  }

  public EmployeeInfo getDoctor() {
    return doctor;
  }

  public void setDoctor(final EmployeeInfo doctor) {
    this.doctor = doctor;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final MedicalItemUseRecord other = (MedicalItemUseRecord) o;
    return Equality.equals(id, other.id)
        && Equality.equals(medicalPackage, other.medicalPackage)
        && Equality.equals(medicalItem, other.medicalItem)
        && Equality.equals(userMedicalItemId, other.userMedicalItemId)
        && Equality.equals(patient, other.patient)
        && Equality.equals(doctor, other.doctor);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, medicalPackage);
    result = Hash.combine(result, multiplier, medicalItem);
    result = Hash.combine(result, multiplier, userMedicalItemId);
    result = Hash.combine(result, multiplier, patient);
    result = Hash.combine(result, multiplier, doctor);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("medicalPackage", medicalPackage)
        .append("medicalItem", medicalItem)
        .append("userMedicalItemId", userMedicalItemId)
        .append("patient", patient)
        .append("doctor", doctor)
        .toString();
  }
}
