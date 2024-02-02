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
import java.time.LocalDate;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示发票的基本信息。
 *
 * @author 胡海星
 */
public class InvoiceInfo implements Identifiable, Assignable<InvoiceInfo> {

  private static final long serialVersionUID = 7980225211218902945L;

  /**
   * 记录在系统中的ID，唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 发票代码。
   */
  @Size(min = 1, max = 64)
  private String code;

  /**
   * 发票编号。
   */
  @Size(min = 1, max = 64)
  private String number;

  /**
   * 发票对应的业务流水号。
   *
   * <p>如一笔业务数据需要开具N张电子票据，则N张电子票对应该值保持一致。
   */
  @Size(min = 1, max = 64)
  private String businessNumber;

  /**
   * 开票日期。
   */
  @Nullable
  private LocalDate issueDate;

  /**
   * 收款方姓名或名称。
   *
   * <p>对于个人收款方，通常是个人真实姓名；对于机构收款方，通常是机构注册名称。
   */
  @Size(min = 1, max = 128)
  private String payeeName;

  /**
   * 付款方姓名或名称。
   *
   * <p>对于个人付款方，通常是个人真实姓名；对于机构付款方，通常是机构注册名称。
   */
  @Size(min = 1, max = 128)
  private String payerName;

  /**
   * 货币种类，默认为CNY。
   */
  private Currency currency;

  /**
   * 总金额。
   */
  @Money
  private BigDecimal totalAmount;

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

  public InvoiceInfo() {
    // empty
  }

  public InvoiceInfo(final Invoice invoice) {
    id = invoice.getId();
    code = invoice.getCode();
    number = invoice.getNumber();
    businessNumber = invoice.getBusinessNumber();
    issueDate = invoice.getIssueDate();
    payeeName = (invoice.getPayee() == null ? null : invoice.getPayee().getName());
    payerName = (invoice.getPayer() == null ? null : invoice.getPayer().getName());
    currency = invoice.getCurrency();
    totalAmount = invoice.getTotalPrice();
    url = invoice.getUrl();
    status = invoice.getStatus();
  }

  public InvoiceInfo(final InvoiceInfo other) {
    assign(other);
  }

  @Override
  public void assign(final InvoiceInfo other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    number = other.number;
    businessNumber = other.businessNumber;
    issueDate = other.issueDate;
    payeeName = other.payeeName;
    payerName = other.payerName;
    currency = other.currency;
    totalAmount = other.totalAmount;
    url = other.url;
    status = other.status;
  }

  @Override
  public InvoiceInfo clone() {
    return new InvoiceInfo(this);
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(final Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public String getBusinessNumber() {
    return businessNumber;
  }

  public void setBusinessNumber(final String businessNumber) {
    this.businessNumber = businessNumber;
  }

  @Nullable
  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(@Nullable final LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  public String getPayeeName() {
    return payeeName;
  }

  public void setPayeeName(final String payeeName) {
    this.payeeName = payeeName;
  }

  public String getPayerName() {
    return payerName;
  }

  public void setPayerName(final String payerName) {
    this.payerName = payerName;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(final Currency currency) {
    this.currency = currency;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(final BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
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

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final InvoiceInfo other = (InvoiceInfo) o;
    return Equality.equals(id, other.id)
            && Equality.equals(code, other.code)
            && Equality.equals(number, other.number)
            && Equality.equals(businessNumber, other.businessNumber)
            && Equality.equals(issueDate, other.issueDate)
            && Equality.equals(payeeName, other.payeeName)
            && Equality.equals(payerName, other.payerName)
            && Equality.equals(currency, other.currency)
            && Equality.equals(totalAmount, other.totalAmount)
            && Equality.equals(url, other.url)
            && Equality.equals(status, other.status);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, businessNumber);
    result = Hash.combine(result, multiplier, issueDate);
    result = Hash.combine(result, multiplier, payeeName);
    result = Hash.combine(result, multiplier, payerName);
    result = Hash.combine(result, multiplier, currency);
    result = Hash.combine(result, multiplier, totalAmount);
    result = Hash.combine(result, multiplier, url);
    result = Hash.combine(result, multiplier, status);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("code", code)
            .append("number", number)
            .append("businessNumber", businessNumber)
            .append("issueDate", issueDate)
            .append("payeeName", payeeName)
            .append("payerName", payerName)
            .append("currency", currency)
            .append("totalAmount", totalAmount)
            .append("url", url)
            .append("status", status)
            .toString();
  }
}
