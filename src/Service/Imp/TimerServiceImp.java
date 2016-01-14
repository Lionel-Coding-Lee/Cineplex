package Service.Imp;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.MemberDao;
import Service.TimerService;


@Repository
public class TimerServiceImp implements TimerService{
	
	Timer timer = new Timer();
	@Autowired
	MemberDao memberdao;
	
	@Override
	public void timeRun() {
		// TODO Auto-generated method stub
		timer.schedule(new TimerRun(), 7 * 3600 * 1000);
	}

	class TimerRun extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			memberdao.frozen();
		}
		
	}
}
