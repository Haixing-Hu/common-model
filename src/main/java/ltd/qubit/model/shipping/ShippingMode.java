////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.shipping;

import java.util.Locale;

import ltd.qubit.commons.lang.EnumUtils;

import static ltd.qubit.commons.lang.EnumUtils.registerLocalizedNames;

/**
 * 此枚举表示配送方式。
 *
 * @author 胡海星
 */
public enum ShippingMode {

  /**
   * 无需配送。
   */
  NONE,

  /**
   * 快递。
   */
  EXPRESS,

  /**
   * 自提。
   */
  SELF,

  /**
   * 电子邮件发送。
   */
  EMAIL,

  /**
   * 手机短信发送。
   */
  SMS;

  static {
    registerLocalizedNames(ShippingMode.class, "i18n/common-model/shipping-mode");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
