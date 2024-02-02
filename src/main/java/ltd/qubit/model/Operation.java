////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model;

/**
 * 此枚举表示各类操作。
 *
 * @author 胡海星
 */
public enum Operation {

  /**
   * 注册。
   */
  REGISTER(Module.BASIC_OPERATION),

  /**
   * 检测用户名是否存在。
   */
  TEST_USERNAME_EXISTENCE(Module.BASIC_OPERATION),

  /**
   * 验证用户名是否合法。
   */
  VALIDATE_USERNAME(Module.BASIC_OPERATION),

  /**
   * 验证密码是否合法。
   */
  VALIDATE_PASSWORD(Module.BASIC_OPERATION),

  /**
   * 查看个人资料。
   */
  VIEW_PROFILE(Module.BASIC_OPERATION),

  /**
   * 修改个人资料。
   */
  CHANGE_PROFILE(Module.BASIC_OPERATION),

  //  /**
  //   * 修改自己的电子邮件地址
  //   */
  //  CHANGE_EMAIL(Module.BASIC_OPERATION),
  //
  //  /**
  //   * 验证自己的电子邮件地址
  //   */
  //  VERIFY_EMAIL(Module.BASIC_OPERATION),
  //
  //  /**
  //   * 修改自己的手机号码
  //   */
  //  CHANGE_MOBILE(Module.BASIC_OPERATION),
  //
  //  /**
  //   * 验证自己的手机号码
  //   */
  //  VERIFY_MOBILE(Module.BASIC_OPERATION),

  /**
   * 修改自己的密码。
   */
  CHANGE_PASSWORD(Module.BASIC_OPERATION),

  /**
   * 重置自己的密码。
   */
  RESET_PASSWORD(Module.BASIC_OPERATION),

  /**
   * 发送验证码。
   */
  SEND_VERIFY_CODE(Module.BASIC_OPERATION),

  //  /**
  //   * 浏览系统设置
  //   */
  //  LIST_SETTING(Module.SYSTEM_MANAGEMENT),
  //
  //  /**
  //   * 查看系统设置
  //   */
  //  VIEW_SETTING(Module.SYSTEM_MANAGEMENT),
  //
  //  /**
  //   * 导入系统设置
  //   */
  //  IMPORT_SETTING(Module.SYSTEM_MANAGEMENT),
  //
  //  /**
  //   * 导出系统设置
  //   */
  //  EXPORT_SETTING(Module.SYSTEM_MANAGEMENT),
  //
  //  /**
  //   * 修改系统设置
  //   */
  //  MODIFY_SETTING(Module.SYSTEM_MANAGEMENT),
  //
  //  /**
  //   * 查看系统活动
  //   */
  //  LIST_ACTIVITY(Module.SYSTEM_MANAGEMENT),
  //
  //  /**
  //   * 导出系统活动
  //   */
  //  EXPORT_ACTIVITY(Module.SYSTEM_MANAGEMENT),
  //
  //  /**
  //   * 查看系统状态
  //   */
  //  VIEW_SYSTEM_STATUS(Module.SYSTEM_MANAGEMENT),
  //
  //  /**
  //   * 查看系统日志
  //   */
  //  VIEW_SYSTEM_LOG(Module.SYSTEM_MANAGEMENT),
  //
  //  /**
  //   * 下载系统日志
  //   */
  //  DOWNLOAD_SYSTEM_LOG(Module.SYSTEM_MANAGEMENT),
  //
  //  /**
  //   * 重启系统
  //   */
  //  RESTART_SYSTEM(Module.SYSTEM_MANAGEMENT),
  //
  //  /**
  //   * 关闭系统
  //   */
  //  SHUTDOWN_SYSTEM(Module.SYSTEM_MANAGEMENT);

  /**
   * 登入。
   */
  LOGIN(Module.BASIC_OPERATION),
  /**
   * 登出。
   */
  LOGOUT(Module.BASIC_OPERATION),

  /**
   * 获取系统设置列表。
   */
  LIST_SETTING(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取系统设置信息。
   */
  GET_SETTING(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建系统设置。
   */
  ADD_SETTING(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新系统设置。
   */
  UPDATE_SETTING(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取系统审计日志列表。
   */
  LIST_AUDIT(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取系统审计日志信息。
   */
  GET_AUDIT(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取国家列表。
   */
  LIST_COUNTRY(Module.SYSTEM_MANAGEMENT),
  /**
   * 获取国家信息。
   */
  GET_COUNTRY(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建国家。
   */
  ADD_COUNTRY(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新国家信息。
   */
  UPDATE_COUNTRY(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除国家。
   */
  DELETE_COUNTRY(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取省份列表。
   */
  LIST_PROVINCE(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取省份。
   */
  GET_PROVINCE(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建省份。
   */
  ADD_PROVINCE(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新省份信息。
   */
  UPDATE_PROVINCE(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除省份。
   */
  DELETE_PROVINCE(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取城市列表。
   */
  LIST_CITY(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取城市信息。
   */
  GET_CITY(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建城市。
   */
  ADD_CITY(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新城市信息。
   */
  UPDATE_CITY(Module.SYSTEM_MANAGEMENT),

  /**
   * 删除城市。
   */
  DELETE_CITY(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取区县列表。
   */
  LIST_DISTRICT(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取区县信息。
   */
  GET_DISTRICT(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建区县。
   */
  ADD_DISTRICT(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新区县信息。
   */
  UPDATE_DISTRICT(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除区县。
   */
  DELETE_DISTRICT(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取街道列表。
   */
  LIST_STREET(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取街道信息。
   */
  GET_STREET(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建街道。
   */
  ADD_STREET(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新街道信息。
   */
  UPDATE_STREET(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除街道。
   */
  DELETE_STREET(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取实体类别列表。
   */
  LIST_CATEGORY(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取实体类别信息。
   */
  GET_CATEGORY(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建实体类别。
   */
  ADD_CATEGORY(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新实体类别信息。
   */
  UPDATE_CATEGORY(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除实体类别。
   */
  DELETE_CATEGORY(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取组织结构列表。
   */
  LIST_ORGANIZATION(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取组织机构信息。
   */
  GET_ORGANIZATION(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建组织机构。
   */
  ADD_ORGANIZATION(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新组织机构信息。
   */
  UPDATE_ORGANIZATION(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除组织机构。
   */
  DELETE_ORGANIZATION(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取应用列表。
   */
  LIST_APP(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取应用信息。
   */
  GET_APP(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建应用。
   */
  ADD_APP(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新应用信息。
   */
  UPDATE_APP(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除应用。
   */
  DELETE_APP(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取来源渠道列表。
   */
  LIST_SOURCE(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取来源渠道信息。
   */
  GET_SOURCE(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建来源渠道。
   */
  ADD_SOURCE(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新来源渠道信息。
   */
  UPDATE_SOURCE(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除来源渠道。
   */
  DELETE_SOURCE(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取字典列表。
   */
  LIST_DICT(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取字典信息。
   */
  GET_DICT(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建字典。
   */
  ADD_DICT(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新字典信息。
   */
  UPDATE_DICT(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除字典。
   */
  DELETE_DICT(Module.SYSTEM_MANAGEMENT),

  /**
   * 根据字典获取字典条目列表。
   */
  LIST_DICT_FOR(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取字典条目列表。
   */
  LIST_DICT_ENTRY(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取字典条目信息。
   */
  GET_DICT_ENTRY(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建字典条目。
   */
  ADD_DICT_ENTRY(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新字典条目信息。
   */
  UPDATE_DICT_ENTRY(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除字典条目。
   */
  DELETE_DICT_ENTRY(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取编码映射列表。
   */
  LIST_CODE_MAP(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取编码映射信息。
   */
  GET_CODE_MAP(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建编码映射。
   */
  ADD_CODE_MAP(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新编码映射信息。
   */
  UPDATE_CODE_MAP(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除编码映射。
   */
  DELETE_CODE_MAP(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取部门列表。
   */
  LIST_DEPARTMENT(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取部门信息。
   */
  GET_DEPARTMENT(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建部门。
   */
  ADD_DEPARTMENT(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新部门信息。
   */
  UPDATE_DEPARTMENT(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除部门。
   */
  DELETE_DEPARTMENT(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取员工列表。
   */
  LIST_EMPLOYEE(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取员工信息。
   */
  GET_EMPLOYEE(Module.SYSTEM_MANAGEMENT),

  /**
   * 创建员工。
   */
  ADD_EMPLOYEE(Module.SYSTEM_MANAGEMENT),

  /**
   * 更新员工信息。
   */
  UPDATE_EMPLOYEE(Module.SYSTEM_MANAGEMENT),

  /**
   * 标记删除员工。
   */
  DELETE_EMPLOYEE(Module.SYSTEM_MANAGEMENT),

  /**
   * 获取系统角色列表。
   */
  LIST_ROLE(Module.USER_MANAGEMENT),

  /**
   * 获取系统角色信息。
   */
  GET_ROLE(Module.USER_MANAGEMENT),

  /**
   * 创建系统角色。
   */
  ADD_ROLE(Module.USER_MANAGEMENT),

  /**
   * 更新系统角色信息。
   */
  UPDATE_ROLE(Module.USER_MANAGEMENT),

  /**
   * 标记删除系统角色。
   */
  DELETE_ROLE(Module.USER_MANAGEMENT),

  /**
   * 获取系统所有操作列表。
   */
  LIST_OPERATION(Module.USER_MANAGEMENT),

  /**
   * 获取用户列表。
   */
  LIST_USER(Module.USER_MANAGEMENT),

  /**
   * 获取用户信息。
   */
  GET_USER(Module.USER_MANAGEMENT),

  /**
   * 创建用户。
   */
  ADD_USER(Module.USER_MANAGEMENT),

  /**
   * 更新用户信息。
   */
  UPDATE_USER(Module.USER_MANAGEMENT),

  /**
   * 删除用户。
   */
  DELETE_USER(Module.USER_MANAGEMENT),

  /**
   * 获取用户角色列表。
   */
  LIST_USER_ROLE(Module.USER_MANAGEMENT),

  /**
   * 更新用户角色。
   */
  UPDATE_USER_ROLE(Module.USER_MANAGEMENT),

  /**
   * 更新用户密码。
   */
  UPDATE_USER_PASSWORD(Module.USER_MANAGEMENT),

  /**
   * 获取非对称秘钥对列表。
   */
  LIST_KEY_PAIR(Module.SIGNATURE_MANAGEMENT),

  /**
   * 获取非对称秘钥对信息。
   */
  GET_KEY_PAIR(Module.SIGNATURE_MANAGEMENT),

  /**
   * 创建非对称秘钥对。
   */
  ADD_KEY_PAIR(Module.SIGNATURE_MANAGEMENT),

  /**
   * 更新非对称秘钥对信息。
   */
  UPDATE_KEY_PAIR_STATE(Module.SIGNATURE_MANAGEMENT),

  /**
   * 标记删除非对称秘钥对。
   */
  DELETE_KEY_PAIR(Module.SIGNATURE_MANAGEMENT),

  /**
   * 获取数字签名列表。
   */
  LIST_SIGNATURE(Module.SIGNATURE_MANAGEMENT),

  /**
   * 获取数字签名信息。
   */
  GET_SIGNATURE(Module.SIGNATURE_MANAGEMENT),

  /**
   * 创建数字签名。
   */
  ADD_SIGNATURE(Module.SIGNATURE_MANAGEMENT),

  /**
   * 标记删除数字签名。
   */
  DELETE_SIGNATURE(Module.SIGNATURE_MANAGEMENT),

  /**
   * 对消息进行数字签名。
   */
  SIGN_SIGNATURE(Module.SIGNATURE_MANAGEMENT),

  /**
   * 验证消息的数字签名。
   */
  VERIFY_SIGNATURE(Module.SIGNATURE_MANAGEMENT),

  /**
   * 获取商品列表。
   */
  LIST_PRODUCT(Module.PRODUCT_MANAGEMENT),

  /**
   * 获取商品信息。
   */
  GET_PRODUCT(Module.PRODUCT_MANAGEMENT),

  /**
   * 创建商品。
   */
  ADD_PRODUCT(Module.PRODUCT_MANAGEMENT),

  /**
   * 更新商品信息。
   */
  UPDATE_PRODUCT(Module.PRODUCT_MANAGEMENT),

  /**
   * 标记删除商品。
   */
  DELETE_PRODUCT(Module.PRODUCT_MANAGEMENT),

  /**
   * 获取订单列表。
   */
  LIST_ORDER(Module.ORDER_MANAGEMENT),

  /**
   * 取消订单。
   */
  CANCEL_ORDER(Module.ORDER_MANAGEMENT),

  /**
   * 获取订单信息。
   */
  GET_ORDER(Module.ORDER_MANAGEMENT),

  /**
   * 提交订单。
   */
  SUBMIT_ORDER(Module.ORDER_MANAGEMENT),

  /**
   * 提交订单，返回Base64编码的支付请求。
   */
  SUBMIT_ORDER_BASE64(Module.ORDER_MANAGEMENT),

  /**
   * 获取订单详情列表。
   */
  LIST_ORDER_DETAIL(Module.ORDER_MANAGEMENT),

  /**
   * 获取指定订单详情。
   */
  GET_ORDER_DETAIL(Module.ORDER_MANAGEMENT),

  /**
   * 获取指定订单物流信息。
   */
  GET_ORDER_SHIPPING(Module.ORDER_MANAGEMENT),

  /**
   * 更新指定订单物流单号。
   */
  UPDATE_ORDER_SHIPPING_NUMBER(Module.ORDER_MANAGEMENT),

  /**
   * 获取收货人信息列表。
   */
  LIST_CONSIGNEE(Module.ORDER_MANAGEMENT),

  /**
   * 获取收货人信息。
   */
  GET_CONSIGNEE(Module.ORDER_MANAGEMENT),

  /**
   * 创建收货人。
   */
  ADD_CONSIGNEE(Module.ORDER_MANAGEMENT),

  /**
   * 更新收货人信息。
   */
  UPDATE_CONSIGNEE(Module.ORDER_MANAGEMENT),

  /**
   * 删除收货人。
   */
  DELETE_CONSIGNEE(Module.ORDER_MANAGEMENT),

  /**
   * 提交退货申请。
   */
  APPLY_RETURN(Module.ORDER_MANAGEMENT),

  /**
   * 提交退货记录并开始退款。
   */
  SUBMIT_RETURN(Module.ORDER_MANAGEMENT),

  /**
   * 获取交易记录。
   */
  GET_TRANSACTION(Module.ORDER_MANAGEMENT),

  /**
   * 根据交易流水号获取交易记录。
   */
  GET_TRANSACTION_BY_NUMBER(Module.ORDER_MANAGEMENT),

  /**
   * 根据渠道交易流水号获取交易记录。
   */
  GET_TRANSACTION_BY_CHANNEL_NUMBER(Module.ORDER_MANAGEMENT),

  /**
   * 提交支付记录。
   */
  SUBMIT_PAYMENT(Module.ORDER_MANAGEMENT),

  /**
   * 提交Base64编码的支付记录。
   */
  SUBMIT_PAYMENT_BASE64(Module.ORDER_MANAGEMENT),

  /**
   * 获取疾病列表。
   */
  LIST_DISEASE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取疾病信息。
   */
  GET_DISEASE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 创建疾病。
   */
  ADD_DISEASE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 更新疾病信息。
   */
  UPDATE_DISEASE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 标记删除疾病。
   */
  DELETE_DISEASE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取药品列表。
   */
  LIST_DRUG(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取药品信息。
   */
  GET_DRUG(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 创建药品。
   */
  ADD_DRUG(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 更新药品信息。
   */
  UPDATE_DRUG(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 标记删除药品。
   */
  DELETE_DRUG(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取患者列表。
   */
  LIST_PATIENT(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取患者信息。
   */
  GET_PATIENT(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 创建患者。
   */
  ADD_PATIENT(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 更新患者信息。
   */
  UPDATE_PATIENT(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 标记删除患者。
   */
  DELETE_PATIENT(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取处方列表。
   */
  LIST_PRESCRIPTION(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取处方信息。
   */
  GET_PRESCRIPTION(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 提交处方。
   */
  SUBMIT_PRESCRIPTION(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 更新处方状态。
   */
  UPDATE_PRESCRIPTION(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 标记删除处方。
   */
  DELETE_PRESCRIPTION(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 根据处方获取可选择订单方案。
   */
  LIST_PRESCRIPTION_ORDER_PREPARED(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 提交处方订单。
   */
  SUBMIT_PRESCRIPTION_ORDER(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 提交处方支付信息。
   */
  SUBMIT_PRESCRIPTION_PAYMENT(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 根据订单获取处方。
   */
  GET_PRESCRIPTION_BY_ORDER(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 申请处方单取药验证码。
   */
  SEND_PRESCRIPTION_VERIFY_CODE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 验证处方单取药验证码。
   */
  CHECK_PRESCRIPTION_VERIFY_CODE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取医院药店关联关系列表。
   */
  LIST_HOSPITAL_DRUGSTORE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取医院药店关联关系。
   */
  GET_HOSPITAL_DRUGSTORE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 创建医院药店关联关系。
   */
  ADD_HOSPITAL_DRUGSTORE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 删除医院药店关联关系。
   */
  DELETE_HOSPITAL_DRUGSTORE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取指定的医院的外延药品列表。
   */
  LIST_HOSPITAL_DRUGSTORE_DRUG(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取指定的医院的疾病信息列表。
   */
  LIST_HOSPITAL_DRUGSTORE_DISEASE(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 获取指定的医院在合作药店的商品列表。
   */
  LIST_HOSPITAL_DRUGSTORE_PRODUCT(Module.PRESCRIPTION_MANAGEMENT),

  /**
   * 请求。
   */
  REQUEST(Module.BASIC_OPERATION),

  /**
   * 更新预约。
   */
  ADD_APPOINTMENT(Module.APPOINTMENT_MANAGEMENT),

  /**
   * 查询预约列表。
   */
  LIST_APPOINTMENT(Module.APPOINTMENT_MANAGEMENT),

  /**
   * 更新预约。
   */
  UPDATE_APPOINTMENT(Module.APPOINTMENT_MANAGEMENT),

  /**
   * 查询用户医疗服务。
   */
  GET_USER_MEDICAL_SERVICE(Module.MEDICAL_SERVICE_MANAGEMENT),

  /**
   * 查询用户医疗服务列表。
   */
  LIST_USER_MEDICAL_SERVICE(Module.MEDICAL_SERVICE_MANAGEMENT),

  /**
   * 更新用户医疗服务。
   */
  UPDATE_USER_MEDICAL_SERVICE(Module.MEDICAL_SERVICE_MANAGEMENT),

  /**
   * 查询排班列表。
   */
  LIST_WORK_SCHEDULE(Module.WORK_SCHEDULE_MANAGEMENT),

  /**
   * FIXME: 这是干什么的？
   *
   * <p>by Haixing Hu
   */
  BUSINESS_EXTENDING(Module.BUSINESS_EXTENSION);

  private Module module;

  Operation(final Module module) {
    this.module = module;
  }

  /**
   * Gets the module this operation belongs to.
   *
   * @return the module this operation belongs to, which cannot be {@code null}.
   */
  public Module getModule() {
    return module;
  }
}
