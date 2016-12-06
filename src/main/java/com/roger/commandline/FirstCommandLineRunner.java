package com.roger.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Roger on 2016/12/6.
 */
@Component
@Order(value = 1)
public class FirstCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>first command line runner: " + strings);
    }
}
