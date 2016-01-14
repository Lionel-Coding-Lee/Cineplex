package Action.Manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Action.BaseAction;
import Model.Manager;
import Model.Film;
import Model.Match;
import Service.ActivityManageService;
import Service.ManagerManageService;
import Service.FilmManageService;
import Service.MatchManageService;

@Repository
public class LoginAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private ManagerManageService ams;
	@Autowired
	private FilmManageService fms;
	
	@Autowired
	private MatchManageService mms;
	@Autowired
	private Manager manager;
	
	public String execute() throws ServletException,IOException {

		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if(password == "") {
			
			return INPUT;
		}
		manager = ams.getManagerByName(name);
		if(manager == null) {
			System.out.println("Sorry");
			return INPUT;
		}
		if(!password.equals(manager.getPassword())) {
			System.out.println("Error pass");
			System.out.println(manager.getPassword());
			return INPUT;
		}
		else {
			List<Film> films = fms.getFilmOnList();
			request.setAttribute("manafilms", films);
			for(Film film : films) {
				List<Match> matches = mms.getMatchesByName(film.getFilmNumber());
				request.setAttribute(film.getFilmName(), matches);
			}
			List<Match> matches = mms.getMatchesByDate();
			session.setAttribute("mathces", matches);
			List<Match> waitingmatches = mms.getWaitingMatches();
			session.setAttribute("waitingmathces", waitingmatches);
			return SUCCESS;	
		}
	}
	
	
}
