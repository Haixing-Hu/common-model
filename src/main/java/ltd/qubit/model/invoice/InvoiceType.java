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
 * 此枚举表示发票类型。
 *
 * @author 胡海星
 */
public enum InvoiceType {

  /**
   * 普通发票。
   */
  NORMAL,

  /**
   * 增值税专用发票。
   */
  VALUE_ADDED;

  static {
    registerLocalizedNames(InvoiceType.class, "i18n/common-model/invoice-type");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
