////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Nullable;

import com.fasterxml.jackson.databind.ObjectMapper;

import ltd.qubit.commons.error.InvalidJsonFormatException;
import ltd.qubit.commons.lang.ClassKey;
import ltd.qubit.commons.lang.EnumUtils;
import ltd.qubit.model.activity.Activity;
import ltd.qubit.model.activity.ActivityCoupon;
import ltd.qubit.model.activity.ActivityProductItem;
import ltd.qubit.model.appointment.Appointment;
import ltd.qubit.model.claim.InsuranceClaim;
import ltd.qubit.model.claim.InsuranceClaimAmount;
import ltd.qubit.model.claim.InsuranceClaimEvent;
import ltd.qubit.model.claim.InsuranceClaimInvoice;
import ltd.qubit.model.claim.InsuranceClaimInvoiceCost;
import ltd.qubit.model.claim.InsuranceClaimMedical;
import ltd.qubit.model.claim.InsuranceProductRule;
import ltd.qubit.model.claim.enterprise.EnterpriseClaim;
import ltd.qubit.model.claim.enterprise.EnterpriseClaimInvoice;
import ltd.qubit.model.claim.enterprise.EnterpriseClaimItem;
import ltd.qubit.model.claim.enterprise.EnterpriseClaimMedical;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.commons.AppResource;
import ltd.qubit.model.commons.Category;
import ltd.qubit.model.commons.CodeMap;
import ltd.qubit.model.commons.Credential;
import ltd.qubit.model.commons.Dict;
import ltd.qubit.model.commons.DictEntry;
import ltd.qubit.model.commons.Faq;
import ltd.qubit.model.commons.MqFailedTask;
import ltd.qubit.model.commons.Payload;
import ltd.qubit.model.commons.Source;
import ltd.qubit.model.contact.Address;
import ltd.qubit.model.contact.City;
import ltd.qubit.model.contact.Country;
import ltd.qubit.model.contact.District;
import ltd.qubit.model.contact.Province;
import ltd.qubit.model.contact.Street;
import ltd.qubit.model.medical.Diagnosis;
import ltd.qubit.model.medical.Disease;
import ltd.qubit.model.medical.Drug;
import ltd.qubit.model.medical.DrugProduct;
import ltd.qubit.model.medical.HospitalDrugstore;
import ltd.qubit.model.medical.Patient;
import ltd.qubit.model.medical.Prescription;
import ltd.qubit.model.medical.PrescriptionContent;
import ltd.qubit.model.medical.PrescriptionItem;
import ltd.qubit.model.order.Client;
import ltd.qubit.model.order.ClientOrder;
import ltd.qubit.model.order.Consignee;
import ltd.qubit.model.order.Order;
import ltd.qubit.model.order.OrderItem;
import ltd.qubit.model.order.RefererInfo;
import ltd.qubit.model.order.RefererOrderRecord;
import ltd.qubit.model.order.Return;
import ltd.qubit.model.organization.Department;
import ltd.qubit.model.organization.Employee;
import ltd.qubit.model.organization.Organization;
import ltd.qubit.model.payment.Account;
import ltd.qubit.model.payment.Payment;
import ltd.qubit.model.person.Person;
import ltd.qubit.model.person.User;
import ltd.qubit.model.privilege.Role;
import ltd.qubit.model.privilege.UserRole;
import ltd.qubit.model.product.Product;
import ltd.qubit.model.product.ProductItem;
import ltd.qubit.model.product.ProductPrice;
import ltd.qubit.model.security.KeyPair;
import ltd.qubit.model.security.Signature;
import ltd.qubit.model.service.MedicalItem;
import ltd.qubit.model.service.MedicalItemUseRecord;
import ltd.qubit.model.service.MedicalPackage;
import ltd.qubit.model.service.MedicalPackageItem;
import ltd.qubit.model.service.UserMedicalItem;
import ltd.qubit.model.settlement.Transaction;
import ltd.qubit.model.system.Log;
import ltd.qubit.model.system.Session;
import ltd.qubit.model.system.Setting;
import ltd.qubit.model.system.VerifyCode;
import ltd.qubit.model.upload.Attachment;
import ltd.qubit.model.upload.Upload;

import static ltd.qubit.commons.lang.EnumUtils.registerLocalizedNames;

/**
 * 此枚举表示实体类型。
 *
 * @author 胡海星
 */
public enum Entity {

  /**
   * 系统设置。
   */
  SETTING(Setting.class),

  /**
   * 审计记录。
   */
  AUDIT(Log.class),

  /**
   * 类别。
   */
  CATEGORY(Category.class),

  /**
   * 来源。
   */
  SOURCE(Source.class),

  /**
   * 验证码。
   */
  VERIFY_CODE(VerifyCode.class),

  /**
   * 会话。
   */
  SESSION(Session.class),

  /**
   * 附件。
   */
  ATTACHMENT(Attachment.class),

  /**
   * 证件。
   */
  CREDENTIAL(Credential.class),

  /**
   * 编码转换。
   */
  CODE_MAP(CodeMap.class),

  /**
   * 上传文件。
   */
  UPLOAD(Upload.class),

  /**
   * 国家。
   */
  COUNTRY(Country.class),

  /**
   * 省份。
   */
  PROVINCE(Province.class),

  /**
   * 城市。
   */
  CITY(City.class),

  /**
   * 区县。
   */
  DISTRICT(District.class),

  /**
   * 街道。
   */
  STREET(Street.class),

  /**
   * 地址。
   */
  ADDRESS(Address.class),

  /**
   * 机构。
   */
  ORGANIZATION(Organization.class),

  /**
   * 部门。
   */
  DEPARTMENT(Department.class),

  /**
   * 员工。
   */
  EMPLOYEE(Employee.class),

  /**
   * 应用。
   */
  APP(App.class),

  /**
   * 字典。
   */
  DICT(Dict.class),

  /**
   * 字典项。
   */
  DICT_ENTRY(DictEntry.class),

  /**
   * 秘钥对。
   */
  KEY_PAIR(KeyPair.class),

  /**
   * 数字签名。
   */
  SIGNATURE(Signature.class),

  /**
   * 角色。
   */
  ROLE(Role.class),

  /**
   * 用户。
   */
  USER(User.class),

  /**
   * 用户角色关联。
   */
  USER_ROLE(UserRole.class),

  /**
   * 个人信息。
   */
  PERSON(Person.class),

  /**
   * 商品。
   */
  PRODUCT(Product.class),

  /**
   * 商品项。
   */
  PRODUCT_ITEM(ProductItem.class),

  /**
   * 商品价格。
   */
  PRODUCT_PRICE(ProductPrice.class),

  /**
   * 订单。
   */
  ORDER(Order.class),

  /**
   * 订单项。
   */
  ORDER_ITEM(OrderItem.class),

  /**
   * 客户。
   */
  CLIENT(Client.class),

  /**
   * 客户订单。
   */
  CLIENT_ORDER(ClientOrder.class),

  /**
   * 退货单。
   */
  RETURN(Return.class),

  /**
   * 交易记录。
   */
  TRANSACTION(Transaction.class),

  /**
   * 支付记录。
   */
  PAYMENT(Payment.class),

  /**
   * 收货人。
   */
  CONSIGNEE(Consignee.class),

  /**
   * 疾病。
   */
  DISEASE(Disease.class),

  /**
   * 诊断。
   */
  DIAGNOSIS(Diagnosis.class),

  /**
   * 药品。
   */
  DRUG(Drug.class),

  /**
   * 药品商品关联。
   */
  DRUG_PRODUCT(DrugProduct.class),

  /**
   * 医院药店关联。
   */
  HOSPITAL_DRUGSTORE(HospitalDrugstore.class),

  /**
   * 患者。
   */
  PATIENT(Patient.class),

  /**
   * 处方单。
   */
  PRESCRIPTION(Prescription.class),

  /**
   * 处方项。
   */
  PRESCRIPTION_ITEM(PrescriptionItem.class),

  PRESCRIPTION_CONTENT(PrescriptionContent.class),

  ACCOUNT(Account.class),

  FAQ(Faq.class),

  ACTIVITY(Activity.class),

  ACTIVITY_COUPON(ActivityCoupon.class),

  ACTIVITY_PRODUCT_ITEM(ActivityProductItem.class),

  PAYLOAD(Payload.class),

  REFERER_ORDER_RECORD(RefererOrderRecord.class),

  REFERER_INFO(RefererInfo.class),

  APP_RESOURCE(AppResource.class),

  INSURANCE_CLAIM(InsuranceClaim.class),

  INSURANCE_CLAIM_INVOICE(InsuranceClaimInvoice.class),

  INSURANCE_CLAIM_AMOUNT(InsuranceClaimAmount.class),

  INSURANCE_CLAIM_MEDICAL(InsuranceClaimMedical.class),

  INSURANCE_CLAIM_EVENT(InsuranceClaimEvent.class),

  INSURANCE_PRODUCT_RULE(InsuranceProductRule.class),

  INSURANCE_CLAIM_INVOICE_COST(InsuranceClaimInvoiceCost.class),

  MQ_FAILED_TASK(MqFailedTask.class),

  ENTERPRISE_CLAIM(EnterpriseClaim.class),

  ENTERPRISE_CLAIM_MEDICAL(EnterpriseClaimMedical.class),

  ENTERPRISE_CLAIM_INVOICE(EnterpriseClaimInvoice.class),

  ENTERPRISE_CLAIM_ITEM(EnterpriseClaimItem.class),

  /**
   * 用户服务项目。
   */
  USER_SERVICE_TRADE(UserMedicalItem.class),

  /**
   * 预约。
   */
  APPOINTMENT(Appointment.class),

  /**
   * 医疗服务使用记录。
   */
  MEDICALITEMUSERECORD(MedicalItemUseRecord.class),

  MEDICAL_PACKAGE(MedicalPackage.class),

  MEDICAL_PACKAGE_ITEM(MedicalPackageItem.class),

  MEDICAL_ITEM(MedicalItem.class);

  private final Class<?> type;

  Entity(final Class<?> type) {
    this.type = type;
  }

  public Class<?> type() {
    return type;
  }

  public String code() {
    return name().toLowerCase();
  }

  static {
    registerLocalizedNames(Entity.class, "i18n/common-model/entity");
  }

  public String getLocalizedName() {
    return getLocalizedName(Locale.getDefault());
  }

  public String getLocalizedName(final Locale locale) {
    return EnumUtils.getLocalizedName(locale, this);
  }

  public Object deserializeJson(final String json,
          @Nullable final ObjectMapper mapper) throws IOException {
    final ObjectMapper theMapper = (mapper != null ? mapper : new ObjectMapper());
    try {
      return theMapper.readValue(json, type);
    } catch (final IOException e) {
      throw new InvalidJsonFormatException(json, e);
    }
  }

  public String normalizeJson(final String json, @Nullable final ObjectMapper mapper)
      throws IOException {
    final ObjectMapper theMapper = (mapper != null ? mapper : new ObjectMapper());
    try {
      final Object obj = theMapper.readValue(json, type);
      return theMapper.writeValueAsString(obj);
    } catch (final IOException e) {
      throw new InvalidJsonFormatException(json, e);
    }
  }

  private static final Map<ClassKey, Entity> TYPE_MAP = new HashMap<>();
  static {
    for (final Entity e : values()) {
      TYPE_MAP.put(new ClassKey(e.type), e);
    }
  }

  public static Entity forType(final Class<?> type) {
    return TYPE_MAP.get(new ClassKey(type));
  }
}
