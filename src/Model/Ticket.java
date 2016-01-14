package Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name="tickets")
public class Ticket implements Serializable{
	@Id
	private long ticketId;
	private long matchId;
	private int seat;
	private String filmName;
	private String buyer;

	public void setTicketId(long ticketId) {
		
		this.ticketId = ticketId;
	}
	
	public long getTicketId() {
		return this.ticketId;
	}
	
	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}
	
	public long getMatchId() {
		return this.matchId;
	}
	
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	public int getSeat() {
		return this.seat;
	}
	
	public String getbuyerName() {
		return buyer;
	}
	public void setbuyerName(String buyerName) {
		this.buyer = buyerName;
	}
	
}
