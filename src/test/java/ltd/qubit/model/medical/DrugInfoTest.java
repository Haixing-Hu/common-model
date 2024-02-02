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
 * Unit test of the {@link DrugInfo} class.
 *
 * @author Haixing Hu
 */
public class DrugInfoTest extends ModelTestBase<DrugInfo> {

  public DrugInfoTest() {
    super(DrugInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(DrugInfo.class, DrugInfo::getId));
    assertEquals("id", getFieldName(DrugInfo.class, DrugInfo::setId));
    assertEquals("code", getFieldName(DrugInfo.class, DrugInfo::getCode));
    assertEquals("code", getFieldName(DrugInfo.class, DrugInfo::setCode));
    assertEquals("name", getFieldName(DrugInfo.class, DrugInfo::getName));
    assertEquals("name", getFieldName(DrugInfo.class, DrugInfo::setName));
    assertEquals("productName", getFieldName(DrugInfo.class, DrugInfo::getProductName));
    assertEquals("productName", getFieldName(DrugInfo.class, DrugInfo::setProductName));
    assertEquals("specification", getFieldName(DrugInfo.class, DrugInfo::getSpecification));
    assertEquals("specification", getFieldName(DrugInfo.class, DrugInfo::setSpecification));
    assertEquals("dosageForm", getFieldName(DrugInfo.class, DrugInfo::getDosageForm));
    assertEquals("dosageForm", getFieldName(DrugInfo.class, DrugInfo::setDosageForm));
    assertEquals("unit", getFieldName(DrugInfo.class, DrugInfo::getUnit));
    assertEquals("unit", getFieldName(DrugInfo.class, DrugInfo::setUnit));
    assertEquals("packaging", getFieldName(DrugInfo.class, DrugInfo::getPackaging));
    assertEquals("packaging", getFieldName(DrugInfo.class, DrugInfo::setPackaging));
    assertEquals("basic", getFieldName(DrugInfo.class, DrugInfo::isBasic));
    assertEquals("basic", getFieldName(DrugInfo.class, DrugInfo::setBasic));
    assertEquals("otc", getFieldName(DrugInfo.class, DrugInfo::isOtc));
    assertEquals("otc", getFieldName(DrugInfo.class, DrugInfo::setOtc));
    assertEquals("antibiotics", getFieldName(DrugInfo.class, DrugInfo::isAntibiotics));
    assertEquals("antibiotics", getFieldName(DrugInfo.class, DrugInfo::setAntibiotics));
    assertEquals("restricted", getFieldName(DrugInfo.class, DrugInfo::isRestricted));
    assertEquals("restricted", getFieldName(DrugInfo.class, DrugInfo::setRestricted));
    assertEquals("herbalCompound", getFieldName(DrugInfo.class, DrugInfo::isHerbalCompound));
    assertEquals("herbalCompound", getFieldName(DrugInfo.class, DrugInfo::setHerbalCompound));
    assertEquals("brand", getFieldName(DrugInfo.class, DrugInfo::getBrand));
    assertEquals("brand", getFieldName(DrugInfo.class, DrugInfo::setBrand));
    assertEquals("origin", getFieldName(DrugInfo.class, DrugInfo::getOrigin));
    assertEquals("origin", getFieldName(DrugInfo.class, DrugInfo::setOrigin));
    assertEquals("manufacturer", getFieldName(DrugInfo.class, DrugInfo::getManufacturer));
    assertEquals("manufacturer", getFieldName(DrugInfo.class, DrugInfo::setManufacturer));
  }
}
