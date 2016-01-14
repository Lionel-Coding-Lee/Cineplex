package Service;

import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import Model.Member;
import Model.Ticket;

public interface TicketManageService {
	public void addTicket(Ticket ticket);

	public void addTicket(Member member, Match match);

	public void cancelTicket(Ticket ticket);

	public List<Ticket> getListByBuyer(String name);
	

}
