package Service;

import Model.BankAccount;

public interface BankManageService {
	public boolean verify(String name, String password);

	public BankAccount getAccountByName(String name);

	public boolean cosume(String name, int value);
}
