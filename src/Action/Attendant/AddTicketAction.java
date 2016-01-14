package Action.Attendant;

import java.io.IOException;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Ticket;
import Service.AttendantManageService;
import Service.TicketManageService;
import Action.BaseAction;

@Repository
public class AddTicketAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Autowired
	private AttendantManageService ams;
	@Autowired
	private TicketManageService fms;
	@Autowired
	private Ticket Ticket;
	public String execute() throws ServletException,IOException {
		/*String Ticketname = request.getParameter("name");
		String price = request.getParameter("price");
		String type = request.getParameter("type");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date offline = null;
		try {
			offline = sdf.parse(request.getParameter("offline"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ticket.setTicketName(Ticketname);
		java.sql.Date sqloffline=new java.sql.Date(offline.getTime());
		Ticket.setOffline(sqloffline);
		Ticket.setPrice(price);
		Ticket.setType(type);
		System.out.println("action");
		fms.addTicket(Ticket);
		List<Ticket> Tickets = fms.getTicketList();
		request.setAttribute("Tickets", Tickets);
		*/
		return SUCCESS;
	}
}
