////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.payment;

import java.io.Serializable;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * The BASE64 encoded response of payment system.
 *
 * @author Haixing Hu
 */
public class PaymentResponseBase64 implements Serializable {

  private static final long serialVersionUID = -571979060151698190L;

  private String data;

  public PaymentResponseBase64() {
    //  empty
  }

  public PaymentResponseBase64(final String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }

  public void setData(final String data) {
    this.data = data;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final PaymentResponseBase64 other = (PaymentResponseBase64) o;
    return Equality.equals(data, other.data);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, data);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("data", data)
            .toString();
  }
}
