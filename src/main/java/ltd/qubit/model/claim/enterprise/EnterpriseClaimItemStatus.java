////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim.enterprise;

/**
 * 此枚举表示理赔分单状态。
 *
 * @author 潘凯
 */
public enum EnterpriseClaimItemStatus {

  /**
   * 新建待理算。
   */
  CREATED,

  /**
   * 无效。
   */
  DISABLED,

  /**
   * 理算完成。
   */
  COMPLETED
}
