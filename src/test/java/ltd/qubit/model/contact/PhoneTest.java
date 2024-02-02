////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.contact;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.test.ModelTestBase;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Phone} class.
 *
 * @author Haixing Hu
 */
public class PhoneTest extends ModelTestBase<Phone> {

  public PhoneTest() {
    super(Phone.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("countryArea", getFieldName(Phone.class, Phone::getCountryArea));
    assertEquals("countryArea", getFieldName(Phone.class, Phone::setCountryArea));
    assertEquals("cityArea", getFieldName(Phone.class, Phone::getCityArea));
    assertEquals("cityArea", getFieldName(Phone.class, Phone::setCityArea));
    assertEquals("number", getFieldName(Phone.class, Phone::getNumber));
    assertEquals("number", getFieldName(Phone.class, Phone::setNumber));
  }

  @Test
  public void testXmlDeserialization() throws JsonProcessingException {
    final Foo obj = random.nextObject(Foo.class);
    logger.debug("Testing XML deserialization for the object:\n{}", obj);
    final String xml = xmlMapper.writeValueAsString(obj);
    logger.info("The object is serialized to:\n{}", xml);
    final Foo result = xmlMapper.readValue(xml, obj.getClass());
    logger.debug("The XML is deserialized to:\n{}", result);
    assertEquals(obj, result);
    logger.debug("Test finished successfully.");
  }

  @Test
  public void testJsonDeserialization() throws JsonProcessingException {
    final Foo obj = random.nextObject(Foo.class);
    logger.debug("Testing JSON deserialization for the object:\n{}", obj);
    final String json = jsonMapper.writeValueAsString(obj);
    logger.info("The object is serialized to:\n{}", json);
    final Foo result = jsonMapper.readValue(json, obj.getClass());
    logger.debug("The JSON is deserialized to:\n{}", result);
    assertEquals(obj, result);
    logger.debug("Test finished successfully.");
  }

  private static class Foo {
    private Phone phone;
    private List<Phone> phoneList;

    public Foo() {
      // empty
    }

    public Phone getPhone() {
      return phone;
    }

    public void setPhone(final Phone phone) {
      this.phone = phone;
    }

    public List<Phone> getPhoneList() {
      return phoneList;
    }

    public void setPhoneList(final List<Phone> phoneList) {
      this.phoneList = phoneList;
    }

    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      final Foo other = (Foo) o;
      return Equality.equals(phone, other.phone) && Equality.equals(phoneList,
          other.phoneList);
    }

    public int hashCode() {
      final int multiplier = 7;
      int result = 3;
      result = Hash.combine(result, multiplier, phone);
      result = Hash.combine(result, multiplier, phoneList);
      return result;
    }

    public String toString() {
      return new ToStringBuilder(this)
          .append("phone", phone)
          .append("phoneList", phoneList)
          .toString();
    }
  }
}
