////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.DictEntryInfo;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.HasInfo;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.Predefinable;

/**
 * 此模型表示药品基本信息。
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
public class Drug implements HasInfo, Predefinable, Auditable, Assignable<Drug> {

  private static final long serialVersionUID = -6710458543331978717L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 内部编码，全局唯一。
   */
  @Size(min = 1, max = 64)
  @Unique
  private String code;

  /**
   * 通用名称，国家药品标准中收录的药品名称。
   */
  @Size(min = 1, max = 256)
  private String name;

  /**
   * 所属类别。
   */
  @Nullable
  private Info category;

  /**
   * 商品名称，经国家药品监督管理部门批准的特定企业使用的该药品的专用的商品名称。
   */
  @Size(min = 1, max = 256)
  private String productName;

  /**
   * 英文名称，药品通用名称的英文名称。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String englishName;

  /**
   * 拼音名称，药品通用名称的汉语拼音名称。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String pinyinName;

  /**
   * 化学名称，药品的化学名称。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String chemicalName;

  /**
   * 规格，药品的规格大小。
   */
  @Size(min = 1, max = 256)
  private String specification;

  /**
   * 剂型，为适应治疗或预防的需要而制备的药物的应用形式，字典条目。
   */
  private DictEntryInfo dosageForm;

  /**
   * 用药途径，字典条目。
   */
  @Nullable
  private DictEntryInfo administrationRoute;

  /**
   * 用药频率，字典条目。
   */
  @Nullable
  private DictEntryInfo frequency;

  /**
   * 标准单位。
   */
  @Size(min = 1, max = 64)
  private String unit;

  /**
   * 包装，药品的包装方式。
   */
  @Size(min = 1, max = 64)
  private String packaging;

  /**
   * 是否是基药。
   */
  private Boolean basic;

  /**
   * 是否是非处方药。
   */
  private Boolean otc;

  /**
   * 是否是抗生素。
   */
  private Boolean antibiotics;

  /**
   * 是否是限制用药。
   */
  private Boolean restricted;

  /**
   * 是否是单复方草药。
   */
  private Boolean herbalCompound;

  /**
   * 是否是特供药。
   */
  private Boolean special;

  /**
   * 性状，对药品的颜色、性状或味道等特征的描述。
   */
  @Nullable
  private String characteristics;

  /**
   * 成分，药品的组成成分。
   */
  @Nullable
  private String composition;

  /**
   * 适应症，宜采用此药品的病症。
   */
  @Nullable
  private String indications;

  /**
   * 用法用量，服用药物的具体方法和剂量。
   */
  @Nullable
  private String dosage;

  /**
   * 不良反应，服用药物时身体发生的不良症状。
   */
  @Nullable
  private String adverseReaction;

  /**
   * 禁忌，用药上应避免的事物。
   */
  @Nullable
  private String contraindications;

  /**
   * 注意事项，服用药品时应注意的事项。
   */
  @Nullable
  private String precautions;

  /**
   * 贮藏，药品的存放方式。
   */
  @Nullable
  private String storage;

  /**
   * 批准文号，国内药品生产企业在生产药品前报请国家药品监督管理部门批准后获得的身份证明。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String licenseNumber;

  /**
   * 批准日期。
   */
  @Nullable
  private LocalDate licenseDate;

  /**
   * 进口注册证号，进口药品经国家药品监督管理部门组织审查批准颁发的证书编号。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String importNumber;

  /**
   * 注册证号，港澳台企业生产的药品所取得的注册证书编号。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String registrationNumber;

  /**
   * 品牌。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String brand;

  /**
   * 产地。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String origin;

  /**
   * 制造商基本信息。
   */
  @Nullable
  private Info manufacturer;

  /**
   * 药品分类。
   */
  @Nullable
  private DictEntryInfo classification;

  /**
   * 药品保质期。
   */
  @Nullable
  private Period shelfLife;

  /**
   * 备注信息。
   */
  @Nullable
  private String comment;

  /**
   * 是否是预定义的数据。
   */
  private Boolean predefined;

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

  public Drug() {
    // empty
  }

  public Drug(final Drug other) {
    assign(other);
  }

  @Override
  public void assign(final Drug other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    name = other.name;
    category = Assignment.clone(other.category);
    productName = other.productName;
    englishName = other.englishName;
    pinyinName = other.pinyinName;
    chemicalName = other.chemicalName;
    specification = other.specification;
    dosageForm = Assignment.clone(other.dosageForm);
    administrationRoute = Assignment.clone(other.administrationRoute);
    frequency = Assignment.clone(other.frequency);
    unit = other.unit;
    packaging = other.packaging;
    basic = other.basic;
    otc = other.otc;
    antibiotics = other.antibiotics;
    restricted = other.restricted;
    herbalCompound = other.herbalCompound;
    special = other.special;
    characteristics = other.characteristics;
    composition = other.composition;
    indications = other.indications;
    dosage = other.dosage;
    adverseReaction = other.adverseReaction;
    contraindications = other.contraindications;
    precautions = other.precautions;
    storage = other.storage;
    licenseNumber = other.licenseNumber;
    licenseDate = other.licenseDate;
    importNumber = other.importNumber;
    registrationNumber = other.registrationNumber;
    brand = other.brand;
    origin = other.origin;
    manufacturer = Assignment.clone(other.manufacturer);
    classification = Assignment.clone(other.classification);
    shelfLife = other.shelfLife;
    comment = other.comment;
    predefined = other.predefined;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Drug clone() {
    return new Drug(this);
  }

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

  @Nullable
  public Info getCategory() {
    return category;
  }

  public void setCategory(@Nullable final Info category) {
    this.category = category;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(final String productName) {
    this.productName = productName;
  }

  @Nullable
  public String getEnglishName() {
    return englishName;
  }

  public void setEnglishName(@Nullable final String englishName) {
    this.englishName = englishName;
  }

  @Nullable
  public String getPinyinName() {
    return pinyinName;
  }

  public void setPinyinName(@Nullable final String pinyinName) {
    this.pinyinName = pinyinName;
  }

  @Nullable
  public String getChemicalName() {
    return chemicalName;
  }

  public void setChemicalName(@Nullable final String chemicalName) {
    this.chemicalName = chemicalName;
  }

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(final String specification) {
    this.specification = specification;
  }

  public DictEntryInfo getDosageForm() {
    return dosageForm;
  }

  public void setDosageForm(final DictEntryInfo dosageForm) {
    this.dosageForm = dosageForm;
  }

  @Nullable
  public DictEntryInfo getAdministrationRoute() {
    return administrationRoute;
  }

  public void setAdministrationRoute(@Nullable final DictEntryInfo administrationRoute) {
    this.administrationRoute = administrationRoute;
  }

  @Nullable
  public DictEntryInfo getFrequency() {
    return frequency;
  }

  public void setFrequency(@Nullable final DictEntryInfo frequency) {
    this.frequency = frequency;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(final String unit) {
    this.unit = unit;
  }

  public String getPackaging() {
    return packaging;
  }

  public void setPackaging(final String packaging) {
    this.packaging = packaging;
  }

  public Boolean isBasic() {
    return basic;
  }

  public void setBasic(final Boolean basic) {
    this.basic = basic;
  }

  public Boolean isOtc() {
    return otc;
  }

  public void setOtc(final Boolean otc) {
    this.otc = otc;
  }

  public Boolean isAntibiotics() {
    return antibiotics;
  }

  public void setAntibiotics(final Boolean antibiotics) {
    this.antibiotics = antibiotics;
  }

  public Boolean isRestricted() {
    return restricted;
  }

  public void setRestricted(final Boolean restricted) {
    this.restricted = restricted;
  }

  public Boolean isHerbalCompound() {
    return herbalCompound;
  }

  public void setHerbalCompound(final Boolean herbalCompound) {
    this.herbalCompound = herbalCompound;
  }

  public Boolean isSpecial() {
    return special;
  }

  public void setSpecial(final Boolean special) {
    this.special = special;
  }

  @Nullable
  public String getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(@Nullable final String characteristics) {
    this.characteristics = characteristics;
  }

  @Nullable
  public String getComposition() {
    return composition;
  }

  public void setComposition(@Nullable final String composition) {
    this.composition = composition;
  }

  @Nullable
  public String getIndications() {
    return indications;
  }

  public void setIndications(@Nullable final String indications) {
    this.indications = indications;
  }

  @Nullable
  public String getDosage() {
    return dosage;
  }

  public void setDosage(@Nullable final String dosage) {
    this.dosage = dosage;
  }

  @Nullable
  public String getAdverseReaction() {
    return adverseReaction;
  }

  public void setAdverseReaction(@Nullable final String adverseReaction) {
    this.adverseReaction = adverseReaction;
  }

  @Nullable
  public String getContraindications() {
    return contraindications;
  }

  public void setContraindications(@Nullable final String contraindications) {
    this.contraindications = contraindications;
  }

  @Nullable
  public String getPrecautions() {
    return precautions;
  }

  public void setPrecautions(@Nullable final String precautions) {
    this.precautions = precautions;
  }

  @Nullable
  public String getStorage() {
    return storage;
  }

  public void setStorage(@Nullable final String storage) {
    this.storage = storage;
  }

  @Nullable
  public String getLicenseNumber() {
    return licenseNumber;
  }

  public void setLicenseNumber(@Nullable final String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  @Nullable
  public LocalDate getLicenseDate() {
    return licenseDate;
  }

  public void setLicenseDate(@Nullable final LocalDate licenseDate) {
    this.licenseDate = licenseDate;
  }

  @Nullable
  public String getImportNumber() {
    return importNumber;
  }

  public void setImportNumber(@Nullable final String importNumber) {
    this.importNumber = importNumber;
  }

  @Nullable
  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(@Nullable final String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  @Nullable
  public String getBrand() {
    return brand;
  }

  public void setBrand(@Nullable final String brand) {
    this.brand = brand;
  }

  @Nullable
  public String getOrigin() {
    return origin;
  }

  public void setOrigin(@Nullable final String origin) {
    this.origin = origin;
  }

  @Nullable
  public Info getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(@Nullable final Info manufacturer) {
    this.manufacturer = manufacturer;
  }

  @Nullable
  public DictEntryInfo getClassification() {
    return classification;
  }

  public void setClassification(@Nullable final DictEntryInfo classification) {
    this.classification = classification;
  }

  @Nullable
  public Period getShelfLife() {
    return shelfLife;
  }

  public void setShelfLife(@Nullable final Period shelfLife) {
    this.shelfLife = shelfLife;
  }

  @Nullable
  public String getComment() {
    return comment;
  }

  public void setComment(@Nullable final String comment) {
    this.comment = comment;
  }

  public Boolean isPredefined() {
    return predefined;
  }

  public void setPredefined(final Boolean predefined) {
    this.predefined = predefined;
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
    final Drug other = (Drug) o;
    return Equality.equals(basic, other.basic)
            && Equality.equals(otc, other.otc)
            && Equality.equals(antibiotics, other.antibiotics)
            && Equality.equals(restricted, other.restricted)
            && Equality.equals(herbalCompound, other.herbalCompound)
            && Equality.equals(special, other.special)
            && Equality.equals(predefined, other.predefined)
            && Equality.equals(id, other.id)
            && Equality.equals(code, other.code)
            && Equality.equals(name, other.name)
            && Equality.equals(category, other.category)
            && Equality.equals(productName, other.productName)
            && Equality.equals(englishName, other.englishName)
            && Equality.equals(pinyinName, other.pinyinName)
            && Equality.equals(chemicalName, other.chemicalName)
            && Equality.equals(specification, other.specification)
            && Equality.equals(dosageForm, other.dosageForm)
            && Equality.equals(administrationRoute, other.administrationRoute)
            && Equality.equals(frequency, other.frequency)
            && Equality.equals(unit, other.unit)
            && Equality.equals(packaging, other.packaging)
            && Equality.equals(characteristics, other.characteristics)
            && Equality.equals(composition, other.composition)
            && Equality.equals(indications, other.indications)
            && Equality.equals(dosage, other.dosage)
            && Equality.equals(adverseReaction, other.adverseReaction)
            && Equality.equals(contraindications, other.contraindications)
            && Equality.equals(precautions, other.precautions)
            && Equality.equals(storage, other.storage)
            && Equality.equals(licenseNumber, other.licenseNumber)
            && Equality.equals(licenseDate, other.licenseDate)
            && Equality.equals(importNumber, other.importNumber)
            && Equality.equals(registrationNumber, other.registrationNumber)
            && Equality.equals(brand, other.brand)
            && Equality.equals(origin, other.origin)
            && Equality.equals(manufacturer, other.manufacturer)
            && Equality.equals(classification, other.classification)
            && Equality.equals(shelfLife, other.shelfLife)
            && Equality.equals(comment, other.comment)
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
    result = Hash.combine(result, multiplier, category);
    result = Hash.combine(result, multiplier, productName);
    result = Hash.combine(result, multiplier, englishName);
    result = Hash.combine(result, multiplier, pinyinName);
    result = Hash.combine(result, multiplier, chemicalName);
    result = Hash.combine(result, multiplier, specification);
    result = Hash.combine(result, multiplier, dosageForm);
    result = Hash.combine(result, multiplier, administrationRoute);
    result = Hash.combine(result, multiplier, frequency);
    result = Hash.combine(result, multiplier, unit);
    result = Hash.combine(result, multiplier, packaging);
    result = Hash.combine(result, multiplier, basic);
    result = Hash.combine(result, multiplier, otc);
    result = Hash.combine(result, multiplier, antibiotics);
    result = Hash.combine(result, multiplier, restricted);
    result = Hash.combine(result, multiplier, herbalCompound);
    result = Hash.combine(result, multiplier, special);
    result = Hash.combine(result, multiplier, characteristics);
    result = Hash.combine(result, multiplier, composition);
    result = Hash.combine(result, multiplier, indications);
    result = Hash.combine(result, multiplier, dosage);
    result = Hash.combine(result, multiplier, adverseReaction);
    result = Hash.combine(result, multiplier, contraindications);
    result = Hash.combine(result, multiplier, precautions);
    result = Hash.combine(result, multiplier, storage);
    result = Hash.combine(result, multiplier, licenseNumber);
    result = Hash.combine(result, multiplier, licenseDate);
    result = Hash.combine(result, multiplier, importNumber);
    result = Hash.combine(result, multiplier, registrationNumber);
    result = Hash.combine(result, multiplier, brand);
    result = Hash.combine(result, multiplier, origin);
    result = Hash.combine(result, multiplier, manufacturer);
    result = Hash.combine(result, multiplier, classification);
    result = Hash.combine(result, multiplier, shelfLife);
    result = Hash.combine(result, multiplier, comment);
    result = Hash.combine(result, multiplier, predefined);
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
            .append("category", category)
            .append("productName", productName)
            .append("englishName", englishName)
            .append("pinyinName", pinyinName)
            .append("chemicalName", chemicalName)
            .append("specification", specification)
            .append("dosageForm", dosageForm)
            .append("administrationRoute", administrationRoute)
            .append("frequency", frequency)
            .append("unit", unit)
            .append("packaging", packaging)
            .append("basic", basic)
            .append("otc", otc)
            .append("antibiotics", antibiotics)
            .append("restricted", restricted)
            .append("herbalCompound", herbalCompound)
            .append("special", special)
            .append("characteristics", characteristics)
            .append("composition", composition)
            .append("indications", indications)
            .append("dosage", dosage)
            .append("adverseReaction", adverseReaction)
            .append("contraindications", contraindications)
            .append("precautions", precautions)
            .append("storage", storage)
            .append("licenseNumber", licenseNumber)
            .append("licenseDate", licenseDate)
            .append("importNumber", importNumber)
            .append("registrationNumber", registrationNumber)
            .append("brand", brand)
            .append("origin", origin)
            .append("manufacturer", manufacturer)
            .append("classification", classification)
            .append("shelfLife", shelfLife)
            .append("comment", comment)
            .append("predefined", predefined)
            .append("createTime", createTime)
            .append("modifyTime", modifyTime)
            .append("deleteTime", deleteTime)
            .toString();
  }
}
