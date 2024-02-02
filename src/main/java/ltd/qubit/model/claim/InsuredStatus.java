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
 * 此枚举表示出险原因。
 *
 * @author 潘凯
 */
public enum InsuredStatus {

  /**
   * 痊愈。
   */
  RECOVERY,

  /**
   * 治疗中。
   */
  UNDER_TREATMENT,

  /**
   * 身故。
   */
  DEATH,

  /**
   * 其他。
   */
  OTHER
}
