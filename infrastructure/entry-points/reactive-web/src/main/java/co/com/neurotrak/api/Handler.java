package co.com.neurotrak.api;

import co.com.neurotrak.api.response.FranchiseResponse;
import co.com.neurotrak.usecase.franchise.FranchiseUseCase;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final FranchiseUseCase useCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        return useCase
                .getFranchises()
                .flatMap(FranchiseResponse::ok)
                .onErrorResume(Mono::error);
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(JsonNode.class)
                .flatMap(jsonNode -> {
                    String name = jsonNode.get("name").asText();
                    if (name.isEmpty() || name.trim().isEmpty()) {
                        throw new Error("Bad request");
                    }
                    return useCase.save(name).flatMap(FranchiseResponse::create);
                }).onErrorResume(FranchiseResponse::error);
    }
}
