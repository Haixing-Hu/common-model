////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

public enum OpenidType {

  /**
   * 微信。
   */
  WEIXIN,

  /**
   * 手机号。
   */
  MOBILE,

  /**
   * e签宝。
   */
  ESIGN;

  public static boolean isValid(final String openidTypeStr) {
    final OpenidType[] openidTypes = values();
    for (final OpenidType openidType : openidTypes) {
      if (openidType.name().equals(openidTypeStr)) {
        return true;
      }
    }
    return false;
  }

}
