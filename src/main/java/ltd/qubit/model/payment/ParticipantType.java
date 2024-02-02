////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import java.util.Locale;

import ltd.qubit.commons.lang.EnumUtils;

import static ltd.qubit.commons.lang.EnumUtils.registerLocalizedNames;

/**
 * 此枚举表示交易参与者类型。
 *
 * @author 胡海星
 */
public enum ParticipantType {

  /**
   * 个人。
   */
  PERSON,

  /**
   * 组织机构。
   */
  ORGANIZATION;

  static {
    registerLocalizedNames(ParticipantType.class, "i18n/common-model/participant-type");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
