package com.validation.seamfix.services;

import com.validation.seamfix.models.Bvn;
import com.validation.seamfix.repository.BvnRepository;
import com.validation.seamfix.responses.BvnResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
@Slf4j
public class BvnServiceImpl implements BvnService{

    private BvnRepository bvnRepository;

    /**
     * method that checks if the bvn given exist.
     * @param bvn body that provides the bvn details to validate
     * @return a response entity
     */
    @Override
    public Optional<BvnResponse> validateBvn(Bvn bvn) {
        Optional<Bvn> findByBvn = bvnRepository.findBvnByBvn(bvn.getBvn());

            if (bvn.getBvn().isEmpty()) {
                throw new NoSuchElementException("One or more of your request parameters failed validation, Please retry");
            }

             if (bvn.getBvn().length() < 11) {
            throw new IllegalArgumentException("The searched bvn is invalid");
             }

            if (!findByBvn.isPresent()) {
                throw new IllegalArgumentException("The searched bvn does not exist");
            }

            String bvnRegex = "\\d+";
            Pattern bvnPattern = Pattern.compile(bvnRegex);
            log.info("pattern --> {}", bvnPattern);
            Matcher bvnMatcher = bvnPattern.matcher(bvn.getBvn());
            if (!bvnMatcher.matches()) {
                throw new IllegalArgumentException("The searched bvn is invalid");
            }

            File image1 = new File("C:\\Users\\chinonso.edozie\\Downloads\\image1.jfif");
            String convertedImage1 = encodeFileToBase64Binary(image1);
            File image2 = new File("C:\\Users\\chinonso.edozie\\Downloads\\image2.jfif");
            String convertedImage2 = encodeFileToBase64Binary(image2);

        return Optional.of(new BvnResponse(convertedImage1, convertedImage2, "Success", "200", findByBvn.get().getBvn()));

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
