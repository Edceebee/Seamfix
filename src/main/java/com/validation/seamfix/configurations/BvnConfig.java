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
            Bvn bvn = new Bvn(null, "1234367890");
            Bvn bvn2 = new Bvn(null, "9876354292");
            Bvn bvn3 = new Bvn(null, "8353729208");
            Bvn bvn4 = new Bvn(null, "3487902513");
            Bvn bvn5 = new Bvn(null, "8783082643");

            bvnRepository.save(bvn);
            bvnRepository.save(bvn2);
            bvnRepository.save(bvn3);
            bvnRepository.save(bvn4);
            bvnRepository.save(bvn5);

        };
    }
}
