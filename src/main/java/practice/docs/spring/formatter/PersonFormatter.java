package practice.docs.spring.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PersonFormatter implements Formatter<Person> {

    @Override
    public Person parse(String text, Locale locale) throws ParseException {
        return new Person(text, 1);
    }

    @Override
    public String print(Person object, Locale locale) {
        return object.getName() + object.getAge();
    }
}
