package co.com.neurotrak.usecase.franchise;

import co.com.neurotrak.model.franchise.Franchise;
import co.com.neurotrak.model.franchise.gateways.FranchiseRepository;
import co.com.neurotrak.usecase.franchise.mapper.FranchiseMapper;
import lombok.RequiredArgsConstructor;

import reactor.core.publisher.Mono;
import java.util.List;

@RequiredArgsConstructor
public class FranchiseUseCase {
    private final FranchiseRepository repository;
    private final FranchiseMapper mapper;

    public Mono<List<Franchise>> getFranchises() {
        return repository.findAll().collectList();
    }

    public Mono<Franchise> save(String name) {
        Franchise franchise = mapper.newOne(name);
        return repository.save(franchise);
    }
}