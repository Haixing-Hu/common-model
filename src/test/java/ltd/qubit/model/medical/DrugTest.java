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
 * Unit test of the {@link Drug} class.
 *
 * @author Haixing Hu
 */
public class DrugTest extends ModelTestBase<Drug> {

  public DrugTest() {
    super(Drug.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Drug.class, Drug::getId));
    assertEquals("id", getFieldName(Drug.class, Drug::setId));
    assertEquals("code", getFieldName(Drug.class, Drug::getCode));
    assertEquals("code", getFieldName(Drug.class, Drug::setCode));
    assertEquals("name", getFieldName(Drug.class, Drug::getName));
    assertEquals("name", getFieldName(Drug.class, Drug::setName));
    assertEquals("category", getFieldName(Drug.class, Drug::getCategory));
    assertEquals("category", getFieldName(Drug.class, Drug::setCategory));
    assertEquals("productName", getFieldName(Drug.class, Drug::getProductName));
    assertEquals("productName", getFieldName(Drug.class, Drug::setProductName));
    assertEquals("englishName", getFieldName(Drug.class, Drug::getEnglishName));
    assertEquals("englishName", getFieldName(Drug.class, Drug::setEnglishName));
    assertEquals("pinyinName", getFieldName(Drug.class, Drug::getPinyinName));
    assertEquals("pinyinName", getFieldName(Drug.class, Drug::setPinyinName));
    assertEquals("chemicalName", getFieldName(Drug.class, Drug::getChemicalName));
    assertEquals("chemicalName", getFieldName(Drug.class, Drug::setChemicalName));
    assertEquals("specification", getFieldName(Drug.class, Drug::getSpecification));
    assertEquals("specification", getFieldName(Drug.class, Drug::setSpecification));
    assertEquals("dosageForm", getFieldName(Drug.class, Drug::getDosageForm));
    assertEquals("dosageForm", getFieldName(Drug.class, Drug::setDosageForm));
    assertEquals("administrationRoute", getFieldName(Drug.class, Drug::getAdministrationRoute));
    assertEquals("administrationRoute", getFieldName(Drug.class, Drug::setAdministrationRoute));
    assertEquals("frequency", getFieldName(Drug.class, Drug::getFrequency));
    assertEquals("frequency", getFieldName(Drug.class, Drug::setFrequency));
    assertEquals("unit", getFieldName(Drug.class, Drug::getUnit));
    assertEquals("unit", getFieldName(Drug.class, Drug::setUnit));
    assertEquals("packaging", getFieldName(Drug.class, Drug::getPackaging));
    assertEquals("packaging", getFieldName(Drug.class, Drug::setPackaging));
    assertEquals("basic", getFieldName(Drug.class, Drug::isBasic));
    assertEquals("basic", getFieldName(Drug.class, Drug::setBasic));
    assertEquals("otc", getFieldName(Drug.class, Drug::isOtc));
    assertEquals("otc", getFieldName(Drug.class, Drug::setOtc));
    assertEquals("antibiotics", getFieldName(Drug.class, Drug::isAntibiotics));
    assertEquals("antibiotics", getFieldName(Drug.class, Drug::setAntibiotics));
    assertEquals("restricted", getFieldName(Drug.class, Drug::isRestricted));
    assertEquals("restricted", getFieldName(Drug.class, Drug::setRestricted));
    assertEquals("herbalCompound", getFieldName(Drug.class, Drug::isHerbalCompound));
    assertEquals("herbalCompound", getFieldName(Drug.class, Drug::setHerbalCompound));
    assertEquals("special", getFieldName(Drug.class, Drug::isSpecial));
    assertEquals("special", getFieldName(Drug.class, Drug::setSpecial));
    assertEquals("characteristics", getFieldName(Drug.class, Drug::getCharacteristics));
    assertEquals("characteristics", getFieldName(Drug.class, Drug::setCharacteristics));
    assertEquals("composition", getFieldName(Drug.class, Drug::getComposition));
    assertEquals("composition", getFieldName(Drug.class, Drug::setComposition));
    assertEquals("indications", getFieldName(Drug.class, Drug::getIndications));
    assertEquals("indications", getFieldName(Drug.class, Drug::setIndications));
    assertEquals("dosage", getFieldName(Drug.class, Drug::getDosage));
    assertEquals("dosage", getFieldName(Drug.class, Drug::setDosage));
    assertEquals("adverseReaction", getFieldName(Drug.class, Drug::getAdverseReaction));
    assertEquals("adverseReaction", getFieldName(Drug.class, Drug::setAdverseReaction));
    assertEquals("contraindications", getFieldName(Drug.class, Drug::getContraindications));
    assertEquals("contraindications", getFieldName(Drug.class, Drug::setContraindications));
    assertEquals("precautions", getFieldName(Drug.class, Drug::getPrecautions));
    assertEquals("precautions", getFieldName(Drug.class, Drug::setPrecautions));
    assertEquals("storage", getFieldName(Drug.class, Drug::getStorage));
    assertEquals("storage", getFieldName(Drug.class, Drug::setStorage));
    assertEquals("licenseNumber", getFieldName(Drug.class, Drug::getLicenseNumber));
    assertEquals("licenseNumber", getFieldName(Drug.class, Drug::setLicenseNumber));
    assertEquals("licenseDate", getFieldName(Drug.class, Drug::getLicenseDate));
    assertEquals("licenseDate", getFieldName(Drug.class, Drug::setLicenseDate));
    assertEquals("importNumber", getFieldName(Drug.class, Drug::getImportNumber));
    assertEquals("importNumber", getFieldName(Drug.class, Drug::setImportNumber));
    assertEquals("registrationNumber", getFieldName(Drug.class, Drug::getRegistrationNumber));
    assertEquals("registrationNumber", getFieldName(Drug.class, Drug::setRegistrationNumber));
    assertEquals("brand", getFieldName(Drug.class, Drug::getBrand));
    assertEquals("brand", getFieldName(Drug.class, Drug::setBrand));
    assertEquals("origin", getFieldName(Drug.class, Drug::getOrigin));
    assertEquals("origin", getFieldName(Drug.class, Drug::setOrigin));
    assertEquals("manufacturer", getFieldName(Drug.class, Drug::getManufacturer));
    assertEquals("manufacturer", getFieldName(Drug.class, Drug::setManufacturer));
    assertEquals("classification", getFieldName(Drug.class, Drug::getClassification));
    assertEquals("classification", getFieldName(Drug.class, Drug::setClassification));
    assertEquals("shelfLife", getFieldName(Drug.class, Drug::getShelfLife));
    assertEquals("shelfLife", getFieldName(Drug.class, Drug::setShelfLife));
    assertEquals("comment", getFieldName(Drug.class, Drug::getComment));
    assertEquals("comment", getFieldName(Drug.class, Drug::setComment));
    assertEquals("predefined", getFieldName(Drug.class, Drug::isPredefined));
    assertEquals("predefined", getFieldName(Drug.class, Drug::setPredefined));
    assertEquals("createTime", getFieldName(Drug.class, Drug::getCreateTime));
    assertEquals("createTime", getFieldName(Drug.class, Drug::setCreateTime));
    assertEquals("modifyTime", getFieldName(Drug.class, Drug::getModifyTime));
    assertEquals("modifyTime", getFieldName(Drug.class, Drug::setModifyTime));
    assertEquals("deleteTime", getFieldName(Drug.class, Drug::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Drug.class, Drug::setDeleteTime));
  }
}
