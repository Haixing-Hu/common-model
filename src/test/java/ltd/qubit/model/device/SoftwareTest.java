////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.device;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Software} class.
 *
 * @author Haixing Hu
 */
public class SoftwareTest extends ModelTestBase<Software> {

  public SoftwareTest() {
    super(Software.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("platform", getFieldName(Software.class, Software::getPlatform));
    assertEquals("platform", getFieldName(Software.class, Software::setPlatform));
    assertEquals("name", getFieldName(Software.class, Software::getName));
    assertEquals("name", getFieldName(Software.class, Software::setName));
    assertEquals("version", getFieldName(Software.class, Software::getVersion));
    assertEquals("version", getFieldName(Software.class, Software::setVersion));
    assertEquals("build", getFieldName(Software.class, Software::getBuild));
    assertEquals("build", getFieldName(Software.class, Software::setBuild));
    assertEquals("patch", getFieldName(Software.class, Software::getPatch));
    assertEquals("patch", getFieldName(Software.class, Software::setPatch));
    assertEquals("codeName", getFieldName(Software.class, Software::getCodeName));
    assertEquals("codeName", getFieldName(Software.class, Software::setCodeName));
    assertEquals("manufacturer", getFieldName(Software.class, Software::getManufacturer));
    assertEquals("manufacturer", getFieldName(Software.class, Software::setManufacturer));
    assertEquals("description", getFieldName(Software.class, Software::getDescription));
    assertEquals("description", getFieldName(Software.class, Software::setDescription));
  }
}
