package com.roger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);

		// 以下方式启动时关闭Banner
		/*SpringApplication app = new SpringApplication(SpringBootDemoApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);*/
	}
}
