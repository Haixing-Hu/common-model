////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.commons;

import javax.annotation.Nullable;

import ltd.qubit.commons.util.codec.Codec;
import ltd.qubit.commons.util.codec.DecodingException;

import static ltd.qubit.commons.lang.StringUtils.isEmpty;
import static ltd.qubit.commons.lang.StringUtils.strip;

/**
 * 证件信息编码解码器。
 *
 * <p>此对象提供对{@link CredentialInfo}对象和字符串之间互相转换的函数。</p>
 *
 * <p>一个{@link CredentialInfo}对象将用下面形式的字符串表示：</p>
 * <pre><code>
 *   &lt;证件类型&gt; '-' &lt;证件号码&gt;
 * </code></pre>
 *
 * <p>例如：</p>
 * <ul>
 * <li>IDENTITY_CARD-320103198807625364</li>
 * <li>PASSPORT-0X111100X</li>
 * <li>OFFICER_CARD-123456789</li>
 * </ul>
 *
 */
public class CredentialInfoCodec implements Codec<CredentialInfo, String> {

  @Override
  @Nullable
  public CredentialInfo decode(@Nullable final String source) throws DecodingException {
    final String theSource = strip(source);
    if (isEmpty(theSource)) {
      return null;
    }
    final int index = theSource.indexOf('-');
    if (index >= 0) {
      final CredentialType type = getCredentialType(theSource.substring(0, index));
      final String number = theSource.substring(index + 1);
      return new CredentialInfo(type, number);
    } else {
      throw new DecodingException("Invalid credential format: " + theSource);
    }
  }

  private CredentialType getCredentialType(final String name) throws DecodingException {
    try {
      return CredentialType.valueOf(name);
    } catch (final IllegalArgumentException e) {
      throw new DecodingException("Unsupported credential type：" + name);
    }
  }

  @Override
  @Nullable
  public String encode(@Nullable final CredentialInfo source) {
    if (source == null) {
      return null;
    }
    return source.getType().name() + '-' + source.getNumber();
  }
}
