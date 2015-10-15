package pl.rybickab.wildsnake;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WildsnakeApplication.class)
@WebAppConfiguration
@IntegrationTest
public class WildsnakeApplicationTests {

	@Test
	public void should_show_main_page(){
        //when
        ResponseEntity<String> entity = template.getForEntity("http://localhost:8081/", String.class);

        //then
        assert entity.getStatusCode() == HttpStatus.OK;
        assert entity.getBody().contains("coming soon");
    }

    TestRestTemplate template = new TestRestTemplate();

}
