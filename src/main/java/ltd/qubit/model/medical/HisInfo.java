////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.io.Serializable;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 此抽象类表示来自HIS系统的信息。
 *
 * @author 胡海星
 * @see <a href="https://docs.oracle.com/javaee/6/api/javax/xml/bind/annotation/XmlSeeAlso.html">Annotation Type XmlSeeAlso</a>
 */
@JsonTypeInfo(use = Id.NAME, include = As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @Type(value = ClinicInfo.class, name = "CLINIC"),
    @Type(value = SpecificClinicInfo.class, name = "SPECIFIC_CLINIC"),
    @Type(value = EmergentClinicInfo.class, name = "EMERGENT_CLINIC"),
    @Type(value = ExaminationInfo.class, name = "EXAMINATION"),
    @Type(value = HospitalizationInfo.class, name = "HOSPITALIZATION"),
    @Type(value = RegistrationInfo.class, name = "REGISTRATION")
})
public abstract class HisInfo implements Serializable {

  private static final long serialVersionUID = 5043263685553549324L;

  /**
   * 服务类别。
   */
  protected final MedicalType type;

  /**
   * 业务流水号。
   */
  @Size(min = 1, max = 64)
  protected String number;

  /**
   * 备注。
   */
  @Nullable
  protected String remark;

  protected HisInfo(final MedicalType type) {
    this.type = type;
  }

  public MedicalType getType() {
    return type;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  @Nullable
  public String getRemark() {
    return remark;
  }

  public void setRemark(@Nullable final String remark) {
    this.remark = remark;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final HisInfo other = (HisInfo) o;
    return Equality.equals(type, other.type)
            && Equality.equals(number, other.number)
            && Equality.equals(remark, other.remark);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, type);
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, remark);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("type", type)
            .append("number", number)
            .append("remark", remark)
            .toString();
  }
}
