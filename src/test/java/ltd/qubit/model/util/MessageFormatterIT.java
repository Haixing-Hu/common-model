////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.model.person.Gender;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageFormatterIT {

  private ApplicationContext getContext() {
    return new ClassPathXmlApplicationContext("classpath:spring/common-model/message-formatter.xml");
  }

  @Test
  public void testGetErrorMessage() {
    final ApplicationContext context = getContext();
    final MessageFormatter formatter = context.getBean(MessageFormatter.class);
    final KeyValuePair[] params = {
        new KeyValuePair("entity", "app"),
        new KeyValuePair("token", "xxx"),
        new KeyValuePair("key", "token"),
        new KeyValuePair("value", "xxx"),
        new KeyValuePair("message", "未知原因"),
    };
    String msg = "";

    msg = formatter.getErrorMessage("INVALID_TOKEN", params);
    assertEquals("应用的令牌不正确: xxx", msg);

    msg = formatter.getErrorMessage("DELETED", params);
    assertEquals("指定的应用已被删除，请与系统管理员联系：xxx", msg);

    msg = formatter.getErrorMessage("INACTIVE", params);
    assertEquals("指定的应用未被激活，请与系统管理员联系：xxx", msg);

    msg = formatter.getErrorMessage("LOCKED", params);
    assertEquals("指定的应用已被锁定，请与系统管理员联系：xxx", msg);

    msg = formatter.getErrorMessage("BLOCKED", params);
    assertEquals("指定的应用已被屏蔽，请与系统管理员联系：xxx", msg);

    msg = formatter.getErrorMessage("DISABLED", params);
    assertEquals("指定的应用已被禁用，请与系统管理员联系：xxx", msg);

    msg = formatter.getErrorMessage("NOT_EXIST", params);
    assertEquals("指定的应用不存在：xxx", msg);

    msg = formatter.getErrorMessage("TOKEN_EXPIRED", params);
    assertEquals("应用的令牌已过期：xxx", msg);
//
//    msg = formatter.getErrorMessage("VERIFICATION_TOKEN_MISMATCH", params);
//    assertEquals("应用的令牌不匹配：xxx", msg);

    msg = formatter.getErrorMessage("DATABASE_ERROR", params);
    assertEquals("访问数据库发生错误，请与系统管理员联系：未知原因", msg);

    msg = formatter.getErrorMessage("SECURITY_KEY_MISMATCH", params);
    assertEquals("应用的安全密钥不正确：xxx", msg);
  }

  @Test
  public void testGetErrorMessage_TooManyAuthenticationFailures() {
    final ApplicationContext context = getContext();
    final MessageFormatter formatter = context.getBean(MessageFormatter.class);
    final KeyValuePair[] params = {new KeyValuePair("entity", "app"),
        new KeyValuePair("key", "name"), new KeyValuePair("value", "系统主程序"),
        new KeyValuePair("duration", "600"),};
    final String msg = formatter.getErrorMessage("TOO_MANY_AUTHENTICATION_FAILURES", params);
    assertEquals("“系统主程序”在短时间内连续多次认证错误，出于安全考虑，"
        + "系统将暂时禁止该应用的认证操作，请在10分钟后再重新尝试", msg);
  }

  @Test
  public void testGetErrorMessage_InvalidStatus() {
    final ApplicationContext context = getContext();
    final MessageFormatter formatter = context.getBean(MessageFormatter.class);
    final KeyValuePair[] params1 = {
        new KeyValuePair("entity", "app"),
        new KeyValuePair("status_class", Gender.class.getName()),
        new KeyValuePair("status", "male"),
    };
    final String msg1 = formatter.getErrorMessage("INVALID_STATUS", params1);
    assertEquals("应用的状态错误，请与系统管理员联系：男", msg1);

    final KeyValuePair[] params2 = {
        new KeyValuePair("entity", "app"),
        new KeyValuePair("status_class", "xxx"),
        new KeyValuePair("status", "male"),
    };
    final String msg2 = formatter.getErrorMessage("INVALID_STATUS", params2);
    assertEquals("应用的状态错误，请与系统管理员联系：MALE", msg2);

    final KeyValuePair[] params3 = {
        new KeyValuePair("entity", "app"),
        new KeyValuePair("status_class", Gender.class.getName()),
        new KeyValuePair("status", null),
    };
    final String msg3 = formatter.getErrorMessage("INVALID_STATUS", params3);
    assertEquals("应用的状态错误，请与系统管理员联系：[未知]", msg3);
  }
}
