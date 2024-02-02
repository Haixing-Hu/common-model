////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.io.Serializable;
import java.math.BigDecimal;

import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 此模型表示医疗服务结算支付信息。
 *
 * @author 胡海星
 */
public class MedicalPayment implements Serializable {

  private static final long serialVersionUID = -1046291171819002525L;

  /**
   * 个人自理金额。
   *
   * <p>是指乙类药品、诊疗项目、服务设施中，个人按比例先自行支付部分。
   */
  @Money
  private BigDecimal selfCare;

  /**
   * 个人自费金额。
   *
   * <p>是指丙类药品、诊疗项目、服务设施和超限价项目，需个人自费支付的部分。
   */
  @Money
  private BigDecimal selfPaid;

  /**
   * 符合医保费用。
   *
   * <p>指的是符合基本医疗保险费用，在药品、诊疗项目和服务设施的甲类和乙类费用中刨除自
   * 理金额的总费用，即 “总费用 - 自理金额 - 自费金额”。
   */
  @Money
  private BigDecimal withinMedicare;

  /**
   * 医保基金支付费用。
   *
   * <p>指的是所有医保基金支付的总额。
   */
  @Money
  private BigDecimal medicarePaid;

  /**
   * 医保起付线。
   */
  @Money
  private BigDecimal medicareDeductible;

  /**
   * 个人自付。
   *
   * <p>符合医保费用中由个人支付的部分，包含起付标准，不包含转诊先自付。
   */
  @Money
  private BigDecimal personalBurden;

  /**
   * 转诊先自付。
   *
   * <p>患者从外地转入就诊，根据当地医保政策转外就诊需自付金额。
   */
  @Money
  private BigDecimal transferPrepaid;

  /**
   * 统筹分段自付。
   *
   * <p>统筹分段计算的个人自付金额。
   */
  @Money
  private BigDecimal sectionalPaid;

  /**
   * 医院负担。
   *
   * <p>个地方医保政策中需要医院负担的金额。
   */
  @Money
  private BigDecimal hospitalBurden;

  /**
   * 统筹基金支付。
   *
   * <p>根据人员身份进行填写，包括基本医疗保险基金支付、城镇居民医疗基金支付、新农合补
   * 偿支付。
   */
  @Money
  private BigDecimal poolFundPaid;

  /**
   * 公务员基金支付。
   *
   * <p>公务员补充医疗保险支付金额。
   */
  @Money
  private BigDecimal civilServantFundPaid;

  /**
   * 大病救助报销金额。
   */
  @Money
  private BigDecimal seriousDiseaseAssistancePaid;

  /**
   * 大病保险报销金额。
   */
  @Money
  private BigDecimal seriousDiseaseInsurancePaid;

  /**
   * 民政救助报销金额。
   */
  @Money
  private BigDecimal civilAffairsAssistancePaid;

  /**
   * 其他基金支付。
   *
   * <p>除上述基金支付外的其他基金支付金额。
   */
  @Money
  private BigDecimal otherFundPaid;

  /**
   * 账户支付。
   *
   * <p>本次个人账户支付金额。
   */
  @Money
  private BigDecimal accountPaid;

  /**
   * 个人账户余额。
   */
  @Money
  private BigDecimal accountBalance;

  /**
   * 现金预交款金额。
   */
  @Money
  private BigDecimal cashPrepaid;

  /**
   * 现金补交款金额。
   */
  @Money
  private BigDecimal cashRecharge;

  /**
   * 现金退还款金额。
   */
  @Money
  private BigDecimal cashRefund;

  /**
   * 支票预交款金额。
   */
  @Money
  private BigDecimal chequePrepaid;

  /**
   * 支票补交款金额。
   */
  @Money
  private BigDecimal chequeRecharge;

  /**
   * 支票退还款金额。
   */
  @Money
  private BigDecimal chequeRefund;

  /**
   * 银行转账预交款金额。
   */
  @Money
  private BigDecimal bankTransferPrepaid;

  /**
   * 银行转账补交款金额。
   */
  @Money
  private BigDecimal bankTransferRecharge;

  /**
   * 银行转账退还款金额。
   */
  @Money
  private BigDecimal bankTransferRefund;

  public BigDecimal getSelfCare() {
    return selfCare;
  }

  public void setSelfCare(final BigDecimal selfCare) {
    this.selfCare = selfCare;
  }

  public BigDecimal getSelfPaid() {
    return selfPaid;
  }

  public void setSelfPaid(final BigDecimal selfPaid) {
    this.selfPaid = selfPaid;
  }

  public BigDecimal getWithinMedicare() {
    return withinMedicare;
  }

  public void setWithinMedicare(final BigDecimal withinMedicare) {
    this.withinMedicare = withinMedicare;
  }

  public BigDecimal getMedicarePaid() {
    return medicarePaid;
  }

  public void setMedicarePaid(final BigDecimal medicarePaid) {
    this.medicarePaid = medicarePaid;
  }

  public BigDecimal getMedicareDeductible() {
    return medicareDeductible;
  }

  public void setMedicareDeductible(final BigDecimal medicareDeductible) {
    this.medicareDeductible = medicareDeductible;
  }

  public BigDecimal getPersonalBurden() {
    return personalBurden;
  }

  public void setPersonalBurden(final BigDecimal personalBurden) {
    this.personalBurden = personalBurden;
  }

  public BigDecimal getTransferPrepaid() {
    return transferPrepaid;
  }

  public void setTransferPrepaid(final BigDecimal transferPrepaid) {
    this.transferPrepaid = transferPrepaid;
  }

  public BigDecimal getSectionalPaid() {
    return sectionalPaid;
  }

  public void setSectionalPaid(final BigDecimal sectionalPaid) {
    this.sectionalPaid = sectionalPaid;
  }

  public BigDecimal getHospitalBurden() {
    return hospitalBurden;
  }

  public void setHospitalBurden(final BigDecimal hospitalBurden) {
    this.hospitalBurden = hospitalBurden;
  }

  public BigDecimal getPoolFundPaid() {
    return poolFundPaid;
  }

  public void setPoolFundPaid(final BigDecimal poolFundPaid) {
    this.poolFundPaid = poolFundPaid;
  }

  public BigDecimal getCivilServantFundPaid() {
    return civilServantFundPaid;
  }

  public void setCivilServantFundPaid(final BigDecimal civilServantFundPaid) {
    this.civilServantFundPaid = civilServantFundPaid;
  }

  public BigDecimal getSeriousDiseaseAssistancePaid() {
    return seriousDiseaseAssistancePaid;
  }

  public void setSeriousDiseaseAssistancePaid(final BigDecimal seriousDiseaseAssistancePaid) {
    this.seriousDiseaseAssistancePaid = seriousDiseaseAssistancePaid;
  }

  public BigDecimal getSeriousDiseaseInsurancePaid() {
    return seriousDiseaseInsurancePaid;
  }

  public void setSeriousDiseaseInsurancePaid(final BigDecimal seriousDiseaseInsurancePaid) {
    this.seriousDiseaseInsurancePaid = seriousDiseaseInsurancePaid;
  }

  public BigDecimal getCivilAffairsAssistancePaid() {
    return civilAffairsAssistancePaid;
  }

  public void setCivilAffairsAssistancePaid(final BigDecimal civilAffairsAssistancePaid) {
    this.civilAffairsAssistancePaid = civilAffairsAssistancePaid;
  }

  public BigDecimal getOtherFundPaid() {
    return otherFundPaid;
  }

  public void setOtherFundPaid(final BigDecimal otherFundPaid) {
    this.otherFundPaid = otherFundPaid;
  }

  public BigDecimal getAccountPaid() {
    return accountPaid;
  }

  public void setAccountPaid(final BigDecimal accountPaid) {
    this.accountPaid = accountPaid;
  }

  public BigDecimal getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(final BigDecimal accountBalance) {
    this.accountBalance = accountBalance;
  }

  public BigDecimal getCashPrepaid() {
    return cashPrepaid;
  }

  public void setCashPrepaid(final BigDecimal cashPrepaid) {
    this.cashPrepaid = cashPrepaid;
  }

  public BigDecimal getCashRecharge() {
    return cashRecharge;
  }

  public void setCashRecharge(final BigDecimal cashRecharge) {
    this.cashRecharge = cashRecharge;
  }

  public BigDecimal getCashRefund() {
    return cashRefund;
  }

  public void setCashRefund(final BigDecimal cashRefund) {
    this.cashRefund = cashRefund;
  }

  public BigDecimal getChequePrepaid() {
    return chequePrepaid;
  }

  public void setChequePrepaid(final BigDecimal chequePrepaid) {
    this.chequePrepaid = chequePrepaid;
  }

  public BigDecimal getChequeRecharge() {
    return chequeRecharge;
  }

  public void setChequeRecharge(final BigDecimal chequeRecharge) {
    this.chequeRecharge = chequeRecharge;
  }

  public BigDecimal getChequeRefund() {
    return chequeRefund;
  }

  public void setChequeRefund(final BigDecimal chequeRefund) {
    this.chequeRefund = chequeRefund;
  }

  public BigDecimal getBankTransferPrepaid() {
    return bankTransferPrepaid;
  }

  public void setBankTransferPrepaid(final BigDecimal bankTransferPrepaid) {
    this.bankTransferPrepaid = bankTransferPrepaid;
  }

  public BigDecimal getBankTransferRecharge() {
    return bankTransferRecharge;
  }

  public void setBankTransferRecharge(final BigDecimal bankTransferRecharge) {
    this.bankTransferRecharge = bankTransferRecharge;
  }

  public BigDecimal getBankTransferRefund() {
    return bankTransferRefund;
  }

  public void setBankTransferRefund(final BigDecimal bankTransferRefund) {
    this.bankTransferRefund = bankTransferRefund;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final MedicalPayment other = (MedicalPayment) o;
    return Equality.equals(selfCare, other.selfCare)
            && Equality.equals(selfPaid, other.selfPaid)
            && Equality.equals(withinMedicare, other.withinMedicare)
            && Equality.equals(medicarePaid, other.medicarePaid)
            && Equality.equals(medicareDeductible, other.medicareDeductible)
            && Equality.equals(personalBurden, other.personalBurden)
            && Equality.equals(transferPrepaid, other.transferPrepaid)
            && Equality.equals(sectionalPaid, other.sectionalPaid)
            && Equality.equals(hospitalBurden, other.hospitalBurden)
            && Equality.equals(poolFundPaid, other.poolFundPaid)
            && Equality.equals(civilServantFundPaid, other.civilServantFundPaid)
            && Equality.equals(seriousDiseaseAssistancePaid, other.seriousDiseaseAssistancePaid)
            && Equality.equals(seriousDiseaseInsurancePaid, other.seriousDiseaseInsurancePaid)
            && Equality.equals(civilAffairsAssistancePaid, other.civilAffairsAssistancePaid)
            && Equality.equals(otherFundPaid, other.otherFundPaid)
            && Equality.equals(accountPaid, other.accountPaid)
            && Equality.equals(accountBalance, other.accountBalance)
            && Equality.equals(cashPrepaid, other.cashPrepaid)
            && Equality.equals(cashRecharge, other.cashRecharge)
            && Equality.equals(cashRefund, other.cashRefund)
            && Equality.equals(chequePrepaid, other.chequePrepaid)
            && Equality.equals(chequeRecharge, other.chequeRecharge)
            && Equality.equals(chequeRefund, other.chequeRefund)
            && Equality.equals(bankTransferPrepaid, other.bankTransferPrepaid)
            && Equality.equals(bankTransferRecharge, other.bankTransferRecharge)
            && Equality.equals(bankTransferRefund, other.bankTransferRefund);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, selfCare);
    result = Hash.combine(result, multiplier, selfPaid);
    result = Hash.combine(result, multiplier, withinMedicare);
    result = Hash.combine(result, multiplier, medicarePaid);
    result = Hash.combine(result, multiplier, medicareDeductible);
    result = Hash.combine(result, multiplier, personalBurden);
    result = Hash.combine(result, multiplier, transferPrepaid);
    result = Hash.combine(result, multiplier, sectionalPaid);
    result = Hash.combine(result, multiplier, hospitalBurden);
    result = Hash.combine(result, multiplier, poolFundPaid);
    result = Hash.combine(result, multiplier, civilServantFundPaid);
    result = Hash.combine(result, multiplier, seriousDiseaseAssistancePaid);
    result = Hash.combine(result, multiplier, seriousDiseaseInsurancePaid);
    result = Hash.combine(result, multiplier, civilAffairsAssistancePaid);
    result = Hash.combine(result, multiplier, otherFundPaid);
    result = Hash.combine(result, multiplier, accountPaid);
    result = Hash.combine(result, multiplier, accountBalance);
    result = Hash.combine(result, multiplier, cashPrepaid);
    result = Hash.combine(result, multiplier, cashRecharge);
    result = Hash.combine(result, multiplier, cashRefund);
    result = Hash.combine(result, multiplier, chequePrepaid);
    result = Hash.combine(result, multiplier, chequeRecharge);
    result = Hash.combine(result, multiplier, chequeRefund);
    result = Hash.combine(result, multiplier, bankTransferPrepaid);
    result = Hash.combine(result, multiplier, bankTransferRecharge);
    result = Hash.combine(result, multiplier, bankTransferRefund);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("selfCare", selfCare)
            .append("selfPaid", selfPaid)
            .append("withinMedicare", withinMedicare)
            .append("medicarePaid", medicarePaid)
            .append("medicareDeductible", medicareDeductible)
            .append("personalBurden", personalBurden)
            .append("transferPrepaid", transferPrepaid)
            .append("sectionalPaid", sectionalPaid)
            .append("hospitalBurden", hospitalBurden)
            .append("poolFundPaid", poolFundPaid)
            .append("civilServantFundPaid", civilServantFundPaid)
            .append("seriousDiseaseAssistancePaid", seriousDiseaseAssistancePaid)
            .append("seriousDiseaseInsurancePaid", seriousDiseaseInsurancePaid)
            .append("civilAffairsAssistancePaid", civilAffairsAssistancePaid)
            .append("otherFundPaid", otherFundPaid)
            .append("accountPaid", accountPaid)
            .append("accountBalance", accountBalance)
            .append("cashPrepaid", cashPrepaid)
            .append("cashRecharge", cashRecharge)
            .append("cashRefund", cashRefund)
            .append("chequePrepaid", chequePrepaid)
            .append("chequeRecharge", chequeRecharge)
            .append("chequeRefund", chequeRefund)
            .append("bankTransferPrepaid", bankTransferPrepaid)
            .append("bankTransferRecharge", bankTransferRecharge)
            .append("bankTransferRefund", bankTransferRefund)
            .toString();
  }
}
