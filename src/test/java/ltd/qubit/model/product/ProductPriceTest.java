////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.product;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link ProductPrice} class.
 *
 * @author Haixing Hu
 */
public class ProductPriceTest extends ModelTestBase<ProductPrice> {

  public ProductPriceTest() {
    super(ProductPrice.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(ProductPrice.class, ProductPrice::getId));
    assertEquals("id", getFieldName(ProductPrice.class, ProductPrice::setId));
    assertEquals("productId", getFieldName(ProductPrice.class, ProductPrice::getProductId));
    assertEquals("productId", getFieldName(ProductPrice.class, ProductPrice::setProductId));
    assertEquals("productItemId", getFieldName(ProductPrice.class, ProductPrice::getProductItemId));
    assertEquals("productItemId", getFieldName(ProductPrice.class, ProductPrice::setProductItemId));
    assertEquals("code", getFieldName(ProductPrice.class, ProductPrice::getCode));
    assertEquals("code", getFieldName(ProductPrice.class, ProductPrice::setCode));
    assertEquals("name", getFieldName(ProductPrice.class, ProductPrice::getName));
    assertEquals("name", getFieldName(ProductPrice.class, ProductPrice::setName));
    assertEquals("specification", getFieldName(ProductPrice.class, ProductPrice::getSpecification));
    assertEquals("specification", getFieldName(ProductPrice.class, ProductPrice::setSpecification));
    assertEquals("source", getFieldName(ProductPrice.class, ProductPrice::getSource));
    assertEquals("source", getFieldName(ProductPrice.class, ProductPrice::setSource));
    assertEquals("price", getFieldName(ProductPrice.class, ProductPrice::getPrice));
    assertEquals("price", getFieldName(ProductPrice.class, ProductPrice::setPrice));
    assertEquals("discount", getFieldName(ProductPrice.class, ProductPrice::getDiscount));
    assertEquals("discount", getFieldName(ProductPrice.class, ProductPrice::setDiscount));
    assertEquals("discountReason", getFieldName(ProductPrice.class, ProductPrice::getDiscountReason));
    assertEquals("discountReason", getFieldName(ProductPrice.class, ProductPrice::setDiscountReason));
    assertEquals("discountFrom", getFieldName(ProductPrice.class, ProductPrice::getDiscountFrom));
    assertEquals("discountFrom", getFieldName(ProductPrice.class, ProductPrice::setDiscountFrom));
    assertEquals("discountUntil", getFieldName(ProductPrice.class, ProductPrice::getDiscountUntil));
    assertEquals("discountUntil", getFieldName(ProductPrice.class, ProductPrice::setDiscountUntil));
    assertEquals("createTime", getFieldName(ProductPrice.class, ProductPrice::getCreateTime));
    assertEquals("createTime", getFieldName(ProductPrice.class, ProductPrice::setCreateTime));
    assertEquals("modifyTime", getFieldName(ProductPrice.class, ProductPrice::getModifyTime));
    assertEquals("modifyTime", getFieldName(ProductPrice.class, ProductPrice::setModifyTime));
    assertEquals("deleteTime", getFieldName(ProductPrice.class, ProductPrice::getDeleteTime));
    assertEquals("deleteTime", getFieldName(ProductPrice.class, ProductPrice::setDeleteTime));
  }
}
