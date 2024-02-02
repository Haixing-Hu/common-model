////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.contact;

import java.math.BigDecimal;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import ltd.qubit.commons.util.codec.BigDecimalCodec;

import static ltd.qubit.commons.lang.BigDecimalUtils.limitPrecision;

/**
 * 地理位置坐标编码器。
 *
 * @author 胡海星
 */
@Immutable
public class LocationCoordinateCodec extends BigDecimalCodec {

  /**
   * 坐标精度，即小数点后面数字的位数，保留6位。
   */
  public static final int SCALE = 6;

  public static final BigDecimal MIN_COORDINATE = BigDecimal.valueOf(-180);

  public static final BigDecimal MAX_COORDINATE = BigDecimal.valueOf(180);

  public static final BigDecimal ROUND_DEGREE = BigDecimal.valueOf(360);

  public static final LocationCoordinateCodec INSTANCE = new LocationCoordinateCodec();

  public LocationCoordinateCodec() {
    super(SCALE);
  }

  @Nullable
  public static BigDecimal normalize(@Nullable final BigDecimal value) {
    return normalize(value, SCALE);
  }

  @Nullable
  public static BigDecimal normalize(@Nullable final BigDecimal value, final int precision) {
    if (value == null) {
      return null;
    }
    BigDecimal v = limitPrecision(value, precision);
    v = v.remainder(ROUND_DEGREE);
    if (v.compareTo(MIN_COORDINATE) < 0) {
      v = v.add(ROUND_DEGREE);
    } else if (v.compareTo(MAX_COORDINATE) > 0) {
      v = v.subtract(ROUND_DEGREE);
    }
    return v;
  }
}
