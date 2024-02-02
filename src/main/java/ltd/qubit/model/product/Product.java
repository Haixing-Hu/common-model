////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.product;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.commons.Category;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.commons.State;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.HasInfo;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.InfoWithEntity;
import ltd.qubit.model.util.Stateful;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;
import ltd.qubit.model.util.WithCategory;

/**
 * 此模型表示商品基本信息。
 *
 * @author 胡海星
 */
public class Product implements HasInfo, WithApp, WithCategory, Stateful,
    Auditable, Assignable<Product> {

  private static final long serialVersionUID = -657073618015597565L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 商品代码，同一App内不可重复。
   */
  @Size(min = 1, max = 64)
  @Unique(respectTo = "app")
  private String code;

  /**
   * 商品名称，可重复。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 所属 App 的基本信息。
   */
  @Reference(entity = App.class, property = "info")
  private StatefulInfo app;

  /**
   * 商品所属类别的基本信息。
   */
  @Reference(entity = Category.class, property = "info")
  @Nullable
  private InfoWithEntity category;

  /**
   * 产品质量。
   */
  private Quality quality;

  /**
   * 货币单位。
   */
  private Currency currency;

  /**
   * 商品主图片。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String image;

  /**
   * 商品概要描述。
   */
  @Nullable
  private String description;

  /**
   * 商品或服务有效期开始日期时间。
   */
  @Nullable
  private LocalDateTime validFrom;

  /**
   * 商品或服务有效期结束日期时间。
   */
  @Nullable
  private LocalDateTime validUntil;

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
   * 制造商的基本信息。
   */
  @Nullable
  private Info manufacturer;

  /**
   * 销售商。
   */
  private Info seller;

  /**
   * 开始销售日期时间。
   */
  private LocalDateTime saleFrom;

  /**
   * 销售结束日期时间。
   */
  @Nullable
  private LocalDateTime saleUntil;

  /**
   * 是否需要送货，默认为{@code true}。
   */
  private Boolean needDelivery;

  /**
   * 是否允许退货，默认为{@code true}。
   */
  private Boolean allowReturn;

  /**
   * 是否允许换货，默认为{@code true}。
   */
  private Boolean allowChange;

  /**
   * 购买此商品是否需要提供客户信息，默认为{@code false}。
   */
  private Boolean needClient;

  /**
   * 购买该商品的限制条件，{@code null}表示不作限制。
   */
  @Nullable
  private ProductConstraint constraint;

  /**
   * 商品项列表。
   */
  @Size(min = 1, max = 8)
  private List<ProductItem> items;

  /**
   * 对象状态。
   */
  private State state = State.NORMAL;

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
   * 标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public Product() {
    // empty
  }

  public Product(final Product other) {
    assign(other);
  }

  @Override
  public void assign(final Product other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    code = other.code;
    name = other.name;
    app = Assignment.clone(other.app);
    category = Assignment.clone(other.category);
    quality = other.quality;
    currency = other.currency;
    image = other.image;
    description = other.description;
    validFrom = other.validFrom;
    validUntil = other.validUntil;
    brand = other.brand;
    origin = other.origin;
    manufacturer = Assignment.clone(other.manufacturer);
    seller = Assignment.clone(other.seller);
    saleFrom = other.saleFrom;
    saleUntil = other.saleUntil;
    needDelivery = other.needDelivery;
    allowReturn = other.allowReturn;
    allowChange = other.allowChange;
    needClient = other.needClient;
    constraint = Assignment.clone(other.constraint);
    items = Assignment.deepClone(other.items);
    state = other.state;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Product clone() {
    return new Product(this);
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

  public StatefulInfo getApp() {
    return app;
  }

  public void setApp(final StatefulInfo app) {
    this.app = app;
  }

  @Nullable
  public InfoWithEntity getCategory() {
    return category;
  }

  public void setCategory(@Nullable final InfoWithEntity category) {
    this.category = category;
  }

  public Quality getQuality() {
    return quality;
  }

  public void setQuality(final Quality quality) {
    this.quality = quality;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(final Currency currency) {
    this.currency = currency;
  }

  @Nullable
  public String getImage() {
    return image;
  }

  public void setImage(@Nullable final String image) {
    this.image = image;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable final String description) {
    this.description = description;
  }

  @Nullable
  public LocalDateTime getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(@Nullable final LocalDateTime validFrom) {
    this.validFrom = validFrom;
  }

  @Nullable
  public LocalDateTime getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(@Nullable final LocalDateTime validUntil) {
    this.validUntil = validUntil;
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

  public Info getSeller() {
    return seller;
  }

  public void setSeller(final Info seller) {
    this.seller = seller;
  }

  public LocalDateTime getSaleFrom() {
    return saleFrom;
  }

  public void setSaleFrom(final LocalDateTime saleFrom) {
    this.saleFrom = saleFrom;
  }

  @Nullable
  public LocalDateTime getSaleUntil() {
    return saleUntil;
  }

  public void setSaleUntil(@Nullable final LocalDateTime saleUntil) {
    this.saleUntil = saleUntil;
  }

  public Boolean isNeedDelivery() {
    return needDelivery;
  }

  public void setNeedDelivery(final Boolean needDelivery) {
    this.needDelivery = needDelivery;
  }

  public Boolean isAllowReturn() {
    return allowReturn;
  }

  public void setAllowReturn(final Boolean allowReturn) {
    this.allowReturn = allowReturn;
  }

  public Boolean isAllowChange() {
    return allowChange;
  }

  public void setAllowChange(final Boolean allowChange) {
    this.allowChange = allowChange;
  }

  public Boolean isNeedClient() {
    return needClient;
  }

  public void setNeedClient(final Boolean needClient) {
    this.needClient = needClient;
  }

  @Nullable
  public ProductConstraint getConstraint() {
    return constraint;
  }

  public void setConstraint(@Nullable final ProductConstraint constraint) {
    this.constraint = constraint;
  }

  public List<ProductItem> getItems() {
    return items;
  }

  public void setItems(final List<ProductItem> items) {
    this.items = items;
  }

  public State getState() {
    return state;
  }

  public void setState(final State state) {
    this.state = state;
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

  /**
   * 获取指定规格的产品项。
   *
   * @param specification
   *     指定的规格。
   * @return
   *     指定规格的产品项，或{@code null}如果不存在该产品项。
   */
  public ProductItem getItem(final String specification) {
    if (items != null) {
      for (final ProductItem item : items) {
        if (Equality.equals(item.getSpecification(), specification)) {
          return item;
        }
      }
    }
    return null;
  }

  /**
   * 获取指定规格的产品项的基本信息。
   *
   * @param specification
   *     指定的规格。
   * @return
   *     指定规格的产品项的基本信息，或{@code null}如果不存在该产品项。
   */
  public ProductInfo getInfo(final String specification) {
    if (items == null) {
      return null;
    }
    for (final ProductItem item : items) {
      if (Equality.equals(specification, item.getSpecification())) {
        final ProductInfo result = new ProductInfo();
        result.setId(id);
        result.setItemId(item.getId());
        result.setName(name);
        result.setCode(code);
        result.setQuality(quality);
        result.setUnit(item.getUnit());
        result.setSpecification(specification);
        result.setCurrency(currency);
        result.setPrice(item.getPrice());
        result.setWeight(item.getWeight());
        result.setImage(item.getImage() != null ? item.getImage() : image);
        result.setDescription(item.getDescription() != null
                            ? item.getDescription()
                            : description);
        result.setBrand(brand);
        result.setOrigin(origin);
        result.setManufacturer(Assignment.clone(manufacturer));
        result.setProductionNumber(item.getProductionNumber());
        result.setProductionDate(item.getProductionDate());
        result.setShelfLife(item.getShelfLife());
        result.setSaleFrom(saleFrom);
        result.setSaleUntil(saleUntil);
        result.setValidFrom(validFrom);
        result.setValidUntil(validUntil);
        result.setNeedDelivery(needDelivery);
        result.setAllowChange(allowChange);
        result.setAllowReturn(allowReturn);
        result.setNeedClient(needClient);
        result.setDiscount(item.getDiscount());
        result.setDiscountReason(item.getDiscountReason());
        result.setDiscountFrom(item.getDiscountFrom());
        result.setDiscountUntil(item.getDiscountUntil());
        result.setInventory(item.getInventory());
        result.setConstraint(Assignment.clone(constraint));
        return result;
      }
    }
    return null;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Product other = (Product) o;
    return Equality.equals(id, other.id)
        && Equality.equals(code, other.code)
        && Equality.equals(name, other.name)
        && Equality.equals(app, other.app)
        && Equality.equals(category, other.category)
        && Equality.equals(quality, other.quality)
        && Equality.equals(currency, other.currency)
        && Equality.equals(image, other.image)
        && Equality.equals(description, other.description)
        && Equality.equals(validFrom, other.validFrom)
        && Equality.equals(validUntil, other.validUntil)
        && Equality.equals(brand, other.brand)
        && Equality.equals(origin, other.origin)
        && Equality.equals(manufacturer, other.manufacturer)
        && Equality.equals(seller, other.seller)
        && Equality.equals(saleFrom, other.saleFrom)
        && Equality.equals(saleUntil, other.saleUntil)
        && Equality.equals(needDelivery, other.needDelivery)
        && Equality.equals(allowReturn, other.allowReturn)
        && Equality.equals(allowChange, other.allowChange)
        && Equality.equals(needClient, other.needClient)
        && Equality.equals(constraint, other.constraint)
        && Equality.equals(items, other.items)
        && Equality.equals(state, other.state)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, category);
    result = Hash.combine(result, multiplier, quality);
    result = Hash.combine(result, multiplier, currency);
    result = Hash.combine(result, multiplier, image);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, validFrom);
    result = Hash.combine(result, multiplier, validUntil);
    result = Hash.combine(result, multiplier, brand);
    result = Hash.combine(result, multiplier, origin);
    result = Hash.combine(result, multiplier, manufacturer);
    result = Hash.combine(result, multiplier, seller);
    result = Hash.combine(result, multiplier, saleFrom);
    result = Hash.combine(result, multiplier, saleUntil);
    result = Hash.combine(result, multiplier, needDelivery);
    result = Hash.combine(result, multiplier, allowReturn);
    result = Hash.combine(result, multiplier, allowChange);
    result = Hash.combine(result, multiplier, needClient);
    result = Hash.combine(result, multiplier, constraint);
    result = Hash.combine(result, multiplier, items);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("code", code)
        .append("name", name)
        .append("app", app)
        .append("category", category)
        .append("quality", quality)
        .append("currency", currency)
        .append("image", image)
        .append("description", description)
        .append("validFrom", validFrom)
        .append("validUntil", validUntil)
        .append("brand", brand)
        .append("origin", origin)
        .append("manufacturer", manufacturer)
        .append("seller", seller)
        .append("saleFrom", saleFrom)
        .append("saleUntil", saleUntil)
        .append("needDelivery", needDelivery)
        .append("allowReturn", allowReturn)
        .append("allowChange", allowChange)
        .append("needClient", needClient)
        .append("constraint", constraint)
        .append("items", items)
        .append("state", state)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
