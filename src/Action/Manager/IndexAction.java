package Action.Manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Film;
import Model.Match;
import Service.FilmManageService;
import Service.MatchManageService;
import Action.BaseAction;


@Repository
public class IndexAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private FilmManageService fms;
	@Autowired
	private MatchManageService mms;
	
	public String execute() throws ServletException,IOException {
	
		List<Film> films = fms.getFilmOnList();
		request.setAttribute("manafilms", films);
		for(Film film : films) {
			List<Match> matches = mms.getMatchesByName(film.getFilmNumber());
			request.setAttribute(film.getFilmName(), matches);
		}
		return SUCCESS;
	}
}
