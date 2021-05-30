package practice.docs.spring.flash;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import practice.docs.spring.session.Event;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FlashControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFlashAttributes() throws Exception {
        Event event = new Event();
        event.setName("jipark");
        event.setId(10);
        mockMvc.perform(get("/flash")
                .sessionAttr("visitTime", LocalDateTime.now())
                .flashAttr("newEvent", event))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
