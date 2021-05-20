package practice.docs.spring.spel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpelTest {

    @Value("#{1+1}")
    private int value;

    @Value("${test.property}")
    private String name;

    @Test
    void spelTest() {
        assertThat(value).isEqualTo(2);
        assertThat(name).isEqualTo("kevin");
    }
}
