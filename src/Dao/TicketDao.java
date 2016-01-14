package Dao;

import java.util.List;

import Model.Film;
import Model.Member;
import Model.Ticket;



public interface TicketDao {
	
	public void addTicket(Ticket ticket);
	
	public void addTicket(Member member, Film film);
	
	public void deleteTicekt(long ticketId);
	
	public void deleteTicket(Ticket ticket);
	
	public void updateTicket(Ticket ticket);
	
	public void updateTicket(Ticket ticket1, Ticket ticket2);
	
	public List<Ticket> getTicketList(Member member);
	
	public List<Ticket> getTicketList(Film film);

	public List<Ticket> getListByBuyer(String name);
	
	
}
