package com.codecodence.admin_panel_backend.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "trainer")

public class Trainer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String trainerName;
	private String trainerEmail;
	private Long trainerPhoneNumber;
	private String trainerAddress;
	
	public Trainer(){
		
	}

	public Trainer(Long id, String trainerName, String trainerEmail, Long trainerPhoneNumber, String trainerAddress) {
		this.id = id;
		this.trainerName = trainerName;
		this.trainerEmail = trainerEmail;
		this.trainerPhoneNumber = trainerPhoneNumber;
		this.trainerAddress = trainerAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerEmail() {
		return trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	public Long getTrainerPhoneNumber() {
		return trainerPhoneNumber;
	}

	public void setTrainerPhoneNumber(Long trainerPhoneNumber) {
		this.trainerPhoneNumber = trainerPhoneNumber;
	}

	public String getTrainerAddress() {
		return trainerAddress;
	}

	public void setTrainerAddress(String trainerAddress) {
		this.trainerAddress = trainerAddress;
	}

}
