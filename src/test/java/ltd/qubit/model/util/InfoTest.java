////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import java.time.Instant;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

public class InfoTest extends ModelTestBase<Info> {

  public InfoTest() {
    super(Info.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Info.class, Info::getId));
    assertEquals("id", getFieldName(Info.class, Info::setId));
    assertEquals("code", getFieldName(Info.class, Info::getCode));
    assertEquals("code", getFieldName(Info.class, Info::setCode));
    assertEquals("name", getFieldName(Info.class, Info::getName));
    assertEquals("name", getFieldName(Info.class, Info::setName));
    assertEquals("deleteTime", getFieldName(Info.class, Info::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Info.class, Info::setDeleteTime));
  }

  @Test
  public void testIsEmpty() {
    final Info o1 = new Info();
    assertTrue(o1.isEmpty());
    final Info o2 = new Info(null, "", null);
    assertTrue(o2.isEmpty());
    final Info o3 = new Info(null, "", null);
    assertTrue(o3.isEmpty());
    final Info o4 = new Info(null, "", "");
    assertTrue(o4.isEmpty());
    final Info o5 = new Info(0l, "", "");
    assertFalse(o5.isEmpty());
    final Info o6 = new Info(null, "", "", Instant.MAX);
    assertFalse(o6.isEmpty());
  }

  @Test
  public void testNormalize() {
    final Info o1 = new Info();
    o1.normalize();
    assertEquals(new Info(), o1);
    final Info o2 = new Info(null, "", null);
    o2.normalize();
    assertEquals(new Info(), o2);
    final Info o3 = new Info(null, "", null);
    o3.normalize();
    assertEquals(new Info(), o3);
    final Info o4 = new Info(null, "", "");
    o4.normalize();
    assertEquals(new Info(), o4);
    final Info o5 = new Info(0l, "", "  ");
    o5.normalize();
    assertEquals(new Info(0l), o5);
    final Info o6 = new Info(null, "　　　ａ", "　");
    o6.normalize();
    assertNull(o6.getId());
    assertEquals("ａ", o6.getCode());
    assertNull(o6.getName());
    assertNull(o6.getDeleteTime());

    final Info o7 = new Info(null, "", "", Instant.MAX);
    o7.normalize();
    assertNull(o7.getId());
    assertNull(o7.getName());
    assertNull(o7.getCode());
    assertEquals(Instant.MAX, o7.getDeleteTime());
  }
}
