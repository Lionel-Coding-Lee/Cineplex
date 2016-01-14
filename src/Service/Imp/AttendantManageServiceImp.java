package Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.AttendantDao;
import Model.Attendant;
import Service.AttendantManageService;

@Repository
public class AttendantManageServiceImp implements AttendantManageService{
	
	
	@Autowired
	private AttendantDao attendantdao;

	@Override
	public Attendant getMemberByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attendant getAttendantByName(String name) {
		// TODO Auto-generated method stub
		return attendantdao.getAttendantByName(name);
	}

}
