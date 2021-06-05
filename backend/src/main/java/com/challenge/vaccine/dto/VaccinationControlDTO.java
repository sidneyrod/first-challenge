package com.challenge.vaccine.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.challenge.vaccine.entities.VaccinationControl;

public class VaccinationControlDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Confirm that the name of the vaccine applied is the correct one")
	private String vaccineName;
	
	@Email(message = "Please enter a valid email address")
	private String userEmail;
	
	@PastOrPresent(message = "Vaccine date cannot be future")
	private Instant vaccineDate;
	
	public VaccinationControlDTO() {
	}

	public VaccinationControlDTO(Long id, String vaccineName, String userEmail, Instant vaccineDate) {
		this.id = id;
		this.vaccineName = vaccineName;
		this.userEmail = userEmail;
		this.vaccineDate = vaccineDate;
	}
	
	public VaccinationControlDTO(VaccinationControl entity) {
		id = entity.getId();
		vaccineName = entity.getVaccineName();
		userEmail = entity.getUserEmail();
		vaccineDate = entity.getVaccineDate();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Instant getVaccineDate() {
		return vaccineDate;
	}

	public void setVaccineDate(Instant vaccineDate) {
		this.vaccineDate = vaccineDate;
	}
}