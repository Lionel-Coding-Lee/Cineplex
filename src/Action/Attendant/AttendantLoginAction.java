package Action.Attendant;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Action.BaseAction;
import Model.Attendant;
import Model.Film;
import Model.Match;
import Service.ActivityManageService;
import Service.AttendantManageService;
import Service.FilmManageService;
import Service.MatchManageService;

@Repository
public class AttendantLoginAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private AttendantManageService ams;
	@Autowired
	private FilmManageService fms;
	@Autowired
	private ActivityManageService acms;
	@Autowired
	private MatchManageService mms;
	@Autowired
	private Attendant att;
	
	public String execute() throws ServletException,IOException {

		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if(password == "") {
			
			return INPUT;
		}
		att = ams.getAttendantByName(name);
		if(att == null) {
			System.out.println("Sorry");
			return INPUT;
		}
		if(!password.equals(att.getPassword())) {
			System.out.println("Error pass");
			System.out.println(att.getPassword());
			return INPUT;
		}
		else {
			List<Film> films = fms.getFilmOnList();
			request.setAttribute("films", films);
			for(Film film : films) {
				List<Match> matches = mms.getMatchesByName(film.getFilmNumber());
				request.setAttribute(film.getFilmName(), matches);
			}
			return SUCCESS;	
		}
	}
	
	
}
