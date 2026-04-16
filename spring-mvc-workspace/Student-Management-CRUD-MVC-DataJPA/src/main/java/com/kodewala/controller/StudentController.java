package com.kodewala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.service.annotation.DeleteExchange;

import com.kodewala.entity.Student;
import com.kodewala.service.IStudentService;

@Controller
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/test")
	@ResponseBody
	public String testStudent() {
		return "Welcome to test";
	}
	
	@GetMapping("/createStudentPage")
	public String createStudentPage(Model model) {
		model.addAttribute("student", new Student());
		return "create-student";
	}
	
	
	@PostMapping("/createStudent")
	public String createStudent(@ModelAttribute("student") Student std,Model model) {
		Student validStudent=studentService.create(std);
		System.out.println(validStudent.getName());
		model.addAttribute("response",validStudent);
		return "profile";
	}
	
	@PostMapping("/searchStudent")
	public String searchStudent(@RequestParam("id") int id,Model model) {
		Student std=studentService.getStudentById(id);
		model.addAttribute("response",std);
		return "profile";
	}
	
	
	@GetMapping("/editPage/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit-student";
    }
	
	@PostMapping("/editStudent")
	public String update(@ModelAttribute Student student,@RequestParam("id") String id,Model model) {
		studentService.update(student);
		model.addAttribute("response",student);
        return "profile";
    }
	
	@GetMapping("/deleteStudent/{id}")
	@ResponseBody
	public String deleteUser(@PathVariable("id") int id, Model model) {
		boolean status=studentService.delete(id);
		if(status) {
			return "deleted";
		}
		else {
			return "not-deleted";
		}
	}
	
}
