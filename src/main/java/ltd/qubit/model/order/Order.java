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
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.pair.KeyValuePairList;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.invoice.InvoiceStatus;
import ltd.qubit.model.person.User;
import ltd.qubit.model.product.Seller;
import ltd.qubit.model.shipping.ShippingDemand;
import ltd.qubit.model.shipping.ShippingMode;
import ltd.qubit.model.system.Environment;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;
import ltd.qubit.model.util.InfoWithEntity;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;
import ltd.qubit.model.util.WithCategory;
import ltd.qubit.model.util.WithSource;

import static java.math.BigDecimal.ZERO;

import static ltd.qubit.commons.lang.ObjectUtils.defaultIfNull;

/**
 * 此模型表示订单。
 *
 * @author 胡海星
 */
public class Order implements Identifiable, WithApp, WithCategory, WithSource,
    Auditable, Assignable<Order> {

  private static final long serialVersionUID = 1390446628123144015L;

  /**
   * 内部ID，全局唯一，亦作为订单流水号。
   */
  @Identifier
  private Long id;

  /**
   * 所属 User 的 ID。
   */
  @Reference(entity = User.class, property = "id")
  @Nullable
  private Long userId;

  /**
   * 所属 App。
   */
  @Reference(entity = App.class, property = "info")
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
   *  订单分项列表。
   */
  @Size(min = 1, max = 20)
  private List<OrderItem> items;

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
   * 订单整体折扣原因。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String discountReason;

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
   * 配送方式。
   */
  private ShippingMode shippingMode;

  /**
   * 收货人信息。
   */
  @Nullable
  private Consignee consignee;

  /**
   * 配送要求。
   */
  @Nullable
  private ShippingDemand shippingDemand;

  /**
   * 发货物流记录ID。
   */
  @Nullable
  private Long shippingId;

  /**
   * 发货物流单单号。
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String shippingNumber;

  /**
   * 订单备注。
   */
  @Nullable
  private String comment;

  /**
   * 订单状态。
   */
  private OrderStatus status;

  /**
   * 订单失效时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant expiredTime;

  /**
   * 付款时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant payTime;

  /**
   * 发货时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant shipTime;

  /**
   * 退款时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant refundTime;

  /**
   * 完成时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant completeTime;

  /**
   * 放弃时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant cancelTime;

  /**
   * 发票开具状态。
   */
  private InvoiceStatus invoiceStatus;

  /**
   * 订单提交时客户端环境。
   */
  @Nullable
  private Environment environment;

  /**
   * 订单的额外参数。
   */
  @Nullable
  private KeyValuePairList payload;

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
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  public Order() {
    // empty
  }

  public Order(final Order other) {
    assign(other);
  }

  @Override
  public void assign(final Order other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    userId = other.userId;
    app = Assignment.clone(other.app);
    buyer = Assignment.clone(other.buyer);
    seller = Assignment.clone(other.seller);
    source = Assignment.clone(other.source);
    category = Assignment.clone(other.category);
    items = Assignment.deepClone(other.items);
    payType = other.payType;
    currency = other.currency;
    totalPrice = other.totalPrice;
    totalShippingCost = other.totalShippingCost;
    totalDiscount = other.totalDiscount;
    discount = other.discount;
    discountReason = other.discountReason;
    shippingCost = other.shippingCost;
    payable = other.payable;
    shippingMode = other.shippingMode;
    consignee = Assignment.clone(other.consignee);
    shippingDemand = Assignment.clone(other.shippingDemand);
    shippingId = other.shippingId;
    shippingNumber = other.shippingNumber;
    comment = other.comment;
    status = other.status;
    expiredTime = other.expiredTime;
    payTime = other.payTime;
    shipTime = other.shipTime;
    refundTime = other.refundTime;
    completeTime = other.completeTime;
    cancelTime = other.cancelTime;
    invoiceStatus = other.invoiceStatus;
    environment = Assignment.clone(other.environment);
    payload = Assignment.clone(other.payload);
    createTime = other.createTime;
    modifyTime = other.modifyTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Order clone() {
    return new Order(this);
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

  public List<OrderItem> getItems() {
    return items;
  }

  public void setItems(final List<OrderItem> items) {
    this.items = items;
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

  @Nullable
  public String getDiscountReason() {
    return discountReason;
  }

  public void setDiscountReason(@Nullable final String discountReason) {
    this.discountReason = discountReason;
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

  public ShippingMode getShippingMode() {
    return shippingMode;
  }

  public void setShippingMode(final ShippingMode shippingMode) {
    this.shippingMode = shippingMode;
  }

  @Nullable
  public Consignee getConsignee() {
    return consignee;
  }

  public void setConsignee(@Nullable final Consignee consignee) {
    this.consignee = consignee;
  }

  @Nullable
  public ShippingDemand getShippingDemand() {
    return shippingDemand;
  }

  public void setShippingDemand(@Nullable final ShippingDemand shippingDemand) {
    this.shippingDemand = shippingDemand;
  }

  @Nullable
  public Long getShippingId() {
    return shippingId;
  }

  public void setShippingId(@Nullable final Long shippingId) {
    this.shippingId = shippingId;
  }

  @Nullable
  public String getShippingNumber() {
    return shippingNumber;
  }

  public void setShippingNumber(@Nullable final String shippingNumber) {
    this.shippingNumber = shippingNumber;
  }

  @Nullable
  public String getComment() {
    return comment;
  }

  public void setComment(@Nullable final String comment) {
    this.comment = comment;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(final OrderStatus status) {
    this.status = status;
  }

  public Instant getExpiredTime() {
    return expiredTime;
  }

  public void setExpiredTime(final Instant expiredTime) {
    this.expiredTime = expiredTime;
  }

  @Nullable
  public Instant getPayTime() {
    return payTime;
  }

  public void setPayTime(@Nullable final Instant payTime) {
    this.payTime = payTime;
  }

  @Nullable
  public Instant getShipTime() {
    return shipTime;
  }

  public void setShipTime(@Nullable final Instant shipTime) {
    this.shipTime = shipTime;
  }

  @Nullable
  public Instant getRefundTime() {
    return refundTime;
  }

  public void setRefundTime(@Nullable final Instant refundTime) {
    this.refundTime = refundTime;
  }

  @Nullable
  public Instant getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(@Nullable final Instant completeTime) {
    this.completeTime = completeTime;
  }

  @Nullable
  public Instant getCancelTime() {
    return cancelTime;
  }

  public void setCancelTime(@Nullable final Instant cancelTime) {
    this.cancelTime = cancelTime;
  }

  public InvoiceStatus getInvoiceStatus() {
    return invoiceStatus;
  }

  public void setInvoiceStatus(final InvoiceStatus invoiceStatus) {
    this.invoiceStatus = invoiceStatus;
  }

  @Nullable
  public Environment getEnvironment() {
    return environment;
  }

  public void setEnvironment(@Nullable final Environment environment) {
    this.environment = environment;
  }

  @Nullable
  public KeyValuePairList getPayload() {
    return payload;
  }

  public void setPayload(@Nullable final KeyValuePairList payload) {
    this.payload = payload;
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
    final Order other = (Order) o;
    return Equality.equals(id, other.id)
        && Equality.equals(userId, other.userId)
        && Equality.equals(app, other.app)
        && Equality.equals(buyer, other.buyer)
        && Equality.equals(seller, other.seller)
        && Equality.equals(source, other.source)
        && Equality.equals(category, other.category)
        && Equality.equals(items, other.items)
        && Equality.equals(payType, other.payType)
        && Equality.equals(currency, other.currency)
        && Equality.equals(totalPrice, other.totalPrice)
        && Equality.equals(totalShippingCost, other.totalShippingCost)
        && Equality.equals(totalDiscount, other.totalDiscount)
        && Equality.equals(discount, other.discount)
        && Equality.equals(discountReason, other.discountReason)
        && Equality.equals(shippingCost, other.shippingCost)
        && Equality.equals(payable, other.payable)
        && Equality.equals(shippingMode, other.shippingMode)
        && Equality.equals(consignee, other.consignee)
        && Equality.equals(shippingDemand, other.shippingDemand)
        && Equality.equals(shippingId, other.shippingId)
        && Equality.equals(shippingNumber, other.shippingNumber)
        && Equality.equals(comment, other.comment)
        && Equality.equals(status, other.status)
        && Equality.equals(expiredTime, other.expiredTime)
        && Equality.equals(payTime, other.payTime)
        && Equality.equals(shipTime, other.shipTime)
        && Equality.equals(refundTime, other.refundTime)
        && Equality.equals(completeTime, other.completeTime)
        && Equality.equals(cancelTime, other.cancelTime)
        && Equality.equals(invoiceStatus, other.invoiceStatus)
        && Equality.equals(environment, other.environment)
        && Equality.equals(payload, other.payload)
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
    result = Hash.combine(result, multiplier, items);
    result = Hash.combine(result, multiplier, payType);
    result = Hash.combine(result, multiplier, currency);
    result = Hash.combine(result, multiplier, totalPrice);
    result = Hash.combine(result, multiplier, totalShippingCost);
    result = Hash.combine(result, multiplier, totalDiscount);
    result = Hash.combine(result, multiplier, discount);
    result = Hash.combine(result, multiplier, discountReason);
    result = Hash.combine(result, multiplier, shippingCost);
    result = Hash.combine(result, multiplier, payable);
    result = Hash.combine(result, multiplier, shippingMode);
    result = Hash.combine(result, multiplier, consignee);
    result = Hash.combine(result, multiplier, shippingDemand);
    result = Hash.combine(result, multiplier, shippingId);
    result = Hash.combine(result, multiplier, shippingNumber);
    result = Hash.combine(result, multiplier, comment);
    result = Hash.combine(result, multiplier, status);
    result = Hash.combine(result, multiplier, expiredTime);
    result = Hash.combine(result, multiplier, payTime);
    result = Hash.combine(result, multiplier, shipTime);
    result = Hash.combine(result, multiplier, refundTime);
    result = Hash.combine(result, multiplier, completeTime);
    result = Hash.combine(result, multiplier, cancelTime);
    result = Hash.combine(result, multiplier, invoiceStatus);
    result = Hash.combine(result, multiplier, environment);
    result = Hash.combine(result, multiplier, payload);
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
        .append("items", items)
        .append("payType", payType)
        .append("currency", currency)
        .append("totalPrice", totalPrice)
        .append("totalShippingCost", totalShippingCost)
        .append("totalDiscount", totalDiscount)
        .append("discount", discount)
        .append("discountReason", discountReason)
        .append("shippingCost", shippingCost)
        .append("payable", payable)
        .append("shippingMode", shippingMode)
        .append("consignee", consignee)
        .append("shippingDemand", shippingDemand)
        .append("shippingId", shippingId)
        .append("shippingNumber", shippingNumber)
        .append("comment", comment)
        .append("status", status)
        .append("expiredTime", expiredTime)
        .append("payTime", payTime)
        .append("shipTime", shipTime)
        .append("refundTime", refundTime)
        .append("completeTime", completeTime)
        .append("cancelTime", cancelTime)
        .append("invoiceStatus", invoiceStatus)
        .append("environment", environment)
        .append("payload", payload)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }

  // /**
  //  * 检查此对象各字段合法性。
  //  *
  //  * <p>TODO: 改用Validator接口实现
  //  *
  //  * @return 此订单
  //  */
  // public final Order checkField() {
  //   final Logger logger = LoggerFactory.getLogger(this.getClass());
  //   logger.info("Validate the Order object: {}", this);
  //   if (app == null) {
  //     logger.error("Order's app cannot be empty");
  //     throw new NullFieldException(Order.class, Order::getApp);
  //   }
  //   if (seller == null) {
  //     logger.error("Order's seller cannot be empty");
  //     throw new NullFieldException(Order.class, Order::getSeller);
  //   }
  //   if (buyer == null) {
  //     logger.error("Order's buyer cannot be empty");
  //     throw new NullFieldException(Order.class, Order::getBuyer);
  //   }
  //   if (items == null || items.isEmpty()) {
  //     logger.error("Order's items cannot be empty");
  //     throw new NullFieldException(Order.class, Order::getItems);
  //   }
  //   final Set<Long> productItemIds = new HashSet<>();
  //   for (final OrderItem item : items) {
  //     // 检查订单项的字段是否合法
  //     item.checkField();
  //     // 检查同一个订单的不同订单项中商品项是否重复
  //     // 注意为了方便后继对商品项购买次数限制的检查，
  //     // 我们规定同一个订单中不同订单项的商品项必须不同
  //     // 换句话说相同的商品项（同一商品，同一规格）必须合并
  //     final ProductInfo product = item.getProduct();
  //     if (productItemIds.contains(product.getItemId())) {
  //       logger.error("Duplicated product: {}", product);
  //       throw new DuplicateProductException(product.getInfo());
  //     }
  //     productItemIds.add(product.getItemId());
  //   }
  //   return this;
  // }

  // /**
  //  * 检查此订单中的商品是否仍在销售期内。
  //  *
  //  * @param now
  //  *     当前日期时间，必须考虑当前系统时区。
  //  * @return 此订单
  //  */
  // public final Order checkSalePeriod(final LocalDateTime now) {
  //   if (items != null) {
  //     for (final OrderItem item : items) {
  //       item.checkSalePeriod(now);
  //     }
  //   }
  //   return this;
  // }
  //
  // /**
  //  * 检查此订单中商品当前的库存是否足够。
  //  *
  //  * @return 此订单
  //  */
  // public final Order checkInventory() {
  //   if (items != null) {
  //     for (final OrderItem item : items) {
  //       item.checkInventory();
  //     }
  //   }
  //   return this;
  // }

  /**
   * 计算此订单的支付金额。
   *
   * @return 此订单
   */
  public final Order calculate() {
    totalPrice = ZERO;
    totalShippingCost = ZERO;
    totalDiscount = ZERO;
    shippingCost = defaultIfNull(shippingCost, ZERO);
    discount = defaultIfNull(discount, ZERO);
    payable = ZERO;
    if (items != null) {
      for (final OrderItem item : items) {
        item.calculate();
        totalPrice = totalPrice.add(item.getTotalPrice());
        totalShippingCost = totalShippingCost.add(item.getShippingCost());
        totalDiscount = totalDiscount.add(item.getDiscount());
        payable = payable.add(item.getPayable());
      }
    }
    payable = payable.add(shippingCost).subtract(discount);
    return this;
  }

  /**
   * 计算订单分项所分配的折扣。
   *
   * @param item
   *     订单分项
   * @return 该订单分项所分配的折扣
   */
  public final BigDecimal calculateDiscount(final OrderItem item) {
    return new OrderInfo(this).calculateDiscount(item);
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
  public final BigDecimal calculateRefundable(final OrderItem item,
      final Integer count) {
    return new OrderInfo(this).calculateRefundable(item, count);
  }

  /**
   * 检测此订单的金额数据是否正确。
   *
   * @param expectedShippingCost
   *     期望的运费
   * @param expectedDiscount
   *     期望的折扣
   * @return 若此订单的金额数据正确，则返回{@code true}；否则返回{@code false}。
   */
  public final boolean isPriceValid(final BigDecimal expectedShippingCost,
      final BigDecimal expectedDiscount) {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    logger.debug("isPriceValid: expectedShippingCost:{} expectedDiscount:{} "
            + "shippingCost:{} discount:{} totalPrice:{} totalShippingCost:{} "
            + "totalDiscount:{} payable:{}",
        expectedShippingCost,
        expectedDiscount,
        shippingCost,
        discount,
        totalPrice,
        totalShippingCost,
        totalDiscount,
        payable
    );
    // 运费必须等于期望值
    if (shippingCost == null
        || shippingCost.compareTo(expectedShippingCost) != 0) {
      logger.error("shippingCost error");
      return false;
    }
    // 折扣必须等于期望值
    if (discount == null || discount.compareTo(expectedDiscount) != 0) {
      logger.error("discount error");
      return false;
    }
    // 总价格、总运费、总折扣、应付金额不能为空
    if (totalPrice == null
        || totalShippingCost == null
        || totalDiscount == null
        || payable == null) {
      logger.error("totalPrice totalShippingCost totalDiscount payable error");
      return false;
    }
    // 计算期望的总价格、总运费、总折扣以及应付金额
    BigDecimal expectedTotalPrice = ZERO;
    BigDecimal expectedTotalShippingCost = ZERO;
    BigDecimal expectedTotalDiscount = ZERO;
    BigDecimal expectedPayable = ZERO;
    if (items != null) {
      for (final OrderItem item : items) {
        expectedTotalPrice = expectedTotalPrice.add(item.getTotalPrice());
        expectedTotalShippingCost = expectedTotalShippingCost
            .add(item.getShippingCost());
        expectedTotalDiscount = expectedTotalDiscount.add(item.getDiscount());
        expectedPayable = expectedPayable.add(item.getPayable());
      }
    }
    expectedPayable = expectedPayable.add(shippingCost)
                                     .subtract(discount);
    logger.debug("isPriceValid: expectedTotalPrice {}  totalPrice {}",
        expectedTotalPrice, totalPrice);
    logger.debug("isPriceValid: expectedTotalShippingCost {}  totalShippingCost {}",
        expectedTotalShippingCost, totalShippingCost);
    logger.debug("isPriceValid: expectedTotalDiscount {}  totalDiscount {}",
        expectedTotalDiscount, totalDiscount);
    logger.debug("isPriceValid: expectedPayable {}  payable {}",
        expectedPayable, payable);
    // 期望值应和实际值相等
    return (expectedTotalPrice.compareTo(totalPrice) == 0)
        && (expectedTotalShippingCost.compareTo(totalShippingCost) == 0)
        && (expectedTotalDiscount.compareTo(totalDiscount) == 0)
        && (expectedPayable.compareTo(payable) == 0);
  }
}
