package com.flight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flight.model.Person;
import com.flight.model.Role;
import com.flight.service.PersonService;




@Controller
@Scope("session")
public class LoginController {

	@Autowired
	PersonService personService;
		
	public void setUserService(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
 		return "login";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(Model model) {
		 model.addAttribute("person", new Person());
		return "register";
	}
  
	@RequestMapping(value="/registerSave", method = RequestMethod.POST)
	public String registerSave(@ModelAttribute("person") Person person, BindingResult result,HttpServletRequest request, Model model,RedirectAttributes attributes) {
		
		person.getUser().setRole(Role.ROLE_USER);
		person.getUser().setEnabled(true);
		personService.savePerson(person);
		attributes.addFlashAttribute("message", "User "+person.getFirstName()+" has been registered. Login with username/password");
		return "redirect:/";
	}

//	@RequestMapping(value="/j_spring_security_check", method = RequestMethod.POST)
//	public ModelAndView PostLogin(HttpServletRequest request) {
//		List<Person> personx=personService.getAllPerson();
//		ModelAndView modelAndView =new ModelAndView ();
//		for(Person s:personx){ 
//			if(request.getParameter("username").equals(s.getUserName())&& request.getParameter("password").equals(s.getPassword())){
//				modelAndView.addObject("person",s);
//				System.out.println(s.getUserName());
//				System.out.println(s.getPassword());
//				modelAndView.setViewName("home");
//				return modelAndView;
//			}
//		}
//		
//		modelAndView.setViewName("login");
//		return modelAndView;
//	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "invalid username password");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession status) {
		status.invalidate();
 		return "redirect:/";
 	}
}
