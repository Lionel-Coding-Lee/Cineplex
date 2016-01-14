package Dao;

import java.util.List;

import Model.Member;

public interface MemberDao {

	public void save(Member member);
	public Member find(long id);
	public void updateById(Member member);
	public Member findByName(String name);
	public int getRank(String name);
	public List<Member> getAll();
	public void setRank(long id, int rank);
	public void frozen();
	
}
