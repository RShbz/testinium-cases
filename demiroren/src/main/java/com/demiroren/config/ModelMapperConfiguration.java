package com.demiroren.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demiroren.Entity.Contact;
import com.demiroren.Entity.Phone;
import com.demiroren.dto.request.AddContactRequest;
import com.demiroren.dto.response.AddContactResponse;

/**
 * @author Remzi ŞAHBAZ
 *
 */
@Configuration
public class ModelMapperConfiguration {

	public static final Converter<AddContactRequest, Contact> AddContactRequest_Convert_To_Contact = (context) -> {

		var request = context.getSource();
		var contact = context.getDestination();

		contact.setLastName(request.getLastName());
		contact.setName(request.getName());
//		var phones = request.getPhone()
//						.stream()
//						.map(p->{
//							
//							var phone= new Phone();
//							phone.setValue(p.getValue());
//							return phone;
//						})
//						.toList();
		contact.setPhone(request.getPhone());
		return contact;
	};


	public static final Converter<Contact, AddContactResponse> Contact_Convert_To_ContactResponse = (context) -> {
		
		var contact = context.getSource();
		var response = context.getDestination();
		
		response.setLastName(contact.getLastName());
		response.setName(contact.getName());
		var phones = contact.getPhone()
				.stream()
				.map(p->{
					
					var phone= new Phone();
					phone.setValue(p.getValue());
					
					return phone;
				})
				.toList();
				
		response.setPhone(phones);
		return response;
	};
	
	
	@Bean("modelMapperforCantact")
	public ModelMapper mapper() {
		
		var mapper= new ModelMapper();
		mapper.addConverter(AddContactRequest_Convert_To_Contact);
		mapper.addConverter(Contact_Convert_To_ContactResponse);
		return mapper;
	}
}
