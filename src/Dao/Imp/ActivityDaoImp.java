package Dao.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.ActivityDao;
import Dao.BaseDao;
import Model.Activity;


@Repository
public class ActivityDaoImp implements ActivityDao{

	@Autowired
	private BaseDao basedao;
	@Autowired
	Activity temp;
	@Override
	public void addActivity(Activity activity) {
		// TODO Auto-generated method stub
		long number = 1;
		List<Activity> list = basedao.getAllList(Model.Activity.class);
		for(Activity temp : list) {
			if(temp.getActivityId() >= number)
				number = temp.getActivityId() + 1;
		}
		activity.setActivityId(number);
		activity.initList();
		System.out.println("dao"+number);
				
		basedao.save(activity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> getList() {
		// TODO Auto-generated method stub
		return basedao.getAllList(Model.Activity.class);
	}

	@Override
	public void addMemToAct(long activityId, long memberId) {
		// TODO Auto-generated method stub
		
		List<Activity> list = basedao.getAllList(Model.Activity.class);
		for(Activity temp : list) {
			if(temp.getActivityId() == activityId){
				temp.addMember(memberId);
				basedao.update(temp);
			}
				
			
		}
	}

}
