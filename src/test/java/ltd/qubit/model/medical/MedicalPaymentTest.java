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
 * Unit test of the {@link MedicalPayment} class.
 *
 * @author Haixing Hu
 */
public class MedicalPaymentTest extends ModelTestBase<MedicalPayment> {

  public MedicalPaymentTest() {
    super(MedicalPayment.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("selfCare", getFieldName(MedicalPayment.class, MedicalPayment::getSelfCare));
    assertEquals("selfCare", getFieldName(MedicalPayment.class, MedicalPayment::setSelfCare));
    assertEquals("selfPaid", getFieldName(MedicalPayment.class, MedicalPayment::getSelfPaid));
    assertEquals("selfPaid", getFieldName(MedicalPayment.class, MedicalPayment::setSelfPaid));
    assertEquals("withinMedicare", getFieldName(MedicalPayment.class, MedicalPayment::getWithinMedicare));
    assertEquals("withinMedicare", getFieldName(MedicalPayment.class, MedicalPayment::setWithinMedicare));
    assertEquals("medicarePaid", getFieldName(MedicalPayment.class, MedicalPayment::getMedicarePaid));
    assertEquals("medicarePaid", getFieldName(MedicalPayment.class, MedicalPayment::setMedicarePaid));
    assertEquals("medicareDeductible", getFieldName(MedicalPayment.class, MedicalPayment::getMedicareDeductible));
    assertEquals("medicareDeductible", getFieldName(MedicalPayment.class, MedicalPayment::setMedicareDeductible));
    assertEquals("personalBurden", getFieldName(MedicalPayment.class, MedicalPayment::getPersonalBurden));
    assertEquals("personalBurden", getFieldName(MedicalPayment.class, MedicalPayment::setPersonalBurden));
    assertEquals("transferPrepaid", getFieldName(MedicalPayment.class, MedicalPayment::getTransferPrepaid));
    assertEquals("transferPrepaid", getFieldName(MedicalPayment.class, MedicalPayment::setTransferPrepaid));
    assertEquals("sectionalPaid", getFieldName(MedicalPayment.class, MedicalPayment::getSectionalPaid));
    assertEquals("sectionalPaid", getFieldName(MedicalPayment.class, MedicalPayment::setSectionalPaid));
    assertEquals("hospitalBurden", getFieldName(MedicalPayment.class, MedicalPayment::getHospitalBurden));
    assertEquals("hospitalBurden", getFieldName(MedicalPayment.class, MedicalPayment::setHospitalBurden));
    assertEquals("poolFundPaid", getFieldName(MedicalPayment.class, MedicalPayment::getPoolFundPaid));
    assertEquals("poolFundPaid", getFieldName(MedicalPayment.class, MedicalPayment::setPoolFundPaid));
    assertEquals("civilServantFundPaid", getFieldName(MedicalPayment.class, MedicalPayment::getCivilServantFundPaid));
    assertEquals("civilServantFundPaid", getFieldName(MedicalPayment.class, MedicalPayment::setCivilServantFundPaid));
    assertEquals("seriousDiseaseAssistancePaid",
      getFieldName(MedicalPayment.class, MedicalPayment::getSeriousDiseaseAssistancePaid));
    assertEquals("seriousDiseaseAssistancePaid",
      getFieldName(MedicalPayment.class, MedicalPayment::setSeriousDiseaseAssistancePaid));
    assertEquals("seriousDiseaseInsurancePaid",
      getFieldName(MedicalPayment.class, MedicalPayment::getSeriousDiseaseInsurancePaid));
    assertEquals("seriousDiseaseInsurancePaid",
      getFieldName(MedicalPayment.class, MedicalPayment::setSeriousDiseaseInsurancePaid));
    assertEquals("civilAffairsAssistancePaid",
      getFieldName(MedicalPayment.class, MedicalPayment::getCivilAffairsAssistancePaid));
    assertEquals("civilAffairsAssistancePaid",
      getFieldName(MedicalPayment.class, MedicalPayment::setCivilAffairsAssistancePaid));
    assertEquals("otherFundPaid", getFieldName(MedicalPayment.class, MedicalPayment::getOtherFundPaid));
    assertEquals("otherFundPaid", getFieldName(MedicalPayment.class, MedicalPayment::setOtherFundPaid));
    assertEquals("accountPaid", getFieldName(MedicalPayment.class, MedicalPayment::getAccountPaid));
    assertEquals("accountPaid", getFieldName(MedicalPayment.class, MedicalPayment::setAccountPaid));
    assertEquals("accountBalance", getFieldName(MedicalPayment.class, MedicalPayment::getAccountBalance));
    assertEquals("accountBalance", getFieldName(MedicalPayment.class, MedicalPayment::setAccountBalance));
    assertEquals("cashPrepaid", getFieldName(MedicalPayment.class, MedicalPayment::getCashPrepaid));
    assertEquals("cashPrepaid", getFieldName(MedicalPayment.class, MedicalPayment::setCashPrepaid));
    assertEquals("cashRecharge", getFieldName(MedicalPayment.class, MedicalPayment::getCashRecharge));
    assertEquals("cashRecharge", getFieldName(MedicalPayment.class, MedicalPayment::setCashRecharge));
    assertEquals("cashRefund", getFieldName(MedicalPayment.class, MedicalPayment::getCashRefund));
    assertEquals("cashRefund", getFieldName(MedicalPayment.class, MedicalPayment::setCashRefund));
    assertEquals("chequePrepaid", getFieldName(MedicalPayment.class, MedicalPayment::getChequePrepaid));
    assertEquals("chequePrepaid", getFieldName(MedicalPayment.class, MedicalPayment::setChequePrepaid));
    assertEquals("chequeRecharge", getFieldName(MedicalPayment.class, MedicalPayment::getChequeRecharge));
    assertEquals("chequeRecharge", getFieldName(MedicalPayment.class, MedicalPayment::setChequeRecharge));
    assertEquals("chequeRefund", getFieldName(MedicalPayment.class, MedicalPayment::getChequeRefund));
    assertEquals("chequeRefund", getFieldName(MedicalPayment.class, MedicalPayment::setChequeRefund));
    assertEquals("bankTransferPrepaid", getFieldName(MedicalPayment.class, MedicalPayment::getBankTransferPrepaid));
    assertEquals("bankTransferPrepaid", getFieldName(MedicalPayment.class, MedicalPayment::setBankTransferPrepaid));
    assertEquals("bankTransferRecharge", getFieldName(MedicalPayment.class, MedicalPayment::getBankTransferRecharge));
    assertEquals("bankTransferRecharge", getFieldName(MedicalPayment.class, MedicalPayment::setBankTransferRecharge));
    assertEquals("bankTransferRefund", getFieldName(MedicalPayment.class, MedicalPayment::getBankTransferRefund));
    assertEquals("bankTransferRefund", getFieldName(MedicalPayment.class, MedicalPayment::setBankTransferRefund));
  }
}
