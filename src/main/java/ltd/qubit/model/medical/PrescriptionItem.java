////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示处方项。
 *
 * @author 胡海星
 */
public class PrescriptionItem implements Identifiable, Assignable<PrescriptionItem> {

  private static final long serialVersionUID = 8450020838044068853L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所属处方ID。
   */
  private Long prescriptionId;

  /**
   * 药品信息。
   */
  private DrugInfo drug;

  /**
   * （包装）数量或剂量。
   */
  private Integer amount;

  /**
   * （包装）数量或剂量单位。
   */
  @Size(min = 1, max = 64)
  private String unit;

  /**
   * 用法与用量。
   */
  private Dosage dosage;

  /**
   * 备注信息。
   */
  @Nullable
  private String comment;

  public PrescriptionItem() {
    // empty
  }

  public PrescriptionItem(final PrescriptionItem other) {
    assign(other);
  }

  @Override
  public void assign(final PrescriptionItem other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    prescriptionId = other.prescriptionId;
    drug = Assignment.clone(other.drug);
    amount = other.amount;
    unit = other.unit;
    dosage = Assignment.clone(other.dosage);
    comment = other.comment;
  }

  @Override
  public PrescriptionItem clone() {
    return new PrescriptionItem(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getPrescriptionId() {
    return prescriptionId;
  }

  public void setPrescriptionId(final Long prescriptionId) {
    this.prescriptionId = prescriptionId;
  }

  public DrugInfo getDrug() {
    return drug;
  }

  public void setDrug(final DrugInfo drug) {
    this.drug = drug;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(final Integer amount) {
    this.amount = amount;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(final String unit) {
    this.unit = unit;
  }

  public Dosage getDosage() {
    return dosage;
  }

  public void setDosage(final Dosage dosage) {
    this.dosage = dosage;
  }

  @Nullable
  public String getComment() {
    return comment;
  }

  public void setComment(@Nullable final String comment) {
    this.comment = comment;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final PrescriptionItem other = (PrescriptionItem) o;
    return Equality.equals(id, other.id)
        && Equality.equals(prescriptionId, other.prescriptionId)
        && Equality.equals(drug, other.drug)
        && Equality.equals(amount, other.amount)
        && Equality.equals(unit, other.unit)
        && Equality.equals(dosage, other.dosage)
        && Equality.equals(comment, other.comment);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, prescriptionId);
    result = Hash.combine(result, multiplier, drug);
    result = Hash.combine(result, multiplier, amount);
    result = Hash.combine(result, multiplier, unit);
    result = Hash.combine(result, multiplier, dosage);
    result = Hash.combine(result, multiplier, comment);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("prescriptionId", prescriptionId)
        .append("drug", drug)
        .append("amount", amount)
        .append("unit", unit)
        .append("dosage", dosage)
        .append("comment", comment)
        .toString();
  }
}
