package sr.grpc.server;

import sr.grpc.gen.Address;
import sr.grpc.gen.Event;
import sr.grpc.gen.EventType;

import java.util.Random;

public class EventDataGenerator {
    String[] descriptions = new String[]{"Rozrywka", "Warsztaty", "Spotkanie","Konkurs","Wyklady","Impreza"};
    Integer[] placesNumber = new Integer[]{2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
    String[] countryCityPair = new String[]{"Polska#Warszawa","Niemcy#Berlin","Francja#Paryz","Wlochy#Rzym","Hiszpania#Barcelona"};
    String[] streets = new String[]{"Main Street","Long Street", "Pretty Street","Short Street","Ugly Street"};

    protected Event generateEvent(){
        Random random = new Random();
        int token = random.nextInt();
        int typeNumber = EventType.values().length;

        EventType eventType = switch (Math.abs(token % typeNumber)) {
            case 0 -> EventType.CONCERT;
            case 1 -> EventType.FILM_SHOW;
            case 2 -> EventType.FOOTBALL;
            case 3 -> EventType.CLUB_PARTY;
            case 4 -> EventType.FESTIVAL;
            default -> EventType.ART_SHOW;
        };

        String[] pair = countryCityPair[Math.abs(token%countryCityPair.length)].split("#");
        String country = pair[0];
        String city = pair[1];
        String street = streets[Math.abs(token%streets.length)];
        String streetAddress = street +" "+ random.nextInt(200);
        String zipCode = String.valueOf(random.nextInt(90000) + 10000);

        Address address = Address.newBuilder()
                .setCountry(country)
                .setCity(city)
                .setZipCode(zipCode)
                .setStreetAddress(streetAddress)
                .build();

        return Event.newBuilder()
                .setDescription(descriptions[Math.abs(random.nextInt()% descriptions.length)])
                .setAddress(address)
                .setPlacesNumber(placesNumber[Math.abs(random.nextInt()% placesNumber.length)])
                .addType(eventType)
                .build();
    }
}
