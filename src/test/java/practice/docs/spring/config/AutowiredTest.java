package practice.docs.spring.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import practice.docs.spring.bean.component.C1;
import practice.docs.spring.bean.component.Concrete2;
import practice.docs.spring.bean.component.Concrete3;
import practice.docs.spring.bean.component.DuplicateInterface;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:/appContext.xml")
class AutowiredTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void autowired() {
        C1 c1 = applicationContext.getBean("c1", C1.class);

        DuplicateInterface concrete1 = c1.getConcrete1();
        DuplicateInterface duplicateInterface = c1.getDuplicateInterface();
        DuplicateInterface duplicateInterface2 = c1.getDuplicateInterface2();

        assertThat(concrete1).isInstanceOf(Concrete2.class);
        assertThat(duplicateInterface).isInstanceOf(Concrete3.class);
        assertThat(duplicateInterface2).isInstanceOf(Concrete2.class);
    }
}
