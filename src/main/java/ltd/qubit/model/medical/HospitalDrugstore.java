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
 * 此模型表示医院、药店的关联关系。
 *
 * @author 孙建，胡海星
 */
public class HospitalDrugstore implements Identifiable, Auditable,
    Assignable<HospitalDrugstore> {

  private static final long serialVersionUID = -8506958672144950976L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 医院信息。
   */
  private Info hospital;

  /**
   * 药店信息。
   */
  private Info drugstore;

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

  public HospitalDrugstore() {
    // empty
  }

  public HospitalDrugstore(final HospitalDrugstore other) {
    assign(other);
  }

  @Override
  public void assign(final HospitalDrugstore other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    hospital = Assignment.clone(other.hospital);
    drugstore = Assignment.clone(other.drugstore);
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public HospitalDrugstore clone() {
    return new HospitalDrugstore(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Info getHospital() {
    return hospital;
  }

  public void setHospital(final Info hospital) {
    this.hospital = hospital;
  }

  public Info getDrugstore() {
    return drugstore;
  }

  public void setDrugstore(final Info drugstore) {
    this.drugstore = drugstore;
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

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final HospitalDrugstore other = (HospitalDrugstore) o;
    return Equality.equals(id, other.id)
            && Equality.equals(hospital, other.hospital)
            && Equality.equals(drugstore, other.drugstore)
            && Equality.equals(createTime, other.createTime)
            && Equality.equals(modifyTime, other.modifyTime)
            && Equality.equals(deleteTime, other.deleteTime);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, hospital);
    result = Hash.combine(result, multiplier, drugstore);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("hospital", hospital)
            .append("drugstore", drugstore)
            .append("createTime", createTime)
            .append("modifyTime", modifyTime)
            .append("deleteTime", deleteTime)
            .toString();
  }
}
