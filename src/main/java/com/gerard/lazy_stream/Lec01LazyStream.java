package com.gerard.lazy_stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;


/*
*  Streams were introduced in Java 8
*  Very useful for the functional paradigm
*  By default they're 'lazy'
* */
public class Lec01LazyStream {

    private static final Logger log = LoggerFactory.getLogger(Lec01LazyStream.class);

    public static void main(String[] args) {

        Stream.of(1)
                .peek(i -> log.info("received: {}", i)) // This won't execute anything.
                .toList(); // This is known as Terminal Operator, this will actually execute the Lazy Stream
    }
}
