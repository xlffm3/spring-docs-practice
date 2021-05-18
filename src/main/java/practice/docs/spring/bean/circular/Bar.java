package practice.docs.spring.bean.circular;

import org.springframework.stereotype.Component;

@Component
public class Bar {

    private final Poo poo;

    public Bar(Poo poo) {
        this.poo = poo;
    }
}
