package com.validation.seamfix.controllers;

import com.validation.seamfix.models.Bvn;
import com.validation.seamfix.models.Dto.BvnDto;
import com.validation.seamfix.responses.BvnResponse;
import com.validation.seamfix.services.BvnService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BvnController {
    @Autowired
    BvnService bvnService;

    @Autowired
    ModelMapper modelMapper;

    /**
     * Endpoint for validating bvn.
     * @param bvnDto used to collect details for validation
     * @return bvn response if successful
     */
    @PostMapping("/bv-service/svalidate/wrapper")
    public ResponseEntity<?> validateBvn(@RequestBody BvnDto bvnDto) {
        try {
            Bvn bvnRequest = modelMapper.map(bvnDto, Bvn.class);
            Optional<BvnResponse> bvnResponse = bvnService.validateBvn(bvnRequest);

            return new ResponseEntity<>(bvnResponse, HttpStatus.FOUND);
        }

        catch (Exception exception) {
            return new ResponseEntity<>(new BvnResponse(exception.getMessage()),
                    HttpStatus.EXPECTATION_FAILED);
        }
        }
    }
