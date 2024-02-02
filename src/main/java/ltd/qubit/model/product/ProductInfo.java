////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.annotation.Scale;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.util.HasInfo;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示所购买的商品的基本信息。
 *
 * @author 胡海星
 */
public class ProductInfo implements HasInfo, Assignable<ProductInfo> {

  private static final long serialVersionUID = -8547887137468682136L;

  /**
   * 对应的商品（{@link Product}）的ID。
   */
  @Identifier
  private Long id;

  /**
   * 对应的商品项（{@link ProductItem}）的ID。
   */
  @Reference(entity = ProductItem.class, property = "id")
  private Long itemId;

  /**
   * 商品名称，可重复。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 商品代码，同一App内不可重复。
   */
  @Size(min = 1, max = 64)
  private String code;

  /**
   * 商品质量。
   */
  private Quality quality;

  /**
   * 商品计价单位。
   */
  @Size(min = 1, max = 64)
  private String unit;

  /**
   * 商品规格。
   */
  @Size(min = 1, max = 256)
  private String specification;

  /**
   * 货币单位。
   */
  private Currency currency;

  /**
   * 商品单价，必须大于等于0，保留四位小数。
   */
  @Money
  private BigDecimal price;

  /**
   * 重量，用于计算运费。
   */
  @Scale(4)
  @Nullable
  private BigDecimal weight;

  /**
   * 商品图片。
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
   * 生产编号。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String productionNumber;

  /**
   * 商品生产日期。
   */
  @Nullable
  private LocalDate productionDate;

  /**
   * 商品保质期。
   */
  @Nullable
  private Period shelfLife;

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
   * 是否需要送货。
   */
  private Boolean needDelivery;

  /**
   * 是否允许退货。
   */
  private Boolean allowReturn;

  /**
   * 是否允许换货。
   */
  private Boolean allowChange;

  /**
   * 购买此商品是否需要提供客户信息，默认为{@code false}。
   */
  private Boolean needClient;

  /**
   * 折扣，必须大于等于0，保留四位小数。
   */
  @Money
  private BigDecimal discount;

  /**
   * 折扣原因。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String discountReason;

  /**
   * 折扣开始时间。
   */
  @Nullable
  private LocalDateTime discountFrom;

  /**
   * 折扣结束时间。
   */
  @Nullable
  private LocalDateTime discountUntil;

  /**
   * 该商品当前的库存量，{@code null}表示无限。
   *
   * <p>此字段无需被序列化到前端和数据库，仅用来记录从数据库中获取的数据。
   */
  @Nullable
  private Integer inventory;

  /**
   * 购买该商品的限制条件，{@code null}表示不作限制。
   *
   * <p>此字段无需被序列化到前端和数据库，仅用来记录从数据库中获取的数据。
   */
  @Nullable
  private ProductConstraint constraint;

  public ProductInfo() {
    // empty
  }

  public ProductInfo(final ProductInfo other) {
    assign(other);
  }

  public ProductInfo(final Product product, final String specification) {
    assign(product, specification);
  }

  public ProductInfo(final Product product, final ProductItem item) {
    assign(product, item);
  }

  @Override
  public void assign(final ProductInfo other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    itemId = other.itemId;
    name = other.name;
    code = other.code;
    quality = other.quality;
    unit = other.unit;
    specification = other.specification;
    currency = other.currency;
    price = other.price;
    weight = other.weight;
    image = other.image;
    description = other.description;
    brand = other.brand;
    origin = other.origin;
    manufacturer = Assignment.clone(other.manufacturer);
    seller = Assignment.clone(other.seller);
    productionNumber = other.productionNumber;
    productionDate = other.productionDate;
    shelfLife = other.shelfLife;
    saleFrom = other.saleFrom;
    saleUntil = other.saleUntil;
    validFrom = other.validFrom;
    validUntil = other.validUntil;
    needDelivery = other.needDelivery;
    allowReturn = other.allowReturn;
    allowChange = other.allowChange;
    needClient = other.needClient;
    discount = other.discount;
    discountReason = other.discountReason;
    discountFrom = other.discountFrom;
    discountUntil = other.discountUntil;
    inventory = other.inventory;
    constraint = Assignment.clone(other.constraint);
  }

  public void assign(final Product product, final String specification) {
    final ProductItem item = product.getItem(specification);
    // if (item == null) {
    //   throw new DataNotExistException(ProductItem.class, "specification", specification);
    // }
    if (item == null) {
      throw new IllegalArgumentException("No item with the specification '"
          + specification + "' in product " + product.getName()
          + " (" + product.getCode() + ").");
    }
    assign(product, item);
  }

  public void assign(final Product product, final ProductItem item) {
    this.id = product.getId();
    this.itemId = item.getId();
    this.name = product.getName();
    this.code = product.getCode();
    this.quality = product.getQuality();
    this.unit = item.getUnit();
    this.specification = item.getSpecification();
    this.currency = product.getCurrency();
    this.price = item.getPrice();
    this.weight = item.getWeight();
    this.image = (item.getImage() == null ? product.getImage() : item.getImage());
    this.description = (item.getDescription() == null
                        ? product.getDescription()
                        : item.getDescription());
    this.brand = product.getBrand();
    this.origin = product.getOrigin();
    this.manufacturer = Assignment.clone(product.getManufacturer());
    this.seller = Assignment.clone(product.getSeller());
    this.productionNumber = item.getProductionNumber();
    this.productionDate = item.getProductionDate();
    this.shelfLife = item.getShelfLife();
    this.saleFrom = product.getSaleFrom();
    this.saleUntil = product.getSaleUntil();
    this.validFrom = product.getValidFrom();
    this.validUntil = product.getValidUntil();
    this.needDelivery = product.isNeedDelivery();
    this.allowReturn = product.isAllowReturn();
    this.allowChange = product.isAllowChange();
    this.needClient = product.isNeedClient();
    this.discount = item.getDiscount();
    this.discountReason = item.getDiscountReason();
    this.discountFrom = item.getDiscountFrom();
    this.discountUntil = item.getDiscountUntil();
    this.inventory = item.getInventory();
    this.constraint = Assignment.clone(product.getConstraint());
  }

  @Override
  public ProductInfo clone() {
    return new ProductInfo(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getItemId() {
    return itemId;
  }

  public void setItemId(final Long itemId) {
    this.itemId = itemId;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  public Quality getQuality() {
    return quality;
  }

  public void setQuality(final Quality quality) {
    this.quality = quality;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(final String unit) {
    this.unit = unit;
  }

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(final String specification) {
    this.specification = specification;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(final Currency currency) {
    this.currency = currency;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(final BigDecimal price) {
    this.price = price;
  }

  @Nullable
  public BigDecimal getWeight() {
    return weight;
  }

  public void setWeight(@Nullable final BigDecimal weight) {
    this.weight = weight;
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

  @Nullable
  public String getProductionNumber() {
    return productionNumber;
  }

  public void setProductionNumber(@Nullable final String productionNumber) {
    this.productionNumber = productionNumber;
  }

  @Nullable
  public LocalDate getProductionDate() {
    return productionDate;
  }

  public void setProductionDate(@Nullable final LocalDate productionDate) {
    this.productionDate = productionDate;
  }

  @Nullable
  public Period getShelfLife() {
    return shelfLife;
  }

  public void setShelfLife(@Nullable final Period shelfLife) {
    this.shelfLife = shelfLife;
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

  public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(final BigDecimal discount) {
    this.discount = discount;
  }

  @Nullable
  public String getDiscountReason() {
    return discountReason;
  }

  public void setDiscountReason(@Nullable final String discountReason) {
    this.discountReason = discountReason;
  }

  @Nullable
  public LocalDateTime getDiscountFrom() {
    return discountFrom;
  }

  public void setDiscountFrom(@Nullable final LocalDateTime discountFrom) {
    this.discountFrom = discountFrom;
  }

  @Nullable
  public LocalDateTime getDiscountUntil() {
    return discountUntil;
  }

  public void setDiscountUntil(@Nullable final LocalDateTime discountUntil) {
    this.discountUntil = discountUntil;
  }

  @Nullable
  public Integer getInventory() {
    return inventory;
  }

  public void setInventory(@Nullable final Integer inventory) {
    this.inventory = inventory;
  }

  @Nullable
  public ProductConstraint getConstraint() {
    return constraint;
  }

  public void setConstraint(@Nullable final ProductConstraint constraint) {
    this.constraint = constraint;
  }

  // /**
  //  * 检查此对象各字段合法性。
  //  *
  //  * <p>TODO: 改用Validator接口实现
  //  */
  // public void checkField() {
  //   final Logger logger = LoggerFactory.getLogger(this.getClass());
  //   logger.info("Validating product info: {}", this);
  //   if (id == null) {
  //     logger.error("Product ID cannot be empty.");
  //     throw new NullFieldException(ProductInfo.class, ProductInfo::getId);
  //   }
  //   if (itemId == null) {
  //     logger.error("Product item ID cannot be empty.");
  //     throw new NullFieldException(ProductInfo.class, ProductInfo::getItemId);
  //   }
  //   if (isEmpty(name)) {
  //     logger.error("Product name cannot be empty.");
  //     throw new NullFieldException(ProductInfo.class, ProductInfo::getName);
  //   }
  //   if (isEmpty(code)) {
  //     logger.error("Product code cannot be empty.");
  //     throw new NullFieldException(ProductInfo.class, ProductInfo::getCode);
  //   }
  //   if (quality == null) {
  //     logger.error("Product quality cannot be empty.");
  //     throw new NullFieldException(ProductInfo.class, ProductInfo::getQuality);
  //   }
  //   if (isEmpty(unit)) {
  //     logger.error("Product unit cannot be empty.");
  //     throw new NullFieldException(ProductInfo.class, ProductInfo::getUnit);
  //   }
  //   if (isEmpty(specification)) {
  //     logger.error("Product specification cannot be empty.");
  //     throw new NullFieldException(ProductInfo.class, ProductInfo::getSpecification);
  //   }
  //   if (currency == null) {
  //     logger.error("Product currency cannot be empty.");
  //     throw new NullFieldException(ProductInfo.class, ProductInfo::getCurrency);
  //   }
  //   if (price == null) {
  //     logger.error("Product price cannot be empty.");
  //     throw new NullFieldException(ProductInfo.class, ProductInfo::getPrice);
  //   }
  //   if (price.signum() < 0) {
  //     logger.error("Product price cannot be negative.");
  //     throw new InvalidFieldFormatException("productPrice", price);
  //   }
  //   // TODO: 还需验证其他字段吗？
  // }
  //
  // /**
  //  * 检查此商品是否仍在销售期内。
  //  *
  //  * @param now
  //  *     当前日期时间，必须考虑当前系统时区。
  //  */
  // public void checkSalePeriod(final LocalDateTime now) {
  //   final Logger logger = LoggerFactory.getLogger(this.getClass());
  //   logger.info("Checking sale period of product: now = {}, product = {}", now, this);
  //   if (now.isBefore(saleFrom)) {
  //     logger.error("The selling of the product {} ({}) has not started: "
  //             + "now = {}, from = {}, until = {}", name, code, now,
  //         saleFrom, saleUntil);
  //     throw new SellingNotStartException(now, saleFrom, saleUntil);
  //   }
  //   if (null != saleUntil && now.isAfter(saleUntil)) {
  //     logger.error("The selling of the product {} ({}) was over: "
  //             + "now = {}, from = {}, until = {}", name, code, now,
  //         saleFrom, saleUntil);
  //     throw new SellingHasEndException(now, saleFrom, saleUntil);
  //   }
  // }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final ProductInfo other = (ProductInfo) o;
    return Equality.equals(id, other.id)
        && Equality.equals(itemId, other.itemId)
        && Equality.equals(name, other.name)
        && Equality.equals(code, other.code)
        && Equality.equals(quality, other.quality)
        && Equality.equals(unit, other.unit)
        && Equality.equals(specification, other.specification)
        && Equality.equals(currency, other.currency)
        && Equality.equals(price, other.price)
        && Equality.equals(weight, other.weight)
        && Equality.equals(image, other.image)
        && Equality.equals(description, other.description)
        && Equality.equals(brand, other.brand)
        && Equality.equals(origin, other.origin)
        && Equality.equals(manufacturer, other.manufacturer)
        && Equality.equals(seller, other.seller)
        && Equality.equals(productionNumber, other.productionNumber)
        && Equality.equals(productionDate, other.productionDate)
        && Equality.equals(shelfLife, other.shelfLife)
        && Equality.equals(saleFrom, other.saleFrom)
        && Equality.equals(saleUntil, other.saleUntil)
        && Equality.equals(validFrom, other.validFrom)
        && Equality.equals(validUntil, other.validUntil)
        && Equality.equals(needDelivery, other.needDelivery)
        && Equality.equals(allowReturn, other.allowReturn)
        && Equality.equals(allowChange, other.allowChange)
        && Equality.equals(needClient, other.needClient)
        && Equality.equals(discount, other.discount)
        && Equality.equals(discountReason, other.discountReason)
        && Equality.equals(discountFrom, other.discountFrom)
        && Equality.equals(discountUntil, other.discountUntil)
        && Equality.equals(inventory, other.inventory)
        && Equality.equals(constraint, other.constraint);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, itemId);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, quality);
    result = Hash.combine(result, multiplier, unit);
    result = Hash.combine(result, multiplier, specification);
    result = Hash.combine(result, multiplier, currency);
    result = Hash.combine(result, multiplier, price);
    result = Hash.combine(result, multiplier, weight);
    result = Hash.combine(result, multiplier, image);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, brand);
    result = Hash.combine(result, multiplier, origin);
    result = Hash.combine(result, multiplier, manufacturer);
    result = Hash.combine(result, multiplier, seller);
    result = Hash.combine(result, multiplier, productionNumber);
    result = Hash.combine(result, multiplier, productionDate);
    result = Hash.combine(result, multiplier, shelfLife);
    result = Hash.combine(result, multiplier, saleFrom);
    result = Hash.combine(result, multiplier, saleUntil);
    result = Hash.combine(result, multiplier, validFrom);
    result = Hash.combine(result, multiplier, validUntil);
    result = Hash.combine(result, multiplier, needDelivery);
    result = Hash.combine(result, multiplier, allowReturn);
    result = Hash.combine(result, multiplier, allowChange);
    result = Hash.combine(result, multiplier, needClient);
    result = Hash.combine(result, multiplier, discount);
    result = Hash.combine(result, multiplier, discountReason);
    result = Hash.combine(result, multiplier, discountFrom);
    result = Hash.combine(result, multiplier, discountUntil);
    result = Hash.combine(result, multiplier, inventory);
    result = Hash.combine(result, multiplier, constraint);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("itemId", itemId)
        .append("name", name)
        .append("code", code)
        .append("quality", quality)
        .append("unit", unit)
        .append("specification", specification)
        .append("currency", currency)
        .append("price", price)
        .append("weight", weight)
        .append("image", image)
        .append("description", description)
        .append("brand", brand)
        .append("origin", origin)
        .append("manufacturer", manufacturer)
        .append("seller", seller)
        .append("productionNumber", productionNumber)
        .append("productionDate", productionDate)
        .append("shelfLife", shelfLife)
        .append("saleFrom", saleFrom)
        .append("saleUntil", saleUntil)
        .append("validFrom", validFrom)
        .append("validUntil", validUntil)
        .append("needDelivery", needDelivery)
        .append("allowReturn", allowReturn)
        .append("allowChange", allowChange)
        .append("needClient", needClient)
        .append("discount", discount)
        .append("discountReason", discountReason)
        .append("discountFrom", discountFrom)
        .append("discountUntil", discountUntil)
        .append("inventory", inventory)
        .append("constraint", constraint)
        .toString();
  }
}
