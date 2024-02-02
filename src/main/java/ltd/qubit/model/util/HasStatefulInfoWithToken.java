////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import ltd.qubit.commons.annotation.Computed;

/**
 * 此接口表示实体类具有带状态的基本信息。
 *
 * @author 胡海星
 */
@SuppressWarnings("serial")
public interface HasStatefulInfoWithToken extends HasStatefulInfo, WithToken {

  /**
   * 获取当前对象的基本信息。
   *
   * @return
   *     当前对象的基本信息。
   */
  @Computed({"id", "code", "name", "state", "token"})
  @Override
  default StatefulInfoWithToken getInfo() {
    return new StatefulInfoWithToken(getId(), getCode(), getName(), getState(), getToken());
  }
}
