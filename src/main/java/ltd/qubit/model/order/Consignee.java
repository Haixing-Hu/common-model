////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
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
import ltd.qubit.model.person.Person;
import ltd.qubit.model.person.User;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示收件人信息。
 *
 * @author 胡海星
 */
public class Consignee implements Identifiable, Auditable, Assignable<Consignee> {

  private static final long serialVersionUID = 1120238757631304925L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 此收件人所属用户ID。
   */
  @Reference(entity = User.class, property = "id")
  @Nullable
  private Long userId;

  /**
   * 此收件人信息标题。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String title;

  /**
   * 收件人姓名。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 收件人手机号码。
   */
  private Phone mobile;

  /**
   * 收件人电子邮件地址。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String email;

  /**
   * 收件人证件。
   *
   * <p>仅用于需要实名认证的收件情况。
   */
  @Nullable
  private CredentialInfo credential;

  /**
   * 收件地址。
   */
  private Address address;

  /**
   * 备注。
   */
  private String comment;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public Consignee() {
    // empty
  }

  public Consignee(final Consignee other) {
    assign(other);
  }

  public Consignee(final Person person) {
    assign(person);
  }

  @Override
  public void assign(final Consignee other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    userId = other.userId;
    title = other.title;
    name = other.name;
    mobile = Assignment.clone(other.mobile);
    email = other.email;
    credential = Assignment.clone(other.credential);
    address = Assignment.clone(other.address);
    comment = other.comment;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  public void assign(final Person person) {
    id = person.getId();
    name = person.getName();
    credential = Assignment.clone(person.getCredential());
    if (person.getContact() != null) {
      final Contact contact = person.getContact();
      mobile = Assignment.clone(contact.getMobile());
      email = contact.getEmail();
      address = Assignment.clone(contact.getAddress());
    }
  }

  @Override
  public Consignee clone() {
    return new Consignee(this);
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

  @Nullable
  public String getTitle() {
    return title;
  }

  public void setTitle(@Nullable final String title) {
    this.title = title;
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

  public String getComment() {
    return comment;
  }

  public void setComment(final String comment) {
    this.comment = comment;
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
    final Consignee other = (Consignee) o;
    return Equality.equals(id, other.id)
        && Equality.equals(userId, other.userId)
        && Equality.equals(title, other.title)
        && Equality.equals(name, other.name)
        && Equality.equals(mobile, other.mobile)
        && Equality.equals(email, other.email)
        && Equality.equals(credential, other.credential)
        && Equality.equals(address, other.address)
        && Equality.equals(comment, other.comment)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, userId);
    result = Hash.combine(result, multiplier, title);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, mobile);
    result = Hash.combine(result, multiplier, email);
    result = Hash.combine(result, multiplier, credential);
    result = Hash.combine(result, multiplier, address);
    result = Hash.combine(result, multiplier, comment);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("userId", userId)
        .append("title", title)
        .append("name", name)
        .append("mobile", mobile)
        .append("email", email)
        .append("credential", credential)
        .append("address", address)
        .append("comment", comment)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
