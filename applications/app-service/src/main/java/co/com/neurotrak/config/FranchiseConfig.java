package co.com.neurotrak.config;

import co.com.neurotrak.usecase.franchise.mapper.FranchiseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FranchiseConfig {

    @Bean
    public FranchiseMapper franchiseMapper() {
        return new FranchiseMapper(); // or however you create it
    }
}
