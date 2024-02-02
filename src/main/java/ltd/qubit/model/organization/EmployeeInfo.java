////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.organization;

import java.time.Instant;
import java.time.LocalDate;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Reference;
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
import ltd.qubit.model.person.User;
import ltd.qubit.model.util.Deletable;
import ltd.qubit.model.util.Emptyful;
import ltd.qubit.model.util.HasInfo;
import ltd.qubit.model.util.Normalizable;
import ltd.qubit.model.util.Stateful;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithBirthday;

/**
 * 此模型表示机构下属职工基本信息。
 *
 * @author 胡海星
 */
public class EmployeeInfo implements HasInfo, WithBirthday, Stateful, Deletable,
    Emptyful, Normalizable, Assignable<EmployeeInfo> {

  private static final long serialVersionUID = -1731433473911709869L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 编号，全局唯一；可使用所属机构编号+机构内部编号生成全局唯一编号。
   */
  @Size(min = 1, max = 64)
  @Unique
  private String code;

  /**
   * 在所属机构内部编号。
   */
  @Size(min = 1, max = 64)
  @Unique(respectTo = "organization")
  @Nullable
  private String internalCode;

  /**
   * 该员工所注册的用户的用户名，对应于{@link User}类的{@code username}属性。
   *
   * <p>注意若该员工没有在系统中注册，此属性可以为{@code null}
   */
  @Size(min = 1, max = 64)
  @Reference(entity = User.class, property = "username")
  @Nullable
  private String username;

  /**
   * 姓名。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 性别。
   */
  private Gender gender;

  /**
   * 出生日期。
   */
  @Nullable
  private LocalDate birthday;

  /**
   * 证件。
   */
  @Unique
  @Nullable
  private CredentialInfo credential;

  /**
   * 手机号码。
   */
  @Unique
  private Phone mobile;

  /**
   * 所属机构基本信息。
   */
  private StatefulInfo organization;

  /**
   * 所属部门基本信息。
   */
  @Nullable
  private StatefulInfo department;

  /**
   * 状态。
   */
  private State state;

  /**
   * 标记删除时间。
   */
  @Nullable
  private Instant deleteTime;

  public static EmployeeInfo create(
          @Nullable final Long id,
          @Nullable final String code,
          @Nullable final String internalCode,
          @Nullable final String name,
          @Nullable final CredentialInfo credential,
          @Nullable final Phone mobile) {
    if (id == null
            && code == null
            && internalCode == null
            && name == null
            && credential == null
            && mobile == null) {
      return null;
    }
    final EmployeeInfo result = new EmployeeInfo();
    result.id = id;
    result.code = code;
    result.name = name;
    result.credential = credential;
    result.mobile = mobile;
    return result;
  }

  public static EmployeeInfo create(
          @Nullable final Long id,
          @Nullable final String code,
          @Nullable final String name,
          @Nullable final CredentialInfo credential,
          @Nullable final Phone mobile,
          @Nullable final StatefulInfo organization,
          @Nullable final StatefulInfo department) {
    if (id == null
            && code == null
            && name == null
            && credential == null
            && organization == null
            && department == null
            && mobile == null) {
      return null;
    }
    final EmployeeInfo result = new EmployeeInfo();
    result.id = id;
    result.code = code;
    result.name = name;
    result.credential = credential;
    result.mobile = mobile;
    result.organization = organization;
    result.department = department;
    return result;
  }

  public EmployeeInfo() {
    // empty
  }

  public EmployeeInfo(final EmployeeInfo other) {
    assign(other);
  }

  public EmployeeInfo(final Employee employee) {
    assign(employee);
  }

  @Override
  public void assign(final EmployeeInfo other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    internalCode = other.internalCode;
    username = other.username;
    name = other.name;
    gender = other.gender;
    birthday = other.birthday;
    credential = Assignment.clone(other.credential);
    mobile = Assignment.clone(other.mobile);
    organization = Assignment.clone(other.organization);
    department = Assignment.clone(other.department);
    state = other.state;
    deleteTime = other.deleteTime;
  }

  public void assign(final Employee employee) {
    Argument.requireNonNull("employee", employee);
    id = employee.getId();
    code = employee.getCode();
    internalCode = employee.getInternalCode();
    username = employee.getUsername();
    name = employee.getName();
    gender = employee.getGender();
    birthday = employee.getBirthday();
    credential = employee.getCredential();
    mobile = employee.getMobile();
    organization = employee.getOrganization();
    department = employee.getDepartment();
    state = employee.getState();
    deleteTime = employee.getDeleteTime();
  }

  @Override
  public EmployeeInfo clone() {
    return new EmployeeInfo(this);
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

  @Nullable
  public String getInternalCode() {
    return internalCode;
  }

  public void setInternalCode(@Nullable final String internalCode) {
    this.internalCode = internalCode;
  }

  @Nullable
  public String getUsername() {
    return username;
  }

  public void setUsername(@Nullable final String username) {
    this.username = username;
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

  @Override
  @Nullable
  public LocalDate getBirthday() {
    return birthday;
  }

  @Override
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

  @Nullable
  public StatefulInfo getDepartment() {
    return department;
  }

  public void setDepartment(@Nullable final StatefulInfo department) {
    this.department = department;
  }

  public State getState() {
    return state;
  }

  public void setState(final State state) {
    this.state = state;
  }

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final EmployeeInfo other = (EmployeeInfo) o;
    return Equality.equals(id, other.id)
        && Equality.equals(code, other.code)
        && Equality.equals(internalCode, other.internalCode)
        && Equality.equals(username, other.username)
        && Equality.equals(name, other.name)
        && Equality.equals(gender, other.gender)
        && Equality.equals(birthday, other.birthday)
        && Equality.equals(credential, other.credential)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(organization, other.organization)
        && Equality.equals(department, other.department)
        && Equality.equals(state, other.state)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, internalCode);
    result = Hash.combine(result, multiplier, username);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, gender);
    result = Hash.combine(result, multiplier, birthday);
    result = Hash.combine(result, multiplier, credential);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, department);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("code", code)
        .append("internalCode", internalCode)
        .append("username", username)
        .append("name", name)
        .append("gender", gender)
        .append("birthday", birthday)
        .append("credential", credential)
        .append("mobile", mobile)
        .append("organization", organization)
        .append("department", department)
        .append("state", state)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
