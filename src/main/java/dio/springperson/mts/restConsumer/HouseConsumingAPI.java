package dio.springperson.mts.restConsumer;

import dio.springperson.mts.houses.Houses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class HouseConsumingAPI {

    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private UserRegistrationConsumingAPI userRegistrationConsumingAPI;

    public List<Houses> discoverAllHouses() {
        ResponseEntity<List<Houses>> housesList = webClient.build()
                .get()
                .uri("http://us-central1-rh-challenges.cloudfunctions.net/potterApi/houses")
                .header("apiKey", userRegistrationConsumingAPI
                        .registerUser()
                        .getApiKey())
                .retrieve()
                .toEntityList(Houses.class)
                .block();

        return housesList.getBody();
    }

}
