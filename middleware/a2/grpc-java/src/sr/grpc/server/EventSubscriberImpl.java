package sr.grpc.server;

import io.grpc.StatusRuntimeException;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import sr.grpc.gen.Event;
import sr.grpc.gen.EventSubscriberGrpc;
import sr.grpc.gen.EventType;
import sr.grpc.gen.SubscribeRequest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class EventSubscriberImpl extends EventSubscriberGrpc.EventSubscriberImplBase {
    private final EventDataGenerator eventDataGenerator = new EventDataGenerator();
    private final static List<StreamObserver<Event>> observers = new LinkedList<>();
    private List<Event> events = new LinkedList<>();
    private final ConcurrentHashMap<StreamObserver<Event>, Integer> triesList = new ConcurrentHashMap();
    private final ConcurrentHashMap<StreamObserver<Event>, List<Event>> bufferedEventData = new ConcurrentHashMap();
    private final ConcurrentHashMap<StreamObserver<Event>, Boolean> isAliveList = new ConcurrentHashMap<>();


    @Override
    public void subscribe(SubscribeRequest request, StreamObserver<Event> responseObserver) {
        System.out.println("New client connected: " + responseObserver);
        ServerCallStreamObserver<Event> serverStreamObserver = (ServerCallStreamObserver<Event>) responseObserver;
        observers.add(responseObserver);
        isAliveList.put(responseObserver, true);
        bufferedEventData.putIfAbsent(responseObserver, new LinkedList<>());
        triesList.put(responseObserver, 7);
        while (serverStreamObserver.isReady() || isAliveList.get(responseObserver)) {
            try {
                Event event = eventDataGenerator.generateEvent();
                Thread.sleep(50);
                if (checkEvent(event, request)) {
                    events.add(event);
                    printEvent(event);
                    try {
                        if (serverStreamObserver.isReady()) {
                            responseObserver.onNext(event);
                            Thread.sleep(50);
                        } else {
                            if (0 < triesList.get(responseObserver)) {
                                System.out.println(responseObserver + ": Connection down - trying to reconnect - attempt " + (8 - triesList.get(responseObserver)));
                                bufferedEventData.get(responseObserver).add(event);
                                Thread.sleep(500);
                                triesList.put(responseObserver, triesList.get(responseObserver) - 1);
                            } else {
                                System.out.println(responseObserver + ": Too many tries - reconnection failed");
                                isAliveList.put(responseObserver, false);
                            }
                        }
                    } catch (StatusRuntimeException e) {
                        System.out.println("Connection down " + responseObserver);

                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        System.out.println("\nBUFFERED EVENTS FROM " + responseObserver+"\n");
        for (Event event :
                bufferedEventData.get(responseObserver)) {
            System.out.println(event);
        }
        observers.remove(responseObserver);
        triesList.remove(responseObserver);
        bufferedEventData.remove(responseObserver);
        isAliveList.remove(responseObserver);
    }

    protected boolean checkEvent(Event event, SubscribeRequest request) {
        return checkCountry(event, request) && checkEventType(event, request);
    }

    protected boolean checkCountry(Event event, SubscribeRequest request) {
        return event.getAddress().getCountry().equals(request.getCountry()) || request.getCountry().equals("");
    }

    protected boolean checkEventType(Event event, SubscribeRequest request) {
        for (EventType requestedEventType : request.getTypeList()) {
            for (EventType eventType : event.getTypeList()) {
                if (requestedEventType.equals(eventType)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected void printEvent(Event event) {
        System.out.print("\n[New event generated]\n");
        for (EventType type : event.getTypeList()) {
            System.out.print("\tEvent type: " + type + "\n");
        }
        System.out.println("\tDescription: " + event.getDescription());
        System.out.println("\tCountry: " + event.getAddress().getCountry());
        System.out.println("\tCity: " + event.getAddress().getCity());
        System.out.println("\tZip code: " + event.getAddress().getZipCode());
        System.out.println("\tStreet: " + event.getAddress().getStreetAddress());
    }
}
