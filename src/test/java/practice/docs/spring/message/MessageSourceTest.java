package practice.docs.spring.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MessageSourceTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    void messageSource() {
        String greeting = messageSource.getMessage("greeting", new String[]{"jipark", "hey"}, Locale.getDefault());
        String korGreeting = messageSource.getMessage("greeting", new String[]{"진홍", "이봐"}, Locale.KOREA);

        assertThat(greeting).isEqualTo("hello jipark hey");
        assertThat(korGreeting).isEqualTo("안녕 진홍 이봐");
    }
}
