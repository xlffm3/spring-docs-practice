package practice.docs.spring.validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Event {

    @NotNull
    private String name;
    @Min(value = 17, message = "money no good")
    private int money;

    public Event(@NotNull String name, @Min(17) int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
}
