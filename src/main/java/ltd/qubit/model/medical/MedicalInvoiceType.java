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
 * 此枚举表示医疗发票的类别。
 *
 * @author 潘凯
 */
public enum MedicalInvoiceType {

  /**
   *  门诊大病。
   */
  CLINIC_SERIOUS_ILLNESS,

  /**
   *  门特。
   */
  CLINIC_SPECIAL,

  /**
   *  住院。
   */
  HOSPITAL,

  /**
   *  其他。
   */
  OTHER
}
