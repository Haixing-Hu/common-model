////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.person;

import java.time.LocalDate;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Computed;
import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Indexed;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.contact.Contact;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.util.Emptyful;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Normalizable;
import ltd.qubit.model.util.WithBirthday;
import ltd.qubit.model.util.WithName;

/**
 * 此模型表示一个人的基本信息。
 *
 * @author 胡海星
 */
public class PersonInfo implements Identifiable, WithName, WithBirthday,
    Emptyful, Normalizable, Assignable<PersonInfo> {

  private static final long serialVersionUID = -1051312542127306317L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 姓名。
   */
  @Size(min = 1, max = 128)
  @Indexed
  private String name;

  /**
   * 该人所注册的用户的用户名，对应于{@link User}类的{@code username}属性。
   *
   * <p>注意若该人没有在系统中注册，此属性可以为{@code null}
   */
  @Size(min = 1, max = 64)
  @Reference(entity = User.class, property = "username")
  @Nullable
  @Indexed
  private String username;

  /**
   * 性别。
   */
  @Nullable
  private Gender gender;

  /**
   * 出生日期。
   */
  @Nullable
  private LocalDate birthday;

  /**
   * 身份证件。
   */
  @Indexed
  @Nullable
  private CredentialInfo credential;

  /**
   * 手机号码。
   */
  @Indexed
  private Phone mobile;

  /**
   * 电子邮件地址。
   */
  @Indexed
  @Nullable
  private String email;

  public PersonInfo() {
    // empty
  }

  public PersonInfo(final Person person) {
    Argument.requireNonNull("person", person);
    id = person.getId();
    name = person.getName();
    username = person.getUsername();
    gender = person.getGender();
    birthday = person.getBirthday();
    credential = person.getCredential();
    final Contact contact = person.getContact();
    if (contact != null) {
      mobile = contact.getMobile();
      email = contact.getEmail();
    }
  }

  public PersonInfo(final PersonInfo other) {
    assign(other);
  }

  @Override
  public void assign(final PersonInfo other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    name = other.name;
    username = other.username;
    gender = other.gender;
    birthday = other.birthday;
    credential = Assignment.clone(other.credential);
    mobile = Assignment.clone(other.mobile);
    email = other.email;
  }

  @Override
  public PersonInfo clone() {
    return new PersonInfo(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Nullable
  public String getUsername() {
    return username;
  }

  public void setUsername(@Nullable final String username) {
    this.username = username;
  }

  @Nullable
  public Gender getGender() {
    return gender;
  }

  public void setGender(@Nullable final Gender gender) {
    this.gender = gender;
  }

  @Nullable
  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(@Nullable final LocalDate birthday) {
    this.birthday = birthday;
  }

  @Nullable
  public CredentialInfo getCredential() {
    return credential;
  }

  public void setCredential(@Nullable final CredentialInfo credential) {
    this.credential = credential;
  }

  @Nullable
  public Phone getMobile() {
    return mobile;
  }

  public void setMobile(@Nullable final Phone mobile) {
    this.mobile = mobile;
  }

  @Nullable
  public String getEmail() {
    return email;
  }

  public void setEmail(@Nullable final String email) {
    this.email = email;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final PersonInfo other = (PersonInfo) o;
    return Equality.equals(id, other.id)
        && Equality.equals(name, other.name)
        && Equality.equals(username, other.username)
        && Equality.equals(gender, other.gender)
        && Equality.equals(birthday, other.birthday)
        && Equality.equals(credential, other.credential)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(email, other.email);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, username);
    result = Hash.combine(result, multiplier, gender);
    result = Hash.combine(result, multiplier, birthday);
    result = Hash.combine(result, multiplier, credential);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, email);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("name", name)
        .append("username", username)
        .append("gender", gender)
        .append("birthday", birthday)
        .append("credential", credential)
        .append("mobile", mobile)
        .append("email", email)
        .toString();
  }

  @Computed({"id", "name", "username", "gender", "birthday", "credential",
      "mobile", "email", "deleteTime"})
  public final boolean isEmpty() {
    return (id == null)
        && (name == null || name.isEmpty())
        && (username == null || username.isEmpty())
        && (gender == null)
        && (birthday == null)
        && (credential == null || credential.isEmpty())
        && (mobile == null || mobile.isEmpty())
        && (email == null || email.isEmpty());
  }

  // /**
  //  * 检查此对象各字段合法性。
  //  *
  //  * <p>TODO: 改用Validator接口实现
  //  *
  //  * FIXME:
  //  *
  //  * @param constraint
  //  *     指定的约束条件
  //  */
  // public void validateGuardianField(@Nullable final ProductConstraint constraint) {
  //   final Logger logger = LoggerFactory.getLogger(this.getClass());
  //   logger.info("Validating guardian: {}", this);
  //   // 1. 检查姓名
  //   if (StringUtils.isEmpty(name)) {
  //     logger.error("Guardian name cannot be empty.");
  //     throw new NullFieldException(PersonInfo.class, PersonInfo::getName);
  //   }
  //   if (!PersonNameValidationRule.INSTANCE.validate(name)) {
  //     logger.error("Guardian name is invalid: {}", name);
  //     throw new InvalidFieldFormatException(PersonInfo.class,
  //         PersonInfo::getName, name);
  //   }
  //   // 2. 检查证件
  //   if (credential == null) {
  //     logger.error("Guardian credential cannot be empty.");
  //     throw new NullFieldException(PersonInfo.class, PersonInfo::getCredential);
  //   }
  //   if (credential.getType() == CredentialType.IDENTITY_CARD) {
  //     if (! IdentityCardUtils.validate(credential.getNumber())) {
  //       logger.error("The identity card number of the guardian is invalid: {}",
  //           credential.getNumber());
  //       throw new InvalidFieldFormatException(PersonInfo.class,
  //           PersonInfo::getCredential, credential.toString());
  //     }
  //   }
  //   // 3. 检查性别
  //   if (gender == null) {
  //     logger.error("Guardian gender cannot be empty.");
  //     throw new NullFieldException(PersonInfo.class, PersonInfo::getGender);
  //   }
  //   if (credential.getType() == CredentialType.IDENTITY_CARD) {
  //     final Gender expected = IdentityCardUtils.getGender(credential.getNumber());
  //     if (gender != expected) {
  //       logger.error("The gender of the guardian mismatch with his identity card number. "
  //               + "Expected to be {}, but was {}. ID card number = {}", expected,
  //           gender, credential.getNumber());
  //       throw new MismatchGenderException(credential, expected, gender);
  //     }
  //   }
  //   // 4. 检查出生日期
  //   if (birthday == null) {
  //     logger.error("Guardian birthday cannot be empty.");
  //     throw new NullFieldException(PersonInfo.class, PersonInfo::getBirthday);
  //   }
  //   if (credential.getType() == CredentialType.IDENTITY_CARD) {
  //     final LocalDate expected = IdentityCardUtils.getBirthday(credential.getNumber());
  //     if (! birthday.equals(expected)) {
  //       logger.error("The birthday of the guardian mismatch with his identity card. "
  //               + "Expected to be {}, but was {}. ID card number = {}", expected,
  //           birthday, credential.getNumber());
  //       throw new MismatchBirthdayException(credential, expected, birthday);
  //     }
  //   }
  //   // 5. 检查手机号码
  //   if (mobile == null) {
  //     logger.error("Guardian mobile cannot be empty.");
  //     throw new NullFieldException(PersonInfo.class, PersonInfo::getMobile);
  //   }
  //   if (!ChineseMobileValidationRule.INSTANCE.validate(mobile.toString())) {
  //     logger.error("The mobile of the guardian is invalid: {}", mobile.toString());
  //     throw new InvalidFieldFormatException(PersonInfo.class,
  //         PersonInfo::getMobile, mobile.toString());
  //   }
  //   // 6. 检查电子邮件地址，注意电子邮件非必需
  //   if (!StringUtils.isEmpty(email)) {
  //     if (!EmailValidationRule.INSTANCE.validate(email)) {
  //       logger.error("The email of the guardian is invalid: {}", email);
  //       throw new InvalidFieldFormatException(PersonInfo.class,
  //           PersonInfo::getEmail, email);
  //     }
  //   }
  //   // 7. 检查监护人是否是成年人
  //   LocalDate ageEpoch = LocalDate.now();
  //   Integer adultAge = DEFAULT_ADULT_AGE;
  //   if (constraint != null) {
  //     if (constraint.getAgeEpoch() != null) {
  //       ageEpoch = constraint.getAgeEpoch();
  //     }
  //     if (constraint.getAdultAge() != null) {
  //       adultAge = constraint.getAdultAge();
  //     }
  //   }
  //   if (! isAdult(ageEpoch, adultAge)) {
  //     logger.error("The guardian is not adult: {}", this);
  //     throw new InvalidGuardianAgeException(this);
  //   }
  // }
}
