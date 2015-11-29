package tech.allegro.wildsnake.integration;

import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import tech.allegro.wildsnake.WildsnakeApplication;

@SpringApplicationConfiguration(classes = WildsnakeApplication.class)
@WebAppConfiguration
@IntegrationTest
@ActiveProfiles("test")
public class WildSnakeIntegrationTest {
    public TestRestTemplate template = new TestRestTemplate();
}
