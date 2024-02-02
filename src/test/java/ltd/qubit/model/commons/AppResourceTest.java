////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.commons;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link AppResource} class.
 *
 * @author Haixing Hu
 */
public class AppResourceTest extends ModelTestBase<AppResource> {

  public AppResourceTest() {
    super(AppResource.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(AppResource.class, AppResource::getId));
    assertEquals("id", getFieldName(AppResource.class, AppResource::setId));
    assertEquals("appId", getFieldName(AppResource.class, AppResource::getAppId));
    assertEquals("appId", getFieldName(AppResource.class, AppResource::setAppId));
    assertEquals("resourceType", getFieldName(AppResource.class, AppResource::getResourceType));
    assertEquals("resourceType", getFieldName(AppResource.class, AppResource::setResourceType));
    assertEquals("resourceId", getFieldName(AppResource.class, AppResource::getResourceId));
    assertEquals("resourceId", getFieldName(AppResource.class, AppResource::setResourceId));
    assertEquals("createTime", getFieldName(AppResource.class, AppResource::getCreateTime));
    assertEquals("createTime", getFieldName(AppResource.class, AppResource::setCreateTime));
    assertEquals("modifyTime", getFieldName(AppResource.class, AppResource::getModifyTime));
    assertEquals("modifyTime", getFieldName(AppResource.class, AppResource::setModifyTime));
    assertEquals("deleteTime", getFieldName(AppResource.class, AppResource::getDeleteTime));
    assertEquals("deleteTime", getFieldName(AppResource.class, AppResource::setDeleteTime));
  }
}
