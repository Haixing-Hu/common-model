////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim.enterprise;

/**
 * 人员归属枚举。
 */
public enum EnterpriseOwnership {

  YANGTZE("1", "扬子"),

  REFORM("0", "改制"),

  CO_SOLUTION("2", "协解"),

  TEST("z", "测试");

  private final String code;

  private final String desc;

  EnterpriseOwnership(final String code, final String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }
}
