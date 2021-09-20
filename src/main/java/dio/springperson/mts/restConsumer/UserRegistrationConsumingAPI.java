package dio.springperson.mts.restConsumer;

import dio.springperson.mts.restConsumer.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserRegistrationConsumingAPI {

    @Autowired
    public WebClient.Builder webClient;

    public User registerUser() {
        User user = webClient.build()
                .post()
                .uri("http://us-central1-rh-challenges.cloudfunctions.net/potterApi/users")
                .headers(httpHeaders -> {
                    httpHeaders.add("email", "mtscar23@gmail.com");
                    httpHeaders.add("password", "password@123");
                    httpHeaders.add("name", "Matheus Carneiro");
                })
                .retrieve()
                .bodyToMono(User.class)
                .block();
        return user;
    }
}
