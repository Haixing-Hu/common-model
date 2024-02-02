////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

/**
 * 此枚举表示处方单的状态。
 *
 * @author 胡海星
 */
public enum PrescriptionStatus {

  /**
   * 已被创建。
   */
  CREATED,

  /**
   * 已被院内审方药师审核过并通过。
   */
  AUDITOR_ACCEPTED,

  /**
   * 已被院内审方药师审核过并拒绝。
   */
  AUDITOR_REJECTED,

  /**
   * 已被第三方审方药师审核过并通过。
   */
  INSPECTOR_ACCEPTED,

  /**
   * 已被第三方审方药师审核过并拒绝。
   */
  INSPECTOR_REJECTED,

  /**
   * 已被患者接受。
   */
  PATIENT_ACCEPTED,

  /**
   * 已被患者拒绝。
   */
  PATIENT_REJECTED,

  /**
   * 已被流转到药房或医院。
   */
  TRANSFERRED,

  /**
   * 药房药师已配好药。
   */
  PREPARED,

  /**
   * 药房复核药师已复核过并通过。
   */
  REVIEWER_ACCEPTED,

  /**
   * 药房复核药师已复核过并拒绝。
   */
  REVIEWER_REJECTED,

  /**
   * 药房发药师已将药物发出。
   */
  DISPATCHED,

  /**
   * 患者已收到药品。
   */
  RECEIVED,

  /**
   * 已过期。
   */
  EXPIRED,

  /**
   * 已被取消。
   */
  CANCELLED,

}
