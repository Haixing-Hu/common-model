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

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Buyer} class.
 *
 * @author Haixing Hu
 */
public class BuyerTest extends ModelTestBase<Buyer> {

  public BuyerTest() {
    super(Buyer.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Buyer.class, Buyer::getId));
    assertEquals("id", getFieldName(Buyer.class, Buyer::setId));
    assertEquals("userId", getFieldName(Buyer.class, Buyer::getUserId));
    assertEquals("userId", getFieldName(Buyer.class, Buyer::setUserId));
    assertEquals("name", getFieldName(Buyer.class, Buyer::getName));
    assertEquals("name", getFieldName(Buyer.class, Buyer::setName));
    assertEquals("credential", getFieldName(Buyer.class, Buyer::getCredential));
    assertEquals("credential", getFieldName(Buyer.class, Buyer::setCredential));
    assertEquals("gender", getFieldName(Buyer.class, Buyer::getGender));
    assertEquals("gender", getFieldName(Buyer.class, Buyer::setGender));
    assertEquals("birthday", getFieldName(Buyer.class, Buyer::getBirthday));
    assertEquals("birthday", getFieldName(Buyer.class, Buyer::setBirthday));
    assertEquals("mobile", getFieldName(Buyer.class, Buyer::getMobile));
    assertEquals("mobile", getFieldName(Buyer.class, Buyer::setMobile));
    assertEquals("email", getFieldName(Buyer.class, Buyer::getEmail));
    assertEquals("email", getFieldName(Buyer.class, Buyer::setEmail));
  }
}
