package com.validation.seamfix.responses;

import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
;import java.io.File;

@Data
@AllArgsConstructor
public class BvnResponse {
    private File image1;

    private File image2;

    private String message;

    private String statusCode;

    private String bvn;

    public BvnResponse(String message) {
        this.message = message;
    }
}
