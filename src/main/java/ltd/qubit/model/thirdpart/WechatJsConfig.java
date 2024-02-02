////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.thirdpart;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 此模型表示微信的JSAPI配置。
 *
 * @author 胡海星
 */
public class WechatJsConfig {

  private static final long serialVersionUID = 3545033771231630410L;

  private String appId;

  private String timestamp;

  private String nonceStr;

  private String signature;

  public WechatJsConfig() {
    // empty
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(final String appId) {
    this.appId = appId;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(final String timestamp) {
    this.timestamp = timestamp;
  }

  public String getNonceStr() {
    return nonceStr;
  }

  public void setNonceStr(final String nonceStr) {
    this.nonceStr = nonceStr;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(final String signature) {
    this.signature = signature;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final WechatJsConfig other = (WechatJsConfig) o;
    return Equality.equals(appId, other.appId)
        && Equality.equals(timestamp, other.timestamp)
        && Equality.equals(nonceStr, other.nonceStr)
        && Equality.equals(signature, other.signature);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, appId);
    result = Hash.combine(result, multiplier, timestamp);
    result = Hash.combine(result, multiplier, nonceStr);
    result = Hash.combine(result, multiplier, signature);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("appId", appId)
        .append("timestamp", timestamp)
        .append("nonceStr", nonceStr)
        .append("signature", signature)
        .toString();
  }
}
