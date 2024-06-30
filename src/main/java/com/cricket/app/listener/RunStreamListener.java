package com.cricket.app.listener;

import com.cricket.app.Event;
import com.cricket.app.enums.ServiceErrorType;
import com.cricket.app.exceptions.ServiceException;
import com.cricket.app.model.MatchEvent;
import com.cricket.app.services.CricketMatchManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * The concrete class which implements to handle the runs event stream.
 */
public class RunStreamListener implements StreamListener {
    
    private static final Logger logger = LoggerFactory.getLogger(RunStreamListener.class);
    
    
    private CricketMatchManager matchManager;
    
    private ObjectMapper mapper = new ObjectMapper();
    
    public RunStreamListener(CricketMatchManager matchManager) {
        this.matchManager = matchManager;
    }
    
    @Override
    public void handle(Event event) throws ServiceException {
        
        try {
            MatchEvent matchEvent =
                    mapper.readValue(event.getMessage(), MatchEvent.class);
            matchManager.updateRuns(matchEvent);
        } catch (Exception ex) {
            throw new ServiceException(ServiceErrorType.MAPPER_ERROR);
        }
        
    }
}
