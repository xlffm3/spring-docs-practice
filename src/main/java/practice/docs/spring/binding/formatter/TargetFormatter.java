package practice.docs.spring.binding.formatter;

import org.springframework.format.Formatter;
import practice.docs.spring.binding.Target;

import java.text.ParseException;
import java.util.Locale;

public class TargetFormatter implements Formatter<Target> {

    @Override
    public Target parse(String text, Locale locale) throws ParseException {
        return new Target(Integer.parseInt(text));
    }

    @Override
    public String print(Target object, Locale locale) {
        return object.getMoney() + "";
    }
}
