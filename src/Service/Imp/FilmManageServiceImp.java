package Service.Imp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.FilmDao;
import Model.Film;
import Service.FilmManageService;


@Repository
public class FilmManageServiceImp implements FilmManageService {
	
	/**
	 * Default Constructor
	 */
	@Autowired
	private FilmDao filmdao;
	
	@Override
	public Integer validateNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sentErrorMessage(String message, HttpServletRequest req)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sentMessage(String message, HttpServletRequest req)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Film> getFilmList() {
		// TODO Auto-generated method stub
		return filmdao.getFilmList();
	}


	@Override
	public void updateFilm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Film> getFilmOnList() {
		// TODO Auto-generated method stub
		return filmdao.getFilmOnList();
	}

	@Override
	public List<Film> getFilmListByDate() {
		// TODO Auto-generated method stub
		return filmdao.getFilmListByDate();
	}

	@Override
	public void addFilm(Film film) {
		// TODO Auto-generated method stub
		System.out.println("service");
		filmdao.addFilm(film);
	}

	@Override
	public Film getFilmById(long filmId) {
		// TODO Auto-generated method stub
		return filmdao.getFilmById(filmId);
	}

}
