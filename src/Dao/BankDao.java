package Dao;

import Model.BankAccount;

public interface BankDao {
	 public BankAccount getAccountByName(String name);
	 public boolean cosume(String name, int value);
	 public boolean verify(String name, String password);
}
