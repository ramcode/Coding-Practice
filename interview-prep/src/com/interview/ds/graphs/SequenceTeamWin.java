package com.interview.ds.graphs;

import java.util.HashSet;
import java.util.Set;

public class SequenceTeamWin {

	public class MatchPair {
		public String teamA;
		public String teamB;
		public boolean result;

		public MatchPair(String teamA, String teamB, boolean result) {
			this.teamA = teamA;
			this.teamB = teamB;
			this.result = result;
		}
	}

	public boolean doesSequenceExist(String teamA, String teamB, MatchPair[] matches, Set<String> mems) {

		return getOpponent(teamA, teamB, matches, mems);

	}

	public boolean getOpponent(String mem, String opp, MatchPair[] matches, Set<String> mems) {
		if (opp == null || mems.contains(opp))
			return false;
		mems.add(mem);
		for (MatchPair match : matches) {
			if (getOpponent(match.teamB, opp, matches, mems))
				return true;
		}
		return false;

	}

	public static void main(String[] args) {
		SequenceTeamWin sq = new SequenceTeamWin();
		MatchPair[] matches = new MatchPair[5];
		MatchPair mp1 = sq.new MatchPair("A", "D", false);
		MatchPair mp2 = sq.new MatchPair("A", "C", true);
		MatchPair mp3 = sq.new MatchPair("B", "D", false);
		MatchPair mp4 = sq.new MatchPair("D", "C", false);
		MatchPair mp5 = sq.new MatchPair("B", "A", true);
		matches[0] = mp1;
		matches[1] = mp2;
		matches[2] = mp3;
		matches[3] = mp4;
		matches[4] = mp5;
		System.out.println(sq.doesSequenceExist("D", "B", matches, new HashSet<>()));

	}

}
