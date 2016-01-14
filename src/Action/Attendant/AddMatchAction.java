package Action.Attendant;

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
public class AddMatchAction extends BaseAction {

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
		String filmname = request.getParameter("filmname");
		int hallNo = Integer.parseInt(request.getParameter("hall"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(request.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		long filmId = 0;
		
		List<Film> films = fms.getFilmList();
		request.setAttribute("films", films);

		for (Film film : films) {
			if (filmname.equals(film.getFilmName()))
				filmId = film.getFilmNumber();
		}
		
		match.setFilmId(filmId);
		match.setHallNum(hallNo);
		match.setTime(sqldate);
		mms.addMatch(match);
		
		List<Film> filmList = fms.getFilmList();
		request.setAttribute("films", filmList);
		List<Match> passList = mms.getPassMatches();
		request.setAttribute("passmatches", passList);
		List<Match> waitList = mms.getWaitingMatches();
		request.setAttribute("waitmatches", waitList);
		return SUCCESS;
	}
}
