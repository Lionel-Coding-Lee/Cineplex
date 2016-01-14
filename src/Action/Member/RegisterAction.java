package Action.Member;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Action.BaseAction;
import Model.Member;
import Service.MemberManageService;

@Repository
public class RegisterAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private MemberManageService memberManageService;
	@Autowired
	private Member member;

	public String execute() throws ServletException, IOException {
		if (memberManageService == null)
			System.out.println("Member service null");
		// String test=MemberService.test();

		String message = "";
		int year = 0;
		int month = 0;
		int day = 0;
		try {
			year = Integer.valueOf(request.getParameter("year")).intValue();
			month = Integer.valueOf(request.getParameter("month")).intValue() - 1;
			day = Integer.valueOf(request.getParameter("day")).intValue();
		} catch (Exception e) {
			message += "Birthday must be a Integer!<br>";
			// MemberService.sentMessage(message,request);
			request.setAttribute("mess", message);
			return INPUT;
		}
		if (request.getParameter("password").equals(
				request.getParameter("password2"))) {
			member.setPassword(request.getParameter("password"));
		} else {
			message += "Password not match!<br>";
			// MemberService.sentMessage(message,request);
			return INPUT;
		}
		System.out.println(member.getId() + " Member execute");

		member.setIdByDate();
		member.setName(request.getParameter("name"));
		member.setPhoneNumber(request.getParameter("phone"));
		member.setBalance(2000);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		Date date = new Date(calendar.getTimeInMillis());
		member.setBirthday(date);

		memberManageService.registerMember(member);
		session.put("Member", member);
		return SUCCESS;
	}

	public void setMember(Member Member) {
		this.member = Member;
		System.out.println(Member.getId() + "Member");
	}

	public Member getMember() {
		if (member == null)
			System.out.println("Member null\n");
		return member;
	}

}
