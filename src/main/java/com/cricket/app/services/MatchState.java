package com.cricket.app.services;

import lombok.Data;

import java.util.Map;

/**
 * The match state which have both the batting and bowling teams states.
 */
@Data
public class MatchState {
    
    TeamState battingTeam;
    TeamState bowlingTeam;
}
