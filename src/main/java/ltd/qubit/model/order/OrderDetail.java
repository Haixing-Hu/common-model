////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.order;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.settlement.Transaction;

/**
 * 此模型表示订单及其对应的交易。
 *
 * @author 胡海星
 */
public class OrderDetail implements Serializable {

  private static final long serialVersionUID = 7300851387974175257L;

  /**
   * 订单。
   */
  private Order order;

  /**
   * 该订单对应的所有交易。
   */
  @Nullable
  private List<Transaction> transactions;

  /**
   * 该订单对应的所有退货记录。
   */
  @Nullable
  private List<Return> returns;

  public OrderDetail() {}

  public OrderDetail(final Order order, final Transaction transaction) {
    this.order = order;
    this.transactions = Arrays.asList(transaction);
  }

  public OrderDetail(final Order order, final Transaction transaction, final Return ret) {
    this.order = order;
    this.transactions = Arrays.asList(transaction);
    this.returns = Arrays.asList(ret);
  }

  public OrderDetail(final Order order, final List<Transaction> transactions) {
    this.order = order;
    this.transactions = transactions;
  }

  public OrderDetail(final Order order, final List<Transaction> transactions,
      final List<Return> returns) {
    this.order = order;
    this.transactions = transactions;
    this.returns = returns;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(final Order order) {
    this.order = order;
  }

  @Nullable
  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(@Nullable final List<Transaction> transactions) {
    this.transactions = transactions;
  }

  @Nullable
  public List<Return> getReturns() {
    return returns;
  }

  public void setReturns(@Nullable final List<Return> returns) {
    this.returns = returns;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final OrderDetail other = (OrderDetail) o;
    return Equality.equals(order, other.order)
            && Equality.equals(transactions, other.transactions)
            && Equality.equals(returns, other.returns);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, order);
    result = Hash.combine(result, multiplier, transactions);
    result = Hash.combine(result, multiplier, returns);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("order", order)
            .append("transactions", transactions)
            .append("returns", returns)
            .toString();
  }
}
