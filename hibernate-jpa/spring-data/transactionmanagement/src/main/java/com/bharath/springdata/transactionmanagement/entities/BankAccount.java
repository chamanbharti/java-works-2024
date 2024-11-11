package com.bharath.springdata.transactionmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount {
	
	@Id
	
	private int accno;
	private String firstname;
	private String lastname;
	private int bal;

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", firstname=" + firstname + ", lastname=" + lastname + ", bal=" + bal
				+ "]";
	}

	

	
}
