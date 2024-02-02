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
 * Unit test of the {@link ProductItem} class.
 *
 * @author Haixing Hu
 */
public class ProductItemTest extends ModelTestBase<ProductItem> {

  public ProductItemTest() {
    super(ProductItem.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(ProductItem.class, ProductItem::getId));
    assertEquals("id", getFieldName(ProductItem.class, ProductItem::setId));
    assertEquals("productId", getFieldName(ProductItem.class, ProductItem::getProductId));
    assertEquals("productId", getFieldName(ProductItem.class, ProductItem::setProductId));
    assertEquals("index", getFieldName(ProductItem.class, ProductItem::getIndex));
    assertEquals("index", getFieldName(ProductItem.class, ProductItem::setIndex));
    assertEquals("specification", getFieldName(ProductItem.class, ProductItem::getSpecification));
    assertEquals("specification", getFieldName(ProductItem.class, ProductItem::setSpecification));
    assertEquals("unit", getFieldName(ProductItem.class, ProductItem::getUnit));
    assertEquals("unit", getFieldName(ProductItem.class, ProductItem::setUnit));
    assertEquals("weight", getFieldName(ProductItem.class, ProductItem::getWeight));
    assertEquals("weight", getFieldName(ProductItem.class, ProductItem::setWeight));
    assertEquals("productionNumber", getFieldName(ProductItem.class, ProductItem::getProductionNumber));
    assertEquals("productionNumber", getFieldName(ProductItem.class, ProductItem::setProductionNumber));
    assertEquals("productionDate", getFieldName(ProductItem.class, ProductItem::getProductionDate));
    assertEquals("productionDate", getFieldName(ProductItem.class, ProductItem::setProductionDate));
    assertEquals("shelfLife", getFieldName(ProductItem.class, ProductItem::getShelfLife));
    assertEquals("shelfLife", getFieldName(ProductItem.class, ProductItem::setShelfLife));
    assertEquals("image", getFieldName(ProductItem.class, ProductItem::getImage));
    assertEquals("image", getFieldName(ProductItem.class, ProductItem::setImage));
    assertEquals("description", getFieldName(ProductItem.class, ProductItem::getDescription));
    assertEquals("description", getFieldName(ProductItem.class, ProductItem::setDescription));
    assertEquals("price", getFieldName(ProductItem.class, ProductItem::getPrice));
    assertEquals("price", getFieldName(ProductItem.class, ProductItem::setPrice));
    assertEquals("discount", getFieldName(ProductItem.class, ProductItem::getDiscount));
    assertEquals("discount", getFieldName(ProductItem.class, ProductItem::setDiscount));
    assertEquals("discountReason", getFieldName(ProductItem.class, ProductItem::getDiscountReason));
    assertEquals("discountReason", getFieldName(ProductItem.class, ProductItem::setDiscountReason));
    assertEquals("discountFrom", getFieldName(ProductItem.class, ProductItem::getDiscountFrom));
    assertEquals("discountFrom", getFieldName(ProductItem.class, ProductItem::setDiscountFrom));
    assertEquals("discountUntil", getFieldName(ProductItem.class, ProductItem::getDiscountUntil));
    assertEquals("discountUntil", getFieldName(ProductItem.class, ProductItem::setDiscountUntil));
    assertEquals("inventory", getFieldName(ProductItem.class, ProductItem::getInventory));
    assertEquals("inventory", getFieldName(ProductItem.class, ProductItem::setInventory));
    assertEquals("serviceType", getFieldName(ProductItem.class, ProductItem::getServiceType));
    assertEquals("serviceType", getFieldName(ProductItem.class, ProductItem::setServiceType));
    assertEquals("serviceId", getFieldName(ProductItem.class, ProductItem::getServiceId));
    assertEquals("serviceId", getFieldName(ProductItem.class, ProductItem::setServiceId));
    assertEquals("createTime", getFieldName(ProductItem.class, ProductItem::getCreateTime));
    assertEquals("createTime", getFieldName(ProductItem.class, ProductItem::setCreateTime));
    assertEquals("modifyTime", getFieldName(ProductItem.class, ProductItem::getModifyTime));
    assertEquals("modifyTime", getFieldName(ProductItem.class, ProductItem::setModifyTime));
    assertEquals("deleteTime", getFieldName(ProductItem.class, ProductItem::getDeleteTime));
    assertEquals("deleteTime", getFieldName(ProductItem.class, ProductItem::setDeleteTime));
  }
}
