package Action.Member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Film;
import Model.Match;
import Model.Member;
import Model.Ticket;
import Service.AttendantManageService;
import Service.BankManageService;
import Service.FilmManageService;
import Service.MatchManageService;
import Service.MemberManageService;
import Service.TicketManageService;
import Action.BaseAction;

@Repository
public class PayAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AttendantManageService ams;
	@Autowired
	private FilmManageService fms;
	@Autowired
	private MatchManageService mms;
	@Autowired
	private TicketManageService tms;
	@Autowired
	private Ticket t;
	@Autowired
	private BankManageService bms;
	@Autowired
	private MemberManageService mbms;

	public String execute() throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		long matchId = (long) session.getAttribute("matchId");
		int seat = (int) session.getAttribute("seat");
		String memberName = member.getName();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
//		String s = request.getParameter("seat");
//		System.out.println(s);
//		int seat = Integer.parseInt(s); 

		Match m = mms.getMatchById(matchId);
		//m.addSeat(seat);
		mms.addSeat(matchId, seat);
		Film f = fms.getFilmById(m.getFilmId());
		
		if (bms.verify(account, password)) {
			int rank = (int) member.getRank();
			double d = (double) rank;
			double r = d/10;
			int price = (int) ((1.0 - r) * Double.parseDouble(f.getPrice()));
			if (bms.cosume(account, price)){
				request.setAttribute("mess", "购买成功，银行账户消费" + price + "元");
				System.out.println("购买成功，银行账户消费" + price + "元");
				t.setbuyerName(memberName);
				t.setFilmName(f.getFilmName());
				t.setSeat(seat);
				t.setMatchId(matchId);
			
				tms.addTicket(t);
				
				List<Film> films = fms.getFilmOnList();
				request.setAttribute("films", films);
				for(Film film : films) {
					List<Match> matches = mms.getMatchesByName(film.getFilmNumber());
					request.setAttribute(film.getFilmName(), matches);
				}
				return SUCCESS;
			}
				
			else{
				request.setAttribute("mess", "账户余额不足");
				return INPUT;
			}
				
		} else {
			request.setAttribute("mess", "账户用户或密码不正确");
			return INPUT;
		}
	}

}
