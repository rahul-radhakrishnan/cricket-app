package com.cricket.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MatchEvent {
    
    String batting;
    String bowling;
    String ball;
    int run;
    boolean out;
}
