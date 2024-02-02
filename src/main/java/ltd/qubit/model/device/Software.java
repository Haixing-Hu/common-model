////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.device;

import java.io.Serializable;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Indexed;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.system.Platform;

/**
 * 此模型表示软件信息。
 *
 * @author 胡海星
 */
public class Software implements Serializable, Assignable<Software> {

  private static final long serialVersionUID = 2022369797329984463L;

  /**
   * 软件类别。
   */
  @Indexed
  private Platform platform;

  /**
   * 软件商品名称。
   */
  @Size(min = 1, max = 128)
  @Indexed
  private String name;

  /**
   * 软件版本号。
   */
  @Size(min = 1, max = 128)
  @Indexed
  private String version;

  /**
   * 软件构建号。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String build;

  /**
   * 软件补丁信息。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String patch;

  /**
   * 软件内部代号。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String codeName;

  /**
   * 软件制造商名称。
   */
  @Size(min = 1, max = 128)
  @Indexed
  @Nullable
  private String manufacturer;

  /**
   * 软件描述。
   */
  @Nullable
  private String description;

  public Software() {
    // empty
  }

  public Software(final Software other) {
    assign(other);
  }

  @Override
  public void assign(final Software other) {
    Argument.requireNonNull("other", other);
    platform = other.platform;
    name = other.name;
    version = other.version;
    build = other.build;
    patch = other.patch;
    codeName = other.codeName;
    manufacturer = other.manufacturer;
    description = other.description;
  }

  @Override
  public Software clone() {
    return new Software(this);
  }

  public Platform getPlatform() {
    return platform;
  }

  public void setPlatform(final Platform platform) {
    this.platform = platform;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(final String version) {
    this.version = version;
  }

  @Nullable
  public String getBuild() {
    return build;
  }

  public void setBuild(@Nullable final String build) {
    this.build = build;
  }

  @Nullable
  public String getPatch() {
    return patch;
  }

  public void setPatch(@Nullable final String patch) {
    this.patch = patch;
  }

  @Nullable
  public String getCodeName() {
    return codeName;
  }

  public void setCodeName(@Nullable final String codeName) {
    this.codeName = codeName;
  }

  @Nullable
  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(@Nullable final String manufacturer) {
    this.manufacturer = manufacturer;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Software other = (Software) o;
    return Equality.equals(platform, other.platform)
        && Equality.equals(name, other.name)
        && Equality.equals(version, other.version)
        && Equality.equals(build, other.build)
        && Equality.equals(patch, other.patch)
        && Equality.equals(codeName, other.codeName)
        && Equality.equals(manufacturer, other.manufacturer)
        && Equality.equals(description, other.description);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, platform);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, version);
    result = Hash.combine(result, multiplier, build);
    result = Hash.combine(result, multiplier, patch);
    result = Hash.combine(result, multiplier, codeName);
    result = Hash.combine(result, multiplier, manufacturer);
    result = Hash.combine(result, multiplier, description);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("category", platform)
        .append("name", name)
        .append("version", version)
        .append("build", build)
        .append("patch", patch)
        .append("codeName", codeName)
        .append("manufacturer", manufacturer)
        .append("description", description)
        .toString();
  }
}
