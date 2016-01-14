package Action.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Action.BaseAction;
import Model.Age;
import Model.Booking;
import Model.Film;
import Model.Match;
import Model.Member;
import Service.FilmManageService;
import Service.MatchManageService;
import Service.MemberManageService;

@Repository
public class StatisticAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private MemberManageService mbms;
	@Autowired
	private FilmManageService fms;
	@Autowired
	private MatchManageService mms;
	
	
	public String execute() throws ServletException,IOException {
		List<Member> memberList = mbms.getAll();
		List<Match> matchList = mms.getPassMatches();
		List<Film> filmList = fms.getFilmList();
		List<Age> ageList = new ArrayList<Age>();
		int[] tempAgeList = {0, 0, 0, 0, 0, 0};
		List<Booking> bookingList = new ArrayList<Booking>();
		
		for(Member m : memberList) {
			Date d = m.getBirthday();
			@SuppressWarnings("deprecation")
			int y = d.getYear();
			System.out.println(y);
			int yy = y/10;
			switch (yy) {
			case 5 : tempAgeList[0] = tempAgeList[0] + 1;
			break;
			case 6 : tempAgeList[1] = tempAgeList[1] + 1;
			break;
			case 7 : tempAgeList[2] = tempAgeList[2] + 1;
			break;
			case 8 : tempAgeList[3] = tempAgeList[3] + 1;
			break;
			case 9 : tempAgeList[4] = tempAgeList[4] + 1;
			break;
			case 0 : tempAgeList[5] = tempAgeList[5] + 1;
			break;
			}
		}
		
		{
			ageList.add(new Age("50后", tempAgeList[0]));
			ageList.add(new Age("60后", tempAgeList[1]));
			ageList.add(new Age("70后", tempAgeList[2]));
			ageList.add(new Age("80后", tempAgeList[3]));
			ageList.add(new Age("90后", tempAgeList[4]));
			ageList.add(new Age("00后", tempAgeList[5]));
		}
		
		for(Film f : filmList) {
			//bookingList.put(f.getFilmName(), 0);
			Booking b = new Booking(f.getFilmName(), 0);
			bookingList.add(b);
			System.out.println(b);
		}
		/*
		for (Match m : matchList) {
			Film f = fms.getFilmById(m.getFilmId());
			String name = f.getFilmName();
			int value = 0;
			Boolean[] seats = m.getSeats();
			for (boolean b : seats) {
				if (!b)
					value++;
			}
			int sum = value * Integer.parseInt(f.getPrice());
			Booking booking;
			for(Booking b : bookingList) {
				if (b.getName().equals(f.getFilmName())) {
					System.out.println(b.getName());
					booking = b;
					booking.add(sum);
					//bookingList.remove(b);
					bookingList.add(booking);
					booking = null;
				}
					
			}
			//bookingList.put(name, value);
		}
		*/
		
		request.setAttribute("ageList", ageList);
		request.setAttribute("matchList", matchList);
		request.setAttribute("filmList", filmList);
		request.setAttribute("bookingList", bookingList);
		
		return SUCCESS;
	}
}
