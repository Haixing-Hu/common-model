////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.invoice;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.DictEntryInfo;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;
import ltd.qubit.model.util.WithOrganization;

/**
 * 此模型表示电子票据编号段。
 *
 * @author 孙建，胡海星，徐伟
 */
public class InvoiceNumberSegment implements Identifiable, WithApp,
    WithOrganization, Auditable {

  private static final long serialVersionUID = 4750891328705129371L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所属 App 的基本信息。
   */
  private StatefulInfo app;

  /**
   * 所属机构的基本信息。
   */
  private StatefulInfo organization;

  /**
   * 对应申请单的ID，关联对象{@link InvoiceApply}的{@code id}字段。
   */
  private Long applyId;

  /**
   * 对应申请单（在省平台的）的编号，关联对象{@link InvoiceApply}的{@code number}字段。
   */
  @Size(min = 1, max = 64)
  private String applyNumber;

  /**
   * 电子票据种类，字典项。
   */
  private DictEntryInfo type;

  /**
   * 电子票据代码。
   */
  @Size(min = 1, max = 64)
  private String code;

  /**
   * 电子票据名称。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 电子票据总数。
   */
  private Integer count;

  /**
   * 起始编号（本号段包含此编号）。
   */
  @Size(min = 1, max = 64)
  private String start;

  /**
   * 结束编号（本号段包含此编号）。
   */
  @Size(min = 1, max = 64)
  private String end;

  /**
   * 库存状态。
   */
  private InvoiceStockStatus status;

  /**
   * 备注。
   */
  @Nullable
  private String remark;

  /**
   * 发放时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant dispatchTime;

  /**
   * 作废时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant cancelTime;


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

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public StatefulInfo getApp() {
    return app;
  }

  public void setApp(final StatefulInfo app) {
    this.app = app;
  }

  public StatefulInfo getOrganization() {
    return organization;
  }

  public void setOrganization(final StatefulInfo organization) {
    this.organization = organization;
  }

  public Long getApplyId() {
    return applyId;
  }

  public void setApplyId(final Long applyId) {
    this.applyId = applyId;
  }

  public String getApplyNumber() {
    return applyNumber;
  }

  public void setApplyNumber(final String applyNumber) {
    this.applyNumber = applyNumber;
  }

  public DictEntryInfo getType() {
    return type;
  }

  public void setType(final DictEntryInfo type) {
    this.type = type;
  }

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(final Integer count) {
    this.count = count;
  }

  public String getStart() {
    return start;
  }

  public void setStart(final String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(final String end) {
    this.end = end;
  }

  public InvoiceStockStatus getStatus() {
    return status;
  }

  public void setStatus(final InvoiceStockStatus status) {
    this.status = status;
  }

  @Nullable
  public String getRemark() {
    return remark;
  }

  public void setRemark(@Nullable final String remark) {
    this.remark = remark;
  }

  public Instant getDispatchTime() {
    return dispatchTime;
  }

  public void setDispatchTime(final Instant dispatchTime) {
    this.dispatchTime = dispatchTime;
  }

  public Instant getCancelTime() {
    return cancelTime;
  }

  public void setCancelTime(final Instant cancelTime) {
    this.cancelTime = cancelTime;
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
    final InvoiceNumberSegment other = (InvoiceNumberSegment) o;
    return Equality.equals(id, other.id)
            && Equality.equals(app, other.app)
            && Equality.equals(organization, other.organization)
            && Equality.equals(applyId, other.applyId)
            && Equality.equals(applyNumber, other.applyNumber)
            && Equality.equals(type, other.type)
            && Equality.equals(code, other.code)
            && Equality.equals(name, other.name)
            && Equality.equals(count, other.count)
            && Equality.equals(start, other.start)
            && Equality.equals(end, other.end)
            && Equality.equals(status, other.status)
            && Equality.equals(remark, other.remark)
            && Equality.equals(dispatchTime, other.dispatchTime)
            && Equality.equals(cancelTime, other.cancelTime)
            && Equality.equals(createTime, other.createTime)
            && Equality.equals(modifyTime, other.modifyTime)
            && Equality.equals(deleteTime, other.deleteTime);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, applyId);
    result = Hash.combine(result, multiplier, applyNumber);
    result = Hash.combine(result, multiplier, type);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, count);
    result = Hash.combine(result, multiplier, start);
    result = Hash.combine(result, multiplier, end);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, remark);
    result = Hash.combine(result, multiplier, dispatchTime);
    result = Hash.combine(result, multiplier, cancelTime);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("app", app)
            .append("organization", organization)
            .append("applyId", applyId)
            .append("applyNumber", applyNumber)
            .append("type", type)
            .append("code", code)
            .append("name", name)
            .append("count", count)
            .append("start", start)
            .append("end", end)
            .append("status", status)
            .append("remark", remark)
            .append("dispatchTime", dispatchTime)
            .append("cancelTime", cancelTime)
            .append("createTime", createTime)
            .append("modifyTime", modifyTime)
            .append("deleteTime", deleteTime)
            .toString();
  }
}
