package com.cricket.app.services;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *  This class holds the Teams state at any point.
 */
@Data
public class TeamState {
    
    private int totalRuns = 0;
    private int totalWickets = 0;
    private String lastBall = "0.0";
    private String team;
    Map<String,BallState> perBallStats = new HashMap<>();
}
