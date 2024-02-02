////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.organization;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Organization} class.
 *
 * @author Haixing Hu
 */
public class OrganizationTest extends ModelTestBase<Organization> {

  public OrganizationTest() {
    super(Organization.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Organization.class, Organization::getId));
    assertEquals("id", getFieldName(Organization.class, Organization::setId));
    assertEquals("code", getFieldName(Organization.class, Organization::getCode));
    assertEquals("code", getFieldName(Organization.class, Organization::setCode));
    assertEquals("name", getFieldName(Organization.class, Organization::getName));
    assertEquals("name", getFieldName(Organization.class, Organization::setName));
    assertEquals("category", getFieldName(Organization.class, Organization::getCategory));
    assertEquals("category", getFieldName(Organization.class, Organization::setCategory));
    assertEquals("parent", getFieldName(Organization.class, Organization::getParent));
    assertEquals("parent", getFieldName(Organization.class, Organization::setParent));
    assertEquals("state", getFieldName(Organization.class, Organization::getState));
    assertEquals("state", getFieldName(Organization.class, Organization::setState));
    assertEquals("icon", getFieldName(Organization.class, Organization::getIcon));
    assertEquals("icon", getFieldName(Organization.class, Organization::setIcon));
    assertEquals("description", getFieldName(Organization.class, Organization::getDescription));
    assertEquals("description", getFieldName(Organization.class, Organization::setDescription));
    assertEquals("comment", getFieldName(Organization.class, Organization::getComment));
    assertEquals("comment", getFieldName(Organization.class, Organization::setComment));
    assertEquals("contact", getFieldName(Organization.class, Organization::getContact));
    assertEquals("contact", getFieldName(Organization.class, Organization::setContact));
    assertEquals("credential", getFieldName(Organization.class, Organization::getCredential));
    assertEquals("credential", getFieldName(Organization.class, Organization::setCredential));
    assertEquals("licenses", getFieldName(Organization.class, Organization::getLicenses));
    assertEquals("licenses", getFieldName(Organization.class, Organization::setLicenses));
    assertEquals("principal", getFieldName(Organization.class, Organization::getPrincipal));
    assertEquals("principal", getFieldName(Organization.class, Organization::setPrincipal));
    assertEquals("taxPayerType", getFieldName(Organization.class, Organization::getTaxPayerType));
    assertEquals("taxPayerType", getFieldName(Organization.class, Organization::setTaxPayerType));
    assertEquals("taxNumber", getFieldName(Organization.class, Organization::getTaxNumber));
    assertEquals("taxNumber", getFieldName(Organization.class, Organization::setTaxNumber));
    assertEquals("payloads", getFieldName(Organization.class, Organization::getPayloads));
    assertEquals("payloads", getFieldName(Organization.class, Organization::setPayloads));
    assertEquals("predefined", getFieldName(Organization.class, Organization::isPredefined));
    assertEquals("predefined", getFieldName(Organization.class, Organization::setPredefined));
    assertEquals("createTime", getFieldName(Organization.class, Organization::getCreateTime));
    assertEquals("createTime", getFieldName(Organization.class, Organization::setCreateTime));
    assertEquals("modifyTime", getFieldName(Organization.class, Organization::getModifyTime));
    assertEquals("modifyTime", getFieldName(Organization.class, Organization::setModifyTime));
    assertEquals("deleteTime", getFieldName(Organization.class, Organization::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Organization.class, Organization::setDeleteTime));
  }
}
