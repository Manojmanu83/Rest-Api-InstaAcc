package com.restapi.InstaAccounts.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

	@GetMapping("/")
	public String loadHome() {
		return "redirect:/swagger-ui/index.html";
	}
}
