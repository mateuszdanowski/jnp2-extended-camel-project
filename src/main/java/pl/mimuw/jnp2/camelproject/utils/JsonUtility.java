package pl.mimuw.jnp2.camelproject.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import pl.mimuw.jnp2.camelproject.server.repositories.entities.FileMessage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

@UtilityClass
public class JsonUtility {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static String mapFileToJsonFileMessage(File file) throws FileNotFoundException, JsonProcessingException {
        String fileName = file.getName();
        String fileBody = readFile(file);
        Date processedAt = new Date();

        FileMessage fileMessage = new FileMessage(fileName, fileBody, processedAt.toString());

        return objectMapper.writeValueAsString(fileMessage);
    }

    @SneakyThrows
    public static FileMessage mapJsonToFileMessage(String jsonFileMessage) {
        try {
            return objectMapper.readValue(jsonFileMessage, FileMessage.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new FileMessage();
        }
    }

    private static String readFile(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\\Z");
            return scanner.next();
        }
    }
}
