package arustamov.entities.file;

import arustamov.entities.Users;
import arustamov.entity.file.FileUser;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FileUsers extends FileEntities<FileUser> implements Users<FileUser> {

    public FileUsers() {
        super("users.json", new TypeReference<List<FileUser>>(){});
    }
}
