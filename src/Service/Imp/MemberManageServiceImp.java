package Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.MemberDao;
import Model.Member;
import Service.MemberManageService;

@Repository
public class MemberManageServiceImp implements MemberManageService{
	 /**
     * Default constructor. 
     */
	@Autowired
	private MemberDao memberDao;

	@Override
	public String registerMember(Member member) {
		// TODO Auto-generated method stub
		String message = "";
		System.out.println("hello?");
		memberDao.save(member);
			
		return message;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member find(long id) {
		// TODO Auto-generated method stub
		return memberDao.find(id);
	}

	@Override
	public Member getMemberByName(String name) {
		// TODO Auto-generated method stub
		//System.out.println("Hello Meto");
		return memberDao.findByName(name);
	}

	@Override
	public int getRank(String memberName) {
		// TODO Auto-generated method stub
		return memberDao.getRank(memberName);
	}

	@Override
	public List<Member> getAll() {
		// TODO Auto-generated method stub
		return memberDao.getAll();
	}

	@Override
	public void setRank(long id, int rank) {
		// TODO Auto-generated method stub
		memberDao.setRank(id, rank);
	}

}
