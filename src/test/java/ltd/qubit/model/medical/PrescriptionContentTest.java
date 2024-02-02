////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link PrescriptionContent} class.
 *
 * @author Haixing Hu
 */
public class PrescriptionContentTest extends ModelTestBase<PrescriptionContent> {

  public PrescriptionContentTest() {
    super(PrescriptionContent.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("number", getFieldName(PrescriptionContent.class, PrescriptionContent::getNumber));
    assertEquals("number", getFieldName(PrescriptionContent.class, PrescriptionContent::setNumber));
    assertEquals("category", getFieldName(PrescriptionContent.class, PrescriptionContent::getCategory));
    assertEquals("category", getFieldName(PrescriptionContent.class, PrescriptionContent::setCategory));
    assertEquals("type", getFieldName(PrescriptionContent.class, PrescriptionContent::getType));
    assertEquals("type", getFieldName(PrescriptionContent.class, PrescriptionContent::setType));
    assertEquals("direction", getFieldName(PrescriptionContent.class, PrescriptionContent::getDirection));
    assertEquals("direction", getFieldName(PrescriptionContent.class, PrescriptionContent::setDirection));
    assertEquals("costSource", getFieldName(PrescriptionContent.class, PrescriptionContent::getCostSource));
    assertEquals("costSource", getFieldName(PrescriptionContent.class, PrescriptionContent::setCostSource));
    assertEquals("medicalType", getFieldName(PrescriptionContent.class, PrescriptionContent::getMedicalType));
    assertEquals("medicalType", getFieldName(PrescriptionContent.class, PrescriptionContent::setMedicalType));
    assertEquals("medicalNumber", getFieldName(PrescriptionContent.class, PrescriptionContent::getMedicalNumber));
    assertEquals("medicalNumber", getFieldName(PrescriptionContent.class, PrescriptionContent::setMedicalNumber));
    assertEquals("recordNumber", getFieldName(PrescriptionContent.class, PrescriptionContent::getRecordNumber));
    assertEquals("recordNumber", getFieldName(PrescriptionContent.class, PrescriptionContent::setRecordNumber));
    assertEquals("hospital", getFieldName(PrescriptionContent.class, PrescriptionContent::getHospital));
    assertEquals("hospital", getFieldName(PrescriptionContent.class, PrescriptionContent::setHospital));
    assertEquals("department", getFieldName(PrescriptionContent.class, PrescriptionContent::getDepartment));
    assertEquals("department", getFieldName(PrescriptionContent.class, PrescriptionContent::setDepartment));
    assertEquals("subject", getFieldName(PrescriptionContent.class, PrescriptionContent::getSubject));
    assertEquals("subject", getFieldName(PrescriptionContent.class, PrescriptionContent::setSubject));
    assertEquals("ward", getFieldName(PrescriptionContent.class, PrescriptionContent::getWard));
    assertEquals("ward", getFieldName(PrescriptionContent.class, PrescriptionContent::setWard));
    assertEquals("bed", getFieldName(PrescriptionContent.class, PrescriptionContent::getBed));
    assertEquals("bed", getFieldName(PrescriptionContent.class, PrescriptionContent::setBed));
    assertEquals("patient", getFieldName(PrescriptionContent.class, PrescriptionContent::getPatient));
    assertEquals("patient", getFieldName(PrescriptionContent.class, PrescriptionContent::setPatient));
    assertEquals("complaint", getFieldName(PrescriptionContent.class, PrescriptionContent::getComplaint));
    assertEquals("complaint", getFieldName(PrescriptionContent.class, PrescriptionContent::setComplaint));
    assertEquals("diagnoses", getFieldName(PrescriptionContent.class, PrescriptionContent::getDiagnoses));
    assertEquals("diagnoses", getFieldName(PrescriptionContent.class, PrescriptionContent::setDiagnoses));
    assertEquals("weight", getFieldName(PrescriptionContent.class, PrescriptionContent::getWeight));
    assertEquals("weight", getFieldName(PrescriptionContent.class, PrescriptionContent::setWeight));
    assertEquals("allergicHistory", getFieldName(PrescriptionContent.class, PrescriptionContent::getAllergicHistory));
    assertEquals("allergicHistory", getFieldName(PrescriptionContent.class, PrescriptionContent::setAllergicHistory));
    assertEquals("issueTime", getFieldName(PrescriptionContent.class, PrescriptionContent::getIssueTime));
    assertEquals("issueTime", getFieldName(PrescriptionContent.class, PrescriptionContent::setIssueTime));
    assertEquals("validityDays", getFieldName(PrescriptionContent.class, PrescriptionContent::getValidityDays));
    assertEquals("validityDays", getFieldName(PrescriptionContent.class, PrescriptionContent::setValidityDays));
    assertEquals("items", getFieldName(PrescriptionContent.class, PrescriptionContent::getItems));
    assertEquals("items", getFieldName(PrescriptionContent.class, PrescriptionContent::setItems));
    assertEquals("dosage", getFieldName(PrescriptionContent.class, PrescriptionContent::getDosage));
    assertEquals("dosage", getFieldName(PrescriptionContent.class, PrescriptionContent::setDosage));
    assertEquals("notes", getFieldName(PrescriptionContent.class, PrescriptionContent::getNotes));
    assertEquals("notes", getFieldName(PrescriptionContent.class, PrescriptionContent::setNotes));
    assertEquals("doctor", getFieldName(PrescriptionContent.class, PrescriptionContent::getDoctor));
    assertEquals("doctor", getFieldName(PrescriptionContent.class, PrescriptionContent::setDoctor));
  }
}
