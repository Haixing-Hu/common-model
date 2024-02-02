////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.contact;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.Nullable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ltd.qubit.commons.annotation.Indexed;
import ltd.qubit.commons.annotation.Scale;
import ltd.qubit.commons.annotation.TypeCodec;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.codec.DecodingException;
import ltd.qubit.model.util.Emptyful;
import ltd.qubit.model.util.Normalizable;

/**
 * 此模型表示地理位置坐标。
 *
 * <p>经纬度坐标的表示方式通常有三种：
 * <ol>
 * <li>ddd.ddddd° 用小数表示度，保留小数点后面5位</li>
 * <li>ddd°mm.mmm' 用整数表示度，小数表示分，保留小数点后面3位</li>
 * <li>ddd°mm'ss" 用整数表示度、分、秒</li>
 * </ol>
 *
 * <p>其中
 * <ul>
 * <li>1分 = 60秒</li>
 * <li>1度 = 60分</li>
 * </ul>
 *
 * @author 胡海星
 */
@TypeCodec(LocationCodec.class)
public class Location implements Serializable, Emptyful, Normalizable,
    Assignable<Location> {

  private static final long serialVersionUID = -4224079873422617869L;

  /**
   * 经纬度坐标用小数形式表示时保留的小数点后位数。
   *
   * <p>默认保留小数点后{@value}位。</p>
   */
  public static final int PRECISION = LocationCoordinateCodec.SCALE;

  /**
   * 经度，采用小数形式表示，保留小数点后面5位。
   */
  @JsonSerialize(using = LocationCoordinateSerializer.class)
  @JsonDeserialize(using = LocationCoordinateDeserializer.class)
  @Scale(LocationCoordinateCodec.SCALE)
  @Indexed
  private BigDecimal longitude;

  /**
   * 纬度，采用小数形式表示，保留小数点后面5位。
   */
  @JsonSerialize(using = LocationCoordinateSerializer.class)
  @JsonDeserialize(using = LocationCoordinateDeserializer.class)
  @Scale(LocationCoordinateCodec.SCALE)
  @Indexed
  private BigDecimal latitude;

  /**
   * 创建一个新的{@link Location}对象。
   *
   * @param longitude
   *     指定的经度。
   * @param latitude
   *     指定的纬度。
   * @return
   *     根据指定经纬度新创建的{@link Location}对象，或{@code null}如果参数有一个
   *     是{@code null}。
   */
  public static Location create(@Nullable final BigDecimal longitude,
      @Nullable final BigDecimal latitude) {
    if (longitude == null || latitude == null) {
      return null;
    } else {
      return new Location(longitude, latitude);
    }
  }

  /**
   * 创建一个新的{@link Location}对象。
   *
   * @param longitude
   *     指定的经度的字符串编码。
   * @param latitude
   *     指定的纬度的字符串编码。
   * @return
   *     根据指定经纬度新创建的{@link Location}对象，或{@code null}如果参数有一个是
   *     {@code null}。
   * @throws DecodingException
   *     如果参数不是正确的经纬度编码。
   */
  public static Location create(@Nullable final String longitude,
      @Nullable final String latitude) throws DecodingException {
    if (longitude == null || latitude == null) {
      return null;
    } else {
      return new Location(longitude, latitude);
    }
  }

  /**
   * 创建一个新的{@link Location}对象。
   *
   * @param location
   *     指定的经纬度的字符串编码，注意该编码的形式为"&lt;经度&gt;,&lt;纬度&gt;"，例如
   *     "118.905641,32.078"。如果该参数为{@code null}，返回一个{@code null}。
   * @return
   *     根据指定经纬度新创建的{@link Location}对象，或{@code null}如果参数是{@code null}。
   * @throws DecodingException
   *     如果参数不是正确的经纬度编码。
   */
  public static Location create(@Nullable final String location)
      throws DecodingException {
    if (location == null) {
      return null;
    } else {
      return new Location(location);
    }
  }

  /**
   * 创建一个空的{@link Location}对象。
   */
  public Location() {
    // empty
  }

  /**
   * 复制创建一个新的{@link Location}对象。
   *
   * @param other
   *     被复制的{@link Location}对象。
   */
  public Location(final Location other) {
    assign(other);
  }

  /**
   * 创建一个新的{@link Location}对象。
   *
   * @param longitude
   *     指定的经度。
   * @param latitude
   *     指定的纬度。
   */
  public Location(final BigDecimal longitude, final BigDecimal latitude) {
    this.longitude = longitude;
    this.latitude = latitude;
  }

  /**
   * 创建一个新的{@link Location}对象。
   *
   * @param longitude
   *     指定的经度的字符串编码。
   * @param latitude
   *     指定的纬度的字符串编码。
   * @throws DecodingException
   *     如果参数不是正确的经纬度编码。
   */
  public Location(final String longitude, final String latitude) throws DecodingException {
    final LocationCoordinateCodec codec = LocationCoordinateCodec.INSTANCE;
    this.longitude = codec.decode(longitude);
    this.latitude = codec.decode(latitude);
  }

  /**
   * 创建一个新的{@link Location}对象。
   *
   * @param location
   *     指定的经纬度的字符串编码，注意该编码的形式为"&lt;经度&gt;,&lt;纬度&gt;"，例如
   *     "118.905641,32.078"。
   * @throws DecodingException
   *     如果参数不是正确的经纬度编码。
   */
  public Location(final String location) throws DecodingException {
    final LocationCodec codec = new LocationCodec();
    final Location loc = codec.decode(location);
    this.longitude = loc.longitude;
    this.latitude = loc.latitude;
  }

  @Override
  public void assign(final Location other) {
    Argument.requireNonNull("other", other);
    longitude = other.longitude;
    latitude = other.latitude;
  }

  @Override
  public Location clone() {
    return new Location(this);
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(final BigDecimal longitude) {
    this.longitude = longitude;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(final BigDecimal latitude) {
    this.latitude = latitude;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Location other = (Location) o;
    return Equality.equals(longitude, other.longitude)
        && Equality.equals(latitude, other.latitude);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, longitude);
    result = Hash.combine(result, multiplier, latitude);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("longitude", longitude)
        .append("latitude", latitude)
        .toString();
  }

  @Override
  public final void normalize() {
    normalize(PRECISION);
  }

  public final void normalize(final int precision) {
    longitude = LocationCoordinateCodec.normalize(longitude, precision);
    latitude = LocationCoordinateCodec.normalize(latitude, precision);
  }
}
