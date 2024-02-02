////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.commons;

/**
 * 此枚举表示实体类型的状态。
 *
 * @author 胡海星
 */
public enum State {

  /**
   * 未激活。
   */
  INACTIVE,

  /**
   * 正常。
   */
  NORMAL,

  /**
   * (临时性地)锁定/冻结。
   */
  LOCKED,

  /**
   * (永久性地)屏蔽/封杀。
   */
  BLOCKED,

  /**
   * 已废弃。
   */
  OBSOLETED,    // FIXME: 是否需要单独的ErrorCode?

  /**
   * 禁用。
   */
  DISABLED;
}
