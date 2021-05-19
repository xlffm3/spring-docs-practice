package practice.docs.spring.bean.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class B1 {

    @Autowired
    private A1 a1;

    public A1 getA1() {
        return a1;
    }
}
