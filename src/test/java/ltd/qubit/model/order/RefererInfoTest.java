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
 * Unit test of the {@link RefererInfo} class.
 *
 * @author Haixing Hu
 */
public class RefererInfoTest extends ModelTestBase<RefererInfo> {

  public RefererInfoTest() {
    super(RefererInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(RefererInfo.class, RefererInfo::getId));
    assertEquals("id", getFieldName(RefererInfo.class, RefererInfo::setId));
    assertEquals("openidType", getFieldName(RefererInfo.class, RefererInfo::getOpenidType));
    assertEquals("openidType", getFieldName(RefererInfo.class, RefererInfo::setOpenidType));
    assertEquals("openid", getFieldName(RefererInfo.class, RefererInfo::getOpenid));
    assertEquals("openid", getFieldName(RefererInfo.class, RefererInfo::setOpenid));
    assertEquals("refererType", getFieldName(RefererInfo.class, RefererInfo::getRefererType));
    assertEquals("refererType", getFieldName(RefererInfo.class, RefererInfo::setRefererType));
    assertEquals("refererId", getFieldName(RefererInfo.class, RefererInfo::getRefererId));
    assertEquals("refererId", getFieldName(RefererInfo.class, RefererInfo::setRefererId));
    assertEquals("createTime", getFieldName(RefererInfo.class, RefererInfo::getCreateTime));
    assertEquals("createTime", getFieldName(RefererInfo.class, RefererInfo::setCreateTime));
    assertEquals("modifyTime", getFieldName(RefererInfo.class, RefererInfo::getModifyTime));
    assertEquals("modifyTime", getFieldName(RefererInfo.class, RefererInfo::setModifyTime));
    assertEquals("deleteTime", getFieldName(RefererInfo.class, RefererInfo::getDeleteTime));
    assertEquals("deleteTime", getFieldName(RefererInfo.class, RefererInfo::setDeleteTime));
  }
}
