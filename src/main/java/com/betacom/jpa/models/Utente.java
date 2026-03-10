package com.betacom.jpa.models;

import javax.management.relation.Role;

import com.betacom.jpa.enums.Roles;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="utente")
@Getter
@Setter

public class Utente {
	@Id
	
	private String userName;
	private String pwd;
	private String email;
	private Roles   role;
}
