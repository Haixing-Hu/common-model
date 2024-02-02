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
 * 此枚举表示账户类型。
 *
 * @author 胡海星
 */
public enum AccountType {

  /**
   * 银行卡账户：用户的银行卡信息，每个卡对应一个账户。
   */
  BANK_CARD,

  /**
   * 信用卡账户：用户的信用卡信息，每个卡对应一个账户。
   */
  CREDIT_CARD,

  /**
   * 存折。
   */
  DEPOSIT_BOOK,

  /**
   * 第三方支付账户：用户在第三方支付机构建立的账户。
   */
  THIRD_PART,

  /**
   * 结算账户：用来支持和第三方支付公司、银行进行结算用。
   *
   * <p>第三方支付需要为每个商户号建立结算账号；银行需要为借记卡、贷记卡分别建立
   * 结算账号（银行卡直连时使用）。
   */
  SETTLEMENT,

  /**
   * 零钱账户：即电商的内部账号，用户、商户、清算单位需要建立零钱账户。
   */
  CHANGE,

  /**
   * 虚拟货币账户：用户和使用虚拟币的商户都需要建立虚拟币账户。
   */
  VIRTUAL;

  static {
    registerLocalizedNames(AccountType.class, "i18n/common-model/account-type");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
