////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.controller;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link UpdatePasswordParams} class.
 *
 * @author Haixing Hu
 */
public class UpdatePasswordParamsTest extends ModelTestBase<UpdatePasswordParams> {

  public UpdatePasswordParamsTest() {
    super(UpdatePasswordParams.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("oldPassword", getFieldName(UpdatePasswordParams.class, UpdatePasswordParams::getOldPassword));
    assertEquals("oldPassword", getFieldName(UpdatePasswordParams.class, UpdatePasswordParams::setOldPassword));
    assertEquals("newPassword", getFieldName(UpdatePasswordParams.class, UpdatePasswordParams::getNewPassword));
    assertEquals("newPassword", getFieldName(UpdatePasswordParams.class, UpdatePasswordParams::setNewPassword));
    assertEquals("changePassword", getFieldName(UpdatePasswordParams.class, UpdatePasswordParams::isChangePassword));
    assertEquals("changePassword", getFieldName(UpdatePasswordParams.class, UpdatePasswordParams::setChangePassword));
  }
}
