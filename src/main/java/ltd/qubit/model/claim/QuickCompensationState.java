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
 * 此枚举表示快赔状态。
 *
 * @author 潘凯
 */
public enum QuickCompensationState {

  /**
   * 快赔数据获取中。
   */
  FETCHING,

  /**
   * 快赔数据获取成功。
   */
  SUCCESS,

  /**
   * 快赔数据获取失败。
   */
  FAILED
}
