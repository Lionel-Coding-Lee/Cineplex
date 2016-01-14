package Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import Model.Film;

public interface FilmManageService {
	public Integer validateNumber(String number);

	public void sentErrorMessage(String message, HttpServletRequest req)
			throws ServletException, IOException;

	public void sentMessage(String message, HttpServletRequest req)
			throws ServletException, IOException;
	
	public List<Film> getFilmList();
	
	public void addFilm(Film film);
	
	public void updateFilm();

	public List<Film> getFilmOnList();

	
	public List<Film> getFilmListByDate();

	public Film getFilmById(long filmId);
}
