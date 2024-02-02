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
 * 此枚举表示确认订单的状态。
 *
 * @author 潘凯
 */
public enum ConfirmStatus {

  /**
   * 表示已超期失效。
   */
  EXPIRED,

  /**
   * 表示已被用户接受。
   */
  ACCEPTED,

  /**
   * 表示退已被用户拒绝。
   */
  REJECTED

}
