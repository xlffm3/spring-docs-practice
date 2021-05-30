package practice.docs.spring.mapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@WebMvcTest
class HeaderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void handleHeaderMapping() throws Exception {
        mockMvc.perform(get("/header").header(HttpHeaders.AUTHORIZATION, "111"))
                .andExpect(content().string("ok"));
    }


    @Test
    void cannotHandleHeaderMapping() throws Exception {
        mockMvc.perform(get("/header").header(HttpHeaders.AUTHORIZATION, "112"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void testOptions() throws Exception {
        mockMvc.perform(options("/header").header(HttpHeaders.AUTHORIZATION, "111"))
                .andExpect(status().isOk())
                .andExpect(header().stringValues(HttpHeaders.ALLOW, "GET,HEAD,OPTIONS"));
    }
}
