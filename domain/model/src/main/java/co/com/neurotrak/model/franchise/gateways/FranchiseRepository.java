package co.com.neurotrak.model.franchise.gateways;


import co.com.neurotrak.model.franchise.Franchise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseRepository {
    Mono<Franchise> findById(String uuid);

    Mono<Franchise> save(Franchise franchise);

    Mono<Void> deleteById(String uuid);

    Flux<Franchise> findAll();
}
