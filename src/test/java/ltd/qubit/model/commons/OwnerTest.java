////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.commons;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;
import ltd.qubit.model.product.ProductItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Owner} class.
 *
 * @author Haixing Hu
 */
public class OwnerTest extends ModelTestBase<Owner> {

  public OwnerTest() {
    super(Owner.class);
  }

  @Test
  public void testConstructor() throws Exception {
    final Owner o1 = new Owner(Owner.class, 123l, "id");
    assertEquals("OWNER", o1.getType());
    assertEquals(123l, o1.getId());
    assertEquals("ID", o1.getProperty());

    final Owner o2 = new Owner(ProductItem.class, -123l, "socialSecurityCard");
    assertEquals("PRODUCT_ITEM", o2.getType());
    assertEquals(-123l, o2.getId());
    assertEquals("SOCIAL_SECURITY_CARD", o2.getProperty());
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("type", getFieldName(Owner.class, Owner::getType));
    assertEquals("type", getFieldName(Owner.class, Owner::setType));
    assertEquals("id", getFieldName(Owner.class, Owner::getId));
    assertEquals("id", getFieldName(Owner.class, Owner::setId));
    assertEquals("property", getFieldName(Owner.class, Owner::getProperty));
    assertEquals("property", getFieldName(Owner.class, Owner::setProperty));
  }
}
