////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.contact.Contact;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.order.Buyer;
import ltd.qubit.model.order.Client;
import ltd.qubit.model.organization.Organization;
import ltd.qubit.model.person.Person;
import ltd.qubit.model.product.Seller;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.WithCredential;

/**
 * 此模型表示交易的参与者。
 *
 * @author 胡海星
 */
public class Participant implements Identifiable, WithCredential,
    Assignable<Participant> {

  private static final long serialVersionUID = 640357515372246818L;

  /**
   * 参与者ID，此ID参与者表示的对象在系统内部的ID。
   *
   * <p>若参与者是个人，此ID是{@link Person}对象的ID；若参与者是机构，此ID是
   * {@link Organization}对象的ID。
   */
  @Identifier
  private Long id;

  /**
   * 参与者类型，个人或机构。
   */
  private ParticipantType type;

  /**
   * 参与者姓名或名称。
   *
   * <p>对于个人参与者，通常是个人真实姓名；对于机构参与者，通常是机构注册名称。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 参与者证件。
   *
   * <p>对于个人参与者，证件通常是身份证，社保卡等；对于机构参与者，证件通常是营业执照、
   * 组织机构代码证等。
   */
  @Nullable
  private CredentialInfo credential;

  /**
   * 参与者手机号码。
   *
   * <p>对于个人参与者，通常是手机号码；对于机构参与者，可以是固定电话。
   */
  @Nullable
  private Phone phone;

  /**
   * 参与者电子邮件地址。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String email;

  /**
   * 参与者使用的账户信息。
   */
  @Nullable
  private Account account;

  public Participant() {
    // empty
  }

  public Participant(final Participant other) {
    assign(other);
  }

  public Participant(final Person person) {
    assign(person);
  }

  public Participant(final Client client) {
    assign(client);
  }

  public Participant(final Buyer buyer) {
    assign(buyer);
  }

  public Participant(final Organization organization) {
    assign(organization);
  }

  public Participant(final Seller seller) {
    assign(seller);
  }

  @Override
  public void assign(final Participant other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    type = other.type;
    name = other.name;
    credential = Assignment.clone(other.credential);
    phone = Assignment.clone(other.phone);
    email = other.email;
    account = Assignment.clone(other.account);
  }

  public void assign(final Person person) {
    id = person.getId();
    type = ParticipantType.PERSON;
    name = person.getName();
    credential = Assignment.clone(person.getCredential());
    final Contact contact = person.getContact();
    if (contact != null) {
      phone = Assignment.clone(contact.getPhone() != null
                               ? contact.getPhone()
                               : contact.getMobile());
      email = contact.getEmail();
    }
  }

  public void assign(final Client client) {
    id = client.getId();
    type = ParticipantType.PERSON;
    name = client.getName();
    credential = Assignment.clone(client.getCredential());
    phone = Assignment.clone(client.getMobile());
    email = client.getEmail();
  }

  public void assign(final Buyer buyer) {
    id = buyer.getId();
    type = ParticipantType.PERSON;
    name = buyer.getName();
    credential = Assignment.clone(buyer.getCredential());
    phone = Assignment.clone(buyer.getMobile());
    email = buyer.getEmail();
  }

  public void assign(final Organization organization) {
    id = organization.getId();
    type = ParticipantType.ORGANIZATION;
    name = organization.getName();
    credential = Assignment.clone(organization.getCredential());
    final Contact contact = organization.getContact();
    if (contact != null) {
      phone = Assignment.clone(contact.getPhone() != null
                               ? contact.getPhone()
                               : contact.getMobile());
      email = contact.getEmail();
    }
  }

  public void assign(final Seller seller) {
    id = seller.getId();
    type = ParticipantType.ORGANIZATION;
    name = seller.getName();
    credential = Assignment.clone(seller.getCredential());
    phone = Assignment.clone(seller.getMobile() != null
                             ? seller.getMobile()
                             : seller.getPhone());
    email = seller.getEmail();
  }

  @Override
  public Participant clone() {
    return new Participant(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public ParticipantType getType() {
    return type;
  }

  public void setType(final ParticipantType type) {
    this.type = type;
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
  public Phone getPhone() {
    return phone;
  }

  public void setPhone(@Nullable final Phone phone) {
    this.phone = phone;
  }

  @Nullable
  public String getEmail() {
    return email;
  }

  public void setEmail(@Nullable final String email) {
    this.email = email;
  }

  @Nullable
  public Account getAccount() {
    return account;
  }

  public void setAccount(@Nullable final Account account) {
    this.account = account;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Participant other = (Participant) o;
    return Equality.equals(id, other.id)
        && Equality.equals(type, other.type)
        && Equality.equals(name, other.name)
        && Equality.equals(credential, other.credential)
        && Equality.equals(phone, other.phone)
        && Equality.equals(email, other.email)
        && Equality.equals(account, other.account);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, type);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, credential);
    result = Hash.combine(result, multiplier, phone);
    result = Hash.combine(result, multiplier, email);
    result = Hash.combine(result, multiplier, account);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("type", type)
        .append("name", name)
        .append("credential", credential)
        .append("phone", phone)
        .append("email", email)
        .append("account", account)
        .toString();
  }
}
