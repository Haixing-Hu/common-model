////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import ltd.qubit.commons.annotation.NoAutoTest;

/**
 * 此接口表示模型具有时钟对象。
 *
 * @author 胡海星
 */
public interface HasClock {

  /**
   * 获取此模型具有的时钟对象。
   *
   * @return
   *     此模型具有的时钟对象。
   */
  @NoAutoTest
  Clock getClock();

  /**
   * 获取内部时钟的当前时刻，精确到秒。
   *
   * <p><b>注意：</b>因为我们将时间戳用MySQL的{@code DATETIME}类型存储在数据库内部，所以
   * 所有对象的时间戳必须截断到秒。否则，单元测试时比较时间戳会遇到麻烦。</p>
   *
   * @return
   *     内部时钟的当前时刻，精确到秒。
   */
  @NoAutoTest
  default Instant now() {
    final Clock clock = getClock();
    return Instant.ofEpochMilli(clock.millis())
                  .truncatedTo(ChronoUnit.SECONDS);
  }
}
