package hello;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class GreetingWebClient {

    private WebClient webClient = WebClient.create("http://localhost:8080");

    private Mono<ClientResponse> result = webClient
        .get()
        .uri("/hello")
        .accept(MediaType.TEXT_PLAIN)
        .exchange();

    /**
     * .
     *
     * @return .
     */
    public String getResult() {
        return ">> result = " + result.flatMap(rezult -> rezult.bodyToMono(String.class)).block();
    }
}
