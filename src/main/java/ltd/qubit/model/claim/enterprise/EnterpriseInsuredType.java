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
 * 企业出险人类别。
 */
public enum EnterpriseInsuredType {

  /**
   * 在职。
   */
  IN_SERVICE("10", "在职"),

  /**
   * 退休。
   */
  RETIRED("11", "退休"),

  /**
   * 退职。
   */
  RESIGNED("12", "退职"),

  /**
   * 70岁以上。
   */
  OVER_SEVENTY("13", "70岁以上"),

  /**
   * 独生子女<=16。
   */
  ONLY_CHILD("31", "独生子女<=16"),

  /**
   * 子女供属。
   */
  CHILD_DONOR_GENUS("32", "子女供属"),

  /**
   * 供属。
   */
  DONOR_GENUS("41", "供属");

  private String code;

  private String desc;

  EnterpriseInsuredType(final String code, final String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(final String desc) {
    this.desc = desc;
  }

}
