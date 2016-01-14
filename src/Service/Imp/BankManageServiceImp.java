package Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.BankDao;
import Model.BankAccount;
import Service.BankManageService;

@Repository
public class BankManageServiceImp implements BankManageService{
	@Autowired
	BankDao bd;

	@Override
	public BankAccount getAccountByName(String name) {
		// TODO Auto-generated method stub
		return bd.getAccountByName(name);
	}

	@Override
	public boolean cosume(String name, int value) {
		// TODO Auto-generated method stub
		return bd.cosume(name, value);
	}

	@Override
	public boolean verify(String name, String password) {
		// TODO Auto-generated method stub
		return bd.verify(name, password);
	}

}
