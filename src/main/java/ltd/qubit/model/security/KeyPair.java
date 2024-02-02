////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.security;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.security.KeyFormat;
import ltd.qubit.commons.security.SignatureAlgorithm;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.State;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Stateful;

/**
 * 此模型表示用于数字签名的密钥对。
 *
 * @author 胡海星
 */
public class KeyPair implements Identifiable, Stateful, Auditable, Assignable<KeyPair> {

  private static final long serialVersionUID = 8102677805129811441L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所有者类型。
   */
  @Size(min = 1, max = 64)
  private String ownerType;

  /**
   * 所有者ID。
   */
  private Long ownerId;

  /**
   * 所有者编码。
   */
  @Nullable
  private String ownerCode;

  /**
   * 使用的数字签名算法。
   */
  private SignatureAlgorithm algorithm;

  /**
   * 密钥对的编码格式。
   */
  private KeyFormat format;

  /**
   * 版本标记。
   */
  @Size(min = 1, max = 64)
  private String version;

  /**
   * 公钥。
   */
  @Size(min = 1, max = 4096)
  private String publicKey;

  /**
   * 私钥，可以不存储在本系统内。
   */
  @Size(min = 1, max = 4096)
  @Nullable
  private String privateKey;

  /**
   * 状态。
   */
  private State state = State.NORMAL;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public KeyPair() {
    // empty
  }

  public KeyPair(final KeyPair other) {
    assign(other);
  }

  @Override
  public void assign(final KeyPair other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    ownerType = other.ownerType;
    ownerId = other.ownerId;
    ownerCode = other.ownerCode;
    algorithm = other.algorithm;
    format = other.format;
    version = other.version;
    publicKey = other.publicKey;
    privateKey = other.privateKey;
    state = other.state;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public KeyPair clone() {
    return new KeyPair(this);
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

  @Nullable
  public String getOwnerCode() {
    return ownerCode;
  }

  public void setOwnerCode(@Nullable final String ownerCode) {
    this.ownerCode = ownerCode;
  }

  public SignatureAlgorithm getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(final SignatureAlgorithm algorithm) {
    this.algorithm = algorithm;
  }

  public KeyFormat getFormat() {
    return format;
  }

  public void setFormat(final KeyFormat format) {
    this.format = format;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(final String version) {
    this.version = version;
  }

  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(final String publicKey) {
    this.publicKey = publicKey;
  }

  @Nullable
  public String getPrivateKey() {
    return privateKey;
  }

  public void setPrivateKey(@Nullable final String privateKey) {
    this.privateKey = privateKey;
  }

  public State getState() {
    return state;
  }

  public void setState(final State state) {
    this.state = state;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  @Nullable
  public Instant getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(@Nullable final Instant modifyTime) {
    this.modifyTime = modifyTime;
  }

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final KeyPair other = (KeyPair) o;
    return Equality.equals(id, other.id)
        && Equality.equals(ownerType, other.ownerType)
        && Equality.equals(ownerId, other.ownerId)
        && Equality.equals(ownerCode, other.ownerCode)
        && Equality.equals(algorithm, other.algorithm)
        && Equality.equals(format, other.format)
        && Equality.equals(version, other.version)
        && Equality.equals(publicKey, other.publicKey)
        && Equality.equals(privateKey, other.privateKey)
        && Equality.equals(state, other.state)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, ownerType);
    result = Hash.combine(result, multiplier, ownerId);
    result = Hash.combine(result, multiplier, ownerCode);
    result = Hash.combine(result, multiplier, algorithm);
    result = Hash.combine(result, multiplier, format);
    result = Hash.combine(result, multiplier, version);
    result = Hash.combine(result, multiplier, publicKey);
    result = Hash.combine(result, multiplier, privateKey);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("ownerType", ownerType)
        .append("ownerId", ownerId)
        .append("ownerCode", ownerCode)
        .append("algorithm", algorithm)
        .append("format", format)
        .append("version", version)
        .append("publicKey", publicKey)
        .append("privateKey", privateKey)
        .append("state", state)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }

  /**
   * 检测此密钥对是否匹配指定的数字签名。
   *
   * @param signature
   *     指定的数字签名。
   * @return 若此密钥对匹配指定的数字签名，返回{@code true}；否则返回{@code false}。
   */
  public boolean match(final Signature signature) {
    if (signature == null) {
      return false;
    }
    return Equality.equals(ownerType, signature.getSignerType())
        && Equality.equals(ownerId, signature.getSignerId())
        && match(signature.getSignedInfo());
  }

  /**
   * 检测此密钥对是否匹配指定的数字签名参数。
   *
   * @param signedInfo
   *     指定的数字签名参数。
   * @return 若此密钥对匹配指定的数字签名参数，返回{@code true}；否则返回{@code false}。
   */
  public boolean match(final SignedInfo signedInfo) {
    if (signedInfo == null) {
      return false;
    }
    return Equality.equals(algorithm, signedInfo.getAlgorithm())
        // && Equality.equals(format, signedInfo.getKeyFormat())
        && Equality.equals(version, signedInfo.getKeyVersion())
        && Equality.equals(publicKey, signedInfo.getPublicKey());
  }
}
