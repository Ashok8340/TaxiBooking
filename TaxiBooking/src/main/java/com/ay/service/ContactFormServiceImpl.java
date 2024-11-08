package com.ay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ay.dao.ContactFormCrud;
import com.ay.model.ContactForm;

@Service
public class ContactFormServiceImpl  implements  ContactFormService{

	
	private ContactFormCrud contactFormCrud;
	
	@Autowired
	public void setContactFormCrud(ContactFormCrud contactFormCrud) {
		this.contactFormCrud = contactFormCrud;
	}



	@Override
	public ContactForm saveContactFormService(ContactForm contactForm) {
		// TODO Auto-generated method stub
		
	return contactFormCrud.save(contactForm);
	}
	
	

}
