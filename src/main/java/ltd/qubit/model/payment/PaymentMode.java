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

import ltd.qubit.commons.lang.EnumUtils;

import static ltd.qubit.commons.lang.EnumUtils.registerLocalizedNames;

/**
 * 此枚举表示支付模式。
 *
 * @author 胡海星
 */
public enum PaymentMode {

  /**
   * 通过支付渠道提供的 App 支付。
   */
  APP,

  /**
   * 通过支付渠道提供的小程序 App 支付。
   */
  LITE_APP,

  /**
   * 通过支付渠道提供的移动端网站支付。
   */
  WAP,

  /**
   * 通过支付渠道提供的PC网站支付。
   */
  WEB,

  /**
   * 通过扫码等方式进入商家H5页面，在APP内置浏览器支付。
   */
  JSAPI,

  /**
   * 通过支付渠道提供的App扫商家的二维码支付。
   */
  ACTIVE_QR,

  /**
   * 通过支付渠道提供支付二维码被商家扫码支付。
   */
  PASSIVE_QR,

  /**
   * 通过线下转账的方式进行支付。
   */
  OFFLINE,

  /**
   * 未知模式。
   *
   * <p>在某些情况下暂时不知道支付模式，但该字段非空，所以需要一个占位符。
   */
  UNKNOWN;

  static {
    registerLocalizedNames(PaymentMode.class, "i18n/common-model/payment-mode");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
