////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.device;

import java.io.Serializable;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Indexed;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 此模型表示设备的硬件信息。
 *
 * @author 胡海星
 */
public class Hardware implements Serializable, Assignable<Hardware> {

  private static final long serialVersionUID = -7320591174105320264L;

  /**
   * 设备的硬件名称，通常是制造商分配的一个特定的硬件名称。
   */
  @Size(min = 1, max = 128)
  @Indexed
  @Nullable
  private String device;

  /**
   * 设备型号名称。
   */
  @Size(min = 1, max = 128)
  @Indexed
  @Nullable
  private String model;

  /**
   * 设备品牌名称。
   * <p>
   * 例如 Samsung、Google、Huawei 等。
   */
  @Size(min = 1, max = 128)
  @Indexed
  @Nullable
  private String brand;

  /**
   * 设备硬件制造商名称。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String manufacturer;

  /**
   * 设备硬件产品的整体名称。
   * <p>
   * 它通常与设备的型号或市场名称相关。这个名称是在设备的固件或软件层面定义的，通常用于标识
   * 设备的特定配置或子型号。例如，同一个设备在不同的地区或网络运营商那里可能有不同的产品
   * 名称。这个字段有助于开发者识别运行他们应用的特定设备型号。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String product;

  /**
   * 设备固件版本的人类可读描述。
   * <p>
   * 这通常包括了一个版本号或标识符，有时还会包括其他信息，如构建类型或构建日期。
   * 此字段通常用于展示给最终用户，提供关于设备当前安装的固件或操作系统版本的信息。
   * 这对于诊断问题或确保应用与特定系统版本兼容非常有用。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String display;

  /**
   * 设备主板名称。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String board;

  /**
   * 描述设备硬件的通用名称，如处理器型号。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String hardware;

  /**
   * 设备支持的应用二进制接口（Application Binary Interfaces, ABIs）。
   * <p>
   * ABI 是一个接口，它定义了应用程序与操作系统之间的交互方式，特别是如何在特定的处理器架
   * 构上执行。它包括细节如数据类型的大小、布局、对齐，以及调用约定，这些都影响着应用程序
   * 的二进制代码如何与操作系统交互。
   * <p>
   * 此字段的值与硬件密切相关。反映了设备的处理器架构，这是由设备的硬件决定的。不同的处理器
   * 架构支持不同的指令集和执行特性，这对于应用程序中包含的本地（即使用 C/C++ 编写的）代码
   * 的运行至关重要。
   */
  @Nullable
  private String[] supportedAbis;

  /**
   * 所有非虚拟网卡的MAC地址列表，按照字典序从小到大排序。
   */
  @Nullable
  private String[] macAddresses;

  /**
   * 设备SIM卡的IMEI号。
   */
  @Size(min = 1, max = 128)
  @Indexed
  @Nullable
  private String imei;

  /**
   * 设备SIM卡的MEID号。
   */
  @Size(min = 1, max = 128)
  @Indexed
  @Nullable
  private String meid;

  /**
   * 设备硬件序列号。
   */
  @Size(min = 1, max = 128)
  @Indexed
  private String serial;

  public Hardware() {
    // empty
  }

  public Hardware(final Hardware other) {
    assign(other);
  }

  @Override
  public void assign(final Hardware other) {
    Argument.requireNonNull("other", other);
    device = other.device;
    model = other.model;
    brand = other.brand;
    manufacturer = other.manufacturer;
    product = other.product;
    display = other.display;
    board = other.board;
    hardware = other.hardware;
    supportedAbis = Assignment.clone(other.supportedAbis);
    macAddresses = Assignment.clone(other.macAddresses);
    imei = other.imei;
    meid = other.meid;
    serial = other.serial;
  }

  @Override
  public Hardware clone() {
    return new Hardware(this);
  }

  @Nullable
  public String getDevice() {
    return device;
  }

  public void setDevice(@Nullable final String device) {
    this.device = device;
  }

  @Nullable
  public String getModel() {
    return model;
  }

  public void setModel(@Nullable final String model) {
    this.model = model;
  }

  @Nullable
  public String getBrand() {
    return brand;
  }

  public void setBrand(@Nullable final String brand) {
    this.brand = brand;
  }

  @Nullable
  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(@Nullable final String manufacturer) {
    this.manufacturer = manufacturer;
  }

  @Nullable
  public String getProduct() {
    return product;
  }

  public void setProduct(@Nullable final String product) {
    this.product = product;
  }

  @Nullable
  public String getDisplay() {
    return display;
  }

  public void setDisplay(@Nullable final String display) {
    this.display = display;
  }

  @Nullable
  public String getBoard() {
    return board;
  }

  public void setBoard(@Nullable final String board) {
    this.board = board;
  }

  @Nullable
  public String getHardware() {
    return hardware;
  }

  public void setHardware(@Nullable final String hardware) {
    this.hardware = hardware;
  }

  @Nullable
  public String[] getSupportedAbis() {
    return supportedAbis;
  }

  public void setSupportedAbis(@Nullable final String[] supportedAbis) {
    this.supportedAbis = supportedAbis;
  }

  @Nullable
  public String[] getMacAddresses() {
    return macAddresses;
  }

  public void setMacAddresses(@Nullable final String[] macAddresses) {
    this.macAddresses = macAddresses;
  }

  @Nullable
  public String getImei() {
    return imei;
  }

  public void setImei(@Nullable final String imei) {
    this.imei = imei;
  }

  @Nullable
  public String getMeid() {
    return meid;
  }

  public void setMeid(@Nullable final String meid) {
    this.meid = meid;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(final String serial) {
    this.serial = serial;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Hardware other = (Hardware) o;
    return Equality.equals(device, other.device)
        && Equality.equals(model, other.model)
        && Equality.equals(brand, other.brand)
        && Equality.equals(manufacturer, other.manufacturer)
        && Equality.equals(product, other.product)
        && Equality.equals(display, other.display)
        && Equality.equals(board, other.board)
        && Equality.equals(hardware, other.hardware)
        && Equality.equals(supportedAbis, other.supportedAbis)
        && Equality.equals(macAddresses, other.macAddresses)
        && Equality.equals(imei, other.imei)
        && Equality.equals(meid, other.meid)
        && Equality.equals(serial, other.serial);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, device);
    result = Hash.combine(result, multiplier, model);
    result = Hash.combine(result, multiplier, brand);
    result = Hash.combine(result, multiplier, manufacturer);
    result = Hash.combine(result, multiplier, product);
    result = Hash.combine(result, multiplier, display);
    result = Hash.combine(result, multiplier, board);
    result = Hash.combine(result, multiplier, hardware);
    result = Hash.combine(result, multiplier, supportedAbis);
    result = Hash.combine(result, multiplier, macAddresses);
    result = Hash.combine(result, multiplier, imei);
    result = Hash.combine(result, multiplier, meid);
    result = Hash.combine(result, multiplier, serial);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("device", device)
        .append("model", model)
        .append("brand", brand)
        .append("manufacturer", manufacturer)
        .append("product", product)
        .append("display", display)
        .append("board", board)
        .append("hardware", hardware)
        .append("supportedAbis", supportedAbis)
        .append("macAddresses", macAddresses)
        .append("imei", imei)
        .append("meid", meid)
        .append("serial", serial)
        .toString();
  }
}
