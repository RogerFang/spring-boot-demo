package com.roger;

import com.roger.config.AuthorSettings;
import com.roger.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class SpringBootDemoApplication {

	@Autowired
	private AuthorSettings authorSettings;

	@RequestMapping("/")
	public String index(Model model){
		Person single = new Person("aa", 11);

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

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);

		// 以下方式启动时关闭Banner
		/*SpringApplication app = new SpringApplication(SpringBootDemoApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);*/
	}
}
