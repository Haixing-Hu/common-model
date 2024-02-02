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
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.commons.DictEntry;
import ltd.qubit.model.commons.DictEntryInfo;
import ltd.qubit.model.organization.Organization;
import ltd.qubit.model.person.User;
import ltd.qubit.model.person.UserInfo;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;
import ltd.qubit.model.util.WithOrganization;

/**
 * 此模型表示电子票据申请单。
 *
 * @author 孙建，胡海星
 */
public class InvoiceApply implements Identifiable, WithApp, WithOrganization,
    Auditable {

  private static final long serialVersionUID = 6647639454544463222L;

  /**
   * 唯一标识，系统自动生成。
   *
   * <p>此字段即提交到省平台的申请业务编码，用于唯一标识一个专用系统的一个申请单；如果系统发生申
   * 请单提交重试，该业务编码要维持一致。
   */
  @Identifier
  private Long id;

  /**
   * 所属 App 的基本信息。
   */
  @Reference(entity = App.class, property = "info")
  private StatefulInfo app;

  /**
   * 所属机构的基本信息。
   */
  @Reference(entity = Organization.class, property = "info")
  private StatefulInfo organization;

  /**
   * 申请用户的基本信息。
   */
  @Reference(entity = User.class, property = "info")
  private UserInfo applicant;

  /**
   * 申请单的类型。
   */
  @Reference(entity = DictEntry.class, property = "info")
  private DictEntryInfo type;

  /**
   * 申请单在省电子票据平台的编号。
   */
  @Size(min = 1, max = 64)
  private String number;

  /**
   * 状态:申请已提交，尚未被审核,申请已被审核并通过,申请已被审核但未通过,申请已被撤销。
   */
  private Integer count;

  /**
   * 申请状态。
   */
  private InvoiceApplyStatus status;

  /**
   * 申请备注。
   */
  @Nullable
  private String applyRemark;

  /**
   * 撤销申请备注。
   */
  @Nullable
  private String cancelRemark;

  /**
   * 审批申请备注。
   */
  @Nullable
  private String approveRemark;

  /**
   * 申请发起时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant applyTime;

  /**
   * 申请撤销时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant cancelTime;

  /**
   * 申请审批时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant approveTime;

  /**
   * 记录创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;


  /**
   * 记录最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 记录标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public InvoiceApply() {
    // empty
  }

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

  public UserInfo getApplicant() {
    return applicant;
  }

  public void setApplicant(final UserInfo applicant) {
    this.applicant = applicant;
  }

  public DictEntryInfo getType() {
    return type;
  }

  public void setType(final DictEntryInfo type) {
    this.type = type;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(final Integer count) {
    this.count = count;
  }

  public InvoiceApplyStatus getStatus() {
    return status;
  }

  public void setStatus(final InvoiceApplyStatus status) {
    this.status = status;
  }

  @Nullable
  public String getApplyRemark() {
    return applyRemark;
  }

  public void setApplyRemark(@Nullable final String applyRemark) {
    this.applyRemark = applyRemark;
  }

  @Nullable
  public String getCancelRemark() {
    return cancelRemark;
  }

  public void setCancelRemark(@Nullable final String cancelRemark) {
    this.cancelRemark = cancelRemark;
  }

  @Nullable
  public String getApproveRemark() {
    return approveRemark;
  }

  public void setApproveRemark(@Nullable final String approveRemark) {
    this.approveRemark = approveRemark;
  }

  public Instant getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(final Instant applyTime) {
    this.applyTime = applyTime;
  }

  @Nullable
  public Instant getCancelTime() {
    return cancelTime;
  }

  public void setCancelTime(@Nullable final Instant cancelTime) {
    this.cancelTime = cancelTime;
  }

  @Nullable
  public Instant getApproveTime() {
    return approveTime;
  }

  public void setApproveTime(@Nullable final Instant approveTime) {
    this.approveTime = approveTime;
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
    final InvoiceApply other = (InvoiceApply) o;
    return Equality.equals(id, other.id)
        && Equality.equals(app, other.app)
        && Equality.equals(organization, other.organization)
        && Equality.equals(applicant, other.applicant)
        && Equality.equals(type, other.type)
        && Equality.equals(number, other.number)
        && Equality.equals(count, other.count)
        && Equality.equals(status, other.status)
        && Equality.equals(applyRemark, other.applyRemark)
        && Equality.equals(cancelRemark, other.cancelRemark)
        && Equality.equals(approveRemark, other.approveRemark)
        && Equality.equals(applyTime, other.applyTime)
        && Equality.equals(cancelTime, other.cancelTime)
        && Equality.equals(approveTime, other.approveTime)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, applicant);
    result = Hash.combine(result, multiplier, type);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, count);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, applyRemark);
    result = Hash.combine(result, multiplier, cancelRemark);
    result = Hash.combine(result, multiplier, approveRemark);
    result = Hash.combine(result, multiplier, applyTime);
    result = Hash.combine(result, multiplier, cancelTime);
    result = Hash.combine(result, multiplier, approveTime);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("app", app)
        .append("organization", organization)
        .append("applicant", applicant)
        .append("type", type)
        .append("number", number)
        .append("count", count)
        .append("status", status)
        .append("applyRemark", applyRemark)
        .append("cancelRemark", cancelRemark)
        .append("approveRemark", approveRemark)
        .append("applyTime", applyTime)
        .append("cancelTime", cancelTime)
        .append("approveTime", approveTime)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
