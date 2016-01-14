package Dao.Imp;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.BaseDao;
import Dao.MemberDao;
import Model.Member;


@Repository
public class MemberDaoImp implements MemberDao{
	@Autowired
	private BaseDao basedao;

	@Override
	public void save(Member member) {
		// TODO Auto-generated method stub
		try{
			basedao.save(member);
			System.out.println("where happens");
		}catch(Exception e){
			
		}
		
	}

	@Override
	public Member find(long id) {
		// TODO Auto-generated method stub
		List<Member> list = basedao.getAllList(Model.Member.class);
		
		for(Member m : list) {
			if(m.getId() == id)
				return m;
		}
		return null;
	}

	@Override
	public void updateById(Member member) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Member findByName(String name) {
		// TODO Auto-generated method stub
		
		//System.out.println("Here");
		
		List<Member> list = basedao.getAllList(Model.Member.class);
		
		//System.out.println("There");
        for(int i = 0; i < list.size(); i++) {
        	Member temp = list.get(i);
        	if(temp.getName().equals(name))
        		return temp;
        }
		return null;
	}

	@Override
	public int getRank(String name) {
		// TODO Auto-generated method stub
		return findByName(name).getVIP();
	}

	@Override
	public List<Member> getAll() {
		// TODO Auto-generated method stub
		List<Member> list = basedao.getAllList(Model.Member.class);
		return list;
	}

	@Override
	public void setRank(long id, int rank) {
		// TODO Auto-generated method stub
		Member m = find(id);
		m.setRank(rank);
		m.setIsForzen(false);
		m.setLastRecord(new java.sql.Date(new Date().getTime()));
		basedao.update(m);
	}

	@Override
	public void frozen() {
		// TODO Auto-generated method stub
		List<Member> list = basedao.getAllList(Model.Member.class);
		for(Member m : list) {
			long distance = new Date().getTime() - m.getLastRecord().getTime();
			if(distance >= 365*12*30*3600*1000) {
				m.setIsForzen(true);
				basedao.update(m);
			}
		}
	}
	
	

}
