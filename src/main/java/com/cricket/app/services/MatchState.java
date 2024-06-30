package com.cricket.app.services;

import lombok.Data;

import java.util.Map;

@Data
public class MatchState {
    
    TeamState  battingTeam;
    TeamState  bowlingTeam;
}
