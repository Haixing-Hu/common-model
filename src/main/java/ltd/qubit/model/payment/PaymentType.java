////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import java.util.Locale;

import jakarta.xml.bind.annotation.XmlTransient;

import ltd.qubit.commons.lang.ArrayUtils;
import ltd.qubit.commons.lang.EnumUtils;
import ltd.qubit.model.settlement.TransactionType;

import static ltd.qubit.commons.lang.EnumUtils.registerLocalizedNames;

/**
 * 此枚举表示支付类型。
 *
 * @author 胡海星
 */
public enum PaymentType {

  /**
   * 付款。
   */
  PAY(TransactionType.BUY),

  /**
   * 退款。
   */
  REFUND(TransactionType.REFUND);

  static {
    registerLocalizedNames(PaymentType.class, "i18n/common-model/payment-type");
  }

  @XmlTransient
  private final TransactionType[] compatibleTypes;

  PaymentType(final TransactionType ... compatibleTypes) {
    this.compatibleTypes = compatibleTypes;
  }

  public boolean match(final TransactionType type) {
    return ArrayUtils.contains(compatibleTypes, type);
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
