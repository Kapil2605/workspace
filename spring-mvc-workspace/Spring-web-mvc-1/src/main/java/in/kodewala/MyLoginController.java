package in.kodewala;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyLoginController {
	@GetMapping("/loginPage")
	public ModelAndView openHelloPage() {
		System.out.println("Login page");
		
		ModelAndView obj=new ModelAndView();
		obj.setViewName("login");
		return obj;
	}
}
