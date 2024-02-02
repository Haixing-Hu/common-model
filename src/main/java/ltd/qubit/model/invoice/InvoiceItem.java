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

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示电子票据明细。
 *
 * @author 孙建，胡海星
 */
public class InvoiceItem implements Identifiable {

  private static final long serialVersionUID = 7525117846693645073L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所属票据的ID，关联表invoice的id字段。
   */
  private Long invoiceId;

  /**
   * 本项在发票的明细列表中的编号，从0开始编号。
   */
  private Integer index;

  /**
   * 编码。
   */
  @Size(min = 1, max = 64)
  private String code;

  /**
   * 名称。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 规格。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String specification;

  /**
   * 单位。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String unit;

  /**
   * 单价。
   */
  @Money
  private BigDecimal price;

  /**
   * 单价折扣。
   */
  @Money
  @Nullable
  private BigDecimal discount;

  /**
   * 数量。
   */
  @Money
  private BigDecimal amount;

  /**
   * 单价外的总价折扣。
   */
  @Money
  @Nullable
  private BigDecimal totalDiscount;

  /**
   * 应付总金额。
   *
   * <p>应付总金额 =  (单价 - 单价折扣) * 数量 - 总价折扣
   */
  @Money
  private BigDecimal payable;

  /**
   * 税率。
   */
  @Money
  @Nullable
  private BigDecimal taxRate;

  /**
   * 税额 = 应付总金额 * 税率。
   */
  @Money
  @Nullable
  private BigDecimal tax;

  /**
   * 实付总金额 = 应付总金额 + 税额。
   */
  @Money
  private BigDecimal paid;

  /**
   * 备注信息。
   */
  @Nullable
  private String remark;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(final Long invoiceId) {
    this.invoiceId = invoiceId;
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex(final Integer index) {
    this.index = index;
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

  @Nullable
  public String getSpecification() {
    return specification;
  }

  public void setSpecification(@Nullable final String specification) {
    this.specification = specification;
  }

  @Nullable
  public String getUnit() {
    return unit;
  }

  public void setUnit(@Nullable final String unit) {
    this.unit = unit;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(final BigDecimal price) {
    this.price = price;
  }

  @Nullable
  public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(@Nullable final BigDecimal discount) {
    this.discount = discount;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
  }

  @Nullable
  public BigDecimal getTotalDiscount() {
    return totalDiscount;
  }

  public void setTotalDiscount(@Nullable final BigDecimal totalDiscount) {
    this.totalDiscount = totalDiscount;
  }

  public BigDecimal getPayable() {
    return payable;
  }

  public void setPayable(final BigDecimal payable) {
    this.payable = payable;
  }

  @Nullable
  public BigDecimal getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(@Nullable final BigDecimal taxRate) {
    this.taxRate = taxRate;
  }

  @Nullable
  public BigDecimal getTax() {
    return tax;
  }

  public void setTax(@Nullable final BigDecimal tax) {
    this.tax = tax;
  }

  public BigDecimal getPaid() {
    return paid;
  }

  public void setPaid(final BigDecimal paid) {
    this.paid = paid;
  }

  @Nullable
  public String getRemark() {
    return remark;
  }

  public void setRemark(@Nullable final String remark) {
    this.remark = remark;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final InvoiceItem other = (InvoiceItem) o;
    return Equality.equals(id, other.id)
            && Equality.equals(invoiceId, other.invoiceId)
            && Equality.equals(index, other.index)
            && Equality.equals(code, other.code)
            && Equality.equals(name, other.name)
            && Equality.equals(specification, other.specification)
            && Equality.equals(unit, other.unit)
            && Equality.equals(price, other.price)
            && Equality.equals(discount, other.discount)
            && Equality.equals(amount, other.amount)
            && Equality.equals(totalDiscount, other.totalDiscount)
            && Equality.equals(payable, other.payable)
            && Equality.equals(taxRate, other.taxRate)
            && Equality.equals(tax, other.tax)
            && Equality.equals(paid, other.paid)
            && Equality.equals(remark, other.remark);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, invoiceId);
    result = Hash.combine(result, multiplier, index);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, specification);
    result = Hash.combine(result, multiplier, unit);
    result = Hash.combine(result, multiplier, price);
    result = Hash.combine(result, multiplier, discount);
    result = Hash.combine(result, multiplier, amount);
    result = Hash.combine(result, multiplier, totalDiscount);
    result = Hash.combine(result, multiplier, payable);
    result = Hash.combine(result, multiplier, taxRate);
    result = Hash.combine(result, multiplier, tax);
    result = Hash.combine(result, multiplier, paid);
    result = Hash.combine(result, multiplier, remark);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("invoiceId", invoiceId)
            .append("index", index)
            .append("code", code)
            .append("name", name)
            .append("specification", specification)
            .append("unit", unit)
            .append("price", price)
            .append("discount", discount)
            .append("amount", amount)
            .append("totalDiscount", totalDiscount)
            .append("payable", payable)
            .append("taxRate", taxRate)
            .append("tax", tax)
            .append("paid", paid)
            .append("remark", remark)
            .toString();
  }
}
