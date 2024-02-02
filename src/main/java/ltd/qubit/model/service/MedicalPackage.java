////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.service;

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
import ltd.qubit.model.organization.Organization;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.HasInfo;
import ltd.qubit.model.util.StatefulInfo;

/**
 * 此模型表示医疗服务包。
 *
 * @author 王佳，胡海星
 */
public class MedicalPackage implements HasInfo, Auditable,
    Assignable<MedicalPackage> {

  private static final long serialVersionUID = -3975665458379978757L;

  /**
   * 唯一标识。
   */
  @Identifier
  private Long id;

  /**
   * 服务编码，全局唯一。
   */
  @Unique
  @Size(min = 1, max = 64)
  private String code;

  /**
   * 服务名称。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 服务概要描述。
   */
  @Nullable
  private String description;

  /**
   * 服务项目集。
   */
  @Nullable
  private List<MedicalPackageItem> items;

  /**
   * 所属机构。
   */
  @Reference(entity = Organization.class, property = "info")
  private StatefulInfo organization;

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

  public MedicalPackage() {
    // empty
  }

  public MedicalPackage(final MedicalPackage other) {
    assign(other);
  }

  @Override
  public void assign(final MedicalPackage other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    name = other.name;
    description = other.description;
    items = Assignment.deepClone(other.items);
    organization = Assignment.clone(other.organization);
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public MedicalPackage clone() {
    return new MedicalPackage(this);
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(final Long id) {
    this.id = id;
  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public void setCode(final String code) {
    this.code = code;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  @Nullable
  public List<MedicalPackageItem> getItems() {
    return items;
  }

  public void setItems(@Nullable final List<MedicalPackageItem> items) {
    this.items = items;
  }

  public StatefulInfo getOrganization() {
    return organization;
  }

  public void setOrganization(final StatefulInfo organization) {
    this.organization = organization;
  }

  @Override
  public Instant getCreateTime() {
    return createTime;
  }

  @Override
  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  @Override
  @Nullable
  public Instant getModifyTime() {
    return modifyTime;
  }

  @Override
  public void setModifyTime(@Nullable final Instant modifyTime) {
    this.modifyTime = modifyTime;
  }

  @Override
  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  @Override
  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  @Override
  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final MedicalPackage other = (MedicalPackage) o;
    return Equality.equals(id, other.id)
        && Equality.equals(code, other.code)
        && Equality.equals(name, other.name)
        && Equality.equals(description, other.description)
        && Equality.equals(items, other.items)
        && Equality.equals(organization, other.organization)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, items);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("code", code)
        .append("name", name)
        .append("description", description)
        .append("items", items)
        .append("organization", organization)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
