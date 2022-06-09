package com.validation.seamfix.repository;

import com.validation.seamfix.models.Bvn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BvnRepository extends MongoRepository<Bvn, Long> {

    Optional<Bvn> findBvnByBvn(String bvn);
}
