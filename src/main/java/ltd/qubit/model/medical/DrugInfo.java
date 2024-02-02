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
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.DictEntryInfo;
import ltd.qubit.model.util.HasInfo;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示药品基本信息。
 *
 * @author 胡海星
 */
public class DrugInfo implements HasInfo, Assignable<DrugInfo> {

  private static final long serialVersionUID = -1185779496483072698L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 编码，全局唯一。
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
   * 商品名称，经国家药品监督管理部门批准的特定企业使用的该药品的专用的商品名称。
   */
  @Size(min = 1, max = 256)
  private String productName;

  /**
   * 规格，药品的规格大小。
   */
  @Size(min = 1, max = 256)
  private String specification;

  /**
   * 剂型，为适应治疗或预防的需要而制备的药物的应用形式。
   */
  private DictEntryInfo dosageForm;

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
   * 制造商。
   */
  @Nullable
  private Info manufacturer;

  public DrugInfo() {
  }

  public DrugInfo(final DrugInfo other) {
    assign(other);
  }

  public DrugInfo(final Drug drug) {
    assign(drug);
  }

  @Override
  public void assign(final DrugInfo other) {
    this.id = other.id;
    this.code = other.code;
    this.name = other.name;
    this.productName = other.productName;
    this.specification = other.specification;
    this.dosageForm = Assignment.clone(other.dosageForm);
    this.unit = other.unit;
    this.packaging = other.packaging;
    this.basic = other.basic;
    this.otc = other.otc;
    this.antibiotics = other.antibiotics;
    this.restricted = other.restricted;
    this.herbalCompound = other.herbalCompound;
    this.brand = other.brand;
    this.origin = other.origin;
    this.manufacturer = Assignment.clone(other.manufacturer);
  }

  public void assign(final Drug drug) {
    this.id = drug.getId();
    this.code = drug.getCode();
    this.name = drug.getName();
    this.productName = drug.getProductName();
    this.specification = drug.getSpecification();
    this.dosageForm = drug.getDosageForm();
    this.unit = drug.getUnit();
    this.packaging = drug.getPackaging();
    this.basic = drug.isBasic();
    this.otc = drug.isOtc();
    this.antibiotics = drug.isAntibiotics();
    this.restricted = drug.isRestricted();
    this.herbalCompound = drug.isHerbalCompound();
    this.brand = drug.getBrand();
    this.origin = drug.getOrigin();
    this.manufacturer = drug.getManufacturer();
  }

  @Override
  public DrugInfo clone() {
    return new DrugInfo(this);
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

  public String getProductName() {
    return productName;
  }

  public void setProductName(final String productName) {
    this.productName = productName;
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

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final DrugInfo other = (DrugInfo) o;
    return Equality.equals(basic, other.basic)
            && Equality.equals(otc, other.otc)
            && Equality.equals(antibiotics, other.antibiotics)
            && Equality.equals(restricted, other.restricted)
            && Equality.equals(herbalCompound, other.herbalCompound)
            && Equality.equals(id, other.id)
            && Equality.equals(code, other.code)
            && Equality.equals(name, other.name)
            && Equality.equals(productName, other.productName)
            && Equality.equals(specification, other.specification)
            && Equality.equals(dosageForm, other.dosageForm)
            && Equality.equals(unit, other.unit)
            && Equality.equals(packaging, other.packaging)
            && Equality.equals(brand, other.brand)
            && Equality.equals(origin, other.origin)
            && Equality.equals(manufacturer, other.manufacturer);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, productName);
    result = Hash.combine(result, multiplier, specification);
    result = Hash.combine(result, multiplier, dosageForm);
    result = Hash.combine(result, multiplier, unit);
    result = Hash.combine(result, multiplier, packaging);
    result = Hash.combine(result, multiplier, basic);
    result = Hash.combine(result, multiplier, otc);
    result = Hash.combine(result, multiplier, antibiotics);
    result = Hash.combine(result, multiplier, restricted);
    result = Hash.combine(result, multiplier, herbalCompound);
    result = Hash.combine(result, multiplier, brand);
    result = Hash.combine(result, multiplier, origin);
    result = Hash.combine(result, multiplier, manufacturer);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("code", code)
            .append("name", name)
            .append("productName", productName)
            .append("specification", specification)
            .append("dosageForm", dosageForm)
            .append("unit", unit)
            .append("packaging", packaging)
            .append("basic", basic)
            .append("otc", otc)
            .append("antibiotics", antibiotics)
            .append("restricted", restricted)
            .append("herbalCompound", herbalCompound)
            .append("brand", brand)
            .append("origin", origin)
            .append("manufacturer", manufacturer)
            .toString();
  }
}
