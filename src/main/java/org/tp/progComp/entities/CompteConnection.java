package org.tp.progComp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompteConnection {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;

	private String email;

	private String password;

	public CompteConnection() {

	}

	public CompteConnection(final String email, final String password) {
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
