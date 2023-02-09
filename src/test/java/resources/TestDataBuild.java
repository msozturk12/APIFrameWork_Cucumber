package resources;

import Pojo.AddPlace;
import Pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload(String name, String language, String address) {
        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setName(name);
        p.setLanguage(language);
        p.setAddress(address);
        p.setPhone_number("(+91) 983 893 3937");
        p.setWebsite("https://rahulshettyacademy.com");


        List<String> mylist = new ArrayList<>();
        mylist.add("shoe park");
        mylist.add("shop");
        p.setTypes(mylist);

        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }

    public String deletePLacePayload(String place_id) {
        return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";
    }
}
