////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.system;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.error.InvalidSettingValueException;
import ltd.qubit.commons.error.TypeMismatchException;
import ltd.qubit.commons.lang.DateUtils;
import ltd.qubit.commons.lang.Type;
import ltd.qubit.commons.test.ModelTestBase;
import ltd.qubit.model.commons.State;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;
import static ltd.qubit.commons.test.xml.JacksonXmlTestUtils.assertXmlDeserializeEquals;
import static ltd.qubit.commons.test.xml.JacksonXmlTestUtils.assertXmlSerializeEquals;

/**
 * Unit test of the {@link Setting} class.
 *
 * @author Haixing Hu
 */
public class SettingTest extends ModelTestBase<Setting> {

  public SettingTest() {
    super(Setting.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("name", getFieldName(Setting.class, Setting::getName));
    assertEquals("name", getFieldName(Setting.class, Setting::setName));
    assertEquals("type", getFieldName(Setting.class, Setting::getType));
    assertEquals("type", getFieldName(Setting.class, Setting::setType));
    assertEquals("readonly", getFieldName(Setting.class, Setting::isReadonly));
    assertEquals("readonly", getFieldName(Setting.class, Setting::setReadonly));
    assertEquals("nullable", getFieldName(Setting.class, Setting::isNullable));
    assertEquals("nullable", getFieldName(Setting.class, Setting::setNullable));
    assertEquals("multiple", getFieldName(Setting.class, Setting::isMultiple));
    assertEquals("multiple", getFieldName(Setting.class, Setting::setMultiple));
    assertEquals("encrypted", getFieldName(Setting.class, Setting::isEncrypted));
    assertEquals("encrypted", getFieldName(Setting.class, Setting::setEncrypted));
    assertEquals("description", getFieldName(Setting.class, Setting::getDescription));
    assertEquals("description", getFieldName(Setting.class, Setting::setDescription));
    assertEquals("value", getFieldName(Setting.class, Setting::getValue));
    assertEquals("value", getFieldName(Setting.class, Setting::setValue));
    assertEquals("createTime", getFieldName(Setting.class, Setting::getCreateTime));
    assertEquals("createTime", getFieldName(Setting.class, Setting::setCreateTime));
    assertEquals("modifyTime", getFieldName(Setting.class, Setting::getModifyTime));
    assertEquals("modifyTime", getFieldName(Setting.class, Setting::setModifyTime));
    assertEquals("count", getFieldName(Setting.class, Setting::getCount));
  }

  /**
   * TestFragment method for {@link Setting#Setting()}.
   */
  @Test
  public void testSetting() {
    final Setting setting = new Setting();
    assertNull(setting.getName());
    assertEquals(Type.STRING, setting.getType());
    assertNull(setting.getValue());
    assertTrue(setting.isEmpty());
    assertFalse(setting.isReadonly());
    assertFalse(setting.isMultiple());
    assertFalse(setting.isNullable());
    assertFalse(setting.isEncrypted());
  }

  /**
   * TestFragment method for {@link Setting#Setting(String)}.
   */
  @Test
  public void testSettingString() {
    final Setting setting = new Setting("system.setting");
    assertEquals("system.setting", setting.getName());
    assertEquals(Type.STRING, setting.getType());
    assertNull(setting.getValue());
    assertTrue(setting.isEmpty());
    assertFalse(setting.isReadonly());
    assertFalse(setting.isMultiple());
    assertFalse(setting.isNullable());
    assertFalse(setting.isEncrypted());
  }

  /**
   * TestFragment method for {@link Setting#getName()} and {@link
   * Setting#setName(String)}.
   */
  @Test
  public void testGetSetName() {
    final Setting s1 = new Setting("system.setting");
    assertEquals("system.setting", s1.getName());
    final Setting s2 = new Setting();
    assertNull(s2.getName());

    s1.setName("s1.id");
    assertEquals("s1.id", s1.getName());

    s2.setName("s2.id");
    assertEquals("s2.id", s2.getName());

    s2.setName("");
    assertEquals("", s2.getName());

    s2.setName(null);
    assertNull(s2.getName());
  }

  /**
   * TestFragment method for {@link Setting#getType()} and {@link
   * Setting#setType(Type)} .
   */
  @Test
  public void testGetSetType() {
    final Setting s1 = new Setting();
    assertEquals(Type.STRING, s1.getType());
    s1.setString("s1");
    assertEquals("s1", s1.getValue());

    s1.setType(Type.INT);
    assertEquals(Type.INT, s1.getType());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#isReadonly()} and {@link
   * Setting#setReadonly(boolean)}.
   */
  @Test
  public void testGetSetReadOnly() {
    final Setting s1 = new Setting();
    assertFalse(s1.isReadonly());
    s1.setReadonly(true);
    assertTrue(s1.isReadonly());
    s1.setReadonly(false);
    assertFalse(s1.isReadonly());
  }

  /**
   * TestFragment method for {@link Setting#isNullable()} and {@link
   * Setting#setNullable(boolean)}.
   */
  @Test
  public void testGetSetNullable() {
    final Setting s1 = new Setting();
    assertFalse(s1.isNullable());
    s1.setNullable(true);
    assertTrue(s1.isNullable());
    s1.setNullable(false);
    assertFalse(s1.isNullable());
  }

  /**
   * TestFragment method for {@link Setting#isMultiple()} and {@link
   * Setting#setMultiple(boolean)}.
   */
  @Test
  public void testGetSetMultiple() {
    final Setting s1 = new Setting();
    assertFalse(s1.isMultiple());
    s1.setMultiple(true);
    assertTrue(s1.isMultiple());
    s1.setMultiple(false);
    assertFalse(s1.isMultiple());
  }

  /**
   * TestFragment method for {@link Setting#isEncrypted()} and {@link
   * Setting#setEncrypted(boolean)}.
   */
  @Test
  public void testGetSetEncrypted() {
    final Setting s1 = new Setting();
    assertFalse(s1.isEncrypted());
    s1.setEncrypted(true);
    assertTrue(s1.isEncrypted());
    s1.setEncrypted(false);
    assertFalse(s1.isEncrypted());
  }

  // stop checkstyle: MagicNumberCheck

  /**
   * TestFragment method for {@link Setting#getValue()}.
   */
  @Test
  public void testGetValue() {
    final Setting s1 = new Setting();
    assertNull(s1.getValue());

    s1.setValue("s1");
    assertEquals("s1", s1.getValue());

    s1.setBool(true);
    assertEquals("true", s1.getValue());

    s1.setBools(true, true, false);
    assertEquals("true, true, false", s1.getValue());

    s1.setChar('x');
    assertEquals("x", s1.getValue());

    s1.setChars('a', 'b', 'c', 'd');
    assertEquals("a, b, c, d", s1.getValue());

    s1.setString("xxx");
    assertEquals("xxx", s1.getValue());

    s1.setStrings("abc", "def", "xyz");
    assertEquals("abc\ndef\nxyz", s1.getValue());

    s1.setByte((byte) -123);
    assertEquals("-123", s1.getValue());

    s1.setBytes((byte) 1, (byte) 2);
    assertEquals("1, 2", s1.getValue());

    s1.setShort((short) -12345);
    assertEquals("-12345", s1.getValue());

    s1.setShorts((short) 1, (short) 2, (short) 3, (short) 4);
    assertEquals("1, 2, 3, 4", s1.getValue());

    s1.setInt(-12345678);
    assertEquals("-12345678", s1.getValue());

    s1.setInts(123, -456, 789, 1000);
    assertEquals("123, -456, 789, 1000", s1.getValue());

    s1.setLong(12345678890L);
    assertEquals("12345678890", s1.getValue());

    s1.setLongs(12345678890L, -12345678890L);
    assertEquals("12345678890, -12345678890", s1.getValue());

    s1.setFloat(3.14f);
    assertEquals("3.14", s1.getValue());

    s1.setFloats(3.14f, 0.618f);
    assertEquals("3.14, 0.618", s1.getValue());

    s1.setDouble(0.618);
    assertEquals("0.618", s1.getValue());

    s1.setDoubles(0.618, 9999.999);
    assertEquals("0.618, 9999.999", s1.getValue());

    s1.setDate(LocalDate.of(2012, 2, 14));
    assertEquals("2012-02-14", s1.getValue());

    s1.setDates(LocalDate.of(2012, 2, 14), LocalDate.of(2015, 8, 24));
    assertEquals("2012-02-14, 2015-08-24", s1.getValue());

    s1.setBigInteger(new BigInteger("-12345678901234567890"));
    assertEquals("-12345678901234567890", s1.getValue());

    s1.setBigIntegers(new BigInteger("12345678901234567890"),
        new BigInteger("-12345678901234567890"));
    assertEquals("12345678901234567890, -12345678901234567890", s1.getValue());

    s1.setBigDecimal(new BigDecimal("12345678901234567890.9917739475"));
    assertEquals("12345678901234567890.9917739475", s1.getValue());

    s1.setBigDecimals(new BigDecimal("12345678901234567890.9917739475"),
        new BigDecimal("-12345678901234567890.9917739475"));
    assertEquals("12345678901234567890.9917739475, "
                     + "-12345678901234567890.9917739475", s1.getValue());

    s1.setByteArray(new byte[]{0x10, 0x2A, 0x3C, 0x4D});
    assertEquals("0x10 0x2A 0x3C 0x4D", s1.getValue());

    s1.setByteArrays(new byte[]{0x10, 0x2A, 0x3C, 0x4D}, new byte[]{
        0x10, 0x2A, 0x3C, 0x4D});
    assertEquals("0x10 0x2A 0x3C 0x4D, 0x10 0x2A 0x3C 0x4D", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_boolean() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.BOOL);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getBool());
    assertArrayEquals(new Boolean[]{null}, s1.getBools());

    s1.setValue("true");
    assertEquals("true", s1.getValue());
    assertEquals(Boolean.TRUE, s1.getBool());
    assertArrayEquals(new Boolean[]{Boolean.TRUE}, s1.getBools());

    s1.setValue("false");
    assertEquals("false", s1.getValue());
    assertEquals(Boolean.FALSE, s1.getBool());
    assertArrayEquals(new Boolean[]{Boolean.FALSE}, s1.getBools());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getBool());
    assertArrayEquals(new Boolean[]{null}, s1.getBools());

    s1.setValue("true, false, true");
    assertEquals("true, false, true", s1.getValue());
    assertEquals(Boolean.TRUE, s1.getBool());
    assertArrayEquals(
        new Boolean[]{Boolean.TRUE, Boolean.FALSE, Boolean.TRUE},
        s1.getBools());

    s1.setValue("true, [null], true");
    assertEquals("true, [null], true", s1.getValue());
    assertEquals(Boolean.TRUE, s1.getBool());
    assertArrayEquals(new Boolean[]{Boolean.TRUE, null, Boolean.TRUE},
        s1.getBools());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getBool();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getBools();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("true, xxx");
    assertEquals("true, xxx", s1.getValue());
    try {
      s1.getBool();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getBools();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_char() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.CHAR);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getChar());
    assertArrayEquals(new Character[]{null}, s1.getChars());

    s1.setValue("x");
    assertEquals("x", s1.getValue());
    assertEquals(Character.valueOf('x'), s1.getChar());
    assertArrayEquals(new Character[]{'x'}, s1.getChars());

    s1.setValue("y");
    assertEquals("y", s1.getValue());
    assertEquals(Character.valueOf('y'), s1.getChar());
    assertArrayEquals(new Character[]{'y'}, s1.getChars());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getChar());
    assertArrayEquals(new Character[]{null}, s1.getChars());

    s1.setValue("x, y, z");
    assertEquals("x, y, z", s1.getValue());
    assertEquals(Character.valueOf('x'), s1.getChar());
    assertArrayEquals(new Character[]{'x', 'y', 'z'}, s1.getChars());

    s1.setValue("x, [null], z");
    assertEquals("x, [null], z", s1.getValue());
    assertEquals(Character.valueOf('x'), s1.getChar());
    assertArrayEquals(new Character[]{'x', null, 'z'}, s1.getChars());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getChar();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getChars();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("a, xxx");
    assertEquals("a, xxx", s1.getValue());
    try {
      s1.getChar();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getChars();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_byte() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.BYTE);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getByte());
    assertArrayEquals(new Byte[]{null}, s1.getBytes());

    s1.setValue("12");
    assertEquals("12", s1.getValue());
    assertEquals(Byte.valueOf((byte) 12), s1.getByte());
    assertArrayEquals(new Byte[]{(byte) 12}, s1.getBytes());

    s1.setValue("-121");
    assertEquals("-121", s1.getValue());
    assertEquals(Byte.valueOf((byte) -121), s1.getByte());
    assertArrayEquals(new Byte[]{(byte) -121}, s1.getBytes());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getByte());
    assertArrayEquals(new Byte[]{null}, s1.getBytes());

    s1.setValue("-12, -34, 121");
    assertEquals("-12, -34, 121", s1.getValue());
    assertEquals(Byte.valueOf((byte) -12), s1.getByte());
    assertArrayEquals(new Byte[]{(byte) -12, (byte) -34, (byte) 121},
        s1.getBytes());

    s1.setValue("-12, [null], 121");
    assertEquals("-12, [null], 121", s1.getValue());
    assertEquals(Byte.valueOf((byte) -12), s1.getByte());
    assertArrayEquals(new Byte[]{(byte) -12, null, (byte) 121},
        s1.getBytes());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getByte();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getBytes();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("-12, xxx");
    assertEquals("-12, xxx", s1.getValue());
    try {
      s1.getByte();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getBytes();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_short() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.SHORT);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getShort());
    assertArrayEquals(new Short[]{null}, s1.getShorts());

    s1.setValue("12");
    assertEquals("12", s1.getValue());
    assertEquals(Short.valueOf((short) 12), s1.getShort());
    assertArrayEquals(new Short[]{(short) 12}, s1.getShorts());

    s1.setValue("-121");
    assertEquals("-121", s1.getValue());
    assertEquals(Short.valueOf((short) -121), s1.getShort());
    assertArrayEquals(new Short[]{(short) -121}, s1.getShorts());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getShort());
    assertArrayEquals(new Short[]{null}, s1.getShorts());

    s1.setValue("-12, -34, 121");
    assertEquals("-12, -34, 121", s1.getValue());
    assertEquals(Short.valueOf((short) -12), s1.getShort());
    assertArrayEquals(new Short[]{(short) -12, (short) -34, (short) 121},
        s1.getShorts());

    s1.setValue("-12, [null], 121");
    assertEquals("-12, [null], 121", s1.getValue());
    assertEquals(Short.valueOf((short) -12), s1.getShort());
    assertArrayEquals(new Short[]{(short) -12, null, (short) 121},
        s1.getShorts());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getShort();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getShorts();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("-12, xxx");
    assertEquals("-12, xxx", s1.getValue());
    try {
      s1.getShort();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getShorts();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_int() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.INT);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getInt());
    assertArrayEquals(new Integer[]{null}, s1.getInts());

    s1.setValue("12");
    assertEquals("12", s1.getValue());
    assertEquals(Integer.valueOf(12), s1.getInt());
    assertArrayEquals(new Integer[]{12}, s1.getInts());

    s1.setValue("-121");
    assertEquals("-121", s1.getValue());
    assertEquals(Integer.valueOf(-121), s1.getInt());
    assertArrayEquals(new Integer[]{-121}, s1.getInts());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getInt());
    assertArrayEquals(new Integer[]{null}, s1.getInts());

    s1.setValue("-12, -34, 121");
    assertEquals("-12, -34, 121", s1.getValue());
    assertEquals(Integer.valueOf(-12), s1.getInt());
    assertArrayEquals(new Integer[]{-12, -34, 121}, s1.getInts());

    s1.setValue("-12, [null], 121");
    assertEquals("-12, [null], 121", s1.getValue());
    assertEquals(Integer.valueOf(-12), s1.getInt());
    assertArrayEquals(new Integer[]{-12, null, 121}, s1.getInts());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getInt();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getInts();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("-12, xxx");
    assertEquals("-12, xxx", s1.getValue());
    try {
      s1.getInt();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getInts();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_long() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.LONG);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getLong());
    assertArrayEquals(new Long[]{null}, s1.getLongs());

    s1.setValue("12");
    assertEquals("12", s1.getValue());
    assertEquals(Long.valueOf(12L), s1.getLong());
    assertArrayEquals(new Long[]{12L}, s1.getLongs());

    s1.setValue("-121");
    assertEquals("-121", s1.getValue());
    assertEquals(Long.valueOf(-121L), s1.getLong());
    assertArrayEquals(new Long[]{-121L}, s1.getLongs());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getLong());
    assertArrayEquals(new Long[]{null}, s1.getLongs());

    s1.setValue("-12, -34, 121");
    assertEquals("-12, -34, 121", s1.getValue());
    assertEquals(Long.valueOf(-12L), s1.getLong());
    assertArrayEquals(new Long[]{-12L, -34L, 121L}, s1.getLongs());

    s1.setValue("-12, [null], 121");
    assertEquals("-12, [null], 121", s1.getValue());
    assertEquals(Long.valueOf(-12L), s1.getLong());
    assertArrayEquals(new Long[]{-12L, null, 121L}, s1.getLongs());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getLong();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getLongs();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("-12, xxx");
    assertEquals("-12, xxx", s1.getValue());
    try {
      s1.getLong();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getLongs();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_float() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.FLOAT);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getFloat());
    assertArrayEquals(new Float[]{null}, s1.getFloats());

    s1.setValue("12.11");
    assertEquals("12.11", s1.getValue());
    assertEquals(Float.valueOf(12.11f), s1.getFloat());
    assertArrayEquals(new Float[]{12.11f}, s1.getFloats());

    s1.setValue("-121.9749");
    assertEquals("-121.9749", s1.getValue());
    assertEquals(Float.valueOf(-121.9749f), s1.getFloat());
    assertArrayEquals(new Float[]{-121.9749f}, s1.getFloats());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getFloat());
    assertArrayEquals(new Float[]{null}, s1.getFloats());

    s1.setValue("-12.11, -3.14159, 121.9749");
    assertEquals("-12.11, -3.14159, 121.9749", s1.getValue());
    assertEquals(Float.valueOf(-12.11f), s1.getFloat());
    assertArrayEquals(new Float[]{-12.11f, -3.14159f, 121.9749f},
        s1.getFloats());

    s1.setValue("-12.11, [null], 121.9749");
    assertEquals("-12.11, [null], 121.9749", s1.getValue());
    assertEquals(Float.valueOf(-12.11f), s1.getFloat());
    assertArrayEquals(new Float[]{-12.11f, null, 121.9749f},
        s1.getFloats());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getFloat();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getFloats();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("-12.11, xxx");
    assertEquals("-12.11, xxx", s1.getValue());
    try {
      s1.getFloat();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getFloats();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_double() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.DOUBLE);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getDouble());
    assertArrayEquals(new Double[]{null}, s1.getDoubles());

    s1.setValue("12.11");
    assertEquals("12.11", s1.getValue());
    assertEquals(Double.valueOf(12.11), s1.getDouble());
    assertArrayEquals(new Double[]{12.11}, s1.getDoubles());

    s1.setValue("-121.9749");
    assertEquals("-121.9749", s1.getValue());
    assertEquals(Double.valueOf(-121.9749), s1.getDouble());
    assertArrayEquals(new Double[]{-121.9749}, s1.getDoubles());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getDouble());
    assertArrayEquals(new Double[]{null}, s1.getDoubles());

    s1.setValue("-12.11, -3.14159, 121.9749");
    assertEquals("-12.11, -3.14159, 121.9749", s1.getValue());
    assertEquals(Double.valueOf(-12.11), s1.getDouble());
    assertArrayEquals(new Double[]{-12.11, -3.14159, 121.9749},
        s1.getDoubles());

    s1.setValue("-12.11, [null], 121.9749");
    assertEquals("-12.11, [null], 121.9749", s1.getValue());
    assertEquals(Double.valueOf(-12.11), s1.getDouble());
    assertArrayEquals(new Double[]{-12.11, null, 121.9749},
        s1.getDoubles());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getDouble();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getDoubles();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("-12.11, xxx");
    assertEquals("-12.11, xxx", s1.getValue());
    try {
      s1.getDouble();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getDoubles();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_date() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.DATE);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getDate());
    assertArrayEquals(new LocalDate[]{null}, s1.getDates());

    s1.setValue("2012-01-12");
    assertEquals("2012-01-12", s1.getValue());
    assertEquals(LocalDate.of(2012, 1, 12), s1.getDate());
    assertArrayEquals(new LocalDate[]{LocalDate.of(2012, 1, 12)},
        s1.getDates());

    s1.setValue("2015-01-15");
    assertEquals("2015-01-15", s1.getValue());
    assertEquals(LocalDate.of(2015, 1, 15), s1.getDate());
    assertArrayEquals(new LocalDate[]{LocalDate.of(2015, 1, 15)},
        s1.getDates());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getDate());
    assertArrayEquals(new LocalDate[]{null}, s1.getDates());

    s1.setValue("2012-01-12, 2015-01-15");
    assertEquals("2012-01-12, 2015-01-15", s1.getValue());
    assertEquals(LocalDate.of(2012, 1, 12), s1.getDate());
    assertArrayEquals(new LocalDate[]{LocalDate.of(2012, 1, 12),
        LocalDate.of(2015, 1, 15)}, s1.getDates());

    s1.setValue("2012-01-12, [null]");
    assertEquals("2012-01-12, [null]", s1.getValue());
    assertEquals(LocalDate.of(2012, 1, 12), s1.getDate());
    assertArrayEquals(new LocalDate[]{LocalDate.of(2012, 1, 12), null},
        s1.getDates());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getDate();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getDates();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("2012-01-12 00:00:00 UTC");
    assertEquals("2012-01-12 00:00:00 UTC", s1.getValue());
    try {
      s1.getDate();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("2012-01-12 00:00:00 UTC", e.getValue());
    }

    s1.setValue("2012-01-12, xxx");
    assertEquals("2012-01-12, xxx", s1.getValue());
    try {
      s1.getDate();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getDates();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_time() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.TIME);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getTime());
    assertArrayEquals(new LocalTime[]{null}, s1.getTimes());

    s1.setValue("11:23:01");
    assertEquals("11:23:01", s1.getValue());
    assertEquals(LocalTime.of(11, 23, 1), s1.getTime());
    assertArrayEquals(new LocalTime[]{LocalTime.of(11, 23, 1)}, s1.getTimes());

    s1.setValue("00:13:43");
    assertEquals("00:13:43", s1.getValue());
    assertEquals(LocalTime.of(0, 13, 43), s1.getTime());
    assertArrayEquals(new LocalTime[]{LocalTime.of(0, 13, 43)}, s1.getTimes());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getTime());
    assertArrayEquals(new LocalTime[]{null}, s1.getTimes());

    s1.setValue("00:00:00, 14:50:39");
    assertEquals("00:00:00, 14:50:39", s1.getValue());
    assertEquals(LocalTime.of(0, 0, 0), s1.getTime());
    assertArrayEquals(new LocalTime[]{LocalTime.of(0, 0, 0),
        LocalTime.of(14, 50, 39)}, s1.getTimes());

    s1.setValue("00:00:00, [null]");
    assertEquals("00:00:00, [null]", s1.getValue());
    assertEquals(LocalTime.of(0, 0, 0), s1.getTime());
    assertArrayEquals(new LocalTime[]{LocalTime.of(0, 0, 0), null},
        s1.getTimes());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getTime();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getTimes();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("00:00:00, xxx");
    assertEquals("00:00:00, xxx", s1.getValue());
    try {
      s1.getTime();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getTimes();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_datetime() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.DATETIME);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getDateTime());
    assertArrayEquals(new LocalDateTime[]{null}, s1.getDateTimes());

    s1.setValue("2012-01-12T00:00:00");
    assertEquals("2012-01-12T00:00:00", s1.getValue());
    assertEquals(LocalDateTime.of(2012, 1, 12, 0, 0, 0), s1.getDateTime());
    assertArrayEquals(
        new LocalDateTime[]{LocalDateTime.of(2012, 1, 12, 0, 0, 0)},
        s1.getDateTimes());

    s1.setValue("2015-01-15T14:50:39");
    assertEquals("2015-01-15T14:50:39", s1.getValue());
    assertEquals(LocalDateTime.of(2015, 1, 15, 14, 50, 39), s1.getDateTime());
    assertArrayEquals(
        new LocalDateTime[]{LocalDateTime.of(2015, 1, 15, 14, 50, 39)},
        s1.getDateTimes());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getDateTime());
    assertArrayEquals(new LocalDateTime[]{null}, s1.getDateTimes());

    s1.setValue("2012-01-12T00:00:00, 2015-01-15T14:50:39");
    assertEquals("2012-01-12T00:00:00, 2015-01-15T14:50:39",
        s1.getValue());
    assertEquals(LocalDateTime.of(2012, 1, 12, 0, 0, 0), s1.getDateTime());
    assertArrayEquals(
        new LocalDateTime[]{LocalDateTime.of(2012, 1, 12, 0, 0, 0),
            LocalDateTime.of(2015, 1, 15, 14, 50, 39)}, s1.getDateTimes());

    s1.setValue("2012-01-12T00:00:00, [null]");
    assertEquals("2012-01-12T00:00:00, [null]", s1.getValue());
    assertEquals(LocalDateTime.of(2012, 1, 12, 0, 0, 0), s1.getDateTime());
    assertArrayEquals(
        new LocalDateTime[]{LocalDateTime.of(2012, 1, 12, 0, 0, 0), null},
        s1.getDateTimes());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getDateTime();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getDateTimes();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("2012-01-12T00:00:00, xxx");
    assertEquals("2012-01-12T00:00:00, xxx", s1.getValue());
    try {
      s1.getDateTime();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getDateTimes();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  private static Timestamp getTimestamp(final int year, final int month,
      final int day, final int hour, final int minute, final int second) {
    final Calendar cal = new GregorianCalendar(DateUtils.UTC);
    cal.clear();
    cal.set(year, month - 1, day, hour, minute, second);
    return new Timestamp(cal.getTimeInMillis());
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_timestamp() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.TIMESTAMP);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getTimestamp());
    assertArrayEquals(new Timestamp[]{null}, s1.getTimestamps());

    s1.setValue("2012-01-12 00:00:00 UTC");
    assertEquals("2012-01-12 00:00:00 UTC", s1.getValue());
    assertEquals(getTimestamp(2012, 1, 12, 0, 0, 0), s1.getTimestamp());
    assertArrayEquals(new Timestamp[]{getTimestamp(2012, 1, 12, 0, 0, 0)},
        s1.getTimestamps());

    s1.setValue("2015-01-15 14:50:39 UTC");
    assertEquals("2015-01-15 14:50:39 UTC", s1.getValue());
    assertEquals(getTimestamp(2015, 1, 15, 14, 50, 39), s1.getTimestamp());
    assertArrayEquals(new Timestamp[]{getTimestamp(2015, 1, 15, 14, 50, 39)},
        s1.getTimestamps());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getTimestamp());
    assertArrayEquals(new Timestamp[]{null}, s1.getTimestamps());

    s1.setValue("2012-01-12 00:00:00 UTC, 2015-01-15 14:50:39 UTC");
    assertEquals("2012-01-12 00:00:00 UTC, 2015-01-15 14:50:39 UTC",
        s1.getValue());
    assertEquals(getTimestamp(2012, 1, 12, 0, 0, 0), s1.getTimestamp());
    assertArrayEquals(
        new Timestamp[]{getTimestamp(2012, 1, 12, 0, 0, 0),
            getTimestamp(2015, 1, 15, 14, 50, 39)},
        s1.getTimestamps());

    s1.setValue("2012-01-12 00:00:00 UTC, [null]");
    assertEquals("2012-01-12 00:00:00 UTC, [null]", s1.getValue());
    assertEquals(getTimestamp(2012, 1, 12, 0, 0, 0), s1.getTimestamp());
    assertArrayEquals(new Timestamp[]{getTimestamp(2012, 1, 12, 0, 0, 0), null},
        s1.getTimestamps());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getTimestamp();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getTimestamps();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("2012-01-12 00:00:00 UTC, xxx");
    assertEquals("2012-01-12 00:00:00 UTC, xxx", s1.getValue());
    try {
      s1.getTimestamp();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getTimestamps();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_BigInteger() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.BIG_INTEGER);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getBigInteger());
    assertArrayEquals(new BigInteger[]{null}, s1.getBigIntegers());

    s1.setValue("123456789123456789");
    assertEquals("123456789123456789", s1.getValue());
    assertEquals(new BigInteger("123456789123456789"), s1.getBigInteger());
    assertArrayEquals(new BigInteger[]{new BigInteger("123456789123456789")},
        s1.getBigIntegers());

    s1.setValue("-123456789123456789");
    assertEquals("-123456789123456789", s1.getValue());
    assertEquals(new BigInteger("-123456789123456789"), s1.getBigInteger());
    assertArrayEquals(new BigInteger[]{new BigInteger("-123456789123456789")},
        s1.getBigIntegers());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getBigInteger());
    assertArrayEquals(new BigInteger[]{null}, s1.getBigIntegers());

    s1.setValue("-123456789123456789, -789123456789, 789123456789");
    assertEquals("-123456789123456789, -789123456789, 789123456789",
        s1.getValue());
    assertEquals(new BigInteger("-123456789123456789"), s1.getBigInteger());
    assertArrayEquals(new BigInteger[]{new BigInteger("-123456789123456789"),
        new BigInteger("-789123456789"), new BigInteger("789123456789")},
        s1.getBigIntegers());

    s1.setValue("-123456789123456789, [null], 789123456789");
    assertEquals("-123456789123456789, [null], 789123456789", s1.getValue());
    assertEquals(new BigInteger("-123456789123456789"), s1.getBigInteger());
    assertArrayEquals(new BigInteger[]{new BigInteger("-123456789123456789"),
        null, new BigInteger("789123456789")}, s1.getBigIntegers());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getBigInteger();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getBigIntegers();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("-123456789, xxx");
    assertEquals("-123456789, xxx", s1.getValue());
    try {
      s1.getBigInteger();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getBigIntegers();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_BigDecimal() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.BIG_DECIMAL);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getBigDecimal());
    assertArrayEquals(new BigDecimal[]{null}, s1.getBigDecimals());

    s1.setValue("123456789.123456789");
    assertEquals("123456789.123456789", s1.getValue());
    assertEquals(new BigDecimal("123456789.123456789"), s1.getBigDecimal());
    assertArrayEquals(new BigDecimal[]{new BigDecimal("123456789.123456789")},
        s1.getBigDecimals());

    s1.setValue("-123456789.123456789");
    assertEquals("-123456789.123456789", s1.getValue());
    assertEquals(new BigDecimal("-123456789.123456789"), s1.getBigDecimal());
    assertArrayEquals(new BigDecimal[]{new BigDecimal("-123456789.123456789")},
        s1.getBigDecimals());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getBigDecimal());
    assertArrayEquals(new BigDecimal[]{null}, s1.getBigDecimals());

    s1.setValue("-123456789.123456789, -789.123456789, 7891234567.89");
    assertEquals("-123456789.123456789, -789.123456789, 7891234567.89",
        s1.getValue());
    assertEquals(new BigDecimal("-123456789.123456789"), s1.getBigDecimal());
    assertArrayEquals(new BigDecimal[]{new BigDecimal("-123456789.123456789"),
        new BigDecimal("-789.123456789"), new BigDecimal("7891234567.89")},
        s1.getBigDecimals());

    s1.setValue("-123456789.123456789, [null], 789.123456789");
    assertEquals("-123456789.123456789, [null], 789.123456789", s1.getValue());
    assertEquals(new BigDecimal("-123456789.123456789"), s1.getBigDecimal());
    assertArrayEquals(new BigDecimal[]{new BigDecimal("-123456789.123456789"),
        null, new BigDecimal("789.123456789")}, s1.getBigDecimals());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getBigDecimal();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getBigDecimals();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("-1234.56789, xxx");
    assertEquals("-1234.56789, xxx", s1.getValue());
    try {
      s1.getBigDecimal();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getBigDecimals();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_ByteArray() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.BYTE_ARRAY);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getByteArray());
    assertArrayEquals(new byte[][]{null}, s1.getByteArrays());

    s1.setValue("0x10 0x20 0x30");
    assertEquals("0x10 0x20 0x30", s1.getValue());
    assertArrayEquals(new byte[]{0x10, 0x20, 0x30}, s1.getByteArray());
    assertArrayEquals(new byte[][]{new byte[]{0x10, 0x20, 0x30}},
        s1.getByteArrays());

    s1.setValue("0x10 0x20 0x3F");
    assertEquals("0x10 0x20 0x3F", s1.getValue());
    assertArrayEquals(new byte[]{0x10, 0x20, 0x3F}, s1.getByteArray());
    assertArrayEquals(new byte[][]{new byte[]{0x10, 0x20, 0x3F}},
        s1.getByteArrays());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertArrayEquals(null, s1.getByteArray());
    assertArrayEquals(new byte[][]{null}, s1.getByteArrays());

    s1.setValue("0x10 0x20 0x30, 0x10 0x20 0x3F, 0x3F");
    assertEquals("0x10 0x20 0x30, 0x10 0x20 0x3F, 0x3F",
        s1.getValue());
    assertArrayEquals(new byte[]{0x10, 0x20, 0x30}, s1.getByteArray());
    assertArrayEquals(new byte[][]{new byte[]{0x10, 0x20, 0x30},
        new byte[]{0x10, 0x20, 0x3F}, new byte[]{0x3F}},
        s1.getByteArrays());

    s1.setValue("0x10 0x20 0x30, [null], 0x3F");
    assertEquals("0x10 0x20 0x30, [null], 0x3F", s1.getValue());
    assertArrayEquals(new byte[]{0x10, 0x20, 0x30}, s1.getByteArray());
    assertArrayEquals(new byte[][]{new byte[]{0x10, 0x20, 0x30},
        null, new byte[]{0x3F}},
        s1.getByteArrays());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getByteArray();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getByteArrays();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("0x10 0x20 0x3F, xxx");
    assertEquals("0x10 0x20 0x3F, xxx", s1.getValue());
    try {
      s1.getByteArray();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
    try {
      s1.getByteArrays();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }
  }

  /**
   * TestFragment method for {@link Setting#setValue(String)}.
   */
  @Test
  public void testSetValue_string() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setType(Type.STRING);
    s1.setValue(null);
    assertNull(s1.getValue());
    assertNull(s1.getString());
    assertArrayEquals(new String[]{null}, s1.getStrings());

    s1.setValue("abcdef");
    assertEquals("abcdef", s1.getValue());
    assertEquals("abcdef", s1.getString());
    assertArrayEquals(new String[]{"abcdef"}, s1.getStrings());

    s1.setValue("xxxyyyzzz");
    assertEquals("xxxyyyzzz", s1.getValue());
    assertEquals("xxxyyyzzz", s1.getString());
    assertArrayEquals(new String[]{"xxxyyyzzz"}, s1.getStrings());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getString());
    assertArrayEquals(new String[]{null}, s1.getStrings());

    s1.setValue("abcdef\n yyyyyu\n xxxyyyzzz");
    assertEquals("abcdef\n yyyyyu\n xxxyyyzzz", s1.getValue());
    assertEquals("abcdef", s1.getString());
    assertArrayEquals(new String[]{"abcdef", "yyyyyu", "xxxyyyzzz"},
        s1.getStrings());

    s1.setValue("abcdef\n [null]\n xxxyyyzzz");
    assertEquals("abcdef\n [null]\n xxxyyyzzz", s1.getValue());
    assertEquals("abcdef", s1.getString());
    assertArrayEquals(new String[]{"abcdef", null, "xxxyyyzzz"},
        s1.getStrings());
  }

  /**
   * TestFragment method for {@link Setting#getCount()}.
   */
  @Test
  public void testGetCount() {
    final Setting s1 = new Setting();
    assertEquals(0, s1.getCount());

    s1.setBool(true);
    assertEquals(1, s1.getCount());

    s1.setBool(null);
    assertEquals(1, s1.getCount());

    s1.setBools(new Boolean[]{true, false, null});
    assertEquals(3, s1.getCount());

    s1.setValue(null);
    assertEquals(1, s1.getCount());
  }

  /**
   * TestFragment method for {@link Setting#isEmpty()}.
   */
  @Test
  public void testIsEmpty() {
    final Setting s1 = new Setting();
    assertTrue(s1.isEmpty());

    s1.setBool(true);
    assertFalse(s1.isEmpty());

    s1.setBool(null);
    assertFalse(s1.isEmpty());

    s1.setValue(null);
    assertFalse(s1.isEmpty());
  }

  /**
   * TestFragment method for {@link Setting#getBool()} and {@link
   * Setting#setBool(Boolean)}.
   */
  @Test
  public void testGetSetBool() {
    final Setting s1 = new Setting();

    s1.setBool(true);
    assertEquals(Type.BOOL, s1.getType());
    assertEquals(Boolean.TRUE, s1.getBool());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Boolean[]{Boolean.TRUE}, s1.getBools());
    assertEquals("true", s1.getValue());

    s1.setBool(false);
    assertEquals(Type.BOOL, s1.getType());
    assertEquals(Boolean.FALSE, s1.getBool());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Boolean[]{Boolean.FALSE}, s1.getBools());
    assertEquals("false", s1.getValue());

    s1.setBool(null);
    assertEquals(Type.BOOL, s1.getType());
    assertNull(s1.getBool());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Boolean[]{null}, s1.getBools());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getBools()} and {@link
   * Setting#setBools(Boolean[])}.
   */
  @Test
  public void testGetSetBools() {
    final Setting s1 = new Setting();

    s1.setBools(true, false);
    assertEquals(Type.BOOL, s1.getType());
    assertEquals(Boolean.TRUE, s1.getBool());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new Boolean[]{Boolean.TRUE, Boolean.FALSE},
        s1.getBools());
    assertEquals("true, false", s1.getValue());

    s1.setBools(false, true);
    assertEquals(Type.BOOL, s1.getType());
    assertEquals(Boolean.FALSE, s1.getBool());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new Boolean[]{Boolean.FALSE, Boolean.TRUE},
        s1.getBools());
    assertEquals("false, true", s1.getValue());

    s1.setBools(new Boolean[]{null, Boolean.TRUE, Boolean.FALSE});
    assertEquals(Type.BOOL, s1.getType());
    assertNull(s1.getBool());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Boolean[]{null, Boolean.TRUE, Boolean.FALSE},
        s1.getBools());
    assertEquals("[null], true, false", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getChar()} and {@link
   * Setting#setChar(Character)}.
   */
  @Test
  public void testGetSetChar() {
    final Setting s1 = new Setting();

    s1.setChar('x');
    assertEquals(Type.CHAR, s1.getType());
    assertEquals(Character.valueOf('x'), s1.getChar());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Character[]{'x'}, s1.getChars());
    assertEquals("x", s1.getValue());

    s1.setChar('y');
    assertEquals(Type.CHAR, s1.getType());
    assertEquals(Character.valueOf('y'), s1.getChar());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Character[]{'y'}, s1.getChars());
    assertEquals("y", s1.getValue());

    s1.setChar(null);
    assertEquals(Type.CHAR, s1.getType());
    assertNull(s1.getChar());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Character[]{null}, s1.getChars());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getChars()} and {@link
   * Setting#setChars(Character[])}.
   */
  @Test
  public void testGetSetChars() {
    final Setting s1 = new Setting();

    s1.setChars('x', 'y');
    assertEquals(Type.CHAR, s1.getType());
    assertEquals(Character.valueOf('x'), s1.getChar());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new Character[]{'x', 'y'}, s1.getChars());
    assertEquals("x, y", s1.getValue());

    s1.setChars('y', 'x', 'z');
    assertEquals(Type.CHAR, s1.getType());
    assertEquals(Character.valueOf('y'), s1.getChar());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Character[]{'y', 'x', 'z'}, s1.getChars());
    assertEquals("y, x, z", s1.getValue());

    s1.setChars(new Character[]{null, 'x', 'y'});
    assertEquals(Type.CHAR, s1.getType());
    assertNull(s1.getChar());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Character[]{null, 'x', 'y'}, s1.getChars());
    assertEquals("[null], x, y", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getByte()} and {@link
   * Setting#setByte(Byte)}.
   */
  @Test
  public void testGetSetByte() {
    final Setting s1 = new Setting();

    s1.setByte((byte) 123);
    assertEquals(Type.BYTE, s1.getType());
    assertEquals(Byte.valueOf((byte) 123), s1.getByte());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Byte[]{(byte) 123}, s1.getBytes());
    assertEquals("123", s1.getValue());

    s1.setByte((byte) -123);
    assertEquals(Type.BYTE, s1.getType());
    assertEquals(Byte.valueOf((byte) -123), s1.getByte());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Byte[]{(byte) -123}, s1.getBytes());
    assertEquals("-123", s1.getValue());

    s1.setByte(null);
    assertEquals(Type.BYTE, s1.getType());
    assertNull(s1.getByte());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Byte[]{null}, s1.getBytes());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getBytes()} and {@link
   * Setting#setBytes(Byte[])}.
   */
  @Test
  public void testGetSetBytes() {
    final Setting s1 = new Setting();

    s1.setBytes((byte) 73, (byte) -123);
    assertEquals(Type.BYTE, s1.getType());
    assertEquals(Byte.valueOf((byte) 73), s1.getByte());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new Byte[]{(byte) 73, (byte) -123}, s1.getBytes());
    assertEquals("73, -123", s1.getValue());

    s1.setBytes((byte) 73, (byte) -123, (byte) 0);
    assertEquals(Type.BYTE, s1.getType());
    assertEquals(Byte.valueOf((byte) 73), s1.getByte());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Byte[]{(byte) 73, (byte) -123, (byte) 0},
        s1.getBytes());
    assertEquals("73, -123, 0", s1.getValue());

    s1.setBytes(new Byte[]{(byte) 73, null, (byte) 0});
    assertEquals(Type.BYTE, s1.getType());
    assertEquals(Byte.valueOf((byte) 73), s1.getByte());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Byte[]{(byte) 73, null, (byte) 0},
        s1.getBytes());
    assertEquals("73, [null], 0", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getShort()} and {@link
   * Setting#setShort(Short)}.
   */
  @Test
  public void testGetSetShort() {
    final Setting s1 = new Setting();

    s1.setShort((short) 123);
    assertEquals(Type.SHORT, s1.getType());
    assertEquals(Short.valueOf((short) 123), s1.getShort());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Short[]{(short) 123}, s1.getShorts());
    assertEquals("123", s1.getValue());

    s1.setShort((short) -123);
    assertEquals(Type.SHORT, s1.getType());
    assertEquals(Short.valueOf((short) -123), s1.getShort());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Short[]{(short) -123}, s1.getShorts());
    assertEquals("-123", s1.getValue());

    s1.setShort(null);
    assertEquals(Type.SHORT, s1.getType());
    assertNull(s1.getShort());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Short[]{null}, s1.getShorts());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getShorts()} and {@link
   * Setting#setShorts(Short[])}.
   */
  @Test
  public void testGetSetShorts() {
    final Setting s1 = new Setting();

    s1.setShorts((short) 73, (short) -123);
    assertEquals(Type.SHORT, s1.getType());
    assertEquals(Short.valueOf((short) 73), s1.getShort());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new Short[]{(short) 73, (short) -123},
        s1.getShorts());
    assertEquals("73, -123", s1.getValue());

    s1.setShorts((short) 73, (short) -123, (short) 0);
    assertEquals(Type.SHORT, s1.getType());
    assertEquals(Short.valueOf((short) 73), s1.getShort());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Short[]{(short) 73, (short) -123, (short) 0},
        s1.getShorts());
    assertEquals("73, -123, 0", s1.getValue());

    s1.setShorts(new Short[]{(short) 73, null, (short) 0});
    assertEquals(Type.SHORT, s1.getType());
    assertEquals(Short.valueOf((short) 73), s1.getShort());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Short[]{(short) 73, null, (short) 0},
        s1.getShorts());
    assertEquals("73, [null], 0", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getInt()} and {@link
   * Setting#setInt(Integer)}.
   */
  @Test
  public void testGetSetInt() {
    final Setting s1 = new Setting();

    s1.setInt(123);
    assertEquals(Type.INT, s1.getType());
    assertEquals(Integer.valueOf(123), s1.getInt());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Integer[]{123}, s1.getInts());
    assertEquals("123", s1.getValue());

    s1.setInt(-123);
    assertEquals(Type.INT, s1.getType());
    assertEquals(Integer.valueOf(-123), s1.getInt());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Integer[]{-123}, s1.getInts());
    assertEquals("-123", s1.getValue());

    s1.setInt(null);
    assertEquals(Type.INT, s1.getType());
    assertNull(s1.getInt());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Integer[]{null}, s1.getInts());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getInts()} and {@link
   * Setting#setInts(Integer[])}.
   */
  @Test
  public void testGetSetInts() {
    final Setting s1 = new Setting();

    s1.setInts(73, -123);
    assertEquals(Type.INT, s1.getType());
    assertEquals(Integer.valueOf(73), s1.getInt());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new Integer[]{73, -123}, s1.getInts());
    assertEquals("73, -123", s1.getValue());

    s1.setInts(73, -123, 0);
    assertEquals(Type.INT, s1.getType());
    assertEquals(Integer.valueOf(73), s1.getInt());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Integer[]{73, -123, 0}, s1.getInts());
    assertEquals("73, -123, 0", s1.getValue());

    s1.setInts(new Integer[]{73, null, 0});
    assertEquals(Type.INT, s1.getType());
    assertEquals(Integer.valueOf(73), s1.getInt());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Integer[]{73, null, 0}, s1.getInts());
    assertEquals("73, [null], 0", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getLong()} and {@link
   * Setting#setLong(Long)}.
   */
  @Test
  public void testGetSetLong() {
    final Setting s1 = new Setting();

    s1.setLong(123L);
    assertEquals(Type.LONG, s1.getType());
    assertEquals(Long.valueOf(123L), s1.getLong());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Long[]{123L}, s1.getLongs());
    assertEquals("123", s1.getValue());

    s1.setLong(-123L);
    assertEquals(Type.LONG, s1.getType());
    assertEquals(Long.valueOf(-123L), s1.getLong());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Long[]{-123L}, s1.getLongs());
    assertEquals("-123", s1.getValue());

    s1.setLong(null);
    assertEquals(Type.LONG, s1.getType());
    assertNull(s1.getLong());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Long[]{null}, s1.getLongs());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getLongs()} and {@link
   * Setting#setLongs(Long[])}.
   */
  @Test
  public void testGetSetLongs() {
    final Setting s1 = new Setting();

    s1.setLongs(73L, -123L);
    assertEquals(Type.LONG, s1.getType());
    assertEquals(Long.valueOf(73L), s1.getLong());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new Long[]{73L, -123L}, s1.getLongs());
    assertEquals("73, -123", s1.getValue());

    s1.setLongs(73L, -123L, 0L);
    assertEquals(Type.LONG, s1.getType());
    assertEquals(Long.valueOf(73L), s1.getLong());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Long[]{73L, -123L, 0L}, s1.getLongs());
    assertEquals("73, -123, 0", s1.getValue());

    s1.setLongs(new Long[]{73L, null, 0L});
    assertEquals(Type.LONG, s1.getType());
    assertEquals(Long.valueOf(73L), s1.getLong());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Long[]{73L, null, 0L}, s1.getLongs());
    assertEquals("73, [null], 0", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getFloat()} and {@link
   * Setting#setFloat(Float)}.
   */
  @Test
  public void testGetSetFloat() {
    final Setting s1 = new Setting();

    s1.setFloat(123.323f);
    assertEquals(Type.FLOAT, s1.getType());
    assertEquals(Float.valueOf(123.323f), s1.getFloat());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Float[]{123.323f}, s1.getFloats());
    assertEquals("123.323", s1.getValue());

    s1.setFloat(-123.323f);
    assertEquals(Type.FLOAT, s1.getType());
    assertEquals(Float.valueOf(-123.323f), s1.getFloat());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Float[]{-123.323f}, s1.getFloats());
    assertEquals("-123.323", s1.getValue());

    s1.setFloat(null);
    assertEquals(Type.FLOAT, s1.getType());
    assertNull(s1.getFloat());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Float[]{null}, s1.getFloats());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getFloats()} and {@link
   * Setting#setFloats(Float[])}.
   */
  @Test
  public void testGetSetFloats() {
    final Setting s1 = new Setting();

    s1.setFloats(3.141593f, -123.323f);
    assertEquals(Type.FLOAT, s1.getType());
    assertEquals(Float.valueOf(3.141593f), s1.getFloat());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new Float[]{3.141593f, -123.323f},
        s1.getFloats());
    assertEquals("3.141593, -123.323", s1.getValue());

    s1.setFloats(3.141593f, -123.323f, 0.00f);
    assertEquals(Type.FLOAT, s1.getType());
    assertEquals(Float.valueOf(3.141593f), s1.getFloat());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Float[]{3.141593f, -123.323f, 0.00f},
        s1.getFloats());
    assertEquals("3.141593, -123.323, 0.0", s1.getValue());

    s1.setFloats(new Float[]{3.141593f, null, -123.323f});
    assertEquals(Type.FLOAT, s1.getType());
    assertEquals(Float.valueOf(3.141593f), s1.getFloat());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Float[]{3.141593f, null, -123.323f},
        s1.getFloats());
    assertEquals("3.141593, [null], -123.323", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getDouble()} and {@link
   * Setting#setDouble(Double)}.
   */
  @Test
  public void testGetSetDouble() {
    final Setting s1 = new Setting();

    s1.setDouble(123.323);
    assertEquals(Type.DOUBLE, s1.getType());
    assertEquals(Double.valueOf(123.323), s1.getDouble());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Double[]{123.323}, s1.getDoubles());
    assertEquals("123.323", s1.getValue());

    s1.setDouble(-123.323);
    assertEquals(Type.DOUBLE, s1.getType());
    assertEquals(Double.valueOf(-123.323), s1.getDouble());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Double[]{-123.323}, s1.getDoubles());
    assertEquals("-123.323", s1.getValue());

    s1.setDouble(null);
    assertEquals(Type.DOUBLE, s1.getType());
    assertNull(s1.getDouble());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new Double[]{null}, s1.getDoubles());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getDoubles()} and {@link
   * Setting#setDoubles(Double[])}.
   */
  @Test
  public void testGetSetDoubles() {
    final Setting s1 = new Setting();

    s1.setDoubles(3.1415926, -123.323);
    assertEquals(Type.DOUBLE, s1.getType());
    assertEquals(Double.valueOf(3.1415926), s1.getDouble());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new Double[]{3.1415926, -123.323},
        s1.getDoubles());
    assertEquals("3.1415926, -123.323", s1.getValue());

    s1.setDoubles(3.1415926, -123.323, 0.00);
    assertEquals(Type.DOUBLE, s1.getType());
    assertEquals(Double.valueOf(3.1415926), s1.getDouble());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Double[]{3.1415926, -123.323, 0.00},
        s1.getDoubles());
    assertEquals("3.1415926, -123.323, 0.0", s1.getValue());

    s1.setDoubles(new Double[]{3.1415926, null, -123.323});
    assertEquals(Type.DOUBLE, s1.getType());
    assertEquals(Double.valueOf(3.1415926), s1.getDouble());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new Double[]{3.1415926, null, -123.323},
        s1.getDoubles());
    assertEquals("3.1415926, [null], -123.323", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getString()} and {@link
   * Setting#setString(String)}.
   */
  @Test
  public void testGetSetString() {
    final Setting s1 = new Setting();

    s1.setString("abc");
    assertEquals(Type.STRING, s1.getType());
    assertEquals("abc", s1.getString());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new String[]{"abc"}, s1.getStrings());
    assertEquals("abc", s1.getValue());

    s1.setString("def");
    assertEquals(Type.STRING, s1.getType());
    assertEquals("def", s1.getString());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new String[]{"def"}, s1.getStrings());
    assertEquals("def", s1.getValue());

    s1.setString(null);
    assertEquals(Type.STRING, s1.getType());
    assertNull(s1.getString());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new String[]{null}, s1.getStrings());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getStrings()} and {@link
   * Setting#setStrings(String[])}.
   */
  @Test
  public void testGetSetStrings() {
    final Setting s1 = new Setting();

    s1.setStrings("abc", "def");
    assertEquals(Type.STRING, s1.getType());
    assertEquals("abc", s1.getString());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new String[]{"abc", "def"}, s1.getStrings());
    assertEquals("abc\ndef", s1.getValue());

    s1.setStrings("abc", "def", "xyz");
    assertEquals(Type.STRING, s1.getType());
    assertEquals("abc", s1.getString());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new String[]{"abc", "def", "xyz"},
        s1.getStrings());
    assertEquals("abc\ndef\nxyz", s1.getValue());

    s1.setStrings("abc", null, "xyz", "[null]");
    assertEquals(Type.STRING, s1.getType());
    assertEquals("abc", s1.getString());
    assertEquals(4, s1.getCount());
    assertArrayEquals(new String[]{"abc", null, "xyz", "[null]"},
        s1.getStrings());
    assertEquals("abc\n[null]\nxyz\n[null]", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getDate()} and {@link
   * Setting#setDate(LocalDate)}.
   */
  @Test
  public void testGetSetDate() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setDate(null);
    assertNull(s1.getValue());
    assertNull(s1.getDate());
    assertArrayEquals(new LocalDate[]{null}, s1.getDates());

    s1.setDate(LocalDate.of(2012, 1, 12));
    assertEquals("2012-01-12", s1.getValue());
    assertEquals(LocalDate.of(2012, 1, 12), s1.getDate());
    assertArrayEquals(new LocalDate[]{LocalDate.of(2012, 1, 12)},
        s1.getDates());

    s1.setDate(LocalDate.of(2015, 1, 15));
    assertEquals("2015-01-15", s1.getValue());
    assertEquals(LocalDate.of(2015, 1, 15), s1.getDate());
    assertArrayEquals(new LocalDate[]{LocalDate.of(2015, 1, 15)},
        s1.getDates());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getDate());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getDate();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setString("xxx");
    try {
      s1.getDate();
    } catch (final TypeMismatchException e) {
      assertEquals(Type.DATE.name(), e.getExpectedTypeName());
      assertEquals(Type.STRING.name(), e.getActualTypeName());
    }
  }

  /**
   * TestFragment method for {@link Setting#getDates()} and {@link
   * Setting#setDates(LocalDate...)}.
   */
  @Test
  public void testGetSetDates() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setDates(LocalDate.of(2012, 1, 12), LocalDate.of(2015, 1, 15));
    assertEquals("2012-01-12, 2015-01-15", s1.getValue());
    assertEquals(LocalDate.of(2012, 1, 12), s1.getDate());
    assertArrayEquals(new LocalDate[]{LocalDate.of(2012, 1, 12),
        LocalDate.of(2015, 1, 15)}, s1.getDates());

    s1.setDates(LocalDate.of(2012, 1, 12), null);
    assertEquals("2012-01-12, [null]", s1.getValue());
    assertEquals(LocalDate.of(2012, 1, 12), s1.getDate());
    assertArrayEquals(new LocalDate[]{LocalDate.of(2012, 1, 12), null},
        s1.getDates());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertArrayEquals(new LocalDate[]{null}, s1.getDates());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getDates();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setStrings("xxx", "yyy");
    try {
      s1.getDates();
    } catch (final TypeMismatchException e) {
      assertEquals(Type.DATE.name(), e.getExpectedTypeName());
      assertEquals(Type.STRING.name(), e.getActualTypeName());
    }
  }

  /**
   * TestFragment method for {@link Setting#getTime()} and {@link
   * Setting#setTime(LocalTime)}.
   */
  @Test
  public void testGetSetTime() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setTime(null);
    assertNull(s1.getValue());
    assertNull(s1.getTime());
    assertArrayEquals(new LocalTime[]{null}, s1.getTimes());

    s1.setTime(LocalTime.of(11, 23, 1));
    assertEquals("11:23:01", s1.getValue());
    assertEquals(LocalTime.of(11, 23, 1), s1.getTime());
    assertArrayEquals(new LocalTime[]{LocalTime.of(11, 23, 1)}, s1.getTimes());

    s1.setTime(LocalTime.of(0, 13, 43));
    assertEquals("00:13:43", s1.getValue());
    assertEquals(LocalTime.of(0, 13, 43), s1.getTime());
    assertArrayEquals(new LocalTime[]{LocalTime.of(0, 13, 43)}, s1.getTimes());

    s1.setTime(LocalTime.of(12, 0, 0));
    assertEquals("12:00", s1.getValue());
    assertEquals(LocalTime.of(12, 0, 0), s1.getTime());
    assertArrayEquals(new LocalTime[]{LocalTime.of(12, 0, 0)}, s1.getTimes());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getTime());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getTime();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setString("xxx");
    try {
      s1.getTime();
    } catch (final TypeMismatchException e) {
      assertEquals(Type.TIME.name(), e.getExpectedTypeName());
      assertEquals(Type.STRING.name(), e.getActualTypeName());
    }
  }

  /**
   * TestFragment method for {@link Setting#getTimes()} and {@link
   * Setting#setTimes(LocalTime...)}.
   */
  @Test
  public void testGetSetTimes() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setTimes(LocalTime.of(0, 0, 0), LocalTime.of(14, 50, 39));
    assertEquals("00:00, 14:50:39", s1.getValue());
    assertEquals(LocalTime.of(0, 0, 0), s1.getTime());
    assertArrayEquals(new LocalTime[]{LocalTime.of(0, 0, 0),
        LocalTime.of(14, 50, 39)}, s1.getTimes());

    s1.setTimes(LocalTime.of(14, 50, 39), null);
    assertEquals("14:50:39, [null]", s1.getValue());
    assertEquals(LocalTime.of(14, 50, 39), s1.getTime());
    assertArrayEquals(new LocalTime[]{LocalTime.of(14, 50, 39), null},
        s1.getTimes());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertArrayEquals(new LocalTime[]{null}, s1.getTimes());

    s1.setValue("00:00:00, xxx");
    assertEquals("00:00:00, xxx", s1.getValue());
    try {
      s1.getTimes();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setStrings("xxx", "yyy");
    try {
      s1.getTimes();
    } catch (final TypeMismatchException e) {
      assertEquals(Type.TIME.name(), e.getExpectedTypeName());
      assertEquals(Type.STRING.name(), e.getActualTypeName());
    }
  }


  /**
   * TestFragment method for {@link Setting#getDateTime()} and {@link
   * Setting#setDateTime(LocalDateTime)}.
   */
  @Test
  public void testGetSetDateTime() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setDateTime(null);
    assertNull(s1.getValue());
    assertNull(s1.getDateTime());
    assertArrayEquals(new LocalDateTime[]{null}, s1.getDateTimes());

    s1.setDateTime(LocalDateTime.of(2012, 1, 12, 0, 0, 0));
    assertEquals("2012-01-12T00:00", s1.getValue());
    assertEquals(LocalDateTime.of(2012, 1, 12, 0, 0, 0), s1.getDateTime());
    assertArrayEquals(
        new LocalDateTime[]{LocalDateTime.of(2012, 1, 12, 0, 0, 0)},
        s1.getDateTimes());

    s1.setDateTime(LocalDateTime.of(2015, 1, 15, 14, 50, 39));
    assertEquals("2015-01-15T14:50:39", s1.getValue());
    assertEquals(LocalDateTime.of(2015, 1, 15, 14, 50, 39), s1.getDateTime());
    assertArrayEquals(
        new LocalDateTime[]{LocalDateTime.of(2015, 1, 15, 14, 50, 39)},
        s1.getDateTimes());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getDateTime());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getDateTime();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setString("xxx");
    try {
      s1.getDateTime();
    } catch (final TypeMismatchException e) {
      assertEquals(Type.DATETIME.name(), e.getExpectedTypeName());
      assertEquals(Type.STRING.name(), e.getActualTypeName());
    }
  }

  /**
   * TestFragment method for {@link Setting#getDateTimes()} and {@link
   * Setting#setDateTimes(LocalDateTime...)}.
   */
  @Test
  public void testGetSetDateTimes() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setDateTimes(LocalDateTime.of(2012, 1, 12, 0, 0, 0),
        LocalDateTime.of(2015, 1, 15, 14, 50, 39));
    assertEquals("2012-01-12T00:00, 2015-01-15T14:50:39",
        s1.getValue());
    assertEquals(LocalDateTime.of(2012, 1, 12, 0, 0, 0), s1.getDateTime());
    assertArrayEquals(
        new LocalDateTime[]{LocalDateTime.of(2012, 1, 12, 0, 0, 0),
            LocalDateTime.of(2015, 1, 15, 14, 50, 39)}, s1.getDateTimes());

    s1.setDateTimes(LocalDateTime.of(2015, 1, 15, 14, 50, 39), null);
    assertEquals("2015-01-15T14:50:39, [null]", s1.getValue());
    assertEquals(LocalDateTime.of(2015, 1, 15, 14, 50, 39), s1.getDateTime());
    assertArrayEquals(
        new LocalDateTime[]{LocalDateTime.of(2015, 1, 15, 14, 50, 39), null},
        s1.getDateTimes());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertArrayEquals(new LocalDateTime[]{null}, s1.getDateTimes());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getDateTimes();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("2012-01-12T00:00:00, xxx");
    assertEquals("2012-01-12T00:00:00, xxx", s1.getValue());
    try {
      s1.getDateTimes();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setStrings("xxx", "yyy");
    try {
      s1.getDateTimes();
    } catch (final TypeMismatchException e) {
      assertEquals(Type.DATETIME.name(), e.getExpectedTypeName());
      assertEquals(Type.STRING.name(), e.getActualTypeName());
    }
  }


  /**
   * TestFragment method for {@link Setting#getTimestamp()} and {@link
   * Setting#setTimestamp(Timestamp)}.
   */
  @Test
  public void testGetSetTimestamp() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setTimestamp(null);
    assertNull(s1.getValue());
    assertNull(s1.getTimestamp());
    assertArrayEquals(new Timestamp[]{null}, s1.getTimestamps());

    s1.setTimestamp(getTimestamp(2012, 1, 12, 0, 0, 0));
    assertEquals("2012-01-12 00:00:00 UTC", s1.getValue());
    assertEquals(getTimestamp(2012, 1, 12, 0, 0, 0), s1.getTimestamp());
    assertArrayEquals(new Timestamp[]{getTimestamp(2012, 1, 12, 0, 0, 0)},
        s1.getTimestamps());

    s1.setTimestamp(getTimestamp(2015, 1, 15, 14, 50, 39));
    assertEquals("2015-01-15 14:50:39 UTC", s1.getValue());
    assertEquals(getTimestamp(2015, 1, 15, 14, 50, 39), s1.getTimestamp());
    assertArrayEquals(new Timestamp[]{getTimestamp(2015, 1, 15, 14, 50, 39)},
        s1.getTimestamps());

    s1.setValue("[null]");
    assertEquals("[null]", s1.getValue());
    assertNull(s1.getTimestamp());
    assertArrayEquals(new Timestamp[]{null}, s1.getTimestamps());

    s1.setValue("xxx");
    assertEquals("xxx", s1.getValue());
    try {
      s1.getTimestamp();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setValue("2012-01-12 00:00:00 UTC, xxx");
    assertEquals("2012-01-12 00:00:00 UTC, xxx", s1.getValue());
    try {
      s1.getTimestamp();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setString("xxx");
    try {
      s1.getTimestamps();
    } catch (final TypeMismatchException e) {
      assertEquals(Type.TIMESTAMP.name(), e.getExpectedTypeName());
      assertEquals(Type.STRING.name(), e.getActualTypeName());
    }
  }

  /**
   * TestFragment method for {@link Setting#getTimestamps()} and {@link
   * Setting#setTimestamps(Timestamp...)}.
   */
  @Test
  public void testGetSetTimestamps() {
    final Setting s1 = new Setting("s1");
    assertNull(s1.getValue());

    s1.setTimestamps(getTimestamp(2012, 1, 12, 0, 0, 0),
        getTimestamp(2015, 1, 15, 14, 50, 39));
    assertEquals("2012-01-12 00:00:00 UTC, 2015-01-15 14:50:39 UTC",
        s1.getValue());
    assertEquals(getTimestamp(2012, 1, 12, 0, 0, 0), s1.getTimestamp());
    assertArrayEquals(
        new Timestamp[]{getTimestamp(2012, 1, 12, 0, 0, 0),
            getTimestamp(2015, 1, 15, 14, 50, 39)},
        s1.getTimestamps());

    s1.setTimestamps(getTimestamp(2012, 1, 12, 0, 0, 0), null);
    assertEquals("2012-01-12 00:00:00 UTC, [null]", s1.getValue());
    assertEquals(getTimestamp(2012, 1, 12, 0, 0, 0), s1.getTimestamp());
    assertArrayEquals(new Timestamp[]{getTimestamp(2012, 1, 12, 0, 0, 0), null},
        s1.getTimestamps());

    s1.setValue("2012-01-12 00:00:00 UTC, xxx");
    assertEquals("2012-01-12 00:00:00 UTC, xxx", s1.getValue());
    try {
      s1.getTimestamps();
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

    s1.setStrings("xxx", "yyy");
    try {
      s1.getTimestamps();
    } catch (final TypeMismatchException e) {
      assertEquals(Type.TIMESTAMP.name(), e.getExpectedTypeName());
      assertEquals(Type.STRING.name(), e.getActualTypeName());
    }
  }

  /**
   * TestFragment method for {@link Setting#getBigInteger()} and {@link
   * Setting#setBigInteger(BigInteger)}.
   */
  @Test
  public void testGetSetBigInteger() {
    final Setting s1 = new Setting();

    s1.setBigInteger(new BigInteger("12345678901234567890"));
    assertEquals(Type.BIG_INTEGER, s1.getType());
    assertEquals(new BigInteger("12345678901234567890"), s1.getBigInteger());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new BigInteger[]{new BigInteger("12345678901234567890")},
        s1.getBigIntegers());
    assertEquals("12345678901234567890", s1.getValue());

    s1.setBigInteger(new BigInteger("-12345678901234567890"));
    assertEquals(Type.BIG_INTEGER, s1.getType());
    assertEquals(new BigInteger("-12345678901234567890"), s1.getBigInteger());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new BigInteger[]{new BigInteger("-12345678901234567890")},
        s1.getBigIntegers());
    assertEquals("-12345678901234567890", s1.getValue());

    s1.setBigInteger(null);
    assertEquals(Type.BIG_INTEGER, s1.getType());
    assertNull(s1.getBigInteger());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new BigInteger[]{null}, s1.getBigIntegers());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getBigIntegers()} and {@link
   * Setting#setBigIntegers(BigInteger[])}.
   */
  @Test
  public void testGetSetBigIntegers() {
    final Setting s1 = new Setting();

    s1.setBigIntegers(new BigInteger("12345678901234567890"),
        new BigInteger("-12345678901234567890"));
    assertEquals(Type.BIG_INTEGER, s1.getType());
    assertEquals(new BigInteger("12345678901234567890"), s1.getBigInteger());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new BigInteger[]{new BigInteger("12345678901234567890"),
        new BigInteger("-12345678901234567890")}, s1.getBigIntegers());
    assertEquals("12345678901234567890, -12345678901234567890", s1.getValue());

    s1.setBigIntegers(new BigInteger("12345678901234567890"),
        new BigInteger("789127381293912038"), new BigInteger("-12932193821093821"));
    assertEquals(Type.BIG_INTEGER, s1.getType());
    assertEquals(new BigInteger("12345678901234567890"), s1.getBigInteger());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new BigInteger[]{new BigInteger("12345678901234567890"),
        new BigInteger("789127381293912038"), new BigInteger("-12932193821093821")},
        s1.getBigIntegers());
    assertEquals("12345678901234567890, 789127381293912038, "
                     + "-12932193821093821", s1.getValue());

    s1.setBigIntegers(new BigInteger("12345678901234567890"),
        new BigInteger("789127381293912038"), null, new BigInteger("-12932193821093821"));
    assertEquals(Type.BIG_INTEGER, s1.getType());
    assertEquals(new BigInteger("12345678901234567890"),
        s1.getBigInteger());
    assertEquals(4, s1.getCount());
    assertArrayEquals(new BigInteger[]{new BigInteger("12345678901234567890"),
        new BigInteger("789127381293912038"), null,
        new BigInteger("-12932193821093821")}, s1.getBigIntegers());
    assertEquals("12345678901234567890, 789127381293912038, "
        + "[null], -12932193821093821", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getBigDecimal()} and {@link
   * Setting#setBigDecimal(BigDecimal)}.
   */
  @Test
  public void testGetSetBigDecimal() {
    final Setting s1 = new Setting();

    s1.setBigDecimal(new BigDecimal("123456789.012345678901"));
    assertEquals(Type.BIG_DECIMAL, s1.getType());
    assertEquals(new BigDecimal("123456789.012345678901"), s1.getBigDecimal());
    assertEquals(1, s1.getCount());
    assertArrayEquals(
        new BigDecimal[]{new BigDecimal("123456789.012345678901")},
        s1.getBigDecimals());
    assertEquals("123456789.012345678901", s1.getValue());

    s1.setBigDecimal(new BigDecimal("-1234567890.12345678901"));
    assertEquals(Type.BIG_DECIMAL, s1.getType());
    assertEquals(new BigDecimal("-1234567890.12345678901"), s1.getBigDecimal());
    assertEquals(1, s1.getCount());
    assertArrayEquals(
        new BigDecimal[]{new BigDecimal("-1234567890.12345678901")},
        s1.getBigDecimals());
    assertEquals("-1234567890.12345678901", s1.getValue());

    s1.setBigDecimal(null);
    assertEquals(Type.BIG_DECIMAL, s1.getType());
    assertNull(s1.getBigDecimal());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new BigDecimal[]{null}, s1.getBigDecimals());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getBigDecimal()} and {@link
   * Setting#setBigDecimal(BigDecimal)}.
   */
  @Test
  public void testGetSetBigDecimals() {
    final Setting s1 = new Setting();

    s1.setBigDecimals(new BigDecimal("1234.56789012345678909"),
        new BigDecimal("-1234.56789012345678904"));
    assertEquals(Type.BIG_DECIMAL, s1.getType());
    assertEquals(new BigDecimal("1234.56789012345678909"), s1.getBigDecimal());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new BigDecimal[]{new BigDecimal("1234.56789012345678909"),
        new BigDecimal("-1234.56789012345678904")}, s1.getBigDecimals());
    assertEquals("1234.56789012345678909, -1234.56789012345678904",
        s1.getValue());

    s1.setBigDecimals(new BigDecimal("12345678.90123456789099"),
        new BigDecimal("78912738129.3912038"), new BigDecimal("-12932193.821093821"));
    assertEquals(Type.BIG_DECIMAL, s1.getType());
    assertEquals(new BigDecimal("12345678.90123456789099"), s1.getBigDecimal());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new BigDecimal[]{new BigDecimal("12345678.90123456789099"),
        new BigDecimal("78912738129.3912038"), new BigDecimal("-12932193.821093821")},
        s1.getBigDecimals());
    assertEquals("12345678.90123456789099, 78912738129.3912038, "
                     + "-12932193.821093821", s1.getValue());

    s1.setBigDecimals(new BigDecimal("1234567890.123456789099"),
        new BigDecimal("789127381.293912038"), null,
        new BigDecimal("-1.2932193821093821"));
    assertEquals(Type.BIG_DECIMAL, s1.getType());
    assertEquals(new BigDecimal("1234567890.123456789099"),
        s1.getBigDecimal());
    assertEquals(4, s1.getCount());
    assertArrayEquals(new BigDecimal[]{new BigDecimal("1234567890.123456789099"),
        new BigDecimal("789127381.293912038"), null,
        new BigDecimal("-1.2932193821093821")}, s1.getBigDecimals());
    assertEquals("1234567890.123456789099, 789127381.293912038, [null], "
                     + "-1.2932193821093821", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getByteArray()} and {@link
   * Setting#setByteArray(byte[])}.
   */
  @Test
  public void testGetSetByteArray() {
    final Setting s1 = new Setting();

    s1.setByteArray(new byte[]{0x10, 0x20, 0x30});
    assertEquals(Type.BYTE_ARRAY, s1.getType());
    assertArrayEquals(new byte[]{0x10, 0x20, 0x30}, s1.getByteArray());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new byte[][]{new byte[]{0x10, 0x20, 0x30}},
        s1.getByteArrays());
    assertEquals("0x10 0x20 0x30", s1.getValue());

    s1.setByteArray(new byte[]{0x10, 0x20, 0x3F});
    assertEquals(Type.BYTE_ARRAY, s1.getType());
    assertArrayEquals(new byte[]{0x10, 0x20, 0x3F}, s1.getByteArray());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new byte[][]{new byte[]{0x10, 0x20, 0x3F}},
        s1.getByteArrays());
    assertEquals("0x10 0x20 0x3F", s1.getValue());

    s1.setByteArray(null);
    assertEquals(Type.BYTE_ARRAY, s1.getType());
    assertArrayEquals(null, s1.getByteArray());
    assertEquals(1, s1.getCount());
    assertArrayEquals(new byte[][]{null}, s1.getByteArrays());
    assertNull(s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getByteArrays()} and {@link
   * Setting#setByteArrays(byte[]...)}.
   */
  @Test
  public void testGetSetByteArrays() {
    final Setting s1 = new Setting();

    s1.setByteArrays(new byte[]{0x10, 0x20, 0x30},
        new byte[]{0x10, 0x20, 0x3F});
    assertEquals(Type.BYTE_ARRAY, s1.getType());
    assertArrayEquals(new byte[]{0x10, 0x20, 0x30}, s1.getByteArray());
    assertEquals(2, s1.getCount());
    assertArrayEquals(new byte[][]{new byte[]{0x10, 0x20, 0x30},
        new byte[]{0x10, 0x20, 0x3F}}, s1.getByteArrays());
    assertEquals("0x10 0x20 0x30, 0x10 0x20 0x3F", s1.getValue());

    s1.setByteArrays(new byte[]{0x10, 0x20, 0x30},
        new byte[]{0x10, 0x20, 0x3F},
        new byte[]{0x3F});
    assertEquals(Type.BYTE_ARRAY, s1.getType());
    assertArrayEquals(new byte[]{0x10, 0x20, 0x30}, s1.getByteArray());
    assertEquals(3, s1.getCount());
    assertArrayEquals(new byte[][]{new byte[]{0x10, 0x20, 0x30},
        new byte[]{0x10, 0x20, 0x3F},
        new byte[]{0x3F}},
        s1.getByteArrays());
    assertEquals("0x10 0x20 0x30, 0x10 0x20 0x3F, 0x3F", s1.getValue());

    s1.setByteArrays(new byte[]{0x10, 0x20, 0x30},
        new byte[]{0x10, 0x20, 0x3F},
        null,
        new byte[]{0x3F});
    assertEquals(Type.BYTE_ARRAY, s1.getType());
    assertArrayEquals(new byte[]{0x10, 0x20, 0x30}, s1.getByteArray());
    assertEquals(4, s1.getCount());
    assertArrayEquals(new byte[][]{new byte[]{0x10, 0x20, 0x30},
        new byte[]{0x10, 0x20, 0x3F},
        null,
        new byte[]{0x3F}},
        s1.getByteArrays());
    assertEquals("0x10 0x20 0x30, 0x10 0x20 0x3F, [null], 0x3F", s1.getValue());
  }

  /**
   * TestFragment method for {@link Setting#getEnum(Class)} and {@link
   * Setting#setEnum(Enum)}.
   */
  @Test
  public void testGetSetEnum() {
    final Setting s1 = new Setting("s1");

    s1.setEnum(State.NORMAL);
    assertEquals(Type.STRING, s1.getType());
    assertEquals(State.NORMAL, s1.getEnum(State.class));
    assertEquals(1, s1.getCount());
    assertEquals(Arrays.asList(State.NORMAL), s1.getEnums(State.class));

    s1.setEnum(State.LOCKED);
    assertEquals(Type.STRING, s1.getType());
    assertEquals(State.LOCKED, s1.getEnum(State.class));
    assertEquals(1, s1.getCount());
    assertEquals(Arrays.asList(State.LOCKED),
        s1.getEnums(State.class));

    s1.setString("xxx");
    try {
      s1.getEnum(State.class);
      fail("should throw");
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

//    try {
//      s1.setEnum(null);
//      fail("should throw");
//    } catch (final NullPointerException e) {
//      //  pass
//    }
  }

  /**
   * TestFragment method for {@link Setting#getEnums(Class)} and {@link
   * Setting#setEnums(Enum[])}.
   */
  @Test
  public void testGetSetEnums() {
    final Setting s1 = new Setting("s1");

    s1.setEnums(State.NORMAL, State.BLOCKED);
    assertEquals(Type.STRING, s1.getType());
    assertEquals(State.NORMAL, s1.getEnum(State.class));
    assertEquals(2, s1.getCount());
    assertEquals(Arrays.asList(State.NORMAL, State.BLOCKED),
        s1.getEnums(State.class));

    s1.setEnums(State.NORMAL, State.BLOCKED, State.LOCKED);
    assertEquals(Type.STRING, s1.getType());
    assertEquals(State.NORMAL, s1.getEnum(State.class));
    assertEquals(3, s1.getCount());
    assertEquals(Arrays.asList(State.NORMAL, State.BLOCKED,
        State.LOCKED), s1.getEnums(State.class));

    s1.setEnums(State.NORMAL, State.LOCKED, State.BLOCKED,
        State.LOCKED);
    assertEquals(Type.STRING, s1.getType());
    assertEquals(State.NORMAL, s1.getEnum(State.class));
    assertEquals(4, s1.getCount());
    assertEquals(Arrays.asList(State.NORMAL, State.LOCKED, State.BLOCKED,
        State.LOCKED), s1.getEnums(State.class));

    s1.setType(Type.STRING);
    s1.setValue("NORMAL\nxxx");
    try {
      s1.getEnums(State.class);
      fail("should throw");
    } catch (final InvalidSettingValueException e) {
      assertEquals("s1", e.getName());
      assertEquals("xxx", e.getValue());
    }

//    try {
//      s1.setEnums(State.NORMAL, null, State.BLOCKED);
//      fail("should throw");
//    } catch (final NullPointerException e) {
//      //  pass
//    }
  }

  /**
   * TestFragment method for {@link Setting#getCreateTime()} and {@link
   * Setting#setCreateTime(Instant)}.
   */
  @Test
  public void testGetSetCreateTime() {

    final Setting s = new Setting();
    assertNull(s.getCreateTime());
    final Instant now = Instant.now();
    s.setCreateTime(now);
    assertEquals(now, s.getCreateTime());
    //    assertNotSame(now, s.getCreateTime());
    s.setCreateTime(null);
    assertNull(s.getCreateTime());
  }

  /**
   * TestFragment method for {@link Setting#getModifyTime()} and {@link
   * Setting#setModifyTime(Instant)}.
   */
  @Test
  public void testGetSetModifyTime() {
    final Setting s = new Setting();
    assertNull(s.getModifyTime());
    final Instant now = Instant.now();
    s.setModifyTime(now);
    assertEquals(now, s.getModifyTime());
    //    assertNotSame(now, s.getModifyTime());
    s.setModifyTime(null);
    assertNull(s.getModifyTime());
  }

  /**
   * TestFragment method for {@link Setting#hashCode()}.
   */
  @Test
  public void testHashCode() {
    final Setting s1 = new Setting();
    s1.setName("s1");
    s1.setReadonly(true);
    s1.setMultiple(false);
    s1.setNullable(true);
    s1.setEncrypted(false);
    s1.setType(Type.STRING);
    s1.setValue("s1");

    final Setting s2 = new Setting();
    s2.setName("s1");
    s2.setReadonly(true);
    s2.setMultiple(false);
    s2.setNullable(true);
    s2.setEncrypted(false);
    s2.setType(Type.STRING);
    s2.setValue("s1");

    final Setting s3 = new Setting();
    s3.setName("s1");
    s3.setReadonly(true);
    s3.setMultiple(false);
    s3.setNullable(true);
    s3.setEncrypted(true);
    s3.setType(Type.STRING);
    s3.setValue("s1");

    assertEquals(s1.hashCode(), s2.hashCode());
    assertTrue(s1.hashCode() != s3.hashCode());
  }

  /**
   * TestFragment method for {@link Setting#equals(Object)}.
   */
  @Test
  public void testEqualsObject() {
    final Setting s1 = new Setting();
    s1.setName("s1");
    s1.setReadonly(true);
    s1.setMultiple(false);
    s1.setNullable(true);
    s1.setEncrypted(false);
    s1.setType(Type.STRING);
    s1.setValue("s1");

    final Setting s2 = new Setting();
    s2.setName("s1");
    s2.setReadonly(true);
    s2.setMultiple(false);
    s2.setNullable(true);
    s2.setEncrypted(false);
    s2.setType(Type.STRING);
    s2.setValue("s1");

    final Setting s3 = new Setting();
    s3.setName("s1");
    s3.setReadonly(true);
    s3.setMultiple(false);
    s3.setNullable(true);
    s3.setEncrypted(true);
    s3.setType(Type.STRING);
    s3.setValue("s1");

    assertTrue(s1.equals(s2));
    assertFalse(s1.equals(s3));
    assertFalse(s1.equals(null));
  }

  /**
   * TestFragment method for {@link Setting#toString()}.
   */
  @Test
  public void testToString() {
    final Setting s1 = new Setting();
    s1.setName("s1");
    s1.setReadonly(true);
    s1.setMultiple(false);
    s1.setNullable(true);
    s1.setEncrypted(false);
    s1.setType(Type.STRING);
    s1.setValue("s1");

    final Setting s2 = new Setting();
    s2.setName("s1");
    s2.setReadonly(true);
    s2.setMultiple(false);
    s2.setNullable(true);
    s2.setEncrypted(false);
    s2.setType(Type.STRING);
    s2.setValue("s1");

    System.out.println(s1);
  }

  @Test
  public void testIsValid() {
    final Setting s1 = new Setting();
    s1.setName("s1");
    s1.setType(Type.STRING);
    s1.setMultiple(false);
    s1.setNullable(false);
    s1.setValue("value1");

    assertTrue(s1.isValid());

    s1.setValue(null);
    assertFalse(s1.isValid());
    s1.setNullable(true);
    assertTrue(s1.isValid());

    s1.setValue("x\ny");
    assertFalse(s1.isValid());
    s1.setMultiple(true);
    assertTrue(s1.isValid());

    s1.setType(Type.INT);
    s1.setValue(null);
    assertTrue(s1.isValid());

    s1.setValue("xxx");
    assertFalse(s1.isValid());
  }

  @Test
  public void testXmlSerialization_special() throws Exception {
    final Setting s1 = new Setting();
    s1.setName("s1");
    s1.setReadonly(true);
    s1.setMultiple(false);
    s1.setNullable(true);
    s1.setEncrypted(false);
    s1.setType(Type.STRING);
    s1.setValue("value1");

    final String xml1 = "<setting name='s1'>"
                            + "<type>STRING</type>"
                            + "<readonly>true</readonly>"
                            + "<multiple>false</multiple>"
                            + "<nullable>true</nullable>"
                            + "<encrypted>false</encrypted>"
                            + "<value>value1</value>"
                            + "</setting>";

    assertXmlSerializeEquals(xmlMapper, Setting.class, s1, xml1);
    assertXmlDeserializeEquals(xmlMapper, Setting.class, xml1, s1);

    final Setting s2 = new Setting();
    s2.setName("s2");
    s2.setReadonly(true);
    s2.setMultiple(true);
    s2.setNullable(true);
    s2.setEncrypted(false);
    s2.setType(Type.INT);
    s2.setInts(1, 2, 3, 4);

    final String xml2 = "<setting name='s2'>"
                            + "<type>INT</type>"
                            + "<readonly>true</readonly>"
                            + "<multiple>true</multiple>"
                            + "<nullable>true</nullable>"
                            + "<encrypted>false</encrypted>"
                            + "<value>1, 2, 3, 4</value>"
                            + "</setting>";

    assertXmlSerializeEquals(xmlMapper, Setting.class, s2, xml2);
    assertXmlDeserializeEquals(xmlMapper, Setting.class, xml2, s2);
  }

  @Test
  public void testSetValue() {
    final Setting setting = new Setting();
    setting.setName("test.value");
    setting.setValue("SPRING_FESTIVAL\nNATIONAL_DAY");
    assertEquals("SPRING_FESTIVAL\nNATIONAL_DAY", setting.getValue());
  }

  @Test
  public void testCompareTo() {
    final String n1 = "setting-tt-UV";
    final String n2 = "setting-tt-jcEIuCGs";
    assertThat(n1.compareToIgnoreCase(n2)).isGreaterThan(0);

    final Setting s1 = new Setting("setting-tt-UV")
                           .setInts(-571544247, 1953478606, 1416058656,
                               -1111904366, -766799623);
    final Setting s2 = new Setting("setting-tt-jcEIuCGs")
                           .setString("YramnRshwUcplHPVSBgCUsEes");
    assertThat(s1.compareTo(s2)).isGreaterThan(0);
  }
  // resume checkstyle: MagicNumberCheck
}
