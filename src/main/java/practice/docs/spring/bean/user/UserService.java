package practice.docs.spring.bean.user;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void printHello() {
        System.out.println("hello");
    }
}
