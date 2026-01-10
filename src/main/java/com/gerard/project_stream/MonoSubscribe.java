package com.gerard.project_stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoSubscribe {
    private static final Logger log = LoggerFactory.getLogger(MonoSubscribe.class);

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);

        Mono<Integer> mono2 = Mono.just(1)
                                    .map(i -> i * 100);

        mono2.subscribe(
                integer -> log.info("received {}", integer)
        );

        mono.subscribe(
                i -> log.info("received {}", i), // Consumer
                err -> log.error("error while executing: {}", err.getMessage()), // Error consumer
                () -> log.info("completed"), // Completed
                subscription -> subscription.cancel() // How to get subscription
        );

        /**
         * Why did we have the value, if we're just subscribing,
         * we're not asking for any value like in
         * {@link com.gerard.project_stream.MonoJust}
         * It's because that's the default project stream behavior
         * Below we're doing manually
         */
        mono.subscribe(
                i -> log.info("received {}", i), // Consumer
                err -> log.error("error while executing: {}", err.getMessage()), // Error consumer
                () -> log.info("completed"), // Completed
                subscription -> subscription.request(1) // How to get subscription
        );

    }
}
