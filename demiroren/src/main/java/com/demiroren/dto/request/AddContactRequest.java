package com.demiroren.dto.request;

import java.util.List;
import java.util.Objects;

import com.demiroren.Entity.Phone;

/**
 * @author Remzi ŞAHBAZ
 *
 */
public class AddContactRequest {

	
	private String name;
	private String lastName;
	private List<Phone> phone;
	
	
	/**
	 * 
	 */
	public AddContactRequest() {
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Objects.nonNull(name);
		this.name = name;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		Objects.nonNull(lastName);
		this.lastName = lastName;
	}
	/**
	 * @return the phone
	 */
	public List<Phone>  getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(List<Phone>  phone) {
		this.phone = phone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(lastName, name, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddContactRequest other = (AddContactRequest) obj;
		return Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}
	@Override
	public String toString() {
		return "AddContactRequest [name=" + name + ", lastName=" + lastName + ", phone=" + phone + "]";
	}


}
