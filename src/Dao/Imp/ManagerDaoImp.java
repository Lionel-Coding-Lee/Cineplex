package Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.BaseDao;
import Dao.ManagerDao;
import Model.Manager;

@Repository
public class ManagerDaoImp implements ManagerDao{

	@Autowired
	private BaseDao bs;
	@Override
	public Manager getManagerByName(String name) {
		// TODO Auto-generated method stub
		List<Manager> list = (List<Manager>)bs.getAllList(Model.Manager.class);
		for(Manager m : list) {
			if(m.getName().equals(name))
				return m;
		}
		return null;
	}

}
