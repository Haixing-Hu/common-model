////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.invoice;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示医院注册信息。
 *
 * @author xuw
 */
public class InvoiceHospitalRegiste implements Identifiable, Auditable {

  private static final long serialVersionUID = 6647639454544463222L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 机构编码。
   */
  @Size(min = 1, max = 128)
  private String code;

  /**
   * 机构名称。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 行政区划。
   */
  @Size(min = 1, max = 128)
  private String zoneCode;

  /**
   * 收款人全称。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String payeeName;

  /**
   * 收款人账号。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String payeeAccount;

  /**
   * 收款人开户行。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String payeeOpeningBank;

  /**
   * 管理员账号。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String account;

  /**
   * 管理员密码。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String password;

  /**
   * 注册时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant registerTime;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

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

  public String getZoneCode() {
    return zoneCode;
  }

  public void setZoneCode(final String zoneCode) {
    this.zoneCode = zoneCode;
  }

  @Nullable
  public String getPayeeName() {
    return payeeName;
  }

  public void setPayeeName(@Nullable final String payeeName) {
    this.payeeName = payeeName;
  }

  @Nullable
  public String getPayeeAccount() {
    return payeeAccount;
  }

  public void setPayeeAccount(@Nullable final String payeeAccount) {
    this.payeeAccount = payeeAccount;
  }

  @Nullable
  public String getPayeeOpeningBank() {
    return payeeOpeningBank;
  }

  public void setPayeeOpeningBank(@Nullable final String payeeOpeningBank) {
    this.payeeOpeningBank = payeeOpeningBank;
  }

  @Nullable
  public String getAccount() {
    return account;
  }

  public void setAccount(@Nullable final String account) {
    this.account = account;
  }

  @Nullable
  public String getPassword() {
    return password;
  }

  public void setPassword(@Nullable final String password) {
    this.password = password;
  }

  @Nullable
  public Instant getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(@Nullable final Instant registerTime) {
    this.registerTime = registerTime;
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

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final InvoiceHospitalRegiste other = (InvoiceHospitalRegiste) o;
    return Equality.equals(id, other.id)
            && Equality.equals(code, other.code)
            && Equality.equals(name, other.name)
            && Equality.equals(zoneCode, other.zoneCode)
            && Equality.equals(payeeName, other.payeeName)
            && Equality.equals(payeeAccount, other.payeeAccount)
            && Equality.equals(payeeOpeningBank, other.payeeOpeningBank)
            && Equality.equals(account, other.account)
            && Equality.equals(password, other.password)
            && Equality.equals(registerTime, other.registerTime)
            && Equality.equals(createTime, other.createTime)
            && Equality.equals(modifyTime, other.modifyTime)
            && Equality.equals(deleteTime, other.deleteTime);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, zoneCode);
    result = Hash.combine(result, multiplier, payeeName);
    result = Hash.combine(result, multiplier, payeeAccount);
    result = Hash.combine(result, multiplier, payeeOpeningBank);
    result = Hash.combine(result, multiplier, account);
    result = Hash.combine(result, multiplier, password);
    result = Hash.combine(result, multiplier, registerTime);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("code", code)
            .append("name", name)
            .append("zoneCode", zoneCode)
            .append("payeeName", payeeName)
            .append("payeeAccount", payeeAccount)
            .append("payeeOpeningBank", payeeOpeningBank)
            .append("account", account)
            .append("password", password)
            .append("registerTime", registerTime)
            .append("createTime", createTime)
            .append("modifyTime", modifyTime)
            .append("deleteTime", deleteTime)
            .toString();
  }
}
