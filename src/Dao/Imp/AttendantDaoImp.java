package Dao.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.AttendantDao;
import Dao.BaseDao;
import Model.Attendant;

@Repository
public class AttendantDaoImp implements AttendantDao{

	@Autowired
	private Attendant att;
	@Autowired
	private BaseDao basedao;
	
	
	@Override
	public Attendant getAttendantByName(String name) {
		// TODO Auto-generated method stub
		
		return (Attendant) basedao.load(Model.Attendant.class, name);
	}

}
