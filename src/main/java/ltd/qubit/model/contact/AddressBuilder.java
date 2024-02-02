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

import ltd.qubit.commons.util.codec.DecodingException;
import ltd.qubit.model.util.Info;

/**
 * 用于构造一个{@link Address}对象的构造器。
 *
 * @author 胡海星
 */
public class AddressBuilder {

  private final Address address;

  public AddressBuilder() {
    address = new Address();
    address.setCountry(new Info());
    address.setProvince(new Info());
    address.setCity(new Info());
    address.setDistrict(new Info());
    address.setStreet(new Info());
    address.setLocation(new Location());
  }

  public AddressBuilder countryId(final Long countryId) {
    address.getCountry().setId(countryId);
    return this;
  }

  public AddressBuilder countryCode(final String countryCode) {
    address.getCountry().setCode(countryCode);
    return this;
  }

  public AddressBuilder countryName(final String countryName) {
    address.getCountry().setName(countryName);
    return this;
  }

  public AddressBuilder provinceId(final Long provinceId) {
    address.getProvince().setId(provinceId);
    return this;
  }

  public AddressBuilder provinceCode(final String provinceCode) {
    address.getProvince().setCode(provinceCode);
    return this;
  }

  public AddressBuilder provinceName(final String provinceName) {
    address.getProvince().setName(provinceName);
    return this;
  }

  public AddressBuilder cityId(final Long cityId) {
    address.getCity().setId(cityId);
    return this;
  }

  public AddressBuilder cityCode(final String cityCode) {
    address.getCity().setCode(cityCode);
    return this;
  }

  public AddressBuilder cityName(final String cityName) {
    address.getCity().setName(cityName);
    return this;
  }

  public AddressBuilder districtId(final Long districtId) {
    address.getDistrict().setId(districtId);
    return this;
  }

  public AddressBuilder districtCode(final String districtCode) {
    address.getDistrict().setCode(districtCode);
    return this;
  }

  public AddressBuilder districtName(final String districtName) {
    address.getDistrict().setName(districtName);
    return this;
  }

  public AddressBuilder streetId(final Long streetId) {
    address.getStreet().setId(streetId);
    return this;
  }

  public AddressBuilder streetCode(final String streetCode) {
    address.getStreet().setCode(streetCode);
    return this;
  }

  public AddressBuilder streetName(final String streetName) {
    address.getStreet().setName(streetName);
    return this;
  }

  public AddressBuilder detail(final String detail) {
    address.setDetail(detail);
    return this;
  }

  public AddressBuilder postalcode(final String postalcode) {
    address.setPostalcode(postalcode);
    return this;
  }

  public AddressBuilder location(final Location location) {
    if (location != null) {
      address.getLocation().assign(location);
    }
    return this;
  }

  public AddressBuilder location(final String location) throws DecodingException {
    final LocationCodec codec = new LocationCodec();
    final Location loc = codec.decode(location);
    if (location != null) {
      address.getLocation().assign(loc);
    }
    return this;
  }

  public AddressBuilder longitude(final BigDecimal longitude) {
    address.getLocation().setLongitude(longitude);
    return this;
  }

  public AddressBuilder longitude(final String longitude) throws DecodingException {
    final LocationCoordinateCodec codec = LocationCoordinateCodec.INSTANCE;
    address.getLocation().setLongitude(codec.decode(longitude));
    return this;
  }

  public AddressBuilder latitude(final BigDecimal latitude) {
    address.getLocation().setLatitude(latitude);
    return this;
  }

  public AddressBuilder latitude(final String latitude) throws DecodingException {
    final LocationCoordinateCodec codec = LocationCoordinateCodec.INSTANCE;
    address.getLocation().setLatitude(codec.decode(latitude));
    return this;
  }

  public Address build() {
    final Address result  = address.clone();
    result.normalize();
    return result;
  }
}
