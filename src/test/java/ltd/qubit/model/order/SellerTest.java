////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;
import ltd.qubit.model.product.Seller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Seller} class.
 *
 * @author Haixing Hu
 */
public class SellerTest extends ModelTestBase<Seller> {

  public SellerTest() {
    super(Seller.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Seller.class, Seller::getId));
    assertEquals("id", getFieldName(Seller.class, Seller::setId));
    assertEquals("code", getFieldName(Seller.class, Seller::getCode));
    assertEquals("code", getFieldName(Seller.class, Seller::setCode));
    assertEquals("name", getFieldName(Seller.class, Seller::getName));
    assertEquals("name", getFieldName(Seller.class, Seller::setName));
    assertEquals("phone", getFieldName(Seller.class, Seller::getPhone));
    assertEquals("phone", getFieldName(Seller.class, Seller::setPhone));
    assertEquals("mobile", getFieldName(Seller.class, Seller::getMobile));
    assertEquals("mobile", getFieldName(Seller.class, Seller::setMobile));
    assertEquals("email", getFieldName(Seller.class, Seller::getEmail));
    assertEquals("email", getFieldName(Seller.class, Seller::setEmail));
    assertEquals("url", getFieldName(Seller.class, Seller::getUrl));
    assertEquals("url", getFieldName(Seller.class, Seller::setUrl));
    assertEquals("credential", getFieldName(Seller.class, Seller::getCredential));
    assertEquals("credential", getFieldName(Seller.class, Seller::setCredential));
    assertEquals("address", getFieldName(Seller.class, Seller::getAddress));
    assertEquals("address", getFieldName(Seller.class, Seller::setAddress));
  }
}
