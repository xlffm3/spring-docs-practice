package practice.docs.spring.multipart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void upload() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "mycontent", "hello files".getBytes());
        mockMvc.perform(multipart("/file").file(multipartFile))
                .andExpect(content().string("mycontent"));
    }

    @Test
    void download() throws Exception {
        mockMvc.perform(get("/file/mock.txt"))
                .andExpect(status().isOk())
                .andExpect(content().string("abc\n"));
    }
}
