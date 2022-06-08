package com.validation.seamfix.services;

import com.validation.seamfix.models.Bvn;
import com.validation.seamfix.repository.BvnRepository;
import com.validation.seamfix.responses.BvnResponse;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BvnServiceImpl implements BvnService{

    private BvnRepository bvnRepository;

    @Override
    public BvnResponse validateBvn(String bvn) {
        Optional<Bvn> findByBvn = Optional.ofNullable(bvnRepository.findBvnByBvn(bvn).
                orElseThrow(() -> new RuntimeException("Bvn not found")));

        File image1 = new File("/Users/elninoestrella/Downloads/download2.jpeg");
        File image2 = new File("/Users/elninoestrella/Downloads/download.jpeg");

        return new BvnResponse(image1, image2, "Successful", "200", findByBvn.get().getBvn());

    }


    /**
     * this method coverts an image to base64 encoded strings.
     * @param file needed to get the url from computer
     * @return the encoded file that has been converted.
     */
    private static String encodeFileToBase64Binary(File file){
        String encodedFile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedFile = new String(Base64.encodeBase64(bytes), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encodedFile;
    }
}
