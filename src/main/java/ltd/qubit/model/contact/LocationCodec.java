////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.contact;

import ltd.qubit.commons.util.codec.Codec;
import ltd.qubit.commons.util.codec.DecodingException;

/**
 * 地理位置坐标编码解码器。
 *
 * <p>此对象提供{@link Location}对象和字符串之间互相转换的函数。</p>
 *
 * <p>一个{@link Location}对象将用下面形式的字符串表示：</p>
 *
 * <pre><code>
 *   &lt;经度&gt; ',' &lt;纬度&gt;
 * </code></pre>
 *
 * <p>例如："116.482086,39.990496"</p>
 *
 * @author 胡海星
 */
public class LocationCodec implements Codec<Location, String> {

  /**
   * 经纬度坐标之间的分隔符。
   */
  public static final String SPLITTER = ",";

  @Override
  public Location decode(final String source) throws DecodingException {
    if (source == null || source.length() == 0) {
      return null;
    }
    final String[] values = source.split(SPLITTER);
    if (values.length != 2) {
      throw new DecodingException("Invalid location format: " + source);
    }
    try {
      return new Location(values[0], values[1]);
    } catch (final DecodingException e) {
      throw new DecodingException("Invalid location format: " + source);
    }
  }

  @Override
  public String encode(final Location source) {
    if (source == null) {
      return null;
    }
    final LocationCoordinateCodec codec = LocationCoordinateCodec.INSTANCE;
    return codec.encode(source.getLongitude())
        + SPLITTER
        + codec.encode(source.getLatitude());
  }
}
