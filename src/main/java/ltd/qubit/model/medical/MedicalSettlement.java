////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.util.List;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.settlement.Settlement;

/**
 * 此模型表示医疗费用结算信息。
 *
 * @author 胡海星
 */
public class MedicalSettlement extends Settlement {

  private static final long serialVersionUID = 1254312672513946475L;

  /**
   * 医保类别。
   */
  private MedicareType medicare;

  /**
   * 患者信息。
   */
  private PatientInfo patient;

  /**
   * 患者使用的医疗卡。
   */
  private CredentialInfo card;

  /**
   * HIS信息。
   */
  private HisInfo hisInfo;

  /**
   * 支付信息。
   */
  private MedicalPayment payment;

  /**
   * 结算明细清单。
   */
  private List<MedicalSettlementItem> items;

  public MedicalSettlement() {}

  public MedicareType getMedicare() {
    return medicare;
  }

  public void setMedicare(final MedicareType medicare) {
    this.medicare = medicare;
  }

  public PatientInfo getPatient() {
    return patient;
  }

  public void setPatient(final PatientInfo patient) {
    this.patient = patient;
  }

  public CredentialInfo getCard() {
    return card;
  }

  public void setCard(final CredentialInfo card) {
    this.card = card;
  }

  public HisInfo getHisInfo() {
    return hisInfo;
  }

  public void setHisInfo(final HisInfo hisInfo) {
    this.hisInfo = hisInfo;
  }

  public MedicalPayment getPayment() {
    return payment;
  }

  public void setPayment(final MedicalPayment payment) {
    this.payment = payment;
  }

  public List<MedicalSettlementItem> getItems() {
    return items;
  }

  public void setItems(final List<MedicalSettlementItem> items) {
    this.items = items;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final MedicalSettlement other = (MedicalSettlement) o;
    return super.equals(other)
            && Equality.equals(medicare, other.medicare)
            && Equality.equals(patient, other.patient)
            && Equality.equals(card, other.card)
            && Equality.equals(hisInfo, other.hisInfo)
            && Equality.equals(payment, other.payment)
            && Equality.equals(items, other.items);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, super.hashCode());
    result = Hash.combine(result, multiplier, medicare);
    result = Hash.combine(result, multiplier, patient);
    result = Hash.combine(result, multiplier, card);
    result = Hash.combine(result, multiplier, hisInfo);
    result = Hash.combine(result, multiplier, payment);
    result = Hash.combine(result, multiplier, items);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .appendSuper(super.toString())
            .append("medicare", medicare)
            .append("patient", patient)
            .append("card", card)
            .append("hisInfo", hisInfo)
            .append("payment", payment)
            .append("items", items)
            .toString();
  }
}
