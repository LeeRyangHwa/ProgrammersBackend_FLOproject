package com.example.demo;

import com.example.demo.dto.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {

		return "Happy Coding!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
}
