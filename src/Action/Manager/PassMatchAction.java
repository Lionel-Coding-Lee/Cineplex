package Action.Manager;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Film;
import Model.Match;
import Service.AttendantManageService;
import Service.FilmManageService;
import Service.MatchManageService;
import Action.BaseAction;

@Repository
public class PassMatchAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private AttendantManageService ams;
	@Autowired
	private MatchManageService mms;
	@Autowired
	private FilmManageService fms;
	@Autowired
	private Match match;

	public String execute() throws ServletException, IOException {
		List<Film> films = fms.getFilmList();
		String matchId = request.getParameter("match");
		mms.setPass(matchId);
		request.setAttribute("films1", films);
		request.setAttribute("films2", films);
		List<Match> passList = mms.getPassMatches();
		request.setAttribute("passmatches", passList);
		List<Match> waitList = mms.getWaitingMatches();
		request.setAttribute("waitmatches", waitList);
		return SUCCESS;
	}
}
