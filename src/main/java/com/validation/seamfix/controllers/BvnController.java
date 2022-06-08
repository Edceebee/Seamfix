package com.validation.seamfix.controllers;

import com.validation.seamfix.models.Bvn;
import com.validation.seamfix.models.Dto.BvnDto;
import com.validation.seamfix.responses.BvnResponse;
import com.validation.seamfix.services.BvnService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BvnController {

    private BvnService bvnService;

    private ModelMapper modelMapper;

    @PostMapping("/bv-service/svalidate/wrapper/{bvn}")
    public ResponseEntity<?> validateBvn(@PathVariable String bvn) {
        try {
            BvnResponse bvnResponse = bvnService.validateBvn(bvn);

            return new ResponseEntity<>(bvnResponse, HttpStatus.FOUND);
        }

        catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(new BvnResponse(exception.getMessage()),
                    HttpStatus.EXPECTATION_FAILED);
        }
    }

}
