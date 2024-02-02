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

import ltd.qubit.commons.text.jackson.deserializer.DecoderDeserializer;
import ltd.qubit.commons.util.codec.Codec;

@Immutable
public class PhoneJsonDeserializer extends DecoderDeserializer<Phone> {

  private static final long serialVersionUID = -5066519475467960647L;

  public static final PhoneJsonDeserializer INSTANCE = new PhoneJsonDeserializer();

  public PhoneJsonDeserializer() {
    this(PhoneCodec.INSTANCE);
  }

  public PhoneJsonDeserializer(final Codec<Phone, String> codec) {
    super(Phone.class, codec);
  }
}
