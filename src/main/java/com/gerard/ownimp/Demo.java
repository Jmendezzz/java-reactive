package com.gerard.ownimp;

import com.gerard.ownimp.publisher.PublisherImpl;
import com.gerard.ownimp.suscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class Demo {
  public static void main(String[] args) {

    //demo1(); Nothing should happen here.

    demo2();

  }

  private static void demo1(){
    Publisher<String> publisher = new PublisherImpl();
    Subscriber<String> subscriber = new SubscriberImpl();

    publisher.subscribe(subscriber);
  }

  private static void demo2(){
    PublisherImpl publisher = new PublisherImpl();
    SubscriberImpl subscriber = new SubscriberImpl();

    publisher.subscribe(subscriber);
    subscriber.getSubscription().request(3);

  }
}
