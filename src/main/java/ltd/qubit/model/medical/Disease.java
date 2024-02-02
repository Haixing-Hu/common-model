////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.time.Instant;
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
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.HasInfo;
import ltd.qubit.model.util.InfoWithEntity;
import ltd.qubit.model.util.Predefinable;

/**
 * 此模型表示疾病信息详情。
 *
 * @author 胡海星
 */
public class Disease implements HasInfo, Predefinable, Auditable, Assignable<Disease> {

  private static final long serialVersionUID = -4453251329411749342L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 编码，全局唯一。
   *
   * <p>此编码可以是各机构内部编码，也可以是 ICD-10 国家标准编码，具体取决于应用上下文。
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
   * 所属类别基本信息，按照国家规范对疾病进行分类。
   */
  @Reference(entity = Category.class, property = "info")
  @Nullable
  private InfoWithEntity category;

  /**
   * 描述。
   */
  @Nullable
  private String description;

  /**
   * 详情链接。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String url;

  /**
   * 备注信息。
   */
  @Nullable
  private String comment;

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
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public Disease() {
    // empty
  }

  public Disease(final Disease other) {
    assign(other);
  }

  @Override
  public void assign(final Disease other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    name = other.name;
    category = Assignment.clone(other.category);
    description = other.description;
    url = other.url;
    comment = other.comment;
    predefined = other.predefined;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Disease clone() {
    return new Disease(this);
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
  public InfoWithEntity getCategory() {
    return category;
  }

  public void setCategory(@Nullable final InfoWithEntity category) {
    this.category = category;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  @Nullable
  public String getUrl() {
    return url;
  }

  public void setUrl(@Nullable final String url) {
    this.url = url;
  }

  @Nullable
  public String getComment() {
    return comment;
  }

  public void setComment(@Nullable final String comment) {
    this.comment = comment;
  }

  @Override
  public Boolean isPredefined() {
    return predefined;
  }

  @Override
  public void setPredefined(final Boolean predefined) {
    this.predefined = predefined;
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
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Disease other = (Disease) o;
    return Equality.equals(predefined, other.predefined)
            && Equality.equals(id, other.id)
            && Equality.equals(code, other.code)
            && Equality.equals(name, other.name)
            && Equality.equals(category, other.category)
            && Equality.equals(description, other.description)
            && Equality.equals(url, other.url)
            && Equality.equals(comment, other.comment)
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
    result = Hash.combine(result, multiplier, category);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, url);
    result = Hash.combine(result, multiplier, comment);
    result = Hash.combine(result, multiplier, predefined);
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
            .append("category", category)
            .append("description", description)
            .append("url", url)
            .append("comment", comment)
            .append("predefined", predefined)
            .append("createTime", createTime)
            .append("modifyTime", modifyTime)
            .append("deleteTime", deleteTime)
            .toString();
  }
}
