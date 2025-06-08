package co.com.neurotrak.usecase.franchise;

import co.com.neurotrak.model.franchise.Franchise;
import co.com.neurotrak.model.franchise.gateways.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FranchiseUseCase {
    private final FranchiseRepository repository;

    public Flux<Franchise> getFranchises() {
        return repository.findAll();
    }
}
