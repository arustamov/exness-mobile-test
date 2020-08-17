package arustamov.entity.file;

import arustamov.entity.PropertyEntity;
import arustamov.entity.User;

public class FileUser extends PropertyEntity implements User {

    private String email;
    private String password;

    public FileUser() {}

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

}
