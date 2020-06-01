package sample;

import javafx.event.Event;

public class MapEvent extends Event {

    public MapEvent(GoogleMap map, double lat, double lng) {
        super(map, Event.NULL_SOURCE_TARGET, Event.ANY);
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }


    private double lat;
    private double lng;
}