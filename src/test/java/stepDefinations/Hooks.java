package stepDefinations;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        //execute this code only when place id is null
        //write a code that will give you place id


        StepDefination m = new StepDefination();
        if(StepDefination.place_id==null){
            m.add_Place_Payload_with("Shetty","French","Paris");
            m.user_calls_with_http_request("addPlaceAPI","POST");
            m.verify_place_Id_created_maps_to_using("Shetty","getPlaceAPI");

        }



    }
}
