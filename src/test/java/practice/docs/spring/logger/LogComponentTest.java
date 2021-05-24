package practice.docs.spring.logger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class LogComponentTest {

    @Autowired
    private LogComponent logComponent;

    @Test
    void capture(CapturedOutput capturedOutput) {
        logComponent.printLog();

        assertThat(capturedOutput).contains("findable");
    }
}
