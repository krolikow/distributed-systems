// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package sr.grpc.gen;

/**
 * Protobuf enum {@code event_subscriber.EventType}
 */
public enum EventType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>CONCERT = 0;</code>
   */
  CONCERT(0),
  /**
   * <code>FILM_SHOW = 1;</code>
   */
  FILM_SHOW(1),
  /**
   * <code>FOOTBALL = 2;</code>
   */
  FOOTBALL(2),
  /**
   * <code>CLUB_PARTY = 3;</code>
   */
  CLUB_PARTY(3),
  /**
   * <code>FESTIVAL = 4;</code>
   */
  FESTIVAL(4),
  /**
   * <code>ART_SHOW = 5;</code>
   */
  ART_SHOW(5),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>CONCERT = 0;</code>
   */
  public static final int CONCERT_VALUE = 0;
  /**
   * <code>FILM_SHOW = 1;</code>
   */
  public static final int FILM_SHOW_VALUE = 1;
  /**
   * <code>FOOTBALL = 2;</code>
   */
  public static final int FOOTBALL_VALUE = 2;
  /**
   * <code>CLUB_PARTY = 3;</code>
   */
  public static final int CLUB_PARTY_VALUE = 3;
  /**
   * <code>FESTIVAL = 4;</code>
   */
  public static final int FESTIVAL_VALUE = 4;
  /**
   * <code>ART_SHOW = 5;</code>
   */
  public static final int ART_SHOW_VALUE = 5;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static EventType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static EventType forNumber(int value) {
    switch (value) {
      case 0: return CONCERT;
      case 1: return FILM_SHOW;
      case 2: return FOOTBALL;
      case 3: return CLUB_PARTY;
      case 4: return FESTIVAL;
      case 5: return ART_SHOW;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<EventType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      EventType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<EventType>() {
          public EventType findValueByNumber(int number) {
            return EventType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return sr.grpc.gen.EventProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final EventType[] VALUES = values();

  public static EventType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private EventType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:event_subscriber.EventType)
}

