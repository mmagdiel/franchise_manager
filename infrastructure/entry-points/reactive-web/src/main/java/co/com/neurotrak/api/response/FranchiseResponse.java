package co.com.neurotrak.api.response;

import co.com.neurotrak.api.resource.FranchiseResource;
import co.com.neurotrak.model.franchise.Franchise;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public class FranchiseResponse {
    public static Mono<ServerResponse> ok(List<Franchise>  franchise) {
        FranchiseResource template = new FranchiseResource(franchise, HttpStatus.OK.value(), "Operation completed successfully");
        return ServerResponse.ok().bodyValue(template);
    }
}

