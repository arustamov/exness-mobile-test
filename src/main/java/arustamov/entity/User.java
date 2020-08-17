package arustamov.entity;

public interface User extends Entity {

    String getEmail();

    String getPassword();

    default String getInvalidEmail() {
        return getEmail().replace("@","!");
    }
}
