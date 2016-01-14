package Service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import Model.Member;

public interface MemberManageService {

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String registerMember(Member member);

	public Member find(long id);

	public String test();

	public Member getMemberByName(String name);

	public int getRank(String memberName);

	public List<Member> getAll();

	public void setRank(long id, int rank);
}
