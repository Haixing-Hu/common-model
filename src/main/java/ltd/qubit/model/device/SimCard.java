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

import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.contact.Country;
import ltd.qubit.model.contact.Location;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.util.Emptyful;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.Normalizable;

/**
 * 此模型表示SIM卡信息。
 *
 * @author 胡海星
 */
public class SimCard implements Serializable, Emptyful, Normalizable,
    Assignable<SimCard> {

  private static final long serialVersionUID = -6838740246290718252L;

  /**
   * SIM卡的ICCID。
   *
   * <p>ICCID: Integrate circuit card identity, 集成电路卡识别码，即SIM卡卡号，相当于
   * 手机号码的身份证。 ICCID为IC卡的识别号码，共有20位字符组成，其编码格式为：</p>
   *
   * <pre><code>XXXXXX 0MFSS YYGXX XXXX</code></pre>
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String iccid;

  /**
   * SIM 卡槽的 IMEI 码。
   *
   * <p>IMEI: International Mobile Equipment Identity，国际移动设备识别码，是一个15~17
   * 位16进制数的字符串表示，用于标识GSM，WCDMA和iDEN移动电话以及某些卫星电话的唯一编号。通
   * 常，手机有一个IMEI号码，但在双SIM卡手机中有两个。</p>
   *
   * <p>全球每部通过正规渠道销售的 GSM 手机均有唯一的 IMEI 码。IMEI 码由 GSMA 协会统一规划，
   * 并授权各地区组织进行分配，在中国由工业和信息化部电信终端测试技术协会（TAF）负责国内手机的
   * 入网认证，其他分配机构包括英国 BABT、美国 CTIA 等。</p>
   *
   * <p>IMEI 序列号共有15~17位数字。前8位（TAC）是型号核准号码（早期为6位），是区分手机品牌
   * 和型号的编码。接着2位（FAC）是最后装配号（仅在早期机型中存在），代表最终装配地代码。后6位
   * （SNR）是串号，代表生产顺序号。国际移动设备识别码一般贴于机身背面与外包装上，同时也存在于
   * 手机存储器中，通过在手机拨号键盘中输入*#06#即可查询。</p>
   *
   * <p><b>注意：</b>IMEI 是绑定到手机的 SIM 卡槽的，和 SIM 卡无关，即使没有插 SIM 卡也有
   * IMEI 码。</p>
   *
   * <p>如果手机有多个卡槽（多卡多待手机），此属性表示第一个卡槽（但不一定是用户设置的默认卡槽）
   * 的 IMEI 码。</p>
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String imei;

  /**
   * SIM 卡槽的 MEID 。
   *
   * <p>IMEI: Mobile Equipment Identifier，适用于 CDMA 制式手机，是一个14位十六进制数的
   * 字符串表示。从作用上说，MEID 也是移动网络中手机的唯一标识。</p>
   *
   * <p>MEID 号码是由 Telecommunications Industry Association（TIA）进行分配管理的。
   * 申请 MEID 是需要付费的。目前的价格是每 1M 范围的 MEID 的费用是 8000 美元，每增加 1M
   * 范围的 MEID 号码需要额外付费 8000 美元。
   *
   * <p><b>注意：</b>MEID 是绑定到手机的 SIM 卡槽的，和 SIM 卡无关，即使没有插 SIM 卡也有
   * IMEI 码。</p>
   *
   * <p>如果手机有多个卡槽（多卡多待手机），此属性表示第一个卡槽（但不一定是用户设置的默认卡槽）
   * 的 MEID 码。</p>
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String meid;

  /**
   * SIM卡的手机号码。
   */
  @Nullable
  private Phone phone;

  /**
   * 运营商名称。
   */
  @Nullable
  private String operator;

  /**
   * 运营商所属国家的基本信息。
   */
  @Reference(entity = Country.class, property = "info")
  @Nullable
  private Info country;

  /**
   * SIM卡当前所在地理位置。
   */
  @Nullable
  private Location location;

  /**
   * 移动数据网络类型。
   */
  @Nullable
  private DataNetworkType networkType;

  /**
   * SIM卡当前状态。
   */
  @Nullable
  private SimCardStatus status;

  public SimCard() {
    // empty
  }

  public SimCard(final SimCard other) {
    assign(other);
  }

  @Override
  public void assign(final SimCard other) {
    Argument.requireNonNull("other", other);
    iccid = other.iccid;
    imei = other.imei;
    meid = other.meid;
    phone = Assignment.clone(other.phone);
    operator = other.operator;
    country = Assignment.clone(other.country);
    location = Assignment.clone(other.location);
    networkType = other.networkType;
    status = other.status;
  }

  @Override
  public SimCard clone() {
    return new SimCard(this);
  }

  @Nullable
  public String getIccid() {
    return iccid;
  }

  public void setIccid(@Nullable final String iccid) {
    this.iccid = iccid;
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

  @Nullable
  public Phone getPhone() {
    return phone;
  }

  public void setPhone(@Nullable final Phone phone) {
    this.phone = phone;
  }

  @Nullable
  public String getOperator() {
    return operator;
  }

  public void setOperator(@Nullable final String operator) {
    this.operator = operator;
  }

  @Nullable
  public Info getCountry() {
    return country;
  }

  public void setCountry(@Nullable final Info country) {
    this.country = country;
  }

  @Nullable
  public Location getLocation() {
    return location;
  }

  public void setLocation(@Nullable final Location location) {
    this.location = location;
  }

  @Nullable
  public DataNetworkType getNetworkType() {
    return networkType;
  }

  public void setNetworkType(@Nullable final DataNetworkType networkType) {
    this.networkType = networkType;
  }

  @Nullable
  public SimCardStatus getStatus() {
    return status;
  }

  public void setStatus(@Nullable final SimCardStatus status) {
    this.status = status;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final SimCard other = (SimCard) o;
    return Equality.equals(iccid, other.iccid)
        && Equality.equals(imei, other.imei)
        && Equality.equals(meid, other.meid)
        && Equality.equals(phone, other.phone)
        && Equality.equals(operator, other.operator)
        && Equality.equals(country, other.country)
        && Equality.equals(location, other.location)
        && Equality.equals(networkType, other.networkType)
        && Equality.equals(status, other.status);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, iccid);
    result = Hash.combine(result, multiplier, imei);
    result = Hash.combine(result, multiplier, meid);
    result = Hash.combine(result, multiplier, phone);
    result = Hash.combine(result, multiplier, operator);
    result = Hash.combine(result, multiplier, country);
    result = Hash.combine(result, multiplier, location);
    result = Hash.combine(result, multiplier, networkType);
    result = Hash.combine(result, multiplier, status);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("iccid", iccid)
        .append("imei", imei)
        .append("meid", meid)
        .append("phone", phone)
        .append("operator", operator)
        .append("country", country)
        .append("location", location)
        .append("networkType", networkType)
        .append("status", status)
        .toString();
  }
}
