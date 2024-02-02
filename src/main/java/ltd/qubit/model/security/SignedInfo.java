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
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.security.SignatureAlgorithm;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.pair.KeyValuePairList;

/**
 * 此模型用来存储签名和摘要的信息以及使用的算法。
 *
 * @author 胡海星
 */
public class SignedInfo implements Serializable, Assignable<SignedInfo> {

  private static final long serialVersionUID = -8674638077270970368L;

  /**
   * 被签名的消息。
   *
   * <ul>
   * <li>如果被签名对象是个字符串或文本，则此字段为该字符串或文本的UTF-8编码表示；</li>
   * <li>如果被签名对象是个二进制文件或二进制数据，则此字符串为该文件的BASE-64编码；</li>
   * <li>如果被签名对象是个结构化对象，则此字段为该对象的正则化JSON编码，并以UTF-8字符串
   * 表示。</li>
   * </ul>
   * <p>
   */
  private String message;

  /**
   * 使用的签名算法。
   */
  private SignatureAlgorithm algorithm;

  /**
   * 密钥对的版本，通常是其public key的MD5哈希值；用于在密钥分发系统中区分不同
   * 版本的密钥。
   */
  @Size(min = 1, max = 64)
  private String keyVersion;

  /**
   * 密钥对的公钥。
   *
   * <p>公钥的标准编码格式为X.509格式，此字段存储该格式下编码的BASE-64编码字符串。</p>
   */
  @Size(min = 1, max = 4096)
  private String publicKey;

  /**
   * 签名者姓名（对于个人）或名称（对于机构或App）。
   */
  @Size(min = 1, max = 64)
  private String name;

  /**
   * 签名者证件类型，可以是身份证（对于个人），营业执照（对于机构）等。
   */
  private String credentialType;

  /**
   * 签名者证件号码。
   */
  @Size(min = 1, max = 128)
  private String credentialNumber;

  /**
   * 其他需要编码进被签名消息的额外数据。
   */
  @Size(min = 1, max = 16)
  @Nullable
  private KeyValuePairList payload;

  /**
   * 签名时的时间戳。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant timestamp;

  public SignedInfo() {
    // empty
  }

  public SignedInfo(final SignedInfo other) {
    assign(other);
  }

  @Override
  public void assign(final SignedInfo other) {
    Argument.requireNonNull("other", other);
    message = other.message;
    algorithm = other.algorithm;
    keyVersion = other.keyVersion;
    publicKey = other.publicKey;
    name = other.name;
    credentialType = other.credentialType;
    credentialNumber = other.credentialNumber;
    payload = Assignment.clone(other.payload);
    timestamp = other.timestamp;
  }

  @Override
  public SignedInfo clone() {
    return new SignedInfo(this);
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public SignatureAlgorithm getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(final SignatureAlgorithm algorithm) {
    this.algorithm = algorithm;
  }

  public String getKeyVersion() {
    return keyVersion;
  }

  public void setKeyVersion(final String keyVersion) {
    this.keyVersion = keyVersion;
  }

  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(final String publicKey) {
    this.publicKey = publicKey;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getCredentialType() {
    return credentialType;
  }

  public void setCredentialType(final String credentialType) {
    this.credentialType = credentialType;
  }

  public String getCredentialNumber() {
    return credentialNumber;
  }

  public void setCredentialNumber(final String credentialNumber) {
    this.credentialNumber = credentialNumber;
  }

  @Nullable
  public KeyValuePairList getPayload() {
    return payload;
  }

  public void setPayload(@Nullable final KeyValuePairList payload) {
    this.payload = payload;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(final Instant timestamp) {
    this.timestamp = timestamp;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final SignedInfo other = (SignedInfo) o;
    return Equality.equals(message, other.message)
        && Equality.equals(algorithm, other.algorithm)
        && Equality.equals(keyVersion, other.keyVersion)
        && Equality.equals(publicKey, other.publicKey)
        && Equality.equals(name, other.name)
        && Equality.equals(credentialType, other.credentialType)
        && Equality.equals(credentialNumber, other.credentialNumber)
        && Equality.equals(payload, other.payload)
        && Equality.equals(timestamp, other.timestamp);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, message);
    result = Hash.combine(result, multiplier, algorithm);
    result = Hash.combine(result, multiplier, keyVersion);
    result = Hash.combine(result, multiplier, publicKey);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, credentialType);
    result = Hash.combine(result, multiplier, credentialNumber);
    result = Hash.combine(result, multiplier, payload);
    result = Hash.combine(result, multiplier, timestamp);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("message", message)
        .append("algorithm", algorithm)
        .append("keyVersion", keyVersion)
        .append("publicKey", publicKey)
        .append("name", name)
        .append("credentialType", credentialType)
        .append("credentialNumber", credentialNumber)
        .append("payload", payload)
        .append("timestamp", timestamp)
        .toString();
  }
}
