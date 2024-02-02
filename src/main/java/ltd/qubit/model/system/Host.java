////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.system;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型存储分布式系统中的主机信息。
 *
 * @author 胡海星
 */
public class Host implements Identifiable, Assignable<Host> {

  private static final long serialVersionUID = -1510561914861397847L;

  /**
   * 记录在系统中的ID，唯一标识。
   */
  @Identifier
  private Long id;

  /**
   * 供应商名称。
   */
  @Size(min = 1, max = 128)
  private String provider;

  /**
   * 设备的UDID。
   */
  @Size(min = 1, max = 128)
  @Unique
  private String udid;

  public Host() {
    // empty
  }

  public Host(final Host other) {
    assign(other);
  }

  @Override
  public void assign(final Host other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    provider = other.provider;
    udid = other.udid;
  }

  @Override
  public Host clone() {
    return new Host(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getProvider() {
    return provider;
  }

  public void setProvider(final String provider) {
    this.provider = provider;
  }

  public String getUdid() {
    return udid;
  }

  public void setUdid(final String udid) {
    this.udid = udid;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Host other = (Host) o;
    return Equality.equals(id, other.id)
        && Equality.equals(provider, other.provider)
        && Equality.equals(udid, other.udid);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, provider);
    result = Hash.combine(result, multiplier, udid);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("provider", provider)
        .append("udid", udid)
        .toString();
  }
}
