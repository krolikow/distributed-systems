// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package sr.grpc.gen;

public final class EventProto {
  private EventProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_event_subscriber_SubscribeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_event_subscriber_SubscribeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_event_subscriber_Address_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_event_subscriber_Address_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_event_subscriber_Event_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_event_subscriber_Event_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013event.proto\022\020event_subscriber\"N\n\020Subsc" +
      "ribeRequest\022\017\n\007country\030\001 \001(\t\022)\n\004type\030\002 \003" +
      "(\0162\033.event_subscriber.EventType\"P\n\007Addre" +
      "ss\022\017\n\007country\030\001 \001(\t\022\014\n\004city\030\002 \001(\t\022\017\n\007zip" +
      "Code\030\003 \001(\t\022\025\n\rstreetAddress\030\004 \001(\t\"\211\001\n\005Ev" +
      "ent\022\023\n\013description\030\001 \001(\t\022*\n\007address\030\002 \001(" +
      "\0132\031.event_subscriber.Address\022\024\n\014placesNu" +
      "mber\030\003 \001(\005\022)\n\004type\030\004 \003(\0162\033.event_subscri" +
      "ber.EventType*a\n\tEventType\022\013\n\007CONCERT\020\000\022" +
      "\r\n\tFILM_SHOW\020\001\022\014\n\010FOOTBALL\020\002\022\016\n\nCLUB_PAR" +
      "TY\020\003\022\014\n\010FESTIVAL\020\004\022\014\n\010ART_SHOW\020\0052]\n\017Even" +
      "tSubscriber\022J\n\tsubscribe\022\".event_subscri" +
      "ber.SubscribeRequest\032\027.event_subscriber." +
      "Event0\001B\033\n\013sr.grpc.genB\nEventProtoP\001b\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_event_subscriber_SubscribeRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_event_subscriber_SubscribeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_event_subscriber_SubscribeRequest_descriptor,
        new java.lang.String[] { "Country", "Type", });
    internal_static_event_subscriber_Address_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_event_subscriber_Address_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_event_subscriber_Address_descriptor,
        new java.lang.String[] { "Country", "City", "ZipCode", "StreetAddress", });
    internal_static_event_subscriber_Event_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_event_subscriber_Event_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_event_subscriber_Event_descriptor,
        new java.lang.String[] { "Description", "Address", "PlacesNumber", "Type", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}