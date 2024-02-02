////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Account} class.
 *
 * @author Haixing Hu
 */
public class AccountTest extends ModelTestBase<Account> {

  public AccountTest() {
    super(Account.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Account.class, Account::getId));
    assertEquals("id", getFieldName(Account.class, Account::setId));
    assertEquals("app", getFieldName(Account.class, Account::getApp));
    assertEquals("app", getFieldName(Account.class, Account::setApp));
    assertEquals("ownerType", getFieldName(Account.class, Account::getOwnerType));
    assertEquals("ownerType", getFieldName(Account.class, Account::setOwnerType));
    assertEquals("ownerId", getFieldName(Account.class, Account::getOwnerId));
    assertEquals("ownerId", getFieldName(Account.class, Account::setOwnerId));
    assertEquals("type", getFieldName(Account.class, Account::getType));
    assertEquals("type", getFieldName(Account.class, Account::setType));
    assertEquals("name", getFieldName(Account.class, Account::getName));
    assertEquals("name", getFieldName(Account.class, Account::setName));
    assertEquals("number", getFieldName(Account.class, Account::getNumber));
    assertEquals("number", getFieldName(Account.class, Account::setNumber));
    assertEquals("provider", getFieldName(Account.class, Account::getProvider));
    assertEquals("provider", getFieldName(Account.class, Account::setProvider));
    assertEquals("createTime", getFieldName(Account.class, Account::getCreateTime));
    assertEquals("createTime", getFieldName(Account.class, Account::setCreateTime));
    assertEquals("modifyTime", getFieldName(Account.class, Account::getModifyTime));
    assertEquals("modifyTime", getFieldName(Account.class, Account::setModifyTime));
    assertEquals("deleteTime", getFieldName(Account.class, Account::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Account.class, Account::setDeleteTime));
  }
}
