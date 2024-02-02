////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.lang.ArrayUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 对 {@link Emptyful} 接口进行单元测试。
 *
 * @author 胡海星
 */
public class EmptyfulTest {

  @Test
  public void testStaticIsEmpty() {
    assertTrue(Emptyful.isEmpty(null));
    assertTrue(Emptyful.isEmpty(""));
    assertTrue(Emptyful.isEmpty(Collections.emptyList()));
    assertTrue(Emptyful.isEmpty(Collections.emptySet()));
    assertTrue(Emptyful.isEmpty(Collections.emptyMap()));
    assertTrue(Emptyful.isEmpty(ArrayUtils.EMPTY_BOOLEAN_ARRAY));
    assertTrue(Emptyful.isEmpty(ArrayUtils.EMPTY_CHAR_ARRAY));
    assertTrue(Emptyful.isEmpty(ArrayUtils.EMPTY_BYTE_ARRAY));
    assertTrue(Emptyful.isEmpty(ArrayUtils.EMPTY_SHORT_ARRAY));
    assertTrue(Emptyful.isEmpty(ArrayUtils.EMPTY_INT_ARRAY));
    assertTrue(Emptyful.isEmpty(ArrayUtils.EMPTY_LONG_ARRAY));
    assertTrue(Emptyful.isEmpty(ArrayUtils.EMPTY_FLOAT_ARRAY));
    assertTrue(Emptyful.isEmpty(ArrayUtils.EMPTY_DOUBLE_ARRAY));
    assertTrue(Emptyful.isEmpty(ArrayUtils.EMPTY_CLASS_ARRAY));
    assertTrue(Emptyful.isEmpty(new Info()));
    assertTrue(Emptyful.isEmpty(new Info(null, "")));

    assertFalse(Emptyful.isEmpty("ab"));
    assertFalse(Emptyful.isEmpty(Arrays.asList("a", "b")));
    assertFalse(Emptyful.isEmpty(new String[] {"a"}));
    assertFalse(Emptyful.isEmpty(new Info(1l)));
    assertFalse(Emptyful.isEmpty(new Info(null, " ")));
  }
}
