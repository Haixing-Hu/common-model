////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示保险产品规则。
 *
 * @author 潘凯
 */
public class InsuranceProductRule implements Identifiable, Auditable,
    Assignable<InsuranceProductRule> {

  private static final long serialVersionUID = -4843310121195220850L;

  /**
   * 内部ID，全局唯一，亦作为理赔流水号。
   */
  @Identifier
  private Long id;

  /**
   * 理赔产品。
   */
  private Info product;

  /**
   * 产品规则key。
   */
  private String key;

  /**
   * 产品规则value。
   */
  private String value;

  /**
   * 产品规则的描述。
   */
  private String description;

  /**
   * 创建时间，即提交时间。
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

  public InsuranceProductRule() {
    // empty
  }

  public InsuranceProductRule(final InsuranceProductRule other) {
    assign(other);
  }

  @Override
  public void assign(final InsuranceProductRule other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    product = Assignment.clone(other.product);
    key = other.key;
    value = other.value;
    description = other.description;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public InsuranceProductRule clone() {
    return new InsuranceProductRule(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Info getProduct() {
    return product;
  }

  public void setProduct(final Info product) {
    this.product = product;
  }

  public String getKey() {
    return key;
  }

  public void setKey(final String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
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

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final InsuranceProductRule other = (InsuranceProductRule) o;
    return Equality.equals(id, other.id)
        && Equality.equals(product, other.product)
        && Equality.equals(key, other.key)
        && Equality.equals(value, other.value)
        && Equality.equals(description, other.description)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, product);
    result = Hash.combine(result, multiplier, key);
    result = Hash.combine(result, multiplier, value);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("product", product)
        .append("key", key)
        .append("value", value)
        .append("description", description)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
