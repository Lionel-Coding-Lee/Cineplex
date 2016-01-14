package Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Dao.MatchDao;
import Model.Match;
import Service.MatchManageService;


@Repository
public class MatchManageServiceImp implements MatchManageService{
	
	@Autowired
	private MatchDao matchdao;

	@Override
	public List<Match> getMatchesByName(long filmNumber) {
		// TODO Auto-generated method stub
		return matchdao.getMatchesByName(filmNumber);
	}

	@Override
	public List<Match> getMatches() {
		// TODO Auto-generated method stub
		return matchdao.getMatches();
	}

	@Override
	public List<Match> getMatchesByDate() {
		// TODO Auto-generated method stub
		return matchdao.getMatchesByDate();
	}

	@Override
	public List<Match> getWaitingMatches() {
		// TODO Auto-generated method stub
		return matchdao.getWaitingMatches();
	}

	@Override
	public List<Match> getPassMatches() {
		// TODO Auto-generated method stub
		return matchdao.getPassMatches();
	}

	@Override
	public void addMatch(Match match) {
		// TODO Auto-generated method stub
		matchdao.addMatch(match);
	}

	@Override
	public void setPass(String matchId) {
		// TODO Auto-generated method stub
		matchdao.setPass(matchId);
	}

	@Override
	public Match getMatchById(long matchId) {
		// TODO Auto-generated method stub
		return matchdao.getMatchById(matchId);
	}

	@Override
	public void addSeat(long matchId, int seat) {
		// TODO Auto-generated method stub
		matchdao.addSeat(matchId, seat);
	}

}
