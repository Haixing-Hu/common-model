////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.security;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import jakarta.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.json.JsonMapper;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.error.SignMessageException;
import ltd.qubit.commons.error.VerifySignatureException;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.security.SignatureAlgorithm;
import ltd.qubit.commons.security.SignaturePrivateKeyCodec;
import ltd.qubit.commons.security.SignaturePublicKeyCodec;
import ltd.qubit.commons.security.SignatureSigner;
import ltd.qubit.commons.security.SignatureVerifier;
import ltd.qubit.commons.text.jackson.JsonMapperUtils;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.codec.Base64Codec;
import ltd.qubit.commons.util.codec.DecodingException;
import ltd.qubit.commons.util.pair.KeyValuePairList;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 此模型表示数字签名。
 *
 * <p>此模型的设计借鉴了W3C的XML数字签名规范。
 *
 * @author 胡海星
 */
public class Signature implements Assignable<Signature>, Serializable {

  private static final long serialVersionUID = -1153714428771258276L;

  private static final Logger LOGGER = LoggerFactory.getLogger(Signature.class);

  /**
   * 对代签名消息文本的编码。
   */
  public static final Charset TEXT_ENCODING = UTF_8;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 该签名所属对象的类型。
   */
  private String ownerType;

  /**
   * 该签名所属对象的ID。
   */
  private Long ownerId;

  /**
   * 该签名签发者对象的类型。
   */
  @Size(min = 1, max = 64)
  private String signerType;

  /**
   * 该签名签发者对象的ID。
   */
  private Long signerId;

  /**
   * 该签名签发者对象的编码。
   */
  private String signerCode;

  /**
   * 签名和摘要相关信息，以及待签名的消息的数字摘要。
   */
  private SignedInfo signedInfo;

  /**
   * BASE64编码的签名值；通过签名{@link #signedInfo}的正则化JSON编码计算得到的签名值。
   */
  @Size(min = 1, max = 2048)
  private String signedValue;

  public Signature() {
    // empty
  }

  public Signature(final Signature other) {
    assign(other);
  }

  @Override
  public void assign(final Signature other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    ownerType = other.ownerType;
    ownerId = other.ownerId;
    signerType = other.signerType;
    signerId = other.signerId;
    signerCode = other.signerCode;
    signedInfo = Assignment.clone(other.signedInfo);
    signedValue = other.signedValue;
  }

  @Override
  public Signature clone() {
    return new Signature(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getOwnerType() {
    return ownerType;
  }

  public void setOwnerType(final String ownerType) {
    this.ownerType = ownerType;
  }

  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(final Long ownerId) {
    this.ownerId = ownerId;
  }

  public String getSignerType() {
    return signerType;
  }

  public void setSignerType(final String signerType) {
    this.signerType = signerType;
  }

  public Long getSignerId() {
    return signerId;
  }

  public void setSignerId(final Long signerId) {
    this.signerId = signerId;
  }

  public String getSignerCode() {
    return signerCode;
  }

  public void setSignerCode(final String signerCode) {
    this.signerCode = signerCode;
  }

  public SignedInfo getSignedInfo() {
    return signedInfo;
  }

  public void setSignedInfo(final SignedInfo signedInfo) {
    this.signedInfo = signedInfo;
  }

  public String getSignedValue() {
    return signedValue;
  }

  public void setSignedValue(final String signedValue) {
    this.signedValue = signedValue;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Signature other = (Signature) o;
    return Equality.equals(id, other.id)
        && Equality.equals(ownerType, other.ownerType)
        && Equality.equals(ownerId, other.ownerId)
        && Equality.equals(signerType, other.signerType)
        && Equality.equals(signerId, other.signerId)
        && Equality.equals(signerCode, other.signerCode)
        && Equality.equals(signedInfo, other.signedInfo)
        && Equality.equals(signedValue, other.signedValue);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, ownerType);
    result = Hash.combine(result, multiplier, ownerId);
    result = Hash.combine(result, multiplier, signerType);
    result = Hash.combine(result, multiplier, signerId);
    result = Hash.combine(result, multiplier, signerCode);
    result = Hash.combine(result, multiplier, signedInfo);
    result = Hash.combine(result, multiplier, signedValue);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("ownerType", ownerType)
        .append("ownerId", ownerId)
        .append("signerType", signerType)
        .append("signerId", signerId)
        .append("signerCode", signerCode)
        .append("signedInfo", signedInfo)
        .append("signedValue", signedValue)
        .toString();
  }

  /**
   * 为此签名设置一条payload数据。
   *
   * @param key
   *     主键
   * @param value
   *     值
   * @return 此对象本身。
   */
  public Signature setPayload(final String key, final Object value) {
    if (signedInfo == null) {
      signedInfo = new SignedInfo();
    }
    if (signedInfo.getPayload() == null) {
      signedInfo.setPayload(new KeyValuePairList());
    }
    signedInfo.getPayload().setValue(key, value);
    return this;
  }

  /**
   * 为此签名设置被封装的待签名消息。
   *
   * @param message
   *     待签名消息。
   * @return 此对象本身。
   */
  public Signature setMessage(final String message) {
    if (signedInfo == null) {
      signedInfo = new SignedInfo();
    }
    signedInfo.setMessage(message);
    return this;
  }

  /**
   * 对此签名封装的待签名消息进行数字签名。
   *
   * <p>此函数操作过程如下：</p>
   *
   * <ol>
   * <li>将当前时间戳（精确到秒）填入{@link #signedInfo}字段值的{@code timestamp}字段；</li>
   * <li>对{@link #signedInfo}字段值进行正则化JSON编码；</li>
   * <li>使用{@link #signedInfo}字段值的{@code algorithm}指定的算法对上一步
   * 计算出的正则化JSON字符串按照UTF-8字符集编码计算其数字签名；</li>
   * <li>对计算出的数字签名进行BASE64编码，填入{@link #signedValue}字段；</li>
   * </ol>
   *
   * @param privateKey
   *     用来签名的私钥，以BASE64编码，格式为{@code signedInfo.keyFormat}指定的格式。
   * @param mapper
   *     用来进行JSON序列化的{@link JsonMapper}。
   * @see JsonMapperUtils#formatNormalized(Object, JsonMapper)
   */
  public void sign(final String privateKey, final JsonMapper mapper)
      throws SignMessageException {
    final SignatureAlgorithm algorithm = signedInfo.getAlgorithm();
    final String message = signedInfo.getMessage();
    LOGGER.debug("Sign the message with algorithm {}: {}", algorithm, message);
    final SignaturePrivateKeyCodec privateKeyCodec = new SignaturePrivateKeyCodec(algorithm);
    final SignatureSigner signer = new SignatureSigner(algorithm);
    final Base64Codec base64Codec = new Base64Codec();
    final PrivateKey key;
    try {
      key = privateKeyCodec.decode(base64Codec.decode(privateKey));
    } catch (final DecodingException e) {
      throw new SignMessageException(e);
    }
    signedInfo.setTimestamp(Instant.now().truncatedTo(ChronoUnit.SECONDS));
    final byte[] signature = signer.sign(key, signedInfo, mapper);
    setSignedValue(base64Codec.encode(signature));
  }

  /**
   * 对指定的消息验证数字签名。
   *
   * <p>此函数操作过程如下：
   * <ol>
   * <li>对消息字符串使用UTF-8编码并转换为二进制；</li>
   * <li>使用{@code signedInfo.digestAlgorithm}指定的算法对上一步得到的二进制字节数
   * 组计算其数字摘要</li>
   * <li>对计算出的数字摘要进行BASE64编码，和{@code signedInfo.digestValue}字段比较</li>
   * <li>如果比较失败，则验证失败，消息的数字摘要和签名中的摘要不符合；</li>
   * <li>如果比较成功，则对{@code signedInfo}字段进行正则化JSON编码；</li>
   * <li>对上一步的序列化结果，使用UTF-8编码并转换为二进制，再次计算其数字摘要，
   * 这一步得到实际的数字摘要；</li>
   * <li>用{@code signedInfo.cryptAlgorithm}指定的算法和此函数参数提供的公钥解密
   * BASE64编码的{@code signedValue}，得到期望的数字摘要；</li>
   * <li>比较实际数字摘要和期望数字摘要是否一致，若一致则签名无误，否则签名有误。</li>
   * </ol>
   *
   * @return 若此签名验证正确，返回{@code true}；否则返回{@code false}。
   * @see JsonMapperUtils#formatNormalized(Object, JsonMapper)
   */
  public boolean verify(final JsonMapper mapper)
      throws VerifySignatureException {
    if (signedValue == null) {
      LOGGER.error("No signature.");
      return false;
    }
    final SignatureAlgorithm algorithm = signedInfo.getAlgorithm();
    LOGGER.debug("Verify the signature of the message with algorithm {}: {}",
        algorithm, signedInfo.getMessage());
    final SignaturePublicKeyCodec publicKeyCodec = new SignaturePublicKeyCodec(algorithm);
    final SignatureVerifier verifier = new SignatureVerifier(algorithm);
    final Base64Codec base64Codec = new Base64Codec();
    final PublicKey key;
    final byte[] signature;
    try {
      key = publicKeyCodec.decode(base64Codec.decode(signedInfo.getPublicKey()));
      signature = base64Codec.decode(signedValue);
    } catch (final DecodingException e) {
      LOGGER.error("Decoding failed: {}", e.getMessage(), e);
      return false;
    }
    return verifier.verify(key, signedInfo, mapper, signature);
  }
}
