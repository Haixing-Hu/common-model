////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.product;

import java.io.Serializable;
import java.time.Period;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.person.Gender;

/**
 * 此模型表示对人的限制。
 *
 * @author 胡海星
 */
public class PersonConstraint implements Assignable<PersonConstraint>, Serializable {

  private static final long serialVersionUID = -8133374331042660640L;

  /**
   * 最低年龄要求（包含此年龄），{@code null}表示不作限制。
   */
  @Nullable
  private Period minAge;

  /**
   * 最高年龄要求（包含此年龄），{@code null}表示不作限制。
   */
  @Nullable
  private Period maxAge;

  /**
   * 是否只能是成年人，{@code null}表示不作限制。
   */
  @Nullable
  private Boolean adultOnly;

  /**
   * 性别限制，{@code null}表示不作限制。
   */
  @Nullable
  private Gender gender;

  /**
   * 是否必须有医保，{@code null}表示不作限制。
   */
  @Nullable
  private Boolean hasMedicare;

  /**
   * 是否必须有社保，{@code null}表示不作限制。
   */
  @Nullable
  private Boolean hasSocialSecurity;

  /**
   * 是否必须有医保或社保，{@code null}表示不作限制。
   */
  @Nullable
  private Boolean hasMedicareOrSocialSecurity;

  /**
   * 医保所在城市代码的允许列表，{@code null}表示不作限制。
   */
  @Size(min = 1, max = 16)
  @Nullable
  private String[] medicareCities;

  /**
   * 社保所在城市代码的允许列表，{@code null}表示不作限制。
   */
  @Size(min = 1, max = 16)
  @Nullable
  private String[] socialSecurityCities;

  /**
   * 对于未成年人是否需要提供监护人信息，{@code null}表示不作限制。
   */
  @Nullable
  private Boolean needGuardian;

  public PersonConstraint() {}

  public PersonConstraint(final PersonConstraint other) {
    assign(other);
  }

  @Override
  public void assign(final PersonConstraint other) {
    this.minAge = other.minAge;
    this.maxAge = other.maxAge;
    this.adultOnly = other.adultOnly;
    this.gender = other.gender;
    this.hasMedicare = other.hasMedicare;
    this.hasSocialSecurity = other.hasSocialSecurity;
    this.hasMedicareOrSocialSecurity = other.hasMedicareOrSocialSecurity;
    this.medicareCities = Assignment.clone(other.medicareCities);
    this.socialSecurityCities = Assignment.clone(other.socialSecurityCities);
    this.needGuardian = other.needGuardian;
  }

  @Override
  public PersonConstraint clone() {
    return new PersonConstraint(this);
  }
  //
  // public void check(final Person person, @Nullable final ProductConstraint constraint) {
  //   final Logger logger = LoggerFactory.getLogger(this.getClass());
  //   logger.info("Validating a person again the constraint: person = {}, constraint = {}",
  //           person, this);
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
  //   // 判定年龄是否符合条件
  //   if (minAge != null || maxAge != null) {
  //     if (person.getBirthday() == null) {
  //       logger.error("Person's birthday cannot be empty.");
  //       throw new NullFieldException(Person.class, Person::getBirthday);
  //     }
  //     final Period age = person.getAge(ageEpoch);
  //     if (minAge != null && age.getDays() < minAge.getDays()) {
  //       logger.error("Person's age is less than " + minAge);
  //       throw new FieldValueOutOfRangeException(Person.class, Person::getAge);
  //     }
  //     if (maxAge != null && age.getDays() > maxAge.getDays()) {
  //       logger.error("Person's age is greater than " + maxAge);
  //       throw new FieldValueOutOfRangeException(Person.class, Person::getAge);
  //     }
  //   }
  //   // 判定是否必须是成年人
  //   if (isTrue(adultOnly)) {
  //     if (person.getBirthday() == null) {
  //       logger.error("Person's birthday cannot be empty.");
  //       throw new NullFieldException(Person.class, Person::getBirthday);
  //     }
  //     if (! isTrue(person.isAdult(ageEpoch, adultAge))) {
  //       logger.error("The person must be an adult.");
  //       throw new FieldValueOutOfRangeException(Person.class, Person::getAge);
  //     }
  //   }
  //   // 判定性别是否符合条件
  //   if (gender != null) {
  //     if (person.getGender() != gender) {
  //       logger.error("Person's gender must be " + gender);
  //       throw new FieldValueOutOfRangeException(Person.class, Person::getGender);
  //     }
  //   }
  //   // 判定医保、社保是否符合条件
  //   if (hasMedicare != null) {
  //     if (! Equality.equals(hasMedicare, person.isHasMedicare())) {
  //       logger.error("Person must " + (isTrue(hasMedicare) ? "has" : "has no")
  //               + " medicare.");
  //       throw new FieldValueOutOfRangeException(Person.class, Person::isHasMedicare);
  //     }
  //   }
  //   if (hasSocialSecurity != null) {
  //     if (! Equality.equals(hasSocialSecurity, person.isHasSocialSecurity())) {
  //       logger.error("Person must " + choose(hasSocialSecurity, "has", "has no")
  //               + " social security.");
  //       throw new FieldValueOutOfRangeException(Person.class, Person::isHasSocialSecurity);
  //     }
  //   }
  //   if (hasMedicareOrSocialSecurity != null) {
  //     final Boolean actual = or(person.isHasMedicare(), person.isHasSocialSecurity());
  //     if (! Equality.equals(hasMedicareOrSocialSecurity, actual)) {
  //       logger.error("Person must " + choose(hasSocialSecurity, "has", "has no")
  //               + " medicare " + choose(hasSocialSecurity, "or", "nor")
  //               + " social security.");
  //       throw new FieldValueOutOfRangeException(Person.class,
  //           Person::isHasMedicareOrSocialSecurity);
  //     }
  //   }
  //   // 判定医保所在城市是否符合条件
  //   if (medicareCities != null && medicareCities.length > 0) {
  //     final Info city = person.getMedicareCity();
  //     if (city == null || city.getCode() == null) {
  //       logger.error("Person's medicare city cannot be empty.");
  //       throw new NullFieldException(Person.class, Person::getMedicareCity);
  //     }
  //     final String actual = city.getCode();
  //     if (! ArrayUtils.contains(medicareCities, actual)) {
  //       logger.error("Person's medicare city must within "
  //                   + ArrayUtils.toString(medicareCities));
  //       throw new FieldValueOutOfRangeException(Person.class, Person::getMedicareCity);
  //     }
  //   }
  //   // 判定社保所在城市是否符合条件
  //   if (socialSecurityCities != null && socialSecurityCities.length > 0) {
  //     final Info city = person.getSocialSecurityCity();
  //     if (city == null || city.getCode() == null) {
  //       logger.error("Person's social security city cannot be empty.");
  //       throw new NullFieldException(Person.class, Person::getSocialSecurityCity);
  //     }
  //     final String actual = city.getCode();
  //     if (! ArrayUtils.contains(socialSecurityCities, actual)) {
  //       logger.error("Person's social security city must within "
  //               + ArrayUtils.toString(medicareCities));
  //       throw new FieldValueOutOfRangeException(Person.class, Person::getSocialSecurityCity);
  //     }
  //   }
  //   // 判定监护人信息存在与否是否符合条件
  //   if (isTrue(needGuardian)) {
  //     if (! person.isAdult(constraint.getAgeEpoch(), constraint.getAdultAge())) {
  //       if (person.getGuardian() == null) {
  //         logger.error("The non-adult person must have a guardian: {}", this);
  //         throw new NullFieldException(Person.class, Person::getGuardian);
  //       }
  //     }
  //   }
  // }
  //
  // public void check(final Buyer buyer, @Nullable final ProductConstraint constraint) {
  //   final Logger logger = LoggerFactory.getLogger(this.getClass());
  //   logger.info("Validating a buyer again the constraint: buyer = {}, constraint = {}",
  //           buyer, this);
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
  //   // 判定年龄是否符合条件
  //   if (minAge != null || maxAge != null) {
  //     if (buyer.getBirthday() == null) {
  //       logger.error("Buyer's birthday cannot be empty.");
  //       throw new NullFieldException(Buyer.class, Buyer::getBirthday);
  //     }
  //     final Period age = buyer.getAge(ageEpoch);
  //     if (minAge != null && age.getDays() < minAge.getDays()) {
  //       logger.error("Buyer's age is less than " + minAge);
  //       throw new FieldValueOutOfRangeException(Buyer.class, Buyer::getAge);
  //     }
  //     if (maxAge != null && age.getDays() > maxAge.getDays()) {
  //       logger.error("Buyer's age is greater than " + maxAge);
  //       throw new FieldValueOutOfRangeException(Buyer.class, Buyer::getAge);
  //     }
  //   }
  //   // 判定是否必须是成年人
  //   if (isTrue(adultOnly)) {
  //     if (buyer.getBirthday() == null) {
  //       logger.error("Buyer's birthday cannot be empty.");
  //       throw new NullFieldException(Buyer.class, Buyer::getBirthday);
  //     }
  //     if (! isTrue(buyer.isAdult(ageEpoch, adultAge))) {
  //       logger.error("The buyer must be an adult.");
  //       throw new FieldValueOutOfRangeException(Buyer.class, Buyer::getAge);
  //     }
  //   }
  //   // 判定性别是否符合条件
  //   if (gender != null) {
  //     if (buyer.getGender() != gender) {
  //       logger.error("Buyer's gender must be " + gender);
  //       throw new FieldValueOutOfRangeException(Buyer.class, Buyer::getGender);
  //     }
  //   }
  // }
  //
  // public void check(final Client client, @Nullable final ProductConstraint constraint) {
  //   final Logger logger = LoggerFactory.getLogger(this.getClass());
  //   logger.info("Validating a client again the constraint: client = {}, constraint = {}",
  //           client, this);
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
  //   // 判定年龄是否符合条件
  //   if (minAge != null || maxAge != null) {
  //     if (client.getBirthday() == null) {
  //       logger.error("Client's birthday cannot be empty.");
  //       throw new NullFieldException(Client.class, Client::getBirthday);
  //     }
  //     final Period age = client.getAge(ageEpoch);
  //     if (minAge != null && age.getDays() < minAge.getDays()) {
  //       logger.error("Client's age is less than " + minAge);
  //       throw new FieldValueOutOfRangeException(Client.class, Client::getAge);
  //     }
  //     if (maxAge != null && age.getDays() > maxAge.getDays()) {
  //       logger.error("Client's age is greater than " + maxAge);
  //       throw new FieldValueOutOfRangeException(Client.class, Client::getAge);
  //     }
  //   }
  //   // 判定是否必须是成年人
  //   if (isTrue(adultOnly)) {
  //     if (client.getBirthday() == null) {
  //       logger.error("Client's birthday cannot be empty.");
  //       throw new NullFieldException(Client.class, Client::getBirthday);
  //     }
  //     if (! isTrue(client.isAdult(ageEpoch, adultAge))) {
  //       logger.error("The client must be an adult.");
  //       throw new FieldValueOutOfRangeException(Client.class, Client::getAge);
  //     }
  //   }
  //   // 判定性别是否符合条件
  //   if (gender != null) {
  //     if (client.getGender() != gender) {
  //       logger.error("Client's gender must be " + gender);
  //       throw new FieldValueOutOfRangeException(Client.class, Client::getGender);
  //     }
  //   }
  //   // 判定医保、社保是否符合条件
  //   if (hasMedicare != null) {
  //     if (! Equality.equals(hasMedicare, client.isHasMedicare())) {
  //       logger.error("Client must " + (isTrue(hasMedicare) ? "has" : "has no")
  //               + " medicare.");
  //       throw new FieldValueOutOfRangeException(Client.class, Client::isHasMedicare);
  //     }
  //   }
  //   if (hasSocialSecurity != null) {
  //     if (! Equality.equals(hasSocialSecurity, client.isHasSocialSecurity())) {
  //       logger.error("Client must " + choose(hasSocialSecurity, "has", "has no")
  //               + " social security.");
  //       throw new FieldValueOutOfRangeException(Client.class, Client::isHasSocialSecurity);
  //     }
  //   }
  //   if (hasMedicareOrSocialSecurity != null) {
  //     final Boolean actual = or(client.isHasMedicare(), client.isHasSocialSecurity());
  //     if (! Equality.equals(hasMedicareOrSocialSecurity, actual)) {
  //       logger.error("Client must " + choose(hasSocialSecurity, "has", "has no")
  //               + " medicare " + choose(hasSocialSecurity, "or", "nor")
  //               + " social security.");
  //       throw new FieldValueOutOfRangeException(Client.class,
  //           Client::isHasMedicareOrSocialSecurity);
  //     }
  //   }
  //   // 判定医保所在城市是否符合条件
  //   if (medicareCities != null && medicareCities.length > 0) {
  //     final Info city = client.getMedicareCity();
  //     if (city == null || city.getCode() == null) {
  //       logger.error("Client's medicare city cannot be empty.");
  //       throw new NullFieldException(Client.class, Client::getMedicareCity);
  //     }
  //     final String actual = city.getCode();
  //     if (! ArrayUtils.contains(medicareCities, actual)) {
  //       logger.error("Client's medicare city must within "
  //               + ArrayUtils.toString(medicareCities));
  //       throw new FieldValueOutOfRangeException(Client.class, Client::getMedicareCity);
  //     }
  //   }
  //   // 判定社保所在城市是否符合条件
  //   if (socialSecurityCities != null && socialSecurityCities.length > 0) {
  //     final Info city = client.getSocialSecurityCity();
  //     if (city == null || city.getCode() == null) {
  //       logger.error("Client's social security city cannot be empty.");
  //       throw new NullFieldException(Client.class, Client::getSocialSecurityCity);
  //     }
  //     final String actual = city.getCode();
  //     if (! ArrayUtils.contains(socialSecurityCities, actual)) {
  //       logger.error("Client's social security city must within "
  //               + ArrayUtils.toString(medicareCities));
  //       throw new FieldValueOutOfRangeException(Client.class, Client::getSocialSecurityCity);
  //     }
  //   }
  //   // 判定监护人信息存在与否是否符合条件
  //   if (isTrue(needGuardian)) {
  //     if (! client.isAdult(constraint.getAgeEpoch(), constraint.getAdultAge())) {
  //       if (client.getGuardian() == null) {
  //         logger.error("The non-adult client must have a guardian: {}", this);
  //         throw new NullFieldException(Client.class, Client::getGuardian);
  //       }
  //     }
  //   }
  // }

  @Nullable
  public Period getMinAge() {
    return minAge;
  }

  public void setMinAge(@Nullable final Period minAge) {
    this.minAge = minAge;
  }

  @Nullable
  public Period getMaxAge() {
    return maxAge;
  }

  public void setMaxAge(@Nullable final Period maxAge) {
    this.maxAge = maxAge;
  }

  @Nullable
  public Boolean isAdultOnly() {
    return adultOnly;
  }

  public void setAdultOnly(@Nullable final Boolean adultOnly) {
    this.adultOnly = adultOnly;
  }

  @Nullable
  public Gender getGender() {
    return gender;
  }

  public void setGender(@Nullable final Gender gender) {
    this.gender = gender;
  }

  @Nullable
  public Boolean isHasMedicare() {
    return hasMedicare;
  }

  public void setHasMedicare(@Nullable final Boolean hasMedicare) {
    this.hasMedicare = hasMedicare;
  }

  @Nullable
  public Boolean isHasSocialSecurity() {
    return hasSocialSecurity;
  }

  public void setHasSocialSecurity(@Nullable final Boolean hasSocialSecurity) {
    this.hasSocialSecurity = hasSocialSecurity;
  }

  @Nullable
  public Boolean isHasMedicareOrSocialSecurity() {
    return hasMedicareOrSocialSecurity;
  }

  public void setHasMedicareOrSocialSecurity(@Nullable final Boolean hasMedicareOrSocialSecurity) {
    this.hasMedicareOrSocialSecurity = hasMedicareOrSocialSecurity;
  }

  @Nullable
  public String[] getMedicareCities() {
    return medicareCities;
  }

  public void setMedicareCities(@Nullable final String[] medicareCities) {
    this.medicareCities = medicareCities;
  }

  @Nullable
  public String[] getSocialSecurityCities() {
    return socialSecurityCities;
  }

  public void setSocialSecurityCities(@Nullable final String[] socialSecurityCities) {
    this.socialSecurityCities = socialSecurityCities;
  }

  @Nullable
  public Boolean isNeedGuardian() {
    return needGuardian;
  }

  public void setNeedGuardian(@Nullable final Boolean needGuardian) {
    this.needGuardian = needGuardian;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final PersonConstraint other = (PersonConstraint) o;
    return Equality.equals(minAge, other.minAge)
            && Equality.equals(maxAge, other.maxAge)
            && Equality.equals(adultOnly, other.adultOnly)
            && Equality.equals(gender, other.gender)
            && Equality.equals(hasMedicare, other.hasMedicare)
            && Equality.equals(hasSocialSecurity, other.hasSocialSecurity)
            && Equality.equals(hasMedicareOrSocialSecurity, other.hasMedicareOrSocialSecurity)
            && Equality.equals(medicareCities, other.medicareCities)
            && Equality.equals(socialSecurityCities, other.socialSecurityCities)
            && Equality.equals(needGuardian, other.needGuardian);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, minAge);
    result = Hash.combine(result, multiplier, maxAge);
    result = Hash.combine(result, multiplier, adultOnly);
    result = Hash.combine(result, multiplier, gender);
    result = Hash.combine(result, multiplier, hasMedicare);
    result = Hash.combine(result, multiplier, hasSocialSecurity);
    result = Hash.combine(result, multiplier, hasMedicareOrSocialSecurity);
    result = Hash.combine(result, multiplier, medicareCities);
    result = Hash.combine(result, multiplier, socialSecurityCities);
    result = Hash.combine(result, multiplier, needGuardian);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("minAge", minAge)
            .append("maxAge", maxAge)
            .append("adultOnly", adultOnly)
            .append("gender", gender)
            .append("hasMedicare", hasMedicare)
            .append("hasSocialSecurity", hasSocialSecurity)
            .append("hasMedicareOrSocialSecurity", hasMedicareOrSocialSecurity)
            .append("medicareCities", medicareCities)
            .append("socialSecurityCities", socialSecurityCities)
            .append("needGuardian", needGuardian)
            .toString();
  }
}
