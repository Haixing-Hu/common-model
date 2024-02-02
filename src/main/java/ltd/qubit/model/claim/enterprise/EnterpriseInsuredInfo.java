////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.claim.enterprise;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Creatable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.Modifiable;

/**
 * 此模型表示企业出险人信息。
 *
 * @author 潘凯
 */
public class EnterpriseInsuredInfo implements Identifiable, Creatable,
    Modifiable, Assignable<EnterpriseInsuredInfo> {

  private static final long serialVersionUID = 7035584029287114997L;

  /**
   * 内部ID，全局唯一。
   */
  @Unique
  private Long id;

  /**
   * 产品ID。
   */
  private Info product;

  /**
   * 出险人姓名。
   */
  private String name;

  /**
   * 出险人身份证号。
   */
  private String credentialNumber;

  /**
   * 人员归属。
   */
  @Nullable
  private EnterpriseOwnership ownership;

  /**
   * 人员类别。
   */
  @Nullable
  private EnterpriseInsuredType insuredType;

  /**
   * 出险人年龄。
   */
  @Nullable
  private Integer age;

  /**
   * 出险人与职工关系。
   */
  @Nullable
  private String employeeRelation;

  /**
   * 出险人关联的职工身份证号。
   */
  @Nullable
  private String employeeCredentialNumber;

  /**
   * 出险人关联的职工医保卡号。
   */
  @Nullable
  private String employeeMedicareNumber;

  /**
   * 出险人关联的职工姓名。
   */
  @Nullable
  private String employeeName;

  /**
   * 出险人关联的职工单位。
   */
  @Nullable
  private String employeeCompany;

  /**
   * 出险人的历史赔付金额信息列表。
   */
  private List<EnterpriseHistoryClaimAmount> claimAmounts;

  /**
   * 创建时间，即提交时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  public EnterpriseInsuredInfo() {
    // empty
  }

  public EnterpriseInsuredInfo(final EnterpriseInsuredInfo other) {
    assign(other);
  }

  @Override
  public void assign(final EnterpriseInsuredInfo other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    product = Assignment.clone(other.product);
    name = other.name;
    credentialNumber = other.credentialNumber;
    ownership = other.ownership;
    insuredType = other.insuredType;
    age = other.age;
    employeeRelation = other.employeeRelation;
    employeeCredentialNumber = other.employeeCredentialNumber;
    employeeMedicareNumber = other.employeeMedicareNumber;
    employeeName = other.employeeName;
    employeeCompany = other.employeeCompany;
    claimAmounts = Assignment.deepClone(other.claimAmounts);
    createTime = other.createTime;
    modifyTime = other.modifyTime;
  }

  @Override
  public EnterpriseInsuredInfo clone() {
    return new EnterpriseInsuredInfo(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Info getProduct() {
    return product;
  }

  public void setProduct(final Info product) {
    this.product = product;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getCredentialNumber() {
    return credentialNumber;
  }

  public void setCredentialNumber(final String credentialNumber) {
    this.credentialNumber = credentialNumber;
  }

  @Nullable
  public EnterpriseOwnership getOwnership() {
    return ownership;
  }

  public void setOwnership(@Nullable final EnterpriseOwnership ownership) {
    this.ownership = ownership;
  }

  @Nullable
  public EnterpriseInsuredType getInsuredType() {
    return insuredType;
  }

  public void setInsuredType(@Nullable final EnterpriseInsuredType insuredType) {
    this.insuredType = insuredType;
  }

  @Nullable
  public Integer getAge() {
    return age;
  }

  public void setAge(@Nullable final Integer age) {
    this.age = age;
  }

  @Nullable
  public String getEmployeeRelation() {
    return employeeRelation;
  }

  public void setEmployeeRelation(@Nullable final String employeeRelation) {
    this.employeeRelation = employeeRelation;
  }

  @Nullable
  public String getEmployeeCredentialNumber() {
    return employeeCredentialNumber;
  }

  public void setEmployeeCredentialNumber(@Nullable final String employeeCredentialNumber) {
    this.employeeCredentialNumber = employeeCredentialNumber;
  }

  @Nullable
  public String getEmployeeMedicareNumber() {
    return employeeMedicareNumber;
  }

  public void setEmployeeMedicareNumber(@Nullable final String employeeMedicareNumber) {
    this.employeeMedicareNumber = employeeMedicareNumber;
  }

  @Nullable
  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(@Nullable final String employeeName) {
    this.employeeName = employeeName;
  }

  @Nullable
  public String getEmployeeCompany() {
    return employeeCompany;
  }

  public void setEmployeeCompany(@Nullable final String employeeCompany) {
    this.employeeCompany = employeeCompany;
  }

  public List<EnterpriseHistoryClaimAmount> getClaimAmounts() {
    return claimAmounts;
  }

  public void setClaimAmounts(final List<EnterpriseHistoryClaimAmount> claimAmounts) {
    this.claimAmounts = claimAmounts;
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

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final EnterpriseInsuredInfo other = (EnterpriseInsuredInfo) o;
    return Equality.equals(id, other.id)
        && Equality.equals(product, other.product)
        && Equality.equals(name, other.name)
        && Equality.equals(credentialNumber, other.credentialNumber)
        && Equality.equals(ownership, other.ownership)
        && Equality.equals(insuredType, other.insuredType)
        && Equality.equals(age, other.age)
        && Equality.equals(employeeRelation, other.employeeRelation)
        && Equality.equals(employeeCredentialNumber,
        other.employeeCredentialNumber)
        && Equality.equals(employeeMedicareNumber, other.employeeMedicareNumber)
        && Equality.equals(employeeName, other.employeeName)
        && Equality.equals(employeeCompany, other.employeeCompany)
        && Equality.equals(claimAmounts, other.claimAmounts)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, product);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, credentialNumber);
    result = Hash.combine(result, multiplier, ownership);
    result = Hash.combine(result, multiplier, insuredType);
    result = Hash.combine(result, multiplier, age);
    result = Hash.combine(result, multiplier, employeeRelation);
    result = Hash.combine(result, multiplier, employeeCredentialNumber);
    result = Hash.combine(result, multiplier, employeeMedicareNumber);
    result = Hash.combine(result, multiplier, employeeName);
    result = Hash.combine(result, multiplier, employeeCompany);
    result = Hash.combine(result, multiplier, claimAmounts);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("product", product)
        .append("name", name)
        .append("credentialNumber", credentialNumber)
        .append("ownership", ownership)
        .append("insuredType", insuredType)
        .append("age", age)
        .append("employeeRelation", employeeRelation)
        .append("employeeCredentialNumber", employeeCredentialNumber)
        .append("employeeMedicareNumber", employeeMedicareNumber)
        .append("employeeName", employeeName)
        .append("employeeCompany", employeeCompany)
        .append("claimAmounts", claimAmounts)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .toString();
  }
}
