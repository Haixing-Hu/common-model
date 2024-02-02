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
 * 此枚举表示医保项目类型。
 *
 * @author 胡海星
 */
public enum MedicareItemType {

  /**
   * 药品。
   */
  DRUG,

  /**
   * 项目。
   */
  ITEM,

  /**
   * 材料。
   */
  MATERIAL,

  /**
   * 服务/设施。
   */
  SERVICE;

  static {
    registerLocalizedNames(MedicareItemType.class, "i18n/common-model/medicare-item-type");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }
}
