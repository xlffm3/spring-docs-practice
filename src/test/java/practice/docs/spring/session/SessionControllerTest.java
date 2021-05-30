package practice.docs.spring.session;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class SessionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testEvent() throws Exception {
        mockMvc.perform(get("/events/form"))
                .andExpect(request().sessionAttribute("event", notNullValue()));
    }

    @Test
    void testOneSession() throws Exception {
        mockMvc.perform(get("/another/session").sessionAttr("session", "alive session"))
                .andExpect(view().name("ok"));
    }
}
