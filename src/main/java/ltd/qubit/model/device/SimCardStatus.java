////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.device;

/**
 * 此枚举表示SIM卡的状态。
 *
 * @author 胡海星
 */
public enum SimCardStatus {
  /**
   * 未知。
   */
  UNKNOWN,

  /**
   * 未插入。
   */
  ABSENT,

  /**
   * 已被锁定，需要用户的 SIM PIN 解锁。
   */
  PIN_REQUIRED,

  /**
   * 已被锁定，需要用户的 SIM PUK 解锁。
   */
  PUK_REQUIRED,

  /**
   * 网络已被锁定，需要用户的网络 PIN 解锁。
   */
  NETWORK_LOCKED,

  /**
   * 已就绪。
   */
  READY,

  /**
   * 未就绪。
   */
  NOT_READY,

  /**
   * 永久性被禁用。
   */
  PERM_DISABLED,

  /**
   * 出现I/O错误。
   */
  CARD_IO_ERROR,

  /**
   * 受到运营商限制而不可用。
   */
  CARD_RESTRICTED,
}
