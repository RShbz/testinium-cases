package com.demiroren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.demiroren.dto.request.AddContactRequest;
import com.demiroren.dto.response.AddContactResponse;
import com.demiroren.service.ContactService;

/**
 * @author Remzi ŞAHBAZ
 *
 */

@RestController
@RequestScope
@RequestMapping("/contact")
@Validated
public class ContactController {
	@Autowired
	private ContactService contactService;

	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@PostMapping
	public AddContactResponse HireContact(@RequestBody AddContactRequest request) {

		return contactService.addContact(request);
	}

//	@GetMapping("{name,lastName}")
//	public AddContactRequest GetInformationContact(@RequestBody AddContactRequest request) {
//
//		return contactService.addContact(request);
//	}
}
