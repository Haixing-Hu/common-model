////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.service;

import java.io.Serializable;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 此模型表示医疗服务包中的医疗服务项信息。
 *
 * @author 王佳
 */
public class MedicalPackageItem implements Serializable,
    Assignable<MedicalPackageItem> {

  private static final long serialVersionUID = -4408178686288775954L;

  /**
   * 所属服务包的ID。
   */
  @Reference(entity = MedicalPackage.class, property = "id")
  private Long packageId;

  /**
   * 服务项目。
   */
  @Reference(entity = MedicalItem.class)
  private MedicalItem item;

  /**
   * 服务项目的数量。
   */
  private Integer count = 0;

  public MedicalPackageItem() {
    // empty
  }

  public MedicalPackageItem(final MedicalPackageItem other) {
    assign(other);
  }

  @Override
  public void assign(final MedicalPackageItem other) {
    Argument.requireNonNull("other", other);
    packageId = other.packageId;
    item = Assignment.clone(other.item);
    count = other.count;
  }

  @Override
  public MedicalPackageItem clone() {
    return new MedicalPackageItem(this);
  }

  public Long getPackageId() {
    return packageId;
  }

  public void setPackageId(final Long packageId) {
    this.packageId = packageId;
  }

  public MedicalItem getItem() {
    return item;
  }

  public void setItem(final MedicalItem item) {
    this.item = item;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(final Integer count) {
    this.count = count;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final MedicalPackageItem other = (MedicalPackageItem) o;
    return Equality.equals(packageId, other.packageId)
        && Equality.equals(item, other.item)
        && Equality.equals(count, other.count);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, packageId);
    result = Hash.combine(result, multiplier, item);
    result = Hash.combine(result, multiplier, count);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("packageId", packageId)
        .append("item", item)
        .append("count", count)
        .toString();
  }
}
