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
public class ActivityAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	private AttendantManageService ams;
	@Autowired
	private ActivityManageService acms;
	public String execute() throws ServletException,IOException {
		List<Activity> activities = acms.getActivityList();
		request.setAttribute("activities", activities);
		return SUCCESS;
	}
}
