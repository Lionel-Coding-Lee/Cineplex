package Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankaccounts")
public class BankAccount implements Serializable {

	@Id
	private int accountId;

	private String password;

	private int balance;

	public void setAccountId(int id) {
		this.accountId = id;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setBalance() {
		this.balance = 5000;
	}

	public boolean cosume(int amount) {
		int rest = this.balance - amount;
		if (rest >= 0) {
			this.balance = rest;
			return true;
		}
		return false;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

}
