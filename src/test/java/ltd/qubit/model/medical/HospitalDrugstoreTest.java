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
 * Unit test of the {@link HospitalDrugstore} class.
 *
 * @author Haixing Hu
 */
public class HospitalDrugstoreTest extends ModelTestBase<HospitalDrugstore> {

  public HospitalDrugstoreTest() {
    super(HospitalDrugstore.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(HospitalDrugstore.class, HospitalDrugstore::getId));
    assertEquals("id", getFieldName(HospitalDrugstore.class, HospitalDrugstore::setId));
    assertEquals("hospital", getFieldName(HospitalDrugstore.class, HospitalDrugstore::getHospital));
    assertEquals("hospital", getFieldName(HospitalDrugstore.class, HospitalDrugstore::setHospital));
    assertEquals("drugstore", getFieldName(HospitalDrugstore.class, HospitalDrugstore::getDrugstore));
    assertEquals("drugstore", getFieldName(HospitalDrugstore.class, HospitalDrugstore::setDrugstore));
    assertEquals("createTime", getFieldName(HospitalDrugstore.class, HospitalDrugstore::getCreateTime));
    assertEquals("createTime", getFieldName(HospitalDrugstore.class, HospitalDrugstore::setCreateTime));
    assertEquals("modifyTime", getFieldName(HospitalDrugstore.class, HospitalDrugstore::getModifyTime));
    assertEquals("modifyTime", getFieldName(HospitalDrugstore.class, HospitalDrugstore::setModifyTime));
    assertEquals("deleteTime", getFieldName(HospitalDrugstore.class, HospitalDrugstore::getDeleteTime));
    assertEquals("deleteTime", getFieldName(HospitalDrugstore.class, HospitalDrugstore::setDeleteTime));
  }
}
