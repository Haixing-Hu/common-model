////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim.enterprise;

import java.util.Arrays;
import java.util.List;

/**
 * 此枚举表示理赔状态。
 *
 * @author 潘凯
 */
public enum EnterpriseClaimStatus {

  /**
   * 未提交。
   */
  NOT_SUBMITTED(EnterpriseClaimStatusGroup.NOT_SUBMITTED),

  /**
   * 待审核索赔申请书。
   */
  CLAIM_APPLICATION_WAIT_AUDIT(EnterpriseClaimStatusGroup.REGISTER),

  /**
   * 系统驳回。
   */
  SYSTEM_REJECTED(EnterpriseClaimStatusGroup.REJECT),

  /**
   * 索赔申请书审核通过。
   */
  CLAIM_APPLICATION_AUDITED(EnterpriseClaimStatusGroup.AUDIT),

  /**
   * 暂存待处理。
   */
  TEMPORARY_SAVED(EnterpriseClaimStatusGroup.AUDIT),

  /**
   * 待保司审核。
   */
  WAIT_INSURANCE_COMPANY_AUDITED(EnterpriseClaimStatusGroup.AUDIT),

  /**
   * 保司已结案。
   */
  INSURANCE_COMPANY_COMPLETED(EnterpriseClaimStatusGroup.COMPLETE),

  /**
   * 用户已取消。
   */
  CANCELED(EnterpriseClaimStatusGroup.CANCEL);

  private final EnterpriseClaimStatusGroup statusGroup;

  EnterpriseClaimStatus(final EnterpriseClaimStatusGroup statusGroup) {
    this.statusGroup = statusGroup;
  }

  public EnterpriseClaimStatusGroup getStatusGroup() {
    return this.statusGroup;
  }

  public static List<EnterpriseClaimStatus> listNotFinishedStatus() {
    return Arrays.asList(NOT_SUBMITTED, CLAIM_APPLICATION_WAIT_AUDIT, SYSTEM_REJECTED,
        CLAIM_APPLICATION_AUDITED, TEMPORARY_SAVED, WAIT_INSURANCE_COMPANY_AUDITED);
  }

}
