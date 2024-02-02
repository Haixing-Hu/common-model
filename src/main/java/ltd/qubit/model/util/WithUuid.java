////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

/**
 * 此接口表示实体类具有UUID属性。
 *
 * @author 胡海星
 */
public interface WithUuid {

  /**
   * 获取当前对象的UUID。
   *
   * @return
   *     当前对象的UUID。
   */
  String getUuid();

  /**
   * 设置当前对象的UUID。
   *
   * @param uuid
   *     待设置的新的UUID。
   */
  void setUuid(String uuid);
}
