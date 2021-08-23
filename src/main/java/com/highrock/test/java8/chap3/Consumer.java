package com.highrock.test.java8.chap3;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t) ;
}
