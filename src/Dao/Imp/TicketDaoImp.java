package Dao.Imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.BaseDao;
import Dao.TicketDao;
import Model.Film;
import Model.Match;
import Model.Member;
import Model.Ticket;


@Repository
public class TicketDaoImp implements TicketDao{
	/**
	 * 
	 */

	@Autowired
	private BaseDao basedao;
	
	
	@Override
	public void addTicket(Member member, Film film) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTicket(Ticket ticket1, Ticket ticket2) {
		// TODO Auto-generated method stub
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTicketList(Member member) {
		// TODO Auto-generated method stub
		Session session = basedao.getNewSession();
		String sql = "Select * from " + Model.Ticket.class.getName() + " where buyer = " + member.getName();
		List<Ticket> list = session.createQuery(sql).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTicketList(Film film) {
		// TODO Auto-generated method stub
		Session session = basedao.getNewSession();
		String sql = "Select * from " + Model.Ticket.class.getName() + " where filmName = " + film.getFilmName();
		List<Ticket> list = session.createQuery(sql).list();
		return list;
	}

	@Override
	public void addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		long number = 1;
		List<Ticket> list = basedao.getAllList(Model.Ticket.class);
		for(Ticket temp : list) {
			if(temp.getTicketId() >= number) {
				number = temp.getTicketId() + 1;
			}
		}
		ticket.setTicketId(number);
		basedao.save(ticket);
	}

	@Override
	public void deleteTicekt(long ticketId) {
		// TODO Auto-generated method stub
		String strId = String.valueOf(ticketId);
		basedao.delete(Model.Ticket.class, strId);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		basedao.update(ticket);
	}

	@Override
	public List<Ticket> getListByBuyer(String name) {
		// TODO Auto-generated method stub
		List<Ticket> Ticketes = basedao.getAllList(Model.Ticket.class);
		List<Ticket> temp = new ArrayList();
		for(Ticket Ticket : Ticketes) {
			if(Ticket.getbuyerName().equals(name))
				temp.add(Ticket);
		}
		return temp;
	}

}
