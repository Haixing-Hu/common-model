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
import java.util.List;
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
import ltd.qubit.model.organization.EmployeeInfo;
import ltd.qubit.model.security.Signature;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示电子处方单。
 *
 * <p><b>参考资料：</b>
 * <ul>
 * <li>【WS 445.3-2014】电子病历基本数据集 第3部分：门（急）症处方</li>
 * <li>【WS/T 500.4-2016】电子病历共享文档规范 第4部分：西药处方</li>
 * <li>【WS/T 500.5-2016】电子病历共享文档规范 第5部分：中药处方</li>
 * <li><a href="http://www.termonline.cn/">术语在线</a></li>
 * </ul>
 *
 * @author 胡海星
 */
public class Prescription implements Identifiable, Auditable,
        Assignable<Prescription> {

  private static final long serialVersionUID = 4821864704997056192L;

  /**
   * 记录在系统中的ID，唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 处方单具体内容。
   *
   * <p>将{@link PrescriptionContent}从{@link Prescription}中抽象出一个单独对象，
   * 是为了方便对处方单内容进行数字签名和校验。
   */
  private PrescriptionContent content;

  /**
   * 院内复核药师。
   */
  @Nullable
  private EmployeeInfo auditor;

  /**
   * 第三方复核药师。
   */
  @Nullable
  private EmployeeInfo inspector;

  /**
   * 药房配药药师。
   */
  @Nullable
  private EmployeeInfo pharmacist;

  /**
   * 药房复核药师。
   */
  @Nullable
  private EmployeeInfo reviewer;

  /**
   * 药房发药药师。
   */
  @Nullable
  private EmployeeInfo consignor;

  /**
   * 对处方单内容的数字签名。
   *
   * <p>里面可能包含了院内开方医师、院内审方药师、第三方审方药师、药房配药师、药房
   * 复核药师、药房发药师、患者等对处方在流转过程中各个事件的数字签名。
   */
  @Nullable
  private List<Signature> signatures;

  /**
   * 状态。
   */
  private PrescriptionStatus status;

  /**
   * 该处方单所对应的订单的ID。注意一个订单可能包含多个处方单。
   */
  @Nullable
  private Long orderId;

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

  public Prescription() {
    // empty
  }

  public Prescription(final Prescription other) {
    assign(other);
  }

  @Override
  public void assign(final Prescription other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    content = Assignment.clone(other.content);
    auditor = Assignment.clone(other.auditor);
    inspector = Assignment.clone(other.inspector);
    pharmacist = Assignment.clone(other.pharmacist);
    reviewer = Assignment.clone(other.reviewer);
    consignor = Assignment.clone(other.consignor);
    signatures = Assignment.deepClone(other.signatures);
    status = other.status;
    orderId = other.orderId;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Prescription clone() {
    return new Prescription(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public PrescriptionContent getContent() {
    return content;
  }

  public void setContent(final PrescriptionContent content) {
    this.content = content;
  }

  @Nullable
  public EmployeeInfo getAuditor() {
    return auditor;
  }

  public void setAuditor(@Nullable final EmployeeInfo auditor) {
    this.auditor = auditor;
  }

  @Nullable
  public EmployeeInfo getInspector() {
    return inspector;
  }

  public void setInspector(@Nullable final EmployeeInfo inspector) {
    this.inspector = inspector;
  }

  @Nullable
  public EmployeeInfo getPharmacist() {
    return pharmacist;
  }

  public void setPharmacist(@Nullable final EmployeeInfo pharmacist) {
    this.pharmacist = pharmacist;
  }

  @Nullable
  public EmployeeInfo getReviewer() {
    return reviewer;
  }

  public void setReviewer(@Nullable final EmployeeInfo reviewer) {
    this.reviewer = reviewer;
  }

  @Nullable
  public EmployeeInfo getConsignor() {
    return consignor;
  }

  public void setConsignor(@Nullable final EmployeeInfo consignor) {
    this.consignor = consignor;
  }

  @Nullable
  public List<Signature> getSignatures() {
    return signatures;
  }

  public void setSignatures(@Nullable final List<Signature> signatures) {
    this.signatures = signatures;
  }

  public PrescriptionStatus getStatus() {
    return status;
  }

  public void setStatus(final PrescriptionStatus status) {
    this.status = status;
  }

  @Nullable
  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(@Nullable final Long orderId) {
    this.orderId = orderId;
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
    final Prescription other = (Prescription) o;
    return Equality.equals(id, other.id)
        && Equality.equals(content, other.content)
        && Equality.equals(auditor, other.auditor)
        && Equality.equals(inspector, other.inspector)
        && Equality.equals(pharmacist, other.pharmacist)
        && Equality.equals(reviewer, other.reviewer)
        && Equality.equals(consignor, other.consignor)
        && Equality.equals(signatures, other.signatures)
        && Equality.equals(status, other.status)
        && Equality.equals(orderId, other.orderId)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, content);
    result = Hash.combine(result, multiplier, auditor);
    result = Hash.combine(result, multiplier, inspector);
    result = Hash.combine(result, multiplier, pharmacist);
    result = Hash.combine(result, multiplier, reviewer);
    result = Hash.combine(result, multiplier, consignor);
    result = Hash.combine(result, multiplier, signatures);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, orderId);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("content", content)
        .append("auditor", auditor)
        .append("inspector", inspector)
        .append("pharmacist", pharmacist)
        .append("reviewer", reviewer)
        .append("consignor", consignor)
        .append("signatures", signatures)
        .append("status", status)
        .append("orderId", orderId)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
