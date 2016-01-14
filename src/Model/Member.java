package Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="members")
public class Member implements Serializable{
	@Id
	private long id;
	private String name;
	private String password;
	private double rank;
	private int VIP;
	private boolean isFrozen;
	private double balance;
	private Date lastRecord;
	private Date birthday;
	private String phoneNumber;

	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Date getLastRecord() {
		return lastRecord;
	}
	
	public void setLastRecord(Date lastRecord) {
		this.lastRecord = lastRecord;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean getIsFrozen() {
		return isFrozen;
	}
	
	public void setIsForzen(boolean isFrozen) {
		this.isFrozen = isFrozen;
	}

	public int getVIP() {
		return VIP;
	}

	public void setVIP(int vip) {
		this.VIP = vip;
	}

	public double getRank() {
		return rank;
	}
	
	public void setRank(double rank) {
		this.rank = rank;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setIdByDate() {
		// TODO Auto-generated method stub
		Calendar datetime=Calendar.getInstance();
		this.id=datetime.getTimeInMillis();
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
}
