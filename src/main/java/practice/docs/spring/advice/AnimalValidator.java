package practice.docs.spring.advice;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AnimalValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Animal.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Animal animal = (Animal) target;
        if (animal.getName().equals("aaa")) {
            errors.rejectValue("name", "wrong value", "cannot aaa");
        }
    }
}
