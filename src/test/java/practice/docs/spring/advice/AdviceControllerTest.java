package practice.docs.spring.advice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AdviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void validateTrue() throws Exception {
        mockMvc.perform(get("/animal").param("name", "abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("ok"));
    }

    @Test
    void validateFalse() throws Exception {
        mockMvc.perform(get("/animal").param("name", "aaa"))
                .andExpect(status().isOk())
                .andExpect(content().string("no"));
    }
}
