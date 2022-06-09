package com.validation.seamfix.services;

import com.validation.seamfix.models.Bvn;
import com.validation.seamfix.responses.BvnResponse;

import java.util.Optional;

public interface BvnService {
    Optional<BvnResponse> validateBvn(Bvn bvn) throws Exception;
}
