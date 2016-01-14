package Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="managers")
public class Manager implements Serializable{

	@Id
	private String managerId;
	
	private String password;
	
	private String name;
	
	public void setManagerId(String managerId) {

		this.managerId = managerId;
	}

	public String getManagerId() {
		return this.managerId;
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
	
}
