package practice.docs.spring.nullable;

import org.springframework.lang.NonNull;

public class Student {

    @NonNull
    private String name;

    public Student(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
