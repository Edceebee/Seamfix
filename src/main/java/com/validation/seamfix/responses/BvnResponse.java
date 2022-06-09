package com.validation.seamfix.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BvnResponse {
    private String image1;

    private String image2;

    private String message;

    private String status;

    private String bvn;

    public BvnResponse(String message) {
        this.message = message;
    }

}
