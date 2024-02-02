////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

/**
 * 此枚举表示订单推广的状态。
 *
 * @author 潘凯
 */
public enum RefererOrderRecordStatus {

  /**
   * 表示已提交。
   */
  SUBMITTED,

  /**
   * 表示已支付过但支付失败。
   */
  PAID_FAIL,

  /**
   * 表示已成功支付过。
   */
  PAID_SUCCESS,

  /**
   * 表示已退款。
   */
  REFUND,
}
