package pl.mimuw.jnp2.camelproject.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import pl.mimuw.jnp2.camelproject.utils.JsonUtility;

import java.io.File;

@Component
public class FileToKafkaRouteBuilder extends RouteBuilder {

    @Override
    public void configure() {
        from("file-watch://filesForKafka")
                .process(exchange -> {
                    File file = exchange.getIn().getBody(File.class);
                    exchange.getIn().setBody(JsonUtility.mapFileToJsonFileMessage(file), String.class);
                })
                .to("kafka:jnp2-fileToKafka?brokers=localhost:9092");
    }
}
