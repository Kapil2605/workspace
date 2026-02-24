package in.sp.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

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
	
	@GetMapping("/myForm")
	public String openFormPage() {
		return "my-form";
	}
	
	@PostMapping("/submitForm")
	public String handleMyForm(
			@RequestParam("name1") String myName,
			@RequestParam("email1") String myEmail,
			@RequestParam("phoneno1") String myPhoneNo,
			Model model
			
			) {
		
		
		
		System.out.println("Name: "+myName);
		System.out.println("Email: "+myEmail);
		System.out.println("PhoneNo: "+myPhoneNo);
		
		model.addAttribute("model_name", myName);
		model.addAttribute("model_email", myEmail);
		model.addAttribute("model_phoneNo", myPhoneNo);
		
		return "profile";
	}
}
