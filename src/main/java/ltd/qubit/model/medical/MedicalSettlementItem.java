////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.math.BigDecimal;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Scale;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.DictEntryInfo;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示医疗费用结算单中的结算项目。
 *
 * @author 胡海星
 */
public class MedicalSettlementItem implements Identifiable {

  private static final long serialVersionUID = 7435641042541286026L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所属结算单的ID，关联表 medical-settlement 的id字段。
   */
  private Long settlementId;

  /**
   * 本项在明细列表中的编号，从0开始编号。
   */
  private Integer index;

  /**
   * 医保项目类型。
   */
  private MedicareItemType type;

  /**
   * 费用类型。
   */
  private DictEntryInfo chargeType;

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
   * 数量。
   */
  @Scale(2)
  private BigDecimal amount;

  /**
   * 总金额。
   *
   * <p>总金额 =  单价 * 数量
   */
  @Money
  private BigDecimal totalPrice;

  /**
   * 自费金额。
   */
  @Money
  private BigDecimal selfPaid;

  /**
   * 自费比例。
   */
  @Money
  private BigDecimal selfPaidRate;

  /**
   * 报销上限。
   */
  @Money
  private BigDecimal reimburseLimit;

  /**
   * 应收费用。
   */
  @Money
  private BigDecimal payable;

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

  public Long getSettlementId() {
    return settlementId;
  }

  public void setSettlementId(final Long settlementId) {
    this.settlementId = settlementId;
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex(final Integer index) {
    this.index = index;
  }

  public MedicareItemType getType() {
    return type;
  }

  public void setType(final MedicareItemType type) {
    this.type = type;
  }

  public DictEntryInfo getChargeType() {
    return chargeType;
  }

  public void setChargeType(final DictEntryInfo chargeType) {
    this.chargeType = chargeType;
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

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(final BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public BigDecimal getSelfPaid() {
    return selfPaid;
  }

  public void setSelfPaid(final BigDecimal selfPaid) {
    this.selfPaid = selfPaid;
  }

  public BigDecimal getSelfPaidRate() {
    return selfPaidRate;
  }

  public void setSelfPaidRate(final BigDecimal selfPaidRate) {
    this.selfPaidRate = selfPaidRate;
  }

  public BigDecimal getReimburseLimit() {
    return reimburseLimit;
  }

  public void setReimburseLimit(final BigDecimal reimburseLimit) {
    this.reimburseLimit = reimburseLimit;
  }

  public BigDecimal getPayable() {
    return payable;
  }

  public void setPayable(final BigDecimal payable) {
    this.payable = payable;
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
    final MedicalSettlementItem other = (MedicalSettlementItem) o;
    return Equality.equals(id, other.id)
            && Equality.equals(settlementId, other.settlementId)
            && Equality.equals(index, other.index)
            && Equality.equals(type, other.type)
            && Equality.equals(chargeType, other.chargeType)
            && Equality.equals(code, other.code)
            && Equality.equals(name, other.name)
            && Equality.equals(specification, other.specification)
            && Equality.equals(unit, other.unit)
            && Equality.equals(price, other.price)
            && Equality.equals(amount, other.amount)
            && Equality.equals(totalPrice, other.totalPrice)
            && Equality.equals(selfPaid, other.selfPaid)
            && Equality.equals(selfPaidRate, other.selfPaidRate)
            && Equality.equals(reimburseLimit, other.reimburseLimit)
            && Equality.equals(payable, other.payable)
            && Equality.equals(remark, other.remark);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, settlementId);
    result = Hash.combine(result, multiplier, index);
    result = Hash.combine(result, multiplier, type);
    result = Hash.combine(result, multiplier, chargeType);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, specification);
    result = Hash.combine(result, multiplier, unit);
    result = Hash.combine(result, multiplier, price);
    result = Hash.combine(result, multiplier, amount);
    result = Hash.combine(result, multiplier, totalPrice);
    result = Hash.combine(result, multiplier, selfPaid);
    result = Hash.combine(result, multiplier, selfPaidRate);
    result = Hash.combine(result, multiplier, reimburseLimit);
    result = Hash.combine(result, multiplier, payable);
    result = Hash.combine(result, multiplier, remark);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("settlementId", settlementId)
            .append("index", index)
            .append("type", type)
            .append("chargeType", chargeType)
            .append("code", code)
            .append("name", name)
            .append("specification", specification)
            .append("unit", unit)
            .append("price", price)
            .append("amount", amount)
            .append("totalPrice", totalPrice)
            .append("selfPaid", selfPaid)
            .append("selfPaidRate", selfPaidRate)
            .append("reimburseLimit", reimburseLimit)
            .append("payable", payable)
            .append("remark", remark)
            .toString();
  }
}
