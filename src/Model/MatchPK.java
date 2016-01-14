package Model;

import java.io.Serializable;
import java.util.Date;

public class MatchPK implements Serializable{

	private long filmId;
	
	private int hallNum;
	
	private Date playTime;
	
	public void setFilmId(long id) {
		this.filmId = id;
	}
	
	public long getFilmId() {
		return this.filmId;
	}
}
