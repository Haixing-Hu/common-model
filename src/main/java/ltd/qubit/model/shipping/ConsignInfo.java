////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.shipping;

import javax.annotation.Nullable;

import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.contact.Address;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.util.WithCredential;
import ltd.qubit.model.util.WithName;

/**
 * 此模型表示收件人、发件人信息。
 *
 * @author 胡海星
 */
public class ConsignInfo implements WithName, WithCredential,
    Assignable<ConsignInfo> {

  /**
   * 姓名。
   */
  private String name;

  /**
   * 手机号码。
   */
  private Phone mobile;

  /**
   * 电子邮件地址。
   */
  @Nullable
  private String email;

  /**
   * 证件。
   *
   * <p>仅用于需要实名认证的收件情况。
   */
  @Nullable
  private CredentialInfo credential;

  /**
   * 地址。
   */
  private Address address;

  public ConsignInfo() {
    // empty
  }

  public ConsignInfo(final ConsignInfo other) {
    assign(other);
  }

  @Override
  public void assign(final ConsignInfo other) {
    Argument.requireNonNull("other", other);
    name = other.name;
    mobile = Assignment.clone(other.mobile);
    email = other.email;
    credential = Assignment.clone(other.credential);
    address = Assignment.clone(other.address);
  }

  @Override
  public ConsignInfo clone() {
    return new ConsignInfo(this);
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
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
  public CredentialInfo getCredential() {
    return credential;
  }

  public void setCredential(@Nullable final CredentialInfo credential) {
    this.credential = credential;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(final Address address) {
    this.address = address;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final ConsignInfo other = (ConsignInfo) o;
    return Equality.equals(name, other.name)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(email, other.email)
        && Equality.equals(credential, other.credential)
        && Equality.equals(address, other.address);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, email);
    result = Hash.combine(result, multiplier, credential);
    result = Hash.combine(result, multiplier, address);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("name", name)
        .append("mobile", mobile)
        .append("email", email)
        .append("credential", credential)
        .append("address", address)
        .toString();
  }
}
