package com.roger.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Roger on 2016/12/6.
 */
@Component
@Order(value = 2)
public class SecondCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>second command line runner: " + strings);
    }
}
