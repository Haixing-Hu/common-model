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
 * 此枚举表示订单状态。
 *
 * <p>订单状态按照下述规则转换：
 *
 * <ul>
 * <li>用户提交订单后，订单状态标记为{@link #SUBMITTED}；下一步需等待商户审核订单；</li>
 * <li>商户审核订单后，若拒绝则订单状态标记为{@link #REJECTED}；该订单失效，生命周期结束；</li>
 * <li>商户审核订单后，若接受则订单状态标记为{@link #ACCEPTED}；下一步需等待用户支付；</li>
 * <li>用户完成支付后，若支付失败，订单状态标记为{@link #PAID_FAIL}；下一步可等待用户取消订单或重新支付；</li>
 * <li>用户完成支付后，若支付成功，订单状态标记为{@link #PAID_SUCCESS}；下一步可等待商户发货；</li>
 * <li>商户发货后，订单状态标记为{@link #SENT}</li>
 * <li>货物被用户签收后，订单状态标记为{@link #RECEIVED}</li>
 * <li>用户确认收货后，订单状态标记为{@link #COMPLETED}</li>
 * <li>订单处于{@link #SUBMITTED}, {@link #ACCEPTED}, {@link #PAID_FAIL},
 * {@link #PAID_SUCCESS}, {@link #SENT},
 * 任何一个过程中，用户都可以取消订单；取消订单后，订单状态标记为{@link #CANCELLED}</li>
 * </ul>
 *
 * @author 胡海星
 */
public enum OrderStatus {

  /**
   * 表示订单已超期失效。
   */
  EXPIRED,

  /**
   * 表示订单已被取消。
   */
  CANCELLED,

  /**
   * 表示此订单已提交。
   */
  SUBMITTED,

  /**
   * 表示此订单提交后已被商户接受。
   */
  ACCEPTED,

  /**
   * 表示此订单提交后已被商户拒绝。
   */
  REJECTED,

  /**
   * 表示此订单已支付过但支付失败。
   */
  PAID_FAIL,

  /**
   * 表示此订单已成功支付过。
   */
  PAID_SUCCESS,

  /**
   * 表示此订单已发货。
   */
  SENT,

  /**
   * 表示货物已被签收。
   */
  RECEIVED,

  /**
   * 表示此订单已完成。
   */
  COMPLETED;

  static {
    registerLocalizedNames(OrderStatus.class, "i18n/common-model/order-status");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
