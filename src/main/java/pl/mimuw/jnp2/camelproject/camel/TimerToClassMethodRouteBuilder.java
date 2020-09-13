package pl.mimuw.jnp2.camelproject.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerToClassMethodRouteBuilder extends RouteBuilder {

    @Override
    public void configure() {
        from("timer://MainTimer?fixedRate=true&period=2000&delay=4000")
                .to("class:pl.mimuw.jnp2.camelproject.utils.FileCreator?method=createNextFileWithRandomBody");
    }
}
