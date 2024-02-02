////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.product;

import java.io.Serializable;
import java.time.LocalDate;

import javax.annotation.Nullable;

import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 此模型表示产品销售的限制条件。
 *
 * @author 胡海星
 */
public class ProductConstraint implements Assignable<ProductConstraint>, Serializable {

  private static final long serialVersionUID = -600447456380575698L;

  /**
   * 计算年龄时的起始日期。
   *
   * <p>系统在计算人的年龄时，会计算这个日期和该人出生日期之间的间隔，从而得到
   * 该人的精确年龄。有些产品，例如保险产品，会要求在产品生效的那一天，用户
   * 年龄必须在某个范围内，此时可设置这个字段为该产品的生效期。
   *
   * <p>{@code null}表示以当前系统日期作为起始日期。
   */
  @Nullable
  private LocalDate ageEpoch;

  /**
   * 成年人的年龄起始点，单位为年。
   *
   * <p>{@code null}表示使用系统默认值（18岁）。
   */
  @Nullable
  private Integer adultAge;

  /**
   * 购买者是否只允许为自己购买，{@code null}表示不作限制。
   */
  @Nullable
  private Boolean selfOnly;

  /**
   * 对购买者的限制，{@code null}表示不作限制。
   */
  @Nullable
  private PersonConstraint buyer;

  /**
   * 对客户的限制，{@code null}表示不作限制。
   */
  @Nullable
  private PersonConstraint client;

  /**
   * 允许的订单来源代码列表，{@code null}或空列表均表示不做限制。
   */
  @Nullable
  private String[] sources;

  /**
   * 购买者最多可以购买此商品多少份，{@code null}表示不作限制。
   */
  @Nullable
  private Integer limitForBuyer;

  /**
   * 每个客户最多可以购买此商品多少份，{@code null}表示不作限制。
   */
  @Nullable
  private Integer limitForClient;

  public ProductConstraint() {
    // empty
  }

  public ProductConstraint(final ProductConstraint other) {
    assign(other);
  }

  @Override
  public void assign(final ProductConstraint other) {
    Argument.requireNonNull("other", other);
    ageEpoch = other.ageEpoch;
    adultAge = other.adultAge;
    selfOnly = other.selfOnly;
    buyer = Assignment.clone(other.buyer);
    client = Assignment.clone(other.client);
    sources = Assignment.clone(other.sources);
    limitForBuyer = other.limitForBuyer;
    limitForClient = other.limitForClient;
  }

  @Override
  public ProductConstraint clone() {
    return new ProductConstraint(this);
  }

  @Nullable
  public LocalDate getAgeEpoch() {
    return ageEpoch;
  }

  public void setAgeEpoch(@Nullable final LocalDate ageEpoch) {
    this.ageEpoch = ageEpoch;
  }

  @Nullable
  public Integer getAdultAge() {
    return adultAge;
  }

  public void setAdultAge(@Nullable final Integer adultAge) {
    this.adultAge = adultAge;
  }

  @Nullable
  public Boolean isSelfOnly() {
    return selfOnly;
  }

  public void setSelfOnly(@Nullable final Boolean selfOnly) {
    this.selfOnly = selfOnly;
  }

  @Nullable
  public PersonConstraint getBuyer() {
    return buyer;
  }

  public void setBuyer(@Nullable final PersonConstraint buyer) {
    this.buyer = buyer;
  }

  @Nullable
  public PersonConstraint getClient() {
    return client;
  }

  public void setClient(@Nullable final PersonConstraint client) {
    this.client = client;
  }

  @Nullable
  public String[] getSources() {
    return sources;
  }

  public void setSources(@Nullable final String[] sources) {
    this.sources = sources;
  }

  @Nullable
  public Integer getLimitForBuyer() {
    return limitForBuyer;
  }

  public void setLimitForBuyer(@Nullable final Integer limitForBuyer) {
    this.limitForBuyer = limitForBuyer;
  }

  @Nullable
  public Integer getLimitForClient() {
    return limitForClient;
  }

  public void setLimitForClient(@Nullable final Integer limitForClient) {
    this.limitForClient = limitForClient;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final ProductConstraint other = (ProductConstraint) o;
    return Equality.equals(ageEpoch, other.ageEpoch)
        && Equality.equals(adultAge, other.adultAge)
        && Equality.equals(selfOnly, other.selfOnly)
        && Equality.equals(buyer, other.buyer)
        && Equality.equals(client, other.client)
        && Equality.equals(sources, other.sources)
        && Equality.equals(limitForBuyer, other.limitForBuyer)
        && Equality.equals(limitForClient, other.limitForClient);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, ageEpoch);
    result = Hash.combine(result, multiplier, adultAge);
    result = Hash.combine(result, multiplier, selfOnly);
    result = Hash.combine(result, multiplier, buyer);
    result = Hash.combine(result, multiplier, client);
    result = Hash.combine(result, multiplier, sources);
    result = Hash.combine(result, multiplier, limitForBuyer);
    result = Hash.combine(result, multiplier, limitForClient);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("ageEpoch", ageEpoch)
        .append("adultAge", adultAge)
        .append("selfOnly", selfOnly)
        .append("buyer", buyer)
        .append("client", client)
        .append("sources", sources)
        .append("limitForBuyer", limitForBuyer)
        .append("limitForClient", limitForClient)
        .toString();
  }
}
