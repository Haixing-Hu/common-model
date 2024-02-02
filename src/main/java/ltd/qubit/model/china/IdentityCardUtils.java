////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.china;

import java.io.IOException;
import java.net.URL;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import ltd.qubit.commons.error.InitializationError;
import ltd.qubit.commons.lang.IntUtils;
import ltd.qubit.commons.lang.SystemUtils;
import ltd.qubit.commons.util.properties.PropertiesUtils;
import ltd.qubit.model.contact.District;
import ltd.qubit.model.person.Gender;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 处理中华人民共和国公民第二代身份证信息（18位）的函数。
 *
 * @author 胡海星
 */
public class IdentityCardUtils {

  public static final int NUMBER_LENGTH = 18;

  public static final int AREA_INDEX = 0;

  public static final int AREA_LENGTH = 6;

  public static final int YEAR_INDEX = 6;

  public static final int YEAR_LENGTH = 4;

  public static final int MONTH_INDEX = 10;

  public static final int MONTH_LENGTH = 2;

  public static final int DAY_INDEX = 12;

  public static final int DAY_LENGTH = 2;

  public static final int SEQUENCE_INDEX = 14;

  public static final int SEQUENCE_LENGTH = 3;

  public static final int VERIFY_INDEX = 17;

  private static final int DECIMAL_BASE = 10;

  private static final int[] RATIO = {
      7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2
  };

  private static final char[] LAST_CHAR = {
      '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'
  };

  private static Integer parseNumber(final String number, final int start, final int end) {
    if (number == null
        || start < 0
        || end <= start
        || end > number.length()) {
      return null;
    }
    int result = 0;
    for (int i = start; i < end; ++i) {
      final char ch = number.charAt(i);
      if (ch < '0' || ch > '9') {
        return null;
      }
      result *= DECIMAL_BASE;
      result += (ch - '0');
    }
    return result;
  }

  /**
   * 验证身份证号码是否合法。
   *
   * <p>身份证中第十八位数字的计算方法如下：
   *
   * <ul>
   * <li>将前面的身份证号码17位数分别乘以不同的系数，
   * 从第一位到第十七位的系数分别为：7、9、10、5、8、4、2、1、6、3、7、9、
   * 10、5、8、4、2；</li>
   * <li>将这17位数字和系数相乘的结果相加；</li>
   * <li>用加出来和除以11，看余数是多少；</li>
   * <li>余数只可能有0 、1、 2、 3、 4、 5、 6、 7、 8、 9、 10这11个数字。</li>
   * <li>其分别对应的最后一位身份证的号码为1、0、X、9、8、7、6、5、4、3、2；</li>
   * </ul>
   *
   * <p>通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。
   * 如果余数是10，身份证的最后一位号码就是2。
   *
   * <p><b>注意：</b>对于身份证号码中编码的出生日期，此函数只验证该日期是否存在，
   * 没有验证出生日期的范围是否合法。
   *
   * @param number
   *     待验证的身份证号码。
   * @return 若该身份证号码合法则返回{@code true}，否则返回{@code false}。
   */
  public static boolean validate(final String number) {
    // 验证长度是否合法
    if (number == null || number.length() != NUMBER_LENGTH) {
      return false;
    }
    final Character expected = getLastChar(number);
    if (expected == null) {
      return false;
    }
    final char actual = Character.toUpperCase(number.charAt(NUMBER_LENGTH - 1));
    if (actual != expected) {
      return false;
    }
    // 验证出生日期是否合法
    if (getBirthday(number) == null) {
      return false;
    }
    // 验证地址区县是否合法
    // FIXME
    //    if (! isAreaValid(number)) {
    //      return false;
    //    }
    return true;
  }

  /**
   * 获取身份证号码中的最后一个字符。
   *
   * <p>身份证中第十八位数字的计算方法如下：
   *
   * <ul>
   * <li>将前面的身份证号码17位数分别乘以不同的系数，
   * 从第一位到第十七位的系数分别为：7、9、10、5、8、4、2、1、6、3、7、9、
   * 10、5、8、4、2；</li>
   * <li>将这17位数字和系数相乘的结果相加；</li>
   * <li>用加出来和除以11，看余数是多少；</li>
   * <li>余数只可能有0 、1、 2、 3、 4、 5、 6、 7、 8、 9、 10这11个数字。</li>
   * <li>其分别对应的最后一位身份证的号码为1、0、X、9、8、7、6、5、4、3、2；</li>
   * </ul>
   *
   * <p>通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。
   * 如果余数是10，身份证的最后一位号码就是2。
   *
   * @param number
   *     身份证号码。
   * @return 若该身份证号码前17个字符合法则返回第18个字符，否则返回{@code null}。
   */
  public static Character getLastChar(final String number) {
    final int length = NUMBER_LENGTH - 1;
    if (number == null || number.length() < length) {
      return null;
    }
    int sum = 0;
    for (int i = 0; i < length; ++i) {
      final char ch = number.charAt(i);
      if (ch < '0' || ch > '9') {
        return null;
      }
      sum += (ch - '0') * RATIO[i];
    }
    return LAST_CHAR[sum % LAST_CHAR.length];
  }

  /**
   * 获取身份证号码中的出生日期。
   *
   * <p>身份证号码第7~12为日期码，表示该居民的出生年月日。格式为YYYYMMDD，
   * 如19491001。出生日期码是按GB/T 7408的规定执行的。
   *
   * @param number
   *     身份证号码。
   * @return 若该身份证号码中的出生日期编码合法则返回出生日期，否则返回{@code null}。
   */
  public static LocalDate getBirthday(final String number) {
    if (number == null || number.length() != NUMBER_LENGTH) {
      return null;
    }
    final Integer year = parseNumber(number, YEAR_INDEX, YEAR_INDEX + YEAR_LENGTH);
    final Integer month = parseNumber(number, MONTH_INDEX, MONTH_INDEX + MONTH_LENGTH);
    final Integer day = parseNumber(number, DAY_INDEX, DAY_INDEX + DAY_LENGTH);
    if (year == null || month == null || day == null) {
      return null;
    }
    try {
      return LocalDate.of(year, month, day);
    } catch (final DateTimeException e) {
      return null;
    }
  }

  /**
   * 获取身份证号码中的性别。
   *
   * <p>身份证号码第15~17为顺序码，表示同一地址码区域内，同年、同月、同日生的人所
   * 编订的顺序号，根据自己身份证的顺序码就可以知道：与我们同年同月同日生的同性至
   * 少有多少个，且在我们之前登记户籍的有多少人。身份证顺序码的奇数分配给男性，偶
   * 数分配给女性。因此身份证号码倒数第2位是奇数则为男性，偶数则为女性。
   *
   * @param number
   *     身份证号码。
   * @return 若该身份证号码中的性别编码合法则返回性别，否则返回{@code null}。
   */
  public static Gender getGender(final String number) {
    if (number == null || number.length() != NUMBER_LENGTH) {
      return null;
    }
    final char ch = number.charAt(NUMBER_LENGTH - 2);
    if (ch < '0' || ch > '9') {
      return null;
    }
    final int num = ch - '0';
    return (num % 2 == 0 ? Gender.FEMALE : Gender.MALE);
  }

  /**
   * 获取身份证号码中的区县。
   *
   * <p>身份证号码第1~6位为地址码，表示登记户口时所在地的行政区划代码（省、市、县）。
   * 其中1-2位省、自治区、直辖市代码；3-4位地级市、盟、自治州代码；5-6位县、县级 市、
   * 区代码。如果行政区划进行了重新划分，同一个地方进行户口登记的可能存在地址码不一致
   * 的情况。行政区划代码按GB/T2260的规定执行。
   *
   * @param number
   *     身份证号码。
   * @return 若该身份证号码中的区县编码合法则返回区县，否则返回{@code null}。
   */
  public static District getDistrict(final String number) {
    // FIXME
    return new District();
  }

  public static boolean isAreaValid(final String number) {
    if (number == null || number.length() != NUMBER_LENGTH) {
      return false;
    }
    final String area = number.substring(AREA_INDEX, AREA_LENGTH);
    return (AREA_MAP.get(area) != null);
  }

  public static Map<String, String> getAreaMap() {
    return AREA_MAP;
  }

  private static final String AREA_MAP_RESOURCE = "/china/china-area.properties";

  private static final Map<String, String> AREA_MAP;

  static {
    try {
      final URL url = SystemUtils.getResource(AREA_MAP_RESOURCE, IdentityCardUtils.class);
      if (url == null) {
        throw new InitializationError("Resource not found: " + AREA_MAP_RESOURCE);
      }
      final Properties properties = PropertiesUtils.load(url, UTF_8);
      final Map<String, String> map = PropertiesUtils.toMap(properties);
      AREA_MAP = Collections.unmodifiableMap(map);
    } catch (final IOException e) {
      throw new InitializationError(e);
    }
  }

  public static String changeBirthday(final String number, final LocalDate birthday) {
    if (number == null || number.length() != NUMBER_LENGTH) {
      return null;
    }
    final StringBuilder builder = new StringBuilder();
    builder.append(number, AREA_INDEX, AREA_INDEX + AREA_LENGTH)
           .append(getBirthdayCode(birthday))
           .append(number, SEQUENCE_INDEX, SEQUENCE_INDEX + SEQUENCE_LENGTH);
    final Character lastChar = getLastChar(builder.toString());
    builder.append(lastChar);
    return builder.toString();
  }

  private static String getBirthdayCode(final LocalDate birthday) {
    final String year = IntUtils.toFixSizeString(birthday.getYear(), 4);
    final String month = IntUtils.toFixSizeString(birthday.getMonthValue(), 2);
    final String day = IntUtils.toFixSizeString(birthday.getDayOfMonth(), 2);
    return year + month + day;
  }
}
