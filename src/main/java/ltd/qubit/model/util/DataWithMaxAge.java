////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 一个带有{@code maxAge}属性的数据封装接口。
 *
 * <p>此对象可用在缓存中设置每个对象的存活时间。</p>
 *
 * @param <T>
 *     被封装的数据的类型。
 */
public class DataWithMaxAge<T> {

  /**
   * 被封装的对象。
   */
  private final T data;

  /**
   * 此对象的最长生命周期，单位为毫秒。
   */
  private final long maxAge;

  public DataWithMaxAge(final T data, final long maxAge) {
    this.data = data;
    this.maxAge = maxAge;
  }

  public T getData() {
    return data;
  }

  public long getMaxAge() {
    return maxAge;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final DataWithMaxAge<?> other = (DataWithMaxAge<?>) o;
    return Equality.equals(data, other.data)
        && Equality.equals(maxAge, other.maxAge);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, data);
    result = Hash.combine(result, multiplier, maxAge);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("data", data)
        .append("maxAge", maxAge)
        .toString();
  }
}
