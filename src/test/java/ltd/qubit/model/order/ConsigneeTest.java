////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Consignee} class.
 *
 * @author Haixing Hu
 */
public class ConsigneeTest extends ModelTestBase<Consignee> {

  public ConsigneeTest() {
    super(Consignee.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Consignee.class, Consignee::getId));
    assertEquals("id", getFieldName(Consignee.class, Consignee::setId));
    assertEquals("userId", getFieldName(Consignee.class, Consignee::getUserId));
    assertEquals("userId", getFieldName(Consignee.class, Consignee::setUserId));
    assertEquals("title", getFieldName(Consignee.class, Consignee::getTitle));
    assertEquals("title", getFieldName(Consignee.class, Consignee::setTitle));
    assertEquals("name", getFieldName(Consignee.class, Consignee::getName));
    assertEquals("name", getFieldName(Consignee.class, Consignee::setName));
    assertEquals("mobile", getFieldName(Consignee.class, Consignee::getMobile));
    assertEquals("mobile", getFieldName(Consignee.class, Consignee::setMobile));
    assertEquals("email", getFieldName(Consignee.class, Consignee::getEmail));
    assertEquals("email", getFieldName(Consignee.class, Consignee::setEmail));
    assertEquals("credential", getFieldName(Consignee.class, Consignee::getCredential));
    assertEquals("credential", getFieldName(Consignee.class, Consignee::setCredential));
    assertEquals("address", getFieldName(Consignee.class, Consignee::getAddress));
    assertEquals("address", getFieldName(Consignee.class, Consignee::setAddress));
    assertEquals("comment", getFieldName(Consignee.class, Consignee::getComment));
    assertEquals("comment", getFieldName(Consignee.class, Consignee::setComment));
    assertEquals("createTime", getFieldName(Consignee.class, Consignee::getCreateTime));
    assertEquals("createTime", getFieldName(Consignee.class, Consignee::setCreateTime));
    assertEquals("modifyTime", getFieldName(Consignee.class, Consignee::getModifyTime));
    assertEquals("modifyTime", getFieldName(Consignee.class, Consignee::setModifyTime));
    assertEquals("deleteTime", getFieldName(Consignee.class, Consignee::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Consignee.class, Consignee::setDeleteTime));
  }
}
