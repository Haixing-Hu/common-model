////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.shipping;

import java.util.Locale;

import ltd.qubit.commons.lang.EnumUtils;

import static ltd.qubit.commons.lang.EnumUtils.registerLocalizedNames;

/**
 * 此枚举表示货物的包装方式。
 *
 * @author 胡海星
 */
public enum Packing {

  /**
   * 正常打包。
   */
  NORMAL,

  /**
   * 普通加固。
   */
  REINFORCEMENT,

  /**
   * 打木架。
   */
  WOODEN_FRAME;

  static {
    registerLocalizedNames(Packing.class, "i18n/common-model/packing");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
