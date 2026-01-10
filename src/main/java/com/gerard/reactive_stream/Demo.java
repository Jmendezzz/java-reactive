package com.gerard.reactive_stream;

import com.gerard.reactive_stream.publisher.PublisherImpl;
import com.gerard.reactive_stream.suscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.time.Duration;

public class Demo {
  public static void main(String[] args) throws InterruptedException {

    //demo1(); Nothing should happen here. Since we're not requesting anything to the Subscription. So the producer won't produce.

    //demo2();

    //demo3();

    demo4();
  }

  private static void demo1(){
    Publisher<String> publisher = new PublisherImpl();
    Subscriber<String> subscriber = new SubscriberImpl();

    publisher.subscribe(subscriber);
  }

  private static void demo2() throws InterruptedException {
    PublisherImpl publisher = new PublisherImpl();
    SubscriberImpl subscriber = new SubscriberImpl();

    publisher.subscribe(subscriber);

    subscriber.getSubscription().request(3); // 3
    Thread.sleep(Duration.ofSeconds(2));

    subscriber.getSubscription().request(3); // 6
    Thread.sleep(Duration.ofSeconds(2));

    subscriber.getSubscription().request(3); // 9
    Thread.sleep(Duration.ofSeconds(2));

    subscriber.getSubscription().request(3); // 12 it'll produce just 10 items, since that's the max established
    Thread.sleep(Duration.ofSeconds(2));

    subscriber.getSubscription().request(3); // 15
  }

  private static void demo3() throws InterruptedException {
    PublisherImpl publisher = new PublisherImpl();
    SubscriberImpl subscriber = new SubscriberImpl();

    publisher.subscribe(subscriber);

    subscriber.getSubscription().request(3); // 3
    Thread.sleep(Duration.ofSeconds(2));

    subscriber.getSubscription().request(3); // 6
    Thread.sleep(Duration.ofSeconds(2));

    subscriber.getSubscription().cancel(); // Cancel subscription
    Thread.sleep(Duration.ofSeconds(2));

    subscriber.getSubscription().request(3); // This won't be executed
  }

  private static void demo4() throws InterruptedException {
    PublisherImpl publisher = new PublisherImpl();
    SubscriberImpl subscriber = new SubscriberImpl();

    publisher.subscribe(subscriber);

    subscriber.getSubscription().request(3); // 3
    Thread.sleep(Duration.ofSeconds(2));

    subscriber.getSubscription().request(11);
    Thread.sleep(Duration.ofSeconds(2));

    subscriber.getSubscription().request(3);
    Thread.sleep(Duration.ofSeconds(2));
  }
}
