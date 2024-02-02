////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import java.util.Locale;

import ltd.qubit.commons.lang.EnumUtils;

import static ltd.qubit.commons.lang.EnumUtils.registerLocalizedNames;

/**
 * 此枚举退货发起方。
 *
 * @author 胡海星
 */
public enum ReturnIssuer {

  /**
   * 买家。
   */
  BUYER,

  /**
   * 卖家。
   */
  SELLER,

  /**
   * 平台。
   */
  PLATFORM,

  /**
   * 医保。
   */
  MEDICARE;

  static {
    registerLocalizedNames(ReturnIssuer.class, "i18n/common-model/return-issuer");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
