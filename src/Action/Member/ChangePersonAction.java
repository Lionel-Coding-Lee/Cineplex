package Action.Member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Action.BaseAction;
import Model.Film;
import Model.Match;
import Model.Member;
import Model.Ticket;
import Service.FilmManageService;
import Service.MatchManageService;
import Service.MemberManageService;
import Service.TicketManageService;


@Repository
public class ChangePersonAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private MemberManageService memberManageService;  
	@Autowired
	private Member member; 
	
	public String execute() throws ServletException,IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		request.setAttribute("member",	member);
		return SUCCESS;
	}
	

}
