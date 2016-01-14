package Service;

import Model.Attendant;

public interface AttendantManageService {

	Attendant getMemberByName(String name);

	Attendant getAttendantByName(String name);

}
