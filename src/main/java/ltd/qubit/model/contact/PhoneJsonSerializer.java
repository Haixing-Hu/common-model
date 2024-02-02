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

import com.fasterxml.jackson.core.JsonGenerator;

import ltd.qubit.commons.text.jackson.serializer.EncoderSerializer;
import ltd.qubit.commons.util.codec.Codec;

@Immutable
public class PhoneJsonSerializer extends EncoderSerializer<Phone> {

  private static final long serialVersionUID = -6010753017429561078L;

  public static final PhoneJsonSerializer INSTANCE = new PhoneJsonSerializer();

  public PhoneJsonSerializer() {
    this(PhoneCodec.INSTANCE);
  }

  public PhoneJsonSerializer(final Codec<Phone, String> codec) {
    super(Phone.class, codec, JsonGenerator::writeString);
  }
}
