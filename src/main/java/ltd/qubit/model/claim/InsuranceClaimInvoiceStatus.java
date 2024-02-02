////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim;

/**
 * 此枚举表示理赔发票的状态。
 *
 * @author 潘凯
 */
public enum InsuranceClaimInvoiceStatus {

  /**
   * 已保存。
   */
  SAVED,

  /**
   * 已忽略，快赔金额大于发票金额。
   */
  IGNORED_GT,

  /**
   * 已忽略，快赔金额小于发票金额。
   */
  IGNORED_LT,

  /**
   * 已忽略，无此发票数据。
   */
  IGNORED_NONE,

  /**
   * 医保禁用费用。
   */
  IGNORED_MEDICARE_PROHIBITED,

  /**
   * 重复保存。
   */
  IGNORED_REPEAT
}
