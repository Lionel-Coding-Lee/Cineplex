package Action.Member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Action.BaseAction;
import Model.Match;
import Model.Member;
import Model.Ticket;
import Service.FilmManageService;
import Service.MatchManageService;
import Service.MemberManageService;
import Service.TicketManageService;

@Repository
public class TicketAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	private MemberManageService memberManageService;  
	@Autowired
	private Member member; 
	@Autowired
	private FilmManageService filmManageService;
	@Autowired
	private MatchManageService matchManageService;
	@Autowired
	private TicketManageService ticketManageService;
	
	public String execute() throws ServletException,IOException {
		HttpSession session = request.getSession();
		member = (Member) session.getAttribute("member");
		String name = member.getName();
		List<Match> ml = matchManageService.getPassMatches();
		List<Ticket> tl = ticketManageService.getListByBuyer(name);
		request.setAttribute("tickets", tl);
		request.setAttribute("matches", ml);
		return SUCCESS;
	}
}
