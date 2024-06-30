package com.cricket.app.services;

import com.cricket.app.model.MatchEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CricketMatchManager {
    private static final Logger logger = LoggerFactory.getLogger(CricketMatchManager.class);
    
    
    MatchState state = new MatchState();
    
    public void updateRuns(MatchEvent matchEvent) {
        
        //Find current team state
        TeamState battingTeamState = getBattingTeamState(matchEvent);
        
        
        //Find current ball state for the ball inthe event
        Map<String, BallState> perBallStats = battingTeamState.getPerBallStats();
        //BallState ballState = perBallStats.getOrDefault(matchEvent.getBall(), new BallState());
        BallState ballState = perBallStats.get(matchEvent.getBall());
        
        if(ballState == null) {
            ballState = new BallState();
            //Update runs by removing any old entry. Helps in replay corrections
            int ballStateWithoutCurrentBall = battingTeamState.getTotalRuns() - ballState.getRun();
            battingTeamState.setTotalRuns(ballStateWithoutCurrentBall + matchEvent.getRun());
    
            perBallStats.put(matchEvent.getBall(), ballState);
        }
        updateLastBall(battingTeamState, matchEvent.getBall());
        
        displayScore(battingTeamState);
        
    }
    
    private TeamState getBattingTeamState(MatchEvent matchEvent) {
        TeamState battingTeamState = state.getBattingTeam();
        if (battingTeamState == null) {
            battingTeamState = new TeamState();
            battingTeamState.setTeam(matchEvent.getBatting());
            state.setBattingTeam(battingTeamState);
        }
        return battingTeamState;
    }
    
    
    public void updateWicket(MatchEvent matchEvent) {
        
        
        //Find current team state
        TeamState battingTeamState = getBattingTeamState(matchEvent);
        
        //Find current ball state for the ball inthe event
        Map<String, BallState> perBallStats = battingTeamState.getPerBallStats();
        BallState ballState = perBallStats.get(matchEvent.getBall());
        
        if (ballState == null) {
            ballState = new BallState();
            int wicketCountInBall = matchEvent.isOut() ? 1 : 0;
    
            //Update runs by removing any old entry. Helps in replay corrections
            int wicketStateWithoutCurrentBall = battingTeamState.getTotalWickets() - ballState.getWicket();
            battingTeamState.setTotalWickets(wicketStateWithoutCurrentBall + wicketCountInBall);
    
            perBallStats.put(matchEvent.getBall(), ballState);
        }
        updateLastBall(battingTeamState, matchEvent.getBall());
        
        displayScore(battingTeamState);
    }
    
    
    private void updateLastBall(TeamState teamState, String ball) {
        if (Double.parseDouble(ball) > Double.parseDouble(teamState.getLastBall())) {
            teamState.setLastBall(ball);
        }
    }
    
    
    public void displayScore(TeamState teamState) {
    
        /*logger.info("Overs " + teamState.getLastBall() + " " +
                                   teamState.getTeam() + " : " + teamState.getTotalRuns() + "/" +
                                   teamState.getTotalWickets());*/

        System.out.println(teamState.getTeam() + " is " + teamState.getTotalRuns() + "/" +
                                   teamState.getTotalWickets() + " after " + teamState.getLastBall());
        //teamX is 2/0 after 0.1 overs
        
    }
}
