package Action.Member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Film;
import Model.Match;
import Model.Member;
import Model.Ticket;
import Service.AttendantManageService;
import Service.BankManageService;
import Service.FilmManageService;
import Service.MatchManageService;
import Service.MemberManageService;
import Service.TicketManageService;
import Action.BaseAction;

@Repository
public class PersonPayAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AttendantManageService ams;
	@Autowired
	private FilmManageService fms;
	@Autowired
	private MatchManageService mms;
	@Autowired
	private TicketManageService tms;
	@Autowired
	private Ticket t;
	@Autowired
	private BankManageService bms;
	@Autowired
	private MemberManageService mbms;

	public String execute() throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		//String memberName = member.getName();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		int price = Integer.parseInt(request.getParameter("num"));
		
		if (bms.verify(account, password)) {
			
			if (bms.cosume(account, price)){
				request.setAttribute("mess", "购买成功，银行账户消费" + price + "元");
				System.out.println("购买成功，银行账户消费" + price + "元");
				
				int rank = price/100;
				
				mbms.setRank(member.getId(), rank);
				Member m = mbms.getMemberByName(member.getName());
				request.setAttribute("member",	m);
				return SUCCESS;
			}
				
			else{
				request.setAttribute("mess", "账户余额不足");
				return INPUT;
			}
				
		} else {
			request.setAttribute("mess", "账户用户或密码不正确");
			return INPUT;
		}
		
		
	}

}
