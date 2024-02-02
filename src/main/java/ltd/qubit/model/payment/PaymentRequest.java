////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import java.io.Serializable;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.settlement.Transaction;

/**
 * 此模型表示传递给支付系统的支付请求消息。
 *
 * @author 胡海星
 */
public class PaymentRequest implements Serializable {

  private static final long serialVersionUID = 2042458735640201034L;

  private static final Logger LOGGER = LoggerFactory.getLogger(PaymentRequest.class);

  /**
   * 提交的交易信息，注意此信息必须被过滤过。
   */
  private Transaction data;

  /**
   * 支付完成后跳转返回的URL。
   */
  private String returnUrl;

  /**
   * 支付完成后支付系统通过POST方法回写数据的URL。
   */
  private String notifyUrl;

  /**
   * 对本消息的JSON编码的RSA数字签名（不包含 signature 字段）。
   */
  @Nullable
  private String signature;

  public PaymentRequest() {}

  public PaymentRequest(final Transaction data, final String returnUrl) {
    this.data = data;
    this.returnUrl = returnUrl;
  }

  /**
   * 过滤不需要传输的数据。
   */
  public void filter() {
    if (data != null) {
      data.setType(null);
      data.setOriginId(null);
      data.setReturnId(null);
      data.setStatus(null);
      data.setApp(null);
      data.setSource(null);
      data.setCategory(null);
      data.setDiscount(null);
      data.setPaid(null);
      data.setPayee(null);
      data.setPayment(null);
      data.setCompleteTime(null);
      data.setInvoiceStatus(null);
      data.setComment(null);
      data.setEnvironment(null);
      data.setModifyTime(null);
      data.setDeleteTime(null);
      final Participant payer = data.getPayer();
      if (payer != null) {
        payer.setId(null);
        payer.setType(null);
        payer.setPhone(null);
        payer.setEmail(null);
        payer.setAccount(null);
      }
    }
  }

  public Transaction getData() {
    return data;
  }

  public void setData(final Transaction data) {
    this.data = data;
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

  public String getSignature() {
    return signature;
  }

  public void setSignature(final String signature) {
    this.signature = signature;
  }

  //  /**
  //   * 对此消息进行数字签名
  //   *
  //   * @param mapper
  //   *    JSON编码解码器
  //   * @param privateKey
  //   *    消息发送方的RSA私钥
  //   * @throws EncodingMessageFailedException
  //   *    若进行JSON编码解码时发生错误
  //   * @throws SignMessageFailedException
  //   *    若进行RSA数字签名时发生错误
  //   */
  //  public void sign(ObjectMapper mapper, String privateKey) {
  //    signature = null;
  //    try {
  //      String message = mapper.writeValueAsString(this);
  //      signature = RsaSignature.sign(privateKey, message);
  //    } catch (JsonProcessingException e) {
  //      LOGGER.error("An error occurs while serializing the request to JSON: {}\n{}",
  //              e.getMessage(), this, e);
  //      throw new EncodingMessageFailedException(e.getMessage());
  //    } catch (GeneralSecurityException e) {
  //      LOGGER.error("Failed to sign the request: {}\n{}", e.getMessage(), this, e);
  //      throw new SignMessageFailedException(e.getMessage());
  //    }
  //  }
  //
  //  /**
  //   * 验证此消息的数字签名
  //   *
  //   * @param mapper
  //   *    JSON编码解码器
  //   * @param publicKey
  //   *    消息发送方的RSA公钥
  //   * @return
  //   *    若数字签名正确，返回{@code true}；否则返回{@code false}。
  //   * @throws EncodingMessageFailedException
  //   *    若进行JSON编码解码时发生错误
  //   * @throws VerifySignatureFailedException
  //   *    若对RSA数字签名进行验证时发生错误
  //   */
  //  public boolean verify(ObjectMapper mapper, String publicKey) {
  //    PaymentRequest cloned = new PaymentRequest();
  //    cloned.data = this.data;
  //    cloned.returnUrl = this.returnUrl;
  //    cloned.notifyUrl = this.notifyUrl;
  //    cloned.signature = null;
  //    try {
  //      String message = mapper.writeValueAsString(cloned);
  //      return RsaSignature.verify(publicKey, message, signature);
  //    } catch (JsonProcessingException e) {
  //      LOGGER.error("An error occurs while serializing the request to JSON: {}\n{}",
  //              e.getMessage(), this, e);
  //      throw new EncodingMessageFailedException(e.getMessage());
  //    } catch (GeneralSecurityException e) {
  //      LOGGER.error("Failed to verify the signature of the request: {}\n{}",
  //              e.getMessage(), this, e);
  //      throw new VerifySignatureFailedException(e.getMessage());
  //    }
  //  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final PaymentRequest other = (PaymentRequest) o;
    return Equality.equals(data, other.data)
            && Equality.equals(returnUrl, other.returnUrl)
            && Equality.equals(notifyUrl, other.notifyUrl)
            && Equality.equals(signature, other.signature);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, data);
    result = Hash.combine(result, multiplier, returnUrl);
    result = Hash.combine(result, multiplier, notifyUrl);
    result = Hash.combine(result, multiplier, signature);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("data", data)
            .append("returnUrl", returnUrl)
            .append("notifyUrl", notifyUrl)
            .append("signature", signature)
            .toString();
  }
}
