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
 * 此模型封装了客户端提交订单时在 Request Body 提交中的 JSON 对象。
 *
 * @author 胡海星
 */
public class OrderSubmitRequest implements Serializable {

  private static final long serialVersionUID = 7432184170669421792L;

  /**
   * 订单信息。
   */
  private Order order;

  /**
   * 支付完成后页面跳转回的URL。
   */
  private String returnUrl;

  /**
   * 支付完成后支付系统POST通知数据的URL地址。
   */
  private String notifyUrl;

  public OrderSubmitRequest() {
    // empty
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(final Order order) {
    this.order = order;
  }

  public String getReturnUrl() {
    return returnUrl;
  }

  public void setReturnUrl(final String returnUrl) {
    this.returnUrl = returnUrl;
  }

  public String getNotifyUrl() {
    return notifyUrl;
  }

  public void setNotifyUrl(final String notifyUrl) {
    this.notifyUrl = notifyUrl;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final OrderSubmitRequest other = (OrderSubmitRequest) o;
    return Equality.equals(order, other.order)
        && Equality.equals(returnUrl, other.returnUrl)
        && Equality.equals(notifyUrl, other.notifyUrl);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, order);
    result = Hash.combine(result, multiplier, returnUrl);
    result = Hash.combine(result, multiplier, notifyUrl);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("order", order)
        .append("returnUrl", returnUrl)
        .append("notifyUrl", notifyUrl)
        .toString();
  }
}
