package practice.docs.spring.bean.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class C1 {

    @Autowired
    private DuplicateInterface concrete1;

    @Autowired
    @Qualifier("concrete3")
    private DuplicateInterface duplicateInterface;

    @Autowired
    private DuplicateInterface duplicateInterface2;

    public DuplicateInterface getConcrete1() {
        return concrete1;
    }

    public DuplicateInterface getDuplicateInterface() {
        return duplicateInterface;
    }

    public DuplicateInterface getDuplicateInterface2() {
        return duplicateInterface2;
    }
}
