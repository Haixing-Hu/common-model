////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.time.Instant;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.commons.State;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.person.Gender;
import ltd.qubit.model.person.Person;
import ltd.qubit.model.person.PersonInfo;
import ltd.qubit.model.person.User;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.HasInfo;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.Stateful;

/**
 * 此模型表示患者。
 *
 * @author 胡海星
 */
public class Patient implements HasInfo, Stateful, Auditable,
    Assignable<Patient> {

  private static final long serialVersionUID = 7705195419966560217L;

  /**
   * 患者在系统中的ID，唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 患者所属用户ID，对应于 {@link User} 类的 id 属性。
   *
   * <p>注意若该患者没有在系统中注册，此属性可以为{@code null}。
   */
  @Nullable
  private Long userId;

  /**
   * 患者个人档案ID，对应于 {@link Person} 类的 id 属性。
   *
   * <p>注意若该患者在系统中没有完整的个人档案，此属性可以为{@code null}。
   */
  @Nullable
  private Long personId;

  /**
   * 患者所属医院的基本信息。
   */
  private Info hospital;

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
  @Nullable
  private CredentialInfo credential;

  /**
   * 患者手机号码。
   */
  private Phone mobile;

  /**
   * 患者电子邮件地址。
   */
  @Nullable
  private String email;

  /**
   * 患者监护人信息。
   *
   * <p>未满18周岁未成年人有时购药可能需要提供监护人信息，监护人本身必须年满18周岁
   */
  @Nullable
  private PersonInfo guardian;

  /**
   * 是否有医保。
   */
  @Nullable
  private Boolean hasMedicare;

  /**
   * 医保卡。
   */
  @Nullable
  private CredentialInfo medicareCard;

  /**
   * 医保所在城市。
   */
  @Nullable
  private Info medicareCity;

  /**
   * 备注。
   */
  @Nullable
  private String comment;

  /**
   * 状态。
   */
  private State state;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public Patient() {
    // empty
  }

  public Patient(final Patient other) {
    assign(other);
  }

  @Override
  public void assign(final Patient other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    userId = other.userId;
    personId = other.personId;
    hospital = Assignment.clone(other.hospital);
    code = other.code;
    internalCode = other.internalCode;
    name = other.name;
    gender = other.gender;
    birthday = other.birthday;
    credential = Assignment.clone(other.credential);
    mobile = Assignment.clone(other.mobile);
    email = other.email;
    guardian = Assignment.clone(other.guardian);
    hasMedicare = other.hasMedicare;
    medicareCard = Assignment.clone(other.medicareCard);
    medicareCity = Assignment.clone(other.medicareCity);
    comment = other.comment;
    state = other.state;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Patient clone() {
    return new Patient(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  @Nullable
  public Long getUserId() {
    return userId;
  }

  public void setUserId(@Nullable final Long userId) {
    this.userId = userId;
  }

  @Nullable
  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(@Nullable final Long personId) {
    this.personId = personId;
  }

  public Info getHospital() {
    return hospital;
  }

  public void setHospital(final Info hospital) {
    this.hospital = hospital;
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

  @Nullable
  public CredentialInfo getCredential() {
    return credential;
  }

  public void setCredential(@Nullable final CredentialInfo credential) {
    this.credential = credential;
  }

  public Phone getMobile() {
    return mobile;
  }

  public void setMobile(final Phone mobile) {
    this.mobile = mobile;
  }

  @Nullable
  public String getEmail() {
    return email;
  }

  public void setEmail(@Nullable final String email) {
    this.email = email;
  }

  @Nullable
  public PersonInfo getGuardian() {
    return guardian;
  }

  public void setGuardian(@Nullable final PersonInfo guardian) {
    this.guardian = guardian;
  }

  @Nullable
  public Boolean isHasMedicare() {
    return hasMedicare;
  }

  public void setHasMedicare(@Nullable final Boolean hasMedicare) {
    this.hasMedicare = hasMedicare;
  }

  @Nullable
  public CredentialInfo getMedicareCard() {
    return medicareCard;
  }

  public void setMedicareCard(@Nullable final CredentialInfo medicareCard) {
    this.medicareCard = medicareCard;
  }

  @Nullable
  public Info getMedicareCity() {
    return medicareCity;
  }

  public void setMedicareCity(@Nullable final Info medicareCity) {
    this.medicareCity = medicareCity;
  }

  @Nullable
  public String getComment() {
    return comment;
  }

  public void setComment(@Nullable final String comment) {
    this.comment = comment;
  }

  public State getState() {
    return state;
  }

  public void setState(final State state) {
    this.state = state;
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

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Patient other = (Patient) o;
    return Equality.equals(id, other.id)
        && Equality.equals(userId, other.userId)
        && Equality.equals(personId, other.personId)
        && Equality.equals(hospital, other.hospital)
        && Equality.equals(code, other.code)
        && Equality.equals(internalCode, other.internalCode)
        && Equality.equals(name, other.name)
        && Equality.equals(gender, other.gender)
        && Equality.equals(birthday, other.birthday)
        && Equality.equals(credential, other.credential)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(email, other.email)
        && Equality.equals(guardian, other.guardian)
        && Equality.equals(hasMedicare, other.hasMedicare)
        && Equality.equals(medicareCard, other.medicareCard)
        && Equality.equals(medicareCity, other.medicareCity)
        && Equality.equals(comment, other.comment)
        && Equality.equals(state, other.state)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, userId);
    result = Hash.combine(result, multiplier, personId);
    result = Hash.combine(result, multiplier, hospital);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, internalCode);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, gender);
    result = Hash.combine(result, multiplier, birthday);
    result = Hash.combine(result, multiplier, credential);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, email);
    result = Hash.combine(result, multiplier, guardian);
    result = Hash.combine(result, multiplier, hasMedicare);
    result = Hash.combine(result, multiplier, medicareCard);
    result = Hash.combine(result, multiplier, medicareCity);
    result = Hash.combine(result, multiplier, comment);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("userId", userId)
        .append("personId", personId)
        .append("hospital", hospital)
        .append("code", code)
        .append("internalCode", internalCode)
        .append("name", name)
        .append("gender", gender)
        .append("birthday", birthday)
        .append("credential", credential)
        .append("mobile", mobile)
        .append("email", email)
        .append("guardian", guardian)
        .append("hasMedicare", hasMedicare)
        .append("medicareCard", medicareCard)
        .append("medicareCity", medicareCity)
        .append("comment", comment)
        .append("state", state)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
