package practice.docs.spring.nullable;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void checkNullSafety() {
        Student student = new Student(null);
    }
}
