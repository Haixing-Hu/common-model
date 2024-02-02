////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link DrugProduct} class.
 *
 * @author Haixing Hu
 */
public class DrugProductTest extends ModelTestBase<DrugProduct> {

  public DrugProductTest() {
    super(DrugProduct.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("drug", getFieldName(DrugProduct.class, DrugProduct::getDrug));
    assertEquals("drug", getFieldName(DrugProduct.class, DrugProduct::setDrug));
    assertEquals("product", getFieldName(DrugProduct.class, DrugProduct::getProduct));
    assertEquals("product", getFieldName(DrugProduct.class, DrugProduct::setProduct));
  }
}
