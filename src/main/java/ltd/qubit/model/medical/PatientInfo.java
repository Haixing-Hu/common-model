////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.time.LocalDate;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.person.Gender;
import ltd.qubit.model.util.HasInfo;

/**
 * 此模型表示患者基本信息。
 *
 * @author 胡海星
 */
public class PatientInfo implements HasInfo, Assignable<PatientInfo> {

  private static final long serialVersionUID = -1109796344522321433L;

  /**
   * 患者在系统中的ID，唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 患者编号，全局唯一；可以用所属医院编号+患者院内编号组合成。
   */
  @Size(min = 1, max = 64)
  @Unique
  private String code;

  /**
   * 患者在所属医院中的编号。
   */
  @Size(min = 1, max = 64)
  private String internalCode;

  /**
   * 患者真实姓名。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 患者性别。
   */
  private Gender gender;

  /**
   * 患者出生日期。
   */
  private LocalDate birthday;

  /**
   * 患者实名认证证件。
   */
  private CredentialInfo credential;

  /**
   * 患者手机号码。
   */
  private Phone mobile;

  public static PatientInfo create(
          @Nullable final Long id,
          @Nullable final String code,
          @Nullable final String internalCode,
          @Nullable final String name,
          @Nullable final Gender gender,
          @Nullable final LocalDate birthday,
          @Nullable final CredentialInfo credential,
          @Nullable final Phone mobile) {
    if (id == null
            && code == null
            && internalCode == null
            && name == null
            && gender == null
            && birthday == null
            && credential == null
            && mobile == null) {
      return null;
    }
    final PatientInfo result = new PatientInfo();
    result.id = id;
    result.code = code;
    result.internalCode = internalCode;
    result.name = name;
    result.gender = gender;
    result.birthday = birthday;
    result.credential = credential;
    result.mobile = mobile;
    return result;
  }

  public PatientInfo() {
    // empty
  }

  public PatientInfo(final PatientInfo other) {
    assign(other);
  }

  public PatientInfo(final Patient patient) {
    assign(patient);
  }

  @Override
  public void assign(final PatientInfo other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    internalCode = other.internalCode;
    name = other.name;
    gender = other.gender;
    birthday = other.birthday;
    credential = Assignment.clone(other.credential);
    mobile = Assignment.clone(other.mobile);
  }

  public void assign(final Patient patient) {
    this.id = patient.getId();
    this.code = patient.getCode();
    this.internalCode = patient.getInternalCode();
    this.name = patient.getName();
    this.gender = patient.getGender();
    this.birthday = patient.getBirthday();
    this.credential = patient.getCredential();
    this.mobile = patient.getMobile();
  }

  @Override
  public PatientInfo clone() {
    return new PatientInfo(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  public String getInternalCode() {
    return internalCode;
  }

  public void setInternalCode(final String internalCode) {
    this.internalCode = internalCode;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(final Gender gender) {
    this.gender = gender;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(final LocalDate birthday) {
    this.birthday = birthday;
  }

  public CredentialInfo getCredential() {
    return credential;
  }

  public void setCredential(final CredentialInfo credential) {
    this.credential = credential;
  }

  public Phone getMobile() {
    return mobile;
  }

  public void setMobile(final Phone mobile) {
    this.mobile = mobile;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final PatientInfo other = (PatientInfo) o;
    return Equality.equals(id, other.id)
        && Equality.equals(code, other.code)
        && Equality.equals(internalCode, other.internalCode)
        && Equality.equals(name, other.name)
        && Equality.equals(gender, other.gender)
        && Equality.equals(birthday, other.birthday)
        && Equality.equals(credential, other.credential)
        && Equality.equals(mobile, other.mobile);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, internalCode);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, gender);
    result = Hash.combine(result, multiplier, birthday);
    result = Hash.combine(result, multiplier, credential);
    result = Hash.combine(result, multiplier, mobile);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("code", code)
        .append("internalCode", internalCode)
        .append("name", name)
        .append("gender", gender)
        .append("birthday", birthday)
        .append("credential", credential)
        .append("mobile", mobile)
        .toString();
  }
}
