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
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Indexed;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.Category;
import ltd.qubit.model.commons.Credential;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.commons.State;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.person.Gender;
import ltd.qubit.model.person.Person;
import ltd.qubit.model.person.User;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Emptyful;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.InfoWithEntity;
import ltd.qubit.model.util.Normalizable;
import ltd.qubit.model.util.Stateful;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithBirthday;
import ltd.qubit.model.util.WithCategory;
import ltd.qubit.model.util.WithCode;
import ltd.qubit.model.util.WithComment;
import ltd.qubit.model.util.WithCredential;
import ltd.qubit.model.util.WithEmail;
import ltd.qubit.model.util.WithMobile;
import ltd.qubit.model.util.WithName;
import ltd.qubit.model.util.WithOrganization;
import ltd.qubit.model.util.WithUsername;

/**
 * 此模型表示机构下属职工信息详情。
 *
 * @author 胡海星
 */
public class Employee implements Identifiable, WithUsername, WithCode, WithName,
    WithBirthday, WithCategory, WithOrganization, WithCredential, WithMobile,
    WithEmail, WithComment, Stateful, Auditable, Emptyful, Normalizable,
    Assignable<Employee> {

  private static final long serialVersionUID = 4249048050215639904L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

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
   * 个人档案ID，对应于 {@link Person} 类的 id 属性。
   *
   * <p>注意若系统中不存在该员工的个人信息，此属性可以为{@code null}。
   */
  @Reference(entity = Person.class, property = "id")
  @Nullable
  private Long personId;

  /**
   * 编码，全局唯一。
   *
   * <p>可使用 [所属机构编码] + "-" + [机构内部编码] 生成全局唯一编码。
   */
  @Size(min = 1, max = 64)
  @Unique
  private String code;

  /**
   * 在所属机构内部编码，在所属机构内唯一。
   */
  @Size(min = 1, max = 64)
  @Unique(respectTo = "organization")
  @Nullable
  private String internalCode;

  /**
   * 姓名。
   */
  @Size(min = 1, max = 128)
  @Indexed
  private String name;

  /**
   * 性别。
   */
  @Indexed
  private Gender gender;

  /**
   * 出生日期。
   */
  @Nullable
  @Indexed
  private LocalDate birthday;

  /**
   * 身份证明证件，例如身份证、护照等。
   */
  @Reference(entity = Credential.class, property = "info")
  @Unique
  @Nullable
  private CredentialInfo credential;

  /**
   * 所属类别。
   */
  @Reference(entity = Category.class, property = "info")
  @Nullable
  private InfoWithEntity category;

  /**
   * 所属机构。
   */
  @Reference(entity = Organization.class, property = "info")
  private StatefulInfo organization;

  /**
   * 所属部门。
   */
  @Reference(entity = Department.class, property = "info")
  @Nullable
  private StatefulInfo department;

  /**
   * 固定电话号码。
   */
  @Nullable
  @Indexed
  private Phone phone;

  /**
   * 手机号码，在所属机构内唯一。
   */
  @Unique(respectTo = "organization")
  private Phone mobile;

  /**
   * 电子邮件地址，在所属机构内唯一。
   */
  @Size(min = 1, max = 512)
  @Unique(respectTo = "organization")
  @Nullable
  private String email;

  /**
   * 网址 URL。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String url;

  /**
   * 照片，存储相对路径或者URL。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String photo;

  /**
   * 描述。
   */
  @Nullable
  private String description;

  /**
   * 执业资格证。
   */
  @Reference(entity = Credential.class, property = "info")
  @Nullable
  private CredentialInfo practisingCertificate;

  /**
   * 职称资格证。
   */
  @Reference(entity = Credential.class, property = "info")
  @Nullable
  private CredentialInfo titleCertificate;

  /**
   * 执业类别，字典条目。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String practisingType;

  /**
   * 执业范围，字典条目。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String practisingScope;

  /**
   * 职称。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String jobTitle;

  /**
   * 备注。
   */
  @Nullable
  private String comment;

  /**
   * 状态。
   */
  @Indexed
  private State state = State.NORMAL;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  @Indexed
  private Instant modifyTime;

  /**
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  @Indexed
  private Instant deleteTime;

  public Employee() {
    // empty
  }

  public Employee(final Employee other) {
    assign(other);
  }

  @Override
  public void assign(final Employee other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    username = other.username;
    personId = other.personId;
    code = other.code;
    internalCode = other.internalCode;
    name = other.name;
    gender = other.gender;
    birthday = other.birthday;
    credential = Assignment.clone(other.credential);
    category = Assignment.clone(other.category);
    organization = Assignment.clone(other.organization);
    department = Assignment.clone(other.department);
    phone = Assignment.clone(other.phone);
    mobile = Assignment.clone(other.mobile);
    email = other.email;
    url = other.url;
    photo = other.photo;
    description = other.description;
    practisingCertificate = Assignment.clone(other.practisingCertificate);
    titleCertificate = Assignment.clone(other.titleCertificate);
    practisingType = other.practisingType;
    practisingScope = other.practisingScope;
    jobTitle = other.jobTitle;
    comment = other.comment;
    state = other.state;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Employee clone() {
    return new Employee(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  @Nullable
  public String getUsername() {
    return username;
  }

  public void setUsername(@Nullable final String username) {
    this.username = username;
  }

  @Nullable
  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(@Nullable final Long personId) {
    this.personId = personId;
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
  public InfoWithEntity getCategory() {
    return category;
  }

  public void setCategory(@Nullable final InfoWithEntity category) {
    this.category = category;
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

  @Nullable
  public Phone getPhone() {
    return phone;
  }

  public void setPhone(@Nullable final Phone phone) {
    this.phone = phone;
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
  public String getUrl() {
    return url;
  }

  public void setUrl(@Nullable final String url) {
    this.url = url;
  }

  @Nullable
  public String getPhoto() {
    return photo;
  }

  public void setPhoto(@Nullable final String photo) {
    this.photo = photo;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  @Nullable
  public CredentialInfo getPractisingCertificate() {
    return practisingCertificate;
  }

  public void setPractisingCertificate(@Nullable final CredentialInfo practisingCertificate) {
    this.practisingCertificate = practisingCertificate;
  }

  @Nullable
  public CredentialInfo getTitleCertificate() {
    return titleCertificate;
  }

  public void setTitleCertificate(@Nullable final CredentialInfo titleCertificate) {
    this.titleCertificate = titleCertificate;
  }

  @Nullable
  public String getPractisingType() {
    return practisingType;
  }

  public void setPractisingType(@Nullable final String practisingType) {
    this.practisingType = practisingType;
  }

  @Nullable
  public String getPractisingScope() {
    return practisingScope;
  }

  public void setPractisingScope(@Nullable final String practisingScope) {
    this.practisingScope = practisingScope;
  }

  @Nullable
  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(@Nullable final String jobTitle) {
    this.jobTitle = jobTitle;
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

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Employee other = (Employee) o;
    return Equality.equals(id, other.id)
        && Equality.equals(username, other.username)
        && Equality.equals(personId, other.personId)
        && Equality.equals(code, other.code)
        && Equality.equals(internalCode, other.internalCode)
        && Equality.equals(name, other.name)
        && Equality.equals(gender, other.gender)
        && Equality.equals(birthday, other.birthday)
        && Equality.equals(credential, other.credential)
        && Equality.equals(category, other.category)
        && Equality.equals(organization, other.organization)
        && Equality.equals(department, other.department)
        && Equality.equals(phone, other.phone)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(email, other.email)
        && Equality.equals(url, other.url)
        && Equality.equals(photo, other.photo)
        && Equality.equals(description, other.description)
        && Equality.equals(practisingCertificate, other.practisingCertificate)
        && Equality.equals(titleCertificate, other.titleCertificate)
        && Equality.equals(practisingType, other.practisingType)
        && Equality.equals(practisingScope, other.practisingScope)
        && Equality.equals(jobTitle, other.jobTitle)
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
    result = Hash.combine(result, multiplier, username);
    result = Hash.combine(result, multiplier, personId);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, internalCode);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, gender);
    result = Hash.combine(result, multiplier, birthday);
    result = Hash.combine(result, multiplier, credential);
    result = Hash.combine(result, multiplier, category);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, department);
    result = Hash.combine(result, multiplier, phone);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, email);
    result = Hash.combine(result, multiplier, url);
    result = Hash.combine(result, multiplier, photo);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, practisingCertificate);
    result = Hash.combine(result, multiplier, titleCertificate);
    result = Hash.combine(result, multiplier, practisingType);
    result = Hash.combine(result, multiplier, practisingScope);
    result = Hash.combine(result, multiplier, jobTitle);
    result = Hash.combine(result, multiplier, comment);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this).append("id", id)
        .append("username", username)
        .append("personId", personId)
        .append("code", code)
        .append("internalCode", internalCode)
        .append("name", name)
        .append("gender", gender)
        .append("birthday", birthday)
        .append("credential", credential)
        .append("category", category)
        .append("organization", organization)
        .append("department", department)
        .append("phone", phone)
        .append("mobile", mobile)
        .append("email", email)
        .append("url", url)
        .append("photo", photo)
        .append("description", description)
        .append("practisingCertificate", practisingCertificate)
        .append("titleCertificate", titleCertificate)
        .append("practisingType", practisingType)
        .append("practisingScope", practisingScope)
        .append("jobTitle", jobTitle)
        .append("comment", comment)
        .append("state", state)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }

  public EmployeeInfo getInfo() {
    return new EmployeeInfo(this);
  }
}
