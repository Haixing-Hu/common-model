////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.device;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Indexed;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.commons.State;
import ltd.qubit.model.contact.Address;
import ltd.qubit.model.contact.Location;
import ltd.qubit.model.person.Person;
import ltd.qubit.model.person.PersonInfo;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Emptyful;
import ltd.qubit.model.util.HasStatefulInfo;
import ltd.qubit.model.util.Normalizable;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;
import ltd.qubit.model.util.WithComment;
import ltd.qubit.model.util.WithLocation;

/**
 * 此模型表示智能盒子设备。
 *
 * @author 胡海星
 */
public class Device implements HasStatefulInfo, WithApp, WithComment,
    WithLocation, Auditable, Emptyful, Normalizable, Assignable<Device> {

  private static final long serialVersionUID = 8554519533779934750L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 编码，全局不可重复，一旦设置不能更改。
   */
  @Unique
  @Size(min = 1, max = 64)
  private String code;

  /**
   * 名称。
   */
  @Size(min = 1, max = 128)
  @Indexed
  private String name;

  /**
   * 所属 App 的基本信息。
   */
  @Reference(entity = App.class, property = "info")
  private StatefulInfo app;

  /**
   * 详细描述。
   */
  @Nullable
  private String description;

  /**
   * 硬件信息。
   */
  private Hardware hardware;

  /**
   * 该设备运行的操作系统的信息。
   */
  private Software operatingSystem;

  /**
   * 该设备运行的客户端应用的信息。
   */
  @Nullable
  private List<Software> softwares;

  /**
   * 设备当前所处的位置。
   *
   * <p>注意可能和设备部署地址的地理位置不同。</p>
   */
  @Nullable
  private Location location;

  /**
   * 设备当前公网IP地址。
   */
  @Size(min = 1, max = 128)
  @Indexed
  @Nullable
  private String ipAddress;

  /**
   * 硬件设备唯一ID。
   */
  @Size(min = 1, max = 128)
  @Unique
  @Nullable
  private String udid;

  /**
   * 设备所有者信息。
   */
  @Reference(entity = Person.class, property = "info")
  @Nullable
  private PersonInfo owner;

  /**
   * 设备部署地址。
   *
   * <p>注意设备部署地址的地理位置可能和设备当前所处地理位置不同。</p>
   */
  @Reference
  @Nullable
  private Address deployAddress;

  /**
   * 对象状态。
   */
  @Indexed
  private State state;

  /**
   * 备注。
   *
   * <p>备注(comment)是由系统管理员填写，描述(description)可以由用户自己填写。</p>
   */
  @Nullable
  private String comment;

  /**
   * 注册(激活)时间。
   */
  @Precision(value = TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant registerTime;

  /**
   * 上次启动时间。
   */
  @Precision(value = TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant lastStartupTime;

  /**
   * 上次心跳连接时间。
   */
  @Precision(value = TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant lastHeartbeatTime;

  /**
   * 创建时间。
   */
  @Precision(value = TimeUnit.SECONDS)
  @Indexed
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(value = TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant modifyTime;

  /**
   * 标记删除时间。
   */
  @Precision(value = TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant deleteTime;

  public Device() {
    // empty
  }

  public Device(final Device other) {
    assign(other);
  }

  @Override
  public void assign(final Device other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    name = other.name;
    app = Assignment.clone(other.app);
    description = other.description;
    hardware = Assignment.clone(other.hardware);
    operatingSystem = Assignment.clone(other.operatingSystem);
    softwares = Assignment.deepClone(other.softwares);
    location = Assignment.clone(other.location);
    ipAddress = other.ipAddress;
    udid = other.udid;
    owner = Assignment.clone(other.owner);
    deployAddress = Assignment.clone(other.deployAddress);
    state = other.state;
    comment = other.comment;
    registerTime = other.registerTime;
    lastStartupTime = other.lastStartupTime;
    lastHeartbeatTime = other.lastHeartbeatTime;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Device clone() {
    return new Device(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public StatefulInfo getApp() {
    return app;
  }

  public void setApp(final StatefulInfo app) {
    this.app = app;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  public Hardware getHardware() {
    return hardware;
  }

  public void setHardware(final Hardware hardware) {
    this.hardware = hardware;
  }

  public Software getOperatingSystem() {
    return operatingSystem;
  }

  public void setOperatingSystem(final Software operatingSystem) {
    this.operatingSystem = operatingSystem;
  }

  @Nullable
  public List<Software> getSoftwares() {
    return softwares;
  }

  public void setSoftwares(@Nullable final List<Software> softwares) {
    this.softwares = softwares;
  }

  @Nullable
  public Location getLocation() {
    return location;
  }

  public void setLocation(@Nullable final Location location) {
    this.location = location;
  }

  @Nullable
  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(@Nullable final String ipAddress) {
    this.ipAddress = ipAddress;
  }

  @Nullable
  public String getUdid() {
    return udid;
  }

  public void setUdid(@Nullable final String udid) {
    this.udid = udid;
  }

  @Nullable
  public PersonInfo getOwner() {
    return owner;
  }

  public void setOwner(@Nullable final PersonInfo owner) {
    this.owner = owner;
  }

  @Nullable
  public Address getDeployAddress() {
    return deployAddress;
  }

  public void setDeployAddress(@Nullable final Address deployAddress) {
    this.deployAddress = deployAddress;
  }

  public State getState() {
    return state;
  }

  public void setState(final State state) {
    this.state = state;
  }

  @Nullable
  public String getComment() {
    return comment;
  }

  public void setComment(@Nullable final String comment) {
    this.comment = comment;
  }

  @Nullable
  public Instant getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(@Nullable final Instant registerTime) {
    this.registerTime = registerTime;
  }

  @Nullable
  public Instant getLastStartupTime() {
    return lastStartupTime;
  }

  public void setLastStartupTime(@Nullable final Instant lastStartupTime) {
    this.lastStartupTime = lastStartupTime;
  }

  @Nullable
  public Instant getLastHeartbeatTime() {
    return lastHeartbeatTime;
  }

  public void setLastHeartbeatTime(@Nullable final Instant lastHeartbeatTime) {
    this.lastHeartbeatTime = lastHeartbeatTime;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  @Nullable
  public Instant getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(@Nullable final Instant modifyTime) {
    this.modifyTime = modifyTime;
  }

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Device other = (Device) o;
    return Equality.equals(id, other.id)
        && Equality.equals(code, other.code)
        && Equality.equals(name, other.name)
        && Equality.equals(app, other.app)
        && Equality.equals(description, other.description)
        && Equality.equals(hardware, other.hardware)
        && Equality.equals(operatingSystem, other.operatingSystem)
        && Equality.equals(softwares, other.softwares)
        && Equality.equals(location, other.location)
        && Equality.equals(ipAddress, other.ipAddress)
        && Equality.equals(udid, other.udid)
        && Equality.equals(owner, other.owner)
        && Equality.equals(deployAddress, other.deployAddress)
        && Equality.equals(state, other.state)
        && Equality.equals(comment, other.comment)
        && Equality.equals(registerTime, other.registerTime)
        && Equality.equals(lastStartupTime, other.lastStartupTime)
        && Equality.equals(lastHeartbeatTime, other.lastHeartbeatTime)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, hardware);
    result = Hash.combine(result, multiplier, operatingSystem);
    result = Hash.combine(result, multiplier, softwares);
    result = Hash.combine(result, multiplier, location);
    result = Hash.combine(result, multiplier, ipAddress);
    result = Hash.combine(result, multiplier, udid);
    result = Hash.combine(result, multiplier, owner);
    result = Hash.combine(result, multiplier, deployAddress);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, comment);
    result = Hash.combine(result, multiplier, registerTime);
    result = Hash.combine(result, multiplier, lastStartupTime);
    result = Hash.combine(result, multiplier, lastHeartbeatTime);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("code", code)
        .append("name", name)
        .append("app", app)
        .append("description", description)
        .append("hardware", hardware)
        .append("operatingSystem", operatingSystem)
        .append("softwares", softwares)
        .append("location", location)
        .append("ipAddress", ipAddress)
        .append("udid", udid)
        .append("owner", owner)
        .append("deployAddress", deployAddress)
        .append("state", state)
        .append("comment", comment)
        .append("registerTime", registerTime)
        .append("lastStartupTime", lastStartupTime)
        .append("lastHeartbeatTime", lastHeartbeatTime)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
