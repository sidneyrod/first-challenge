package com.challenge.vaccine.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.challenge.vaccine.entities.User;
import com.challenge.vaccine.entities.VaccinationControl;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotNull
	@NotBlank(message = "Required field name")
	private String name;
	
	@NotNull
	@NotBlank(message = "Please enter a valid email address")
	@Email(message = "Insert a valid email")
	private String email;
	
	@NotNull
	@NotBlank(message = "Please enter a valid CPF")
	private String numberCpf;
	
	@NotNull(message = "Please enter a valid birthdate")
	@PastOrPresent
	private Date birthDate;
	
	private List<VaccinationControl> vaccinationControls = new ArrayList<>();
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email, String numberCpf, Date birthDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.numberCpf = numberCpf;
		this.birthDate = birthDate;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		numberCpf = entity.getNumberCpf();
		birthDate = entity.getBirthDate();
	}
	
	public UserDTO (User entity, Set<VaccinationControl> vaccinationControls) {
		this(entity);
		vaccinationControls.forEach(vacc -> this.vaccinationControls.add(vacc));
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumberCpf() {
		return numberCpf;
	}

	public void setNumberCpf(String numberCpf) {
		this.numberCpf = numberCpf;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<VaccinationControl> getVaccinationControls() {
		return vaccinationControls;
	}
}