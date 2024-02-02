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
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.annotation.Scale;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.Entity;
import ltd.qubit.model.util.Identifiable;

/**
 * 此模型表示商品项信息。
 *
 * <p>一个商品可以有一个或多个商品项，每一项表示某种规格的商品的信息，包括规格、
 * 图片、单价、库存、描述等。
 *
 * @author 胡海星
 */
public class ProductItem implements Identifiable, Assignable<ProductItem> {

  private static final long serialVersionUID = -1213830246907010882L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所属{@link Product}对象的ID。
   */
  @Reference(entity = Product.class, property = "id")
  private Long productId;

  /**
   * 在所属{@link Product}对象中的位置索引。
   */
  private Integer index;

  /**
   * 规格名称，同一产品下不重复。
   */
  @Size(min = 1, max = 256)
  @Unique(respectTo = "productId")
  private String specification;

  /**
   * 计价单位。
   */
  @Size(min = 1, max = 64)
  private String unit;

  /**
   * 重量，用于计算运费；保留小数点后4位数字。
   */
  @Scale(4)
  @Nullable
  private BigDecimal weight;

  /**
   * 生产编号。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String productionNumber;

  /**
   * 生产日期。
   */
  @Nullable
  private LocalDate productionDate;

  /**
   * 药品保质期。
   */
  @Nullable
  private Period shelfLife;

  /**
   * 图片。
   */
  @Size(min = 1, max = 512)
  @Nullable
  private String image;

  /**
   * 描述。
   */
  @Nullable
  private String description;

  /**
   * 单价，必须大于等于0，保留四位小数。
   */
  @Money
  private BigDecimal price;

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
   * 库存量，{@code null}表示无限。
   */
  @Nullable
  private Integer inventory;

  /**
   * 服务类型。
   */
  @Nullable
  private Entity serviceType;

  /**
   * 服务ID。
   */
  @Nullable
  private Long serviceId;

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

  public ProductItem() {
    // empty
  }

  public ProductItem(final ProductItem other) {
    assign(other);
  }

  @Override
  public void assign(final ProductItem other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    productId = other.productId;
    index = other.index;
    specification = other.specification;
    unit = other.unit;
    weight = other.weight;
    productionNumber = other.productionNumber;
    productionDate = other.productionDate;
    shelfLife = other.shelfLife;
    image = other.image;
    description = other.description;
    price = other.price;
    discount = other.discount;
    discountReason = other.discountReason;
    discountFrom = other.discountFrom;
    discountUntil = other.discountUntil;
    inventory = other.inventory;
    serviceType = other.serviceType;
    serviceId = other.serviceId;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public ProductItem clone() {
    return new ProductItem(this);
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(final Long id) {
    this.id = id;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(final Long productId) {
    this.productId = productId;
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex(final Integer index) {
    this.index = index;
  }

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(final String specification) {
    this.specification = specification;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(final String unit) {
    this.unit = unit;
  }

  @Nullable
  public BigDecimal getWeight() {
    return weight;
  }

  public void setWeight(@Nullable final BigDecimal weight) {
    this.weight = weight;
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

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(final BigDecimal price) {
    this.price = price;
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
  public Entity getServiceType() {
    return serviceType;
  }

  public void setServiceType(@Nullable final Entity serviceType) {
    this.serviceType = serviceType;
  }

  @Nullable
  public Long getServiceId() {
    return serviceId;
  }

  public void setServiceId(@Nullable final Long serviceId) {
    this.serviceId = serviceId;
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
    final ProductItem other = (ProductItem) o;
    return Equality.equals(id, other.id)
        && Equality.equals(productId, other.productId)
        && Equality.equals(index, other.index)
        && Equality.equals(specification, other.specification)
        && Equality.equals(unit, other.unit)
        && Equality.equals(weight, other.weight)
        && Equality.equals(productionNumber, other.productionNumber)
        && Equality.equals(productionDate, other.productionDate)
        && Equality.equals(shelfLife, other.shelfLife)
        && Equality.equals(image, other.image)
        && Equality.equals(description, other.description)
        && Equality.equals(price, other.price)
        && Equality.equals(discount, other.discount)
        && Equality.equals(discountReason, other.discountReason)
        && Equality.equals(discountFrom, other.discountFrom)
        && Equality.equals(discountUntil, other.discountUntil)
        && Equality.equals(inventory, other.inventory)
        && Equality.equals(serviceType, other.serviceType)
        && Equality.equals(serviceId, other.serviceId)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, productId);
    result = Hash.combine(result, multiplier, index);
    result = Hash.combine(result, multiplier, specification);
    result = Hash.combine(result, multiplier, unit);
    result = Hash.combine(result, multiplier, weight);
    result = Hash.combine(result, multiplier, productionNumber);
    result = Hash.combine(result, multiplier, productionDate);
    result = Hash.combine(result, multiplier, shelfLife);
    result = Hash.combine(result, multiplier, image);
    result = Hash.combine(result, multiplier, description);
    result = Hash.combine(result, multiplier, price);
    result = Hash.combine(result, multiplier, discount);
    result = Hash.combine(result, multiplier, discountReason);
    result = Hash.combine(result, multiplier, discountFrom);
    result = Hash.combine(result, multiplier, discountUntil);
    result = Hash.combine(result, multiplier, inventory);
    result = Hash.combine(result, multiplier, serviceType);
    result = Hash.combine(result, multiplier, serviceId);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("productId", productId)
        .append("index", index)
        .append("specification", specification)
        .append("unit", unit)
        .append("weight", weight)
        .append("productionNumber", productionNumber)
        .append("productionDate", productionDate)
        .append("shelfLife", shelfLife)
        .append("image", image)
        .append("description", description)
        .append("price", price)
        .append("discount", discount)
        .append("discountReason", discountReason)
        .append("discountFrom", discountFrom)
        .append("discountUntil", discountUntil)
        .append("inventory", inventory)
        .append("serviceType", serviceType)
        .append("serviceId", serviceId)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
