package Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import Dao.TicketDao;
import Model.Member;
import Model.Ticket;
import Service.TicketManageService;



@Repository
public class TicektManageServiceImp implements TicketManageService{

	@Autowired
	private TicketDao ticketdao;
	@Override
	public void addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketdao.addTicket(ticket);
	}

	@Override
	public void addTicket(Member member, Match match) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ticket> getListByBuyer(String name) {
		// TODO Auto-generated method stub
		return ticketdao.getListByBuyer(name);
	}

}
