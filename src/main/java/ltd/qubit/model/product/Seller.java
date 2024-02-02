////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.product;

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
import ltd.qubit.model.contact.Address;
import ltd.qubit.model.contact.Contact;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.organization.Organization;
import ltd.qubit.model.util.HasInfo;

/**
 * 此模型表示商品的销售商。
 *
 * @author 胡海星
 */
public class Seller implements HasInfo, Assignable<Seller> {

  private static final long serialVersionUID = 5567496813289687653L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 代码，全局唯一。
   */
  @Size(min = 1, max = 64)
  @Unique
  private String code;

  /**
   * 名称。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 固定电话号码。
   */
  @Nullable
  private Phone phone;

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

  /**
   * 网址 URL。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String url;

  /**
   * 身份证件，例如营业执照、组织机构代码证等。
   */
  @Nullable
  private CredentialInfo credential;

  /**
   * 联系地址.
   */
  @Nullable
  private Address address;

  public Seller() {
    // empty
  }

  public Seller(final Seller other) {
    assign(other);
  }

  public Seller(final Organization org) {
    assign(org);
  }

  @Override
  public void assign(final Seller other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    name = other.name;
    phone = Assignment.clone(other.phone);
    mobile = Assignment.clone(other.mobile);
    email = other.email;
    url = other.url;
    credential = Assignment.clone(other.credential);
    address = Assignment.clone(other.address);
  }

  public void assign(final Organization org) {
    id = org.getId();
    name = org.getName();
    code = org.getCode();
    credential = Assignment.clone(org.getCredential());
    if (org.getContact() != null) {
      final Contact contact = org.getContact();
      phone = contact.getPhone();
      mobile = contact.getMobile();
      email = contact.getEmail();
      url = contact.getUrl();
      address = Assignment.clone(contact.getAddress());
    }
  }

  @Override
  public Seller clone() {
    return new Seller(this);
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

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Nullable
  public Phone getPhone() {
    return phone;
  }

  public void setPhone(@Nullable final Phone phone) {
    this.phone = phone;
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

  @Nullable
  public String getUrl() {
    return url;
  }

  public void setUrl(@Nullable final String url) {
    this.url = url;
  }

  @Nullable
  public CredentialInfo getCredential() {
    return credential;
  }

  public void setCredential(@Nullable final CredentialInfo credential) {
    this.credential = credential;
  }

  @Nullable
  public Address getAddress() {
    return address;
  }

  public void setAddress(@Nullable final Address address) {
    this.address = address;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Seller other = (Seller) o;
    return Equality.equals(id, other.id)
        && Equality.equals(code, other.code)
        && Equality.equals(name, other.name)
        && Equality.equals(phone, other.phone)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(email, other.email)
        && Equality.equals(url, other.url)
        && Equality.equals(credential, other.credential)
        && Equality.equals(address, other.address);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, phone);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, email);
    result = Hash.combine(result, multiplier, url);
    result = Hash.combine(result, multiplier, credential);
    result = Hash.combine(result, multiplier, address);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("code", code)
        .append("name", name)
        .append("phone", phone)
        .append("mobile", mobile)
        .append("email", email)
        .append("url", url)
        .append("credential", credential)
        .append("address", address)
        .toString();
  }
}
