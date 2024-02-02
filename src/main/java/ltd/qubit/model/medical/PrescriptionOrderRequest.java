////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.io.Serializable;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.order.Order;

/**
 * 此模型表示向药房推送处方单、订单的消息体。
 *
 * @author 孙建
 */
public class PrescriptionOrderRequest implements Serializable {

  private static final long serialVersionUID = -7084911823963673557L;

  /**
   * 处方单具体内容。
   */
  private Prescription prescription;

  /**
   * 订单内容。
   */
  private Order order;

  public Prescription getPrescription() {
    return prescription;
  }

  public void setPrescription(final Prescription prescription) {
    this.prescription = prescription;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(final Order order) {
    this.order = order;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final PrescriptionOrderRequest other = (PrescriptionOrderRequest) o;
    return Equality.equals(prescription, other.prescription)
            && Equality.equals(order, other.order);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, prescription);
    result = Hash.combine(result, multiplier, order);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("prescription", prescription)
            .append("order", order)
            .toString();
  }
}
