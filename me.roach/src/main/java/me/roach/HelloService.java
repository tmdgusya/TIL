package me.roach;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getName() {
        return "roach";
    }
}
