////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.device;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link Device} class.
 *
 * @author Haixing Hu
 */
public class DeviceTest extends ModelTestBase<Device> {

  public DeviceTest() {
    super(Device.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("id", getFieldName(Device.class, Device::getId));
    assertEquals("id", getFieldName(Device.class, Device::setId));
    assertEquals("code", getFieldName(Device.class, Device::getCode));
    assertEquals("code", getFieldName(Device.class, Device::setCode));
    assertEquals("name", getFieldName(Device.class, Device::getName));
    assertEquals("name", getFieldName(Device.class, Device::setName));
    assertEquals("app", getFieldName(Device.class, Device::getApp));
    assertEquals("app", getFieldName(Device.class, Device::setApp));
    assertEquals("description", getFieldName(Device.class, Device::getDescription));
    assertEquals("description", getFieldName(Device.class, Device::setDescription));
    assertEquals("hardware", getFieldName(Device.class, Device::getHardware));
    assertEquals("hardware", getFieldName(Device.class, Device::setHardware));
    assertEquals("operatingSystem", getFieldName(Device.class, Device::getOperatingSystem));
    assertEquals("operatingSystem", getFieldName(Device.class, Device::setOperatingSystem));
    assertEquals("softwares", getFieldName(Device.class, Device::getSoftwares));
    assertEquals("softwares", getFieldName(Device.class, Device::setSoftwares));
    assertEquals("location", getFieldName(Device.class, Device::getLocation));
    assertEquals("location", getFieldName(Device.class, Device::setLocation));
    assertEquals("ipAddress", getFieldName(Device.class, Device::getIpAddress));
    assertEquals("ipAddress", getFieldName(Device.class, Device::setIpAddress));
    assertEquals("udid", getFieldName(Device.class, Device::getUdid));
    assertEquals("udid", getFieldName(Device.class, Device::setUdid));
    assertEquals("owner", getFieldName(Device.class, Device::getOwner));
    assertEquals("owner", getFieldName(Device.class, Device::setOwner));
    assertEquals("deployAddress", getFieldName(Device.class, Device::getDeployAddress));
    assertEquals("deployAddress", getFieldName(Device.class, Device::setDeployAddress));
    assertEquals("state", getFieldName(Device.class, Device::getState));
    assertEquals("state", getFieldName(Device.class, Device::setState));
    assertEquals("comment", getFieldName(Device.class, Device::getComment));
    assertEquals("comment", getFieldName(Device.class, Device::setComment));
    assertEquals("registerTime", getFieldName(Device.class, Device::getRegisterTime));
    assertEquals("registerTime", getFieldName(Device.class, Device::setRegisterTime));
    assertEquals("lastStartupTime", getFieldName(Device.class, Device::getLastStartupTime));
    assertEquals("lastStartupTime", getFieldName(Device.class, Device::setLastStartupTime));
    assertEquals("lastHeartbeatTime", getFieldName(Device.class, Device::getLastHeartbeatTime));
    assertEquals("lastHeartbeatTime", getFieldName(Device.class, Device::setLastHeartbeatTime));
    assertEquals("createTime", getFieldName(Device.class, Device::getCreateTime));
    assertEquals("createTime", getFieldName(Device.class, Device::setCreateTime));
    assertEquals("modifyTime", getFieldName(Device.class, Device::getModifyTime));
    assertEquals("modifyTime", getFieldName(Device.class, Device::setModifyTime));
    assertEquals("deleteTime", getFieldName(Device.class, Device::getDeleteTime));
    assertEquals("deleteTime", getFieldName(Device.class, Device::setDeleteTime));
  }
}
