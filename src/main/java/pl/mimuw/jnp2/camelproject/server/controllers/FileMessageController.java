package pl.mimuw.jnp2.camelproject.server.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.mimuw.jnp2.camelproject.server.repositories.FileMessageRepository;
import pl.mimuw.jnp2.camelproject.server.repositories.entities.FileMessage;
import pl.mimuw.jnp2.camelproject.utils.JsonUtility;

@RestController
public class FileMessageController {

    private final FileMessageRepository repository;

    FileMessageController(FileMessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/messages")
    public List<FileMessage> all() {
        return repository.findAll();
    }

    @PostMapping("/messages")
    public FileMessage newFileMessage(@RequestBody String newJsonFileMessage) {
        return repository.save(JsonUtility.mapJsonToFileMessage(newJsonFileMessage));
    }
}