package com.validation.seamfix.services;

import com.validation.seamfix.models.Bvn;
import com.validation.seamfix.responses.BvnResponse;

public interface BvnService {

    BvnResponse validateBvn(String bvn);
}
