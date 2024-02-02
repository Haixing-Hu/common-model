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
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
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
import ltd.qubit.model.commons.Payload;
import ltd.qubit.model.commons.State;
import ltd.qubit.model.contact.Contact;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Emptyful;
import ltd.qubit.model.util.HasStatefulInfo;
import ltd.qubit.model.util.InfoWithEntity;
import ltd.qubit.model.util.Normalizable;
import ltd.qubit.model.util.Predefinable;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithCategory;
import ltd.qubit.model.util.WithContact;

/**
 * 此模型表示组织机构下属部门。
 *
 * @author 胡海星
 */
public class Department implements HasStatefulInfo, WithCategory, WithContact,
    Predefinable, Auditable, Emptyful, Normalizable, Assignable<Department> {

  private static final long serialVersionUID = -1991064299165372925L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 编码，全局唯一。
   *
   * <p>可使用 [所属机构编码] + "-" + [机构内部编码] 生成全局唯一编码。
   */
  @Size(min = 1, max = 64)
  @Unique
  private String code;

  /**
   * 在所属机构内部编码，在所属机构内部不可重复。
   */
  @Size(min = 1, max = 64)
  @Unique(respectTo = "organization")
  @Nullable
  private String internalCode;

  /**
   * 名称，同一个机构中不重复。
   */
  @Unique(respectTo = "organization")
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 所属类别基本信息。
   */
  @Reference(entity = Category.class, property = "info")
  @Nullable
  private InfoWithEntity category;

  /**
   * 上级部门基本信息，若没有则为{@code null}。
   */
  @Reference(entity = Department.class, property = "info")
  @Nullable
  private StatefulInfo parent;

  /**
   * 所属机构基本信息。
   */
  @Reference(entity = Organization.class, property = "info")
  private StatefulInfo organization;

  /**
   * 状态。
   */
  private State state = State.NORMAL;

  /**
   * 图标，存储相对路径或者URL。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String icon;

  /**
   * 描述。
   */
  @Nullable
  private String description;

  /**
   * 联系方式。
   */
  @Reference
  @Nullable
  private Contact contact;

  /**
   * 额外参数。
   */
  @Size(min = 1, max = 10)
  @Reference(entity = Payload.class, existing = false)
  @Nullable
  private List<Payload> payloads;

  /**
   * 是否是预定义的数据。
   */
  private Boolean predefined;

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

  public Department() {
    // empty
  }

  public Department(final Department other) {
    assign(other);
  }

  @Override
  public void assign(final Department other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    internalCode = other.internalCode;
    name = other.name;
    category = Assignment.clone(other.category);
    parent = Assignment.clone(other.parent);
    organization = Assignment.clone(other.organization);
    state = other.state;
    icon = other.icon;
    description = other.description;
    contact = Assignment.clone(other.contact);
    payloads = Assignment.deepClone(other.payloads);
    predefined = other.predefined;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Department clone() {
    return new Department(this);
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

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Nullable
  public InfoWithEntity getCategory() {
    return category;
  }

  public void setCategory(@Nullable final InfoWithEntity category) {
    this.category = category;
  }

  @Nullable
  public StatefulInfo getParent() {
    return parent;
  }

  public void setParent(@Nullable final StatefulInfo parent) {
    this.parent = parent;
  }

  public StatefulInfo getOrganization() {
    return organization;
  }

  public void setOrganization(final StatefulInfo organization) {
    this.organization = organization;
  }

  public State getState() {
    return state;
  }

  public void setState(final State state) {
    this.state = state;
  }

  @Nullable
  public String getIcon() {
    return icon;
  }

  public void setIcon(@Nullable final String icon) {
    this.icon = icon;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  @Nullable
  public Contact getContact() {
    return contact;
  }

  public void setContact(@Nullable final Contact contact) {
    this.contact = contact;
  }

  @Nullable
  public List<Payload> getPayloads() {
    return payloads;
  }

  public void setPayloads(@Nullable final List<Payload> payloads) {
    this.payloads = payloads;
  }

  public Boolean isPredefined() {
    return predefined;
  }

  public void setPredefined(final Boolean predefined) {
    this.predefined = predefined;
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
    final Department other = (Department) o;
    return Equality.equals(id, other.id)
      && Equality.equals(code, other.code)
      && Equality.equals(internalCode, other.internalCode)
      && Equality.equals(name, other.name)
      && Equality.equals(category, other.category)
      && Equality.equals(parent, other.parent)
      && Equality.equals(organization, other.organization)
      && Equality.equals(state, other.state)
      && Equality.equals(icon, other.icon)
      && Equality.equals(description, other.description)
      && Equality.equals(contact, other.contact)
      && Equality.equals(payloads, other.payloads)
      && Equality.equals(predefined, other.predefined)
      && Equality.equals(createTime, other.createTime)
      && Equality.equals(modifyTime, other.modifyTime)
      && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, internalCode);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, category);
    result = Hash.combine(result, multiplier, parent);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, icon);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, contact);
    result = Hash.combine(result, multiplier, payloads);
    result = Hash.combine(result, multiplier, predefined);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this).append("id", id)
      .append("code", code)
      .append("internalCode", internalCode)
      .append("name", name)
      .append("category", category)
      .append("parent", parent)
      .append("organization", organization)
      .append("state", state)
      .append("icon", icon)
      .append("description", description)
      .append("contact", contact)
      .append("payloads", payloads)
      .append("predefined", predefined)
      .append("createTime", createTime)
      .append("modifyTime", modifyTime)
      .append("deleteTime", deleteTime)
      .toString();
  }
}
