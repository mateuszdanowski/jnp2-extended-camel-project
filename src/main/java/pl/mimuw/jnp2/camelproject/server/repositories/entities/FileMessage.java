package pl.mimuw.jnp2.camelproject.server.repositories.entities;

import lombok.Data;
import pl.mimuw.jnp2.camelproject.utils.RandomUtil;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class FileMessage {

    private @Id String id;

    private String filename;
    private String content;
    private String processedAt;

    public FileMessage() {

    }

    public FileMessage(String filename, String content, String processedAt) {
        this.id = RandomUtil.getRandomId();
        this.filename = filename;
        this.content = content;
        this.processedAt = processedAt;
    }
}