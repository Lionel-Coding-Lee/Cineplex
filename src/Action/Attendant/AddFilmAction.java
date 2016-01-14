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
import Service.AttendantManageService;
import Service.FilmManageService;
import Action.BaseAction;

@Repository
public class AddFilmAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Autowired
	private AttendantManageService ams;
	@Autowired
	private FilmManageService fms;
	@Autowired
	private Film film;
	public String execute() throws ServletException,IOException {
		String filmname = request.getParameter("name");
		String price = request.getParameter("price");
		String type = request.getParameter("type");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date offline = null;
		try {
			offline = sdf.parse(request.getParameter("offline"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		film.setFilmName(filmname);
		java.sql.Date sqloffline=new java.sql.Date(offline.getTime());
		film.setOffline(sqloffline);
		film.setPrice(price);
		film.setType(type);
		System.out.println("action");
		fms.addFilm(film);
		List<Film> films = fms.getFilmList();
		request.setAttribute("films", films);
		return SUCCESS;
	}
}
