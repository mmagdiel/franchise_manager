package co.com.neurotrak.usecase.franchise.mapper;

import co.com.neurotrak.model.franchise.Franchise;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

@NoArgsConstructor
public class FranchiseMapper {
    public Franchise newOne(String name) {
        String uuid = UUID.randomUUID().toString();
        Date now = new Date();
        return new Franchise(uuid, name, now, now, 0, new HashSet<>());
    }
}
