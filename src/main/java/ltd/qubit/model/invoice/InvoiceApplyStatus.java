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
 * 此枚举表示申请状态。
 *
 * @author 胡海星
 */
public enum InvoiceApplyStatus {

  /**
   * 申请已提交，尚未被审核。
   */
  SUBMITTED,

  /**
   * 申请已被审核并通过。
   */
  APPROVED,

  /**
   * 申请已被审核但未通过。
   */
  REJECTED,

  /**
   * 申请已被撤销。
   */
  CANCELLED;

  static {
    registerLocalizedNames(InvoiceApplyStatus.class, "i18n/common-model/invoice-apply-status");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
