package Action.Member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Action.BaseAction;
import Model.Activity;
import Model.Member;
import Service.ActivityManageService;
import Service.MemberManageService;


@Repository
public class AddActivityAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	private ActivityManageService ams;
	@Autowired
	private MemberManageService mms;
	@Autowired
	private Member member;
	
	public String execute() throws ServletException, IOException {
		HttpSession session = request.getSession();
		member = (Member) session.getAttribute("member");
		long memberId = member.getId();
		
		long activityId = Long.parseLong(request.getParameter("activity"));
		ams.addMemToAct(activityId, memberId);
		
		List<Activity> al = ams.getActivityList();
		request.setAttribute("activitylist", al);
		return SUCCESS;
		
	}

}
