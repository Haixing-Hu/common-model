////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.privilege;

import java.util.List;

import ltd.qubit.commons.text.Joiner;
import ltd.qubit.commons.text.Splitter;
import ltd.qubit.commons.util.codec.Codec;
import ltd.qubit.commons.util.codec.DecodingException;
import ltd.qubit.commons.util.codec.EncodingException;

/**
 * 此模型表示用户的权限。
 *
 * @author 胡海星
 */
public class PrivilegesCodec implements Codec<Privileges, String> {

  public static final char SEPARATOR = ',';

  @Override
  public Privileges decode(final String str) throws DecodingException {
    if (str == null) {
      return null;
    }
    if (str.isEmpty()) {
      return new Privileges();
    }
    final List<String> values = new Splitter()
        .byChar(SEPARATOR)
        .strip(true)
        .ignoreEmpty(true)
        .split(str);
    return new Privileges(values);
  }

  @Override
  public String encode(final Privileges privileges) throws EncodingException {
    if (privileges == null) {
      return null;
    }
    return new Joiner(SEPARATOR).addAll(privileges).toString();
  }
}
