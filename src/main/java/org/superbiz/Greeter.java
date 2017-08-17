package org.superbiz;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Greeter {
    public String greet() {
        return "Howdy at " + LocalDateTime.now();
    }
}
