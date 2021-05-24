package main.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="/")
	public String test(Model model) throws Exception {
		System.out.println("controller");

		return "main/Main";
	}
}