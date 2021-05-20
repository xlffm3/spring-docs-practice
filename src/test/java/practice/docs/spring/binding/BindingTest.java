package practice.docs.spring.binding;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class BindingTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testBindingEditor() throws Exception {
        mockMvc.perform(get("/target/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("money").value("1"));
    }

    @Test
    void testBindingConverter() throws Exception {
        mockMvc.perform(get("/targetconverter/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("money").value("1"));
    }
}
