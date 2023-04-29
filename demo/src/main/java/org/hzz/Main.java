package org.hzz;

import lombok.extern.slf4j.Slf4j;

public class Main {
    public static void main(String[] args) {
        MyFactory.getSomething();
        System.out.println("over"); // problem:not printed
    }
}
