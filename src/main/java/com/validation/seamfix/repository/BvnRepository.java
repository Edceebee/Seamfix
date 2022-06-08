package com.validation.seamfix.repository;

import com.validation.seamfix.models.Bvn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BvnRepository extends JpaRepository<Bvn, Long> {

    Optional<Bvn> findBvnByBvn(String bvn);
}
