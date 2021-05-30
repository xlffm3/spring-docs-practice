package practice.docs.spring.advice;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class AnimalFormatter implements Formatter<Animal> {

    @Override
    public Animal parse(String text, Locale locale) throws ParseException {
        return new Animal(text);
    }

    @Override
    public String print(Animal object, Locale locale) {
        return object.getName();
    }
}
