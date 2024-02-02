////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.contact;

import javax.annotation.concurrent.Immutable;

import ltd.qubit.commons.text.jackson.keydeserializer.DecoderKeyDeserializer;
import ltd.qubit.commons.util.codec.Codec;

@Immutable
public class PhoneJsonKeyDeserializer extends DecoderKeyDeserializer<Phone> {

  private static final long serialVersionUID = -5066519475467960647L;

  public static final PhoneJsonKeyDeserializer
      INSTANCE = new PhoneJsonKeyDeserializer();

  public PhoneJsonKeyDeserializer() {
    this(new PhoneCodec());
  }

  public PhoneJsonKeyDeserializer(final Codec<Phone, String> codec) {
    super(Phone.class, codec);
  }
}
