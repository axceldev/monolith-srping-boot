package com.axceldev.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.axceldev.springboot.form.app.editors.CapitalizedNamePropertyEditor;
import com.axceldev.springboot.form.app.editors.CountryPropertyEditor;
import com.axceldev.springboot.form.app.editors.GenderPropertyEditor;
import com.axceldev.springboot.form.app.editors.RolePropertyEditor;
import com.axceldev.springboot.form.app.models.domain.Country;
import com.axceldev.springboot.form.app.models.domain.Gender;
import com.axceldev.springboot.form.app.models.domain.Role;
import com.axceldev.springboot.form.app.models.domain.User;
import com.axceldev.springboot.form.app.services.ICountryService;
import com.axceldev.springboot.form.app.services.IGenderService;
import com.axceldev.springboot.form.app.services.IRoleService;
import com.axceldev.springboot.form.app.validation.UserValidator;


@Controller
@SessionAttributes("user")
public class FormController {
	
	@Autowired
	private UserValidator validator;

	@Autowired
	private ICountryService countryService;
	
	@Autowired
	private IRoleService roleService;

	@Autowired
	private IGenderService genderService;

	@Autowired
	private CountryPropertyEditor CountrypropertyEditor;
	
	@Autowired
	private RolePropertyEditor rolepropertyEditor;

	@Autowired
	private GenderPropertyEditor genderpropertyEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.addValidators(validator);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient( false );
		binder.registerCustomEditor( Date.class, "birthDate",new CustomDateEditor( dateFormat, true ) );

		binder.registerCustomEditor( String.class, "name", new CapitalizedNamePropertyEditor() );
		binder.registerCustomEditor( String.class, "lastName", new CapitalizedNamePropertyEditor() );
		binder.registerCustomEditor( Country.class, "country", CountrypropertyEditor);
		binder.registerCustomEditor( Role.class, "roles", rolepropertyEditor);
		binder.registerCustomEditor( Gender.class, "gender", genderpropertyEditor);
	}

	@ModelAttribute("countries")
	public List<Country> getCountries() {
		List<Country> countriesList = countryService.getListAllCountry();
		return countriesList;
	}

	@ModelAttribute("roles")
	public List<Role> getRoles() {
		List<Role> rolesList = roleService.getListAllRoles();
		return rolesList;
	}

	@ModelAttribute("genders")
	public List<Gender> getGenders() {
		List<Gender> gendersList = genderService.getListAllGender();
		return gendersList;
	}

	@GetMapping("/form")
	public String form(Model model) {
		User userObj = new User();
		userObj.setName("John");
		userObj.setLastName("Doe");
		userObj.setIdentification("12.456.789-K");
		userObj.setEnableBool(true);
		userObj.setHiddenValue("00001");
		userObj.setCountry(new Country(1, "CO", "Colombia"));
		userObj.setRoles(Arrays.asList(
			new Role(1, "ROLE_ADMI", "Administrador")
			));
		model.addAttribute("titulo", "Formulario Registro");
		model.addAttribute("user", userObj);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(@Valid User userObj, BindingResult result, Model model) {
	
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Resultado form");
			return "form";
		}

		return "redirect:/view";
	}

	@GetMapping("/view")
	public String view(@SessionAttribute(name = "user", required = false) User user, Model model, SessionStatus status) {

		if(user == null)
			return "redirect:/form";

		model.addAttribute("titulo", "Resultado form");
		status.setComplete();
		return "resultado";
	}

}

	//LISTAS
	//Lista de strin de paises
	/*@ModelAttribute("countries")
	public List<String> getCountries() {

		List<String> countriesList = Arrays.asList("Colombia", "Mexico", "Chile", "Brasil", "Estados Unidos", "España");
		return countriesList;
		
	}*/

	//Mapa de paises
	/*@ModelAttribute("countries")
	public Map<String,String> getCountriesMap() {

		Map<String, String> countriesMap = new HashMap<>();
		
		countriesMap.put("CO", "Colombia"); 
		countriesMap.put("ME", "Mexico"); 
		countriesMap.put("CL", "Chile"); 
		countriesMap.put("BR", "Brasil");
		countriesMap.put("EU", "Estados Unidos");
		countriesMap.put("ES", "España");

		return countriesMap;

	}*/

	//CHECKBOX

		/*@ModelAttribute("roles")
	public List<String> getRoles() {
		List<String> countriesList = Arrays.asList("Administrador", "Contador", "Auditor", "Coordinador", "Lider", "Gerente");
		return countriesList;
	}*/
	
	/*@ModelAttribute("roles")
	public Map<String, String> getRoles() {
		Map<String, String> rolesMap = new HashMap<>();
	   
		rolesMap.put("ROLE_ADMI", "Administrador"); 
		rolesMap.put("ROLE_CONT", "Contador"); 
		rolesMap.put("ROLE_AUDI",  "Auditor"); 
		rolesMap.put("ROLE_COOR", "Coordinador");
		rolesMap.put("ROLE_LIDE", "Lider");
		rolesMap.put("ROLE_GERE", "Gerente");

		return rolesMap;
	}*/