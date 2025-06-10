package co.com.neurotrak.api.response;

import co.com.neurotrak.api.resource.FranchiseCollection;
import co.com.neurotrak.api.resource.FranchiseElement;
import co.com.neurotrak.api.resource.FranchiseError;
import co.com.neurotrak.model.franchise.Franchise;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import java.util.List;

public class FranchiseResponse {
    public static Mono<ServerResponse> index(List<Franchise>  franchise) {
        FranchiseCollection template = new FranchiseCollection(franchise, HttpStatus.OK.value(), "Operation completed successfully");
        return ServerResponse.ok().bodyValue(template);
    }

    public static Mono<ServerResponse> show(Franchise franchise) {
        FranchiseElement template = new FranchiseElement(franchise, HttpStatus.OK.value(), "Operation completed successfully");
        return ServerResponse.ok().bodyValue(template);
    }

    public static Mono<ServerResponse> store(Franchise  franchise) {
        FranchiseElement template = new FranchiseElement(franchise, HttpStatus.CREATED.value(), "Operation completed successfully");
        return ServerResponse.ok().bodyValue(template);
    }

    public static Mono<ServerResponse> error(Throwable error) {
        FranchiseError template = new FranchiseError(HttpStatus.BAD_REQUEST.value(), error.getMessage());
        return ServerResponse.badRequest().bodyValue(template);
    }
}

