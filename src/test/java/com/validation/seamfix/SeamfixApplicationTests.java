package com.validation.seamfix;

import com.validation.seamfix.models.Bvn;
import com.validation.seamfix.repository.BvnRepository;
import com.validation.seamfix.responses.BvnResponse;
import com.validation.seamfix.services.BvnService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@SpringBootTest
class SeamfixApplicationTests {

	@Autowired
	BvnService bvnService;

	@Autowired
	BvnRepository bvnRepository;

	@Test
	void testValidRequest() throws Exception {
		Bvn bvnTest1 = new Bvn(null, "12345678989");
		bvnRepository.save(bvnTest1);
		Optional<BvnResponse> bvnResponse =  bvnService.validateBvn(bvnTest1);
		log.info("bvn --> {}", bvnTest1);
		assertThat(Objects.equals(bvnResponse.get().getStatus(), "200"));
	}

	@Test
	void testEmptyRequestPayLoad() {
		Bvn bvnTest2 = new Bvn(null, "");

		NoSuchElementException exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
			bvnService.validateBvn(bvnTest2);
		});
		Assertions.assertEquals("One or more of your request parameters failed validation, Please retry", exception.getMessage());
	}

	@Test
	void testInvalidBvnRequestInPayload() {
		Bvn bvnTest3 = new Bvn(null, "98767898767");

		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			bvnService.validateBvn(bvnTest3);
		});
		Assertions.assertEquals("The searched bvn does not exist", exception.getMessage());
	}

	@Test
	void testInvalidBvnRequestInPayloadLessThan11Numbers() {
		Bvn bvnTest4 = new Bvn(null, "767898767");

		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			bvnService.validateBvn(bvnTest4);
		});
		Assertions.assertEquals("The searched bvn is invalid", exception.getMessage());
	}

	@Test
	void testInvalidBvnRequestInPayloadIncludingLetters() {
		Bvn bvnTest5 = new Bvn(null, "76789tf877");

		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			bvnService.validateBvn(bvnTest5);
		});
		Assertions.assertEquals("The searched bvn is invalid", exception.getMessage());
	}
}
