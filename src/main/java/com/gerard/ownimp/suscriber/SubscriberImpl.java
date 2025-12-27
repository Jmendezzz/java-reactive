package com.gerard.ownimp.suscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriberImpl implements Subscriber<String> {

    private static final Logger log = LoggerFactory.getLogger(SubscriberImpl.class);

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {

    }

    @Override
    public void onNext(String email) {
        log.info("received email:{}", email);

    }

    @Override
    public void onError(Throwable throwable) {
        log.error("error", throwable);

    }

    @Override
    public void onComplete() {
        log.info("completed!");

    }

    public Subscription getSubscription(){
        return subscription;
    }
}
