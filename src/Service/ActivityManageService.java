package Service;

import java.util.List;

import Model.Activity;

public interface ActivityManageService {

	List<Activity> getActivityList();

	void addActivity(Activity activity);
	
	void addMemToAct(long activityId, long memberId);
}
