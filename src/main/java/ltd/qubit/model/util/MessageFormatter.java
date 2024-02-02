////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Nullable;

import jakarta.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ltd.qubit.commons.error.ErrorInfo;
import ltd.qubit.commons.error.ErrorInfoConvertable;
import ltd.qubit.commons.error.NoSuchMessageException;
import ltd.qubit.commons.i18n.message.MessageSource;
import ltd.qubit.commons.lang.EnumUtils;
import ltd.qubit.commons.text.Replacer;
import ltd.qubit.commons.util.HumanReadable;
import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.commons.util.pair.KeyValuePairList;
import ltd.qubit.model.Entity;
import ltd.qubit.model.commons.CredentialType;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.person.Gender;

import static ltd.qubit.commons.lang.EnumUtils.getEnumClass;

/**
 * 消息格式化工具。
 *
 * @author 胡海星
 */
public class MessageFormatter {

  /**
   * The prefix for the keys of error messages, which is {@value}.
   */
  public static final String ERROR_PREFIX = "error.";

  /**
   * The prefix for the keys of entity types, which is {@value}.
   */
  public static final String ENTITY_PREFIX = "entity.";

  /**
   * The prefix for the keys of field names, which is {@value}.
   */
  public static final String FIELD_PREFIX = "field.";

  /**
   * The infix for the keys of field names, which is {@value}.
   */
  public static final String FIELD_INFIX = ".field.";

  /**
   * The prefix for the keys of operation names, which is {@value}.
   */
  public static final String OPERATION_PREFIX = "operation.";

  /**
   * The prefix for the keys of a boolean value indicating success or failure,
   * which is {@value}.
   */
  public static final String SUCCESS_PREFIX = "success.";

  /**
   * The prefix for the keys of attachment types, which is {@value}.
   */
  public static final String ATTACHMENT_TYPE_PREFIX = "attachment.";

  public static final String DURATION_SECONDS = "time.duration.seconds";

  public static final String DURATION_MINUTES = "time.duration.minutes";

  public static final String DURATION_HOURS = "time.duration.hours";

  public static final String DURATION_DAYS = "time.duration.days";

  public static final String UNKNOWN = "unknown";

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final Locale locale;
  private final MessageSource messageSource;

  public MessageFormatter(final Locale locale, final MessageSource messageSource) {
    this.locale = locale;
    this.messageSource = messageSource;
  }

  public final Locale getLocale() {
    return locale;
  }

  public final MessageSource getMessageSource() {
    return messageSource;
  }

  /**
   * 获取格式化消息。
   *
   * <p>注意：此函数只能格式化包含形如"{0}", "{1}"这样占位符的消息模板。</p>
   *
   * @param key
   *     消息模板的主键。
   * @param params
   *     用于格式化消息的参数。
   * @return
   *     格式化后的消息。
   */
  public String getMessage(final String key, final Object ... params) {
    try {
      return messageSource.getMessage(key, params, locale);
    } catch (final NoSuchMessageException exception) {
      logger.warn("Cannot find the message template for '{}'.", key);
      return key;
    }
  }

  /**
   * 从指定的错误异常对象获取格式化后的错误消息。
   *
   * @param e
   *     指定的错误异常对象。
   */
  public final <T extends Throwable & ErrorInfoConvertable>
  String getErrorMessage(final T e) {
    final ErrorInfo info = e.toErrorInfo();
    return getErrorMessage(info.getCode(), info.getParams());
  }

  /**
   * 从指定的错误信息对象获取格式化后的错误消息。
   *
   * @param error
   *     指定的错误信息对象。
   */
  public final String getErrorMessage(final ErrorInfo error) {
    if (error.getParams() == null) {
      return getErrorMessage(error.getCode());
    } else {
      return getErrorMessage(error.getCode(), error.getParams().toArray());
    }
  }

  /**
   * 从指定的错误代码和参数获取格式化后的错误消息。
   *
   * @param errorCode
   *     指定的错误代码。
   * @param errorParams
   *     指定的错误参数。
   */
  public final String getErrorMessage(final String errorCode,
      final KeyValuePair... errorParams) {
    return getErrorMessage(errorCode, KeyValuePairList.ofArray(errorParams));
  }

  /**
   * 从指定的错误代码和参数获取格式化后的错误消息。
   *
   * @param errorCode
   *     指定的错误代码。
   * @param errorParams
   *     指定的错误参数。
   */
  public final <E extends Enum<E>> String getErrorMessage(final E errorCode,
      final KeyValuePair... errorParams) {
    return getErrorMessage(errorCode.name(), KeyValuePairList.ofArray(errorParams));
  }

  /**
   * 从指定的错误代码和参数获取格式化后的错误消息。
   *
   * @param errorCode
   *     指定的错误代码。
   * @param errorParams
   *     指定的错误参数。
   */
  public final String getErrorMessage(final String errorCode,
      final KeyValuePairList errorParams) {
    final String messageKey = ERROR_PREFIX + errorCode.toLowerCase();
    final List<String> params = new ArrayList<>();
    final String originalTemplate = getMessage(messageKey);
    if (originalTemplate == null) {
      final String message = "Cannot find the message template for " +  messageKey;
      logger.error(message);
      return message;
    }
    final String template = translateTemplate(originalTemplate, errorParams, params);
    logger.debug("Getting message of template '{}': {}", template, params);
    return MessageFormat.format(template, params.toArray());
  }

  /**
   * 从指定的错误代码和参数获取格式化后的错误消息。
   *
   * @param errorCode
   *     指定的错误代码。
   * @param errorParams
   *     指定的错误参数。
   */
  public final <E extends Enum<E>> String getErrorMessage(final E errorCode,
      final KeyValuePairList errorParams) {
    return getErrorMessage(errorCode.name(), errorParams);
  }

  private String translateTemplate(@NotNull final String template,
      final KeyValuePairList params, final List<String> translatedParams) {
    assert template != null;
    int index = 0;
    translatedParams.clear();
    String result = template;
    final Replacer replacer = new Replacer().ignoreCase(false);
    for (final KeyValuePair param : params) {
      final String key = param.getKey();
      final String value = param.getValue();
      final String placeholder = "{" + key + "}";
      if (result != null && result.contains(placeholder)) {
        final String replaced = "{" + index + "}";
        result = replacer.searchForSubstring(placeholder)
                         .replaceWithString(replaced)
                         .applyTo(result);
        translatedParams.add(translateValue(key, value, params));
        ++index;
      }
    }
    return result;
  }

  private String translateValue(final String key, final String value,
      final KeyValuePairList params) {
    if (key.equals("entity") || key.endsWith("_entity")) {
      return getEntity(value);
    }
    if (key.equals("field") || key.endsWith("_field")) {
      return getField(value);
    }
    if (key.equals("gender") || key.equals("_gender")) {
      return getEnumLocalizedName(Gender.class, value);
    }
    if (key.equals("credential_type") || key.equals("_credential_type")) {
      return getEnumLocalizedName(CredentialType.class, value);
    }
    if (key.equals("currency") || key.equals("_currency")) {
      return getEnumLocalizedName(Currency.class, value);
    }
    if (key.equals("duration") || key.endsWith("_duration")) {
      return getDuration(value);
    }
    if (key.equals("file_size") || key.endsWith("_file_size")) {
      return getFileSize(value);
    }
    if (key.equals("success")
        && (value == null
          || value.isEmpty()
          || value.equalsIgnoreCase("true")
          || value.equalsIgnoreCase("false"))) {
      return getSuccessValue(value);
    }
    if (key.equals("status") || key.equals("_status")) {
      if (value == null || value.isEmpty()) {
        return getMessage(UNKNOWN);
      } else {
        return getStatus(key, value, params);
      }
    }
    return value;
  }

  public String getEntity(@Nullable final String entity) {
    if (entity == null) {
      return getMessage(UNKNOWN);
    }
    //  final String key = ENTITY_PREFIX + entity.toLowerCase();
    //  return getMessage(key);
    return getEnumLocalizedName(Entity.class, entity);
  }

  public String getField(@Nullable final String field) {
    if (field == null) {
      return getMessage(UNKNOWN);
    }
    final String key = FIELD_PREFIX + field.toLowerCase();
    return getMessage(key);
  }

  public String getField(@Nullable final String entity, @Nullable final String field) {
    if (entity == null || field == null) {
      return getMessage(UNKNOWN);
    }
    final String key = entity.toLowerCase() + FIELD_INFIX + field.toLowerCase();
    return getMessage(key);
  }

  public String getOperation(@Nullable final String operation, @Nullable final String entity) {
    if (operation == null) {
      return getMessage(UNKNOWN);
    }
    final String key = OPERATION_PREFIX + operation.toLowerCase();
    if (entity == null) {
      return getMessage(key);
    } else {
      return getMessage(key, getEntity(entity));
    }
  }

  public String getEnumLocalizedName(final Class<? extends Enum<?>> cls,
          @Nullable final String name) {
    if (name == null || name.isEmpty()) {
      return getMessage(UNKNOWN);
    }
    final String enumName = name.toUpperCase();
    final Enum<?> value = EnumUtils.valueOf(cls, enumName);
    if (value == null) {
      logger.error("Unknown localized name of '{}' of the enumeration class {}",
          enumName, cls);
      return enumName;
    } else {
      return EnumUtils.getLocalizedName(locale, value);
    }
  }

  private static final long SECONDS_PER_MINUTE = 60L;

  private static final long SECONDS_PER_HOUR = 60L * 60L;

  private static final long SECONDS_PER_DAY = 60L * 60L * 24L;

  public String getDuration(final String seconds) {
    return getDuration(Long.parseLong(seconds));
  }

  public String getDuration(final long seconds) {
    if (seconds < SECONDS_PER_MINUTE) {
      return getMessage(DURATION_SECONDS, seconds);
    } else if (seconds < SECONDS_PER_HOUR) {
      return getMessage(DURATION_MINUTES, (seconds + SECONDS_PER_MINUTE - 1) / SECONDS_PER_MINUTE);
    } else if (seconds < SECONDS_PER_DAY) {
      return getMessage(DURATION_HOURS, (seconds + SECONDS_PER_HOUR - 1) / SECONDS_PER_HOUR);
    } else {
      return getMessage(DURATION_DAYS, (seconds + SECONDS_PER_DAY - 1) / SECONDS_PER_DAY);
    }
  }

  public String getFileSize(final String bytes) {
    return getFileSize(Long.parseLong(bytes));
  }

  public String getFileSize(final long bytes) {
    return HumanReadable.formatBytesShort(bytes);
  }

  public String getSuccessValue(final String value) {
    final String key;
    if (value == null || value.isEmpty()) {
      return getMessage(UNKNOWN);
    } else {
      return getMessage(SUCCESS_PREFIX + value.toLowerCase());
    }
  }

  public String getStatus(final String key, final String value, final KeyValuePairList params) {
    final String statusClassKey = key + "_class";
    final String statusClassName = params.find(statusClassKey);
    if (statusClassName == null) {
      return value;
    }
    final Class<? extends Enum<?>> statusClass = getEnumClass(statusClassName);
    if (statusClass == null) {
      return value.toUpperCase();
    } else {
      return getEnumLocalizedName(statusClass, value);
    }
  }
}
