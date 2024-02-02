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

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;
import static ltd.qubit.commons.test.json.JsonUnitUtils.assertJsonArrayEquals;
import static ltd.qubit.commons.test.json.JsonUnitUtils.assertJsonNodeAbsent;
import static ltd.qubit.commons.test.json.JsonUnitUtils.assertJsonNodeEquals;
import static ltd.qubit.commons.test.xml.XmlUnitUtils.assertXPathEquals;

/**
 * Unit test of the {@link DictEntryInfo} class.
 *
 * @author Haixing Hu
 */
public class DictEntryInfoTest extends ModelTestBase<DictEntryInfo> {

  public DictEntryInfoTest() {
    super(DictEntryInfo.class);
  }

  // stop checkstyle: MagicNumberCheck
  @Test
  public void testGetDisplayCodeGetDisplayName() throws Exception {
    final DictEntryInfo info = new DictEntryInfo();

    info.setId(123L);
    info.setCode("QD");
    info.setName("每天使用一次");
    info.setParams(null);
    assertEquals("QD", info.getDisplayCode());
    assertEquals("每天使用一次", info.getDisplayName());

    info.setId(123L);
    info.setCode("QD");
    info.setName("每天使用一次");
    info.setParams(new String[]{"xx"});
    assertEquals("QD", info.getDisplayCode());
    assertEquals("每天使用一次", info.getDisplayName());

    info.setId(123L);
    info.setCode("Q{0}H");
    info.setName("每{0}小时使用一次");
    info.setParams(new String[]{"3"});
    assertEquals("Q3H", info.getDisplayCode());
    assertEquals("每3小时使用一次", info.getDisplayName());

    info.setId(123L);
    info.setCode("Q{0}H");
    info .setName("每{0}小时使用一次");
    info .setParams(new String[]{"3", "4"});
    assertEquals("Q3H", info.getDisplayCode());
    assertEquals("每3小时使用一次", info.getDisplayName());

    info.setId(123L);
    info.setCode("MCD{0}D{1}");
    info.setName("月经第{0}天至第{1}天使用");
    info.setParams(new String[]{"3", "5"});
    assertEquals("MCD3D5", info.getDisplayCode());
    assertEquals("月经第3天至第5天使用", info.getDisplayName());

    info.setId(123L);
    info.setCode("MCD{0}D{1}");
    info.setName("月经第{0}天至第{1}天使用");
    info.setParams(new String[]{"3", "5", "7"});
    assertEquals("MCD3D5", info.getDisplayCode());
    assertEquals("月经第3天至第5天使用", info.getDisplayName());

    info.setId(123L);
    info.setCode("OTH");
    info.setName("{0}");
    info.setParams(new String[]{"其他特定的使用方法"});
    assertEquals("OTH", info.getDisplayCode());
    assertEquals("其他特定的使用方法", info.getDisplayName());

    info.setId(123L);
    info.setCode("QW({0},{1},{2})");
    info.setName("每周{0},{1},{2}使用");
    info.setParams(new String[]{"2", "4", "6"});
    assertEquals("QW(2,4,6)", info.getDisplayCode());
    assertEquals("每周2,4,6使用", info.getDisplayName());

  }

  @Test
  public void testJsonSerializeDeserializeExtra() throws Exception {
    final DictEntryInfo obj = new DictEntryInfo();
    obj.setId(123L);
    obj.setCode("QD");
    obj.setName("每天使用一次");
    obj.setParams(null);
    String json = jsonMapper.writerWithDefaultPrettyPrinter()
        .writeValueAsString(obj);
    System.out.println(json);
    assertJsonNodeEquals(json, "id", 123L);
    assertJsonNodeEquals(json, "code", "QD");
    assertJsonNodeEquals(json, "name", "每天使用一次");
    assertJsonNodeEquals(json, "display_code", "QD");
    assertJsonNodeEquals(json, "display_name", "每天使用一次");
    assertJsonNodeAbsent(json, "params");

    obj.setId(4578237832L);
    obj.setCode("Q{0}H");
    obj.setName("每{0}小时使用一次");
    obj.setParams(new String[]{"3"});
    json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    System.out.println(json);
    assertJsonNodeEquals(json, "id", 4578237832L);
    assertJsonNodeEquals(json, "code", "Q{0}H");
    assertJsonNodeEquals(json, "name", "每{0}小时使用一次");
    assertJsonNodeEquals(json, "display_code", "Q3H");
    assertJsonNodeEquals(json, "display_name", "每3小时使用一次");
    assertJsonArrayEquals(json, "params", new String[]{"3"}, jsonMapper);

    obj.setId(2342343243L);
    obj.setCode("MCD{0}D{1}");
    obj.setName("月经第{0}天至第{1}天使用");
    obj.setParams(new String[]{"3", "5"});
    json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    System.out.println(json);
    assertJsonNodeEquals(json, "id", 2342343243L);
    assertJsonNodeEquals(json, "code", "MCD{0}D{1}");
    assertJsonNodeEquals(json, "name", "月经第{0}天至第{1}天使用");
    assertJsonNodeEquals(json, "display_code", "MCD3D5");
    assertJsonNodeEquals(json, "display_name", "月经第3天至第5天使用");
    assertJsonArrayEquals(json, "params", new String[]{"3", "5"}, jsonMapper);

    obj.setId(123123423332L);
    obj.setCode("OTH");
    obj.setName("{0}");
    obj.setParams(new String[]{"特定的XX方法"});
    json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    System.out.println(json);
    assertJsonNodeEquals(json, "id", 123123423332L);
    assertJsonNodeEquals(json, "code", "OTH");
    assertJsonNodeEquals(json, "name", "{0}");
    assertJsonNodeEquals(json, "display_code", "OTH");
    assertJsonNodeEquals(json, "display_name", "特定的XX方法");
    assertJsonArrayEquals(json, "params", new String[]{"特定的XX方法"}, jsonMapper);

    obj.setId(21321434246879L);
    obj.setCode("QW({0},{1},{2})");
    obj.setName("每周{0},{1},{2}使用");
    obj.setParams(new String[]{"2", "4", "6"});
    json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    System.out.println(json);
    assertJsonNodeEquals(json, "id", 21321434246879L);
    assertJsonNodeEquals(json, "code", "QW({0},{1},{2})");
    assertJsonNodeEquals(json, "name", "每周{0},{1},{2}使用");
    assertJsonNodeEquals(json, "display_code", "QW(2,4,6)");
    assertJsonNodeEquals(json, "display_name", "每周2,4,6使用");
    assertJsonArrayEquals(json, "params", new String[]{"2", "4", "6"}, jsonMapper);
  }

  @Test
  public void testXmlSerializeDeserializeExtra() throws Exception {
    final DictEntryInfo obj = new DictEntryInfo();
    obj.setId(123L);
    obj.setCode("QD");
    obj.setName("每天使用一次");
    obj.setParams(null);
    String xml = xmlMapper.writeValueAsString(obj);
    System.out.println(xml);
    assertXPathEquals(xml, "dict-entry-info/id", 123L);
    assertXPathEquals(xml, "dict-entry-info/code", "QD");
    assertXPathEquals(xml, "dict-entry-info/name", "每天使用一次");
    assertXPathEquals(xml, "dict-entry-info/display-code", "QD");
    assertXPathEquals(xml, "dict-entry-info/display-name", "每天使用一次");
    // assertXPathAbsent(xml, "dict-entry-info/params");

    obj.setId(4578237832L);
    obj.setCode("Q{0}H");
    obj.setName("每{0}小时使用一次");
    obj.setParams(new String[]{"3"});
    xml = xmlMapper.writeValueAsString(obj);
    System.out.println(xml);
    assertXPathEquals(xml, "dict-entry-info/id", 4578237832L);
    assertXPathEquals(xml, "dict-entry-info/code", "Q{0}H");
    assertXPathEquals(xml, "dict-entry-info/name", "每{0}小时使用一次");
    assertXPathEquals(xml, "dict-entry-info/display-code", "Q3H");
    assertXPathEquals(xml, "dict-entry-info/display-name", "每3小时使用一次");
    // assertXPathArrayEquals(xml, "dict-entry", "params", "param", new String[]{"3"});

    obj.setId(2342343243L);
    obj.setCode("MCD{0}D{1}");
    obj.setName("月经第{0}天至第{1}天使用");
    obj.setParams(new String[]{"3", "5"});
    xml = xmlMapper.writeValueAsString(obj);
    System.out.println(xml);
    assertXPathEquals(xml, "dict-entry-info/id", 2342343243L);
    assertXPathEquals(xml, "dict-entry-info/code", "MCD{0}D{1}");
    assertXPathEquals(xml, "dict-entry-info/name", "月经第{0}天至第{1}天使用");
    assertXPathEquals(xml, "dict-entry-info/display-code", "MCD3D5");
    assertXPathEquals(xml, "dict-entry-info/display-name", "月经第3天至第5天使用");
    // assertXPathArrayEquals(xml, "dict-entry", "params", "param", new String[]{"3", "5"});

    obj.setId(123123423332L);
    obj.setCode("OTH");
    obj.setName("{0}");
    obj.setParams(new String[]{"特定的XX方法"});
    xml = xmlMapper.writeValueAsString(obj);
    System.out.println(xml);
    assertXPathEquals(xml, "dict-entry-info/id", 123123423332L);
    assertXPathEquals(xml, "dict-entry-info/code", "OTH");
    assertXPathEquals(xml, "dict-entry-info/name", "{0}");
    assertXPathEquals(xml, "dict-entry-info/display-code", "OTH");
    assertXPathEquals(xml, "dict-entry-info/display-name", "特定的XX方法");
    // assertXPathArrayEquals(xml, "dict-entry", "params", "param", new String[]{"特定的XX方法"});

    obj.setId(21321434246879L);
    obj.setCode("QW({0},{1},{2})");
    obj.setName("每周{0},{1},{2}使用");
    obj.setParams(new String[]{"2", "4", "6"});
    xml = xmlMapper.writeValueAsString(obj);
    System.out.println(xml);
    assertXPathEquals(xml, "dict-entry-info/id", 21321434246879L);
    assertXPathEquals(xml, "dict-entry-info/code", "QW({0},{1},{2})");
    assertXPathEquals(xml, "dict-entry-info/name", "每周{0},{1},{2}使用");
    assertXPathEquals(xml, "dict-entry-info/display-code", "QW(2,4,6)");
    assertXPathEquals(xml, "dict-entry-info/display-name", "每周2,4,6使用");
    // assertXPathArrayEquals(xml, "dict-entry", "params", "param", new String[]{"2", "4", "6"});
  }
  // resume checkstyle: MagicNumberCheck

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(DictEntryInfo.class, DictEntryInfo::getId));
    assertEquals("id", getFieldName(DictEntryInfo.class, DictEntryInfo::setId));
    assertEquals("code", getFieldName(DictEntryInfo.class, DictEntryInfo::getCode));
    assertEquals("code", getFieldName(DictEntryInfo.class, DictEntryInfo::setCode));
    assertEquals("name", getFieldName(DictEntryInfo.class, DictEntryInfo::getName));
    assertEquals("name", getFieldName(DictEntryInfo.class, DictEntryInfo::setName));
    assertEquals("dictId", getFieldName(DictEntryInfo.class, DictEntryInfo::getDictId));
    assertEquals("dictId", getFieldName(DictEntryInfo.class, DictEntryInfo::setDictId));
    assertEquals("params", getFieldName(DictEntryInfo.class, DictEntryInfo::getParams));
    assertEquals("params", getFieldName(DictEntryInfo.class, DictEntryInfo::setParams));
    assertEquals("deleteTime", getFieldName(DictEntryInfo.class, DictEntryInfo::getDeleteTime));
    assertEquals("deleteTime", getFieldName(DictEntryInfo.class, DictEntryInfo::setDeleteTime));
  }
}
