package practice.docs.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name cannot be empty");
        Person person = (Person) target;
        if (person.getAge() < 17) {
            errors.rejectValue("age", "age is not enough");
        }
    }
}
