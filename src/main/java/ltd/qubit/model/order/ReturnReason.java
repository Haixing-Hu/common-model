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
 * 此枚举表示退货原因。
 *
 * @author 胡海星
 */
public enum ReturnReason {

  /**
   * 无理由退货。
   */
  NO_REASON,

  /**
   * 购买人无资质购买此商品。
   */
  BUYER_INCAPABLE,

  /**
   * 商品缺货。
   */
  OUT_OF_STOCK,

  /**
   * 商品停售。
   */
  STOP_SELLING,

  /**
   * 购买人不喜欢此商品。
   */
  DISLIKE,

  /**
   * 购买人不再想要此商品。
   */
  DONT_WANT,

  /**
   * 误操作购买了此商品。
   */
  MISOPERATION,

  /**
   * 缺件少件。
   */
  LACK_OF_PART,

  /**
   * 收货时发现破损/污渍/变形。
   */
  BROKEN_PRODUCT,

  /**
   * 卖家发错货。
   */
  WRONG_PRODUCT,

  /**
   * 产品已过期。
   */
  EXPIRED_PRODUCT,

  /**
   * 商品存在质量问题。
   */
  QUALITY_PROBLEMS,

  /**
   * 商品描述与实物不符合。
   */
  MISMATCH_DESCRIPTION,

  /**
   * 买贵了。
   */
  TOO_EXPENSIVE,

  /**
   * 买到了赝品。
   */
  IMITATION;

  static {
    registerLocalizedNames(ReturnReason.class, "i18n/common-model/return-reason");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
