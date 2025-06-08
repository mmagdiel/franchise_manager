package co.com.neurotrak.usecase.franchise;

import co.com.neurotrak.model.franchise.Franchise;
import co.com.neurotrak.model.franchise.gateways.FranchiseRepository;
import lombok.RequiredArgsConstructor;

import reactor.core.publisher.Mono;
import java.util.List;


@RequiredArgsConstructor
public class FranchiseUseCase {
    private final FranchiseRepository repository;

    public Mono<List<Franchise>> getFranchises() {
        return repository.findAll().collectList();
    }

    public Mono<Franchise> save(Franchise franchise) {
        return repository.save(franchise);
    }
}
