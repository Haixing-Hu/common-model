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
 * 此模型封装了客户端提交退款申请时在 Request Body 提交中的 JSON 对象。
 *
 * @author 胡海星
 */
public class ClientRefundSubmitRequest implements Serializable {

  private static final long serialVersionUID = 3974432714894475467L;

  /**
   * 退款验证码。
   */
  private String verifyCode;

  /**
   * 退款的客户。
   */
  private Client client;

  /**
   * 退款完成后页面跳转回的URL。
   */
  private String returnUrl;

  /**
   * 支付完成后支付系统POST通知数据的URL地址。
   */
  private String notifyUrl;

  public String getVerifyCode() {
    return verifyCode;
  }

  public ClientRefundSubmitRequest setVerifyCode(final String verifyCode) {
    this.verifyCode = verifyCode;
    return this;
  }

  public Client getClient() {
    return client;
  }

  public ClientRefundSubmitRequest setClient(final Client client) {
    this.client = client;
    return this;
  }

  public String getReturnUrl() {
    return returnUrl;
  }

  public ClientRefundSubmitRequest setReturnUrl(final String returnUrl) {
    this.returnUrl = returnUrl;
    return this;
  }

  public String getNotifyUrl() {
    return notifyUrl;
  }

  public ClientRefundSubmitRequest setNotifyUrl(final String notifyUrl) {
    this.notifyUrl = notifyUrl;
    return this;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final ClientRefundSubmitRequest other = (ClientRefundSubmitRequest) o;
    return Equality.equals(verifyCode, other.verifyCode)
            && Equality.equals(client, other.client)
            && Equality.equals(returnUrl, other.returnUrl)
            && Equality.equals(notifyUrl, other.notifyUrl);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, verifyCode);
    result = Hash.combine(result, multiplier, client);
    result = Hash.combine(result, multiplier, returnUrl);
    result = Hash.combine(result, multiplier, notifyUrl);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("verifyCode", verifyCode)
            .append("client", client)
            .append("returnUrl", returnUrl)
            .append("notifyUrl", notifyUrl)
            .toString();
  }
}
