////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.codec.MoneyCodec;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.product.Seller;
import ltd.qubit.model.util.Deletable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.InfoWithEntity;
import ltd.qubit.model.util.StatefulInfo;

import static ltd.qubit.commons.lang.ObjectUtils.defaultIfNull;

/**
 * 此模型表示订单的基本信息，用于实现某些业务逻辑时获取订单的信息并尽量减少
 * 对数据库的查询开销。
 *
 * @author 胡海星
 */
public class OrderInfo implements Identifiable, Deletable,
    Assignable<OrderInfo> {

  private static final long serialVersionUID = -179547767106547038L;

  /**
   * 内部ID，全局唯一，亦作为订单流水号。
   */
  @Unique
  private Long id;

  /**
   * 所属 User 的 ID。
   */
  @Nullable
  private Long userId;

  /**
   * 所属 App。
   */
  private StatefulInfo app;

  /**
   * 购买者信息。
   */
  private Buyer buyer;

  /**
   * 销售商。
   */
  private Seller seller;

  /**
   * 订单来源。
   */
  @Nullable
  private Info source;

  /**
   * 订单分类。
   */
  @Nullable
  private InfoWithEntity category;

  /**
   * 订单支付类型。
   */
  private PayType payType;

  /**
   * 货币单位。
   */
  private Currency currency;

  /**
   * 订单总价，必须大于等于0，保留四位小数。
   *
   * <p>订单总价 = 订单分项总价之和
   *
   * <p>订单分项总价 = 订单分项单价 × 订单分项数量
   */
  @Money
  private BigDecimal totalPrice;

  /**
   * 订单总运费，必须大于等于0，保留四位小数。
   *
   * <p>订单总运费 = 订单分项运费之和
   */
  @Money
  private BigDecimal totalShippingCost;

  /**
   * 订单总折扣，必须大于等于0，保留四位小数。
   *
   * <p>订单总折扣 = 订单分项折扣之和
   */
  @Money
  private BigDecimal totalDiscount;

  /**
   * 订单整体折扣，必须大于等于0，保留四位小数。
   */
  @Money
  private BigDecimal discount;

  /**
   * 订单整体运费，必须大于等于0，保留四位小数。
   */
  @Money
  private BigDecimal shippingCost;

  /**
   * 应支付金额，必须大于0，保留四位小数。
   *
   * <p>应支付金额 = 订单总金额 + 订单总运费 - 订单总折扣 + 订单整体运费 - 订单整体折扣
   *
   * <p>{@link #payable} = {@link #totalPrice} + {@link #totalShippingCost}
   *  - {@link #totalDiscount} + {@link #shippingCost} - {@link #discount}
   */
  @Money
  private BigDecimal payable;

  /**
   * 订单状态。
   */
  private OrderStatus status;

  /**
   * 创建时间，即提交时间。
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

  public OrderInfo() {
    // empty
  }

  public OrderInfo(final OrderInfo other) {
    assign(other);
  }

  public OrderInfo(final Order order) {
    assign(order);
  }

  @Override
  public void assign(final OrderInfo other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    userId = other.userId;
    app = Assignment.clone(other.app);
    buyer = Assignment.clone(other.buyer);
    seller = Assignment.clone(other.seller);
    source = Assignment.clone(other.source);
    category = Assignment.clone(other.category);
    payType = other.payType;
    currency = other.currency;
    totalPrice = other.totalPrice;
    totalShippingCost = other.totalShippingCost;
    totalDiscount = other.totalDiscount;
    discount = other.discount;
    shippingCost = other.shippingCost;
    payable = other.payable;
    status = other.status;
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  public void assign(final Order order) {
    Argument.requireNonNull("order", order);
    this.id = order.getId();
    this.userId = order.getUserId();
    this.app = Assignment.clone(order.getApp());
    this.buyer = order.getBuyer();
    this.seller = order.getSeller();
    this.source = Assignment.clone(order.getSource());
    this.category = Assignment.clone(order.getCategory());
    this.payType = order.getPayType();
    this.currency = order.getCurrency();
    this.totalPrice = order.getTotalPrice();
    this.totalShippingCost = order.getTotalShippingCost();
    this.totalDiscount = order.getTotalDiscount();
    this.shippingCost = order.getShippingCost();
    this.discount = order.getDiscount();
    this.payable = order.getPayable();
    this.status = order.getStatus();
    this.createTime = order.getCreateTime();
    this.modifyTime = order.getModifyTime();
    this.deleteTime = order.getDeleteTime();
  }

  @Override
  public OrderInfo clone() {
    return new OrderInfo(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  @Nullable
  public Long getUserId() {
    return userId;
  }

  public void setUserId(@Nullable final Long userId) {
    this.userId = userId;
  }

  public StatefulInfo getApp() {
    return app;
  }

  public void setApp(final StatefulInfo app) {
    this.app = app;
  }

  public Buyer getBuyer() {
    return buyer;
  }

  public void setBuyer(final Buyer buyer) {
    this.buyer = buyer;
  }

  public Seller getSeller() {
    return seller;
  }

  public void setSeller(final Seller seller) {
    this.seller = seller;
  }

  @Nullable
  public Info getSource() {
    return source;
  }

  public void setSource(@Nullable final Info source) {
    this.source = source;
  }

  @Nullable
  public InfoWithEntity getCategory() {
    return category;
  }

  public void setCategory(@Nullable final InfoWithEntity category) {
    this.category = category;
  }

  public PayType getPayType() {
    return payType;
  }

  public void setPayType(final PayType payType) {
    this.payType = payType;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(final Currency currency) {
    this.currency = currency;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(final BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public BigDecimal getTotalShippingCost() {
    return totalShippingCost;
  }

  public void setTotalShippingCost(final BigDecimal totalShippingCost) {
    this.totalShippingCost = totalShippingCost;
  }

  public BigDecimal getTotalDiscount() {
    return totalDiscount;
  }

  public void setTotalDiscount(final BigDecimal totalDiscount) {
    this.totalDiscount = totalDiscount;
  }

  public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(final BigDecimal discount) {
    this.discount = discount;
  }

  public BigDecimal getShippingCost() {
    return shippingCost;
  }

  public void setShippingCost(final BigDecimal shippingCost) {
    this.shippingCost = shippingCost;
  }

  public BigDecimal getPayable() {
    return payable;
  }

  public void setPayable(final BigDecimal payable) {
    this.payable = payable;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(final OrderStatus status) {
    this.status = status;
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
    final OrderInfo other = (OrderInfo) o;
    return Equality.equals(id, other.id)
        && Equality.equals(userId, other.userId)
        && Equality.equals(app, other.app)
        && Equality.equals(buyer, other.buyer)
        && Equality.equals(seller, other.seller)
        && Equality.equals(source, other.source)
        && Equality.equals(category, other.category)
        && Equality.equals(payType, other.payType)
        && Equality.equals(currency, other.currency)
        && Equality.equals(totalPrice, other.totalPrice)
        && Equality.equals(totalShippingCost, other.totalShippingCost)
        && Equality.equals(totalDiscount, other.totalDiscount)
        && Equality.equals(discount, other.discount)
        && Equality.equals(shippingCost, other.shippingCost)
        && Equality.equals(payable, other.payable)
        && Equality.equals(status, other.status)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, userId);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, buyer);
    result = Hash.combine(result, multiplier, seller);
    result = Hash.combine(result, multiplier, source);
    result = Hash.combine(result, multiplier, category);
    result = Hash.combine(result, multiplier, payType);
    result = Hash.combine(result, multiplier, currency);
    result = Hash.combine(result, multiplier, totalPrice);
    result = Hash.combine(result, multiplier, totalShippingCost);
    result = Hash.combine(result, multiplier, totalDiscount);
    result = Hash.combine(result, multiplier, discount);
    result = Hash.combine(result, multiplier, shippingCost);
    result = Hash.combine(result, multiplier, payable);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("userId", userId)
        .append("app", app)
        .append("buyer", buyer)
        .append("seller", seller)
        .append("source", source)
        .append("category", category)
        .append("payType", payType)
        .append("currency", currency)
        .append("totalPrice", totalPrice)
        .append("totalShippingCost", totalShippingCost)
        .append("totalDiscount", totalDiscount)
        .append("discount", discount)
        .append("shippingCost", shippingCost)
        .append("payable", payable)
        .append("status", status)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }

  /**
   * 计算订单分项所分配的订单整体折扣。
   *
   * @param item
   *     订单分项
   * @return 该订单分项所分配的订单整体折扣
   */
  public final BigDecimal calculateDiscount(final OrderItem item) {
    if (discount == null || discount.signum() <= 0) {
      return BigDecimal.ZERO;
    }
    if (totalPrice == null || totalPrice.signum() <= 0) {
      return BigDecimal.ZERO;
    }
    // itemMoney 表示除了运费外，该订单项实际总费用
    BigDecimal itemMoney = item.getTotalPrice();
    if (itemMoney == null || itemMoney.signum() <= 0) {
      return BigDecimal.ZERO;
    }
    if (item.getDiscount() != null && item.getDiscount().signum() > 0) {
      itemMoney = itemMoney.subtract(item.getDiscount());
    }
    // 若该订单项除运费外实际支付款项为0，则未享受折扣
    if (itemMoney.signum() <= 0) {
      return BigDecimal.ZERO;
    }
    // totalMoney 表示除了总运费、整体运费和整体折扣外，此订单实际总费用
    BigDecimal totalMoney = totalPrice;
    if (totalDiscount != null && totalDiscount.signum() > 0) {
      totalMoney = totalMoney.subtract(totalDiscount);
    }
    // 若此订单除运费外实际支付款项为0，则未享受折扣
    if (totalMoney.signum() <= 0) {
      return BigDecimal.ZERO;
    }
    // 若订单项支付金额 >= 整个订单支付金额，则独享整体折扣
    if (itemMoney.compareTo(totalMoney) >= 0) {
      return discount;
    }
    // 否则按比例计算该订单项占据的整体折扣金额
    return discount.multiply(itemMoney)
                   .divide(totalMoney, MoneyCodec.DEFAULT_SCALE,
                           MoneyCodec.DEFAULT_ROUND_MODE);
  }

  /**
   * 计算指定的退货应退款项。
   *
   * @param item
   *     退货商品所属订单分项
   * @param count
   *     退货数量
   * @return 指定的退货应退款项
   */
  public final BigDecimal calculateRefundable(final OrderItem item, final Integer count) {
    if (count == null || count <= 0) {
      return BigDecimal.ZERO;
    }
    // 首先按比例计算该分项占据的订单整体折扣
    final BigDecimal itemWholeDiscount = this.calculateDiscount(item);
    // 然后考虑分项自己的折扣，按比例计算退货商品占据的折扣
    final BigDecimal refundableDiscount = item.calculateDiscount(count, itemWholeDiscount);
    // 计算退货商品的总价
    final BigDecimal price = defaultIfNull(item.getPrice(), BigDecimal.ZERO);
    final BigDecimal refundableTotalPrice = price.multiply(BigDecimal.valueOf(count));
    // 应退款金额 = 退货商品总价 - 退货商品占据的折扣
    return refundableTotalPrice.subtract(refundableDiscount);
  }
}
