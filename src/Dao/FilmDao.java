package Dao;

import java.util.List;

import Model.Film;

public interface FilmDao {
	
	public List<Film> getFilmList();
	
	public void addFilm(Film film);
	
	public void updateFilm(Film film);
	
	public Film getFilm(Long filmId);

	public List<Film> getFilmOnList();

	public List<Film> getFilmListByDate();

	public Film getFilmById(long filmId);
	

}
