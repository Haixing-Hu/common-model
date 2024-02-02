////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.invoice;

import java.util.Locale;

import ltd.qubit.commons.lang.EnumUtils;

import static ltd.qubit.commons.lang.EnumUtils.registerLocalizedNames;

/**
 * 此枚举表示开发票状态。
 *
 * @author 胡海星
 */
public enum InvoiceStatus {

  /**
   * 无发票（不可开发票）。
   */
  NO_INVOICE,

  /**
   * 不需要开发票。
   */
  NOT_REQUIRED,

  /**
   * 需要开发票但尚未开具。
   */
  NOT_PRINTED,

  /**
   * 已开具。
   */
  PRINTED,

  /**
   * 已重开。
   */
  REPRINTED,

  /**
   * 已作废/已冲红。
   */
  INVALID;

  static {
    registerLocalizedNames(InvoiceStatus.class, "i18n/common-model/invoice-status");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
