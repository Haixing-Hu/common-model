////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import ltd.qubit.commons.lang.CloneableEx;

/**
 * 此接口表示实体类可进行脱敏操作。
 *
 * @author 胡海星
 */
public interface Desensitizable<T> extends CloneableEx<T> {

  T clone();

  /**
   * 对此对象进行脱敏操作。
   */
  void desensitize();

  /**
   * 获取当前对象进过脱敏的克隆拷贝。
   *
   * @return
   *     当前对象进过脱敏的克隆拷贝。
   */
  @SuppressWarnings("unchecked")
  default T desensitizedClone() {
    final T result = this.clone();
    ((Desensitizable<T>) result).desensitize();
    return result;
  }
}
