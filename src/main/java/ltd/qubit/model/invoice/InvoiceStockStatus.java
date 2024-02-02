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
 * 此枚举表示电子票据入库状态。
 *
 * @author 胡海星
 */
public enum InvoiceStockStatus {
  /**
   * 未入库。
   */
  UNSTOCKED,

  /**
   * 已入库。
   */
  STOCKED,

  /**
   * 已撤销。
   */
  CANCELLED;

  static {
    registerLocalizedNames(InvoiceStockStatus.class, "i18n/common-model/invoice-stock-status");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
