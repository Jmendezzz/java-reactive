package com.gerard.project_stream;


import com.gerard.reactive_stream.suscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

/*
* How to create a Mono using Factory methods.
* Mono can just publish  0 or 1 element.*
* Mono --Implements--> CorePublisher --Extends--> Publisher (The class we implemented earlier)
* */
public class MonoJust {
    private static final Logger logger = LoggerFactory.getLogger(MonoJust.class);

    public static void main(String[] args) {
        Publisher<String> mono =  Mono.just("Beans");
        logger.info(mono.toString()); // This won't return 'Beans', we need to SUSBSCRIBE and REQUEST in order to get the value
        SubscriberImpl subscriber = new SubscriberImpl(); // This is our own implementation
        mono.subscribe(subscriber);

        subscriber.getSubscription().request(10); // Will just give one element 'Beans'
        subscriber.getSubscription().request(10); // Since there's only one 'Bean' this won't be executed
        subscriber.getSubscription().cancel();
    }

}
