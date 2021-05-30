package practice.docs.spring.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ModelTestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testModelAttribute() throws Exception {
        mockMvc.perform(get("/model/test"))
                .andExpect(content().string("abc"));
    }

    @Test
    void testViewNameTranslator() throws Exception {
        mockMvc.perform(get("/test/view"))
                .andExpect(view().name("test/view"))
                .andExpect(model().attributeExists("event"));
    }
}
