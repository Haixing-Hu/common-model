////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.invoice;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link InvoiceHospitalRegiste} class.
 *
 * @author Haixing Hu
 */
public class InvoiceHospitalRegisteTest extends ModelTestBase<InvoiceHospitalRegiste> {

  public InvoiceHospitalRegisteTest() {
    super(InvoiceHospitalRegiste.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getId));
    assertEquals("id", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setId));
    assertEquals("code", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getCode));
    assertEquals("code", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setCode));
    assertEquals("name", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getName));
    assertEquals("name", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setName));
    assertEquals("zoneCode", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getZoneCode));
    assertEquals("zoneCode", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setZoneCode));
    assertEquals("payeeName", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getPayeeName));
    assertEquals("payeeName", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setPayeeName));
    assertEquals("payeeAccount", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getPayeeAccount));
    assertEquals("payeeAccount", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setPayeeAccount));
    assertEquals("payeeOpeningBank",
      getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getPayeeOpeningBank));
    assertEquals("payeeOpeningBank",
      getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setPayeeOpeningBank));
    assertEquals("account", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getAccount));
    assertEquals("account", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setAccount));
    assertEquals("password", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getPassword));
    assertEquals("password", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setPassword));
    assertEquals("registerTime", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getRegisterTime));
    assertEquals("registerTime", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setRegisterTime));
    assertEquals("createTime", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getCreateTime));
    assertEquals("createTime", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setCreateTime));
    assertEquals("modifyTime", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getModifyTime));
    assertEquals("modifyTime", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setModifyTime));
    assertEquals("deleteTime", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::getDeleteTime));
    assertEquals("deleteTime", getFieldName(InvoiceHospitalRegiste.class, InvoiceHospitalRegiste::setDeleteTime));
  }
}
