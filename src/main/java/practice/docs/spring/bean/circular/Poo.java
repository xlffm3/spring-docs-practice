package practice.docs.spring.bean.circular;

import org.springframework.stereotype.Component;

@Component
public class Poo {

    private final Bar bar;

    public Poo(Bar bar) {
        this.bar = bar;
    }
}
