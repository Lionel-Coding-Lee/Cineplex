package Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.ManagerDao;
import Model.Manager;
import Service.ManagerManageService;

@Repository
public class ManagerManageServiceImp implements ManagerManageService{
	@Autowired
	private ManagerDao md;

	@Override
	public Manager getManagerByName(String name) {
		// TODO Auto-generated method stub
		return md.getManagerByName(name);
	}

}
