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
 * 此枚举表示理赔状态的分类。
 *
 * @author 潘凯
 */
public enum InsuranceClaimStatusGroup {

  /**
   * 未提交。
   */
  NOT_SUBMITTED,

  /**
   * 待立案。
   */
  PENDING_CASE,

  /**
   * 已立案。
   */
  REGISTED,

  /**
   * 未达起付线。
   */
  UNREACHED,

  /**
   * 审核中。
   */
  UNDER_REVIEW,

  /**
   * 审核拒绝。
   */
  AUDIT_REJECTION,

  /**
   * 已驳回。
   */
  REJECTED,

  /**
   * 已结案。
   */
  COMPLETED,

  /**
   * 已取消。
   */
  CANCELD;
}
