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
 * Unit test of the {@link Product} class.
 *
 * @author Haixing Hu
 */
public class ProductTest extends ModelTestBase<Product> {

  public ProductTest() {
    super(Product.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Product.class, Product::getId));
    assertEquals("id", getFieldName(Product.class, Product::setId));
    assertEquals("code", getFieldName(Product.class, Product::getCode));
    assertEquals("code", getFieldName(Product.class, Product::setCode));
    assertEquals("name", getFieldName(Product.class, Product::getName));
    assertEquals("name", getFieldName(Product.class, Product::setName));
    assertEquals("app", getFieldName(Product.class, Product::getApp));
    assertEquals("app", getFieldName(Product.class, Product::setApp));
    assertEquals("category", getFieldName(Product.class, Product::getCategory));
    assertEquals("category", getFieldName(Product.class, Product::setCategory));
    assertEquals("quality", getFieldName(Product.class, Product::getQuality));
    assertEquals("quality", getFieldName(Product.class, Product::setQuality));
    assertEquals("currency", getFieldName(Product.class, Product::getCurrency));
    assertEquals("currency", getFieldName(Product.class, Product::setCurrency));
    assertEquals("image", getFieldName(Product.class, Product::getImage));
    assertEquals("image", getFieldName(Product.class, Product::setImage));
    assertEquals("description", getFieldName(Product.class, Product::getDescription));
    assertEquals("description", getFieldName(Product.class, Product::setDescription));
    assertEquals("validFrom", getFieldName(Product.class, Product::getValidFrom));
    assertEquals("validFrom", getFieldName(Product.class, Product::setValidFrom));
    assertEquals("validUntil", getFieldName(Product.class, Product::getValidUntil));
    assertEquals("validUntil", getFieldName(Product.class, Product::setValidUntil));
    assertEquals("brand", getFieldName(Product.class, Product::getBrand));
    assertEquals("brand", getFieldName(Product.class, Product::setBrand));
    assertEquals("origin", getFieldName(Product.class, Product::getOrigin));
    assertEquals("origin", getFieldName(Product.class, Product::setOrigin));
    assertEquals("manufacturer", getFieldName(Product.class, Product::getManufacturer));
    assertEquals("manufacturer", getFieldName(Product.class, Product::setManufacturer));
    assertEquals("seller", getFieldName(Product.class, Product::getSeller));
    assertEquals("seller", getFieldName(Product.class, Product::setSeller));
    assertEquals("saleFrom", getFieldName(Product.class, Product::getSaleFrom));
    assertEquals("saleFrom", getFieldName(Product.class, Product::setSaleFrom));
    assertEquals("saleUntil", getFieldName(Product.class, Product::getSaleUntil));
    assertEquals("saleUntil", getFieldName(Product.class, Product::setSaleUntil));
    assertEquals("needDelivery", getFieldName(Product.class, Product::isNeedDelivery));
    assertEquals("needDelivery", getFieldName(Product.class, Product::setNeedDelivery));
    assertEquals("allowReturn", getFieldName(Product.class, Product::isAllowReturn));
    assertEquals("allowReturn", getFieldName(Product.class, Product::setAllowReturn));
    assertEquals("allowChange", getFieldName(Product.class, Product::isAllowChange));
    assertEquals("allowChange", getFieldName(Product.class, Product::setAllowChange));
    assertEquals("needClient", getFieldName(Product.class, Product::isNeedClient));
    assertEquals("needClient", getFieldName(Product.class, Product::setNeedClient));
    assertEquals("constraint", getFieldName(Product.class, Product::getConstraint));
    assertEquals("constraint", getFieldName(Product.class, Product::setConstraint));
    assertEquals("items", getFieldName(Product.class, Product::getItems));
    assertEquals("items", getFieldName(Product.class, Product::setItems));
    assertEquals("state", getFieldName(Product.class, Product::getState));
    assertEquals("state", getFieldName(Product.class, Product::setState));
    assertEquals("createTime", getFieldName(Product.class, Product::getCreateTime));
    assertEquals("createTime", getFieldName(Product.class, Product::setCreateTime));
    assertEquals("modifyTime", getFieldName(Product.class, Product::getModifyTime));
    assertEquals("modifyTime", getFieldName(Product.class, Product::setModifyTime));
    assertEquals("deleteTime", getFieldName(Product.class, Product::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Product.class, Product::setDeleteTime));
  }
}
