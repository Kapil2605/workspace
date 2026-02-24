package in.sp.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/aboutPage")
	public String openAboutUs() {
		return "about-us";
	}
}
