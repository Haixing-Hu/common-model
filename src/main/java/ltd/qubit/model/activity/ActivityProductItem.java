////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.activity;

import java.io.Serializable;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.product.Product;
import ltd.qubit.model.product.ProductInfo;
import ltd.qubit.model.util.Creatable;
import ltd.qubit.model.util.Deletable;

/**
 * 此模型表示一条活动的商品项记录。
 *
 * <p>每条记录只能对应一项商品。
 *
 * @author 潘凯，胡海星
 */
public class ActivityProductItem implements Serializable, Creatable, Deletable,
    Assignable<ActivityProductItem> {

  private static final long serialVersionUID = 5367590072413421498L;

  /**
   * 所属活动ID。
   */
  @Reference(entity = Activity.class, property = "id")
  private Long activityId;

  /**
   * 此商品项在列表中的下标索引。
   */
  private Integer index;

  /**
   * 此商品项对应的商品的基本信息。
   */
  @Reference(entity = Product.class, property = "info")
  private ProductInfo product;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public ActivityProductItem() {
    // empty
  }

  public ActivityProductItem(final ActivityProductItem other) {
    assign(other);
  }

  @Override
  public void assign(final ActivityProductItem other) {
    Argument.requireNonNull("other", other);
    activityId = other.activityId;
    index = other.index;
    product = Assignment.clone(other.product);
    createTime = other.createTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public ActivityProductItem clone() {
    return new ActivityProductItem(this);
  }

  public Long getActivityId() {
    return activityId;
  }

  public void setActivityId(final Long activityId) {
    this.activityId = activityId;
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex(final Integer index) {
    this.index = index;
  }

  public ProductInfo getProduct() {
    return product;
  }

  public void setProduct(final ProductInfo product) {
    this.product = product;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
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
    final ActivityProductItem other = (ActivityProductItem) o;
    return Equality.equals(activityId, other.activityId)
        && Equality.equals(index, other.index)
        && Equality.equals(product, other.product)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, activityId);
    result = Hash.combine(result, multiplier, index);
    result = Hash.combine(result, multiplier, product);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("activityId", activityId)
        .append("index", index)
        .append("product", product)
        .append("createTime", createTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
