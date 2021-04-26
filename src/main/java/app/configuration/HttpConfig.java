package app.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


/**
 *
 * @author vasil
 */
@Configuration
@Slf4j
public class HttpConfig {

    @Bean
    RouterFunction<ServerResponse> home() {
        return route(GET("/"), request -> {
            log.info("request = {}", request.methodName());
            return ok().body(fromValue("Home page"));
        });
    }

    @Bean
    RouterFunction<ServerResponse> about() {
        return route(GET("/about"), request -> ok().body(fromValue("About page")));
    }
}
