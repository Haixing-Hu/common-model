////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim;

import java.util.Arrays;
import java.util.List;

/**
 * 此枚举表示理赔状态。
 *
 * @author 潘凯
 */
public enum InsuranceClaimStatus {

  /**
   * 未提交。
   */
  NOT_SUBMITTED(InsuranceClaimStatusGroup.NOT_SUBMITTED),

  /**
   * 待审核索赔申请书。
   */
  CLAIM_APPLICATION_WAIT_AUDIT(InsuranceClaimStatusGroup.PENDING_CASE),

  /**
   * 索赔申请书审核通过。
   */
  CLAIM_APPLICATION_AUDITED(InsuranceClaimStatusGroup.PENDING_CASE),

  /**
   * 暂存待处理。
   */
  TEMPORARY_SAVED(InsuranceClaimStatusGroup.PENDING_CASE),

  /**
   * 系统审核通过(数据没有提交给保险公司)。
   */
  SYSTEM_AUDITED(InsuranceClaimStatusGroup.UNREACHED),

  /**
   * 系统驳回。
   */
  SYSTEM_REJECTED(InsuranceClaimStatusGroup.REJECTED),

  /**
   * 待保司审核。
   */
  WAIT_INSURANCE_COMPANY_AUDITED(InsuranceClaimStatusGroup.REGISTED),

  /**
   * 保司受理中。
   */
  INSURANCE_COMPANY_ACCEPTED(InsuranceClaimStatusGroup.UNDER_REVIEW),

  /**
   * 保司驳回。
   */
  INSURANCE_COMPANY_REJECTED(InsuranceClaimStatusGroup.AUDIT_REJECTION),

  /**
   * 保司已结案。
   */
  INSURANCE_COMPANY_COMPLETED(InsuranceClaimStatusGroup.COMPLETED),

  /**
   * 保司案件注销/拒赔。
   */
  INSURANCE_COMPANY_ANNUL_OR_REFUSED(InsuranceClaimStatusGroup.AUDIT_REJECTION),

  /**
   * 用户已取消。
   */
  CANCELED(InsuranceClaimStatusGroup.CANCELD);

  private InsuranceClaimStatusGroup statusGroup;

  private InsuranceClaimStatus(final InsuranceClaimStatusGroup statusGroup) {
    this.statusGroup = statusGroup;
  }

  public InsuranceClaimStatusGroup getStatusGroup() {
    return this.statusGroup;
  }

  public static List<InsuranceClaimStatus> listNotFinishedStatus() {
    return Arrays.asList(NOT_SUBMITTED, CLAIM_APPLICATION_WAIT_AUDIT, CLAIM_APPLICATION_AUDITED,
        TEMPORARY_SAVED, SYSTEM_REJECTED, WAIT_INSURANCE_COMPANY_AUDITED,
        INSURANCE_COMPANY_ACCEPTED, INSURANCE_COMPANY_REJECTED);
  }

}
