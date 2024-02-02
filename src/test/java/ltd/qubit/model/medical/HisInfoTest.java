////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.test.ModelTestBase;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the serialization of {@link HisInfo}.
 *
 * @author Haixing Hu
 */
public class HisInfoTest extends ModelTestBase<HisInfo> {

  public HisInfoTest() {
    super(HisInfo.class);
  }

  public static class Foo {

    private HisInfo hisInfo;

    public HisInfo getHisInfo() {
      return hisInfo;
    }

    public Foo setHisInfo(final HisInfo hisInfo) {
      this.hisInfo = hisInfo;
      return this;
    }

    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      final Foo other = (Foo) o;
      return Equality.equals(hisInfo, other.hisInfo);
    }

    @Override
    public int hashCode() {
      final int multiplier = 7;
      int result = 3;
      result = Hash.combine(result, multiplier, hisInfo);
      return result;
    }

    @Override
    public String toString() {
      return new ToStringBuilder(this)
              .append("hisInfo", hisInfo)
              .toString();
    }
  }

  @Test
  public void testJsonSerializeDeserialize() throws Exception {
    jsonTester.test(Foo.class);
  }

  @Test
  public void testXmlSerializeDeserialize() throws Exception {
    xmlTester.test(Foo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("type", getFieldName(HisInfo.class, HisInfo::getType));
    assertEquals("number", getFieldName(HisInfo.class, HisInfo::getNumber));
    assertEquals("number", getFieldName(HisInfo.class, HisInfo::setNumber));
    assertEquals("remark", getFieldName(HisInfo.class, HisInfo::getRemark));
    assertEquals("remark", getFieldName(HisInfo.class, HisInfo::setRemark));
  }
}
