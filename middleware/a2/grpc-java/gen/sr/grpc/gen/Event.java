// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package sr.grpc.gen;

/**
 * Protobuf type {@code event_subscriber.Event}
 */
public final class Event extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:event_subscriber.Event)
    EventOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Event.newBuilder() to construct.
  private Event(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Event() {
    description_ = "";
    type_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Event();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return sr.grpc.gen.EventProto.internal_static_event_subscriber_Event_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return sr.grpc.gen.EventProto.internal_static_event_subscriber_Event_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            sr.grpc.gen.Event.class, sr.grpc.gen.Event.Builder.class);
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object description_ = "";
  /**
   * <code>string description = 1;</code>
   * @return The description.
   */
  @java.lang.Override
  public java.lang.String getDescription() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }
  /**
   * <code>string description = 1;</code>
   * @return The bytes for description.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDescriptionBytes() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      description_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ADDRESS_FIELD_NUMBER = 2;
  private sr.grpc.gen.Address address_;
  /**
   * <code>.event_subscriber.Address address = 2;</code>
   * @return Whether the address field is set.
   */
  @java.lang.Override
  public boolean hasAddress() {
    return address_ != null;
  }
  /**
   * <code>.event_subscriber.Address address = 2;</code>
   * @return The address.
   */
  @java.lang.Override
  public sr.grpc.gen.Address getAddress() {
    return address_ == null ? sr.grpc.gen.Address.getDefaultInstance() : address_;
  }
  /**
   * <code>.event_subscriber.Address address = 2;</code>
   */
  @java.lang.Override
  public sr.grpc.gen.AddressOrBuilder getAddressOrBuilder() {
    return address_ == null ? sr.grpc.gen.Address.getDefaultInstance() : address_;
  }

  public static final int PLACESNUMBER_FIELD_NUMBER = 3;
  private int placesNumber_ = 0;
  /**
   * <code>int32 placesNumber = 3;</code>
   * @return The placesNumber.
   */
  @java.lang.Override
  public int getPlacesNumber() {
    return placesNumber_;
  }

  public static final int TYPE_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private java.util.List<java.lang.Integer> type_;
  private static final com.google.protobuf.Internal.ListAdapter.Converter<
      java.lang.Integer, sr.grpc.gen.EventType> type_converter_ =
          new com.google.protobuf.Internal.ListAdapter.Converter<
              java.lang.Integer, sr.grpc.gen.EventType>() {
            public sr.grpc.gen.EventType convert(java.lang.Integer from) {
              sr.grpc.gen.EventType result = sr.grpc.gen.EventType.forNumber(from);
              return result == null ? sr.grpc.gen.EventType.UNRECOGNIZED : result;
            }
          };
  /**
   * <code>repeated .event_subscriber.EventType type = 4;</code>
   * @return A list containing the type.
   */
  @java.lang.Override
  public java.util.List<sr.grpc.gen.EventType> getTypeList() {
    return new com.google.protobuf.Internal.ListAdapter<
        java.lang.Integer, sr.grpc.gen.EventType>(type_, type_converter_);
  }
  /**
   * <code>repeated .event_subscriber.EventType type = 4;</code>
   * @return The count of type.
   */
  @java.lang.Override
  public int getTypeCount() {
    return type_.size();
  }
  /**
   * <code>repeated .event_subscriber.EventType type = 4;</code>
   * @param index The index of the element to return.
   * @return The type at the given index.
   */
  @java.lang.Override
  public sr.grpc.gen.EventType getType(int index) {
    return type_converter_.convert(type_.get(index));
  }
  /**
   * <code>repeated .event_subscriber.EventType type = 4;</code>
   * @return A list containing the enum numeric values on the wire for type.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
  getTypeValueList() {
    return type_;
  }
  /**
   * <code>repeated .event_subscriber.EventType type = 4;</code>
   * @param index The index of the value to return.
   * @return The enum numeric value on the wire of type at the given index.
   */
  @java.lang.Override
  public int getTypeValue(int index) {
    return type_.get(index);
  }
  private int typeMemoizedSerializedSize;

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(description_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, description_);
    }
    if (address_ != null) {
      output.writeMessage(2, getAddress());
    }
    if (placesNumber_ != 0) {
      output.writeInt32(3, placesNumber_);
    }
    if (getTypeList().size() > 0) {
      output.writeUInt32NoTag(34);
      output.writeUInt32NoTag(typeMemoizedSerializedSize);
    }
    for (int i = 0; i < type_.size(); i++) {
      output.writeEnumNoTag(type_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(description_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, description_);
    }
    if (address_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getAddress());
    }
    if (placesNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, placesNumber_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < type_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeEnumSizeNoTag(type_.get(i));
      }
      size += dataSize;
      if (!getTypeList().isEmpty()) {  size += 1;
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32SizeNoTag(dataSize);
      }typeMemoizedSerializedSize = dataSize;
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof sr.grpc.gen.Event)) {
      return super.equals(obj);
    }
    sr.grpc.gen.Event other = (sr.grpc.gen.Event) obj;

    if (!getDescription()
        .equals(other.getDescription())) return false;
    if (hasAddress() != other.hasAddress()) return false;
    if (hasAddress()) {
      if (!getAddress()
          .equals(other.getAddress())) return false;
    }
    if (getPlacesNumber()
        != other.getPlacesNumber()) return false;
    if (!type_.equals(other.type_)) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    if (hasAddress()) {
      hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
      hash = (53 * hash) + getAddress().hashCode();
    }
    hash = (37 * hash) + PLACESNUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getPlacesNumber();
    if (getTypeCount() > 0) {
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_.hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static sr.grpc.gen.Event parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.Event parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.Event parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.Event parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.Event parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.gen.Event parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.gen.Event parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.Event parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static sr.grpc.gen.Event parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.Event parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static sr.grpc.gen.Event parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.gen.Event parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(sr.grpc.gen.Event prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code event_subscriber.Event}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:event_subscriber.Event)
      sr.grpc.gen.EventOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sr.grpc.gen.EventProto.internal_static_event_subscriber_Event_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sr.grpc.gen.EventProto.internal_static_event_subscriber_Event_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sr.grpc.gen.Event.class, sr.grpc.gen.Event.Builder.class);
    }

    // Construct using sr.grpc.gen.Event.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      description_ = "";
      address_ = null;
      if (addressBuilder_ != null) {
        addressBuilder_.dispose();
        addressBuilder_ = null;
      }
      placesNumber_ = 0;
      type_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return sr.grpc.gen.EventProto.internal_static_event_subscriber_Event_descriptor;
    }

    @java.lang.Override
    public sr.grpc.gen.Event getDefaultInstanceForType() {
      return sr.grpc.gen.Event.getDefaultInstance();
    }

    @java.lang.Override
    public sr.grpc.gen.Event build() {
      sr.grpc.gen.Event result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public sr.grpc.gen.Event buildPartial() {
      sr.grpc.gen.Event result = new sr.grpc.gen.Event(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(sr.grpc.gen.Event result) {
      if (((bitField0_ & 0x00000008) != 0)) {
        type_ = java.util.Collections.unmodifiableList(type_);
        bitField0_ = (bitField0_ & ~0x00000008);
      }
      result.type_ = type_;
    }

    private void buildPartial0(sr.grpc.gen.Event result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.description_ = description_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.address_ = addressBuilder_ == null
            ? address_
            : addressBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.placesNumber_ = placesNumber_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof sr.grpc.gen.Event) {
        return mergeFrom((sr.grpc.gen.Event)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(sr.grpc.gen.Event other) {
      if (other == sr.grpc.gen.Event.getDefaultInstance()) return this;
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasAddress()) {
        mergeAddress(other.getAddress());
      }
      if (other.getPlacesNumber() != 0) {
        setPlacesNumber(other.getPlacesNumber());
      }
      if (!other.type_.isEmpty()) {
        if (type_.isEmpty()) {
          type_ = other.type_;
          bitField0_ = (bitField0_ & ~0x00000008);
        } else {
          ensureTypeIsMutable();
          type_.addAll(other.type_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              description_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getAddressFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 24: {
              placesNumber_ = input.readInt32();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 32: {
              int tmpRaw = input.readEnum();
              ensureTypeIsMutable();
              type_.add(tmpRaw);
              break;
            } // case 32
            case 34: {
              int length = input.readRawVarint32();
              int oldLimit = input.pushLimit(length);
              while(input.getBytesUntilLimit() > 0) {
                int tmpRaw = input.readEnum();
                ensureTypeIsMutable();
                type_.add(tmpRaw);
              }
              input.popLimit(oldLimit);
              break;
            } // case 34
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object description_ = "";
    /**
     * <code>string description = 1;</code>
     * @return The description.
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string description = 1;</code>
     * @return The bytes for description.
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string description = 1;</code>
     * @param value The description to set.
     * @return This builder for chaining.
     */
    public Builder setDescription(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      description_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string description = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDescription() {
      description_ = getDefaultInstance().getDescription();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string description = 1;</code>
     * @param value The bytes for description to set.
     * @return This builder for chaining.
     */
    public Builder setDescriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      description_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private sr.grpc.gen.Address address_;
    private com.google.protobuf.SingleFieldBuilderV3<
        sr.grpc.gen.Address, sr.grpc.gen.Address.Builder, sr.grpc.gen.AddressOrBuilder> addressBuilder_;
    /**
     * <code>.event_subscriber.Address address = 2;</code>
     * @return Whether the address field is set.
     */
    public boolean hasAddress() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.event_subscriber.Address address = 2;</code>
     * @return The address.
     */
    public sr.grpc.gen.Address getAddress() {
      if (addressBuilder_ == null) {
        return address_ == null ? sr.grpc.gen.Address.getDefaultInstance() : address_;
      } else {
        return addressBuilder_.getMessage();
      }
    }
    /**
     * <code>.event_subscriber.Address address = 2;</code>
     */
    public Builder setAddress(sr.grpc.gen.Address value) {
      if (addressBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        address_ = value;
      } else {
        addressBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.event_subscriber.Address address = 2;</code>
     */
    public Builder setAddress(
        sr.grpc.gen.Address.Builder builderForValue) {
      if (addressBuilder_ == null) {
        address_ = builderForValue.build();
      } else {
        addressBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.event_subscriber.Address address = 2;</code>
     */
    public Builder mergeAddress(sr.grpc.gen.Address value) {
      if (addressBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          address_ != null &&
          address_ != sr.grpc.gen.Address.getDefaultInstance()) {
          getAddressBuilder().mergeFrom(value);
        } else {
          address_ = value;
        }
      } else {
        addressBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.event_subscriber.Address address = 2;</code>
     */
    public Builder clearAddress() {
      bitField0_ = (bitField0_ & ~0x00000002);
      address_ = null;
      if (addressBuilder_ != null) {
        addressBuilder_.dispose();
        addressBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.event_subscriber.Address address = 2;</code>
     */
    public sr.grpc.gen.Address.Builder getAddressBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getAddressFieldBuilder().getBuilder();
    }
    /**
     * <code>.event_subscriber.Address address = 2;</code>
     */
    public sr.grpc.gen.AddressOrBuilder getAddressOrBuilder() {
      if (addressBuilder_ != null) {
        return addressBuilder_.getMessageOrBuilder();
      } else {
        return address_ == null ?
            sr.grpc.gen.Address.getDefaultInstance() : address_;
      }
    }
    /**
     * <code>.event_subscriber.Address address = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        sr.grpc.gen.Address, sr.grpc.gen.Address.Builder, sr.grpc.gen.AddressOrBuilder> 
        getAddressFieldBuilder() {
      if (addressBuilder_ == null) {
        addressBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            sr.grpc.gen.Address, sr.grpc.gen.Address.Builder, sr.grpc.gen.AddressOrBuilder>(
                getAddress(),
                getParentForChildren(),
                isClean());
        address_ = null;
      }
      return addressBuilder_;
    }

    private int placesNumber_ ;
    /**
     * <code>int32 placesNumber = 3;</code>
     * @return The placesNumber.
     */
    @java.lang.Override
    public int getPlacesNumber() {
      return placesNumber_;
    }
    /**
     * <code>int32 placesNumber = 3;</code>
     * @param value The placesNumber to set.
     * @return This builder for chaining.
     */
    public Builder setPlacesNumber(int value) {

      placesNumber_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>int32 placesNumber = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPlacesNumber() {
      bitField0_ = (bitField0_ & ~0x00000004);
      placesNumber_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Integer> type_ =
      java.util.Collections.emptyList();
    private void ensureTypeIsMutable() {
      if (!((bitField0_ & 0x00000008) != 0)) {
        type_ = new java.util.ArrayList<java.lang.Integer>(type_);
        bitField0_ |= 0x00000008;
      }
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @return A list containing the type.
     */
    public java.util.List<sr.grpc.gen.EventType> getTypeList() {
      return new com.google.protobuf.Internal.ListAdapter<
          java.lang.Integer, sr.grpc.gen.EventType>(type_, type_converter_);
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @return The count of type.
     */
    public int getTypeCount() {
      return type_.size();
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @param index The index of the element to return.
     * @return The type at the given index.
     */
    public sr.grpc.gen.EventType getType(int index) {
      return type_converter_.convert(type_.get(index));
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @param index The index to set the value at.
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(
        int index, sr.grpc.gen.EventType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureTypeIsMutable();
      type_.set(index, value.getNumber());
      onChanged();
      return this;
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @param value The type to add.
     * @return This builder for chaining.
     */
    public Builder addType(sr.grpc.gen.EventType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureTypeIsMutable();
      type_.add(value.getNumber());
      onChanged();
      return this;
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @param values The type to add.
     * @return This builder for chaining.
     */
    public Builder addAllType(
        java.lang.Iterable<? extends sr.grpc.gen.EventType> values) {
      ensureTypeIsMutable();
      for (sr.grpc.gen.EventType value : values) {
        type_.add(value.getNumber());
      }
      onChanged();
      return this;
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      type_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @return A list containing the enum numeric values on the wire for type.
     */
    public java.util.List<java.lang.Integer>
    getTypeValueList() {
      return java.util.Collections.unmodifiableList(type_);
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @param index The index of the value to return.
     * @return The enum numeric value on the wire of type at the given index.
     */
    public int getTypeValue(int index) {
      return type_.get(index);
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @param index The index to set the value at.
     * @param value The enum numeric value on the wire for type to set.
     * @return This builder for chaining.
     */
    public Builder setTypeValue(
        int index, int value) {
      ensureTypeIsMutable();
      type_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @param value The enum numeric value on the wire for type to add.
     * @return This builder for chaining.
     */
    public Builder addTypeValue(int value) {
      ensureTypeIsMutable();
      type_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated .event_subscriber.EventType type = 4;</code>
     * @param values The enum numeric values on the wire for type to add.
     * @return This builder for chaining.
     */
    public Builder addAllTypeValue(
        java.lang.Iterable<java.lang.Integer> values) {
      ensureTypeIsMutable();
      for (int value : values) {
        type_.add(value);
      }
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:event_subscriber.Event)
  }

  // @@protoc_insertion_point(class_scope:event_subscriber.Event)
  private static final sr.grpc.gen.Event DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new sr.grpc.gen.Event();
  }

  public static sr.grpc.gen.Event getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Event>
      PARSER = new com.google.protobuf.AbstractParser<Event>() {
    @java.lang.Override
    public Event parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Event> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Event> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public sr.grpc.gen.Event getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

