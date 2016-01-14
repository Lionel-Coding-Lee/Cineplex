package Action.Attendant;

import java.io.IOException;




import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




import Model.Match;
import Service.AttendantManageService;
import Service.FilmManageService;
import Service.MatchManageService;
import Action.BaseAction;

@Repository
public class PrePayAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	private AttendantManageService ams;
	@Autowired
	private FilmManageService fms;
	@Autowired
	private MatchManageService mms;
	
	
	
	public String execute() throws ServletException,IOException {
		long matchId = Long.parseLong(request.getParameter("id"));
		int seat = Integer.parseInt(request.getParameter("seat"));
		request.setAttribute("matchId", matchId);
		request.setAttribute("seat", seat);
		Match m = mms.getMatchById(matchId);
		request.setAttribute("m", m);
		return SUCCESS;
	}
	
}
