////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.contact;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Contact} class.
 *
 * @author Haixing Hu
 */
public class ContactTest extends ModelTestBase<Contact> {

  public ContactTest() {
    super(Contact.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("phone", getFieldName(Contact.class, Contact::getPhone));
    assertEquals("phone", getFieldName(Contact.class, Contact::setPhone));
    assertEquals("phoneVerified", getFieldName(Contact.class, Contact::getPhoneVerified));
    assertEquals("phoneVerified", getFieldName(Contact.class, Contact::setPhoneVerified));
    assertEquals("mobile", getFieldName(Contact.class, Contact::getMobile));
    assertEquals("mobile", getFieldName(Contact.class, Contact::setMobile));
    assertEquals("mobileVerified", getFieldName(Contact.class, Contact::getMobileVerified));
    assertEquals("mobileVerified", getFieldName(Contact.class, Contact::setMobileVerified));
    assertEquals("email", getFieldName(Contact.class, Contact::getEmail));
    assertEquals("email", getFieldName(Contact.class, Contact::setEmail));
    assertEquals("emailVerified", getFieldName(Contact.class, Contact::getEmailVerified));
    assertEquals("emailVerified", getFieldName(Contact.class, Contact::setEmailVerified));
    assertEquals("url", getFieldName(Contact.class, Contact::getUrl));
    assertEquals("url", getFieldName(Contact.class, Contact::setUrl));
    assertEquals("address", getFieldName(Contact.class, Contact::getAddress));
    assertEquals("address", getFieldName(Contact.class, Contact::setAddress));
    assertEquals("addressVerified", getFieldName(Contact.class, Contact::getAddressVerified));
    assertEquals("addressVerified", getFieldName(Contact.class, Contact::setAddressVerified));
  }
}
