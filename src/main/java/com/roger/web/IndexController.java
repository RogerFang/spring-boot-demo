package com.roger.web;

import com.roger.config.AuthorSettings;
import com.roger.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roger on 2016/12/3.
 */
@Controller
public class IndexController {

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String index(Model model){
        Person single = new Person("aa", 22);

        List<Person> people = new ArrayList<>();
        people.add(new Person("xx", 10));
        people.add(new Person("yy", 20));
        people.add(new Person("zz", 30));

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring Boot! " + authorSettings;
    }
}
