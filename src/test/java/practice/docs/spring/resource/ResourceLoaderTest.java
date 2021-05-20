package practice.docs.spring.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ResourceLoaderTest {

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void resourceLoader() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/dummy.txt");
        File file = resource.getFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        String result = "";
        int read = 0;
        while ((read = fileInputStream.read()) != -1) {
            result += String.valueOf((char) read);
        }
        assertThat(resource.exists()).isTrue();
        assertThat(result).isEqualTo("a\nb\nc\nd\n");
    }
}
