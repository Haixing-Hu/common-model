////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.audit;

/**
 * 此枚举表示审核状态。
 *
 * @author 王佳，胡海星
 */
public enum AuditStatus {
  /**
   * 尚未开始审核。
   */
  NOT_START,

  /**
   * 已审核，结果为接受。
   */
  ACCEPT,

  /**
   * 已审核，结果为拒绝。
   */
  REJECT,

  /**
   * 已审核，审核结果延后决定。
   */
  PENDING,
}
