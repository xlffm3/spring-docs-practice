package practice.docs.spring.bean.component;

import org.springframework.stereotype.Repository;

@Repository
public class B1 {

    private final A1 a1;

    public B1(A1 a1) {
        this.a1 = a1;
    }
}
