////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.controller;

import java.io.Serializable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.util.StatefulInfo;

/**
 * 此模型表示绑定用户和职工信息所需的参数。
 *
 * @author 胡海星
 */
public class BindEmployeeParams implements Serializable,
    Assignable<BindEmployeeParams> {

  private static final long serialVersionUID = 2803684029678031794L;

  /**
   * 用户名。
   */
  @Size(min = 1, max = 64)
  private String username;

  /**
   * 姓名。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 手机号码。
   */
  private Phone mobile;

  /**
   * 所属机构基本信息。
   */
  private StatefulInfo organization;

  /**
   * 手机验证码。
   */
  @Size(min = 1, max = 64)
  private String verifyCode;

  public BindEmployeeParams() {
    // empty
  }

  public BindEmployeeParams(final BindEmployeeParams other) {
    assign(other);
  }

  @Override
  public void assign(final BindEmployeeParams other) {
    Argument.requireNonNull("other", other);
    username = other.username;
    name = other.name;
    mobile = Assignment.clone(other.mobile);
    organization = Assignment.clone(other.organization);
    verifyCode = other.verifyCode;
  }

  @Override
  public BindEmployeeParams clone() {
    return new BindEmployeeParams(this);
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
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

  public StatefulInfo getOrganization() {
    return organization;
  }

  public void setOrganization(final StatefulInfo organization) {
    this.organization = organization;
  }

  public String getVerifyCode() {
    return verifyCode;
  }

  public void setVerifyCode(final String verifyCode) {
    this.verifyCode = verifyCode;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final BindEmployeeParams other = (BindEmployeeParams) o;
    return Equality.equals(username, other.username)
        && Equality.equals(name, other.name)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(organization, other.organization)
        && Equality.equals(verifyCode, other.verifyCode);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, username);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, verifyCode);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this).append("username", username)
        .append("name", name)
        .append("mobile", mobile)
        .append("organization", organization)
        .append("verifyCode", verifyCode)
        .toString();
  }
}
