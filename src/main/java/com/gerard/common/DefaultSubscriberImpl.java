package com.gerard.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriberImpl<T> implements Subscriber<T> {

    private static final Logger log = LoggerFactory.getLogger(DefaultSubscriberImpl.class);
    private final String name;

    public DefaultSubscriberImpl(String name) {
        this.name = name; //Since a publisher can have multiple subscribers, we wanna know who is the subscriber
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        log.info("{} received value:{}", name, item);

    }

    @Override
    public void onError(Throwable throwable) {
        log.error("{} error", name, throwable);

    }

    @Override
    public void onComplete() {
        log.info("{} completed!", name);

    }
}
