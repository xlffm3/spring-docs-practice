package practice.docs.spring.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonValidatorTest {

    @Autowired
    private Validator defaultValidator;

    @Test
    void validate() {
        Person person = new Person("kevin", 11);
        PersonValidator personValidator = new PersonValidator();
        Errors errors = new BeanPropertyBindingResult(person, "person");
        personValidator.validate(person, errors);
        FieldError fieldError = errors.getFieldError("age");
        String defaultMessage = fieldError.getCode();

        assertThat(defaultMessage).isEqualTo("age is not enough");
    }

    @Test
    void validateEvent() {
        Event event = new Event("event", 15);
        Errors errors = new BeanPropertyBindingResult(event, "event");
        defaultValidator.validate(event, errors);
        FieldError fieldError = errors.getFieldError("money");
        String defaultMessage = fieldError.getDefaultMessage();

        assertThat(defaultMessage).isEqualTo("money no good");
    }
}
