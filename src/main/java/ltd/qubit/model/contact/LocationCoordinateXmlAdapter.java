////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.contact;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.math.BigDecimal;
import javax.annotation.concurrent.Immutable;

/**
 * 地理位置坐标的XML Adapter。
 *
 * @author 胡海星
 */
@Immutable
public class LocationCoordinateXmlAdapter extends XmlAdapter<String, BigDecimal> {

  @Override
  public BigDecimal unmarshal(final String value) throws Exception {
    final LocationCoordinateCodec codec = LocationCoordinateCodec.INSTANCE;
    return (value == null ? null : codec.decode(value));
  }

  @Override
  public String marshal(final BigDecimal value) throws Exception {
    final LocationCoordinateCodec codec = LocationCoordinateCodec.INSTANCE;
    return (value == null ? null : codec.encode(value));
  }
}
