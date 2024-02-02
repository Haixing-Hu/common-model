////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import java.io.Serializable;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 此模型封装了客户端提交订单后在 Response Body 中返回的 JSON 对象。
 *
 * @author 胡海星
 */
public class OrderSubmitResponse implements Serializable {

  private static final long serialVersionUID = -431994414512768181L;

  /**
   * 支付完成后页面跳转回的URL。
   */
  private String url;

  /**
   * 支付完成后页面跳转回的URL后面加的加密后的参数。
   */
  private String params;

  public OrderSubmitResponse() {
    // empty
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  public String getParams() {
    return params;
  }

  public void setParams(final String params) {
    this.params = params;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final OrderSubmitResponse other = (OrderSubmitResponse) o;
    return Equality.equals(url, other.url)
        && Equality.equals(params, other.params);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, url);
    result = Hash.combine(result, multiplier, params);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("url", url)
        .append("params", params)
        .toString();
  }
}
