package Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.BankDao;
import Dao.BaseDao;
import Model.BankAccount;

@Repository
public class BankDaoImp implements BankDao{
	@Autowired
	BaseDao basedao;

	@Override
	public BankAccount getAccountByName(String name) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<BankAccount> list = basedao.getAllList(Model.BankAccount.class);
		for(BankAccount ba : list) {
			int temp = ba.getAccountId();
			if(String.valueOf(temp).equals(name))
				return ba;
		}
		
		return null;
	}

	@Override
	public boolean cosume(String name, int value) {
		// TODO Auto-generated method stub
		BankAccount ba = getAccountByName(name);
		boolean b = ba.cosume(value);
		basedao.update(ba);
		return b;
	}

	@Override
	public boolean verify(String name, String password) {
		// TODO Auto-generated method stub
		if(getAccountByName(name).getPassword().equals(password))
			return true;
		return false;
	}

}
