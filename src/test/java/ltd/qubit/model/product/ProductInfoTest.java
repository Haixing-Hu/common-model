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
 * Unit test of the {@link ProductInfo} class.
 *
 * @author Haixing Hu
 */
public class ProductInfoTest extends ModelTestBase<ProductInfo> {

  public ProductInfoTest() {
    super(ProductInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(ProductInfo.class, ProductInfo::getId));
    assertEquals("id", getFieldName(ProductInfo.class, ProductInfo::setId));
    assertEquals("itemId", getFieldName(ProductInfo.class, ProductInfo::getItemId));
    assertEquals("itemId", getFieldName(ProductInfo.class, ProductInfo::setItemId));
    assertEquals("name", getFieldName(ProductInfo.class, ProductInfo::getName));
    assertEquals("name", getFieldName(ProductInfo.class, ProductInfo::setName));
    assertEquals("code", getFieldName(ProductInfo.class, ProductInfo::getCode));
    assertEquals("code", getFieldName(ProductInfo.class, ProductInfo::setCode));
    assertEquals("quality", getFieldName(ProductInfo.class, ProductInfo::getQuality));
    assertEquals("quality", getFieldName(ProductInfo.class, ProductInfo::setQuality));
    assertEquals("unit", getFieldName(ProductInfo.class, ProductInfo::getUnit));
    assertEquals("unit", getFieldName(ProductInfo.class, ProductInfo::setUnit));
    assertEquals("specification", getFieldName(ProductInfo.class, ProductInfo::getSpecification));
    assertEquals("specification", getFieldName(ProductInfo.class, ProductInfo::setSpecification));
    assertEquals("currency", getFieldName(ProductInfo.class, ProductInfo::getCurrency));
    assertEquals("currency", getFieldName(ProductInfo.class, ProductInfo::setCurrency));
    assertEquals("price", getFieldName(ProductInfo.class, ProductInfo::getPrice));
    assertEquals("price", getFieldName(ProductInfo.class, ProductInfo::setPrice));
    assertEquals("weight", getFieldName(ProductInfo.class, ProductInfo::getWeight));
    assertEquals("weight", getFieldName(ProductInfo.class, ProductInfo::setWeight));
    assertEquals("image", getFieldName(ProductInfo.class, ProductInfo::getImage));
    assertEquals("image", getFieldName(ProductInfo.class, ProductInfo::setImage));
    assertEquals("description", getFieldName(ProductInfo.class, ProductInfo::getDescription));
    assertEquals("description", getFieldName(ProductInfo.class, ProductInfo::setDescription));
    assertEquals("brand", getFieldName(ProductInfo.class, ProductInfo::getBrand));
    assertEquals("brand", getFieldName(ProductInfo.class, ProductInfo::setBrand));
    assertEquals("origin", getFieldName(ProductInfo.class, ProductInfo::getOrigin));
    assertEquals("origin", getFieldName(ProductInfo.class, ProductInfo::setOrigin));
    assertEquals("manufacturer", getFieldName(ProductInfo.class, ProductInfo::getManufacturer));
    assertEquals("manufacturer", getFieldName(ProductInfo.class, ProductInfo::setManufacturer));
    assertEquals("seller", getFieldName(ProductInfo.class, ProductInfo::getSeller));
    assertEquals("seller", getFieldName(ProductInfo.class, ProductInfo::setSeller));
    assertEquals("productionNumber", getFieldName(ProductInfo.class, ProductInfo::getProductionNumber));
    assertEquals("productionNumber", getFieldName(ProductInfo.class, ProductInfo::setProductionNumber));
    assertEquals("productionDate", getFieldName(ProductInfo.class, ProductInfo::getProductionDate));
    assertEquals("productionDate", getFieldName(ProductInfo.class, ProductInfo::setProductionDate));
    assertEquals("shelfLife", getFieldName(ProductInfo.class, ProductInfo::getShelfLife));
    assertEquals("shelfLife", getFieldName(ProductInfo.class, ProductInfo::setShelfLife));
    assertEquals("saleFrom", getFieldName(ProductInfo.class, ProductInfo::getSaleFrom));
    assertEquals("saleFrom", getFieldName(ProductInfo.class, ProductInfo::setSaleFrom));
    assertEquals("saleUntil", getFieldName(ProductInfo.class, ProductInfo::getSaleUntil));
    assertEquals("saleUntil", getFieldName(ProductInfo.class, ProductInfo::setSaleUntil));
    assertEquals("validFrom", getFieldName(ProductInfo.class, ProductInfo::getValidFrom));
    assertEquals("validFrom", getFieldName(ProductInfo.class, ProductInfo::setValidFrom));
    assertEquals("validUntil", getFieldName(ProductInfo.class, ProductInfo::getValidUntil));
    assertEquals("validUntil", getFieldName(ProductInfo.class, ProductInfo::setValidUntil));
    assertEquals("needDelivery", getFieldName(ProductInfo.class, ProductInfo::isNeedDelivery));
    assertEquals("needDelivery", getFieldName(ProductInfo.class, ProductInfo::setNeedDelivery));
    assertEquals("allowReturn", getFieldName(ProductInfo.class, ProductInfo::isAllowReturn));
    assertEquals("allowReturn", getFieldName(ProductInfo.class, ProductInfo::setAllowReturn));
    assertEquals("allowChange", getFieldName(ProductInfo.class, ProductInfo::isAllowChange));
    assertEquals("allowChange", getFieldName(ProductInfo.class, ProductInfo::setAllowChange));
    assertEquals("needClient", getFieldName(ProductInfo.class, ProductInfo::isNeedClient));
    assertEquals("needClient", getFieldName(ProductInfo.class, ProductInfo::setNeedClient));
    assertEquals("discount", getFieldName(ProductInfo.class, ProductInfo::getDiscount));
    assertEquals("discount", getFieldName(ProductInfo.class, ProductInfo::setDiscount));
    assertEquals("discountReason", getFieldName(ProductInfo.class, ProductInfo::getDiscountReason));
    assertEquals("discountReason", getFieldName(ProductInfo.class, ProductInfo::setDiscountReason));
    assertEquals("discountFrom", getFieldName(ProductInfo.class, ProductInfo::getDiscountFrom));
    assertEquals("discountFrom", getFieldName(ProductInfo.class, ProductInfo::setDiscountFrom));
    assertEquals("discountUntil", getFieldName(ProductInfo.class, ProductInfo::getDiscountUntil));
    assertEquals("discountUntil", getFieldName(ProductInfo.class, ProductInfo::setDiscountUntil));
    assertEquals("inventory", getFieldName(ProductInfo.class, ProductInfo::getInventory));
    assertEquals("inventory", getFieldName(ProductInfo.class, ProductInfo::setInventory));
    assertEquals("constraint", getFieldName(ProductInfo.class, ProductInfo::getConstraint));
    assertEquals("constraint", getFieldName(ProductInfo.class, ProductInfo::setConstraint));
  }
}
