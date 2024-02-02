////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.io.Serializable;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.pair.KeyValuePairList;
import ltd.qubit.model.Entity;

/**
 * 此模型表示处方操作信息。
 *
 * @author 孙建
 */
public class PrescriptionActionParams implements Serializable {

  private static final long serialVersionUID = 2030559983960232947L;

  /**
   * 对处方单执行的操作。
   */
  private PrescriptionAction action;

  /**
   * 操作执行者的类型。
   */
  private Entity actorType;

  /**
   * 操作执行者的编码。
   */
  private String actorCode;

  /**
   * 操作执行者的姓名。
   */
  private String actorName;

  /**
   * 操作执行的详情。
   */
  private String description;

  /**
   * 操作执行的时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant timestamp;

  /**
   * 其他的额外数据。
   */
  @Size(max = 16)
  @Nullable
  private KeyValuePairList payload;

  public PrescriptionAction getAction() {
    return action;
  }

  public void setAction(final PrescriptionAction action) {
    this.action = action;
  }

  public Entity getActorType() {
    return actorType;
  }

  public void setActorType(final Entity actorType) {
    this.actorType = actorType;
  }

  public String getActorCode() {
    return actorCode;
  }

  public void setActorCode(final String actorCode) {
    this.actorCode = actorCode;
  }

  public String getActorName() {
    return actorName;
  }

  public void setActorName(final String actorName) {
    this.actorName = actorName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(final Instant timestamp) {
    this.timestamp = timestamp;
  }

  @Nullable
  public KeyValuePairList getPayload() {
    return payload;
  }

  public void setPayload(@Nullable final KeyValuePairList payload) {
    this.payload = payload;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final PrescriptionActionParams other = (PrescriptionActionParams) o;
    return Equality.equals(action, other.action)
            && Equality.equals(actorType, other.actorType)
            && Equality.equals(actorCode, other.actorCode)
            && Equality.equals(actorName, other.actorName)
            && Equality.equals(description, other.description)
            && Equality.equals(timestamp, other.timestamp)
            && Equality.equals(payload, other.payload);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, action);
    result = Hash.combine(result, multiplier, actorType);
    result = Hash.combine(result, multiplier, actorCode);
    result = Hash.combine(result, multiplier, actorName);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, timestamp);
    result = Hash.combine(result, multiplier, payload);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("action", action)
            .append("actorType", actorType)
            .append("actorCode", actorCode)
            .append("actorName", actorName)
            .append("description", description)
            .append("timestamp", timestamp)
            .append("payload", payload)
            .toString();
  }
}
