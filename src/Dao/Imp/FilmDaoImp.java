package Dao.Imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.BaseDao;
import Dao.FilmDao;
import Model.Film;


@Repository
public class FilmDaoImp implements FilmDao{
	/**
	 * 
	 */
	@Autowired
	private BaseDao basedao;
	
	@Override
	public List<Film> getFilmList() {
		// TODO Auto-generated method stub
		return basedao.getAllList(Model.Film.class);
	}

	@Override
	public void addFilm(Film film) {
		// TODO Auto-generated method stub
		long number = 0;
		List<Film> list = basedao.getAllList(Model.Film.class);
		for(Film temp : list) {
			if(temp.getFilmNumber() >= number)
				number = temp.getFilmNumber() + 1;
		}
		film.setFilmNumber(number);
		System.out.println("dao"+number);
		basedao.save(film);
	}

	@Override
	public void updateFilm(Film film) {
		// TODO Auto-generated method stub
		basedao.update(film);
	}

	@Override
	public Film getFilm(Long filmId) {
		// TODO Auto-generated method stub
		String strId = String.valueOf(filmId);
		Film film = (Film) basedao.load(Model.Film.class, strId);
		return film;
	}

	@Override
	public List<Film> getFilmOnList() {
		// TODO Auto-generated method stub
		List<Film> films = basedao.getAllList(Model.Film.class);
		List<Film> filmson = new ArrayList();
		Date now = new Date();
		for(Film film : films) {
			if(now.getTime() < film.getOffline().getTime())
				filmson.add(film);
		}
		return filmson;
	}

	@Override
	public List<Film> getFilmListByDate() {
		// TODO Auto-generated method stub
		List<Film> films = basedao.getAllList(Model.Film.class);
		List<Film> filmson = new ArrayList();
		Date now = new Date();
		for(Film film : films) {
			if(now.getTime() <= film.getOffline().getTime())
				filmson.add(film);
		}
		return filmson;
	}

	@Override
	public Film getFilmById(long filmId) {
		// TODO Auto-generated method stub
		List<Film> films = basedao.getAllList(Model.Film.class);
		List<Film> filmson = new ArrayList();
		Date now = new Date();
		for(Film film : films) {
			if(film.getFilmNumber() == filmId)
				return film;
		}
		return null;
	}
	

}
