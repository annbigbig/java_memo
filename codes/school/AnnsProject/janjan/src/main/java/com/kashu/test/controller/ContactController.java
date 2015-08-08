package com.kashu.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kashu.test.domain.Contact;
import com.kashu.test.domain.ContactForm;

@Controller
public class ContactController {
	
	@ModelAttribute("contactForm")
	public ContactForm initContactForm(){
		ContactForm form = new ContactForm();
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Barack", "Obama", "barack.o@whitehouse.com", "147-852-965"));
		contacts.add(new Contact("George", "Bush", "george.b@whitehouse.com", "785-985-652"));
		contacts.add(new Contact("Bill", "Clinton", "bill.c@whitehouse.com", "236-587-412"));
		contacts.add(new Contact("Ronald", "Reagan", "ronald.r@whitehouse.com", "369-852-452"));
		form.setContacts(contacts);
		return form;
	}
	
	@RequestMapping(value = "/contact_form", method = RequestMethod.GET)
    public ModelAndView get() {
         
        return new ModelAndView("test/add_contact");
    }
     
    @RequestMapping(value = "/contact_process", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("contactForm") ContactForm contactForm) {
        System.out.println(contactForm);
        System.out.println(contactForm.getContacts());
        List<Contact> contacts = contactForm.getContacts();
         
        if(null != contacts && contacts.size() > 0) {
            //ContactController.contacts = contacts;
            for (Contact contact : contacts) {
                System.out.printf("%s \t %s \n", contact.getFirstname(), contact.getLastname());
            }
        }
         
        return new ModelAndView("test/show_contact", "contactForm", contactForm);
    }
    
}
