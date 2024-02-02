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
import java.util.List;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ltd.qubit.commons.annotation.Computed;
import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Money;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.codec.MoneyCodec;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.product.Product;
import ltd.qubit.model.product.ProductInfo;
import ltd.qubit.model.util.Identifiable;

import static java.math.BigDecimal.ZERO;

import static ltd.qubit.commons.lang.ObjectUtils.defaultIfNull;

/**
 * 此模型表示一条订单记录。
 *
 * <p>每条订单记录只能对应一项商品。
 *
 * @author 胡海星
 */
public class OrderItem implements Identifiable, Assignable<OrderItem> {

  private static final long serialVersionUID = -7522603739971483963L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所属订单ID。
   */
  @Reference(entity = Order.class, property = "id")
  private Long orderId;

  /**
   * 此订单项在列表中的下标索引。
   */
  private Integer index;

  /**
   * 商品。
   */
  @Reference(entity = Product.class, property = "info")
  private ProductInfo product;

  /**
   * 商品数量，必须大于等于0。
   */
  private Integer count;

  /**
   * 商品总价，必须大于等于0，保留四位小数。
   *
   * <p>总价 = 单价 * 数量
   */
  @Money
  private BigDecimal totalPrice;

  /**
   * 商品总金额整体折扣，必须大于等于0，保留四位小数。
   */
  @Money
  private BigDecimal discount;

  /**
   * 商品折扣原因。
   */
  @Size(min = 1, max = 256)
  @Nullable
  private String discountReason;

  /**
   * 运费，必须大于等于0，保留四位小数。
   */
  @Money
  private BigDecimal shippingCost;

  /**
   * 应支付总金额，必须大于等于0，保留四位小数。
   *
   * <p>应支付总金额 =  总金额(单价 * 数量) + 运费 - 折扣
   */
  @Money
  private BigDecimal payable;

  /**
   * 服务ID。
   *
   * FIXME：what's this?
   */
  @Nullable
  private Long serviceId;

  /**
   * 此订单项关联的客户信息。
   *
   * <p>购买某些产品或服务时，例如保险、飞机票、船票等，需要提供产品或服务享用人
   * 的信息。
   *
   * <p><b>注意：</b>如果此订单项关联了客户信息，则关联的客户的数量必须等于购买的
   * 商品的数量，且同一订单项中关联的客户不能重复。
   */
  @Nullable
  private List<Client> clients;

  public OrderItem() {
    // empty
  }

  public OrderItem(final OrderItem other) {
    assign(other);
  }

  @Override
  public void assign(final OrderItem other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    orderId = other.orderId;
    index = other.index;
    product = Assignment.clone(other.product);
    count = other.count;
    totalPrice = other.totalPrice;
    discount = other.discount;
    discountReason = other.discountReason;
    shippingCost = other.shippingCost;
    payable = other.payable;
    serviceId = other.serviceId;
    clients = Assignment.deepClone(other.clients);
  }

  @Override
  public OrderItem clone() {
    return new OrderItem(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(final Long orderId) {
    this.orderId = orderId;
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex(final Integer index) {
    this.index = index;
  }

  public ProductInfo getProduct() {
    return product;
  }

  public void setProduct(final ProductInfo product) {
    this.product = product;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(final Integer count) {
    this.count = count;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(final BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
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

  @Nullable
  public Long getServiceId() {
    return serviceId;
  }

  public void setServiceId(@Nullable final Long serviceId) {
    this.serviceId = serviceId;
  }

  @Nullable
  public List<Client> getClients() {
    return clients;
  }

  public void setClients(@Nullable final List<Client> clients) {
    this.clients = clients;
  }

  @Computed("product")
  public BigDecimal getPrice() {
    return (product == null ? null : product.getPrice());
  }

  public final OrderItem setPrice(final BigDecimal price) {
    if (product != null) {
      product.setPrice(price);
    }
    return this;
  }

  @Computed("product")
  public Currency getCurrency() {
    return (product == null ? null : product.getCurrency());
  }

  public final OrderItem setCurrency(final Currency currency) {
    if (product != null) {
      product.setCurrency(currency);
    }
    return this;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final OrderItem other = (OrderItem) o;
    return Equality.equals(id, other.id)
        && Equality.equals(orderId, other.orderId)
        && Equality.equals(index, other.index)
        && Equality.equals(product, other.product)
        && Equality.equals(count, other.count)
        && Equality.equals(totalPrice, other.totalPrice)
        && Equality.equals(discount, other.discount)
        && Equality.equals(discountReason, other.discountReason)
        && Equality.equals(shippingCost, other.shippingCost)
        && Equality.equals(payable, other.payable)
        && Equality.equals(serviceId, other.serviceId)
        && Equality.equals(clients, other.clients);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, orderId);
    result = Hash.combine(result, multiplier, index);
    result = Hash.combine(result, multiplier, product);
    result = Hash.combine(result, multiplier, count);
    result = Hash.combine(result, multiplier, totalPrice);
    result = Hash.combine(result, multiplier, discount);
    result = Hash.combine(result, multiplier, discountReason);
    result = Hash.combine(result, multiplier, shippingCost);
    result = Hash.combine(result, multiplier, payable);
    result = Hash.combine(result, multiplier, serviceId);
    result = Hash.combine(result, multiplier, clients);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("orderId", orderId)
        .append("index", index)
        .append("product", product)
        .append("count", count)
        .append("totalPrice", totalPrice)
        .append("discount", discount)
        .append("discountReason", discountReason)
        .append("shippingCost", shippingCost)
        .append("payable", payable)
        .append("serviceId", serviceId)
        .append("clients", clients)
        .toString();
  }

  // /**
  //  * 检查此对象各字段合法性。
  //  *
  //  * <p>TODO: 改用Validator接口实现
  //  *
  //  * @return 此订单项。
  //  */
  // public final OrderItem checkField() {
  //   final Logger logger = LoggerFactory.getLogger(this.getClass());
  //   logger.info("Validating order item: {}", this);
  //   if (product == null) {
  //     logger.error("Order item's product cannot be empty.");
  //     throw new NullFieldException(OrderItem.class, OrderItem::getProduct);
  //   }
  //   product.checkField();
  //   if (count == null) {
  //     logger.error("Order item's product count cannot be empty.");
  //     throw new NullFieldException(OrderItem.class, OrderItem::getCount);
  //   }
  //   if (count <= 0) {
  //     logger.error("Order item's product count must be positive.");
  //     throw new FieldValueOutOfRangeException(OrderItem.class, OrderItem::getCount);
  //   }
  //   //    if (totalPrice == null) {
  //   //      logger.error("Order item's total price cannot be empty.");
  //   //      throw new NullFieldException(OrderItem.class, OrderItem::getTotalPrice);
  //   //    }
  //   //    if (totalPrice.signum() < 0) {
  //   //      logger.error("Order item's total price must be non-negative.");
  //   //      throw new FieldValueOutOfRangeException(OrderItem.class, OrderItem::getTotalPrice);
  //   //    }
  //   //    // FIXME: discount必须根据规则预先计算出来
  //   //    if (discount == null) {
  //   //      logger.error("Order item's discount cannot be empty.");
  //   //      throw new NullFieldException(OrderItem.class, OrderItem::getDiscount);
  //   //    }
  //   //    if (discount.signum() < 0) {
  //   //      logger.error("Order item's discount must be non-negative.");
  //   //      throw new FieldValueOutOfRangeException(OrderItem.class, OrderItem::getDiscount);
  //   //    }
  //   //    // FIXME: shippingCost必须根据规则预先计算出来
  //   //    if (shippingCost == null) {
  //   //      logger.error("Order item's shipping cost cannot be empty.");
  //   //      throw new NullFieldException(OrderItem.class, OrderItem::getShippingCose);
  //   //    }
  //   //    if (shippingCost.signum() < 0) {
  //   //      logger.error("Order item's shipping cost must be non-negative.");
  //   //      throw new FieldValueOutOfRangeException(OrderItem.class, OrderItem::getShippingCose);
  //   //    }
  //   //    if (payable == null) {
  //   //      logger.error("Order item's payable cannot be empty.");
  //   //      throw new NullFieldException("payable");
  //   //    }
  //   //    if (payable.signum() < 0) {
  //   //      logger.error("Order item's payable must be non-negative.");
  //   //      throw new FieldValueOutOfRangeException(OrderItem.class, OrderItem::getPayable);
  //   //    }
  //   //    if (totalPrice.compareTo(product.getPrice().multiply(BigDecimal.valueOf(count))) != 0) {
  //   //      logger.error("Order item's total price is invalid.");
  //   //      throw new InvalidFieldValueException(OrderItem.class,
  //   //          OrderItem::getTotalPrice, totalPrice);
  //   //    }
  //   //    if (payable.compareTo(totalPrice.add(shippingCost).subtract(discount)) != 0) {
  //   //      logger.error("Order item's payable is invalid.");
  //   //      throw new InvalidFieldValueException(OrderItem.class, OrderItem::getPayable, payable);
  //   //    }
  //   if (isTrue(product.isNeedClient())) {
  //     if (clients == null || clients.isEmpty()) {
  //       logger.error("Order item's client cannot be empty.");
  //       throw new NullFieldException(OrderItem.class, OrderItem::getClients);
  //     }
  //   }
  //   if (clients != null) {
  //     if (count != clients.size()) {
  //       logger.error("Order item's product count must equals to its client count.");
  //       throw new InvalidProductCountException(product);
  //     }
  //     for (final Client client : clients) {
  //       client.checkField(product.getConstraint());
  //     }
  //   }
  //   return this;
  // }

  // /**
  //  * 检查此订单中的商品是否仍在销售期内。
  //  *
  //  * @param now
  //  *     当前日期时间，必须考虑当前系统时区。
  //  * @return 此订单项。
  //  */
  // public final OrderItem checkSalePeriod(final LocalDateTime now) {
  //   final Logger logger = LoggerFactory.getLogger(this.getClass());
  //   logger.info("Checking sale period of order item: now = {}, item = {}", now, this);
  //   if (product != null) {
  //     product.checkSalePeriod(now);
  //   }
  //   return this;
  // }

  // /**
  //  * 检查此订单中商品当前的库存是否足够。
  //  *
  //  * @return 此订单项。
  //  */
  // public final OrderItem checkInventory() {
  //   final Logger logger = LoggerFactory.getLogger(this.getClass());
  //   logger.info("Checking inventory of order item: {}", this);
  //   if (product == null) {
  //     logger.error("Order item product cannot be empty.");
  //     throw new NullFieldException(OrderItem.class, OrderItem::getProduct);
  //   }
  //   if (count == null) {
  //     logger.error("Order item product count cannot be empty.");
  //     throw new NullFieldException(OrderItem.class, OrderItem::getCount);
  //   }
  //   if (product.getInventory() == null) {
  //     logger.info("The inventory of the product {} is infinite.", product.getCode());
  //   } else if (product.getInventory() < count) {
  //     logger.error("There is no enough inventory of the product: {}. "
  //             + "Expected {} but there are {}.", product.getCode(),
  //             count, product.getInventory());
  //     throw new NoEnoughInventoryException(product.getInfo(), count, product.getInventory());
  //   } else {
  //     logger.info("The inventory of the product {} is enough.", product.getCode());
  //   }
  //   return this;
  // }

  /**
   * 计算此订单项的价格。
   *
   * @return 此订单项。
   */
  public final OrderItem calculate() {
    shippingCost = defaultIfNull(shippingCost, ZERO);
    discount = defaultIfNull(discount, ZERO);
    count = defaultIfNull(count, 1);
    if (product != null) {
      product.setPrice(defaultIfNull(product.getPrice(), ZERO));
      totalPrice = product.getPrice()
                          .multiply(BigDecimal.valueOf(count));
      payable = totalPrice.add(shippingCost)
                          .subtract(discount);
    }
    return this;
  }

  /**
   * 检测此订单项的金额数据是否正确。
   *
   * @param expectedPrice
   *     期望的价格
   * @param expectedShippingCost
   *     期望的运费
   * @param expectedDiscount
   *     期望的折扣
   * @return 若此订单项的金额数据正确，则返回{@code true}；否则返回{@code false}。
   */
  public final boolean isPriceValid(final BigDecimal expectedPrice,
          final BigDecimal expectedShippingCost,
          final BigDecimal expectedDiscount) {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    // 单价必须等于期望值
    if (product == null
            || product.getPrice() == null
            || product.getPrice().compareTo(expectedPrice) != 0) {
      logger.error("isPriceValid expectedPrice:{} actual:{}",
          expectedPrice, product != null ? product.getPrice() : null);
      return false;
    }
    // 运费必须等于期望值
    if (shippingCost == null || shippingCost.compareTo(expectedShippingCost) != 0) {
      logger.error("isPriceValid expectedShippingCost:{} actual:{}",
          expectedPrice, shippingCost);
      return false;
    }
    // 折扣必须等于期望值
    if (discount == null || discount.compareTo(expectedDiscount) != 0) {
      logger.error("isPriceValid expectedDiscount:{} actual:{}",
          expectedDiscount, discount);
      return false;
    }
    // 总价必须等于 单价 x 数量
    final BigDecimal expectedTotalPrice = product
        .getPrice()
        .multiply(BigDecimal.valueOf(count));
    if (count == null
            || totalPrice.compareTo(expectedTotalPrice) != 0) {

      logger.error("isPriceValid expectedTotalPrice:{} actual:{}",
          expectedTotalPrice, count != null ? totalPrice : null);
      return false;
    }
    // 应付金额必须等于  总价 + 运费 - 折扣
    if (payable == null) {
      logger.error("isPriceValid payable actual {}", payable);
      return false;
    }
    if (payable.compareTo(totalPrice.add(shippingCost).subtract(discount)) != 0) {
      logger.error("isPriceValid payable expected:{}  actual {}",
          totalPrice.add(shippingCost).subtract(discount), payable);
      return false;
    }
    return true;
  }

  /**
   * 检测此订单项的产品数量是否正确。
   *
   * @return 若此订单项的产品数量正确，则返回{@code true}；否则返回{@code false}。
   */
  public final boolean isCountValid() {
    if (count == null || count <= 0) {
      return false;
    }
    if (clients != null && clients.size() > 0) {
      // 若有客户则客户数目应该等于产品数目
      return count == clients.size();
    }
    return true;
  }

  /**
   * 根据证件查找此订单项中的客户。
   *
   * @param credential
   *     指定的证件
   * @return 拥有指定证件的客户，若没有则返回{@code null}.
   */
  public final Client findClient(final CredentialInfo credential) {
    if (clients != null) {
      for (final Client client : clients) {
        if (credential.equals(client.getCredential())) {
          return client;
        }
      }
    }
    return null;
  }

  /**
   * 获取此订单项的客户的ID列表。
   *
   * @return 此订单项的客户的ID列表；若此订单项没有客户，则返回一个空列表。
   */
  public Long[] getClientIds() {
    if (clients == null) {
      return new Long[0];
    } else {
      final Long[] result = new Long[clients.size()];
      int i = 0;
      for (final Client client : clients) {
        result[i++] = client.getId();
      }
      return result;
    }
  }

  /**
   * 计算指定数量的商品所分配的折扣。
   *
   * @param amount
   *     货物数量
   * @return 指定数量的商品所分配的折扣
   */
  public final BigDecimal calculateDiscount(final Integer amount) {
    return calculateDiscount(amount, ZERO);
  }

  /**
   * 计算指定数量的商品所分配的折扣。
   *
   * @param amount
   *     货物数量
   * @param wholeDiscount
   *     其他整体折扣
   * @return 指定数量的商品所分配的折扣
   */
  public final BigDecimal calculateDiscount(final Integer amount,
          final BigDecimal wholeDiscount) {
    if (amount == null || amount <= 0) {
      return ZERO;
    }
    // 计算当前订单项的总折扣
    BigDecimal totalDiscount = discount;
    if (totalDiscount == null || totalDiscount.signum() <= 0) {
      totalDiscount = ZERO;
    }
    // 若其他整体折扣大于0则加上其他整体折扣
    if (wholeDiscount != null && wholeDiscount.signum() > 0) {
      totalDiscount = totalDiscount.add(wholeDiscount);
    }
    // 若商品销售数量为0则返回总折扣
    if (count == null || count <= 0) {
      return totalDiscount;
    }
    // 若商品销售数量 <= 退货数量 则返回总折扣
    if (count <= amount) {
      return totalDiscount;
    }
    // 否则按比例分贝总折扣
    return totalDiscount
        .multiply(BigDecimal.valueOf(amount))
        .divide(BigDecimal.valueOf(count),
                MoneyCodec.DEFAULT_SCALE,
                MoneyCodec.DEFAULT_ROUND_MODE);
  }
}
