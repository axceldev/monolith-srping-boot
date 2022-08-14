package com.axceldev.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.axceldev.springboot.form.app.validation.IdentifierRegex;
import com.axceldev.springboot.form.app.validation.Required;

public class User {
	
	@IdentifierRegex
	private String identification;

	private String name;
	
	@Required
	private String lastName;

	@NotBlank
	@Size(min = 3, max=10)
	private String username;
	
	@NotEmpty
	private String password;
	
	@Required
	@Email(message = "correo con formato incorrecto")
	private String email;

	@NotNull(message = "Campo requerido")
	@Min(5)
	@Max(5000)
	private Integer account;

	@NotNull(message = "Campo requerido")
	@Past(message="Tiene que ser una fecha en el pasado.")
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	@NotNull(message="Campo requerido")
	private Country country;

	@NotEmpty(message = "Campo requerido")
	private List<Role> roles;

	private Boolean enableBool;

	@NotNull(message = "Campo requerido")
	private Gender gender;

	private String HiddenValue;

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getEnableBool() {
		return enableBool;
	}

	public void setEnableBool(Boolean enableBool) {
		this.enableBool = enableBool;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getHiddenValue() {
		return HiddenValue;
	}

	public void setHiddenValue(String hiddenValue) {
		HiddenValue = hiddenValue;
	}
	
}
