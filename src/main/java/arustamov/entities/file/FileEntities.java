package arustamov.entities.file;

import arustamov.entities.Entities;
import arustamov.entity.PropertyEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class FileEntities<E extends PropertyEntity> implements Entities<E, List<?>> {

    private static String DATA_FOLDER = "data";

    @Autowired
    private ObjectMapper mapper;

    private Resource resource;
    private TypeReference<List<E>> typeReference;

    private List<E> entities;

    public FileEntities(String resourceClassPath, TypeReference<List<E>> typeReference) {
        this.resource = new ClassPathResource(
            String.format("%s/%s", DATA_FOLDER, resourceClassPath)
        );
        this.typeReference = typeReference;
    }

    @Override
    public E get(List<?> params, Boolean cached) {
        return getAll(params, false).stream().findFirst().orElse(null);
    }

    @Override
    public List<E> getAll(List<?> params, Boolean cached) {
        if (entities == null)
            entities = readFile();
        return entities;
    }

    protected List<E> readFile() {
        try {
            return entities = mapper.readValue(resource.getInputStream(), typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
