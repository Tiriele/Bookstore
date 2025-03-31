package c2_tehtavat.c2_5_bookstore.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SmokeTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testBookControllerIsUp() {
        ResponseEntity<String> response = restTemplate.getForEntity("/booklist", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void testBookRestControllerIsUp() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/books", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void testCategoryControllerIsUp() {
        ResponseEntity<String> response = restTemplate.getForEntity("/categorylist", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
