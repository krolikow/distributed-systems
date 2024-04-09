import logging
import threading
import time
from grpc import ssl_channel_credentials, insecure_channel
import grpc
import event_pb2
import event_pb2_grpc

countries_available = ["polska", "niemcy", "francja", "wlochy", "hiszpania"]
event_types_available = ["concert", "film_show", "football", "club_party", "festival", "art_show"]


def create_request():
    try:
        while True:
            try:
                response = stub.subscribe(event)
                for message in response:
                    print("\n")
                    print(message)
                    print("\n")
            except grpc._channel._Rendezvous:
                print("Connection down - Trying to reconnect")
                time.sleep(5)
    except KeyboardInterrupt:
        exit(0)


def listen_for_response():
    threading.Thread(target=create_request, daemon=True,
                     args=[]).start()
    while True:
        pass


if __name__ == '__main__':
    try:
        logging.basicConfig()
        channel = grpc.insecure_channel('127.0.0.5:50052')
        stub = event_pb2_grpc.EventSubscriberStub(channel)
        print("Connected to server")
        print("Available countries: ", countries_available)
        print("Available event types: ", event_types_available)
        print("Write subscription in format: Country EventType1 EventType2 EventType3 ...")
        while True:
            subscription = input(">>")
            components = subscription.split(' ')
            if len(components) < 2:
                print("I guess something is missing... Enter data once again in format: Country EventType1 EventType2 "
                      "EventType3 ...")
                continue
            country = components[0]
            event_types = components[1:]
            print(country, event_types)
            if country.lower() not in countries_available:
                print("Country is not available. Available countries are: ", countries_available)
                continue

            valid = True
            for event_type in event_types:
                if event_type.lower() not in event_types_available:
                    print("Event type " + event_type + " is not available. Available event types are: ",
                          event_types_available)
                    valid = False
                    break
            if not valid: continue

            parsed_event_types = [event_type.upper() for event_type in event_types]
            event = event_pb2.SubscribeRequest(country=country.capitalize(), type=parsed_event_types)
            # event = event_pb2.SubscribeRequest(country="Polska", type=["FESTIVAL","FILM_SHOW","FOOTBALL","ART_SHOW"])
            break
        listen_for_response()
    except KeyboardInterrupt:
        exit(0)
