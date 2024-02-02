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

import jakarta.xml.bind.annotation.XmlTransient;

import ltd.qubit.commons.lang.EnumUtils;

import static ltd.qubit.commons.lang.EnumUtils.registerLocalizedNames;

/**
 * 此枚举表示退货单的状态。
 *
 * @author 胡海星
 */
public enum ReturnStatus {

  /**
   * 表示退货单已超期失效。
   */
  EXPIRED(true),

  /**
   * 表示此退货单已被取消。
   */
  CANCELLED(true),

  /**
   * 已提交退货单。
   */
  SUBMITTED(false),

  /**
   * 表示退货单提交后已被商户接受。
   */
  ACCEPTED(false),

  /**
   * 表示退货单提交后已被商户拒绝。
   */
  REJECTED(true),

  /**
   * 表示退货单对应的货物已由买家发货给卖家。
   */
  SENT(false),

  /**
   * 表示货物已被卖家签收。
   */
  RECEIVED(false),

  /**
   * 表示此退货单已完成。
   */
  COMPLETED(true),

  /**
   * 表示退款流程正在进行中。
   */
  REFUNDING(false),

  /**
   * 表示退货单已退款，但退款失败。
   */
  REFUND_FAIL(true),

  /**
   * 表示退货单已退款，且退款成功。
   */
  REFUND_SUCCESS(true);

  @XmlTransient
  private final boolean finished;

  ReturnStatus(final boolean finished) {
    this.finished = finished;
  }

  /**
   * 判定此状态是否为终结状态。
   *
   * @return 若此状态为终结状态则返回{@code true}；否则返回{@code false}。
   */
  public final boolean isFinished() {
    return finished;
  }

  static {
    registerLocalizedNames(ReturnStatus.class, "i18n/common-model/return-status");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
