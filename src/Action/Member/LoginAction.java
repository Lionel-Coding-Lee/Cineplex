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
import Service.TimerService;


@Repository
public class LoginAction extends BaseAction {
	/**
	 * 
	 */
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
	@Autowired
	private TimerService timerService;
	
	public String execute() throws ServletException,IOException {
		
		timerService.timeRun();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if(password == "") {
			
			return INPUT;
		}
		member = memberManageService.getMemberByName(name);
		if(member == null) {
			System.out.println("No member");
			return INPUT;
		}
		if(!password.equals(member.getPassword())) {
			System.out.println("Error pass");
			System.out.println(member.getPassword());
			return INPUT;
		}else {
			List<Film> filmson = filmManageService.getFilmOnList();
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			request.setAttribute("films", filmson);
			for(Film film : filmson) {
				List<Match> matches = matchManageService.getMatchesByName(film.getFilmNumber());
				request.setAttribute(film.getFilmName(), matches);
			}
			List<Ticket> tickets = ticketManageService.getListByBuyer(member.getName());
			request.setAttribute("tickets", tickets);
			return "successmem";
		}
	}

}
