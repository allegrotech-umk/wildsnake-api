package com.blackbat13.wildsnake;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WildsnakeApplication.class)
@WebAppConfiguration
@IntegrationTest
public class WildsnakeApplicationTests {

	@Test
	public void should_shown_main_page() {
        ResponseEntity<String> entity = template.getForEntity("http://localhost:8080/", String.class);

        assert entity.getStatusCode() == HttpStatus.OK;
        assert entity.getBody().contains("coming soon ...");
	}

    @Test
    public void should_show_main_page_message() {
        ResponseEntity<String> entity = template.getForEntity("http://localhost:8080/", String.class);

        assert entity.getStatusCode() == HttpStatus.OK;
        //assert entity.getBody().contains("Hello World");
    }

    TestRestTemplate template = new TestRestTemplate();

}
