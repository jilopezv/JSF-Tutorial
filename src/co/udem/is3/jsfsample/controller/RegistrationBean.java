package co.udem.is3.jsfsample.controller;
import javax.faces.bean.ManagedBean;

import co.udem.is3.jsfsample.utils.FormUtils;

@ManagedBean
public class RegistrationBean {
	private String firstName;
	private String lastName;
	private String emailAddress;

	public String doRegistration() {
		if (FormUtils.isAnyMissing(firstName, lastName, emailAddress)) {
			return ("registration-error");
		} else {
			return ("registration-success");
		}
	}

	// Getters & Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}