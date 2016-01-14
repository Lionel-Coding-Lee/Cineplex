package Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.ActivityDao;
import Model.Activity;
import Service.ActivityManageService;

@Repository
public class ActivityManageServiceImp implements ActivityManageService{
	@Autowired
	private ActivityDao ad;

	@Override
	public List<Activity> getActivityList() {
		// TODO Auto-generated method stub
		return ad.getList();
	}

	@Override
	public void addActivity(Activity activity) {
		// TODO Auto-generated method stub
		ad.addActivity(activity);
	}

	@Override
	public void addMemToAct(long activityId, long memberId) {
		// TODO Auto-generated method stub
		ad.addMemToAct(activityId, memberId);
	}

}
