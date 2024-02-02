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

import ltd.qubit.commons.annotation.Identifier;
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
import ltd.qubit.model.person.Gender;
import ltd.qubit.model.person.Person;
import ltd.qubit.model.person.User;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.WithBirthday;
import ltd.qubit.model.util.WithCredential;
import ltd.qubit.model.util.WithName;

/**
 * The model of buyer.
 *
 * @author Haixing Hu
 */
public class Buyer implements Identifiable, WithName, WithBirthday,
    WithCredential, Assignable<Buyer> {

  private static final long serialVersionUID = -8761766823566252587L;

  /**
   * 个人档案ID，对应于 {@link Person} 类的 id 属性。
   */
  @Identifier
  private Long id;

  /**
   * 所属用户ID，对应于 {@link User} 类的 id 属性。
   *
   * <p>注意若该人没有在系统中注册，此属性可以为{@code null}。
   */
  @Reference(entity = User.class, property = "id")
  @Nullable
  private Long userId;

  /**
   * 姓名。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 实名认证证件。
   */
  @Nullable
  private CredentialInfo credential;

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
   * 手机号码。
   */
  @Nullable
  private Phone mobile;

  /**
   * 电子邮件地址。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String email;

  public Buyer() {
    // empty
  }

  public Buyer(final Buyer other) {
    assign(other);
  }

  public Buyer(final Client client) {
    assign(client);
  }

  public Buyer(final Person person) {
    assign(person);
  }

  @Override
  public void assign(final Buyer other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    userId = other.userId;
    name = other.name;
    credential = Assignment.clone(other.credential);
    gender = other.gender;
    birthday = other.birthday;
    mobile = Assignment.clone(other.mobile);
    email = other.email;
  }

  public void assign(final Client client) {
    id = client.getId();
    name = client.getName();
    credential = Assignment.clone(client.getCredential());
    gender = client.getGender();
    birthday = client.getBirthday();
    mobile = Assignment.clone(client.getMobile());
    email = client.getEmail();
  }

  public void assign(final Person person) {
    id = person.getId();
    name = person.getName();
    credential = Assignment.clone(person.getCredential());
    gender = person.getGender();
    birthday = person.getBirthday();
    if (person.getContact() != null) {
      final Contact contact = person.getContact();
      mobile = Assignment.clone(contact.getMobile());
      email = contact.getEmail();
    }
  }

  @Override
  public Buyer clone() {
    return new Buyer(this);
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

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Nullable
  public CredentialInfo getCredential() {
    return credential;
  }

  public void setCredential(@Nullable final CredentialInfo credential) {
    this.credential = credential;
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

  public final <T extends Identifiable & WithCredential> boolean isSame(
      @Nullable final T person) {
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
    final Buyer other = (Buyer) o;
    return Equality.equals(id, other.id)
        && Equality.equals(userId, other.userId)
        && Equality.equals(name, other.name)
        && Equality.equals(credential, other.credential)
        && Equality.equals(gender, other.gender)
        && Equality.equals(birthday, other.birthday)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(email, other.email);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, userId);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, credential);
    result = Hash.combine(result, multiplier, gender);
    result = Hash.combine(result, multiplier, birthday);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, email);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("userId", userId)
        .append("name", name)
        .append("credential", credential)
        .append("gender", gender)
        .append("birthday", birthday)
        .append("mobile", mobile)
        .append("email", email)
        .toString();
  }
}
