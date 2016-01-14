package Action.Attendant;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Activity;
import Service.AttendantManageService;
import Service.ActivityManageService;
import Action.BaseAction;

@Repository
public class AddActivityAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Autowired
	private AttendantManageService ams;
	@Autowired
	private ActivityManageService acms;
	@Autowired
	private Activity activity;
	public String execute() throws ServletException,IOException {
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		activity.setName(name);
		activity.setContent(content);
		System.out.println(content);
		acms.addActivity(activity);
		
		List<Activity> activities = acms.getActivityList();
		request.setAttribute("activities", activities);
		return SUCCESS;
	}
}
