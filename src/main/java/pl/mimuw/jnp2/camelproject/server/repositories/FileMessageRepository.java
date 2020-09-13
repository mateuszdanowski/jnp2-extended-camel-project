package pl.mimuw.jnp2.camelproject.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mimuw.jnp2.camelproject.server.repositories.entities.FileMessage;

public interface FileMessageRepository extends JpaRepository<FileMessage, String> {

}