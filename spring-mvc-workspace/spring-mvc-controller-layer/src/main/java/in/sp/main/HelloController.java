package in.sp.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

//option 1 
//with @Controller and @ResponseBody where it convert data into json 
//not opening welcome.jsp only display welcome in browser 


//@Controller
//public class HelloController {
//	
//	@GetMapping("helloPage")
//	@ResponseBody
//	public String sayHello(Model model) {
//		model.addAttribute("message","Hello , Spring MVC!");
//		return "welcome";
//	}
//}




//using RestController =@Controller +@ResponseBody
@RestController
public class HelloController {
	
	@GetMapping("helloPage")
	public String sayHello() {
		return "Hello from @RestController | welcome";
	}
}


