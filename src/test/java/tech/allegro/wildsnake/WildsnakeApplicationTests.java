package tech.allegro.wildsnake;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WildsnakeApplication.class)
@WebAppConfiguration
@IntegrationTest
@ActiveProfiles("test")
public class WildsnakeApplicationTests {

    @Test
    public void should_show_main_page() {
        // when
        ResponseEntity<String> entity = template.getForEntity("http://localhost:8080/", String.class);

        // then
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(entity.getBody()).contains("Under construction");
    }

    TestRestTemplate template = new TestRestTemplate();

}
