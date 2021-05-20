package practice.docs.spring.binding.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import practice.docs.spring.binding.Target;

public class TargetConverter {

    @Component
    public static class StringToTargetConverter implements Converter<String, Target> {

        @Override
        public Target convert(String source) {
            return new Target(Integer.parseInt(source));
        }
    }

    @Component
    public static class TargetToStringConverter implements Converter<Target, String> {

        @Override
        public String convert(Target source) {
            return String.valueOf(source.getMoney());
        }
    }
}
