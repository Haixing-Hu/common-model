////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.commons;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Payload} class.
 *
 * @author Haixing Hu
 */
public class PayloadTest extends ModelTestBase<Payload> {

  public PayloadTest() {
    super(Payload.class);
  }

  @Test
  public void testRandomGenerated() throws Exception {
    for (int i = 0; i < DEFAULT_TEST_LOOPS * 10; ++i) {
      final Payload payload = random.nextObject(Payload.class);
      assertNotNull(payload.getOwner());
    }
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Payload.class, Payload::getId));
    assertEquals("id", getFieldName(Payload.class, Payload::setId));
    assertEquals("key", getFieldName(Payload.class, Payload::getKey));
    assertEquals("key", getFieldName(Payload.class, Payload::setKey));
    assertEquals("value", getFieldName(Payload.class, Payload::getValue));
    assertEquals("value", getFieldName(Payload.class, Payload::setValue));
    assertEquals("owner", getFieldName(Payload.class, Payload::getOwner));
    assertEquals("owner", getFieldName(Payload.class, Payload::setOwner));
    assertEquals("createTime", getFieldName(Payload.class, Payload::getCreateTime));
    assertEquals("createTime", getFieldName(Payload.class, Payload::setCreateTime));
    assertEquals("modifyTime", getFieldName(Payload.class, Payload::getModifyTime));
    assertEquals("modifyTime", getFieldName(Payload.class, Payload::setModifyTime));
    assertEquals("deleteTime", getFieldName(Payload.class, Payload::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Payload.class, Payload::setDeleteTime));
  }
}
