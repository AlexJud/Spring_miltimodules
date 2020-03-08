package com.nec.process;

import org.springframework.stereotype.Component;

@Component
public class Process {

    synchronized public void sleep() throws InterruptedException {
        System.out.println("execute in method Process, and sleep... Bean " + this.hashCode() + " - Thread: " + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("...waik up, and exit out of method Process " + Thread.currentThread().getName());
    }

}
