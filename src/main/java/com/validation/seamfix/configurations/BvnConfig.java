package com.validation.seamfix.configurations;

import com.validation.seamfix.models.Bvn;
import com.validation.seamfix.repository.BvnRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class seeds the database using command line runner.
 */
@Configuration
public class BvnConfig {
    @Bean
    CommandLineRunner commandLineRunner(BvnRepository bvnRepository) {
        return (args) -> {
            Bvn bvn = new Bvn(null, "71234367890");
            Bvn bvn2 = new Bvn(null, "69876354292");
            Bvn bvn3 = new Bvn(null, "968353729208");
            Bvn bvn4 = new Bvn(null, "34874902513");
            Bvn bvn5 = new Bvn(null, "87830822643");

            bvnRepository.save(bvn);
            bvnRepository.save(bvn2);
            bvnRepository.save(bvn3);
            bvnRepository.save(bvn4);
            bvnRepository.save(bvn5);

        };
    }
}
