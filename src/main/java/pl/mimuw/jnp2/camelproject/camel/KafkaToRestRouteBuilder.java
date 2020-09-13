package pl.mimuw.jnp2.camelproject.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaToRestRouteBuilder extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration().host("localhost").port("8080");

        from("kafka:jnp2-fileToKafka?brokers=localhost:9092")
                .to("rest:post:messages");
    }
}
