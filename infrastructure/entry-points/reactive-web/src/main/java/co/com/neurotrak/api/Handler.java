package co.com.neurotrak.api;

import co.com.neurotrak.api.resource.FranchiseResource;
import co.com.neurotrak.api.response.FranchiseResponse;
import co.com.neurotrak.usecase.franchise.FranchiseUseCase;
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

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
