package practice.docs.spring.bean.circular;

public class Bar {

    private final Poo poo;

    public Bar(Poo poo) {
        this.poo = poo;
    }
}
