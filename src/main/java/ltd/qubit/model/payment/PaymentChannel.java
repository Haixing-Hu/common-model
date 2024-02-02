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
 * 此枚举类表示支付渠道。
 *
 * @author 胡海星
 */
public enum PaymentChannel {

  /**
   * 支付宝。
   */
  ALIPAY,

  /**
   * 微信支付。
   */
  WECHAT_PAY,

  /**
   * QQ 支付。
   */
  QQ_PAY,

  /**
   * 百度钱包。
   */
  BAIDU_PAY,

  /**
   * 京东钱包。
   */
  JD_PAY,

  /**
   * Paypal。
   */
  PAYPAL,

  /**
   * 银联。
   */
  UNION_PAY,

  /**
   * 苹果公司的 Apple Pay。
   */
  APPLE_PAY,

  /**
   * 招行一网通。
   */
  CMB_WALLET,

  /**
   * 银行卡或信用卡开户行直接提供的支付渠道。
   */
  BANK,

  /**
   * 通过余额支付。
   */
  BALANCE,

  /**
   * 医保个账支付。
   */
  MEDICARE,

  /**
   * 未知模式。
   *
   * <p>在某些情况下暂时不知道支付渠道，但该字段非空，所以需要一个占位符。
   */
  UNKNOWN;

  static {
    registerLocalizedNames(PaymentChannel.class, "i18n/common-model/payment-channel");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
