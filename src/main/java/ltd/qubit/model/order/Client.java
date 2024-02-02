////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import java.time.LocalDate;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Computed;
import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.pair.KeyValuePairList;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.commons.KinshipType;
import ltd.qubit.model.contact.Contact;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.medical.MedicareType;
import ltd.qubit.model.person.Gender;
import ltd.qubit.model.person.Person;
import ltd.qubit.model.person.PersonInfo;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.WithBirthday;
import ltd.qubit.model.util.WithCredential;
import ltd.qubit.model.util.WithName;

import static ltd.qubit.commons.lang.BooleanUtils.isTrue;

/**
 * 此模型表示产品或服务关联的使用者信息。
 *
 * @author 胡海星
 */
public class Client implements Identifiable, WithName, WithBirthday,
    WithCredential, Assignable<Client> {

  private static final long serialVersionUID = 6773654884554152302L;

  /**
   * 个人档案ID，对应于 {@link Person} 类的 id 属性。
   */
  @Identifier
  private Long id;

  /**
   * 真实姓名。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 身份证件。
   */
  private CredentialInfo credential;

  /**
   * 性别。
   */
  private Gender gender;

  /**
   * 出生日期。
   */
  private LocalDate birthday;

  /**
   * 手机号码。
   */
  private Phone mobile;

  /**
   * 电子邮件地址。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String email;

  /**
   * 是否有医保。
   */
  @Nullable
  private Boolean hasMedicare;

  /**
   * 医保类别。
   */
  @Nullable
  private MedicareType medicareType;

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
   * 是否有社保。
   */
  @Nullable
  private Boolean hasSocialSecurity;

  /**
   * 社保卡。
   */
  @Nullable
  private CredentialInfo socialSecurityCard;

  /**
   * 社保所在城市。
   */
  @Nullable
  private Info socialSecurityCity;

  /**
   * 监护人信息。
   *
   * <p>未满18周岁未成年人可以有监护人，监护人本身必须年满18周岁。
   */
  @Nullable
  private PersonInfo guardian;

  /**
   * 退货状态。
   */
  @Nullable
  private ReturnStatus returnStatus;

  /**
   * 亲属关系。
   */
  @Nullable
  private KinshipType kinship;

  /**
   * 额外参数。
   */
  @Nullable
  private KeyValuePairList payload;

  public Client() {
    // empty
  }

  public Client(final Client other) {
    assign(other);
  }

  public Client(final Person person) {
    assign(person);
  }

  @Override
  public void assign(final Client other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    name = other.name;
    credential = Assignment.clone(other.credential);
    gender = other.gender;
    birthday = other.birthday;
    mobile = Assignment.clone(other.mobile);
    email = other.email;
    hasMedicare = other.hasMedicare;
    medicareType = other.medicareType;
    medicareCard = Assignment.clone(other.medicareCard);
    medicareCity = Assignment.clone(other.medicareCity);
    hasSocialSecurity = other.hasSocialSecurity;
    socialSecurityCard = Assignment.clone(other.socialSecurityCard);
    socialSecurityCity = Assignment.clone(other.socialSecurityCity);
    guardian = Assignment.clone(other.guardian);
    returnStatus = other.returnStatus;
    kinship = other.kinship;
    payload = Assignment.clone(other.payload);
  }

  public void assign(final Person person) {
    Argument.requireNonNull("person", person);
    this.id = person.getId();
    this.name = person.getName();
    this.credential = Assignment.clone(person.getCredential());
    this.gender = person.getGender();
    this.birthday = person.getBirthday();
    if (person.getContact() != null) {
      final Contact contact = person.getContact();
      this.mobile = Assignment.clone(contact.getMobile());
      this.email = contact.getEmail();
    }
    this.guardian = Assignment.clone(person.getGuardian());
    this.hasMedicare = person.isHasMedicare();
    this.medicareCard = Assignment.clone(person.getMedicareCard());
    this.medicareCity = Assignment.clone(person.getMedicareCity());
    this.hasSocialSecurity = person.isHasSocialSecurity();
    this.medicareType = person.getMedicareType();
    this.socialSecurityCard = Assignment.clone(person.getSocialSecurityCard());
    this.socialSecurityCity = Assignment.clone(person.getSocialSecurityCity());
  }

  @Override
  public Client clone() {
    return new Client(this);
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

  public CredentialInfo getCredential() {
    return credential;
  }

  public void setCredential(final CredentialInfo credential) {
    this.credential = credential;
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
  public Boolean isHasMedicare() {
    return hasMedicare;
  }

  public void setHasMedicare(@Nullable final Boolean hasMedicare) {
    this.hasMedicare = hasMedicare;
  }

  @Nullable
  public MedicareType getMedicareType() {
    return medicareType;
  }

  public void setMedicareType(@Nullable final MedicareType medicareType) {
    this.medicareType = medicareType;
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
  public Boolean isHasSocialSecurity() {
    return hasSocialSecurity;
  }

  public void setHasSocialSecurity(@Nullable final Boolean hasSocialSecurity) {
    this.hasSocialSecurity = hasSocialSecurity;
  }

  @Computed({"hasMedicare", "hasSocialSecurity"})
  public Boolean isHasMedicareOrSocialSecurity() {
    return isTrue(hasMedicare) || isTrue(hasSocialSecurity);
  }

  @Nullable
  public CredentialInfo getSocialSecurityCard() {
    return socialSecurityCard;
  }

  public void setSocialSecurityCard(@Nullable final CredentialInfo socialSecurityCard) {
    this.socialSecurityCard = socialSecurityCard;
  }

  @Nullable
  public Info getSocialSecurityCity() {
    return socialSecurityCity;
  }

  public void setSocialSecurityCity(@Nullable final Info socialSecurityCity) {
    this.socialSecurityCity = socialSecurityCity;
  }

  @Nullable
  public PersonInfo getGuardian() {
    return guardian;
  }

  public void setGuardian(@Nullable final PersonInfo guardian) {
    this.guardian = guardian;
  }

  @Nullable
  public ReturnStatus getReturnStatus() {
    return returnStatus;
  }

  public void setReturnStatus(@Nullable final ReturnStatus returnStatus) {
    this.returnStatus = returnStatus;
  }

  @Nullable
  public KinshipType getKinship() {
    return kinship;
  }

  public void setKinship(@Nullable final KinshipType kinship) {
    this.kinship = kinship;
  }

  @Nullable
  public KeyValuePairList getPayload() {
    return payload;
  }

  public void setPayload(@Nullable final KeyValuePairList payload) {
    this.payload = payload;
  }
  //
  // /**
  //  * 检查此对象各字段合法性。
  //  *
  //  * <p>TODO: 改用Validator接口实现
  //  *
  //  * @param constraint
  //  *     指定的约束条件
  //  */
  // public void checkField(@Nullable final ProductConstraint constraint) {
  //   final Logger logger = LoggerFactory.getLogger(this.getClass());
  //   logger.info("Validating client: {}", this);
  //   // 1. 检查基本信息
  //   checkBaseField();
  //   // 2. 检查性别
  //   if (gender == null) {
  //     logger.error("Client gender cannot be empty.");
  //     throw new NullFieldException(Client.class, Client::getGender);
  //   }
  //   if (credential.getType() == CredentialType.IDENTITY_CARD) {
  //     final Gender expected = IdentityCardUtils.getGender(credential.getNumber());
  //     if (gender != expected) {
  //       logger.error("The gender of the client mismatch with his identity card number. "
  //               + "Expected to be {}, but was {}. ID card number = {}", expected,
  //           gender, credential.getNumber());
  //       throw new MismatchGenderException(credential, expected, gender);
  //     }
  //   }
  //   // 3. 检查出生日期
  //   if (birthday == null) {
  //     logger.error("Client birthday cannot be empty.");
  //     throw new NullFieldException(Client.class, Client::getBirthday);
  //   }
  //   if (credential.getType() == CredentialType.IDENTITY_CARD) {
  //     final LocalDate expected = IdentityCardUtils.getBirthday(credential.getNumber());
  //     if (! birthday.equals(expected)) {
  //       logger.error("The birthday of the client mismatch with his identity card. "
  //               + "Expected to be {}, but was {}. ID card number = {}", expected,
  //           birthday, credential.getNumber());
  //       throw new MismatchBirthdayException(credential, expected, birthday);
  //     }
  //   }
  //   // 4. 检查对于未成年人是否需要监护人信息
  //   if (constraint != null
  //       && constraint.getClient() != null
  //       && isTrue(constraint.getClient().isNeedGuardian())) {
  //     if (! isAdult(constraint.getAgeEpoch(), constraint.getAdultAge())) {
  //       if (guardian == null) {
  //         logger.error("The non-adult client has no guardian: {}", this);
  //         throw new NullFieldException(Client.class, Client::getGuardian);
  //       }
  //     }
  //   }
  //   // 5. 检查可能存在的监护人信息
  //   if (guardian != null) {
  //     guardian.validateGuardianField(constraint);
  //   }
  // }
  //
  // /**
  //  * 检查此对象各基本信息字段合法性。
  //  *
  //  * <p>TODO: 改用Validator接口实现
  //  */
  // public void checkBaseField() {
  //   // 1. 检查姓名
  //   if (isEmpty(name)) {
  //     throw new NullFieldException(Client.class, Client::getName);
  //   }
  //   if (!PersonNameValidationRule.INSTANCE.validate(name)) {
  //     throw new InvalidFieldFormatException(Client.class,
  //         Client::getName, name);
  //   }
  //   // 2. 检查证件
  //   if (credential == null) {
  //     throw new NullFieldException(Client.class, Client::getCredential);
  //   }
  //   if (credential.getType() == CredentialType.IDENTITY_CARD) {
  //     if (!IdentityCardUtils.validate(credential.getNumber())) {
  //       throw new InvalidFieldFormatException(Client.class,
  //           Client::getCredential, credential.toString());
  //     }
  //   }
  //   // 3. 检查手机号码
  //   if (mobile == null) {
  //     throw new NullFieldException(Client.class, Client::getMobile);
  //   }
  //   if (!ChineseMobileValidationRule.INSTANCE.validate(mobile.toString())) {
  //     throw new InvalidFieldFormatException(Client.class, Client::getMobile, mobile);
  //   }
  //   // 4. 检查电子邮件地址，注意电子邮件非必需
  //   if (!isEmpty(email)) {
  //     if (!EmailValidationRule.INSTANCE.validate(email)) {
  //       throw new InvalidFieldFormatException(Client.class, Client::getEmail, email);
  //     }
  //   }
  // }

  public final <T extends Identifiable & WithCredential>
  boolean isSame(@Nullable final T person) {
    if (person == null) {
      return false;
    } else if (id != null && person.getId() != null) {
      return id.longValue() == person.getId().longValue();
    } else if (credential == null) {
      return false;
    } else {
      return credential.isSame(person.getCredential());
    }
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Client other = (Client) o;
    return Equality.equals(id, other.id)
        && Equality.equals(name, other.name)
        && Equality.equals(credential, other.credential)
        && Equality.equals(gender, other.gender)
        && Equality.equals(birthday, other.birthday)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(email, other.email)
        && Equality.equals(hasMedicare, other.hasMedicare)
        && Equality.equals(medicareType, other.medicareType)
        && Equality.equals(medicareCard, other.medicareCard)
        && Equality.equals(medicareCity, other.medicareCity)
        && Equality.equals(hasSocialSecurity, other.hasSocialSecurity)
        && Equality.equals(socialSecurityCard, other.socialSecurityCard)
        && Equality.equals(socialSecurityCity, other.socialSecurityCity)
        && Equality.equals(guardian, other.guardian)
        && Equality.equals(returnStatus, other.returnStatus)
        && Equality.equals(kinship, other.kinship)
        && Equality.equals(payload, other.payload);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, credential);
    result = Hash.combine(result, multiplier, gender);
    result = Hash.combine(result, multiplier, birthday);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, email);
    result = Hash.combine(result, multiplier, hasMedicare);
    result = Hash.combine(result, multiplier, medicareType);
    result = Hash.combine(result, multiplier, medicareCard);
    result = Hash.combine(result, multiplier, medicareCity);
    result = Hash.combine(result, multiplier, hasSocialSecurity);
    result = Hash.combine(result, multiplier, socialSecurityCard);
    result = Hash.combine(result, multiplier, socialSecurityCity);
    result = Hash.combine(result, multiplier, guardian);
    result = Hash.combine(result, multiplier, returnStatus);
    result = Hash.combine(result, multiplier, kinship);
    result = Hash.combine(result, multiplier, payload);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("name", name)
        .append("credential", credential)
        .append("gender", gender)
        .append("birthday", birthday)
        .append("mobile", mobile)
        .append("email", email)
        .append("hasMedicare", hasMedicare)
        .append("medicareType", medicareType)
        .append("medicareCard", medicareCard)
        .append("medicareCity", medicareCity)
        .append("hasSocialSecurity", hasSocialSecurity)
        .append("socialSecurityCard", socialSecurityCard)
        .append("socialSecurityCity", socialSecurityCity)
        .append("guardian", guardian)
        .append("returnStatus", returnStatus)
        .append("kinship", kinship)
        .append("payload", payload)
        .toString();
  }
}
