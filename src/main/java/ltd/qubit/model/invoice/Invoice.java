////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.invoice;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Computed;
import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.organization.Organization;
import ltd.qubit.model.payment.Participant;
import ltd.qubit.model.payment.PaymentChannel;
import ltd.qubit.model.payment.PaymentMode;
import ltd.qubit.model.settlement.Settlement;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;
import ltd.qubit.model.util.WithCode;
import ltd.qubit.model.util.WithOrganization;

/**
 * 此模型表示电子票据。
 *
 * @author 孙建，胡海星
 */
public class Invoice implements Identifiable, WithApp, WithOrganization,
    WithCode, Auditable {

  private static final long serialVersionUID = -6769474294298561793L;

  /**
   * 记录在系统中的ID，唯一标识，系统自动生成。
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
   * 开票点基本信息。
   */
  @Reference(entity = InvoicePlace.class, property = "info")
  private Info place;

  /**
   * 代码。
   */
  @Size(min = 1, max = 64)
  private String code;

  /**
   * 编号。
   */
  @Size(min = 1, max = 64)
  private String number;

  /**
   * 校验码。
   */
  @Size(min = 1, max = 64)
  private String verifyCode;

  /**
   * 发票对应的业务流水号。
   *
   * <p>如一笔业务数据需要开具N张电子票据，则N张电子票对应该值保持一致
   */
  @Size(min = 1, max = 64)
  private String businessNumber;

  /**
   * 发票对应的业务发生的时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant businessTime;

  /**
   * 收款人。
   */
  private Participant payee;

  /**
   * 付款人。
   */
  private Participant payer;

  /**
   * 支付渠道。
   */
  private PaymentChannel paymentChannel;

  /**
   * 支付方式。
   */
  private PaymentMode paymentMode;

  /**
   * 货币种类，默认为CNY。
   */
  private Currency currency;

  /**
   * 汇率。
   */
  @Money
  @Nullable
  private BigDecimal exchangeRate;

  /**
   * 总金额。
   */
  @Money
  private BigDecimal totalPrice;

  /**
   * 备注。
   */
  @Nullable
  private String remark;

  /**
   * 开票人姓名。
   */
  @Size(min = 1, max = 128)
  private String drawer;

  /**
   * 审核人姓名。
   */
  @Size(min = 1, max = 128)
  private String auditor;

  /**
   * 财政部门备注。
   */
  @Nullable
  private String supervisorRemark;

  /**
   * 相关票据的基本信息。
   *
   * <p>预留扩展字段，开具红票时在此填写原票据ID。
   */
  @Reference(entity = Invoice.class, property = "info")
  @Nullable
  private InvoiceInfo relatedInvoice;

  /**
   * 开票单位印章编号。
   */
  @Size(min = 1, max = 64)
  private String sealNumber;

  /**
   * 发票项目明细。
   */
  @Reference(entity = InvoiceItem.class)
  @Nullable
  private List<InvoiceItem> items;

  /**
   * 结算数据。
   */
  @Reference(entity = Settlement.class)
  @Nullable
  private Settlement settlement;

  /**
   * 电子票获取地址。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String url;

  /**
   * 票据状态。
   */
  @Nullable
  private InvoiceStatus status;

  /**
   * 开票日期。
   */
  @Nullable
  private LocalDate issueDate;

  /**
   * 该记录创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 该记录最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 该记录标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public Invoice() {
    // empty
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
  public StatefulInfo getApp() {
    return app;
  }

  @Override
  public void setApp(final StatefulInfo app) {
    this.app = app;
  }

  @Override
  public StatefulInfo getOrganization() {
    return organization;
  }

  @Override
  public void setOrganization(final StatefulInfo organization) {
    this.organization = organization;
  }

  public Info getPlace() {
    return place;
  }

  public void setPlace(final Info place) {
    this.place = place;
  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public void setCode(final String code) {
    this.code = code;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public String getVerifyCode() {
    return verifyCode;
  }

  public void setVerifyCode(final String verifyCode) {
    this.verifyCode = verifyCode;
  }

  public String getBusinessNumber() {
    return businessNumber;
  }

  public void setBusinessNumber(final String businessNumber) {
    this.businessNumber = businessNumber;
  }

  public Instant getBusinessTime() {
    return businessTime;
  }

  public void setBusinessTime(final Instant businessTime) {
    this.businessTime = businessTime;
  }

  public Participant getPayee() {
    return payee;
  }

  public void setPayee(final Participant payee) {
    this.payee = payee;
  }

  public Participant getPayer() {
    return payer;
  }

  public void setPayer(final Participant payer) {
    this.payer = payer;
  }

  public PaymentChannel getPaymentChannel() {
    return paymentChannel;
  }

  public void setPaymentChannel(final PaymentChannel paymentChannel) {
    this.paymentChannel = paymentChannel;
  }

  public PaymentMode getPaymentMode() {
    return paymentMode;
  }

  public void setPaymentMode(final PaymentMode paymentMode) {
    this.paymentMode = paymentMode;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(final Currency currency) {
    this.currency = currency;
  }

  @Nullable
  public BigDecimal getExchangeRate() {
    return exchangeRate;
  }

  public void setExchangeRate(@Nullable final BigDecimal exchangeRate) {
    this.exchangeRate = exchangeRate;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(final BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  @Nullable
  public String getRemark() {
    return remark;
  }

  public void setRemark(@Nullable final String remark) {
    this.remark = remark;
  }

  public String getDrawer() {
    return drawer;
  }

  public void setDrawer(final String drawer) {
    this.drawer = drawer;
  }

  public String getAuditor() {
    return auditor;
  }

  public void setAuditor(final String auditor) {
    this.auditor = auditor;
  }

  @Nullable
  public String getSupervisorRemark() {
    return supervisorRemark;
  }

  public void setSupervisorRemark(@Nullable final String supervisorRemark) {
    this.supervisorRemark = supervisorRemark;
  }

  @Nullable
  public InvoiceInfo getRelatedInvoice() {
    return relatedInvoice;
  }

  public void setRelatedInvoice(@Nullable final InvoiceInfo relatedInvoice) {
    this.relatedInvoice = relatedInvoice;
  }

  public String getSealNumber() {
    return sealNumber;
  }

  public void setSealNumber(final String sealNumber) {
    this.sealNumber = sealNumber;
  }

  @Nullable
  public List<InvoiceItem> getItems() {
    return items;
  }

  public void setItems(@Nullable final List<InvoiceItem> items) {
    this.items = items;
  }

  @Nullable
  public Settlement getSettlement() {
    return settlement;
  }

  public void setSettlement(@Nullable final Settlement settlement) {
    this.settlement = settlement;
  }

  @Nullable
  public String getUrl() {
    return url;
  }

  public void setUrl(@Nullable final String url) {
    this.url = url;
  }

  @Nullable
  public InvoiceStatus getStatus() {
    return status;
  }

  public void setStatus(@Nullable final InvoiceStatus status) {
    this.status = status;
  }

  @Nullable
  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(@Nullable final LocalDate issueDate) {
    this.issueDate = issueDate;
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

  @Computed
  public InvoiceInfo getInfo() {
    return new InvoiceInfo(this);
  }

  @Override
  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Invoice other = (Invoice) o;
    return Equality.equals(id, other.id)
        && Equality.equals(app, other.app)
        && Equality.equals(organization, other.organization)
        && Equality.equals(place, other.place)
        && Equality.equals(code, other.code)
        && Equality.equals(number, other.number)
        && Equality.equals(verifyCode, other.verifyCode)
        && Equality.equals(businessNumber, other.businessNumber)
        && Equality.equals(businessTime, other.businessTime)
        && Equality.equals(payee, other.payee)
        && Equality.equals(payer, other.payer)
        && Equality.equals(paymentChannel, other.paymentChannel)
        && Equality.equals(paymentMode, other.paymentMode)
        && Equality.equals(currency, other.currency)
        && Equality.equals(exchangeRate, other.exchangeRate)
        && Equality.equals(totalPrice, other.totalPrice)
        && Equality.equals(remark, other.remark)
        && Equality.equals(drawer, other.drawer)
        && Equality.equals(auditor, other.auditor)
        && Equality.equals(supervisorRemark, other.supervisorRemark)
        && Equality.equals(relatedInvoice, other.relatedInvoice)
        && Equality.equals(sealNumber, other.sealNumber)
        && Equality.equals(items, other.items)
        && Equality.equals(settlement, other.settlement)
        && Equality.equals(url, other.url)
        && Equality.equals(status, other.status)
        && Equality.equals(issueDate, other.issueDate)
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
    result = Hash.combine(result, multiplier, place);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, verifyCode);
    result = Hash.combine(result, multiplier, businessNumber);
    result = Hash.combine(result, multiplier, businessTime);
    result = Hash.combine(result, multiplier, payee);
    result = Hash.combine(result, multiplier, payer);
    result = Hash.combine(result, multiplier, paymentChannel);
    result = Hash.combine(result, multiplier, paymentMode);
    result = Hash.combine(result, multiplier, currency);
    result = Hash.combine(result, multiplier, exchangeRate);
    result = Hash.combine(result, multiplier, totalPrice);
    result = Hash.combine(result, multiplier, remark);
    result = Hash.combine(result, multiplier, drawer);
    result = Hash.combine(result, multiplier, auditor);
    result = Hash.combine(result, multiplier, supervisorRemark);
    result = Hash.combine(result, multiplier, relatedInvoice);
    result = Hash.combine(result, multiplier, sealNumber);
    result = Hash.combine(result, multiplier, items);
    result = Hash.combine(result, multiplier, settlement);
    result = Hash.combine(result, multiplier, url);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, issueDate);
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
        .append("place", place)
        .append("code", code)
        .append("number", number)
        .append("verifyCode", verifyCode)
        .append("businessNumber", businessNumber)
        .append("businessTime", businessTime)
        .append("payee", payee)
        .append("payer", payer)
        .append("paymentChannel", paymentChannel)
        .append("paymentMode", paymentMode)
        .append("currency", currency)
        .append("exchangeRate", exchangeRate)
        .append("totalPrice", totalPrice)
        .append("remark", remark)
        .append("drawer", drawer)
        .append("auditor", auditor)
        .append("supervisorRemark", supervisorRemark)
        .append("relatedInvoice", relatedInvoice)
        .append("sealNumber", sealNumber)
        .append("items", items)
        .append("settlement", settlement)
        .append("url", url)
        .append("status", status)
        .append("issueDate", issueDate)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
