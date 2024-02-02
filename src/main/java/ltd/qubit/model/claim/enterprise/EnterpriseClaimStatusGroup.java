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
 * 此枚举表示理赔状态的分类。
 *
 * @author 潘凯
 */
public enum EnterpriseClaimStatusGroup {

  /**
   * 未提交。
   */
  NOT_SUBMITTED,

  /**
   * 立案。
   */
  REGISTER,

  /**
   * 审核。
   */
  AUDIT,

  /**
   * 驳回。
   */
  REJECT,

  /**
   * 结案。
   */
  COMPLETE,

  /**
   * 取消。
   */
  CANCEL
}
