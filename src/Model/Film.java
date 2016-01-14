package Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="films")
public class Film implements Serializable{
	@Id
	private long filmNumber;
	private String filmName;
	private Date offline;
	private String type;
	private String price;
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}

	public String getFilmName() {
		// TODO Auto-generated method stub
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	
	public void setFilmNumber(long filmNumber) {
		this.filmNumber = filmNumber;
	}

	public long getFilmNumber() {
		return this.filmNumber;
	}
	
	public void setOffline(Date time) {
		this.offline = time;
	}
	
	public Date getOffline() {
		return offline;
	}
}
