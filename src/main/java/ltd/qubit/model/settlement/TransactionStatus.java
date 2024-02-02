////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.settlement;

/**
 * 此枚举表示交易状态。
 *
 * @author 胡海星
 */
public enum TransactionStatus {

  /**
   * 表示交易已失效。
   */
  EXPIRED,

  /**
   * 表示此交易已提交。
   */
  SUBMITTED,

  /**
   * 表示此交易已失败。
   */
  FAIL,

  /**
   * 表示此交易已成功。
   */
  SUCCESS,

  /**
   * 表示此交易已取消。
   */
  CANCELLED,
}
