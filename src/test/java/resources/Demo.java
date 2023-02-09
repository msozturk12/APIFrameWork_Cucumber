package resources;

import io.cucumber.java.it.Data;
import jdk.nashorn.internal.objects.annotations.Getter;


public class Demo {
    String addPlaceAPI = "/maps/api/place/add/json";
    String getPlaceAPI = "/maps/api/place/get/json";
    String deletePlaceAPI = "/maps/api/place/delete/json";

    public String getAddPlaceAPI() {
        return addPlaceAPI;
    }

    public String getGetPlaceAPI() {
        return getPlaceAPI;
    }

    public String getDeletePlaceAPI() {
        return deletePlaceAPI;
    }
}
