////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.pair.KeyValuePairList;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.commons.KinshipType;
import ltd.qubit.model.contact.Address;
import ltd.qubit.model.order.Client;
import ltd.qubit.model.payment.Account;
import ltd.qubit.model.product.Product;
import ltd.qubit.model.upload.Attachment;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示保险理赔。
 *
 * @author 潘凯
 */
public class InsuranceClaim implements Identifiable, Auditable,
    Assignable<InsuranceClaim> {

  private static final long serialVersionUID = 1399012628123145140L;

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
   * 承保的保险公司。
   */
  private Info company;

  /**
   * 数据来源。
   */
  private Info source;

  /**
   * 出险原因。
   */
  private AccidentReason reason;

  /**
   * 保单号。
   */
  private String policyNumber;

  /**
   * 出险人。
   */
  private Client insured;

  /**
   * 出险人地址。
   */
  @Nullable
  private Address insuredAddress;

  /**
   * 出险人状态。
   */
  @Nullable
  private InsuredStatus insuredStatus;

  /**
   * 报案人与出险人关系。
   */
  private KinshipType claimantRelation;

  /**
   * 报案人。
   */
  private Client claimant;

  /**
   * 报案人地址。
   */
  @Nullable
  private Address claimantAddress;

  /**
   * 出险日期。
   */
  private LocalDate accidentDate;

  /**
   * 出险地点。
   */
  private String accidentPlace;

  /**
   * 出险说明。
   */
  private String accidentDescription;

  /**
   * 就诊医院。
   */
  @Nullable
  private Info hospital;

  /**
   * 最后一次治疗/就诊/住院开始日期。
   */
  @Nullable
  private LocalDate treatmentStartDate;

  /**
   * 最后一次治疗/就诊/住院结束日期。
   */
  @Nullable
  private LocalDate treatmentEndDate;

  /**
   * 快赔状态。
   */
  private QuickCompensationState quickCompensationState;

  /**
   * 发票币种。
   */
  @Nullable
  private Currency currency;

  /**
   * 报案总金额。
   */
  @Money
  @Nullable
  private BigDecimal totalPaidAmount;

  /**
   * 领款人姓名。
   */
  private String payeeName;

  /**
   * 账户信息。
   */
  private Account account;

  /**
   * 报案登记号。
   */
  private String number;

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
  private InsuranceClaimStatus status;

  /**
   * 理赔状态。
   */
  private InsuranceClaimStatusGroup statusGroup;

  /**
   * 备忘录。
   */
  private String notes;

  /**
   * 理赔申请的额外参数。
   */
  @Size(min = 1, max = 8)
  @Nullable
  private KeyValuePairList payload;

  /**
   * 理赔附件资料。
   */
  private List<Attachment> attachmentList;

  /**
   * 最新的一条理赔申请事件。
   */
  private List<InsuranceClaimEvent> events;

  /**
   * 就诊记录列表。
   */
  private List<InsuranceClaimMedical> medicalList;

  /**
   * 已保存的发票列表。
   */
  private List<InsuranceClaimInvoice> savedInvoices;

  /**
   * 理赔金额。
   */
  private InsuranceClaimAmount amount;

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

  public InsuranceClaim() {
    // empty
  }

  public InsuranceClaim(final InsuranceClaim other) {
    assign(other);
  }

  @Override
  public void assign(final InsuranceClaim other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    product = Assignment.clone(other.product);
    company = Assignment.clone(other.company);
    source = Assignment.clone(other.source);
    reason = other.reason;
    policyNumber = other.policyNumber;
    insured = Assignment.clone(other.insured);
    insuredAddress = Assignment.clone(other.insuredAddress);
    insuredStatus = other.insuredStatus;
    claimantRelation = other.claimantRelation;
    claimant = Assignment.clone(other.claimant);
    claimantAddress = Assignment.clone(other.claimantAddress);
    accidentDate = other.accidentDate;
    accidentPlace = other.accidentPlace;
    accidentDescription = other.accidentDescription;
    hospital = Assignment.clone(other.hospital);
    treatmentStartDate = other.treatmentStartDate;
    treatmentEndDate = other.treatmentEndDate;
    quickCompensationState = other.quickCompensationState;
    currency = other.currency;
    totalPaidAmount = other.totalPaidAmount;
    payeeName = other.payeeName;
    account = Assignment.clone(other.account);
    number = other.number;
    issueTime = other.issueTime;
    cancelTime = other.cancelTime;
    completeTime = other.completeTime;
    status = other.status;
    statusGroup = other.statusGroup;
    notes = other.notes;
    payload = Assignment.clone(other.payload);
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
    attachmentList = Assignment.deepClone(other.attachmentList);
    events = Assignment.deepClone(other.events);
    medicalList = Assignment.deepClone(other.medicalList);
    savedInvoices = Assignment.deepClone(other.savedInvoices);
    amount = Assignment.clone(other.amount);
  }

  @Override
  public InsuranceClaim clone() {
    return new InsuranceClaim(this);
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

  public Info getCompany() {
    return company;
  }

  public void setCompany(final Info company) {
    this.company = company;
  }

  public Info getSource() {
    return source;
  }

  public void setSource(final Info source) {
    this.source = source;
  }

  public AccidentReason getReason() {
    return reason;
  }

  public void setReason(final AccidentReason reason) {
    this.reason = reason;
  }

  public String getPolicyNumber() {
    return policyNumber;
  }

  public void setPolicyNumber(final String policyNumber) {
    this.policyNumber = policyNumber;
  }

  public Client getInsured() {
    return insured;
  }

  public void setInsured(final Client insured) {
    this.insured = insured;
  }

  @Nullable
  public Address getInsuredAddress() {
    return insuredAddress;
  }

  public void setInsuredAddress(@Nullable final Address insuredAddress) {
    this.insuredAddress = insuredAddress;
  }

  @Nullable
  public InsuredStatus getInsuredStatus() {
    return insuredStatus;
  }

  public void setInsuredStatus(@Nullable final InsuredStatus insuredStatus) {
    this.insuredStatus = insuredStatus;
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
  public Address getClaimantAddress() {
    return claimantAddress;
  }

  public void setClaimantAddress(@Nullable final Address claimantAddress) {
    this.claimantAddress = claimantAddress;
  }

  public LocalDate getAccidentDate() {
    return accidentDate;
  }

  public void setAccidentDate(final LocalDate accidentDate) {
    this.accidentDate = accidentDate;
  }

  public String getAccidentPlace() {
    return accidentPlace;
  }

  public void setAccidentPlace(final String accidentPlace) {
    this.accidentPlace = accidentPlace;
  }

  public String getAccidentDescription() {
    return accidentDescription;
  }

  public void setAccidentDescription(final String accidentDescription) {
    this.accidentDescription = accidentDescription;
  }

  @Nullable
  public Info getHospital() {
    return hospital;
  }

  public void setHospital(@Nullable final Info hospital) {
    this.hospital = hospital;
  }

  @Nullable
  public LocalDate getTreatmentStartDate() {
    return treatmentStartDate;
  }

  public void setTreatmentStartDate(@Nullable final LocalDate treatmentStartDate) {
    this.treatmentStartDate = treatmentStartDate;
  }

  @Nullable
  public LocalDate getTreatmentEndDate() {
    return treatmentEndDate;
  }

  public void setTreatmentEndDate(@Nullable final LocalDate treatmentEndDate) {
    this.treatmentEndDate = treatmentEndDate;
  }

  public QuickCompensationState getQuickCompensationState() {
    return quickCompensationState;
  }

  public void setQuickCompensationState(final QuickCompensationState quickCompensationState) {
    this.quickCompensationState = quickCompensationState;
  }

  @Nullable
  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(@Nullable final Currency currency) {
    this.currency = currency;
  }

  @Nullable
  public BigDecimal getTotalPaidAmount() {
    return totalPaidAmount;
  }

  public void setTotalPaidAmount(@Nullable final BigDecimal totalPaidAmount) {
    this.totalPaidAmount = totalPaidAmount;
  }

  public String getPayeeName() {
    return payeeName;
  }

  public void setPayeeName(final String payeeName) {
    this.payeeName = payeeName;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(final Account account) {
    this.account = account;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
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

  public InsuranceClaimStatus getStatus() {
    return status;
  }

  public void setStatus(final InsuranceClaimStatus status) {
    this.status = status;
  }

  public InsuranceClaimStatusGroup getStatusGroup() {
    return statusGroup;
  }

  public void setStatusGroup(final InsuranceClaimStatusGroup statusGroup) {
    this.statusGroup = statusGroup;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(final String notes) {
    this.notes = notes;
  }

  @Nullable
  public KeyValuePairList getPayload() {
    return payload;
  }

  public void setPayload(@Nullable final KeyValuePairList payload) {
    this.payload = payload;
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

  public List<Attachment> getAttachmentList() {
    return attachmentList;
  }

  public void setAttachmentList(final List<Attachment> attachmentList) {
    this.attachmentList = attachmentList;
  }

  public List<InsuranceClaimEvent> getEvents() {
    return events;
  }

  public void setEvents(final List<InsuranceClaimEvent> events) {
    this.events = events;
  }

  public List<InsuranceClaimMedical> getMedicalList() {
    return medicalList;
  }

  public void setMedicalList(final List<InsuranceClaimMedical> medicalList) {
    this.medicalList = medicalList;
  }

  public List<InsuranceClaimInvoice> getSavedInvoices() {
    return savedInvoices;
  }

  public void setSavedInvoices(final List<InsuranceClaimInvoice> savedInvoices) {
    this.savedInvoices = savedInvoices;
  }

  public InsuranceClaimAmount getAmount() {
    return amount;
  }

  public void setAmount(final InsuranceClaimAmount amount) {
    this.amount = amount;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final InsuranceClaim other = (InsuranceClaim) o;
    return Equality.equals(id, other.id)
        && Equality.equals(product, other.product)
        && Equality.equals(company, other.company)
        && Equality.equals(source, other.source)
        && Equality.equals(reason, other.reason)
        && Equality.equals(policyNumber, other.policyNumber)
        && Equality.equals(insured, other.insured)
        && Equality.equals(insuredAddress, other.insuredAddress)
        && Equality.equals(insuredStatus, other.insuredStatus)
        && Equality.equals(claimantRelation, other.claimantRelation)
        && Equality.equals(claimant, other.claimant)
        && Equality.equals(claimantAddress, other.claimantAddress)
        && Equality.equals(accidentDate, other.accidentDate)
        && Equality.equals(accidentPlace, other.accidentPlace)
        && Equality.equals(accidentDescription, other.accidentDescription)
        && Equality.equals(hospital, other.hospital)
        && Equality.equals(treatmentStartDate, other.treatmentStartDate)
        && Equality.equals(treatmentEndDate, other.treatmentEndDate)
        && Equality.equals(quickCompensationState, other.quickCompensationState)
        && Equality.equals(currency, other.currency)
        && Equality.equals(totalPaidAmount, other.totalPaidAmount)
        && Equality.equals(payeeName, other.payeeName)
        && Equality.equals(account, other.account)
        && Equality.equals(number, other.number)
        && Equality.equals(issueTime, other.issueTime)
        && Equality.equals(cancelTime, other.cancelTime)
        && Equality.equals(completeTime, other.completeTime)
        && Equality.equals(status, other.status)
        && Equality.equals(statusGroup, other.statusGroup)
        && Equality.equals(notes, other.notes)
        && Equality.equals(payload, other.payload)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime)
        && Equality.equals(attachmentList, other.attachmentList)
        && Equality.equals(events, other.events)
        && Equality.equals(medicalList, other.medicalList)
        && Equality.equals(savedInvoices, other.savedInvoices)
        && Equality.equals(amount, other.amount);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, product);
    result = Hash.combine(result, multiplier, company);
    result = Hash.combine(result, multiplier, source);
    result = Hash.combine(result, multiplier, reason);
    result = Hash.combine(result, multiplier, policyNumber);
    result = Hash.combine(result, multiplier, insured);
    result = Hash.combine(result, multiplier, insuredAddress);
    result = Hash.combine(result, multiplier, insuredStatus);
    result = Hash.combine(result, multiplier, claimantRelation);
    result = Hash.combine(result, multiplier, claimant);
    result = Hash.combine(result, multiplier, claimantAddress);
    result = Hash.combine(result, multiplier, accidentDate);
    result = Hash.combine(result, multiplier, accidentPlace);
    result = Hash.combine(result, multiplier, accidentDescription);
    result = Hash.combine(result, multiplier, hospital);
    result = Hash.combine(result, multiplier, treatmentStartDate);
    result = Hash.combine(result, multiplier, treatmentEndDate);
    result = Hash.combine(result, multiplier, quickCompensationState);
    result = Hash.combine(result, multiplier, currency);
    result = Hash.combine(result, multiplier, totalPaidAmount);
    result = Hash.combine(result, multiplier, payeeName);
    result = Hash.combine(result, multiplier, account);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, issueTime);
    result = Hash.combine(result, multiplier, cancelTime);
    result = Hash.combine(result, multiplier, completeTime);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, statusGroup);
    result = Hash.combine(result, multiplier, notes);
    result = Hash.combine(result, multiplier, payload);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    result = Hash.combine(result, multiplier, attachmentList);
    result = Hash.combine(result, multiplier, events);
    result = Hash.combine(result, multiplier, medicalList);
    result = Hash.combine(result, multiplier, savedInvoices);
    result = Hash.combine(result, multiplier, amount);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("product", product)
        .append("company", company)
        .append("source", source)
        .append("reason", reason)
        .append("policyNumber", policyNumber)
        .append("insured", insured)
        .append("insuredAddress", insuredAddress)
        .append("insuredStatus", insuredStatus)
        .append("claimantRelation", claimantRelation)
        .append("claimant", claimant)
        .append("claimantAddress", claimantAddress)
        .append("accidentDate", accidentDate)
        .append("accidentPlace", accidentPlace)
        .append("accidentDescription", accidentDescription)
        .append("hospital", hospital)
        .append("treatmentStartDate", treatmentStartDate)
        .append("treatmentEndDate", treatmentEndDate)
        .append("quickCompensationState", quickCompensationState)
        .append("currency", currency)
        .append("totalPaidAmount", totalPaidAmount)
        .append("payeeName", payeeName)
        .append("account", account)
        .append("number", number)
        .append("issueTime", issueTime)
        .append("cancelTime", cancelTime)
        .append("completeTime", completeTime)
        .append("status", status)
        .append("statusGroup", statusGroup)
        .append("notes", notes)
        .append("payload", payload)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .append("attachmentList", attachmentList)
        .append("events", events)
        .append("medicalList", medicalList)
        .append("savedInvoices", savedInvoices)
        .append("amount", amount)
        .toString();
  }

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
  //     throw new NullFieldException("accidentReason");
  //   }
  //   // 3. 检查保单号不能为空
  //   if (StringUtils.isBlank(policyNumber)) {
  //     throw new NullFieldException("policyNumber");
  //   }
  //   // 4. 检查出险人信息不能为空
  //   if (insured == null) {
  //     throw new NullFieldException("insured");
  //   }
  //   // 检查出险人的基本信息，包括姓名、证件信息、手机号
  //   insured.checkBaseField();
  //   // 5. 检查报案人与出险人的关系不能为空
  //   if (claimantRelation == null) {
  //     throw new NullFieldException("claimantRelation");
  //   }
  //   // 6. 检查报案人信息不能为空
  //   if (claimant == null) {
  //     throw new NullFieldException("claimant");
  //   }
  //   // 检查报案人的基本信息，包括姓名、证件信息、手机号
  //   claimant.checkBaseField();
  //   // 7. 检查出险日期不能为空
  //   if (accidentDate == null) {
  //     throw new NullFieldException("accidentDate");
  //   }
  //   // 8. 检查出险地点不能为空
  //   if (StringUtils.isBlank(accidentPlace)) {
  //     throw new NullFieldException("accidentPlace");
  //   }
  //   // 9. 检查出险说明不能为空
  //   if (StringUtils.isBlank(accidentDescription)) {
  //     throw new NullFieldException("accidentDescription");
  //   }
  //   // 10. 检查账户信息不能为空
  //   if (account == null
  //       || account.getType() == null
  //       || StringUtils.isBlank(account.getNumber())) {
  //     throw new NullFieldException("account");
  //   }
  //   // 11. 数据来源不能为空
  //   if (source == null) {
  //     throw new NullFieldException("source");
  //   }
  //   if (StringUtils.isBlank(source.getCode())) {
  //     throw new NullFieldException("code");
  //   }
  // }

  /**
   * 检查是否允许用户操作。
   */
  public boolean allowClientOperation() {
    // 当理赔申请状态为未提交或者已驳回时，允许用户进行操作
    return this.status == InsuranceClaimStatus.NOT_SUBMITTED
        || this.status == InsuranceClaimStatus.SYSTEM_REJECTED
        || this.status == InsuranceClaimStatus.INSURANCE_COMPANY_REJECTED;
  }

  /**
   * 检查是否允许系统驳回操作。
   */
  public boolean allowSystemReject() {
    // 当理赔申请状态为待审核索赔申请书、索赔申请书审核通过或暂存待处理状态时，允许系统驳回操作
    return this.status == InsuranceClaimStatus.CLAIM_APPLICATION_WAIT_AUDIT
        || this.status == InsuranceClaimStatus.CLAIM_APPLICATION_AUDITED
        || this.status == InsuranceClaimStatus.TEMPORARY_SAVED;
  }

  /**
   * 检查是否允许系统审核通过操作。
   */
  public boolean allowSystemAccept() {
    // 当理赔申请状态为索赔申请书审核通过或暂存待处理状态时，允许系统审核通过操作
    return this.status == InsuranceClaimStatus.CLAIM_APPLICATION_AUDITED
        || this.status == InsuranceClaimStatus.TEMPORARY_SAVED;
  }

}
