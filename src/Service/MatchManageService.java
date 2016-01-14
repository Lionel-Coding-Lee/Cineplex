package Service;

import java.util.List;

import Model.Match;

public interface MatchManageService {

	public List<Match> getMatchesByName(long filmNumber);

	public List<Match> getMatches();

	public List<Match> getMatchesByDate();

	public List<Match> getWaitingMatches();

	public List<Match> getPassMatches();

	public void addMatch(Match match);

	public void setPass(String matchId);

	public Match getMatchById(long matchId);

	public void addSeat(long matchId, int seat);
	
	
	

}
