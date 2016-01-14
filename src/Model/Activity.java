package Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activities")
public class Activity implements Serializable{
	@Id
	private long activityId;
	
	private String name;
	
	private String content;
	
	private long[] list;
	
	private int number;
	
	public boolean hasMember(long memberId) {
		for(long id : list) {
			if(id==memberId)
				return true;
		}
		return false;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setActivityId(long activityId) {

		this.activityId = activityId;
	}

	public long getActivityId() {
		return this.activityId;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getNum() {
		return this.number;
	}
	
	public void initList() {
		number = 0;
		this.list = new long[10];
		for(long l : list) {
			l = 0;
		}
	}
	
	public void addMember(long memberId) {
		if(number < 10) {
			list[number] = memberId;
			number++;
		}
	}
}
