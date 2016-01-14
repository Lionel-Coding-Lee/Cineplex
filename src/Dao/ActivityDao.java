package Dao;

import java.util.List;

import Model.Activity;

public interface ActivityDao {

	void addActivity(Activity activity);

	List<Activity> getList();

	void addMemToAct(long activityId, long memberId);

}
