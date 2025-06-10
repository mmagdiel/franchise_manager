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

    public Mono<ServerResponse> listenIndexFranchise(ServerRequest serverRequest) {
        return useCase
                .index()
                .flatMap(FranchiseResponse::index)
                .onErrorResume(Mono::error);
    }

    public Mono<ServerResponse> listenShowFranchise(ServerRequest serverRequest) {
        String uuid = serverRequest.pathVariable("uuid");
        if (uuid.isEmpty() || uuid.trim().isEmpty()) {
            return ServerResponse.badRequest().bodyValue("There aren't uuid");
        }
        return useCase
                .show(uuid)
                .flatMap(FranchiseResponse::show)
                .onErrorResume(Mono::error);
    }

    public Mono<ServerResponse> listenStoreFranchise(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(JsonNode.class)
                .flatMap(jsonNode -> {
                    String name = jsonNode.get("name").asText();
                    if (name.isEmpty() || name.trim().isEmpty()) {
                        throw new Error("Bad request");
                    }
                    return useCase.store(name).flatMap(FranchiseResponse::store);
                }).onErrorResume(FranchiseResponse::error);
    }

    public Mono<ServerResponse> listenIndexSubsidiary(ServerRequest serverRequest) {
        return useCase
                .index()
                .flatMap(FranchiseResponse::index)
                .onErrorResume(Mono::error);
    }

    public Mono<ServerResponse> listenStoreSubsidiary(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(JsonNode.class)
                .flatMap(jsonNode -> {
                    String name = jsonNode.get("name").asText();
                    if (name.isEmpty() || name.trim().isEmpty()) {
                        throw new Error("Bad request");
                    }
                    return useCase.store(name).flatMap(FranchiseResponse::store);
                }).onErrorResume(FranchiseResponse::error);
    }
}
