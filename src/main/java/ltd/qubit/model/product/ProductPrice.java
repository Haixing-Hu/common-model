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
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示商品在不同渠道来源的价格信息。
 *
 * @author 孙建，胡海星
 */
public class ProductPrice implements Identifiable, Auditable,
    Assignable<ProductPrice> {

  private static final long serialVersionUID = -6273844825907616301L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 商品ID。
   */
  @Reference(entity = Product.class, property = "id")
  private Long productId;

  /**
   * 商品项ID。
   */
  @Reference(entity = ProductItem.class, property = "id")
  private Long productItemId;

  /**
   * 商品代码，同一App内不可重复。
   */
  @Size(min = 1, max = 64)
  @Unique
  private String code;

  /**
   * 商品名称，可重复。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 商品规格，同一商品下不重复。
   */
  @Size(min = 1, max = 256)
  @Unique(respectTo = "productId")
  private String specification;

  /**
   * 来源。
   */
  private Info source;

  /**
   * 单价，必须大于等于0，保留四位小数。
   */
  @Money
  private BigDecimal price;

  /**
   * 单价折扣，必须大于等于0，保留四位小数。
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

  public ProductPrice() {
    // empty
  }

  public ProductPrice(final ProductPrice other) {
    assign(other);
  }

  @Override
  public void assign(final ProductPrice other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    productId = other.productId;
    productItemId = other.productItemId;
    code = other.code;
    name = other.name;
    specification = other.specification;
    source = Assignment.clone(other.source);
    price = other.price;
    discount = other.discount;
    discountReason = other.discountReason;
    discountFrom = other.discountFrom;
    discountUntil = other.discountUntil;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public ProductPrice clone() {
    return new ProductPrice(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(final Long productId) {
    this.productId = productId;
  }

  public Long getProductItemId() {
    return productItemId;
  }

  public void setProductItemId(final Long productItemId) {
    this.productItemId = productItemId;
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

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(final String specification) {
    this.specification = specification;
  }

  public Info getSource() {
    return source;
  }

  public void setSource(final Info source) {
    this.source = source;
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

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final ProductPrice other = (ProductPrice) o;
    return Equality.equals(id, other.id)
        && Equality.equals(productId, other.productId)
        && Equality.equals(productItemId, other.productItemId)
        && Equality.equals(code, other.code)
        && Equality.equals(name, other.name)
        && Equality.equals(specification, other.specification)
        && Equality.equals(source, other.source)
        && Equality.equals(price, other.price)
        && Equality.equals(discount, other.discount)
        && Equality.equals(discountReason, other.discountReason)
        && Equality.equals(discountFrom, other.discountFrom)
        && Equality.equals(discountUntil, other.discountUntil)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, productId);
    result = Hash.combine(result, multiplier, productItemId);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, specification);
    result = Hash.combine(result, multiplier, source);
    result = Hash.combine(result, multiplier, price);
    result = Hash.combine(result, multiplier, discount);
    result = Hash.combine(result, multiplier, discountReason);
    result = Hash.combine(result, multiplier, discountFrom);
    result = Hash.combine(result, multiplier, discountUntil);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("productId", productId)
        .append("productItemId", productItemId)
        .append("code", code)
        .append("name", name)
        .append("specification", specification)
        .append("source", source)
        .append("price", price)
        .append("discount", discount)
        .append("discountReason", discountReason)
        .append("discountFrom", discountFrom)
        .append("discountUntil", discountUntil)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
