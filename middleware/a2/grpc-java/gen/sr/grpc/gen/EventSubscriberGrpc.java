package sr.grpc.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: event.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EventSubscriberGrpc {

  private EventSubscriberGrpc() {}

  public static final String SERVICE_NAME = "event_subscriber.EventSubscriber";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.SubscribeRequest,
      sr.grpc.gen.Event> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = sr.grpc.gen.SubscribeRequest.class,
      responseType = sr.grpc.gen.Event.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.SubscribeRequest,
      sr.grpc.gen.Event> getSubscribeMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.SubscribeRequest, sr.grpc.gen.Event> getSubscribeMethod;
    if ((getSubscribeMethod = EventSubscriberGrpc.getSubscribeMethod) == null) {
      synchronized (EventSubscriberGrpc.class) {
        if ((getSubscribeMethod = EventSubscriberGrpc.getSubscribeMethod) == null) {
          EventSubscriberGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.SubscribeRequest, sr.grpc.gen.Event>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.SubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Event.getDefaultInstance()))
              .setSchemaDescriptor(new EventSubscriberMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventSubscriberStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventSubscriberStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventSubscriberStub>() {
        @java.lang.Override
        public EventSubscriberStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventSubscriberStub(channel, callOptions);
        }
      };
    return EventSubscriberStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventSubscriberBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventSubscriberBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventSubscriberBlockingStub>() {
        @java.lang.Override
        public EventSubscriberBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventSubscriberBlockingStub(channel, callOptions);
        }
      };
    return EventSubscriberBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventSubscriberFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventSubscriberFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventSubscriberFutureStub>() {
        @java.lang.Override
        public EventSubscriberFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventSubscriberFutureStub(channel, callOptions);
        }
      };
    return EventSubscriberFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribe(sr.grpc.gen.SubscribeRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Event> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EventSubscriber.
   */
  public static abstract class EventSubscriberImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EventSubscriberGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EventSubscriber.
   */
  public static final class EventSubscriberStub
      extends io.grpc.stub.AbstractAsyncStub<EventSubscriberStub> {
    private EventSubscriberStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventSubscriberStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventSubscriberStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(sr.grpc.gen.SubscribeRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Event> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EventSubscriber.
   */
  public static final class EventSubscriberBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EventSubscriberBlockingStub> {
    private EventSubscriberBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventSubscriberBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventSubscriberBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<sr.grpc.gen.Event> subscribe(
        sr.grpc.gen.SubscribeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EventSubscriber.
   */
  public static final class EventSubscriberFutureStub
      extends io.grpc.stub.AbstractFutureStub<EventSubscriberFutureStub> {
    private EventSubscriberFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventSubscriberFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventSubscriberFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((sr.grpc.gen.SubscribeRequest) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.Event>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              sr.grpc.gen.SubscribeRequest,
              sr.grpc.gen.Event>(
                service, METHODID_SUBSCRIBE)))
        .build();
  }

  private static abstract class EventSubscriberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventSubscriberBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sr.grpc.gen.EventProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EventSubscriber");
    }
  }

  private static final class EventSubscriberFileDescriptorSupplier
      extends EventSubscriberBaseDescriptorSupplier {
    EventSubscriberFileDescriptorSupplier() {}
  }

  private static final class EventSubscriberMethodDescriptorSupplier
      extends EventSubscriberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EventSubscriberMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EventSubscriberGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventSubscriberFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
