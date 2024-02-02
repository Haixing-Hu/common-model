////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.util.Locale;

import ltd.qubit.commons.lang.EnumUtils;

import static ltd.qubit.commons.lang.EnumUtils.registerLocalizedNames;

/**
 * 此枚举表示医疗的类别。
 *
 * @author 胡海星
 */
public enum MedicalType {

  /**
   * 挂号。
   */
  REGISTRATION,

  /**
   *  门诊。
   */
  CLINIC,

  /**
   * 门特（门诊特定项目）。
   */
  SPECIFIC_CLINIC,

  /**
   * 急诊。
   */
  EMERGENT_CLINIC,

  /**
   *  住院。
   */
  HOSPITALIZATION,

  /**
   *  入院。
   */
  ADMISSION,

  /**
   * 出院。
   */
  DISCHARGE,

  /**
   * 体检。
   */
  EXAMINATION,

  /**
   * 互联网医院。
   */
  INTERNET,

  /**
   * 未知。
   */
  UNKNOWN;

  static {
    registerLocalizedNames(MedicalType.class, "i18n/common-model/medical-type");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
