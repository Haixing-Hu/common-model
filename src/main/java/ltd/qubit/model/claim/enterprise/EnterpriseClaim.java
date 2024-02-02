////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim.enterprise;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.claim.AccidentReason;
import ltd.qubit.model.claim.InsuredStatus;
import ltd.qubit.model.claim.QuickCompensationState;
import ltd.qubit.model.commons.KinshipType;
import ltd.qubit.model.order.Client;
import ltd.qubit.model.product.Product;
import ltd.qubit.model.upload.Attachment;
import ltd.qubit.model.util.Creatable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Modifiable;

import static ltd.qubit.model.claim.enterprise.EnterpriseClaimStatus.CLAIM_APPLICATION_AUDITED;
import static ltd.qubit.model.claim.enterprise.EnterpriseClaimStatus.CLAIM_APPLICATION_WAIT_AUDIT;
import static ltd.qubit.model.claim.enterprise.EnterpriseClaimStatus.NOT_SUBMITTED;
import static ltd.qubit.model.claim.enterprise.EnterpriseClaimStatus.SYSTEM_REJECTED;
import static ltd.qubit.model.claim.enterprise.EnterpriseClaimStatus.TEMPORARY_SAVED;

/**
 * 此模型表示企业保险理赔。
 *
 * @author 潘凯
 */
public class EnterpriseClaim implements Identifiable, Creatable, Modifiable, Assignable<EnterpriseClaim> {

  private static final long serialVersionUID = -7385849171812489650L;

  private static final Logger LOGGER = LoggerFactory.getLogger(EnterpriseClaim.class);

  /**
   * 内部ID，全局唯一，亦作为理赔流水号。
   */
  @Identifier
  private Long id;

  /**
   * 理赔产品。
   */
  private Product product;

  /**
   * 出险原因。
   */
  private AccidentReason reason;

  /**
   * 出险人状态。
   */
  private InsuredStatus insuredStatus;

  /**
   * 出险人。
   */
  private Client insured;

  /**
   * 报案人与出险人关系。
   */
  private KinshipType claimantRelation;

  /**
   * 报案人。
   */
  private Client claimant;

  /**
   * 报案发起时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant issueTime;

  /**
   * 报案取消时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant cancelTime;

  /**
   * 报案完成时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant completeTime;

  /**
   * 理赔状态。
   */
  private EnterpriseClaimStatus status;

  /**
   * 理赔状态。
   */
  private EnterpriseClaimStatusGroup statusGroup;

  /**
   * 备忘录。
   */
  private String notes;

  /**
   * 快赔状态。
   */
  private QuickCompensationState quickCompensationState;

  /**
   * 理赔申请事件集合。
   */
  private List<EnterpriseClaimEvent> events;

  /**
   * 理赔附件资料。
   */
  private List<Attachment> attachmentList;

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

  public EnterpriseClaim() {
    // empty
  }

  public EnterpriseClaim(final EnterpriseClaim other) {
    assign(other);
  }

  @Override
  public void assign(final EnterpriseClaim other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    product = Assignment.clone(other.product);
    reason = other.reason;
    insuredStatus = other.insuredStatus;
    insured = Assignment.clone(other.insured);
    claimantRelation = other.claimantRelation;
    claimant = Assignment.clone(other.claimant);
    issueTime = other.issueTime;
    cancelTime = other.cancelTime;
    completeTime = other.completeTime;
    status = other.status;
    statusGroup = other.statusGroup;
    notes = other.notes;
    quickCompensationState = other.quickCompensationState;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    events = Assignment.deepClone(other.events);
    attachmentList = Assignment.deepClone(other.attachmentList);
  }

  @Override
  public EnterpriseClaim clone() {
    return new EnterpriseClaim(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(final Product product) {
    this.product = product;
  }

  public AccidentReason getReason() {
    return reason;
  }

  public void setReason(final AccidentReason reason) {
    this.reason = reason;
  }

  public InsuredStatus getInsuredStatus() {
    return insuredStatus;
  }

  public void setInsuredStatus(final InsuredStatus insuredStatus) {
    this.insuredStatus = insuredStatus;
  }

  public Client getInsured() {
    return insured;
  }

  public void setInsured(final Client insured) {
    this.insured = insured;
  }

  public KinshipType getClaimantRelation() {
    return claimantRelation;
  }

  public void setClaimantRelation(final KinshipType claimantRelation) {
    this.claimantRelation = claimantRelation;
  }

  public Client getClaimant() {
    return claimant;
  }

  public void setClaimant(final Client claimant) {
    this.claimant = claimant;
  }

  @Nullable
  public Instant getIssueTime() {
    return issueTime;
  }

  public void setIssueTime(@Nullable final Instant issueTime) {
    this.issueTime = issueTime;
  }

  @Nullable
  public Instant getCancelTime() {
    return cancelTime;
  }

  public void setCancelTime(@Nullable final Instant cancelTime) {
    this.cancelTime = cancelTime;
  }

  @Nullable
  public Instant getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(@Nullable final Instant completeTime) {
    this.completeTime = completeTime;
  }

  public EnterpriseClaimStatus getStatus() {
    return status;
  }

  public void setStatus(final EnterpriseClaimStatus status) {
    this.status = status;
  }

  public EnterpriseClaimStatusGroup getStatusGroup() {
    return statusGroup;
  }

  public void setStatusGroup(final EnterpriseClaimStatusGroup statusGroup) {
    this.statusGroup = statusGroup;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(final String notes) {
    this.notes = notes;
  }

  public QuickCompensationState getQuickCompensationState() {
    return quickCompensationState;
  }

  public void setQuickCompensationState(final QuickCompensationState quickCompensationState) {
    this.quickCompensationState = quickCompensationState;
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

  public List<EnterpriseClaimEvent> getEvents() {
    return events;
  }

  public void setEvents(final List<EnterpriseClaimEvent> events) {
    this.events = events;
  }

  public List<Attachment> getAttachmentList() {
    return attachmentList;
  }

  public void setAttachmentList(final List<Attachment> attachmentList) {
    this.attachmentList = attachmentList;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final EnterpriseClaim other = (EnterpriseClaim) o;
    return Equality.equals(id, other.id)
        && Equality.equals(product, other.product)
        && Equality.equals(reason, other.reason)
        && Equality.equals(insuredStatus, other.insuredStatus)
        && Equality.equals(insured, other.insured)
        && Equality.equals(claimantRelation, other.claimantRelation)
        && Equality.equals(claimant, other.claimant)
        && Equality.equals(issueTime, other.issueTime)
        && Equality.equals(cancelTime, other.cancelTime)
        && Equality.equals(completeTime, other.completeTime)
        && Equality.equals(status, other.status)
        && Equality.equals(statusGroup, other.statusGroup)
        && Equality.equals(notes, other.notes)
        && Equality.equals(quickCompensationState, other.quickCompensationState)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(events, other.events)
        && Equality.equals(attachmentList, other.attachmentList);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, product);
    result = Hash.combine(result, multiplier, reason);
    result = Hash.combine(result, multiplier, insuredStatus);
    result = Hash.combine(result, multiplier, insured);
    result = Hash.combine(result, multiplier, claimantRelation);
    result = Hash.combine(result, multiplier, claimant);
    result = Hash.combine(result, multiplier, issueTime);
    result = Hash.combine(result, multiplier, cancelTime);
    result = Hash.combine(result, multiplier, completeTime);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, statusGroup);
    result = Hash.combine(result, multiplier, notes);
    result = Hash.combine(result, multiplier, quickCompensationState);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, events);
    result = Hash.combine(result, multiplier, attachmentList);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("product", product)
        .append("reason", reason)
        .append("insuredStatus", insuredStatus)
        .append("insured", insured)
        .append("claimantRelation", claimantRelation)
        .append("claimant", claimant)
        .append("issueTime", issueTime)
        .append("cancelTime", cancelTime)
        .append("completeTime", completeTime)
        .append("status", status)
        .append("statusGroup", statusGroup)
        .append("notes", notes)
        .append("quickCompensationState", quickCompensationState)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("events", events)
        .append("attachmentList", attachmentList)
        .toString();
  }
  //
  // /**
  //  * 检查此对象各字段合法性。
  //  */
  // public void checkField() {
  //   // 1. 检查产品信息不能为空
  //   if (product == null) {
  //     throw new NullFieldException("product");
  //   }
  //   if (StringUtils.isBlank(product.getCode())) {
  //     throw new NullFieldException("code");
  //   }
  //   // 2. 检查出险原因不能为空
  //   if (reason == null) {
  //     throw new NullFieldException("reason");
  //   }
  //   // 3. 检查出险人信息不能为空
  //   if (insured == null) {
  //     throw new NullFieldException("insured");
  //   }
  //   // 检查出险人的基本信息，包括姓名、证件信息、手机号
  //   insured.checkBaseField();
  //   // 4. 检查报案人与出险人的关系不能为空
  //   if (claimantRelation == null) {
  //     throw new NullFieldException("kinshipType");
  //   }
  //   // 5. 检查报案人信息不能为空
  //   if (claimant == null) {
  //     throw new NullFieldException("claimant");
  //   }
  //   // 检查报案人的基本信息，包括姓名、证件信息、手机号
  //   claimant.checkBaseField();
  // }

  /**
   * 检查是否允许用户操作。
   */
  public boolean allowClientOperation() {
    // 当理赔申请状态为未提交或者已驳回时，允许用户进行操作
    return this.status == NOT_SUBMITTED || this.status == SYSTEM_REJECTED;
  }

  /**
   * 检查是否允许驳回给用户。
   */
  public boolean allowReject() {
    // 当理赔申请状态为待审核索赔申请书、索赔申请书审核通过、待复核、暂存、保司驳回这几种状态时，允许驳回给用户
    return this.status == CLAIM_APPLICATION_WAIT_AUDIT
        || this.status == CLAIM_APPLICATION_AUDITED
        || this.status == TEMPORARY_SAVED;
  }

  /**
   * 检查是否允许审核人员操作。
   */
  public boolean allowAdminOperation() {
    // 当理赔申请状态为索赔申请书审核通过、暂存、保司驳回这几种状态时，允许审核人员操作
    return this.status == CLAIM_APPLICATION_AUDITED
        || this.status == TEMPORARY_SAVED;
  }
}
