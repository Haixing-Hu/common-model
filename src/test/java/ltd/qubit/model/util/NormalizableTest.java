////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.lang.ArrayUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * 对 {@link Normalizable} 接口进行单元测试。
 *
 * @author 胡海星
 */
public class NormalizableTest {

  @Test
  public void testStaticNormalize() {
    assertNull(Normalizable.normalize(null));
    assertNull(Normalizable.normalize(""));
    assertNull(Normalizable.normalize("   "));
    assertNull(Normalizable.normalize("　"));
    assertNull(Normalizable.normalize(Collections.emptyList()));
    assertNull(Normalizable.normalize(Collections.emptySet()));
    assertNull(Normalizable.normalize(Collections.emptyMap()));
    assertNull(Normalizable.normalize(ArrayUtils.EMPTY_BOOLEAN_ARRAY));
    assertNull(Normalizable.normalize(ArrayUtils.EMPTY_CHAR_ARRAY));
    assertNull(Normalizable.normalize(ArrayUtils.EMPTY_BYTE_ARRAY));
    assertNull(Normalizable.normalize(ArrayUtils.EMPTY_SHORT_ARRAY));
    assertNull(Normalizable.normalize(ArrayUtils.EMPTY_INT_ARRAY));
    assertNull(Normalizable.normalize(ArrayUtils.EMPTY_LONG_ARRAY));
    assertNull(Normalizable.normalize(ArrayUtils.EMPTY_FLOAT_ARRAY));
    assertNull(Normalizable.normalize(ArrayUtils.EMPTY_DOUBLE_ARRAY));
    assertNull(Normalizable.normalize(ArrayUtils.EMPTY_CLASS_ARRAY));
    assertNull(Normalizable.normalize(new Info()));
    assertNull(Normalizable.normalize(new Info(null, "")));
    assertNull(Normalizable.normalize(new Info(null, "  ")));

    assertEquals("ab", Normalizable.normalize("ab"));
    assertEquals(new Info(null, "a"), Normalizable.normalize(new Info(null, "  a")));
  }
}
