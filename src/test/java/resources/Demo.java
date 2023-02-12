package resources;

import io.cucumber.java.it.Data;
import lombok.Getter;

@Getter
public class Demo {
    String addPlaceAPI = "/maps/api/place/add/json";
    String getPlaceAPI = "/maps/api/place/get/json";
    String deletePlaceAPI = "/maps/api/place/delete/json";


}
