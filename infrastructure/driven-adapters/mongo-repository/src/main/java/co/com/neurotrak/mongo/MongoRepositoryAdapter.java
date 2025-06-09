package co.com.neurotrak.mongo;

import co.com.neurotrak.model.franchise.Franchise;
import co.com.neurotrak.model.franchise.gateways.FranchiseRepository;
import co.com.neurotrak.mongo.document.FranchiseDocument;
import co.com.neurotrak.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Franchise, FranchiseDocument, String, MongoDBRepository>
implements FranchiseRepository
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Franchise.class));
    }

}
