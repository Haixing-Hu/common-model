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
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.DictEntryInfo;
import ltd.qubit.model.organization.EmployeeInfo;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示电子处方单的主要内容。
 *
 * <p>将{@link PrescriptionContent}从{@link Prescription}中抽象出一个单独对象，是
 * 为了方便对处方单内容进行数字签名和校验。
 *
 * <p><b>参考资料：</b>
 * <ul>
 *   <li>【WS 445.3-2014】电子病历基本数据集 第3部分：门（急）症处方</li>
 *   <li>【WS/T 500.4-2016】电子病历共享文档规范 第4部分：西药处方</li>
 *   <li>【WS/T 500.5-2016】电子病历共享文档规范 第5部分：中药处方</li>
 *   <li><a href="http://www.termonline.cn/">术语在线</a></li>
 * </ul>
 *
 * @author 胡海星
 */
public class PrescriptionContent implements Serializable,
        Assignable<PrescriptionContent> {

  private static final long serialVersionUID = -8051685967003047183L;

  /**
   * 处方编号，即该处方单在所属机构内的流水号。
   */
  @Size(min = 1, max = 128)
  private String number;

  /**
   * 处方单根据药品分类，字典项：西药处方单、中药处方单，保健品处方单等。
   */
  private DictEntryInfo category;

  /**
   * 处方类别，字典项：中西药分别使用不同的字典。
   */
  private DictEntryInfo type;

  /**
   * 处方流向，字典项：院内处方、院外处方等。
   */
  private DictEntryInfo direction;

  /**
   * 费用来源，字典项：职工医保、居民医保、新农合、公费、自费等。
   */
  private DictEntryInfo costSource;

  /**
   * 该处方单所属医疗行为的类别。
   */
  private MedicalType medicalType;

  /**
   * 该处方单对应的医院内就诊流水号或住院号。
   */
  @Size(min = 1, max = 128)
  private String medicalNumber;

  /**
   * 该处方单对应的医院内电子病历流水号。
   */
  @Size(min = 1, max = 128)
  private String recordNumber;

  /**
   * 开方医院。
   */
  private Info hospital;

  /**
   * 开方科室。
   */
  private Info department;

  /**
   * 诊疗科目，字典项。
   */
  private DictEntryInfo subject;

  /**
   * 患者病区，住院处方需要。
   */
  @Size(min = 1, max = 128)
  @Nullable
  public String ward;

  /**
   * 患者床位号，住院处方需要。
   */
  @Size(min = 1, max = 128)
  @Nullable
  public String bed;

  /**
   * 患者。
   */
  private Patient patient;

  /**
   * 主诉。
   */
  private String complaint;

  /**
   * 诊断列表。
   */
  @Size(min = 1, max = 8)
  private List<Diagnosis> diagnoses;

  /**
   * 患者体重，单位千克。新生儿患者必要时需注明体重。
   */
  @Nullable
  private Integer weight;

  /**
   * 患者过敏史。
   */
  private String allergicHistory;

  /**
   * 处方开具时间。
   */
  private LocalDateTime issueTime;

  /**
   * 处方有效天数。
   */
  private Integer validityDays;

  /**
   * 处方项列表。
   */
  @Size(min = 1, max = 10)
  private List<PrescriptionItem> items;

  /**
   * 中药处方单的用法用量说明；中药处方单的处方项通常是具体的药物原料，对所有
   * 药物做处理后的用法用量在这里说明。
   */
  @Nullable
  private Dosage dosage;

  /**
   * 备注。
   */
  @Nullable
  private String notes;

  /**
   * 院内开方医生。
   */
  private EmployeeInfo doctor;

  public PrescriptionContent() {
    // empty
  }

  public PrescriptionContent(final PrescriptionContent other) {
    assign(other);
  }

  @Override
  public void assign(final PrescriptionContent other) {
    Argument.requireNonNull("other", other);
    number = other.number;
    category = Assignment.clone(other.category);
    type = Assignment.clone(other.type);
    direction = Assignment.clone(other.direction);
    costSource = Assignment.clone(other.costSource);
    medicalType = other.medicalType;
    medicalNumber = other.medicalNumber;
    recordNumber = other.recordNumber;
    hospital = Assignment.clone(other.hospital);
    department = Assignment.clone(other.department);
    subject = Assignment.clone(other.subject);
    ward = other.ward;
    bed = other.bed;
    patient = Assignment.clone(other.patient);
    complaint = other.complaint;
    diagnoses = Assignment.deepClone(other.diagnoses);
    weight = other.weight;
    allergicHistory = other.allergicHistory;
    issueTime = other.issueTime;
    validityDays = other.validityDays;
    items = Assignment.deepClone(other.items);
    dosage = Assignment.clone(other.dosage);
    notes = other.notes;
    doctor = Assignment.clone(other.doctor);
  }

  @Override
  public PrescriptionContent clone() {
    return new PrescriptionContent(this);
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public DictEntryInfo getCategory() {
    return category;
  }

  public void setCategory(final DictEntryInfo category) {
    this.category = category;
  }

  public DictEntryInfo getType() {
    return type;
  }

  public void setType(final DictEntryInfo type) {
    this.type = type;
  }

  public DictEntryInfo getDirection() {
    return direction;
  }

  public void setDirection(final DictEntryInfo direction) {
    this.direction = direction;
  }

  public DictEntryInfo getCostSource() {
    return costSource;
  }

  public void setCostSource(final DictEntryInfo costSource) {
    this.costSource = costSource;
  }

  public MedicalType getMedicalType() {
    return medicalType;
  }

  public void setMedicalType(final MedicalType medicalType) {
    this.medicalType = medicalType;
  }

  public String getMedicalNumber() {
    return medicalNumber;
  }

  public void setMedicalNumber(final String medicalNumber) {
    this.medicalNumber = medicalNumber;
  }

  public String getRecordNumber() {
    return recordNumber;
  }

  public void setRecordNumber(final String recordNumber) {
    this.recordNumber = recordNumber;
  }

  public Info getHospital() {
    return hospital;
  }

  public void setHospital(final Info hospital) {
    this.hospital = hospital;
  }

  public Info getDepartment() {
    return department;
  }

  public void setDepartment(final Info department) {
    this.department = department;
  }

  public DictEntryInfo getSubject() {
    return subject;
  }

  public void setSubject(final DictEntryInfo subject) {
    this.subject = subject;
  }

  @Nullable
  public String getWard() {
    return ward;
  }

  public void setWard(@Nullable final String ward) {
    this.ward = ward;
  }

  @Nullable
  public String getBed() {
    return bed;
  }

  public void setBed(@Nullable final String bed) {
    this.bed = bed;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(final Patient patient) {
    this.patient = patient;
  }

  public String getComplaint() {
    return complaint;
  }

  public void setComplaint(final String complaint) {
    this.complaint = complaint;
  }

  public List<Diagnosis> getDiagnoses() {
    return diagnoses;
  }

  public void setDiagnoses(final List<Diagnosis> diagnoses) {
    this.diagnoses = diagnoses;
  }

  @Nullable
  public Integer getWeight() {
    return weight;
  }

  public void setWeight(@Nullable final Integer weight) {
    this.weight = weight;
  }

  public String getAllergicHistory() {
    return allergicHistory;
  }

  public void setAllergicHistory(final String allergicHistory) {
    this.allergicHistory = allergicHistory;
  }

  public LocalDateTime getIssueTime() {
    return issueTime;
  }

  public void setIssueTime(final LocalDateTime issueTime) {
    this.issueTime = issueTime;
  }

  public Integer getValidityDays() {
    return validityDays;
  }

  public void setValidityDays(final Integer validityDays) {
    this.validityDays = validityDays;
  }

  public List<PrescriptionItem> getItems() {
    return items;
  }

  public void setItems(final List<PrescriptionItem> items) {
    this.items = items;
  }

  @Nullable
  public Dosage getDosage() {
    return dosage;
  }

  public void setDosage(@Nullable final Dosage dosage) {
    this.dosage = dosage;
  }

  @Nullable
  public String getNotes() {
    return notes;
  }

  public void setNotes(@Nullable final String notes) {
    this.notes = notes;
  }

  public EmployeeInfo getDoctor() {
    return doctor;
  }

  public void setDoctor(final EmployeeInfo doctor) {
    this.doctor = doctor;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final PrescriptionContent other = (PrescriptionContent) o;
    return Equality.equals(number, other.number)
        && Equality.equals(category, other.category)
        && Equality.equals(type, other.type)
        && Equality.equals(direction, other.direction)
        && Equality.equals(costSource, other.costSource)
        && Equality.equals(medicalType, other.medicalType)
        && Equality.equals(medicalNumber, other.medicalNumber)
        && Equality.equals(recordNumber, other.recordNumber)
        && Equality.equals(hospital, other.hospital)
        && Equality.equals(department, other.department)
        && Equality.equals(subject, other.subject)
        && Equality.equals(ward, other.ward)
        && Equality.equals(bed, other.bed)
        && Equality.equals(patient, other.patient)
        && Equality.equals(complaint, other.complaint)
        && Equality.equals(diagnoses, other.diagnoses)
        && Equality.equals(weight, other.weight)
        && Equality.equals(allergicHistory, other.allergicHistory)
        && Equality.equals(issueTime, other.issueTime)
        && Equality.equals(validityDays, other.validityDays)
        && Equality.equals(items, other.items)
        && Equality.equals(dosage, other.dosage)
        && Equality.equals(notes, other.notes)
        && Equality.equals(doctor, other.doctor);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, number);
    result = Hash.combine(result, multiplier, category);
    result = Hash.combine(result, multiplier, type);
    result = Hash.combine(result, multiplier, direction);
    result = Hash.combine(result, multiplier, costSource);
    result = Hash.combine(result, multiplier, medicalType);
    result = Hash.combine(result, multiplier, medicalNumber);
    result = Hash.combine(result, multiplier, recordNumber);
    result = Hash.combine(result, multiplier, hospital);
    result = Hash.combine(result, multiplier, department);
    result = Hash.combine(result, multiplier, subject);
    result = Hash.combine(result, multiplier, ward);
    result = Hash.combine(result, multiplier, bed);
    result = Hash.combine(result, multiplier, patient);
    result = Hash.combine(result, multiplier, complaint);
    result = Hash.combine(result, multiplier, diagnoses);
    result = Hash.combine(result, multiplier, weight);
    result = Hash.combine(result, multiplier, allergicHistory);
    result = Hash.combine(result, multiplier, issueTime);
    result = Hash.combine(result, multiplier, validityDays);
    result = Hash.combine(result, multiplier, items);
    result = Hash.combine(result, multiplier, dosage);
    result = Hash.combine(result, multiplier, notes);
    result = Hash.combine(result, multiplier, doctor);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("number", number)
        .append("category", category)
        .append("type", type)
        .append("direction", direction)
        .append("costSource", costSource)
        .append("medicalType", medicalType)
        .append("medicalNumber", medicalNumber)
        .append("recordNumber", recordNumber)
        .append("hospital", hospital)
        .append("department", department)
        .append("subject", subject)
        .append("ward", ward)
        .append("bed", bed)
        .append("patient", patient)
        .append("complaint", complaint)
        .append("diagnoses", diagnoses)
        .append("weight", weight)
        .append("allergicHistory", allergicHistory)
        .append("issueTime", issueTime)
        .append("validityDays", validityDays)
        .append("items", items)
        .append("dosage", dosage)
        .append("notes", notes)
        .append("doctor", doctor)
        .toString();
  }
}
