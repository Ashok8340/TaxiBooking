package com.ay.controller;

import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ay.model.BookingForm;
import com.ay.model.BookingForm;
import com.ay.model.ContactForm;
import com.ay.service.BookingFormService;
import com.ay.service.ContactFormService;
import com.ay.service.ContactFormServiceImpl;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class MyController {
	
	
	private ContactFormService contactFormService;
	private BookingFormService bookingFormService;
	
	@Autowired
	public void setBookingFormService(BookingFormService bookingFormService) {
		this.bookingFormService = bookingFormService;
	}

	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}

	@GetMapping(path = {"/","home","welcome","index"})
	public String welcomeView(HttpServletRequest req,Model m) {
		m.addText("mycurrentpage");
		m.addText("bookingForm");
		return "index";
	}
	
	@GetMapping("about")
	public String aboutView(HttpServletRequest req,Model m) {
		m.addText("mycurrentpage");
		return "about";
	}
	
	@GetMapping("cars")
	public String carsView(HttpServletRequest req,Model m) {
		m.addText("mycurrentpage");
		return "cars";
	}
	
	@GetMapping("services")
	public String servicesView(HttpServletRequest req,Model m) {
		m.addText("mycurrentpage");
		return "services";
	}
	
	@GetMapping("contacts")
	public String contactsView(HttpServletRequest req,Model m) {
		m.addText("mycurrentpage");		
		m.addText("contactForm");
		return "contacts";
	}
	
	@GetMapping("/login")
	public String adminLoginView(HttpServletRequest request,Model model) {
		
		ServletContext servletContext = request.getServletContext();
		  Object attribute = servletContext.getAttribute("logout");
		  
		  if(attribute instanceof Boolean ) {
			  
			  model.addText("logout");
			  servletContext.removeAttribute("logout");
		  }
		
		return "adminlogin";
		
	}
	
	
	@PostMapping("contactform")
	public String contactForm(@Valid @ModelAttribute ContactForm contactForm,  
	 BindingResult bindingResult,ModelAndViewContainer m,RedirectAttributes redirectAttributes ) {		
		
		if(bindingResult.hasErrors()) {
			m.addAttribute("bindingResult",bindingResult);
			 return "contacts";
		}
		 
	ContactForm saveContactFormService = contactFormService.saveContactFormService(contactForm);
		if(saveContactFormService!= null) {
			redirectAttributes.addFlashAttribute("message","message sent successfully");
		}
		else {
			redirectAttributes.addFlashAttribute("message","something want worng");
		}
		
		return "redirect:/contacts";
	}
	
	@PostMapping("bookingform")
	public String bookingForm(@Valid  @ModelAttribute BookingForm bookingForm,  
	 BindingResult bindingResult,ModelAndViewContainer m,RedirectAttributes redirectAttributes ) {		
		 
		if(bindingResult.hasErrors()) {
			m.addAttribute("bindingResult",bindingResult);
			 return "index";
		}
		
		BookingForm	savebookingFormService = bookingFormService.saveBookingFormService(bookingForm);
		if(savebookingFormService!= null) {
			redirectAttributes.addFlashAttribute("message","message sent successfully");
		}
		else {
			redirectAttributes.addFlashAttribute("message","something want worng");
		}
	    
		return "redirect:/index";
	}

}
