////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.settlement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.test.ModelTestBase;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the serialization of {@link Settlement}.
 *
 * @author Haixing Hu
 */
public class SettlementTest extends ModelTestBase<Settlement> {

  public SettlementTest() {
    super(Settlement.class);
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @JsonAutoDetect(fieldVisibility = ANY,
                  getterVisibility = NONE,
                  isGetterVisibility = NONE,
                  setterVisibility = NONE)
  @JsonInclude(Include.NON_NULL)
  public static class Foo {

        private Settlement settlement;

    public final Settlement getSettlement() {
      return settlement;
    }

    public final void setSettlement(final Settlement settlement) {
      this.settlement = settlement;
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
      return Equality.equals(settlement, other.settlement);
    }

    @Override
    public int hashCode() {
      final int multiplier = 7;
      int result = 3;
      result = Hash.combine(result, multiplier, settlement);
      return result;
    }

    @Override
    public String toString() {
      return new ToStringBuilder(this)
              .append("settlement", settlement)
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
    assertEquals("id", getFieldName(Settlement.class, Settlement::getId));
    assertEquals("id", getFieldName(Settlement.class, Settlement::setId));
    assertEquals("app", getFieldName(Settlement.class, Settlement::getApp));
    assertEquals("app", getFieldName(Settlement.class, Settlement::setApp));
    assertEquals("organization", getFieldName(Settlement.class, Settlement::getOrganization));
    assertEquals("organization", getFieldName(Settlement.class, Settlement::setOrganization));
    assertEquals("remark", getFieldName(Settlement.class, Settlement::getRemark));
    assertEquals("remark", getFieldName(Settlement.class, Settlement::setRemark));
    assertEquals("createTime", getFieldName(Settlement.class, Settlement::getCreateTime));
    assertEquals("createTime", getFieldName(Settlement.class, Settlement::setCreateTime));
    assertEquals("modifyTime", getFieldName(Settlement.class, Settlement::getModifyTime));
    assertEquals("modifyTime", getFieldName(Settlement.class, Settlement::setModifyTime));
    assertEquals("deleteTime", getFieldName(Settlement.class, Settlement::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Settlement.class, Settlement::setDeleteTime));
  }
}
