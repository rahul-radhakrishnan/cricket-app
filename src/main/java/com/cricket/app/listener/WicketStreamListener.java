package com.cricket.app.listener;

import com.cricket.app.Event;
import com.cricket.app.model.MatchEvent;
import com.cricket.app.services.CricketMatchManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class WicketStreamListener implements StreamListerner {
    
    private CricketMatchManager matchManager;
    
    private ObjectMapper mapper = new ObjectMapper();
    
    public WicketStreamListener(CricketMatchManager matchManager) {
        
        this.matchManager = matchManager;
    }
    
    @SneakyThrows
    @Override
    public void handle(Event event) {
    
        MatchEvent matchEvent =
                mapper.readValue(event.getMessage(),MatchEvent.class);
        matchManager.updateWicket(matchEvent);
        
    }
}
