////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.security;

import java.io.Serializable;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 此模型封装了被签名的数据。
 *
 * @param <T>
 *     待签名的数据的类型。
 */
public final class SignedData<T> implements Serializable {

  private static final long serialVersionUID = 7381756300240916124L;

  /**
   * 待签名的数据。
   */
  private T data;

  /**
   * 对{@link #data}的数字签名。
   */
  private Signature signature;

  public T getData() {
    return data;
  }

  public void setData(final T data) {
    this.data = data;
  }

  public Signature getSignature() {
    return signature;
  }

  public void setSignature(final Signature signature) {
    this.signature = signature;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    @SuppressWarnings("unchecked")
    final SignedData<T> other = (SignedData<T>) o;
    return Equality.equals(data, other.data)
            && Equality.equals(signature, other.signature);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, data);
    result = Hash.combine(result, multiplier, signature);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("data", data)
        .append("signature", signature)
        .toString();
  }
}
