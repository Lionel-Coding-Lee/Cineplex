package Dao.Imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.BaseDao;
import Dao.MatchDao;
import Model.Film;
import Model.Match;

@Repository
public class MatchDaoImp implements MatchDao {

	@Autowired
	private BaseDao basedao;

	

	@Override
	public List<Match> getMatches() {
		// TODO Auto-generated method stub
		return basedao.getAllList(Model.Match.class);
	}
	
	@Override
	public List<Match> getMatchesByName(long filmNumber) {
		// TODO Auto-generated method stub
		List<Match> matches = basedao.getAllList(Model.Match.class);
		List<Match> temp = new ArrayList();
		for (Match match : matches) {
			if ((match.getFilmId() == filmNumber) && (match.getPass()))
				temp.add(match);
		}
		return temp;
	}


	@Override
	public List<Match> getMatchesByDate() {
		// TODO Auto-generated method stub

		Date now = new Date();		
		List<Match> list = new ArrayList<Match>();
		for (Match match : getMatches()) {
			if(match.getPass() && (match.getTime().getTime() >= now.getTime()))
				list.add(match);
		}
		return list;
	}

	@Override
	public List<Match> getWaitingMatches() {
		// TODO Auto-generated method stub
		List<Match> list = new ArrayList<Match>();
		for (Match match : getMatches()) {
			if(!match.getPass())
				list.add(match);
		}
		return list;
	}

	@Override
	public List<Match> getPassMatches() {
		// TODO Auto-generated method stub	
		List<Match> list = new ArrayList<Match>();
		for (Match match : getMatches()) {
			if(match.getPass())
				list.add(match);
		}
		return list;
	}

	@Override
	public void addMatch(Match match) {
		// TODO Auto-generated method stub
		long number = 1;
		List<Match> list = basedao.getAllList(Model.Match.class);
		for(Match temp : list) {
			if(temp.getMatchId() >= number) {
				number = temp.getMatchId() + 1;
			}
		}
		match.setMatchId(number);
		match.initSeat();
		System.out.println("dao"+number);
		basedao.save(match);
	}

	@Override
	public void setPass(String matchId) {
		// TODO Auto-generated method stub
		long id = Long.parseLong(matchId);
		List<Match> matches = basedao.getAllList(Model.Match.class);
		for (Match match : matches) {
			if ((match.getMatchId() == id) && (!match.getPass()))
			{
				match.setPass();
				basedao.update(match);
			}
		}
	}

	@Override
	public Match getMatchById(long matchId) {
		// TODO Auto-generated method stub
		List<Match> matches = basedao.getAllList(Model.Match.class);
		for (Match match : matches) {
			if ((match.getMatchId() == matchId))
				return match;
		}
		return null;
	}

	@Override
	public void addSeat(long matchId, int seat) {
		// TODO Auto-generated method stub
		Match m = getMatchById(matchId);
		m.addSeat(seat);
		basedao.update(m);
	}
}
