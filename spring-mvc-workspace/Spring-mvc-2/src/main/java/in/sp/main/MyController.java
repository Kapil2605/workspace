package in.sp.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	//@RequestMapping(value="/helloPage" method=RequestMethod.GET)
	
	@GetMapping("/helloPage")
	public ModelAndView openHelloPage() {
		System.out.println("Hello page");
		
		ModelAndView obj=new ModelAndView();
		obj.setViewName("hello");
		return obj;
	}
	
	@GetMapping("/aboutPage")
	public String openAboutUs() {
		return "about-us";
	}
}
