////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ltd.qubit.commons.lang.Equality;

/**
 * 此枚举表示系统各个模块。
 *
 * @author 胡海星
 */
public enum Module {

  /**
   * 基本操作。
   */
  BASIC_OPERATION,

  /**
   * 系统管理。
   */
  SYSTEM_MANAGEMENT,

  /**
   * 用户管理。
   */
  USER_MANAGEMENT,

  /**
   * 签名管理。
   */
  SIGNATURE_MANAGEMENT,

  /**
   * 商品管理。
   */
  PRODUCT_MANAGEMENT,

  /**
   * 订单管理。
   */
  ORDER_MANAGEMENT,

  /**
   * 处方管理。
   */
  PRESCRIPTION_MANAGEMENT,

  /**
   * 业务系统扩展。
   */
  BUSINESS_EXTENSION,

  /**
   * 预约管理。
   */
  APPOINTMENT_MANAGEMENT,

  /**
   * 医疗服务管理。
   */
  MEDICAL_SERVICE_MANAGEMENT,

  /**
   * 排班管理。
   */
  WORK_SCHEDULE_MANAGEMENT;

  private Set<Operation> operations = null;

  /**
   * 获取此模块包含的操作。
   *
   * @return 此模块包含的操作。
   */
  public synchronized Set<Operation> getOperations() {
    if (operations == null) {
      createOperations();
    }
    return operations;
  }

  private void createOperations() {
    final Logger logger = LoggerFactory.getLogger(Module.class);
    logger.info("Creating operations for the module {}", this);
    operations = new HashSet<>();
    for (final Operation operation : Operation.values()) {
      final Module module = operation.getModule();
      if (Equality.equals(this, module)) {
        operations.add(operation);
      }
    }
    logger.info("The contained operations of module {} are: {}", this, operations);
  }
}
