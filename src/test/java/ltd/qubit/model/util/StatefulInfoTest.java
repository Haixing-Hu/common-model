////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;
import ltd.qubit.model.commons.State;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

public class StatefulInfoTest extends ModelTestBase<StatefulInfo> {

  public StatefulInfoTest() {
    super(StatefulInfo.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("state", getFieldName(StatefulInfo.class, StatefulInfo::getState));
    assertEquals("state", getFieldName(StatefulInfo.class, StatefulInfo::setState));
  }

  @Test
  public void testIsEmpty() {
    final StatefulInfo o1 = new StatefulInfo();
    assertTrue(o1.isEmpty());
    final StatefulInfo o2 = new StatefulInfo(null, "", null);
    assertTrue(o2.isEmpty());
    final StatefulInfo o3 = new StatefulInfo(null, "", null);
    assertTrue(o3.isEmpty());
    final StatefulInfo o4 = new StatefulInfo(null, "", "");
    assertTrue(o4.isEmpty());
    final StatefulInfo o5 = new StatefulInfo(0l, "", "");
    assertFalse(o5.isEmpty());
    final StatefulInfo o6 = new StatefulInfo(null, "", "", State.NORMAL);
    assertFalse(o6.isEmpty());
    final StatefulInfo o7 = new StatefulInfo(null, "", "", null);
    assertTrue(o7.isEmpty());
  }

  @Test
  public void testNormalize() {
    final StatefulInfo o1 = new StatefulInfo();
    o1.normalize();
    assertEquals(new StatefulInfo(), o1);
    final StatefulInfo o2 = new StatefulInfo(null, "", null);
    o2.normalize();
    assertEquals(new StatefulInfo(), o2);
    final StatefulInfo o3 = new StatefulInfo(null, "", null);
    o3.normalize();
    assertEquals(new StatefulInfo(), o3);
    final StatefulInfo o4 = new StatefulInfo(null, "", "");
    o4.normalize();
    assertEquals(new StatefulInfo(), o4);
    final StatefulInfo o5 = new StatefulInfo(0l, "", "  ");
    o5.normalize();
    assertEquals(new StatefulInfo(0l), o5);
    final StatefulInfo o6 = new StatefulInfo(null, "", "　", State.NORMAL);
    o6.normalize();
    assertNull(o6.getId());
    assertNull(o6.getName());
    assertNull(o6.getCode());
    assertEquals(State.NORMAL, o6.getState());

    final StatefulInfo o7 = new StatefulInfo(null, "", "", null);
    o7.normalize();
    assertEquals(new StatefulInfo(), o7);
  }

}
