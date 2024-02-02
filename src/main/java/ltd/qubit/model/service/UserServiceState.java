////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.service;

/**
 * 此枚举表示用户医疗服务项目状态。
 *
 * @author pino
 */
public enum UserServiceState {
  /**
   * 有效。
   */
  VALID,

  /**
   * 无效。
   */
  INVALID,

  /**
   * 预约进行中。
   */
  APPOINTMENT_PROGRESS,

  /**
   *  预约成功。
   */
  APPOINTMENT_SUCCESS,
}
