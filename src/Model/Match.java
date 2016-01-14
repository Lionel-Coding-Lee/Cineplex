package Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@IdClass(MatchPK.class)
@Table(name="matches")
public class Match implements Serializable{
	@Id
	private long filmId;
	@Id
	private int hallNum;
	@Id
	private Date playTime;
	
	private long matchId;

	private Boolean[] seats;
	
	private boolean pass;
	
	
	public void initSeat() {
		seats = new Boolean[10];
		for(int i = 0; i < 10 ;i++)
			seats[i] = true;
	}
	
	public void setPass() {
		pass = true;
	}
	
	public boolean getPass() {
		return this.pass;
	}
	
	public void setSeats() {
		seats = new Boolean[10];
		for(int i = 0; i < 10 ;i++)
			seats[i] = true;
	}
	
	public Boolean[] getSeats() {
		return seats;
	}
	
	public void addSeat(int num) {
		if (seats[num - 1])
			seats[num - 1] = false;
	}
	
	public void cancelSeat(int num) {
		if(!seats[num-1])
			seats[num-1] = true;
	}
	
	public void setHallNum(int hallNum) {
		this.hallNum = hallNum;
	}
	
	public long getHallNum() {
		return this.hallNum;
	}
	
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	
	public long getFilmId() {
		return this.filmId;
	}
	
	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}
	
	public long getMatchId() {
		return this.matchId;
	}
	
	public Date getTime() {
		return this.playTime;
	}
	
	public void setTime(Date time) {
		this.playTime = time;
	}
	
}
