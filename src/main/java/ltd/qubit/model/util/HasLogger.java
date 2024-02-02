////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import org.slf4j.Logger;

import ltd.qubit.commons.annotation.NoAutoTest;

/**
 * 此接口表示对象具有logger。
 *
 * @author 胡海星
 */
public interface HasLogger {

  /**
   * 获取此对象的logger.
   *
   * @return
   *     此对象的logger.
   */
  @NoAutoTest
  Logger getLogger();
}
